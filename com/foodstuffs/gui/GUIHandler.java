package com.foodstuffs.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.foodstuffs.container.BlockBarrelContainer;
import com.foodstuffs.tileentity.TileEntityBarrel;

import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {
	// returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		switch (id) {
		case 0:
			return new BlockBarrelContainer(player.inventory,
					(TileEntityBarrel) tileEntity);
		//case 1:
			//return new ContainerBetterTable(player.inventory,
				//	world, x, y, z);
		default:
			return null;
		}
	}

	// returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		switch (id) {
		case 0:
			return new BlockBarrelGUI(player.inventory,
					(TileEntityBarrel) tileEntity);
		//case 1:
			//return new BetterTableGui(player.inventory,
				//	world, x, y, z);
		default:
			return null;
		}
	}
}