package com.caveman.genetics.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.caveman.genetics.item.ItemManager;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager{
		
    public static void mainRegistry(){
        registerCraftingHandlers();
    	addCraftingRecipes();
        addSmeltingRecipes();
    }
  
    private static void registerCraftingHandlers() {
    }
    
    public static void addCraftingRecipes() {
    	//Shapeless Recipes
     
        //Shaped Recipes
        //GameRegistry.addRecipe(new ShapedOreRecipe(ItemManager.sushi, new Object[]{" f ", "rrr", "sss", 'f', Items.fish, 'r', "cropRice", 's', Blocks.waterlily}));
    	GameRegistry.addRecipe(new ItemStack(ItemManager.dnaSample), "d", 'd', Items.apple);   
    }
 
    public static void addSmeltingRecipes() {    
        //GameRegistry.addSmelting(new ItemStack(ItemManager.baconRaw), new ItemStack(ItemManager.baconCooked), 0.1f);
    } 
}