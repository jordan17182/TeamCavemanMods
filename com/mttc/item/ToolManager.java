package com.mttc.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class ToolManager {
	public static ToolMaterial SILVER = EnumHelper.addToolMaterial("SILVER", 1, 99, 3.7F, 3.0F, 14);
	public static ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", 1, 199, 5.0F, 1.5F, 14);
	public static ToolMaterial ZINC = EnumHelper.addToolMaterial("ZINC", 1, 39, 6.0F, 0.0f, 14);
	public static ToolMaterial LEAD = EnumHelper.addToolMaterial("LEAD", 0, 19, 1.5F, 1.0F, 14);
	public static ToolMaterial ALUMINUM = EnumHelper.addToolMaterial("ALUMINUM", 1, 199, 3.5F, 0.0F, 14);
	public static ToolMaterial TITANIUM = EnumHelper.addToolMaterial("TITANIUM", 2, 549, 7.0F, 2.5F, 14);
	public static ToolMaterial PLATINUM = EnumHelper.addToolMaterial("PLATINUM", 2, 224, 5.0F, 1.7F, 14);
	public static ToolMaterial NICKEL = EnumHelper.addToolMaterial("NICKEL", 2, 289, 6.3F, 2.0F, 14);
	public static ToolMaterial TUNGSTEN = EnumHelper.addToolMaterial("TUNGSTEN", 3, 999, 7.4F, 2.8F, 14);
	public static ToolMaterial COBALT = EnumHelper.addToolMaterial("COBALT", 2, 449, 6.8F, 2.3F, 14);
	
	//Silver
	public static Item swordSilver = new ItemMTTCSword(SILVER, "swordSilver");
	public static Item shovelSilver = new ItemMTTCSpade(SILVER, "shovelSilver");
	public static Item axeSilver = new ItemMTTCAxe(SILVER, "axeSilver");
	public static Item hoeSilver = new ItemMTTCHoe(SILVER, "hoeSilver");
	public static Item pickaxeSilver = new ItemMTTCPickaxe(SILVER, "pickaxeSilver");
	//Copper
	public static Item swordCopper = new ItemMTTCSword(COPPER, "swordCopper");
	public static Item shovelCopper = new ItemMTTCSpade(COPPER, "shovelCopper");
	public static Item axeCopper = new ItemMTTCAxe(COPPER, "axeCopper");
	public static Item hoeCopper = new ItemMTTCHoe(COPPER, "hoeCopper");
	public static Item pickaxeCopper = new ItemMTTCPickaxe(COPPER, "pickaxeCopper");
	//Zinc
	public static Item swordZinc = new ItemMTTCSword(ZINC, "swordZinc");
	public static Item shovelZinc = new ItemMTTCSpade(ZINC, "shovelZinc");
	public static Item axeZinc = new ItemMTTCAxe(ZINC, "axeZinc");
	public static Item hoeZinc = new ItemMTTCHoe(ZINC, "hoeZinc");
	public static Item pickaxeZinc = new ItemMTTCPickaxe(ZINC, "pickaxeZinc");
	//Lead
	public static Item swordLead = new ItemMTTCSword(LEAD, "swordLead");
	public static Item shovelLead = new ItemMTTCSpade(LEAD, "shovelLead");
	public static Item axeLead = new ItemMTTCAxe(LEAD, "axeLead");
	public static Item hoeLead = new ItemMTTCHoe(LEAD, "hoeLead");
	public static Item pickaxeLead = new ItemMTTCPickaxe(LEAD, "pickaxeLead");
	//Aluminum
	public static Item swordAluminum = new ItemMTTCSword(ALUMINUM, "swordAluminum");
	public static Item shovelAluminum = new ItemMTTCSpade(ALUMINUM, "shovelAluminum");
	public static Item axeAluminum = new ItemMTTCAxe(ALUMINUM, "axeAluminum");
	public static Item hoeAluminum = new ItemMTTCHoe(ALUMINUM, "hoeAluminum");
	public static Item pickaxeAluminum = new ItemMTTCPickaxe(ALUMINUM, "pickaxeAluminum");
	//Titanium
	public static Item swordTitanium = new ItemMTTCSword(TITANIUM, "swordTitanium");
	public static Item shovelTitanium = new ItemMTTCSpade(TITANIUM, "shovelTitanium");
	public static Item axeTitanium = new ItemMTTCAxe(TITANIUM, "axeTitanium");
	public static Item hoeTitanium = new ItemMTTCHoe(TITANIUM, "hoeTitanium");
	public static Item pickaxeTitanium = new ItemMTTCPickaxe(TITANIUM, "pickaxeTitanium");
	//Platinum
	public static Item swordPlatinum = new ItemMTTCSword(PLATINUM, "swordPlatinum");
	public static Item shovelPlatinum = new ItemMTTCSpade(PLATINUM, "shovelPlatinum");
	public static Item axePlatinum = new ItemMTTCAxe(PLATINUM, "axePlatinum");
	public static Item hoePlatinum = new ItemMTTCHoe(PLATINUM, "hoePlatinum");
	public static Item pickaxePlatinum = new ItemMTTCPickaxe(PLATINUM, "pickaxePlatinum");
	//Nickel
	public static Item swordNickel = new ItemMTTCSword(NICKEL, "swordNickel");
	public static Item shovelNickel = new ItemMTTCSpade(NICKEL, "shovelNickel");
	public static Item axeNickel = new ItemMTTCAxe(NICKEL, "axeNickel");
	public static Item hoeNickel = new ItemMTTCHoe(NICKEL, "hoeNickel");
	public static Item pickaxeNickel = new ItemMTTCPickaxe(NICKEL, "pickaxeNickel");
	//Tungsten
	public static Item swordTungsten = new ItemMTTCSword(TUNGSTEN, "swordTungsten");
	public static Item shovelTungsten = new ItemMTTCSpade(TUNGSTEN, "shovelTungsten");
	public static Item axeTungsten = new ItemMTTCAxe(TUNGSTEN, "axeTungsten");
	public static Item hoeTungsten = new ItemMTTCHoe(TUNGSTEN, "hoeTungsten");
	public static Item pickaxeTungsten = new ItemMTTCPickaxe(TUNGSTEN, "pickaxeTungsten");
	//Cobalt
	public static Item swordCobalt = new ItemMTTCSword(COBALT, "swordCobalt");
	public static Item shovelCobalt = new ItemMTTCSpade(COBALT, "shovelCobalt");
	public static Item axeCobalt = new ItemMTTCAxe(COBALT, "axeCobalt");
	public static Item hoeCobalt = new ItemMTTCHoe(COBALT, "hoeCobalt");
	public static Item pickaxeCobalt = new ItemMTTCPickaxe(COBALT, "pickaxeCobalt");
	
	public static void initializeTools () {
		registerToolset(swordSilver, shovelSilver, axeSilver, hoeSilver, pickaxeSilver);
		registerToolset(swordCopper, shovelCopper, axeCopper, hoeCopper, pickaxeCopper);
		registerToolset(swordZinc, shovelZinc, axeZinc, hoeZinc, pickaxeZinc);
		registerToolset(swordLead, shovelLead, axeLead, hoeLead, pickaxeLead);
		registerToolset(swordAluminum, shovelAluminum, axeAluminum, hoeAluminum, pickaxeAluminum);
		registerToolset(swordTitanium, shovelTitanium, axeTitanium, hoeTitanium, pickaxeTitanium);
		registerToolset(swordPlatinum, shovelPlatinum, axePlatinum, hoePlatinum, pickaxePlatinum);
		registerToolset(swordNickel, shovelNickel, axeNickel, hoeNickel, pickaxeNickel);
		registerToolset(swordTungsten, shovelTungsten, axeTungsten, hoeTungsten, pickaxeTungsten);
		registerToolset(swordCobalt, shovelCobalt, axeCobalt, hoeCobalt, pickaxeCobalt);
	}
	
	private static void registerToolset(Item sword, Item shovel, Item axe, Item hoe, Item pickaxe) {
    	GameRegistry.registerItem(sword, sword.getUnlocalizedName());
    	GameRegistry.registerItem(shovel, shovel.getUnlocalizedName());
    	GameRegistry.registerItem(axe, axe.getUnlocalizedName());
    	GameRegistry.registerItem(hoe, hoe.getUnlocalizedName());
    	GameRegistry.registerItem(pickaxe, pickaxe.getUnlocalizedName());
	}
}
