package com.mttc.block;

import com.mttc.lib.ModInfoLib;
import com.mttc.MTTCMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class StructureBlock extends Block {

		private String textureName;
		
	protected StructureBlock(Material material, String name, float hardness, float resistence, SoundType sound) {
		super(material);
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
