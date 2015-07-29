package com.mttc.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mttc.container.BlockKilnContainer;
import com.mttc.tileentity.TileKiln;

import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		switch (id) {
		case 0:
			return new BlockKilnContainer(player.inventory, (TileKiln) tileEntity);
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		switch (id) {
		case 0:
			return new BlockKilnGUI(player.inventory, (TileKiln) tileEntity);
		default:
			return null;
		}
	}
}