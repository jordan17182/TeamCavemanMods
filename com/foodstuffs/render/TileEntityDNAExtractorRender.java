package com.foodstuffs.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.foodstuffs.block.BlockManager;
import com.foodstuffs.misc.DrinkRegistry;
import com.foodstuffs.tileentity.TileEntityBarrel;

public class TileEntityDNAExtractorRender extends TileEntitySpecialRenderer {
	
    private static final ResourceLocation barrelTexture = new ResourceLocation("foodstuffs:textures/models/barrel.png");
    private static final ResourceLocation fluidTexture = new ResourceLocation("foodstuffs:textures/models/barrelFluid.png");
    private double textureWidth = 48.0D;
    private double textureHeight = 32.0D;
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f) {
        GL11.glPushMatrix();
         
        //This will move our renderer so that it will be on proper place in the world
         GL11.glTranslatef((float)d, (float)d1, (float)d2);
         TileEntityBarrel TileEntityBarrel = (TileEntityBarrel)tileEntity;
         
         /*Note that true tile entity coordinates (tileEntity.xCoord, etc) do not match to render coordinates (d, etc) that are calculated as [true coordinates] - [player coordinates (camera coordinates)]*/
         renderBarrel(TileEntityBarrel, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, BlockManager.barrel);
         GL11.glPopMatrix();
    }

    public void renderBarrel(TileEntityBarrel tl, World world, int i, int j, int k, Block block) {
        Tessellator tessellator = Tessellator.instance;
        
        //This will make your block brightness dependent from surroundings lighting.
        float f = block.getLightValue(world, i, j, k);
        int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int l1 = l % 65536;
        int l2 = l / 65536;
        tessellator.setColorOpaque_F(f, f, f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)l1, (float)l2);
        
        /*This will rotate your model corresponding to player direction that was when you placed the block. If you want this to work,
        add these lines to onBlockPlacedBy method in your block class.
        int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);*/
        int dir = world.getBlockMetadata(i, j, k);
        GL11.glPushMatrix();
        GL11.glTranslatef(1F, 0.5f, 0.5F);
        //This line actually rotates the renderer.
        GL11.glRotatef(90f, 0F, 0F, 1F);
        GL11.glRotatef(tl.rotation, 0F, 1F, 0F);
        //GL11.glRotatef(tl.rotation, 0F, 0F, 1F);

        GL11.glTranslatef(-0.5F, 0, -0.5F);
        
        bindTexture(barrelTexture);

        GL11.glScalef(0.0625F, 0.0625F, 0.0625F);
           
        //Put face rendering here
        renderFace(tessellator, 0.0, 16.0, 0.0, 16.0, 16.0, 16.0, 32.0, 16.0, 32.0, 4);
        renderFace(tessellator, 0.0, 1.0, 0.0, 16.0, 16.0, 0.0, 16.0, 16.0, 32.0, 4);
        renderFace(tessellator, 0.0, 0.0, 0.0, 16.0, 16.0, 0.0, 16.0, 0.0, 16.0, 5);
        
       
        
        for(int n = 0; n < 4; n++) {
        	renderFace(tessellator, 6.0, 0.0, 0.0, 1.0, 16.0, 16.0, 17.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 4.0, 0.0, 1.0, 1.0, 16.0, 17.0, 18.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 3.0, 0.0, 2.0, 1.0, 16.0, 18.0, 19.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 2.0, 0.0, 3.0, 1.0, 16.0, 19.0, 20.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 1.0, 0.0, 4.0, 2.0, 16.0, 20.0, 22.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 0.0, 0.0, 6.0, 4.0, 16.0, 24.0, 26.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 1.0, 0.0, 10.0, 2.0, 16.0, 26.0, 28.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 2.0, 0.0, 12.0, 1.0, 16.0, 28.0, 29.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 3.0, 0.0, 13.0, 1.0, 16.0, 29.0, 30.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 4.0, 0.0, 14.0, 1.0, 16.0, 30.0, 31.0, 0.0, 16.0, 0);
        	renderFace(tessellator, 6.0, 0.0, 15.0, 1.0, 16.0, 31.0, 32.0, 0.0, 16.0, 0);
        	
        	renderFace(tessellator, 6.0, 1.0, 13.0, 1.0, 15.0, 32.0, 33.0, 0.0, 15.0, 2);
        	renderFace(tessellator, 4.0, 1.0, 12.0, 1.0, 15.0, 33.0, 34.0, 0.0, 15.0, 2);
        	renderFace(tessellator, 3.0, 1.0, 10.0, 2.0, 15.0, 34.0, 36.0, 0.0, 15.0, 2);
        	renderFace(tessellator, 2.0, 1.0, 6.0, 4.0, 15.0, 36.0, 40.0, 0.0, 15.0, 2);
        	renderFace(tessellator, 3.0, 1.0, 4.0, 2.0, 15.0, 40.0, 42.0, 0.0, 15.0, 2);
        	renderFace(tessellator, 4.0, 1.0, 3.0, 1.0, 15.0, 42.0, 43.0, 0.0, 15.0, 2);
        	renderFace(tessellator, 6.0, 1.0, 2.0, 1.0, 15.0, 43.0, 44.0, 0.0, 15.0, 2);

            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-16.0F, 0.0F, 0.0F);
        }
        
        S35PacketUpdateTileEntity barrelTemp = (S35PacketUpdateTileEntity)tl.getDescriptionPacket();
        if(barrelTemp.func_148857_g().getBoolean("hasFluid")) {
        	int renderType = 0;
        	int fluidType = barrelTemp.func_148857_g().getInteger("fluidType");
        	int fluidVolume = barrelTemp.func_148857_g().getInteger("fluidVolume");
        	int maxVolume = barrelTemp.func_148857_g().getInteger("maxFluidVolume");
        	int fluidColor = DrinkRegistry.getFluidColor(tl.getFluidType());
        	double tempY = 1+(13.0*((double)fluidVolume/(double)maxVolume));
            bindTexture(fluidTexture);
        	GL11.glEnable(GL11.GL_BLEND);
        	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        	
        	
        	float red = (float)(fluidColor >> 16 & 255) / 255.0F;
        	float green = (float)(fluidColor >> 8 & 255) / 255.0F;
        	float blue = (float)(fluidColor & 255) / 255.0F;
        	//float alpha = (float)(fluidColor >> 24 & 255) / 255.0F;
        	GL11.glColor4f(red, green, blue, 1.0f);
        	renderType = DrinkRegistry.isTranslucent(tl.getFluidType()) ? 0 : 1;
        	renderFace(tessellator, 0.0, tempY, 0.0, 16.0, 16.0, 16.0*renderType, 16.0+16.0*renderType, 0.0, 16.0, 4, 32.0D, 16.0D);
            GL11.glDisable(GL11.GL_BLEND);
        }
        
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }
    
    private void renderFace(Tessellator tessellator, double originX, double originY, double originZ,
    		double width, double height,  double u1, double u2, double v1, double v2, int direction) {
    	this.renderFace(tessellator, originX, originY, originZ, width, height, u1, u2, v1, v2, direction, textureWidth, textureHeight);
    }
    
    /**
     * @param tessellator
     * @param originX
     * @param originY
     * @param originZ
     * @param width
     * @param height
     * @param u1
     * @param u2
     * @param v1
     * @param v2
     * @param direction 0-front,1-right,2-back,3-left,4-top,5-bottom
     */
    private void renderFace(Tessellator tessellator, double originX, double originY, double originZ,
    		double width, double height,  double u1, double u2, double v1, double v2, int direction, double tempWidth, double tempHeight) {
    	
    	
    	switch(direction) {
    	case 0:
            GL11.glNormal3f(-0.0626F, 0.0F, 0.0F);
            tessellator.startDrawingQuads();
    		tessellator.addVertexWithUV(originX, originY, originZ, u1/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(originX, originY, width+originZ, u2/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(originX, height+originY, width+originZ, u2/tempWidth, v1/tempHeight);
            tessellator.addVertexWithUV(originX, height+originY, originZ, u1/tempWidth, v1/tempHeight);
            tessellator.draw();
            break;
    	case 1:
            GL11.glNormal3f(0.0F, 0.0F, 0.0626F);
    		tessellator.startDrawingQuads();
    		tessellator.addVertexWithUV(originX, originY, originZ, u1/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(width, originY, originZ, u2/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(width, height+originY, originZ, u2/tempWidth, v1/tempHeight);
            tessellator.addVertexWithUV(originX, height+originY, originZ, u1/tempWidth, v1/tempHeight);
            tessellator.draw();
            break;
    	case 2:
            GL11.glNormal3f(0.0626F, 0.0F, 0.0F);
    		tessellator.startDrawingQuads();
    		tessellator.addVertexWithUV(originX, originY, originZ+width, u1/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(originX, originY, originZ, u2/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(originX, height+originY, originZ, u2/tempWidth, v1/tempHeight);
            tessellator.addVertexWithUV(originX, height+originY, originZ+width, u1/tempWidth, v1/tempHeight);
            tessellator.draw();
            break;
    	case 3:
            GL11.glNormal3f(0.0F, 0.0625F, -0.0626F);
    		tessellator.startDrawingQuads();
    		tessellator.addVertexWithUV(width+originX, originY, originZ, u1/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(originX, originY, originZ, u2/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(originX, height+originY, originZ, u2/tempWidth, v1/tempHeight);
            tessellator.addVertexWithUV(width+originX, height+originY, originZ, u1/tempWidth, v1/tempHeight);
            tessellator.draw();
            break;
    	case 4:
            GL11.glNormal3f(0.0F, 0F, 0.0F);
    		tessellator.startDrawingQuads();
    		tessellator.addVertexWithUV(originX, originY, originZ, u1/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(originX, originY, width+originZ, u2/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(height+originX, originY, width+originZ, u2/tempWidth, v1/tempHeight);
            tessellator.addVertexWithUV(height+originX, originY, originZ, u1/tempWidth, v1/tempHeight);
            tessellator.draw();
            break;
    	case 5:
            GL11.glNormal3f(0.0F, -0.0625F, 0.0F);
    		tessellator.startDrawingQuads();
    		tessellator.addVertexWithUV(originX, originY, width+originZ, u1/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(originX, originY, originZ, u2/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(height+originX, originY, originZ, u2/tempWidth, v1/tempHeight);
            tessellator.addVertexWithUV(height+originX, originY, width+originZ, u1/tempWidth, v1/tempHeight);
            tessellator.draw();
            break;
    	}    
    }
}
   