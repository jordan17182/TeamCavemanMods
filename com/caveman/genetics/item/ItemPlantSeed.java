package com.caveman.genetics.item;

import io.netty.buffer.Unpooled;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.caveman.genetics.GeneticsMod;
import com.caveman.genetics.lib.ModInfoLib;
import com.caveman.genetics.tileentity.PlantEnums.BreakType;
import com.caveman.genetics.tileentity.PlantEnums.CropType;
import com.caveman.genetics.tileentity.PlantEnums.Deffence;
import com.caveman.genetics.tileentity.PlantEnums.Harvestability;
import com.caveman.genetics.tileentity.PlantEnums.PlantOrientation;
import com.caveman.genetics.tileentity.PlantEnums.Planting;
import com.caveman.genetics.tileentity.PlantEnums.SeedType;
import com.caveman.genetics.tileentity.PlantEnums.Spread;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPlantSeed extends Item {

	private Block blockToPlace;

	private String traitType = "";
	private String trait = "Unknown";

	@SideOnly(Side.CLIENT)
	private IIcon contents;
	private IIcon[][] saplings;

	public ItemPlantSeed(String unlocalizedName, Block plant) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(GeneticsMod.genTab);
		this.maxStackSize = 16;
		blockToPlace = plant;
	}

	@Override 
	public IIcon getIcon(ItemStack stack, int pass)
    {
        /**
         * Gets an icon index based on an item's damage value and the given render pass
         */
        return getIconIndex(stack);
    }
	
	@Override
	public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
		return par2 == 0 ? this.contents : this.itemIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		if (stack.stackTagCompound != null && stack.stackTagCompound.getString("seedType").equals("Sappling")) {
			return this.saplings[0][0];
		} else {
			return this.itemIcon;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int p_77617_1_) {
		// this.
		return this.contents;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromDamage(int par1) {
		return 10880775;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
		return renderPass > 0 ? 16777215 : this.getColorFromDamage(itemStack
				.getItemDamage());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean requiresMultipleRenderPasses() {
		return false;
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		System.out.println("Datad...");
		// generateDNATrait();
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setString("seedType",
				SeedType.Sappling.toString());
		itemStack.stackTagCompound.setString("cropType",
				CropType.None.toString());
		itemStack.stackTagCompound.setString("harvest",
				Harvestability.All.toString());
		itemStack.stackTagCompound.setFloat("growthSpeed", 4.5f);
		itemStack.stackTagCompound.setString("spread", Spread.None.toString());
		itemStack.stackTagCompound.setBoolean("canFertalize", false);
		itemStack.stackTagCompound.setString("planting",
				Planting.Sand.toString());
		itemStack.stackTagCompound.setString("breakType",
				BreakType.None.toString());
		itemStack.stackTagCompound.setInteger("lightMin", 0);
		itemStack.stackTagCompound.setInteger("lightMax", 15);
		itemStack.stackTagCompound.setString("plantOrient",
				PlantOrientation.Above.toString());
		itemStack.stackTagCompound.setString("deffence",
				Deffence.None.toString());
		itemStack.stackTagCompound.setBoolean("discovered", false);
	}

	private void generateDNATrait() {
		Random rand = new Random();
		switch (rand.nextInt(5)) {
		case 0:
			traitType = "Leaf Color";
			trait = "Green";
			break;
		case 1:
			traitType = "Fruit Color";
			trait = "Red";
			break;
		case 2:
			traitType = "Fruit Color";
			trait = "Orange";
			break;
		case 3:
			traitType = "Form";
			trait = "Apple";
			break;
		case 4:
			traitType = "Plant Type";
			trait = "Reed";
			break;
		}
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound == null) {
			itemStack.stackTagCompound = itemStack
					.writeToNBT(new NBTTagCompound());
			// onCreated(itemStack, player.worldObj, player);
		}
		if (itemStack.stackTagCompound != null
				&& !itemStack.stackTagCompound.getBoolean("discovered")) {
			String tT = itemStack.stackTagCompound.getString("seedType");
			String t = itemStack.stackTagCompound.getString("cropType");
			list.add(EnumChatFormatting.GOLD + "Seed Type: "
					+ EnumChatFormatting.GREEN + tT);
			list.add(EnumChatFormatting.GOLD + "Crop Type: "
					+ EnumChatFormatting.GREEN + t);
		} else {
			list.add(EnumChatFormatting.GOLD + "Seed Type: "
					+ EnumChatFormatting.RED + "Unknown");
			list.add(EnumChatFormatting.GOLD + "Crop Type: "
					+ EnumChatFormatting.RED + "Unknown");
		}

	}

	public boolean onItemUse(ItemStack equippedStack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
		Block block = world.getBlock(x, y, z);

		if (block == Blocks.snow_layer
				&& (world.getBlockMetadata(x, y, z) & 7) < 1) {
			side = 1;
		} else if (block != Blocks.vine && block != Blocks.tallgrass
				&& block != Blocks.deadbush) {
			if (side == 0) {
				--y;
			}

			if (side == 1) {
				++y;
			}

			if (side == 2) {
				--z;
			}

			if (side == 3) {
				++z;
			}

			if (side == 4) {
				--x;
			}

			if (side == 5) {
				++x;
			}
		}

		if (!player.canPlayerEdit(x, y, z, side, equippedStack)) {
			return false;
		} else if (equippedStack.stackSize == 0) {
			return false;
		} else {
			if (world.canPlaceEntityOnSide(this.blockToPlace, x, y, z, false,
					side, (Entity) null, equippedStack)) {
				int i1 = this.blockToPlace.onBlockPlaced(world, x, y, z, side,
						hitX, hitY, hitZ, 0);

				if (world.setBlock(x, y, z, this.blockToPlace, i1, 3)) {
					if (world.getBlock(x, y, z) == this.blockToPlace) {
						this.blockToPlace.onBlockPlacedBy(world, x, y, z,
								player, equippedStack);
						this.blockToPlace.onPostBlockPlaced(world, x, y, z, i1);
					}

					world.playSoundEffect(
							(double) ((float) x + 0.5F),
							(double) ((float) y + 0.5F),
							(double) ((float) z + 0.5F),
							this.blockToPlace.stepSound.func_150496_b(),
							(this.blockToPlace.stepSound.getVolume() + 1.0F) / 2.0F,
							this.blockToPlace.stepSound.getPitch() * 0.8F);
					--equippedStack.stackSize;
				}
			}

			return true;
		}
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.saplings = new IIcon[1][6];
		this.saplings[0][0] = iconRegister.registerIcon(ModInfoLib.MODID
				+ ":OOSapling");
		this.saplings[0][1] = iconRegister.registerIcon(ModInfoLib.MODID
				+ ":OBSapling");
		this.saplings[0][2] = iconRegister.registerIcon(ModInfoLib.MODID
				+ ":OASapling");

		this.itemIcon = iconRegister.registerIcon(ModInfoLib.MODID
				+ ":dnaSample");
		this.contents = iconRegister.registerIcon(ModInfoLib.MODID
				+ ":dnaSampleFill");
	}
}
