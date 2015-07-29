package com.caveman.genetics.block;

import java.util.Arrays;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.caveman.genetics.item.ItemManager;
import com.caveman.genetics.tileentity.TileEntityDNAExtractor;
import com.caveman.genetics.tileentity.TileEntityPlant;

public class BlockPlant extends Block implements ITileEntityProvider{
	
	public TileEntityPlant plantEntity;

	protected BlockPlant(String unlocalizedName) {
		super(Material.wood);
		this.setBlockName(unlocalizedName);
	}
	
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityPlacedBy, ItemStack stack) {
		if(plantEntity != null) {
			plantEntity.setPlant(stack.getTagCompound());
			System.out.println("Entity is initialized");
		}else {
			System.out.println("didn't do it kirk");
		}
		
	}
	
    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
        p_149749_1_.removeTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);
    }

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		plantEntity = new TileEntityPlant();
		return plantEntity;
	}
}
