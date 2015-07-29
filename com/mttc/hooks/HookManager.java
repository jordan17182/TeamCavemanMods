package com.mttc.hooks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.foodstuffs.FoodstuffsMod;
import com.foodstuffs.item.ItemManager;

public class HookManager {
	public static void mainRegistry() {
        seedHooks();
        vanillaDropHooks();
    }
	public static void seedHooks() {
		//if(FoodstuffsMod.createRice) {
			//MinecraftForge.addGrassSeed(new ItemStack(ItemManager.rice), 8);
		//}
	}
	public static void vanillaDropHooks() {
		//MinecraftForge.EVENT_BUS.register(new ModLivingDropsEvent());
	}
}
