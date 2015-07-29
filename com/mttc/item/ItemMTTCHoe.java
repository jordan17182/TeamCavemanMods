package com.mttc.item;

import net.minecraft.item.ItemHoe;

import com.mttc.MTTCMod;
import com.mttc.lib.ModInfoLib;

public class ItemMTTCHoe extends ItemHoe
{
    public ItemMTTCHoe(ToolMaterial material, String unlocalizedName)
    {
    	super(material);
    	this.setUnlocalizedName(unlocalizedName);
  		this.setTextureName(ModInfoLib.MODID + ":" + unlocalizedName);
  		this.setCreativeTab(MTTCMod.mttcTab);
    }
}