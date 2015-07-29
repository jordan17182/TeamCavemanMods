package com.foodstuffs.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.foodstuffs.FoodstuffsMod;

public class FoodstuffsFood extends ItemFood {

	public FoodstuffsFood(int halfDrumsticks, float saturationModifier, boolean tameWolf, String unlocalizedName) {
		super(halfDrumsticks, saturationModifier, tameWolf);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(FoodstuffsMod.foodTab);
	}

	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
	    super.onFoodEaten(stack, world, player);
	    if(!world.isRemote) {
	        player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 100, 2));
	    }
	}
}
