package com.mttc.item;

import net.minecraft.item.ItemSword;

import com.mttc.MTTCMod;
import com.mttc.lib.ModInfoLib;

public class ItemMTTCSword extends ItemSword
{
    public ItemMTTCSword(ToolMaterial material, String unlocalizedName)
    {
    	super(material);
        this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(ModInfoLib.MODID + ":" + unlocalizedName);
		this.setCreativeTab(MTTCMod.mttcTab);
    }
}