package com.caveman.genetics.misc;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.caveman.genetics.item.ItemManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class GeneticsTab extends CreativeTabs {
	private String label;
	
	public GeneticsTab(String label) {
	    super(label);
	    this.label = label;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return ItemManager.dnaSample;
	}
	
	@SideOnly(Side.CLIENT)
    @Override
	public void displayAllReleventItems(List itemList) {
       /**  
        ItemStack nbtItem01 = new ItemStack(ItemManager.NBTItem);
        nbtItem01.addEnchantment(Enchantment.silkTouch, 1);
        itemList.add(string);
 
        //Adds wooden hoe
        itemList.add(new ItemStack(Items.wooden_hoe));
         
        //Adds all fishing enchantments
        this.addEnchantmentBooksToList(itemList, new EnumEnchantmentType[] { EnumEnchantmentType.fishing_rod});
        **/
    }
	
}