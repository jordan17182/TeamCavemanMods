package com.foodstuffs.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

import com.foodstuffs.block.BlockManager;
import com.foodstuffs.block.FSCrop;
import com.foodstuffs.lib.ModInfoLib;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemManager {
		
	//Meat
	public static Item baconRaw;
	public static Item baconCooked;
	public static Item duckRaw;

	//Veggies
	public static Item garlic;
	public static Item onion;
	public static Item bellPepperGreen;
	public static Item bellPepperRed;
	public static Item lettuce;
	public static Item spinach;
	public static Item celery;
	public static Item asparagus;
	public static Item rhubarb;
	public static Item bokChoy;
	public static Item brusselsSprout;
	public static Item cabbage;
	public static Item chicory;
	public static Item dill;
	public static Item kale;
	public static Item mustard;
	public static Item peas;
	public static Item turnip;
	
	//Grains
	//public static Item rice;

	//Fruits
	public static Item avocado;
	public static Item avocadoHalf;
	public static Item coconut;
	public static Item coconutHalf;
	public static Item banana;
	public static Item blackberry;
	public static Item orange;
	public static Item pineapple;
	public static Item raspberry;
	public static Item strawberry;
	public static Item lemon;
	public static Item lime;


	//Nuts
	public static Item almonds;

	//Foods
	public static Item sushi;
	public static Item breadButter;
	public static Item breadFrenchToast;
	public static Item breadSlice;
	public static Item butter;
	public static Item cheesesteak;
	public static Item iceCreamChocolate;
	public static Item iceCreamVanilla;
	public static Item muffinBlueberry;
	public static Item pieApple;
	public static Item pieBanana;
	public static Item pieBlackberry;
	public static Item pieBlueberry;
	public static Item pieChicken;
	public static Item pieLemon;
	public static Item pieLime;
	public static Item piePumpkin;
	public static Item pieRaspberry;
	public static Item pieStrawberry;
	public static Item pizza;
	public static Item pizzaSlice;
	public static Item porkSandwich;
	public static Item bearGummy;
	public static Item bearGummyVodka;
	
	//Other
	public static Item sugarBrown;

	//Misc
	public static Item knifeWooden;
	public static Item drinkingGlass;
	public static Item drinkingGlassFluid;
	public static Item bucketFluid;	
	public static Item barrelItem;
	
	//To Sort
	public static Item gourd;
	public static Item cucumber;
	public static Item eggplant;
	public static Item squash;
	public static Item tomatillo;
	public static Item tomato;
	public static Item vanilla;
	public static Item winterMelon;
	public static Item zucchini;
	public static Item artichoke;
	public static Item broccoli;
	public static Item caper;
	public static Item cauliflower;
	public static Item chickpea;
	public static Item garbonzo;
	public static Item greenBean;
	public static Item lentil;
	public static Item limaBean;
	public static Item peanut;
	public static Item snapPea;
	public static Item soybean;
	public static Item chives;
	public static Item leek;
	public static Item bambooShoot;
	public static Item ginger;
	public static Item horseradish;
	public static Item parsnip;
	public static Item radish;
	public static Item rutabaga;
	public static Item sweetPotato;
	public static Item turmeric;
	public static Item wasabi;
	public static Item waterChestnut;
	public static Item yam;
	
	public static ArrayList<Item> items = new ArrayList<>();

	
	//***Herbs and spices***//
	//allspice
	//anise
	//basil
	//bay leaf
	//caraway
	//cayenne pepper
	//chili pepper
	//chives
	//cilantro
	//cinnamon
	//clove
	//cumin
	//curry
	//dill
	//fennel
	//ginger
	//horseradish
	//lavender
	//mace
	//mint
	//mustard
	//paprika
	//parsley
	//pepper
	//peppermint
	//rosemary
	//saffron
	//sage
	//sassafras
	//spearmint
	//thyme
	//turmeric
	//vanilla
	//wasabi
	//watercress
	//wintergreen
	//
	public static void registerLate() {
    	items.add(new ItemFSCrop(3, 0.3f, false, "lateItem"));
    	GameRegistry.registerItem(items.get(0), items.get(0).getUnlocalizedName());
    }
	
    public static void mainRegistry() {
        initializeItem();
        registerItem();
        oreDictionary();
    }
 
    public static void initializeItem() {
    	//Seeds
    	//rice = new ItemFSSeeds("rice").setTextureName(ModInfoLib.MODID + ":rice");
    	
    	//Crops
    	garlic = new ItemFSCrop(3, 0.3f, false, "garlic").setTextureName(ModInfoLib.MODID + ":garlic");
    	onion = new ItemFSCrop(3, 0.3f, false, "onion").setTextureName(ModInfoLib.MODID + ":onion");
    	bellPepperGreen = new ItemFSCrop(3, 0.3f, false, "bellPepperGreen").setTextureName(ModInfoLib.MODID + ":bellPepperGreen");
    	bellPepperRed = new ItemFSCrop(3, 0.3f, false, "bellPepperRed").setTextureName(ModInfoLib.MODID + ":bellPepperRed");
    	lettuce = new ItemFSCrop(3, 0.3f, false, "lettuce").setTextureName(ModInfoLib.MODID + ":lettuce");
    	spinach = new ItemFSCrop(3, 0.3f, false, "spinach").setTextureName(ModInfoLib.MODID + ":spinach");
    	celery = new ItemFSCrop(3, 0.3f, false, "celery").setTextureName(ModInfoLib.MODID + ":celery");
    	asparagus = new ItemFSCrop(3, 0.3f, false, "asparagus").setTextureName(ModInfoLib.MODID + ":asparagus");
    	rhubarb = new ItemFSCrop(3, 0.3f, false, "rhubarb").setTextureName(ModInfoLib.MODID + ":rhubarb");
    	bokChoy = new ItemFSCrop(3, 0.3f, false, "bokChoy").setTextureName(ModInfoLib.MODID + ":bokChoy");
    	brusselsSprout = new ItemFSCrop(3, 0.3f, false, "brusselsSprout").setTextureName(ModInfoLib.MODID + ":brusselsSprout");
    	cabbage = new ItemFSCrop(3, 0.3f, false, "cabbage").setTextureName(ModInfoLib.MODID + ":cabbage");
    	chicory = new ItemFSCrop(3, 0.3f, false, "chicory").setTextureName(ModInfoLib.MODID + ":chicory");
    	dill = new ItemFSCrop(3, 0.3f, false, "dill").setTextureName(ModInfoLib.MODID + ":dill");
    	kale = new ItemFSCrop(3, 0.3f, false, "kale").setTextureName(ModInfoLib.MODID + ":kale");
    	mustard = new ItemFSCrop(3, 0.3f, false, "mustard").setTextureName(ModInfoLib.MODID + ":mustard");
    	peas = new ItemFSCrop(3, 0.3f, false, "peas").setTextureName(ModInfoLib.MODID + ":peas");
    	turnip = new ItemFSCrop(3, 0.3f, false, "turnip").setTextureName(ModInfoLib.MODID + ":turnip");
    	
    	//Foods
    	sushi = new FoodstuffsFood(6, 0.6f, false, "sushi").setTextureName(ModInfoLib.MODID + ":sushi");
    	baconRaw = new FoodstuffsFood(3, 0.3f, true, "baconRaw").setTextureName(ModInfoLib.MODID + ":rawBacon");
    	baconCooked = new FoodstuffsFood(6, 0.6f, true, "baconCooked").setTextureName(ModInfoLib.MODID + ":cookedBacon");
    	almonds = new FoodstuffsFood(3, 0.3f, false, "almonds").setTextureName(ModInfoLib.MODID + ":almonds");
    	avocado = new FoodstuffsFood(3, 0.3f, false, "avocado").setTextureName(ModInfoLib.MODID + ":avocado");
    	avocadoHalf = new FoodstuffsFood(3, 0.3f, false, "avocadoHalf").setTextureName(ModInfoLib.MODID + ":avocadoHalf");
    	breadButter = new FoodstuffsFood(3, 0.3f, false, "breadButter").setTextureName(ModInfoLib.MODID + ":breadButter");
    	breadFrenchToast = new FoodstuffsFood(3, 0.3f, false, "breadFrenchToast").setTextureName(ModInfoLib.MODID + ":breadFrenchToast");
    	breadSlice = new FoodstuffsFood(3, 0.3f, false, "breadSlice").setTextureName(ModInfoLib.MODID + ":breadSlice");
    	butter = new FoodstuffsFood(3, 0.3f, false, "butter").setTextureName(ModInfoLib.MODID + ":butterStick");
    	cheesesteak = new FoodstuffsFood(3, 0.3f, false, "cheesesteak").setTextureName(ModInfoLib.MODID + ":cheesesteak");
    	coconut = new FoodstuffsFood(3, 0.3f, false, "coconut").setTextureName(ModInfoLib.MODID + ":coconut");
    	coconutHalf = new FoodstuffsFood(3, 0.3f, false, "coconutHalf").setTextureName(ModInfoLib.MODID + ":coconutHalf");
    	duckRaw = new FoodstuffsFood(3, 0.3f, false, "duckRaw").setTextureName(ModInfoLib.MODID + ":duckRaw");
    	banana = new FoodstuffsFood(3, 0.3f, false, "banana").setTextureName(ModInfoLib.MODID + ":fruitBanana");
    	blackberry = new FoodstuffsFood(3, 0.3f, false, "blackberry").setTextureName(ModInfoLib.MODID + ":fruitBlackberry");
    	orange = new FoodstuffsFood(3, 0.3f, false, "orange").setTextureName(ModInfoLib.MODID + ":fruitOrange");
    	pineapple = new FoodstuffsFood(3, 0.3f, false, "pineapple").setTextureName(ModInfoLib.MODID + ":fruitPineapple");
    	raspberry = new FoodstuffsFood(3, 0.3f, false, "raspberry").setTextureName(ModInfoLib.MODID + ":fruitRaspberry");
    	strawberry = new FoodstuffsFood(3, 0.3f, false, "strawberry").setTextureName(ModInfoLib.MODID + ":fruitStrawberry");
    	iceCreamChocolate = new FoodstuffsFood(3, 0.3f, false, "iceCreamChocolate").setTextureName(ModInfoLib.MODID + ":iceCreamChocolate");
    	iceCreamVanilla = new FoodstuffsFood(3, 0.3f, false, "iceCreamVanilla").setTextureName(ModInfoLib.MODID + ":iceCreamVanilla");
    	lemon = new FoodstuffsFood(3, 0.3f, false, "lemon").setTextureName(ModInfoLib.MODID + ":lemon");
    	lime = new FoodstuffsFood(3, 0.3f, false, "lime").setTextureName(ModInfoLib.MODID + ":lime");
    	muffinBlueberry = new FoodstuffsFood(3, 0.3f, false, "muffinBlueberry").setTextureName(ModInfoLib.MODID + ":muffinBlueberry");
    	pieApple = new FoodstuffsFood(3, 0.3f, false, "pieApple").setTextureName(ModInfoLib.MODID + ":pieApple");
    	pieBanana = new FoodstuffsFood(3, 0.3f, false, "pieBanana").setTextureName(ModInfoLib.MODID + ":pieBananaCream");
    	pieBlackberry = new FoodstuffsFood(3, 0.3f, false, "pieBlackberry").setTextureName(ModInfoLib.MODID + ":pieBlackberry");
    	pieBlueberry = new FoodstuffsFood(3, 0.3f, false, "pieBlueberry").setTextureName(ModInfoLib.MODID + ":pieBlueberry");
    	pieChicken = new FoodstuffsFood(3, 0.3f, false, "pieChicken").setTextureName(ModInfoLib.MODID + ":pieChicken");
    	pieLemon = new FoodstuffsFood(3, 0.3f, false, "pieLemon").setTextureName(ModInfoLib.MODID + ":pieLemon");
    	pieLime = new FoodstuffsFood(3, 0.3f, false, "pieLime").setTextureName(ModInfoLib.MODID + ":pieLime");
    	piePumpkin = new FoodstuffsFood(3, 0.3f, false, "piePumpkin").setTextureName(ModInfoLib.MODID + ":piePumpkin");
    	pieRaspberry = new FoodstuffsFood(3, 0.3f, false, "pieRaspberry").setTextureName(ModInfoLib.MODID + ":pieRaspberry");
    	pieStrawberry = new FoodstuffsFood(3, 0.3f, false, "pieStrawberry").setTextureName(ModInfoLib.MODID + ":pieStrawberry");
    	pizza = new FoodstuffsFood(3, 0.3f, false, "pizza").setTextureName(ModInfoLib.MODID + ":pizza");
    	pizzaSlice = new FoodstuffsFood(3, 0.3f, false, "pizzaSlice").setTextureName(ModInfoLib.MODID + ":pizzaSlice");
    	porkSandwich = new FoodstuffsFood(3, 0.3f, false, "porkSandwich").setTextureName(ModInfoLib.MODID + ":pulled_pork_sandwhich");
    	sugarBrown = new FoodstuffsFood(3, 0.3f, false, "sugarBrown").setTextureName(ModInfoLib.MODID + ":sugarBrown");
    	knifeWooden = new ItemKnife(ToolMaterial.WOOD, "knifeWooden").setTextureName(ModInfoLib.MODID + ":pizza");
    	
    	
    	bearGummy = new FoodstuffsFood(3, 0.3f, false, "bearGummy").setTextureName(ModInfoLib.MODID + ":bearGummy");
    	bearGummyVodka = new FoodstuffsFood(3, 0.3f, false, "bearGummyVodka").setTextureName(ModInfoLib.MODID + ":bearGummyVodka");
    	gourd = new FoodstuffsFood(3, 0.3f, false, "gourd").setTextureName(ModInfoLib.MODID + ":gourd");
    	cucumber = new FoodstuffsFood(3, 0.3f, false, "cucumber").setTextureName(ModInfoLib.MODID + ":cucumber");
    	eggplant = new FoodstuffsFood(3, 0.3f, false, "eggplant").setTextureName(ModInfoLib.MODID + ":eggplant");
    	squash = new FoodstuffsFood(3, 0.3f, false, "squash").setTextureName(ModInfoLib.MODID + ":squash");
    	tomatillo = new FoodstuffsFood(3, 0.3f, false, "tomatillo").setTextureName(ModInfoLib.MODID + ":tomatillo");
    	tomato = new FoodstuffsFood(3, 0.3f, false, "tomato").setTextureName(ModInfoLib.MODID + ":tomato");
    	vanilla = new FoodstuffsFood(3, 0.3f, false, "vanilla").setTextureName(ModInfoLib.MODID + ":vanilla");
    	winterMelon = new FoodstuffsFood(3, 0.3f, false, "winterMelon").setTextureName(ModInfoLib.MODID + ":winterMelon");
    	zucchini = new FoodstuffsFood(3, 0.3f, false, "zucchini").setTextureName(ModInfoLib.MODID + ":zucchini");
    	artichoke = new FoodstuffsFood(3, 0.3f, false, "artichoke").setTextureName(ModInfoLib.MODID + ":artichoke");
    	broccoli = new FoodstuffsFood(3, 0.3f, false, "broccoli").setTextureName(ModInfoLib.MODID + ":broccoli");
    	caper = new FoodstuffsFood(3, 0.3f, false, "caper").setTextureName(ModInfoLib.MODID + ":caper");
    	cauliflower = new FoodstuffsFood(3, 0.3f, false, "cauliflower").setTextureName(ModInfoLib.MODID + ":cauliflower");
    	chickpea = new FoodstuffsFood(3, 0.3f, false, "chickpea").setTextureName(ModInfoLib.MODID + ":chickpea");
    	garbonzo = new FoodstuffsFood(3, 0.3f, false, "garbonzo").setTextureName(ModInfoLib.MODID + ":garbonzo");
    	greenBean = new FoodstuffsFood(3, 0.3f, false, "greenBean").setTextureName(ModInfoLib.MODID + ":greenBean");
    	lentil = new FoodstuffsFood(3, 0.3f, false, "lentil").setTextureName(ModInfoLib.MODID + ":lentil");
    	limaBean = new FoodstuffsFood(3, 0.3f, false, "limaBean").setTextureName(ModInfoLib.MODID + ":limaBean");
    	peanut = new FoodstuffsFood(3, 0.3f, false, "peanut").setTextureName(ModInfoLib.MODID + ":peanut");
    	snapPea = new FoodstuffsFood(3, 0.3f, false, "snapPea").setTextureName(ModInfoLib.MODID + ":snapPea");
    	soybean = new FoodstuffsFood(3, 0.3f, false, "soybean").setTextureName(ModInfoLib.MODID + ":soybean");
    	chives = new FoodstuffsFood(3, 0.3f, false, "chives").setTextureName(ModInfoLib.MODID + ":chives");
    	leek = new FoodstuffsFood(3, 0.3f, false, "leek").setTextureName(ModInfoLib.MODID + ":leek");
    	bambooShoot = new FoodstuffsFood(3, 0.3f, false, "bambooShoot").setTextureName(ModInfoLib.MODID + ":bambooShoot");
    	ginger = new FoodstuffsFood(3, 0.3f, false, "ginger").setTextureName(ModInfoLib.MODID + ":ginger");
    	horseradish = new FoodstuffsFood(3, 0.3f, false, "horseradish").setTextureName(ModInfoLib.MODID + ":horseradish");
    	parsnip = new FoodstuffsFood(3, 0.3f, false, "parsnip").setTextureName(ModInfoLib.MODID + ":parsnip");
    	radish = new FoodstuffsFood(3, 0.3f, false, "radish").setTextureName(ModInfoLib.MODID + ":radish");
    	rutabaga = new FoodstuffsFood(3, 0.3f, false, "rutabaga").setTextureName(ModInfoLib.MODID + ":rutabaga");
    	sweetPotato = new FoodstuffsFood(3, 0.3f, false, "sweetPotato").setTextureName(ModInfoLib.MODID + ":sweetPotato");
    	turmeric = new FoodstuffsFood(3, 0.3f, false, "turmeric").setTextureName(ModInfoLib.MODID + ":turmeric");
    	wasabi = new FoodstuffsFood(3, 0.3f, false, "wasabi").setTextureName(ModInfoLib.MODID + ":wasabi");
    	waterChestnut = new FoodstuffsFood(3, 0.3f, false, "waterChestnut").setTextureName(ModInfoLib.MODID + ":waterChestnut");
    	yam = new FoodstuffsFood(3, 0.3f, false, "yam").setTextureName(ModInfoLib.MODID + ":yam");
    	
    	
    	
    	barrelItem = new ItemBarrel("barrelItem", BlockManager.barrel).setTextureName(ModInfoLib.MODID+ ":barrel");
    	
    	drinkingGlass = new FoodstuffsItem("drinkingGlass").setTextureName(ModInfoLib.MODID + ":cupEmpty");
    	
		drinkingGlassFluid = new ItemDrinkingGlass(1, 0.3F, false).setUnlocalizedName("drinkingGlassFluid");
		bucketFluid = new ItemBucketDrink().setUnlocalizedName("bucketFluid");
    }
 
    public static void registerItem() {
    	    	
    	GameRegistry.registerItem(sushi, sushi.getUnlocalizedName());
    	//GameRegistry.registerItem(rice, rice.getUnlocalizedName());
    	GameRegistry.registerItem(baconRaw, baconRaw.getUnlocalizedName());
    	GameRegistry.registerItem(baconCooked, baconCooked.getUnlocalizedName());
    	GameRegistry.registerItem(almonds, almonds.getUnlocalizedName());
    	GameRegistry.registerItem(avocado, avocado.getUnlocalizedName());
    	GameRegistry.registerItem(avocadoHalf, avocadoHalf.getUnlocalizedName());
    	GameRegistry.registerItem(breadButter, breadButter.getUnlocalizedName());
    	GameRegistry.registerItem(breadFrenchToast, breadFrenchToast.getUnlocalizedName());
    	GameRegistry.registerItem(breadSlice, breadSlice.getUnlocalizedName());
    	GameRegistry.registerItem(butter, butter.getUnlocalizedName());
    	GameRegistry.registerItem(cheesesteak, cheesesteak.getUnlocalizedName());
    	GameRegistry.registerItem(coconut, coconut.getUnlocalizedName());
    	GameRegistry.registerItem(coconutHalf, coconutHalf.getUnlocalizedName());
    	GameRegistry.registerItem(duckRaw, duckRaw.getUnlocalizedName());
    	GameRegistry.registerItem(banana, banana.getUnlocalizedName());
    	GameRegistry.registerItem(blackberry, blackberry.getUnlocalizedName());
    	GameRegistry.registerItem(orange, orange.getUnlocalizedName());
    	GameRegistry.registerItem(pineapple, pineapple.getUnlocalizedName());
    	GameRegistry.registerItem(raspberry, raspberry.getUnlocalizedName());
    	GameRegistry.registerItem(strawberry, strawberry.getUnlocalizedName());
    	GameRegistry.registerItem(iceCreamChocolate, iceCreamChocolate.getUnlocalizedName());
    	GameRegistry.registerItem(iceCreamVanilla, iceCreamVanilla.getUnlocalizedName());
    	GameRegistry.registerItem(lemon, lemon.getUnlocalizedName());
    	GameRegistry.registerItem(lime, lime.getUnlocalizedName());
    	GameRegistry.registerItem(muffinBlueberry, muffinBlueberry.getUnlocalizedName());
    	GameRegistry.registerItem(pieApple, pieApple.getUnlocalizedName());
    	GameRegistry.registerItem(pieBanana, pieBanana.getUnlocalizedName());
    	GameRegistry.registerItem(pieBlueberry, pieBlueberry.getUnlocalizedName());
    	GameRegistry.registerItem(pieChicken, pieChicken.getUnlocalizedName());
    	GameRegistry.registerItem(pieLemon, pieLemon.getUnlocalizedName());
    	GameRegistry.registerItem(pieLime, pieLime.getUnlocalizedName());
    	GameRegistry.registerItem(piePumpkin, piePumpkin.getUnlocalizedName());
    	GameRegistry.registerItem(pieRaspberry, pieRaspberry.getUnlocalizedName());
    	GameRegistry.registerItem(pieStrawberry, pieStrawberry.getUnlocalizedName());
    	GameRegistry.registerItem(pizza, pizza.getUnlocalizedName());
    	GameRegistry.registerItem(pizzaSlice, pizzaSlice.getUnlocalizedName());
    	GameRegistry.registerItem(porkSandwich, porkSandwich.getUnlocalizedName());
    	GameRegistry.registerItem(sugarBrown, sugarBrown.getUnlocalizedName());
    	GameRegistry.registerItem(knifeWooden, knifeWooden.getUnlocalizedName());
    	GameRegistry.registerItem(garlic, garlic.getUnlocalizedName());
    	GameRegistry.registerItem(onion, onion.getUnlocalizedName());
    	GameRegistry.registerItem(bellPepperGreen, bellPepperGreen.getUnlocalizedName());
    	GameRegistry.registerItem(bellPepperRed, bellPepperRed.getUnlocalizedName());
    	GameRegistry.registerItem(lettuce, lettuce.getUnlocalizedName());
    	GameRegistry.registerItem(spinach, spinach.getUnlocalizedName());
    	GameRegistry.registerItem(celery, celery.getUnlocalizedName());
    	GameRegistry.registerItem(asparagus, asparagus.getUnlocalizedName());
    	GameRegistry.registerItem(rhubarb, rhubarb.getUnlocalizedName());
    	GameRegistry.registerItem(bokChoy, bokChoy.getUnlocalizedName());
    	GameRegistry.registerItem(brusselsSprout, brusselsSprout.getUnlocalizedName());
    	GameRegistry.registerItem(cabbage, cabbage.getUnlocalizedName());
    	GameRegistry.registerItem(chicory, chicory.getUnlocalizedName());
    	GameRegistry.registerItem(dill, dill.getUnlocalizedName());
    	GameRegistry.registerItem(kale, kale.getUnlocalizedName());
    	GameRegistry.registerItem(mustard, mustard.getUnlocalizedName());
    	GameRegistry.registerItem(peas, peas.getUnlocalizedName());
    	GameRegistry.registerItem(turnip, turnip.getUnlocalizedName());
    	GameRegistry.registerItem(bearGummy, bearGummy.getUnlocalizedName());
    	GameRegistry.registerItem(bearGummyVodka, bearGummyVodka.getUnlocalizedName());
    	GameRegistry.registerItem(gourd, gourd.getUnlocalizedName());
    	GameRegistry.registerItem(cucumber, cucumber.getUnlocalizedName());
    	GameRegistry.registerItem(eggplant, eggplant.getUnlocalizedName());
    	GameRegistry.registerItem(squash, squash.getUnlocalizedName());
    	GameRegistry.registerItem(tomatillo, tomatillo.getUnlocalizedName());
    	GameRegistry.registerItem(tomato, tomato.getUnlocalizedName());
    	GameRegistry.registerItem(vanilla, vanilla.getUnlocalizedName());
    	GameRegistry.registerItem(winterMelon, winterMelon.getUnlocalizedName());
    	GameRegistry.registerItem(zucchini, zucchini.getUnlocalizedName());
    	GameRegistry.registerItem(artichoke, artichoke.getUnlocalizedName());
    	GameRegistry.registerItem(broccoli, broccoli.getUnlocalizedName());
    	GameRegistry.registerItem(caper, caper.getUnlocalizedName());
    	GameRegistry.registerItem(cauliflower, cauliflower.getUnlocalizedName());
    	GameRegistry.registerItem(chickpea, chickpea.getUnlocalizedName());
    	GameRegistry.registerItem(garbonzo, garbonzo.getUnlocalizedName());
    	GameRegistry.registerItem(greenBean, greenBean.getUnlocalizedName());
    	GameRegistry.registerItem(lentil, lentil.getUnlocalizedName());
    	GameRegistry.registerItem(limaBean, limaBean.getUnlocalizedName());
    	GameRegistry.registerItem(peanut, peanut.getUnlocalizedName());
    	GameRegistry.registerItem(snapPea, snapPea.getUnlocalizedName());
    	GameRegistry.registerItem(soybean, soybean.getUnlocalizedName());
    	GameRegistry.registerItem(chives, chives.getUnlocalizedName());
    	GameRegistry.registerItem(leek, leek.getUnlocalizedName());
    	GameRegistry.registerItem(bambooShoot, bambooShoot.getUnlocalizedName());
    	GameRegistry.registerItem(ginger, ginger.getUnlocalizedName());
    	GameRegistry.registerItem(horseradish, horseradish.getUnlocalizedName());
    	GameRegistry.registerItem(parsnip, parsnip.getUnlocalizedName());
    	GameRegistry.registerItem(radish, radish.getUnlocalizedName());
    	GameRegistry.registerItem(rutabaga, rutabaga.getUnlocalizedName());
    	GameRegistry.registerItem(sweetPotato, sweetPotato.getUnlocalizedName());
    	GameRegistry.registerItem(turmeric, turmeric.getUnlocalizedName());
    	GameRegistry.registerItem(wasabi, wasabi.getUnlocalizedName());
    	GameRegistry.registerItem(waterChestnut, waterChestnut.getUnlocalizedName());
    	GameRegistry.registerItem(yam, yam.getUnlocalizedName());
    	
    	
    	
    	
    	GameRegistry.registerItem(barrelItem, barrelItem.getUnlocalizedName());
    	
    	GameRegistry.registerItem(drinkingGlass, drinkingGlass.getUnlocalizedName());
    	GameRegistry.registerItem(drinkingGlassFluid, drinkingGlassFluid.getUnlocalizedName());
    	GameRegistry.registerItem(bucketFluid, bucketFluid.getUnlocalizedName());
    }
    public static void oreDictionary() {
    	//OreDictionary.registerOre("cropRice", rice);
    }
 
}