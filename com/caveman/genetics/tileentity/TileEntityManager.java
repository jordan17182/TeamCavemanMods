package com.caveman.genetics.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityManager {

	public static void mainRegistry() {
		GameRegistry.registerTileEntity(TileEntityPlant.class, "tksPlant");		
	}

}
