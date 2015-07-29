package com.foodstuffs.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.foodstuffs.lib.ModInfoLib;
import com.mttc.block.BlockBlastFurnace;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockManager {
		
	public static Block ricePlant;
	public static Block garlicPlant;
	public static Block onionPlant; 
	public static Block bellPepperGreenPlant;
	public static Block bellPepperRedPlant;
	public static Block lettucePlant;
	public static Block spinachPlant;
	public static Block celeryPlant;
	public static Block asparagusPlant;
	public static Block rhubarbPlant;
	public static Block bokChoyPlant;
	public static Block brusselsSproutPlant;
	public static Block cabbagePlant;
	public static Block chicoryPlant;
	public static Block dillPlant;
	public static Block kalePlant;
	public static Block mustardPlant;
	public static Block peasPlant;
	public static Block turnipPlant;
	public static Block limeLog;
	public static Block limeWood;
	public static Block limeLeaves;
	public static Block barrel;
	public static ArrayList<Block> blocks = new ArrayList<>();
    public static void mainRegistry() {
        initializeBlock();
        registerBlock();
    }
 
    public static void initializeBlock() {    	
    	ricePlant = new FSCrop("ricePlant").setBlockTextureName(ModInfoLib.MODID + ":rice");
    	garlicPlant = new FSCrop("garlicPlant").setBlockTextureName(ModInfoLib.MODID + ":garlic");
    	onionPlant = new FSCrop("onionPlant").setBlockTextureName(ModInfoLib.MODID + ":onion"); 
    	bellPepperGreenPlant = new FSCrop("bellPepperGreenPlant").setBlockTextureName(ModInfoLib.MODID + ":bellPepperGreen");
    	bellPepperRedPlant = new FSCrop("bellPepperRedPlant").setBlockTextureName(ModInfoLib.MODID + ":bellPepperRed");
    	lettucePlant = new FSCrop("lettucePlant").setBlockTextureName(ModInfoLib.MODID + ":lettuce");
    	spinachPlant = new FSCrop("spinachPlant").setBlockTextureName(ModInfoLib.MODID + ":spinach");
    	celeryPlant = new FSCrop("celeryPlant").setBlockTextureName(ModInfoLib.MODID + ":celery");
    	asparagusPlant = new FSCrop("asparagusPlant").setBlockTextureName(ModInfoLib.MODID + ":asparagus");
    	rhubarbPlant = new FSCrop("rhubarbPlant").setBlockTextureName(ModInfoLib.MODID + ":rhubarb");
    	bokChoyPlant = new FSCrop("bokChoyPlant").setBlockTextureName(ModInfoLib.MODID + ":bokChoy");
    	brusselsSproutPlant = new FSCrop("brusselsSproutPlant").setBlockTextureName(ModInfoLib.MODID + ":brusselsSprout");
    	cabbagePlant = new FSCrop("cabbagePlant").setBlockTextureName(ModInfoLib.MODID + ":cabbage");
    	chicoryPlant = new FSCrop("chicoryPlant").setBlockTextureName(ModInfoLib.MODID + ":chicory");
    	dillPlant = new FSCrop("dillPlant").setBlockTextureName(ModInfoLib.MODID + ":dill");
    	kalePlant = new FSCrop("kalePlant").setBlockTextureName(ModInfoLib.MODID + ":kale");
    	mustardPlant = new FSCrop("mustardPlant").setBlockTextureName(ModInfoLib.MODID + ":mustard");
    	peasPlant = new FSCrop("peasPlant").setBlockTextureName(ModInfoLib.MODID + ":peas");
    	turnipPlant = new FSCrop("turnipPlant").setBlockTextureName(ModInfoLib.MODID + ":turnip"); 
    	
    	limeLog = new BlockLimeLog("limeLog");
    	limeWood = new BlockLimeWood("limeWood");
    	limeLeaves = new BlockLimeLeaves("limeLeaves");
    	barrel = new BlockBarrel("barrelBlock");
    }
    
    public static void registerLate() {
    	blocks.add(new FSCrop("barrelBlock2"));
    	GameRegistry.registerBlock(blocks.get(0), blocks.get(0).getUnlocalizedName());
    }
    
    public static void registerBlock() {
    	GameRegistry.registerBlock(ricePlant, ricePlant.getUnlocalizedName());
    	GameRegistry.registerBlock(garlicPlant, garlicPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(onionPlant, onionPlant.getUnlocalizedName()); 
    	GameRegistry.registerBlock(bellPepperGreenPlant, bellPepperGreenPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(bellPepperRedPlant, bellPepperRedPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(lettucePlant, lettucePlant.getUnlocalizedName());
    	GameRegistry.registerBlock(spinachPlant, spinachPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(celeryPlant, celeryPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(asparagusPlant, asparagusPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(rhubarbPlant, rhubarbPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(bokChoyPlant, bokChoyPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(brusselsSproutPlant, brusselsSproutPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(cabbagePlant, cabbagePlant.getUnlocalizedName());
    	GameRegistry.registerBlock(chicoryPlant, chicoryPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(dillPlant, dillPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(kalePlant, kalePlant.getUnlocalizedName());
    	GameRegistry.registerBlock(mustardPlant, mustardPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(peasPlant, peasPlant.getUnlocalizedName());
    	GameRegistry.registerBlock(turnipPlant, turnipPlant.getUnlocalizedName());
    	
    	GameRegistry.registerBlock(limeLog, limeLog.getUnlocalizedName());
    	GameRegistry.registerBlock(limeWood, limeWood.getUnlocalizedName());
    	GameRegistry.registerBlock(limeLeaves, limeLeaves.getUnlocalizedName());
    	GameRegistry.registerBlock(barrel, barrel.getUnlocalizedName());
    }
 
}