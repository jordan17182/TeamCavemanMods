package com.caveman.genetics.tileentity;

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

import com.caveman.genetics.item.ItemManager;

public class TileEntityDNAExtractor extends TileEntity implements IInventory {

	private int itemProcessTime = 0;
	private int currentProcessTime = 0;
	private int maxBurnTime = 0;
	private int remainingBurnTime = 0;
	private boolean isProcessing = false;
	
	private ItemStack[] inv;

	public TileEntityDNAExtractor() {
		inv = new ItemStack[6];
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setInteger("itemProcessTime", itemProcessTime);
		par1.setInteger("currentProcessTime", currentProcessTime);
		par1.setInteger("maxBurnTime", maxBurnTime);
		par1.setInteger("remainingBurnTime", remainingBurnTime);
		par1.setBoolean("isProcessing", isProcessing);
		
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
		this.itemProcessTime = par1.getInteger("itemProcessTime");
		this.currentProcessTime = par1.getInteger("currentProcessTime");
		this.maxBurnTime = par1.getInteger("maxBurnTime");
		this.remainingBurnTime = par1.getInteger("remainingBurnTime");
		this.isProcessing = par1.getBoolean("isProcessing");
	}

	@Override
	public Packet getDescriptionPacket() {
		S35PacketUpdateTileEntity packet = (S35PacketUpdateTileEntity) super.getDescriptionPacket();
		NBTTagCompound tag = packet != null ? packet.func_148857_g() : new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 2, tag);
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
		boolean isUpdated = false;
		
		if(isUpdated) {
			this.sendUpdate();
		}
	}

	//Marks the block for a packet update to the server
	private void sendUpdate() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
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
		return "genetics.tileentitydnaextractor";
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
