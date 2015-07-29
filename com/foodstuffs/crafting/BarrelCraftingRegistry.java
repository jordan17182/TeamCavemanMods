package com.foodstuffs.crafting;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class BarrelCraftingRegistry {

	private ArrayList<ArrayList<ItemStack>> recipeList;
	private ArrayList<Integer> recipeResult;
	
	public BarrelCraftingRegistry() {
		recipeList = new ArrayList<ArrayList<ItemStack>>();
		recipeResult = new ArrayList<Integer>();
	}
	
	public boolean addDrinkRecipe(int fluidType, Object ... ing) {
		boolean status = false;
		/**if(ing.size() <= 4) {
			recipeList.add(ing);
			recipeResult.add(fluidType);
			status = true;
		}**/
		return status;
	}

	public void addDrinkRecipe(int fluidType, boolean fermentable, int fermentTime, Object ... ing) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkRecipe(Object ... ing) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getDrinkResult(Object ... ing) {
		// TODO Auto-generated method stub
		return 0;
	}

}
