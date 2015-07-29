package com.mttc.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileKiln extends TileEntity implements IInventory {

	private ItemStack[] kilnSlots = new ItemStack[10]; //Slots in the kiln: 1 fuel slot, and 9 item firing slots
	private int[] fireProgress = new int[9]; //Firing progress of each slot in the kiln
	
	

	@Override
	public void updateEntity () {
		
	
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList var2 = par1NBTTagCompound.getTagList("Items", 9);
		this.kilnSlots = new ItemStack[this.getSizeInventory()];
		for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
			NBTTagCompound var4 = var2.getCompoundTagAt(var3);
			byte var5 = var4.getByte("Slot");
			if (var5 >= 0 && var5 < this.kilnSlots.length) {
				this.kilnSlots[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}

	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList var2 = new NBTTagList();
		for (int var3 = 0; var3 < this.kilnSlots.length; ++var3) {
			if (this.kilnSlots[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte) var3);
				this.kilnSlots[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}
		par1NBTTagCompound.setTag("Items", var2);
	}

	@Override
	public int getSizeInventory() {
		return kilnSlots.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slotNumber) {
		return kilnSlots[slotNumber];
	}

	@Override
	public ItemStack decrStackSize(int slotNumber, int decrQuantity) {
		ItemStack tempStack = getStackInSlot(slotNumber);
		if (tempStack != null) {
			if (tempStack.stackSize <= decrQuantity) {
				setInventorySlotContents(slotNumber, null);
			} else {
				tempStack = tempStack.splitStack(decrQuantity);
				if (tempStack.stackSize == 0) {
					setInventorySlotContents(slotNumber, null);
				}
			}
		}
		return tempStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		ItemStack stack = getStackInSlot(p_70304_1_);
		if (stack != null) {
			setInventorySlotContents(p_70304_1_, null);
		}

		return stack;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		kilnSlots[p_70299_1_] = p_70299_2_;

		if (p_70299_2_ != null
				&& p_70299_2_.stackSize > getInventoryStackLimit()) {
			p_70299_2_.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return "Kiln";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord,
				this.zCoord) != this ? false : p_70300_1_.getDistanceSq(
				(double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
				(double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
