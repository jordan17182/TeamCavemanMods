package com.mttc.block;

import java.util.Random;

import com.mttc.MTTCMod;
import com.mttc.lib.ModInfoLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockOre;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockMTTCOre extends BlockOre {

	
	public BlockMTTCOre(String name, float hardness, float resistence, SoundType sound)
    {
        super();
        this.setBlockName(name);
		this.setHardness(hardness);
		this.setResistance(resistence);
		this.setStepSound(sound);
		this.setCreativeTab(MTTCMod.mttcTab);

		textureName = name;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(ModInfoLib.MODID + ":" + textureName);
	}
}
