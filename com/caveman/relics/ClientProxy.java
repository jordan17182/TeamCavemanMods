package com.tks.relics;

import com.foodstuffs.render.TileEntityBarrelRender;
import com.foodstuffs.tileentity.TileEntityBarrel;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy {

	@Override
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, new TileEntityBarrelRender());
	}
}
