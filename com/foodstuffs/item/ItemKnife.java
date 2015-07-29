package com.foodstuffs.item;

import com.foodstuffs.FoodstuffsMod;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemKnife extends ItemSword {

	public ItemKnife(ToolMaterial knifeMaterial, String unlocalizedName) {
		super(knifeMaterial);
		this.setContainerItem(this);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(FoodstuffsMod.foodTab);
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack inputItemStack)
    {
        if (!hasContainerItem(inputItemStack))
        {
            return null;
        }
        ItemStack returnStack = new ItemStack(getContainerItem());
        returnStack.setItemDamage(this.getDamage(inputItemStack)+1);
        return returnStack;
    }
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return false;
    }
}
