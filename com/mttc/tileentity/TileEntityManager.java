package com.mttc.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityManager {

	public static void mainRegistry() {
		GameRegistry.registerTileEntity(TileBlastFurnace.class, "multiBlock");
		GameRegistry.registerTileEntity(TileEntityConveyer.class, "conveyer");	
	}

}
