package com.foodstuffs.misc;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CropRegistry {

	private static Map<Block, Item> crops = new HashMap<Block, Item>();
	private static Map<Block, Item> seeds = new HashMap<Block, Item>();
	private static Map<Item, Block> plants = new HashMap<Item, Block>();
	private static Map<Item, Block> grounds = new HashMap<Item, Block>();
	

	public static void registerCrop(Item cropItem, Item seedItem, Block plant, Block ground) {
		crops.put(plant, cropItem);
		seeds.put(plant, seedItem);
		plants.put(seedItem, plant);
		grounds.put(seedItem, ground);
	}
	
	public static void registerCrop(Item cropItem, Item seedItem, Block plant) {
		registerCrop(cropItem, seedItem, plant, Blocks.farmland);
	}
	
	public static void registerCrop(Item cropItem, Block plant, Block ground) {
		registerCrop(cropItem, cropItem, plant, ground);
	}
	
	public static void registerCrop(Item cropItem, Block plant) {
		registerCrop(cropItem, cropItem, plant);
	}
	
	public static Item getSeed(Block plant) { 
		return seeds.get(plant);
	}
	
	public static Item getCrop(Block plant) {
		return crops.get(plant);
	}
	
	public static Block getPlant(Item seed) {
		return plants.get(seed);
	}
	
	public static Block getGround(Item seed) {
		return grounds.get(seed);
	}
}
