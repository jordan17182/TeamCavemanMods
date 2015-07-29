package com.mttc.block;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.mttc.MTTCMod;
import com.mttc.item.ItemManager;
import com.mttc.lib.ModInfoLib;
import com.mttc.tileentity.TileEntityConveyer;

public class BlockConveyer extends BlockContainer {

	public TileEntityConveyer conveyerEntity;

	public BlockConveyer(String unlocalizedName) {
		super(Material.wood);
		this.setBlockName(unlocalizedName);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundTypeWood);
		this.setBlockTextureName(ModInfoLib.MODID+ ":barrel");
		this.setCreativeTab(MTTCMod.mttcTab);
		//this.setBlockBounds(p_149676_1_, p_149676_2_, p_149676_3_, p_149676_4_, p_149676_5_, p_149676_6_);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,int p_149650_3_) {
		return null;
	}

	private void dropItems(World world, int x, int y, int z) {
		Random rand = new Random();

		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (!(tileEntity instanceof IInventory)) {
			return;
		}
		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z
						+ rz, new ItemStack(item.getItem(), item.stackSize,
						item.getItemDamage()));

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound(
							(NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return false;
	}

	// And this tell it that you can see through this block, and neighbor blocks
	// should be rendered.
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		//ItemStack stack = new ItemStack(this);
		//OreDictionary.registerOre("barrelBlock", stack);
		//ThaumcraftApi.objectTags.put(Arrays.asList(stack.getItem(),0),  new AspectList().add(Aspect.FIRE, 6).add(Aspect.CRYSTAL, 2));

		conveyerEntity = new TileEntityConveyer();
		return conveyerEntity;
	}
}
