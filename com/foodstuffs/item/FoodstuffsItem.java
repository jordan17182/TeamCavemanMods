package com.foodstuffs.item;

import net.minecraft.item.Item;

import com.foodstuffs.FoodstuffsMod;

public class FoodstuffsItem extends Item {
	
	public FoodstuffsItem(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(FoodstuffsMod.foodTab);
	}
	
}
