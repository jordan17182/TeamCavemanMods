package com.mttc.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.mttc.tileentity.TileKiln;

public class BlockKilnContainer extends Container {

        protected TileKiln tileEntity;

        public BlockKilnContainer (InventoryPlayer inventoryPlayer, TileKiln te){
                tileEntity = te;

                //the Slot constructor takes the IInventory and the slot number in that it binds to
                //and the x-y coordinates it resides on-screen
                for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < 10; j++) {
                                addSlotToContainer(new Slot(tileEntity, j + i * 2, 39 + j * 18, 32 + i * 18));
                        }
                }
                
                //commonly used vanilla code that adds the player's inventory
                bindPlayerInventory(inventoryPlayer);
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return tileEntity.isUseableByPlayer(player);
        }

        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                        }
                }

                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
                }
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
                ItemStack stack = null;
                Slot slotObject = (Slot) this.inventorySlots.get(slot);

                //null checks and checks if the item can be stacked (maxStackSize > 1)
                if (slotObject != null && slotObject.getHasStack()) {
                        ItemStack stackInSlot = slotObject.getStack();
                        stack = stackInSlot.copy();

                        //merges the item into player inventory since its in the tileEntity
                        if (slot < 8) {
                                if (!this.mergeItemStack(stackInSlot, 8, this.inventorySlots.size(), true)) {
                                        return null;
                                }
                        }
                        //places it into the tileEntity is possible since its in the player inventory
                        else if (!this.mergeItemStack(stackInSlot, 0, 8, false)) {
                                return null;
                        }

                        if (stackInSlot.stackSize == 0) {
                                slotObject.putStack((ItemStack)null);
                        } else {
                                slotObject.onSlotChanged();
                        }
                }
                return stack;
        }
}