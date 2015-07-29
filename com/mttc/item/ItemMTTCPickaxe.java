package com.mttc.item;

import net.minecraft.item.ItemPickaxe;

import com.mttc.MTTCMod;
import com.mttc.lib.ModInfoLib;

public class ItemMTTCPickaxe extends ItemPickaxe
{
    public ItemMTTCPickaxe(ToolMaterial material, String unlocalizedName)
    {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(ModInfoLib.MODID + ":" + unlocalizedName);
		this.setCreativeTab(MTTCMod.mttcTab);
    }
}