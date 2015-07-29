package com.mttc.item;

import com.mttc.MTTCMod;
import com.mttc.lib.ModInfoLib;

import net.minecraft.item.ItemAxe;

public class ItemMTTCAxe extends ItemAxe
{
    public ItemMTTCAxe(ToolMaterial material, String unlocalizedName)
    {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(ModInfoLib.MODID + ":" + unlocalizedName);
		this.setCreativeTab(MTTCMod.mttcTab);
    }
}