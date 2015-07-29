package com.tks.relics;

import com.foodstuffs.ClientProxy;
import com.foodstuffs.FoodstuffsMod;
import com.foodstuffs.misc.FoodstuffsTab;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class RelicsMod {
	public static final String MODID = "relics";
	public static final String VERSION = "1.0.0.0";


	//Proxys
	@SidedProxy(clientSide = "com.tks.relics.ClientProxy", serverSide = "com.tks.relics.ServerProxy")
	public static ClientProxy proxy;
	
	@Instance("relics")
	public static RelicsMod instance;	
	
	//Creative Tabs
	public static RelicsTab relicsTab = new RelicsTab("relicsTab");

	
    /**
    * Loads before
    * @param PreEvent
    */
    @EventHandler
    public void PreLoad(FMLPreInitializationEvent PreEvent) {
    	
    }
    
    /**
    * Loads during
    * @param Event
    */
    @EventHandler
    public void Load(FMLInitializationEvent Event) {    
 
    }   
 
    /**
    * Loads after
    * @param PostEvent
    */
    @EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent) {
 
    }

}