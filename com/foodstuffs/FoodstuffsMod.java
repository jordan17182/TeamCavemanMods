package com.foodstuffs;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import com.foodstuffs.block.BlockManager;
import com.foodstuffs.crafting.RecipeManager;
import com.foodstuffs.gui.GUIHandler;
import com.foodstuffs.hooks.HookManager;
import com.foodstuffs.item.ItemManager;
import com.foodstuffs.lib.ModInfoLib;
import com.foodstuffs.misc.CropRegistry;
import com.foodstuffs.misc.DrinkRegistry;
import com.foodstuffs.misc.FoodstuffsTab;
import com.foodstuffs.tileentity.TileEntityManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ModInfoLib.MODID, name = ModInfoLib.NAME, version = ModInfoLib.VERSION)


public class FoodstuffsMod {

	//Proxys
	@SidedProxy(clientSide = "com.foodstuffs.ClientProxy", serverSide = "com.foodstuffs.ServerProxy")
	public static ClientProxy proxy;
	
	@Instance("foodstuffs")
	public static FoodstuffsMod instance;
	
	public static boolean createRice = true;
	
	
	//Creative Tabs
	public static FoodstuffsTab foodTab = new FoodstuffsTab("foodTab");

	
    /**
    * Loads before
    * @param PreEvent
    */
    @EventHandler
    public void PreLoad(FMLPreInitializationEvent PreEvent) {
        BlockManager.mainRegistry();
    	ItemManager.mainRegistry();
        TileEntityManager.mainRegistry();        
    	RecipeManager.mainRegistry();
    	HookManager.mainRegistry();
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());

    	
        proxy.registerRenderThings();
        
        CropRegistry.registerCrop(ItemManager.garlic, BlockManager.garlicPlant, Blocks.farmland);
        CropRegistry.registerCrop(ItemManager.onion, BlockManager.onionPlant, Blocks.farmland); 
    	CropRegistry.registerCrop(ItemManager.bellPepperGreen, BlockManager.bellPepperGreenPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.bellPepperRed, BlockManager.bellPepperRedPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.lettuce, BlockManager.lettucePlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.spinach, BlockManager.spinachPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.celery, BlockManager.celeryPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.asparagus, BlockManager.asparagusPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.rhubarb, BlockManager.rhubarbPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.bokChoy, BlockManager.bokChoyPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.brusselsSprout, BlockManager.brusselsSproutPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.cabbage, BlockManager.cabbagePlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.chicory, BlockManager.chicoryPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.dill, BlockManager.dillPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.kale, BlockManager.kalePlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.mustard, BlockManager.mustardPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.peas, BlockManager.peasPlant, Blocks.farmland);
    	CropRegistry.registerCrop(ItemManager.turnip, BlockManager.turnipPlant, Blocks.farmland);
    	
        DrinkRegistry.addFluid("Water", Items.water_bucket, 0, 26367, true);
        DrinkRegistry.addFluid("Carbonated Water", 1, 26367, true);
		DrinkRegistry.addFluid("Milk", Items.milk_bucket, 2, 16777215, false);
		DrinkRegistry.addFluid("Chocolate Milk", 3, 8672256, false);
		DrinkRegistry.addFluid("Strawberry Milk", 4, 16777215, false);
		DrinkRegistry.addFluid("Lemonade", 5, 16187136, true);
		//DrinkRegistry.addFluid("Lemonade", 5, 16187136, true, new ArrayList<ItemStack>(new ItemStack(ItemManager.lemon,16), new ItemStack(Items.sugar, 16)));
		DrinkRegistry.addFluid("Hard Lemonade", 6, 16187136, true);
		DrinkRegistry.addFluid("Sparkling Lemonade", 7, 16187136, true);
		DrinkRegistry.addFluid("Red Grape Juice", 8, 10947614, true);
		DrinkRegistry.addFluid("Sparkling Red Grape Juice", 9, 10947614, true);
		DrinkRegistry.addFluid("Red Wine", 10, 10880775, true);
		DrinkRegistry.addFluid("White Grape Juice", 11, 16771943, true);
		DrinkRegistry.addFluid("Sparkling White Grape Juice", 12, 16771943, true);
		DrinkRegistry.addFluid("White Wine", 13, 15983456, true);
		DrinkRegistry.addFluid("Root Beer", 14, 15983456, true);
		DrinkRegistry.addFluid("Ginger Ale", 15, 15983456, true);
		DrinkRegistry.addFluid("Lemon-Lime Soda", 16, 15983456, true);
		DrinkRegistry.addFluid("Cola", 17, 15983456, true);
		DrinkRegistry.addFluid("Strawberry Soda", 18, 15983456, true);
		DrinkRegistry.addFluid("Grape Soda", 19, 15983456, true);
		DrinkRegistry.addFluid("Cream Soda", 20, 15983456, true);
		DrinkRegistry.addFluid("Strawberry Lemonade", 21, 16187136, true);
		DrinkRegistry.addFluid("Raspberry Lemonade", 22, 16187136, true);
		DrinkRegistry.addFluid("Limeade", 23, 16187136, true);
		DrinkRegistry.addFluid("Raspberry Soda", 24, 16187136, true);
		DrinkRegistry.addFluid("Blackberry Soda", 25, 16187136, true);
		DrinkRegistry.addFluid("Rum", 26, 14320661, true);
		DrinkRegistry.addFluid("Pina Colada", 27, 16771943, true);
		DrinkRegistry.addFluid("Vodka", 28, 16771943, true);
		DrinkRegistry.addFluid("Whiskey", 29, 16771943, true);
		DrinkRegistry.addFluid("Bourbon", 30, 16771943, true);
		//Bloody Mary
		//Memosa
		//Manhatan
		//Cocktail
		//White Russian
		//Orange Soda
		//
	    
	    
		
		//DrinkRegistry.addFluid("Apple Cider", 4, 14320661, true);
		//DrinkRegistry.addFluid("Hard Apple Cider", 5, 14320661, true);
		
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
    	ItemManager.registerLate();
    }

}
