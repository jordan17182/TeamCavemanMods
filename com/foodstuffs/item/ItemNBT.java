package com.foodstuffs.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.foodstuffs.FoodstuffsMod;

public class ItemNBT extends Item {
	public ItemNBT(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(FoodstuffsMod.foodTab);
		this.maxStackSize = 1;
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setString("owner", player.PERSISTED_NBT_TAG);
		itemStack.stackTagCompound.setInteger("code",
				(int) (Math.random() * Integer.MAX_VALUE));
	}

	public void addInformation(ItemStack itemStack, EntityPlayer player,
			List list, boolean par4) {
		if (itemStack.stackTagCompound != null) {
			String owner = itemStack.stackTagCompound.getString("owner");
			int code = itemStack.stackTagCompound.getInteger("code");
			list.add("owner: " + owner);
			if (owner.equals(player.PERSISTED_NBT_TAG)) {
				list.add(EnumChatFormatting.GREEN + "code: " + code);
			} else {
				list.add(EnumChatFormatting.RED + "code: "
						+ EnumChatFormatting.OBFUSCATED + code);
			}
		}
	}
}
