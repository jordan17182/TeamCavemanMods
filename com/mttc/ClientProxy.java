package com.mttc;

import com.mttc.render.TileEntityConveyerRender;
import com.mttc.tileentity.TileEntityConveyer;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy {

	@Override
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyer.class, new TileEntityConveyerRender());
	}
}
