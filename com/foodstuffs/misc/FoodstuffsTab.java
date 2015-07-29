package com.foodstuffs.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.foodstuffs.item.ItemManager;


public class FoodstuffsTab extends CreativeTabs {
	private String label;
	
	public FoodstuffsTab(String label) {
	    super(label);
	    this.label = label;
	}
	@Override
	public Item getTabIconItem() {
		return ItemManager.sushi;
	}
}