package com.caveman.genetics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotGraftingResult extends Slot {
	private ContainerGrafter container;
    private InventoryGrafter selInventory;
    
    public SlotGraftingResult(ContainerGrafter container, InventoryGrafter inv, int i, int j, int k) {
        super(inv, i, j, k);

        this.container = container;
        selInventory = inv;
    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack) {
        return par1ItemStack.getItem().equals(Items.arrow);
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemstack) {
        super.onPickupFromSlot(player, itemstack);
    	container.itemTaken();
    }




    
}
