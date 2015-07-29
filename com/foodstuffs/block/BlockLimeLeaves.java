package com.foodstuffs.block;

import java.util.List;

import com.foodstuffs.FoodstuffsMod;
import com.foodstuffs.lib.ModInfoLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockLimeLeaves extends BlockLeaves {

	private int graphicsLevel;
	public static final String[] field_150131_O = new String[] { "lime" };

	public BlockLimeLeaves(String unlocalizedName) {
		super();
		this.setCreativeTab(FoodstuffsMod.foodTab);
		this.setBlockName(unlocalizedName);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.field_150129_M[this.graphicsLevel][0];

	}

	@SideOnly(Side.CLIENT)
	public void setGraphicsLevel(boolean p_150122_1_) {
		this.field_150121_P = p_150122_1_;
		this.graphicsLevel = p_150122_1_ ? 0 : 1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_,
			List p_149666_3_) {
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.field_150129_M[0] = new IIcon[1];
		this.field_150129_M[1] = new IIcon[1];

		this.field_150129_M[0][0] = p_149651_1_.registerIcon(ModInfoLib.MODID
				+ ":leaves_lime_empty");
		this.field_150129_M[1][0] = p_149651_1_.registerIcon(ModInfoLib.MODID
				+ ":leaves_lime_empty_opaque");
	}

	@Override
	public String[] func_150125_e() {
		return field_150131_O;
	}
}
