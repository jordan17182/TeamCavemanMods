package com.caveman.genetics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerGrafter extends Container {
    public final InventoryGrafter inventory;
    private InventoryPlayer playerInventory;
    private int currentIndex;
    private ItemStack grafter;
    public boolean finished;

	public ContainerGrafter(InventoryPlayer playerInv, InventoryGrafter graftInv) {
		this.inventory = graftInv;
		this.playerInventory = playerInv;
		currentIndex = playerInventory.currentItem;
		graftInv.container = this;
	
        grafter = playerInventory.getCurrentItem();

        for (int k = 0; k < 3; k++) {
            for (int j1 = 0; j1 < 9; j1++) {
                addSlotToContainer(new Slot(playerInventory, j1 + k * 9 + 9, 8 + j1 * 18, 102 + k * 18 - 18));
            }
        }

        for (int l = 0; l < 9; l++) {
            addSlotToContainer(l == currentIndex ?
                    new SlotGrafterPlayer(this, playerInventory, l, 8 + l * 18, 160 - 18) :
                    new Slot(playerInventory, l, 8 + l * 18, 160 - 18)
            );
        }
        
        addSlotToContainer(new SlotGraftingInput(this, inventory, 0, 56, 17));
        addSlotToContainer(new SlotGraftingInput(this, inventory, 1, 56, 53));
        addSlotToContainer(new SlotGraftingResult(this, inventory, 2, 116, 35));


       // if (chisel.stackTagCompound != null) {
         //   ItemStack stack = ItemStack.loadItemStackFromNBT(chisel.stackTagCompound.getCompoundTag("chiselTarget"));
           // inventory.setInventorySlotContents(InventoryChiselSelection.normalSlots, stack);
        //}

        inventory.updateItems();
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer par4EntityPlayer) {
        if (par3 == 2 && par2 == currentIndex)
            return null;
        System.out.println(par1);
        return super.slotClick(par1, par2, par3, par4EntityPlayer);
    }

    @Override
    public void onContainerClosed(EntityPlayer entityplayer) {
        inventory.clearItems();
        super.onContainerClosed(entityplayer);
    }

    public void itemTaken() {
    	inventory.setInventorySlotContents(0, null);
    	inventory.setInventorySlotContents(1, null);
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return inventory.isUseableByPlayer(entityplayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entity, int i) {
        return null;
    }
}
