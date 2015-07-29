package com.caveman.genetics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.foodstuffs.container.BlockBarrelContainer;
import com.foodstuffs.tileentity.TileEntityBarrel;

import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {
	// returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		switch (id) {
		case 0:
			return new ContainerGrafter(player.inventory, new InventoryGrafter(null));
		default:
			return null;
		}
	}

	// returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		switch (id) {
		case 0:
			return new GuiGrafter(player.inventory, new InventoryGrafter(null));
		default:
			return null;
		}
	}
}