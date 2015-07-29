package com.foodstuffs.crafting;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.foodstuffs.block.BlockManager;
import com.foodstuffs.item.ItemManager;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager{
	
	private static BarrelCraftingRegistry barrelCraftingReg;
	
    public static void mainRegistry(){
        registerCraftingHandlers();
    	addCraftingRecipes();
        addSmeltingRecipes();
 
    }//end mainRegistry
  
    private static void registerCraftingHandlers() {
    	barrelCraftingReg = new BarrelCraftingRegistry();
    }
 
    public static boolean addDrinkRecipe(int fluidType, Object ... ing) {
    	return barrelCraftingReg.addDrinkRecipe(fluidType, ing);
    }
    
    public static void addDrinkRecipe(int fluidType, boolean fermentable, int fermentTime, Object ... ing) {
    	barrelCraftingReg.addDrinkRecipe(fluidType, ing, fermentable, fermentTime);
    }
    
    public static boolean checkDrinkRecipe(Object ... ing) {
    	return barrelCraftingReg.checkRecipe(ing);
    }
    
    public static int getDrinkResult(Object ... ing) {
    	if(barrelCraftingReg.checkRecipe(ing)) {
    		return barrelCraftingReg.getDrinkResult(ing);
    	} else {
    		return -1;
    	}
    }
    
    public static void addCraftingRecipes() {
    	//Shapeless Recipes
     
        //Shaped Recipes
        //GameRegistry.addRecipe(new ShapedOreRecipe(ItemManager.sushi, new Object[]{" f ", "rrr", "sss", 'f', Items.fish, 'r', "cropRice", 's', Blocks.waterlily}));
    	
    	
        GameRegistry.addRecipe(new ItemStack(ItemManager.banana,1), "shs", 's', Items.sugar, 'h', new ItemStack(ItemManager.knifeWooden));
        GameRegistry.addRecipe(new ItemStack(ItemManager.barrelItem), "p p", "p p", "ppp", 'p', Blocks.planks);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemManager.drinkingGlass, 4), new Object[]{"g", "g",'g', "paneGlass"}));
        GameRegistry.addRecipe(new ItemStack(ItemManager.knifeWooden, 1), " p", "s ", 'p', Blocks.planks, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(ItemManager.knifeWooden, 1), "p ", " s", 'p', Blocks.planks, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(BlockManager.asparagusPlant, 1,5), "p", 'p', Blocks.obsidian);
        
        
    }//end addCraftingRecipes    
  
 
    public static void addSmeltingRecipes() {    
        GameRegistry.addSmelting(new ItemStack(ItemManager.baconRaw), new ItemStack(ItemManager.baconCooked), 0.1f);
    }//end addSmeltingRecipes
 
}//end class