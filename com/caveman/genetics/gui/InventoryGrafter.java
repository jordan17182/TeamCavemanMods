package com.caveman.genetics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.caveman.genetics.item.ItemManager;

public class InventoryGrafter extends InventoryBasic {
    ItemStack grafter = null;
    final static int normalSlots = 3;
    int activeVariations = 0;
    ContainerGrafter container;
    

    
	public InventoryGrafter(ItemStack grafter) {
		super("Grafter", true, normalSlots);
		this.grafter = grafter;
	}
	
    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return true;
    }

    public void clearItems() {
        activeVariations = 0;
        for (int i = 0; i < normalSlots; i++) {
        	this.setInventorySlotContents(i, null);
        }
    }

    public ItemStack getStackInSpecialSlot() {
        return this.getStackInSlot(normalSlots);
    }

    public void updateItems() {
        ItemStack temp0 = this.getStackInSlot(0);
        ItemStack temp1 = this.getStackInSlot(1);
        
        if(temp0 != null && temp1 != null && temp0.getItem().equals(ItemManager.dnaSample) && temp1.getItem().equals(ItemManager.dnaSample)) {
        	ItemStack resultStack = new ItemStack(ItemManager.dnaSample);
        	resultStack.stackTagCompound = generateTraits(temp0, temp1);
        	this.setInventorySlotContents(2, resultStack);
        	System.out.println("set contents");
        } else {
        	if(this.getStackInSlot(2) != null) {
        		this.setInventorySlotContents(2, null);
        	}
        }
        
    }

    private NBTTagCompound generateTraits(ItemStack plant0, ItemStack plant1) {
    	//NBTTagCompound result = new NBTTagCompound();
    	
    	
    	return plant0.stackTagCompound;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        return null;
    }


    @Override
    public boolean isItemValidForSlot(int i, ItemStack stack) {
        return true;
    }
}
