package com.mttc.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

import com.foodstuffs.lib.ModInfoLib;
import com.mttc.block.BlockBlastFurnace;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockManager {
	
	public static Block kiln;
	public static Block conveyer;
	
	public static Block limestone;
	public static Block etowahMarble;
	
	public static Block oreCopper;
	public static Block oreSilver;
	public static Block oreZinc;
	public static Block oreLead;
	public static Block oreAluminum;
	public static Block oreTitanium;
	public static Block orePlatinum;
	public static Block oreNickel;
	public static Block oreTungsten;
	public static Block oreCobalt;
	public static Block orePlutonium;
	public static Block oreUranium;

	public static Block concrete;
	public static Block concreteBrick;
	public static Block ceramic;
	public static Block ceramicBrick;
	public static Block multiBlock;
	
    public static void mainRegistry() {
        initializeBlock();
        registerBlock();
        oreDictionary();
    }
 
    public static void initializeBlock() {   
    	kiln = new BlockKiln("kiln", 1.7F, 10.5F, Block.soundTypeStone);
    	conveyer = new BlockConveyer("conveyer");
    	
    	oreCopper = new BlockMTTCOre("oreCopper", 1.7F, 10.5F, Block.soundTypeStone);
    	oreSilver = new BlockMTTCOre("oreSilver", 1.7F, 10.5F, Block.soundTypeStone);
    	oreZinc = new BlockMTTCOre("oreZinc", 1.7F, 10.5F, Block.soundTypeStone);
    	oreLead = new BlockMTTCOre("oreLead", 1.7F, 10.5F, Block.soundTypeStone);
    	oreAluminum = new BlockMTTCOre("oreAluminum", 1.7F, 10.5F, Block.soundTypeStone);
    	oreTitanium = new BlockMTTCOre("oreTitanium", 1.7F, 10.5F, Block.soundTypeStone);
    	orePlatinum = new BlockMTTCOre("orePlatinum", 1.7F, 10.5F, Block.soundTypeStone);
    	oreNickel = new BlockMTTCOre("oreNickel", 1.7F, 10.5F, Block.soundTypeStone);
    	oreTungsten = new BlockMTTCOre("oreTungsten", 1.7F, 10.5F, Block.soundTypeStone);
    	oreCobalt = new BlockMTTCOre("oreCobalt", 1.7F, 10.5F, Block.soundTypeStone);
    	orePlutonium = new BlockMTTCOre("orePlutonium", 1.7F, 10.5F, Block.soundTypeStone);
    	oreUranium = new BlockMTTCOre("oreUranium", 1.7F, 10.5F, Block.soundTypeStone);
    	
    	concrete = new StructureBlock(Material.rock, "concrete", 1.7F, 10.5F, Block.soundTypeStone);
    	concreteBrick = new StructureBlock(Material.rock, "concreteBrick", 1.7F, 10.5F, Block.soundTypeStone);
    	ceramic = new StructureBlock(Material.rock, "ceramic", 1.7F, 10.5F, Block.soundTypeStone);
    	ceramicBrick = new StructureBlock(Material.rock, "ceramicBrick", 1.7F, 10.5F, Block.soundTypeStone);
    	
    	multiBlock = new BlockBlastFurnace(Material.rock).setHardness(1.5F).setBlockName("multiBlock");
    }

    
    public static void registerBlock() {
    	GameRegistry.registerBlock(kiln, kiln.getUnlocalizedName());
    	GameRegistry.registerBlock(conveyer, conveyer.getUnlocalizedName());
    	
    	GameRegistry.registerBlock(oreCopper, oreCopper.getUnlocalizedName());
    	GameRegistry.registerBlock(oreSilver, oreSilver.getUnlocalizedName());
    	GameRegistry.registerBlock(oreZinc, oreZinc.getUnlocalizedName());
    	GameRegistry.registerBlock(oreLead, oreLead.getUnlocalizedName());
    	GameRegistry.registerBlock(oreAluminum, oreAluminum.getUnlocalizedName());
    	GameRegistry.registerBlock(oreTitanium, oreTitanium.getUnlocalizedName());
    	GameRegistry.registerBlock(orePlatinum, orePlatinum.getUnlocalizedName());
    	GameRegistry.registerBlock(oreNickel, oreNickel.getUnlocalizedName());
    	GameRegistry.registerBlock(oreTungsten, oreTungsten.getUnlocalizedName());
    	GameRegistry.registerBlock(oreCobalt, oreCobalt.getUnlocalizedName());
    	GameRegistry.registerBlock(orePlutonium, orePlutonium.getUnlocalizedName());
    	GameRegistry.registerBlock(oreUranium, oreUranium.getUnlocalizedName());

    	GameRegistry.registerBlock(concrete, concrete.getUnlocalizedName());
    	GameRegistry.registerBlock(concreteBrick, concreteBrick.getUnlocalizedName());
    	GameRegistry.registerBlock(ceramic, ceramic.getUnlocalizedName());
    	GameRegistry.registerBlock(ceramicBrick, ceramicBrick.getUnlocalizedName());
    	
    	GameRegistry.registerBlock(multiBlock, multiBlock.getUnlocalizedName());
    }
    
    public static void oreDictionary() {
    	OreDictionary.registerOre("oreCopper", oreCopper);
    	OreDictionary.registerOre("oreSilver", oreSilver);
    	OreDictionary.registerOre("oreZinc", oreZinc);
    	OreDictionary.registerOre("oreLead", oreLead);
    }
}