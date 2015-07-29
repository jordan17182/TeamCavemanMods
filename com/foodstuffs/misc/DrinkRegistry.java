package com.foodstuffs.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.foodstuffs.crafting.RecipeManager;
import com.foodstuffs.item.ItemManager;

public class DrinkRegistry {

	
	private static Map<Integer, String> fluidName = new HashMap<Integer, String>();
	private static Map<Integer, Integer> fluidColor = new HashMap<Integer, Integer>();
	private static Map<Integer, Boolean> fluidTranslucent = new HashMap<Integer, Boolean>();
	
	private static Map<Item, Integer> specialInput = new HashMap<Item, Integer>();
	private static Map<Integer, Item> specialBucketOutput = new HashMap<Integer, Item>();

	private static final int BUCKETVOLUME = 1000;
	private static final int CUPVOLUME = 100;

	private static List drinkingGlassList = new ArrayList();
	private static List bucketList = new ArrayList();

	public DrinkRegistry() {
	}
	
	public static void addFluid(String name, int type, int color, boolean opaque) {
		fluidName.put(Integer.valueOf(type), name);
		fluidColor.put(Integer.valueOf(type), Integer.valueOf(color));
		fluidTranslucent.put(Integer.valueOf(type), opaque);
		
		drinkingGlassList.add(new ItemStack(ItemManager.drinkingGlassFluid, 1, type));
		bucketList.add(new ItemStack(ItemManager.bucketFluid, 1, type));
		new ItemStack(ItemManager.drinkingGlassFluid, 1, 1);
	}
	
	public static void addFluid(String name, int type, int color, boolean opaque, ArrayList<ItemStack> ing) {
		addFluid(name, type, color, opaque);
		RecipeManager.addDrinkRecipe(type, ing);
	}
	
	public static void addFluid(String name, Item bucketItem, int type, int color, boolean opaque) {
		addFluid(name, type, color, opaque);
		specialInput.put(bucketItem, Integer.valueOf(type));
		specialBucketOutput.put(Integer.valueOf(type), bucketItem);
	}
	
	public static void addFluid(String name, Item bucketItem, int type, int color, boolean opaque, ArrayList<ItemStack> ing) {
		addFluid(name, bucketItem, type, color, opaque);
		RecipeManager.addDrinkRecipe(type, ing);
	}
	
	
	public static List getCupList() {
		return drinkingGlassList;
	}
	
	public static List getBucketList() {
		return bucketList;
	}
	
	public static boolean hasInput(ItemStack item) {
		boolean inputState = false;
		if(item.getItem().equals(ItemManager.drinkingGlassFluid) || item.getItem().equals(ItemManager.bucketFluid)) {
			if(fluidName.containsKey(item.getItemDamage())) {
				inputState = true;
			} 
		} else if(specialInput.containsKey(item.getItem())) {
			inputState = true;
		}
		return inputState;
	}
	
	public static boolean hasCupOutput(int type) {
		return fluidName.containsKey(type);
	}
	
	public static boolean hasBucketOutput(int type) {
		return fluidName.containsKey(type);
	}
	
	public static int getType(ItemStack item) {
		int typeReturn = 0;
		if(specialInput.containsKey(item.getItem())) {
			typeReturn = specialInput.get(item.getItem());
		} else {
			typeReturn = item.getItemDamage();
		}
		return typeReturn;
	}
	
	public static int getInputVolume(ItemStack item) {
		int inputVolume = 0;
		if(item.getItem().equals(ItemManager.drinkingGlassFluid)) {
			inputVolume = CUPVOLUME;
		} else if(item.getItem().equals(ItemManager.bucketFluid) || specialInput.containsKey(item.getItem())) {
			inputVolume = BUCKETVOLUME;
		}
		return inputVolume;
	}
	
	public static Item getInputReturn(ItemStack item) {
		Item inputReturn = null;
		if(item.getItem().equals(ItemManager.drinkingGlassFluid)) {
			inputReturn = ItemManager.drinkingGlass;
		} else {
			inputReturn = Items.bucket;
		}
		return inputReturn;
	}
	
	public static ItemStack getBucketReturn(int type) {
		ItemStack bucketReturn = null;
		if(specialBucketOutput.containsKey(type)) {
			bucketReturn = new ItemStack(specialBucketOutput.get(type), 1, 0);
		} else {
			bucketReturn = new ItemStack(ItemManager.bucketFluid, 1, type);
		}
		return bucketReturn;
	}
	
	public static ItemStack getCupReturn(int type) {
		return new ItemStack(ItemManager.drinkingGlassFluid, 1, type);
	}
	
	public static int getBucketVolume() {
		return BUCKETVOLUME;
	}
	
	public static int getCupVolume() {
		return CUPVOLUME;
	}
	
	public static int getFluidColor(int type) {
		return fluidColor.get(type);
	}
	
	public static String getFluidName(int type) {
		return fluidName.get(type);
	}
	
	public static boolean isTranslucent(int type) {
		return fluidTranslucent.get(type);
	}

}
