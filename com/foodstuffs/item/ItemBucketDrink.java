package com.foodstuffs.item;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import com.foodstuffs.FoodstuffsMod;
import com.foodstuffs.lib.ModInfoLib;
import com.foodstuffs.misc.DrinkRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBucketDrink extends Item {
    @SideOnly(Side.CLIENT)
    private IIcon cupFill;
    @SideOnly(Side.CLIENT)
    private IIcon cupEdge;
	
    
	public ItemBucketDrink() {
		super();
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
        this.setCreativeTab(FoodstuffsMod.foodTab);
    }
	
    @Override
    public String getItemStackDisplayName(ItemStack par1ItemStack)
    {
    	 return "Bucket of " + DrinkRegistry.getFluidName(par1ItemStack.getItemDamage());
    }
    
    @SideOnly(Side.CLIENT)
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	par3List = new ArrayList(DrinkRegistry.getBucketList());
    }
    

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList) {
        for (int i = 0; i < DrinkRegistry.getBucketList().size(); ++i) {
            itemList.add(new ItemStack(ItemManager.bucketFluid, 1, i));
        }
    }
    
    
    @SideOnly(Side.CLIENT)
    public int getColorFromDamage(int par1)
    {
        return PotionHelper.func_77915_a(par1, false);
    }
    
    @Override
    public IIcon getIconFromDamageForRenderPass(int par1, int par2)
    {
        return par2 == 0 ? this.cupFill : this.cupEdge;
    }
    
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return par2 > 0 ? 16777215 : DrinkRegistry.getFluidColor(par1ItemStack.getItemDamage());
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.cupEdge = par1IconRegister.registerIcon(ModInfoLib.MODID + ":bucketEdge");
        this.cupFill = par1IconRegister.registerIcon(ModInfoLib.MODID + ":bucketFill");
    }
}