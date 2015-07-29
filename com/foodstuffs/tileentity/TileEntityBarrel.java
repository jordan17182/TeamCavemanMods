package com.foodstuffs.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.Constants;

import com.foodstuffs.item.ItemManager;
import com.foodstuffs.misc.DrinkRegistry;

public class TileEntityBarrel extends TileEntity implements IInventory {

	private boolean hasFluid = false;
	private int fluidType = 0;
	private int fluidVolume = 0;
	private final int MAXFLUIDVOLUME = 8000;
	private ItemStack[] inv;

	private boolean canMix = false;
	private boolean isMixing = false;
	
	private int rainFillCounter = 0;
	private final int RAINFILLTIME = 10;
	
	public int rotation = 0;

	public TileEntityBarrel() {
		inv = new ItemStack[4];
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setBoolean("hasFluid", hasFluid);
		par1.setInteger("fluidType", fluidType);
		par1.setInteger("fluidVolume", fluidVolume);
		par1.setInteger("maxFluidVolume", MAXFLUIDVOLUME);
		par1.setBoolean("canMix", canMix);
		par1.setBoolean("isMixing", isMixing);
		par1.setInteger("rotation", rotation);
		
		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		par1.setTag("Inventory", itemList);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);

		NBTTagList tagList = par1.getTagList("Inventory",
				Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		this.hasFluid = par1.getBoolean("hasFluid");
		this.fluidType = par1.getInteger("fluidType");
		this.fluidVolume = par1.getInteger("fluidVolume");
		this.canMix = par1.getBoolean("canMix");
		this.isMixing = par1.getBoolean("isMixing");
		this.rotation = par1.getInteger("rotation");
	}

	@Override
	public Packet getDescriptionPacket() {
		S35PacketUpdateTileEntity packet = (S35PacketUpdateTileEntity) super
				.getDescriptionPacket();
		NBTTagCompound tag = packet != null ? packet.func_148857_g()
				: new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,
				this.zCoord, 2, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		NBTTagCompound tag = pkt.func_148857_g();
		readFromNBT(pkt.func_148857_g());
	}

	//Update the barrel entity
	@Override
	public void updateEntity() {
		
		rotation+=1;
		
		boolean isUpdated = false;
		BiomeGenBase biomegenbase = worldObj.getBiomeGenForCoords(this.xCoord, this.zCoord);

		if (worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord, this.zCoord) && worldObj.isRaining() && !biomegenbase.getEnableSnow()) {
			if (!this.hasFluid || (this.hasFluid && this.fluidType == 0 && this.fluidVolume < this.MAXFLUIDVOLUME)) {
				this.rainFillCounter += 1;
				isUpdated = true;
			}
			if (this.rainFillCounter >= this.RAINFILLTIME) {
				this.rainFillCounter = 0;
				this.hasFluid = true;
				this.fluidVolume += 1;
				this.fluidType = 0;
				isUpdated = true;
			}
		}
		if (this.fluidVolume == 0) {
			this.hasFluid = false;
			isUpdated = true;
		}
		if(isUpdated) {
			this.sendUpdate();
		}
	}

	//Marks the block for a packet update to the server
	private void sendUpdate() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	//Returns if the barrel has fluid
	public boolean isFilled() {
		return this.hasFluid;
	}
	
	//Returns if the barrel is currently mixing
	public boolean isMixing() {
		return this.isMixing;
	}
	
	//Sets the barrel to mixing
	public void setMixing() {
		this.isMixing = true;
		this.sendUpdate();
	}
	
	//Returns if the barrel can mix
	public boolean canMix() {
		boolean result = true;
		if(this.isMixing || this.fluidVolume < this.MAXFLUIDVOLUME) {
			result = false;
		} else if(!this.checkCrafting()) {
			
		}
		
		return result;
	}
	
	//Checks the current ingredients in the crafting grid
	public boolean checkCrafting() {
		return false;
	}
	
	//Returns the fluid volume
	public int getFluidVolume() {
		return this.fluidVolume;
	}

	//Returns the fluid type
	public int getFluidType() {
		return this.fluidType;
	}

	//Adds fluid to the barrel
	public boolean addFluidVolume(ItemStack item) {
		
		boolean result = false;
		if (DrinkRegistry.hasInput(item) && ((this.hasFluid && DrinkRegistry.getType(item) == this.fluidType) || !this.hasFluid)) {
			if (this.MAXFLUIDVOLUME - this.fluidVolume > 0) {
				this.fluidVolume += DrinkRegistry.getInputVolume(item);
				if (this.fluidVolume > this.MAXFLUIDVOLUME) {
					this.fluidVolume = this.MAXFLUIDVOLUME;
				}
				if (!this.hasFluid) {
					this.hasFluid = true;
					this.fluidType = DrinkRegistry.getType(item);
				}
				result = true;
			}
		}
		if(result) {
			this.sendUpdate();
		}
		return result;
	}

	//Removes fluid from the barrel
	public boolean removeFluidVolume(ItemStack item) {
		boolean result = false;
		if (item.getItem().equals(Items.bucket)) {
			if (this.hasFluid
					&& this.fluidVolume >= DrinkRegistry.getBucketVolume()) {
				this.fluidVolume -= DrinkRegistry.getBucketVolume();
				result = true;
			}
		} else if (item.getItem().equals(ItemManager.drinkingGlass)) {
			if (this.hasFluid
					&& this.fluidVolume >= DrinkRegistry.getCupVolume()) {
				this.fluidVolume -= DrinkRegistry.getCupVolume();
				result = true;
			}
		}
		if(result) {
			this.sendUpdate();
		}
		return result;
	}

	//Returns the output item for adding fluid to the barrel
	public ItemStack getInputReturn(ItemStack item) {
		return new ItemStack(DrinkRegistry.getInputReturn(item), 1);
	}

	//Returns the output item for removing fluid from the barrel
	public ItemStack getOutputReturn(ItemStack item) {
		ItemStack tempStack = null;
		if (item.getItem().equals(Items.bucket)
				&& DrinkRegistry.hasBucketOutput(this.fluidType)) {
			tempStack = DrinkRegistry.getBucketReturn(this.fluidType);
		} else if (item.getItem().equals(ItemManager.drinkingGlass)
				&& DrinkRegistry.hasCupOutput(this.fluidType)) {
			tempStack = DrinkRegistry.getCupReturn(this.fluidType);
		}
		return tempStack;
	}

	//Gets the maximum volume for the barrel
	public int getMaxVolume() {
		return MAXFLUIDVOLUME;
	}
	
	//Returns the number of slots in the inventory
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	//Returns the stack in a particular slot of the inventory
	@Override
	public ItemStack getStackInSlot(int i) {
		return inv[i];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		this.sendUpdate();
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amt) {
				setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(amt);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
			this.sendUpdate();
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
			this.sendUpdate();
		}
		return stack;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this
				&& player.getDistanceSq(xCoord + 0.5, yCoord + 0.5,
						zCoord + 0.5) < 64;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	@Override
	public String getInventoryName() {
		return "foodstuffs.tileentitybarrel";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}
}
