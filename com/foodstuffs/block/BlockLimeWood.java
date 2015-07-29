package com.foodstuffs.block;

import java.util.List;

import com.foodstuffs.FoodstuffsMod;
import com.foodstuffs.lib.ModInfoLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockLimeWood extends BlockWood {

	private IIcon blockTexture;

	public BlockLimeWood(String unlocalizedName) {
		super();
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(FoodstuffsMod.foodTab);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return blockTexture;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item currentBlock, CreativeTabs creativeTab,
			List subBlockList) {
		subBlockList.add(new ItemStack(currentBlock, 1, 0));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockTexture = iconRegister.registerIcon(ModInfoLib.MODID
				+ ":tree_lime_side");
	}

}
