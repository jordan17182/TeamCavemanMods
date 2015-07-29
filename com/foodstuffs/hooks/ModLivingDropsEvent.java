package com.foodstuffs.hooks;

import java.util.Random;

import net.minecraft.entity.passive.EntityPig;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import com.foodstuffs.item.ItemManager;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ModLivingDropsEvent {

	public static double rand;
	public Random r = new Random();

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		if (event.entityLiving instanceof EntityPig) {
			event.entityLiving.dropItem(ItemManager.baconRaw, r.nextInt(3));
		}
	}

}