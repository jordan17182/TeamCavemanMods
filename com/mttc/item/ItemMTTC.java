package com.mttc.item;

import net.minecraft.item.Item;

import com.mttc.lib.ModInfoLib;
import com.mttc.MTTCMod;

public class ItemMTTC extends Item {
	
	public ItemMTTC(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(ModInfoLib.MODID + ":" + unlocalizedName);
		this.setCreativeTab(MTTCMod.mttcTab);
	}
}
