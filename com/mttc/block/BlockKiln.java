package com.mttc.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.mttc.MTTCMod;
import com.mttc.lib.ModInfoLib;
import com.mttc.tileentity.TileKiln;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKiln extends BlockContainer {

	private IIcon frontFace;
	private TileKiln tileEntity;
	
	protected BlockKiln(String name, float hardness, float resistence, SoundType sound)
    {
        super(Material.rock);
        this.setBlockName(name);
		this.setHardness(hardness);
		this.setResistance(resistence);
		this.setStepSound(sound);
		this.setCreativeTab(MTTCMod.mttcTab);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		tileEntity = new TileKiln();
		return tileEntity;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileKiln tileEntity = (TileKiln) world.getTileEntity(x, y, z);
		boolean openGui = true;

		if (tileEntity == null || player.isSneaking()) {
			openGui = false;
		} 

		if (openGui) {
			player.openGui(MTTCMod.instance, 0, world, x, y, z);
			return true;
		} else {
			return true;
		}

	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.frontFace = iconRegister.registerIcon(ModInfoLib.MODID + ":ceramic");
		this.blockIcon = iconRegister.registerIcon(ModInfoLib.MODID + ":ceramicBrick");
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metaData)
    {
        return side == metaData ? this.frontFace : this.blockIcon;
    }
}
