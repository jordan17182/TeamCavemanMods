package com.foodstuffs.misc;

import net.minecraftforge.oredict.OreDictionary;

import com.foodstuffs.FoodstuffsMod;

public class ConflictManager {

	public static void mainRegistry() {
		checkDictionary();
	}
	
	public static void checkDictionary() {
		//FoodstuffsMod.createRice = OreDictionary.getOres("cropRice").isEmpty();
	}

}
