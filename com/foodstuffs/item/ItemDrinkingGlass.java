package com.foodstuffs.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.foodstuffs.FoodstuffsMod;
import com.foodstuffs.lib.ModInfoLib;
import com.foodstuffs.misc.DrinkRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDrinkingGlass extends ItemFood {
    @SideOnly(Side.CLIENT)
    private IIcon cupFill;
    @SideOnly(Side.CLIENT)
    private IIcon cupEdge;
	
    
	public ItemDrinkingGlass(int par2, float par3, boolean par4) {
		super(par2, par3, par4);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
        this.setCreativeTab(FoodstuffsMod.foodTab);
    }

    
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.getFoodStats().func_151686_a(this, par1ItemStack);
        par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        if (!par2World.isRemote) {
        	
        }
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            if (par1ItemStack.stackSize <= 0) {
                return new ItemStack(ItemManager.drinkingGlass);
            }
            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemManager.drinkingGlass));
        }
        return par1ItemStack;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.drink;
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack par1ItemStack)
    {
        return "Cup of " + DrinkRegistry.getFluidName(par1ItemStack.getItemDamage());
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList) {
        for (int i = 0; i < DrinkRegistry.getCupList().size(); ++i) {
            itemList.add(new ItemStack(ItemManager.drinkingGlassFluid, 1, i));
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
        this.cupEdge = par1IconRegister.registerIcon(ModInfoLib.MODID + ":cupEdge");
        this.cupFill = par1IconRegister.registerIcon(ModInfoLib.MODID + ":cupFill");
    }
}