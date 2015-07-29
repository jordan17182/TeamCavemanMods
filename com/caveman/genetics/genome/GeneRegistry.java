package com.caveman.genetics.genome;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.item.ItemStack;

public class GeneRegistry {

	public enum Kingdom {
		PLANT, FUNGI, ANIMAL
	};
	
	private TraitParser parser = new TraitParser();
	private BaseSeqGen baseGen = new BaseSeqGen();
	private Map<String, Trait> plantTraits;
	private Map<String, Trait> fungiTraits;
	private Map<String, Trait> animalTraits;
	
	public GeneRegistry() {
		plantTraits = new HashMap<>();
		fungiTraits = new HashMap<>();
		animalTraits = new HashMap<>();
		createPlantTraits();
		createPlantGenes();
	}

	public String generateNewGenome(ItemStack item) {

		return null;
	}

	private void createPlantTraits() {
		registerTrait(Kingdom.PLANT,"species","Species");
		registerTrait(Kingdom.PLANT,"treeLog","Log Type");
		registerTrait(Kingdom.PLANT,"treeLeaf","Leaf Type");
		registerTrait(Kingdom.PLANT,"crop","Crop");
		registerTrait(Kingdom.PLANT,"cropColOne","Crop Primary Color (outside)");
		registerTrait(Kingdom.PLANT,"cropColTwo","Crop Secondary Color (inside)");
		registerTrait(Kingdom.PLANT,"cropPrev","Crop Drop Chance");
		registerTrait(Kingdom.PLANT,"cropMax","Crop Max. Quantity");
		registerTrait(Kingdom.PLANT,"cropMin","Crop Min. Quantity");
		registerTrait(Kingdom.PLANT,"cropWeight","Crop Quantity Weighting");
		registerTrait(Kingdom.PLANT,"cropHarvest","Crop Harvest without destroying plant");
		registerTrait(Kingdom.PLANT,"cropTool","Tool required for crop harvesting");
		registerTrait(Kingdom.PLANT,"cropAutHarv","Crop Auto-Harvest");
		registerTrait(Kingdom.PLANT,"cropAHMax","Auto-Harvest Max. Delay");
		registerTrait(Kingdom.PLANT,"cropAHMin","Auto-Harvest Min. Delay");
		registerTrait(Kingdom.PLANT,"cropSeed","Crop is Seed");
		registerTrait(Kingdom.PLANT,"seedItem","Seed Item");
		registerTrait(Kingdom.PLANT,"seedPrev","Seed Drop Chance");
		registerTrait(Kingdom.PLANT,"seedMax","Seed Max. Quantity");
		registerTrait(Kingdom.PLANT,"seedMin","Seed Min. Quantity");
		registerTrait(Kingdom.PLANT,"seedWeight","Seed Quantity Weighting");
		registerTrait(Kingdom.PLANT,"seedAutDrop","Seed Auto-Drop");
		registerTrait(Kingdom.PLANT,"seedADMax","Auto-Drop Max. Delay");
		registerTrait(Kingdom.PLANT,"seedADMin","Auto-Drop Min. Delay");
		registerTrait(Kingdom.PLANT,"seedAutPlant","Seed Auto-Plant");
		registerTrait(Kingdom.PLANT,"seedAPMax","Auto-Plant Max. Delay");
		registerTrait(Kingdom.PLANT,"seedAPMin","Auto-Plant Min. Delay");
		registerTrait(Kingdom.PLANT,"spread","Plant Spread");
		registerTrait(Kingdom.PLANT,"spreadMax","Spread Max. Delay");
		registerTrait(Kingdom.PLANT,"spreadMin","Spread Min. Delay");
		registerTrait(Kingdom.PLANT,"spreadType","Spread Type");
		registerTrait(Kingdom.PLANT,"flowering","Plant Flowers");
		registerTrait(Kingdom.PLANT,"flowerType","Flower Type");
		registerTrait(Kingdom.PLANT,"flowerColor","Flower Color");
		registerTrait(Kingdom.PLANT,"fertalizeable","Plant Fertalizable");
		registerTrait(Kingdom.PLANT,"plantBlockCond","Planting Block Conditions");
		registerTrait(Kingdom.PLANT,"growSpeed","Growth Speed");
		registerTrait(Kingdom.PLANT,"passiveDeffense","Passive Deffense");
		registerTrait(Kingdom.PLANT,"fire","Flaming");
		registerTrait(Kingdom.PLANT,"lightBreak","Light Level Restriction");
		registerTrait(Kingdom.PLANT,"lightLimit","Light Level");
	}
	
	private void createPlantGenes() {
		registerGene(Kingdom.PLANT, "treeLog", "oak", "Oak", 10, -6f);
		registerGene(Kingdom.PLANT, "treeLog", "drkOak", "Dark Oak", 10, -6f);
		registerGene(Kingdom.PLANT, "treeLog", "birch", "Birch", 2, 8f);
		registerGene(Kingdom.PLANT, "treeLog", "spruce", "Spruce", 10, -6f);
		registerGene(Kingdom.PLANT, "treeLog", "jungle", "Jungle", 10, -6f);
		registerGene(Kingdom.PLANT, "treeLog", "acacia", "Acacia", 10, -6f);
	}
	
	private boolean registerTrait(Kingdom kingdom, String traitID, String traitDispName) {
		if(kingdom.equals(Kingdom.PLANT)) {
			plantTraits.put(traitID, parser.parseTrait(kingdom, traitID, traitDispName));
			return true;
		} else if(kingdom.equals(Kingdom.FUNGI)) {
			fungiTraits.put(traitID, parser.parseTrait(kingdom, traitID, traitDispName));
			return true;
		} else if(kingdom.equals(Kingdom.ANIMAL)) {
			animalTraits.put(traitID, parser.parseTrait(kingdom, traitID, traitDispName));
			return true;
		} else {
			return false;
		}
	}
	
	private boolean registerGene(Kingdom kingdom, String traitID, String geneID, String geneDisplayName, int prevalence, float dominance) {
		if(kingdom.equals(Kingdom.PLANT) && plantTraits.containsKey(traitID)) {
			plantTraits.get(traitID).addGene(geneID, prevalence, dominance);
			return true;
		} else if(kingdom.equals(Kingdom.FUNGI) && fungiTraits.containsKey(traitID)) {
			fungiTraits.get(traitID).addGene(geneID, prevalence, dominance);
			return true;
		} else if(kingdom.equals(Kingdom.ANIMAL) && animalTraits.containsKey(traitID)) {
			animalTraits.get(traitID).addGene(geneID, prevalence, dominance);
			return true;
		} else {
			return false;
		}
	}

}
