package com.mttc.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.foodstuffs.block.BlockManager;
import com.foodstuffs.misc.DrinkRegistry;
import com.foodstuffs.tileentity.TileEntityBarrel;
import com.mttc.tileentity.TileEntityConveyer;

public class TileEntityConveyerRender extends TileEntitySpecialRenderer {
	
    private static final ResourceLocation conveyerTexture = new ResourceLocation("mttc:textures/models/conveyer.png");
    private double textureWidth = 48.0D;
    private double textureHeight = 30.0D;
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double xCoord, double yCoord, double zCoord, float f) {
        GL11.glPushMatrix();
         
        //Set renderer coordinates
        GL11.glTranslatef((float)xCoord, (float)yCoord, (float)zCoord);
        //Convert tileEntity to TileEntityConveyer 
        TileEntityConveyer entityConveyer = (TileEntityConveyer)tileEntity;
         
         /*Note that true tile entity coordinates (tileEntity.xCoord, etc) do not match to render coordinates (d, etc) that are calculated as [true coordinates] - [player coordinates (camera coordinates)]*/
         renderBarrel(entityConveyer, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, BlockManager.barrel);
         GL11.glPopMatrix();
         
       
         
 		for(int i = 0; i < entityConveyer.getSizeInventory(); i++) {
 			renderItem(entityConveyer.getStackInSlot(i), entityConveyer.getSlotPosition(i), entityConveyer, xCoord, yCoord, zCoord);
 		}
    }

    public void renderBarrel(TileEntityConveyer conveyerTile, World world, int i, int j, int k, Block block) {
        Tessellator tessellator = Tessellator.instance;
        
        //Set lighting from surrounding lighting.
        //float f = 
        int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int l1 = l % 65536;
        int l2 = l / 65536;
        //tessellator.setColorOpaque_F(f, f, f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)l1, (float)l2);
        
        /*This will rotate your model corresponding to player direction that was when you placed the block. If you want this to work,
        add these lines to onBlockPlacedBy method in your block class.
        int dir = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);*/
        GL11.glTranslated(0.5F, 0f, 0.5F);
        int dir = world.getBlockMetadata(i, j, k);
        GL11.glRotatef(90f * dir, 0F, 1F, 0F);
        GL11.glTranslated(-0.5F, 0f, -0.5F);
        
        
        GL11.glPushMatrix();

        
        bindTexture(conveyerTexture);

        GL11.glScalef(0.0625F, 0.0625F, 0.0625F);
           
        //Put face rendering here
        //Side Faces
        renderFace(tessellator, 0.0, 0.0, 0.0, 16.0, 16.0, 0.0, 16.0, 14.0, 30.0, 0);
        renderFace(tessellator, 16.0, 0.0, 0.0, 16.0, 16.0, 0.0, 16.0, 14.0, 30.0, 2);
        //End Faces
        renderFace(tessellator, 0.0, 0.0, 16.0, 16.0, 12.0, 0.0, 16.0, 18.0, 30.0, 1);
        renderFace(tessellator, 0.0, 0.0, 0.0, 16.0, 12.0, 0.0, 16.0, 18.0, 30.0, 3);
        //Bottom Face
        renderFace(tessellator, 0.0, 0.0, 0.0, 16.0, 16.0, 32.0, 48.0, 14.0, 30.0, 5);
        //Top Face
        renderFace(tessellator, 0.0, 12.0, 0.0, 16.0, 16.0, 32.0, 48.0, 14.0, 30.0, 4);
        //roller faces
        renderFace(tessellator, 0.0, 12.0, 1.0, 16.0, 2.0, 3.0, 4.0, 16.0, 18.0, 3);
        renderFace(tessellator, 0.0, 12.0, 4.0, 16.0, 2.0, 1.0, 2.0, 16.0, 18.0, 1);
        renderFace(tessellator, 0.0, 14.0, 1.0, 3.0, 16.0, 1.0, 2.0, 16.0, 17.0, 4);
        
        renderFace(tessellator, 0.0, 14.0, 2.0, 16.0, 1.0, 2.0, 3.0, 15.0, 16.0, 3);
        renderFace(tessellator, 0.0, 14.0, 3.0, 16.0, 1.0, 2.0, 3.0, 15.0, 16.0, 1);
        renderFace(tessellator, 0.0, 15.0, 2.0, 1.0, 16.0, 1.0, 2.0, 16.0, 17.0, 4);
        
        renderFace(tessellator, 0.0, 12.0, 12.0, 16.0, 2.0, 3.0, 4.0, 16.0, 18.0, 3);
        renderFace(tessellator, 0.0, 12.0, 15.0, 16.0, 2.0, 1.0, 2.0, 16.0, 18.0, 1);
        renderFace(tessellator, 0.0, 14.0, 12.0, 3.0, 16.0, 1.0, 2.0, 16.0, 17.0, 4);
        
        renderFace(tessellator, 0.0, 14.0, 13.0, 16.0, 1.0, 2.0, 3.0, 15.0, 16.0, 3);
        renderFace(tessellator, 0.0, 14.0, 14.0, 16.0, 1.0, 2.0, 3.0, 15.0, 16.0, 1);
        renderFace(tessellator, 0.0, 15.0, 13.0, 1.0, 16.0, 1.0, 2.0, 16.0, 17.0, 4);
        
        
        //Belt Faces
        //Top
        renderFace(tessellator, 1.0, 16.0, 0.0, 16.0, 14.0, 0.0, 16.0, 0.0, 14.0, 4);
        //Side
        renderFace(tessellator, 1.0, 12.0, 0.0, 16.0, 4.0, 16.0, 32.0, 14.0, 18.0, 0);
        renderFace(tessellator, 15.0, 12.0, 0.0, 16.0, 4.0, 16.0, 32.0, 14.0, 18.0, 2);
        //End
        renderFace(tessellator, 1.0, 12.0, 16.0, 14.0, 4.0, 16.0, 30.0, 0.0, 4.0, 1);
        renderFace(tessellator, 1.0, 12.0, 0.0, 14.0, 4.0, 16.0, 30.0, 0.0, 4.0, 3);
        //Inside ends
        renderFace(tessellator, 1.0, 13.0, 1.0, 14.0, 14.0, 0.0, 14.0, 0.0, 14.0, 4);
        renderFace(tessellator, 1.0, 15.0, 1.0, 14.0, 14.0, 0.0, 14.0, 0.0, 14.0, 5);
        
        renderFace(tessellator, 1.0, 13.0, 1.0, 14.0, 2.0, 16.0, 30.0, 0.0, 2.0, 1);
        renderFace(tessellator, 1.0, 13.0, 15.0, 14.0, 2.0, 16.0, 30.0, 0.0, 2.0, 3);
        
        /**
        ItemStack itemstack = p_82402_1_.getDisplayedItem();

        if (itemstack != null)
        {
            EntityItem entityitem = new EntityItem(p_82402_1_.worldObj, 0.0D, 0.0D, 0.0D, itemstack);
            Item item = entityitem.getEntityItem().getItem();
            entityitem.getEntityItem().stackSize = 1;
            entityitem.hoverStart = 0.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.453125F * (float)Direction.offsetX[p_82402_1_.hangingDirection], -0.18F, -0.453125F * (float)Direction.offsetZ[p_82402_1_.hangingDirection]);
            GL11.glRotatef(180.0F + p_82402_1_.rotationYaw, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef((float)(-90 * p_82402_1_.getRotation()), 0.0F, 0.0F, 1.0F);

            switch (p_82402_1_.getRotation())
            {
                case 1:
                    GL11.glTranslatef(-0.16F, -0.16F, 0.0F);
                    break;
                case 2:
                    GL11.glTranslatef(0.0F, -0.32F, 0.0F);
                    break;
                case 3:
                    GL11.glTranslatef(0.16F, -0.16F, 0.0F);
            }
        }
        
        **/
        
        
        
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }
    
    private void renderItem(ItemStack stack, float position, TileEntityConveyer tile, double x, double y, double z) {
    	if(stack != null && stack.getItem() != null) {
        	System.out.println("rendered item");

    		EntityItem entityitem = new EntityItem(tile.getWorldObj(), 0.0D, 0.0D, 0.0D, stack);

    		int direction = tile.getWorldObj().getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord);
    		
    		
    		GL11.glPushMatrix();
    		//Without the below line, the item will spazz out
    		entityitem.hoverStart = 0.0F;
    		RenderItem.renderInFrame = true;
    		switch(direction) {
    		case 0:
        		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + 1.0F - position);
        		break;
    		case 1:
        		GL11.glTranslatef((float)x + position, (float)y + 1.02F, (float)z + 0.5F);
        		break;
    		case 2:
        		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + position);
        		break;
        	default:
        		GL11.glTranslatef((float)x + 1.0F - position, (float)y + 1.02F, (float)z + 0.5F);
        		break;
    		}
    		GL11.glRotatef(90 * (direction+1), 0, 1, 0);
    		GL11.glScalef(0.75F, 0.75F, 0.75F);
    		RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
    		RenderItem.renderInFrame = false;
    		GL11.glPopMatrix();
            

            //Item item = entityitem.getEntityItem().getItem();
            //entityitem.getEntityItem().stackSize = 1;
            
        //}
    	}
    }
    
    private void renderFace(Tessellator tessellator, double originX, double originY, double originZ, double width, double height,  double u1, double u2, double v1, double v2, int direction) {
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
    private void renderFace(Tessellator tessellator, double originX, double originY, double originZ, double width, double height,  double u1, double u2, double v1, double v2, int direction, double tempWidth, double tempHeight) {
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
            tessellator.addVertexWithUV(width+originX, originY, originZ, u2/tempWidth, v2/tempHeight);
            tessellator.addVertexWithUV(width+originX, height+originY, originZ, u2/tempWidth, v1/tempHeight);
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
            GL11.glNormal3f(0.0F, 0.0F, -0.0626F);
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
   