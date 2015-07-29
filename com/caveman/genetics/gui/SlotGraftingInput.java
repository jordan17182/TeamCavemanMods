package com.caveman.genetics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGraftingInput extends Slot {
	
    ContainerGrafter container;
    InventoryGrafter selInventory;
	
    public SlotGraftingInput(ContainerGrafter container, InventoryGrafter inv, int i, int j, int k) {
        super(inv, i, j, k);
        selInventory = inv;
        this.container = container;
    }

    @Override
    public boolean isItemValid(ItemStack itemstack) {
        if (container.finished) return false;

        return super.isItemValid(itemstack);
    }

    @Override
    public boolean canTakeStack(EntityPlayer par1EntityPlayer) {
        if (container.finished) return false;

        return super.canTakeStack(par1EntityPlayer);
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();
        selInventory.updateItems();
    }


}
