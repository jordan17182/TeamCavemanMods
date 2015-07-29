package com.mttc;

import com.foodstuffs.misc.FoodstuffsTab;
import com.mttc.block.BlockManager;
import com.mttc.crafting.RecipeManager;
import com.mttc.gui.GUIHandler;
import com.mttc.hooks.HookManager;
import com.mttc.item.ItemManager;
import com.mttc.lib.ModInfoLib;
import com.mttc.tileentity.TileEntityManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ModInfoLib.MODID, name = ModInfoLib.NAME, version = ModInfoLib.VERSION)


public class MTTCMod {

	//Proxys
	@SidedProxy(clientSide = "com.mttc.ClientProxy", serverSide = "com.mttc.ServerProxy")
	public static ClientProxy proxy;
	
	@Instance("mttc")
	public static MTTCMod instance;	
	
	//Creative Tabs
	public static FoodstuffsTab mttcTab = new FoodstuffsTab("mttcTab");

	
    /**
    * Loads before
    * @param PreEvent
    */
    @EventHandler
    public void PreLoad(FMLPreInitializationEvent PreEvent) {
        BlockManager.mainRegistry();
    	ItemManager.mainRegistry();
        TileEntityManager.mainRegistry();        
    	HookManager.mainRegistry();
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());

        proxy.registerRenderThings();
	}
 
    /**
    * Loads during
    * @param Event
    */
    @EventHandler
    public void Load(FMLInitializationEvent Event) {    
    	RecipeManager.mainRegistry();

    }   
 
    /**
    * Loads after
    * @param PostEvent
    */
    @EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent) {
    }
}