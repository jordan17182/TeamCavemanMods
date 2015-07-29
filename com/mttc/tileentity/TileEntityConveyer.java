package com.mttc.tileentity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityConveyer extends TileEntity implements IInventory {

	private ItemStack[] inventory = new ItemStack[10];
	private float[] itemPositions = new float[10];
	private float conveyerSpeed = 0.05f;
	private boolean isUpdated = false;
	private boolean isActive = true;
	
	public TileEntityConveyer() {
	}

	// writes entity info to nbt for a packet
	@Override
	public void writeToNBT(NBTTagCompound nbtCompound) {
		super.writeToNBT(nbtCompound);
		nbtCompound.setFloat("conveyerSpeed", conveyerSpeed);

		for (int h = 0; h < itemPositions.length; h++) {
			nbtCompound.setFloat("itemPosition_" + h, itemPositions[h]);
		}

		NBTTagList inventoryList = new NBTTagList();
		for (int i = 0; i < inventory.length; i++) {
			ItemStack slotStack = inventory[i];
			if (slotStack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				slotStack.writeToNBT(tag);
				inventoryList.appendTag(tag);
			}
		}
		nbtCompound.setTag("Inventory", inventoryList);
	}

	// Updates the entity from packet info
	@Override
	public void readFromNBT(NBTTagCompound nbtCompound) {
		super.readFromNBT(nbtCompound);
		this.conveyerSpeed = nbtCompound.getFloat("conveyerSpeed");

		for (int h = 0; h < itemPositions.length; h++) {
			itemPositions[h] = nbtCompound.getFloat("itemPosition_" + h);
		}

		for(int j = 0; j < inventory.length; j++) {
			inventory[j] = null;	
		}
		NBTTagList tagList = nbtCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inventory.length) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}

	}

	// Sends out packet about tile entity
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

	// Recieves a packet about the tile entity
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		NBTTagCompound tag = pkt.func_148857_g();
		readFromNBT(pkt.func_148857_g());
	}

	public static EntityItem getItemsInBounds(World world, double xCoord, double yCoord, double zCoord) {
		List list = world.selectEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1.0D, yCoord + 1.0D, zCoord + 1.0D), IEntitySelector.selectAnything);
		return list.size() > 0 ? (EntityItem) list.get(0) : null;
	}

	// Update the barrel entity
	@Override
	public void updateEntity() {

		if (this.worldObj != null && !this.worldObj.isRemote) {
			isUpdated = false;
			checkFunctioning();
			updateItemPositions();
			offloadItems();
			onloadItems();
			// check pickup item
			if (isUpdated) {
				this.sendUpdate();
			}
		}
	}

	private void checkFunctioning(){
		Block tempBlock = this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord);
		if(tempBlock != Blocks.air) {
			this.isActive = false;
			dropItems();
		} else {
			this.isActive = true;
		}
	}
	
	private void dropItems() {
		for(int i = 0; i < inventory.length; i++) {
			dropToEmptySide(i);
		}
	}
	
	private void dropToEmptySide(int inventorySlot) {
		if(inventory[inventorySlot] != null) {
			
		}
	}
	
	//private void check
	private void updateItemPositions() {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				Item tempItem = inventory[i].getItem();
				if (tempItem != null) {
					itemPositions[i] += conveyerSpeed;
					isUpdated = true;
				} else {
					inventory[i] = null;
					itemPositions[i] = 0;
					isUpdated = true;
				}
			}
		}
	}
    
	private void onloadItems() {
		EntityItem item = getItemsInBounds(this.getWorldObj(), this.xCoord, this.yCoord + 1.0D, this.zCoord);
		if(item != null) {
			boolean placed = false;
			int checked = 0;
			ItemStack stack = new ItemStack(item.getEntityItem().getItem(), 1, item.getEntityItem().getItemDamage());
			if(item.getEntityItem().hasTagCompound()) {
				stack.setTagCompound((NBTTagCompound)item.getEntityItem().getTagCompound().copy());
			}
			while(!placed && checked < inventory.length) {
				if(inventory[checked] == null) {
					this.setInventorySlotContents(checked, stack);
					this.itemPositions[checked] = 0;
					item.getEntityItem().stackSize -= 1;
					if(item.getEntityItem().stackSize <= 0) {
						item.setDead();
					}
					placed = true;
				}
				checked += 1;
			}
		}
	}

	
	
	private void offloadItems() {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				Item tempItem = inventory[i].getItem();
				
				if (tempItem != null && itemPositions[i] >= 1.0f) {
					int direction = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
					TileEntity tempTile;
					switch(direction) {
					case 0:
						tempTile = this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord);
							
					}
							
					//if (this.worldObj.getTileEntity(p_147438_1_, p_147438_2_, p_147438_3_)) {
					if(false){
					} else {
						// 0 -> -z, 1 -> +x, 2 -> +z, 3 -> -x
						float rx;
						float ry = 1.0f;
						float rz;

						switch (direction) {
						case 0:
							rx = 0.5f;
							rz = -0.2f;
							break;
						case 1:
							rx = 1.2f;
							rz = 0.5f;
							break;
						case 2:
							rx = 0.5f;
							rz = 1.2f;
							break;
						default:
							rx = -0.2f;
							rz = 0.5f;
							break;
						}
						;

						EntityItem entityItem = new EntityItem(this.worldObj, this.xCoord + rx, this.yCoord + ry, this.zCoord + rz, new ItemStack(inventory[i].getItem(), 1, inventory[i].getItemDamage()));
						if (inventory[i].hasTagCompound()) {
							entityItem.getEntityItem().setTagCompound(
									(NBTTagCompound) inventory[i]
											.getTagCompound().copy());
						}

						float factor = 0.1F;
						switch (direction) {
						case 0:
							entityItem.motionZ = -factor;
							break;
						case 1:
							entityItem.motionX = factor;
							break;
						case 2:
							entityItem.motionZ = factor;
							break;
						default:
							entityItem.motionX = -factor;
							break;
						};
						this.worldObj.spawnEntityInWorld(entityItem);
						setInventorySlotContents(i, null);
						itemPositions[i] = 0;
					}
					isUpdated = true;
				}
			}
		}
	}

	// Marks the block for a packet update to the server
	private void sendUpdate() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	// Returns the number of slots in the inventory
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	// Returns the stack in a particular slot of the inventory
	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}
	
	public float getSlotPosition(int i) {
		return itemPositions[i];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory[slot] = stack;
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
		return "mttc.tileentityconveyer";
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
