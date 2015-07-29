package com.caveman.genetics.item;

import com.caveman.genetics.block.BlockManager;
import com.caveman.genetics.lib.ModInfoLib;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemManager {
	
	public static Item dnaSample;
	public static Item grafter;

	public static void mainRegistry() {
        initializeItem();
        registerItem();
        oreDictionary();
    }
 
    public static void initializeItem() {
    	dnaSample = new ItemPlantSeed("dnaSample", BlockManager.plant).setTextureName(ModInfoLib.MODID + ":dnaSample");	
    	grafter = new ItemGrafter("grafter").setTextureName(ModInfoLib.MODID + ":grafter");
    }
 
    public static void registerItem() {
    	GameRegistry.registerItem(dnaSample, dnaSample.getUnlocalizedName());
    	GameRegistry.registerItem(grafter, grafter.getUnlocalizedName());
    }
    public static void oreDictionary() {
    	//OreDictionary.registerOre("cropRice", rice);
    }
 
}