package com.mttc.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.mttc.block.BlockManager;
import com.mttc.item.ItemManager;
import com.mttc.item.ToolManager;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager{
	
	
    public static void mainRegistry(){
    	addCraftingRecipes();
        addSmeltingRecipes();
    }

    public static void addCraftingRecipes() {
    	//Shapeless Recipes
    	addNuggetCrafting(ItemManager.copperNugget, ItemManager.copperIngot);
    	addNuggetCrafting(ItemManager.silverNugget, ItemManager.silverIngot);
    	addNuggetCrafting(ItemManager.zincNugget, ItemManager.zincIngot);
    	addNuggetCrafting(ItemManager.leadNugget, ItemManager.leadIngot);
    	addNuggetCrafting(ItemManager.aluminumNugget, ItemManager.aluminumIngot);
    	addNuggetCrafting(ItemManager.titaniumNugget, ItemManager.titaniumIngot);
    	addNuggetCrafting(ItemManager.platinumNugget, ItemManager.platinumIngot);
    	addNuggetCrafting(ItemManager.nickelNugget, ItemManager.nickelIngot);
    	addNuggetCrafting(ItemManager.tungstenNugget, ItemManager.tungstenIngot);
    	addNuggetCrafting(ItemManager.cobaltNugget, ItemManager.cobaltIngot);

    	//Shaped Recipes
    	addToolsetCrafting(ItemManager.silverIngot, ToolManager.swordSilver, ToolManager.shovelSilver, ToolManager.axeSilver, ToolManager.hoeSilver, ToolManager.pickaxeSilver);
    	addToolsetCrafting(ItemManager.copperIngot, ToolManager.swordCopper, ToolManager.shovelCopper, ToolManager.axeCopper, ToolManager.hoeCopper, ToolManager.pickaxeCopper);
    	addToolsetCrafting(ItemManager.zincIngot, ToolManager.swordZinc, ToolManager.shovelZinc, ToolManager.axeZinc, ToolManager.hoeZinc, ToolManager.pickaxeZinc);
    	addToolsetCrafting(ItemManager.leadIngot, ToolManager.swordLead, ToolManager.shovelLead, ToolManager.axeLead, ToolManager.hoeLead, ToolManager.pickaxeLead);
    	addToolsetCrafting(ItemManager.aluminumIngot, ToolManager.swordAluminum, ToolManager.shovelAluminum, ToolManager.axeAluminum, ToolManager.hoeAluminum, ToolManager.pickaxeAluminum);
    	addToolsetCrafting(ItemManager.titaniumIngot, ToolManager.swordTitanium, ToolManager.shovelTitanium, ToolManager.axeTitanium, ToolManager.hoeTitanium, ToolManager.pickaxeTitanium);
    	addToolsetCrafting(ItemManager.platinumIngot, ToolManager.swordPlatinum, ToolManager.shovelPlatinum, ToolManager.axePlatinum, ToolManager.hoePlatinum, ToolManager.pickaxePlatinum);
    	addToolsetCrafting(ItemManager.nickelIngot, ToolManager.swordNickel, ToolManager.shovelNickel, ToolManager.axeNickel, ToolManager.hoeNickel, ToolManager.pickaxeNickel);
    	addToolsetCrafting(ItemManager.tungstenIngot, ToolManager.swordTungsten, ToolManager.shovelTungsten, ToolManager.axeTungsten, ToolManager.hoeTungsten, ToolManager.pickaxeTungsten);
    	addToolsetCrafting(ItemManager.cobaltIngot, ToolManager.swordCobalt, ToolManager.shovelCobalt, ToolManager.axeCobalt, ToolManager.hoeCobalt, ToolManager.pickaxeCobalt);
    	
    	/**
        GameRegistry.addRecipe(new ItemStack(ItemManager.banana,1), "shs", 's', Items.sugar, 'h', new ItemStack(ItemManager.knifeWooden));
        GameRegistry.addRecipe(new ItemStack(ItemManager.barrelItem), "p p", "p p", "ppp", 'p', Blocks.planks);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemManager.drinkingGlass, 4), new Object[]{"g", "g",'g', "paneGlass"}));
        GameRegistry.addRecipe(new ItemStack(ItemManager.knifeWooden, 1), " p", "s ", 'p', Blocks.planks, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(ItemManager.knifeWooden, 1), "p ", " s", 'p', Blocks.planks, 's', Items.stick);
        GameRegistry.addRecipe(new ItemStack(BlockManager.asparagusPlant, 1,5), "p", 'p', Blocks.obsidian);
        **/
    }  
  
    private static void addToolsetCrafting(Item ingot, Item sword, Item shovel, Item axe, Item hoe, Item pickaxe) {
    	String ingotName = OreDictionary.getOreName(OreDictionary.getOreIDs(new ItemStack(ingot))[0]);
    	String stickName = OreDictionary.getOreName(OreDictionary.getOreIDs(new ItemStack(Items.stick))[0]);
    	//Sword recipe
    	GameRegistry.addRecipe(new ShapedOreRecipe(sword, "i", "i", "s", 'i', ingotName, 's', stickName));
    	//Shovel recipe
    	GameRegistry.addRecipe(new ShapedOreRecipe(shovel, "i", "s", "s", 'i', ingotName, 's', stickName));
    	//Axe recipes
    	GameRegistry.addRecipe(new ShapedOreRecipe(axe, "ii", "is", " s", 'i', ingotName, 's', stickName));
    	GameRegistry.addRecipe(new ShapedOreRecipe(axe, "ii", "si", "s ", 'i', ingotName, 's', stickName));
    	//Hoe
    	GameRegistry.addRecipe(new ShapedOreRecipe(hoe, "ii", " s", " s", 'i', ingotName, 's', stickName));
    	GameRegistry.addRecipe(new ShapedOreRecipe(hoe, "ii", "s ", "s ", 'i', ingotName, 's', stickName));
    	//Pickaxe
    	GameRegistry.addRecipe(new ShapedOreRecipe(pickaxe, "iii", " s ", " s ", 'i', ingotName, 's', stickName));
    }
    
    private static void addNuggetCrafting(Item nugget, Item ingot) {
    	String nuggetName = OreDictionary.getOreName(OreDictionary.getOreIDs(new ItemStack(nugget))[0]);
    	String ingotName = OreDictionary.getOreName(OreDictionary.getOreIDs(new ItemStack(ingot))[0]);
    	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(nugget, 9), new Object[] {ingotName}));
    	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ingot, 1), new Object[] 
    			{nuggetName,nuggetName,nuggetName,
    		nuggetName,nuggetName,nuggetName,
    		nuggetName,nuggetName,nuggetName}));
    }
    
    public static void addSmeltingRecipes() {    
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreCopper), new ItemStack(ItemManager.copperIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreSilver), new ItemStack(ItemManager.silverIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreZinc), new ItemStack(ItemManager.zincIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreLead), new ItemStack(ItemManager.leadIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreAluminum), new ItemStack(ItemManager.aluminumIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreTitanium), new ItemStack(ItemManager.titaniumIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.orePlatinum), new ItemStack(ItemManager.platinumIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreNickel), new ItemStack(ItemManager.nickelIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreTungsten), new ItemStack(ItemManager.tungstenIngot), 0.7f);
    	GameRegistry.addSmelting(new ItemStack(BlockManager.oreCobalt), new ItemStack(ItemManager.cobaltIngot), 0.7f);

    }
}