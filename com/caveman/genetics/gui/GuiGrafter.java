package com.caveman.genetics.gui;

import org.lwjgl.opengl.GL11;

import com.caveman.genetics.lib.ModInfoLib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiGrafter extends GuiContainer {

	EntityPlayer player;
	ContainerGrafter container;
	
	public GuiGrafter(InventoryPlayer playerInv, InventoryGrafter graftInv) {
		super(new ContainerGrafter(playerInv, graftInv));
		player = playerInv.player;
		
		container = (ContainerGrafter) this.inventorySlots;
	}

	@Override
    public void onGuiClosed() {
        super.onGuiClosed();
        inventorySlots.onContainerClosed(player);
    }

    @Override
    public void drawGuiContainerForegroundLayer(int j, int i) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        fontRendererObj.drawString("Grafter", 8, 6, 0x404040);
        fontRendererObj.drawString("Inventory", 8, 72, 0x404040);
        
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int mx, int my) {
        drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        int i = width - xSize >> 1;
        int j = height - ySize >> 1;
        
        this.mc.renderEngine.bindTexture(new ResourceLocation(ModInfoLib.MODID + ":textures/gui/grafter.png"));
        
        drawTexturedModalRect(i, j, 0, 0, xSize, ySize);
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        super.actionPerformed(guibutton);
    }
}
