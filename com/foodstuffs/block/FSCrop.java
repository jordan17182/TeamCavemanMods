package com.foodstuffs.block;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import net.minecraft.block.BlockCrops;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.foodstuffs.item.ItemManager;
import com.foodstuffs.misc.CropRegistry;


public class FSCrop extends BlockCrops {
	
	public FSCrop(String unlocalizedName) {
		super();
		this.setBlockName(unlocalizedName);
	}
	
	@Override
	public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
    {
		super.onBlockPlaced(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_, p_149660_5_, p_149660_6_, p_149660_7_, p_149660_8_, p_149660_9_);
		System.out.println(p_149660_1_.getBlockMetadata(p_149660_2_, p_149660_3_, p_149660_4_));
        return p_149660_9_;
    }
	
	//Seeds that plant this block
	@Override
	protected Item func_149866_i() {
		return CropRegistry.getSeed(this);
    }
	
	//Crop item for this block
	@Override
    protected Item func_149865_P() {
		return CropRegistry.getCrop(this);
    }
}
