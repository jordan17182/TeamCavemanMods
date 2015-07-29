package com.mttc.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.mttc.container.BlockKilnContainer;
import com.mttc.lib.ModInfoLib;
import com.mttc.tileentity.TileKiln;

public class BlockKilnGUI extends GuiContainer {

	private static final ResourceLocation guiTexture = new ResourceLocation(ModInfoLib.MODID + ":textures/gui/guiKiln.png");
	private TileKiln kiln;
	private int x;
	private int y;
	
	public BlockKilnGUI(InventoryPlayer inventoryPlayer, TileKiln tileEntity) {
		super(new BlockKilnContainer(inventoryPlayer, tileEntity));
		this.kiln = tileEntity;
	}
	
	@Override
    public void initGui() {
            super.initGui();
    }
	
    @Override
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
    	super.drawScreen(p_73863_1_, p_73863_2_,p_73863_3_);
    }
    
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRendererObj.drawString("Kiln", 8, 6, 4210752);
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
		
		//HoverText
		//if (this.kiln.getFluidVolume() > 0 && this.func_146978_c(102, 8, 34, 80, param1, param2)) {
		//	List fluidName = new ArrayList();
		//	fluidName.add(DrinkRegistry.getFluidName(this.barrel.getFluidType())+ " " + this.barrel.getFluidVolume() + "/" + this.barrel.getMaxVolume());
		//	drawHoveringText(fluidName, param1 - (width - xSize) / 2, param2
		//			- (height - ySize) / 2, fontRendererObj);
		//}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		x = (width - xSize) / 2;
		y = (height - ySize) / 2;
		
		this.drawMainTexture();
		this.drawTexturedModalRect(x + 81, y + 29, 176, 14, 16, 1);

		/**
		if (this.barrel.isFilled()) {
			double tempVY = (80 * ((double) this.barrel.getFluidVolume() / (double) this.barrel.getMaxVolume()));

			int fluidColor = DrinkRegistry.getFluidColor(this.barrel.getFluidType());
			float red = (float) (fluidColor >> 16 & 255) / 255.0F;
			float green = (float) (fluidColor >> 8 & 255) / 255.0F;
			float blue = (float) (fluidColor & 255) / 255.0F;
			GL11.glColor4f(red, green, blue, 0.2f);
			this.drawTexturedModalRect(x + 102, y + 88 - (int) tempVY, 176, 97 - (int) tempVY, 34, (int) tempVY);
		}**/

	}
	
	private void drawMainTexture() {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(guiTexture);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}