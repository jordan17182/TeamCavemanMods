package com.caveman.genetics.tileentity;

public class PlantEnums {
	//Generic Traits
	public static enum TraitType {Doninant, Recessive};
	
	public static enum SeedType {Sappling, Seed, Tuber, Fungus, Nether, Pods, Reed, Cactus, Flower, Crawler, Aqua};
	
	public static enum PlantType {Tree, Grain, Tuber, Flower, Vine, Melon, Aqua, Pillar, Fungus};
	public static enum CropType {None, Fruit, Grain, Tuberous, Fungus, Pod};
	public static enum Harvestability {None, Shears, All};
	public static enum Spread {None, Vertical, Horizontal};
	public static enum Planting {Tilled, Dirt, Water, JungleWood, Wood, SoulSand, Sand};
	public static enum BreakType {None, Min, Max, Clamped};
	public static enum PlantOrientation {Above, Beside};
	public static enum Deffence {None, Thorn, Poison, PoisonThorn, Nausia};
	
	//Crop Traits
	public static enum CropForm {None, Apple, Melon, Pumpkin, Potato, Carrot, Wheat, BrownShroom, RedShroom, NetherWart, CocoaBean};
	public static enum CropColor {None, Red, Yellow, Orange, DkRed, Tan, LtGreen, Brown, LtBrown, YlwGreen};

	//Tree Traits
	public static enum LeafTexture {None, Oak, Birch, Spruce, Jungle, Acia, DarkOak};
	//Normal is oak and birch
	public static enum TreeShape {None, Normal, Large, Tall, Giant};
	public static enum WoodType {None, Oak, Birch, Spruce, Jungle, Acia, DarkOak};
	public static enum ChopType {None, Normal, Tippy};
	
	//Flower Traits
	public static enum FlowerColor {Black, Red, Green, Brwon, Blue, Purple, Cyan, LtGray, Gray, Pink, Lime, Yellow, LtBlue, Magenta, Orange, White};
}
