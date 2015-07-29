package com.foodstuffs.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

import com.foodstuffs.item.ItemManager;


public class RiceCrop extends BlockCrops {
	public RiceCrop(String unlocalizedName) {
		super();
		this.setBlockName(unlocalizedName);
	}
	
	//Seeds that plant this block
	@Override
	protected Item func_149866_i() {
        return null;
    }
	
	//Crop item for this block
	@Override
    protected Item func_149865_P() {
        return null;
    }
}
