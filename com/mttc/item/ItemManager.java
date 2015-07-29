package com.mttc.item;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemManager {
	
	public static Item copperIngot;
	public static Item silverIngot;
	public static Item zincIngot;
	public static Item leadIngot;
	public static Item aluminumIngot;
	public static Item titaniumIngot;
	public static Item platinumIngot;
	public static Item nickelIngot;
	public static Item tungstenIngot;
	public static Item cobaltIngot;
	
	public static Item copperNugget;
	public static Item silverNugget;
	public static Item zincNugget;
	public static Item leadNugget;
	public static Item aluminumNugget;
	public static Item titaniumNugget;
	public static Item platinumNugget;
	public static Item nickelNugget;
	public static Item tungstenNugget;
	public static Item cobaltNugget;
	
	public static Item clayDust;
	
    public static void mainRegistry() {
        initializeItem();
        registerItem();
        oreDictionary();
        ToolManager.initializeTools();
    }
 
    public static void initializeItem() {
    	copperIngot = new ItemMTTC("copperIngot");
    	silverIngot = new ItemMTTC("silverIngot");
    	zincIngot = new ItemMTTC("zincIngot");
    	leadIngot = new ItemMTTC("leadIngot");
    	aluminumIngot = new ItemMTTC("aluminumIngot");
    	titaniumIngot = new ItemMTTC("titaniumIngot");
    	platinumIngot = new ItemMTTC("platinumIngot");
    	nickelIngot = new ItemMTTC("nickelIngot");
    	tungstenIngot = new ItemMTTC("tungstenIngot");
    	cobaltIngot = new ItemMTTC("cobaltIngot");
    	
    	copperNugget = new ItemMTTC("copperNugget");
    	silverNugget = new ItemMTTC("silverNugget");
    	zincNugget = new ItemMTTC("zincNugget");
    	leadNugget = new ItemMTTC("leadNugget");
    	aluminumNugget = new ItemMTTC("aluminumNugget");
    	titaniumNugget = new ItemMTTC("titaniumNugget");
    	platinumNugget = new ItemMTTC("platinumNugget");
    	nickelNugget = new ItemMTTC("nickelNugget");
    	tungstenNugget = new ItemMTTC("tungstenNugget");
    	cobaltNugget = new ItemMTTC("cobaltNugget");
    	
    	clayDust = new ItemMTTC("clayDust");
    }
 
    public static void registerItem() {
    	GameRegistry.registerItem(copperIngot, copperIngot.getUnlocalizedName());
    	GameRegistry.registerItem(silverIngot, silverIngot.getUnlocalizedName());
    	GameRegistry.registerItem(zincIngot, zincIngot.getUnlocalizedName());
    	GameRegistry.registerItem(leadIngot, leadIngot.getUnlocalizedName());
    	GameRegistry.registerItem(aluminumIngot, aluminumIngot.getUnlocalizedName());
    	GameRegistry.registerItem(titaniumIngot, titaniumIngot.getUnlocalizedName());
    	GameRegistry.registerItem(platinumIngot, platinumIngot.getUnlocalizedName());
    	GameRegistry.registerItem(nickelIngot, nickelIngot.getUnlocalizedName());
    	GameRegistry.registerItem(tungstenIngot, tungstenIngot.getUnlocalizedName());
    	GameRegistry.registerItem(cobaltIngot, cobaltIngot.getUnlocalizedName());
    	
    	GameRegistry.registerItem(copperNugget, copperNugget.getUnlocalizedName());
    	GameRegistry.registerItem(silverNugget, silverNugget.getUnlocalizedName());
    	GameRegistry.registerItem(zincNugget, zincNugget.getUnlocalizedName());
    	GameRegistry.registerItem(leadNugget, leadNugget.getUnlocalizedName());
    	GameRegistry.registerItem(aluminumNugget, aluminumNugget.getUnlocalizedName());
    	GameRegistry.registerItem(titaniumNugget, titaniumNugget.getUnlocalizedName());
    	GameRegistry.registerItem(platinumNugget, platinumNugget.getUnlocalizedName());
    	GameRegistry.registerItem(nickelNugget, nickelNugget.getUnlocalizedName());
    	GameRegistry.registerItem(tungstenNugget, tungstenNugget.getUnlocalizedName());
    	GameRegistry.registerItem(cobaltNugget, cobaltNugget.getUnlocalizedName());
    	
    	GameRegistry.registerItem(clayDust, clayDust.getUnlocalizedName());
    	
    }
    public static void oreDictionary() {
    	OreDictionary.registerOre("ingotCopper", copperIngot);
    	OreDictionary.registerOre("ingotSilver", silverIngot);
    	OreDictionary.registerOre("ingotZinc", zincIngot);
    	OreDictionary.registerOre("ingotLead", leadIngot);
    	OreDictionary.registerOre("ingotAluminum", aluminumIngot);
    	OreDictionary.registerOre("ingotTitanium", titaniumIngot);
    	OreDictionary.registerOre("ingotPlatinum", platinumIngot);
    	OreDictionary.registerOre("ingotNickel", nickelIngot);
    	OreDictionary.registerOre("ingotTungsten", tungstenIngot);
    	OreDictionary.registerOre("ingotCobalt", cobaltIngot);
    	
    	OreDictionary.registerOre("nuggetCopper", copperNugget);
    	OreDictionary.registerOre("nuggetSilver", silverNugget);
    	OreDictionary.registerOre("nuggetZinc", zincNugget);
    	OreDictionary.registerOre("nuggetLead", leadNugget);
    	OreDictionary.registerOre("nuggetAluminum", aluminumNugget);
    	OreDictionary.registerOre("nuggetTitanium", titaniumNugget);
    	OreDictionary.registerOre("nuggetPlatinum", platinumNugget);
    	OreDictionary.registerOre("nuggetNickel", nickelNugget);
    	OreDictionary.registerOre("nuggetTungsten", tungstenNugget);
    	OreDictionary.registerOre("nuggetCobalt", cobaltNugget);
    	
    	
    	OreDictionary.registerOre("dustClay", clayDust);
    }
 
}