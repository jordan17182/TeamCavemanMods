package com.mttc.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.foodstuffs.FoodstuffsMod;
import com.mttc.MTTCMod;
import com.mttc.tileentity.TileBlastFurnace;

public class BlockBlastFurnace extends BlockContainer {
    public BlockBlastFurnace(Material material) {
        super(material);
		this.setCreativeTab(MTTCMod.mttcTab);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile != null && tile instanceof TileBlastFurnace) {
            TileBlastFurnace multiBlock = (TileBlastFurnace) tile;
            if (multiBlock.hasMaster()) {
                if (multiBlock.isMaster()) {
                    if (!multiBlock.checkMultiBlockForm())
                        multiBlock.resetStructure();
                } else {
                    if (!multiBlock.checkForMaster()) {
                        multiBlock.reset();
                        world.markBlockForUpdate(x, y, z);
                    } else {
                    	///multiBlock.alertMasterOfChange();
                    }
                }
            }
        }
        super.onNeighborBlockChange(world, x, y, z, block);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block p_149749_5_, int p_149749_6_) {
    	TileEntity tile = world.getTileEntity(x, y, z);
        if (tile != null && tile instanceof TileBlastFurnace) {
            TileBlastFurnace multiBlock = (TileBlastFurnace) tile;
            if (multiBlock.hasMaster()) {
                if (multiBlock.isMaster()) {
                	multiBlock.resetStructure();
                } else {
                	TileBlastFurnace masterTile = multiBlock.getMaster();
                	super.breakBlock(world, x, y, z, p_149749_5_, p_149749_6_);
                	if(masterTile != null && (masterTile instanceof TileBlastFurnace)) {
                		masterTile.checkIntegrity();
                	}
                }
            }
        }
    	
    }

    
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileBlastFurnace();
    }
}