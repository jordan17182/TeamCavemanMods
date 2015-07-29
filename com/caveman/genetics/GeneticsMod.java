package com.caveman.genetics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.caveman.genetics.block.BlockManager;
import com.caveman.genetics.crafting.RecipeManager;
import com.caveman.genetics.genome.GeneRegistry;
import com.caveman.genetics.gui.GUIHandler;
import com.caveman.genetics.item.ItemManager;
import com.caveman.genetics.lib.ModInfoLib;
import com.caveman.genetics.misc.GeneticsTab;
import com.caveman.genetics.tileentity.TileEntityManager;
//import com.tks.genetics.packets.NetworkHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ModInfoLib.MODID, name = ModInfoLib.NAME, version = ModInfoLib.VERSION)
public class GeneticsMod {

	// Proxys
	@SidedProxy(clientSide = "com.caveman.genetics.ClientProxy", serverSide = "com.caveman.genetics.ServerProxy")
	public static ClientProxy proxy;

	@Instance("genetics")
	public static GeneticsMod instance;

	// Genetics Registry
	public static GeneRegistry geneticsRegistry = new GeneRegistry();
	
	// Creative Tabs
	public static GeneticsTab genTab = new GeneticsTab("genTab");

	// Packet Channel
	public static FMLEventChannel networkCon;

	/**
	 * Loads during
	 * 
	 * @param event
	 */	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		//networkCon = NetworkRegistry.INSTANCE.newEventDrivenChannel(ModInfoLib.MODID);
		//networkCon.register(new NetworkHandler());
	}

	/**
	 * Loads before
	 * 
	 * @param PreEvent
	 */
	@EventHandler
	public void PreLoad(FMLPreInitializationEvent PreEvent) {
		BlockManager.mainRegistry();
		ItemManager.mainRegistry();
        TileEntityManager.mainRegistry();
		RecipeManager.mainRegistry();
		// HookManager.mainRegistry();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());

		proxy.registerRenderThings();
	}

	/**
	 * Loads during
	 * 
	 * @param Event
	 */
	@EventHandler
	public void Load(FMLInitializationEvent Event) {
		//GameRegistry.findItem(modId, name)
		
		try {
			Class<?> test = Class.forName("com.caveman.genetics.Test");
			Method method = test.getMethod("PrintTest");
			Object o = method.invoke(null);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Loads after
	 * 
	 * @param PostEvent
	 */
	@EventHandler
	public void PostLoad(FMLPostInitializationEvent PostEvent) {

	}

}
