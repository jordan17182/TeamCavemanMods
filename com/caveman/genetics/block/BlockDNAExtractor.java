package com.caveman.genetics.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.caveman.genetics.GeneticsMod;
import com.caveman.genetics.item.ItemManager;
import com.caveman.genetics.lib.ModInfoLib;
import com.caveman.genetics.tileentity.TileEntityDNAExtractor;

public class BlockDNAExtractor extends BlockContainer {

	public TileEntityDNAExtractor extractorEntity;

	
	protected BlockDNAExtractor(String name) {
		super(Material.rock);
		this.setBlockName(name);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundTypeStone);
		this.setBlockTextureName(ModInfoLib.MODID+ ":extractorFront");
	}


	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntityDNAExtractor tileEntity = (TileEntityDNAExtractor) world.getTileEntity(x, y, z);
		boolean openGui = true;

		if (tileEntity == null || player.isSneaking()) {
			openGui = false;
		}/** else {
			ItemStack itemstack = player.inventory.getCurrentItem();

			if (itemstack != null) {
				if (tileEntity.addFluidVolume(itemstack)) {
					player.inventory.setInventorySlotContents(
							player.inventory.currentItem,
							tileEntity.getInputReturn(itemstack));
					openGui = false;
				} else if (tileEntity.removeFluidVolume(itemstack)) {
					ItemStack tempStack = itemstack.copy();
					--itemstack.stackSize;
					if (itemstack.stackSize <= 0) {
						itemstack = null;
						player.inventory.markDirty();
					}
					if (!player.inventory.addItemStackToInventory(tileEntity
							.getOutputReturn(tempStack))) {
						player.dropPlayerItemWithRandomChoice(tileEntity.getOutputReturn(tempStack),false);
					}
					openGui = false;
				}
			}
		}**/
		if (openGui) {
			player.openGui(GeneticsMod.instance, 0, world, x, y, z);
			return true;
		} else {
			return true;
		}

	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return ItemManager.dnaSample;
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

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		extractorEntity = new TileEntityDNAExtractor();
		return extractorEntity;
	}
}
