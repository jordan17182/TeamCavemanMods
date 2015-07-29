package com.caveman.blockfinder;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = BlockFinderMod.MODID, version = BlockFinderMod.VERSION)
public class BlockFinderMod
{
    public static final String MODID = "blockfinder";
    public static final String VERSION = "1.0.0.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}