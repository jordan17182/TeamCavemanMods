package com.foodstuffs.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.foodstuffs.container.BlockBarrelContainer;
import com.foodstuffs.misc.DrinkRegistry;
import com.foodstuffs.tileentity.TileEntityBarrel;

public class BlockBarrelGUI extends GuiContainer {

	private static final ResourceLocation guiTexture = new ResourceLocation(
			"foodstuffs:textures/gui/guiBarrel.png");
	private TileEntityBarrel barrel;

	public BlockBarrelGUI(InventoryPlayer inventoryPlayer,
			TileEntityBarrel tileEntity) {
		// the container is instanciated and passed to the superclass for
		// handling
		super(new BlockBarrelContainer(inventoryPlayer, tileEntity));
		ySize = 176;
		this.barrel = tileEntity;
	}
	
	@Override
    public void initGui() {
            super.initGui();
            //make buttons
            //id, x, y, width, height, text
            buttonList.add(new GuiButton(1, width/2-10, height/2-25, 20, 20, "Mix"));
    }
	@Override
    protected void actionPerformed(GuiButton guibutton) {
            //id is the id you give your button
            switch(guibutton.id) {
            case 1:
            	barrel.setMixing();
            }
            //Packet code here
            //PacketDispatcher.sendPacketToServer(packet); //send packet
    }
    @Override
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
    	GuiButton tempButton = (GuiButton)buttonList.get(0);
    	tempButton.enabled = barrel.canMix();
    	buttonList.set(0, tempButton);
    	super.drawScreen(p_73863_1_, p_73863_2_,p_73863_3_);
    }
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		// draw text and stuff here
		// the parameters for drawString are: string, x, y, color
		fontRendererObj.drawString("Barrel", 8, 6, 4210752);

		// draws "Inventory" or your regional equivalent
		fontRendererObj.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				ySize - 96 + 2, 4210752);
		if (this.barrel.getFluidVolume() > 0
				&& this.func_146978_c(102, 8, 34, 80, param1, param2)) {
			List fluidName = new ArrayList();
			fluidName
					.add(DrinkRegistry.getFluidName(this.barrel.getFluidType())
							+ " " + this.barrel.getFluidVolume() + "/"
							+ this.barrel.getMaxVolume());
			drawHoveringText(fluidName, param1 - (width - xSize) / 2, param2
					- (height - ySize) / 2, fontRendererObj);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3) {
		// draw your Gui here, only thing you need to change is the path
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(guiTexture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

		if (this.barrel.isFilled()) {
			double tempVY = (80 * ((double) this.barrel.getFluidVolume() / (double) this.barrel
					.getMaxVolume()));

			int fluidColor = DrinkRegistry.getFluidColor(this.barrel
					.getFluidType());
			float red = (float) (fluidColor >> 16 & 255) / 255.0F;
			float green = (float) (fluidColor >> 8 & 255) / 255.0F;
			float blue = (float) (fluidColor & 255) / 255.0F;
			GL11.glColor4f(red, green, blue, 0.2f);
			this.drawTexturedModalRect(x + 102, y + 88 - (int) tempVY, 176,
					97 - (int) tempVY, 34, (int) tempVY);
		}

	}

}