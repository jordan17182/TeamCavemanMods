package com.mttc.item;

import net.minecraft.item.ItemSpade;

import com.mttc.MTTCMod;
import com.mttc.lib.ModInfoLib;

public class ItemMTTCSpade extends ItemSpade
{
    public ItemMTTCSpade(ToolMaterial material, String unlocalizedName)
    {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(ModInfoLib.MODID + ":" + unlocalizedName);
		this.setCreativeTab(MTTCMod.mttcTab);
    }
}