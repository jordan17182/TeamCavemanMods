package com.caveman.genetics.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockManager {
	
	public static Block plant;

    public static void mainRegistry() {
        initializeBlock();
        registerBlock();
    }
 
    public static void initializeBlock() {
    	plant = new BlockPlant("barrelBlock");

    }
 
    public static void registerBlock() {
    	GameRegistry.registerBlock(plant, plant.getUnlocalizedName());
    }
 
}