package com.foodstuffs.block;

import com.foodstuffs.FoodstuffsMod;
import com.foodstuffs.lib.ModInfoLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockLimeLog extends BlockLog {

	public BlockLimeLog(String unlocalizedName) {
		super();
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(FoodstuffsMod.foodTab);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
		//Side Texture
        this.field_150167_a = new IIcon[1];
        //Top Texture
        this.field_150166_b = new IIcon[1];

        for (int i = 0; i < this.field_150167_a.length; ++i)
        {
            this.field_150167_a[i] = p_149651_1_.registerIcon(ModInfoLib.MODID + ":tree_lime_side");
            this.field_150166_b[i] = p_149651_1_.registerIcon(ModInfoLib.MODID + ":tree_lime_top");
        }
    }
}
