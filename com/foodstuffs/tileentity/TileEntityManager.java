package com.foodstuffs.tileentity;

import com.mttc.tileentity.TileBlastFurnace;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityManager {

	public static void mainRegistry() {
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "barrel");	
	}

}
