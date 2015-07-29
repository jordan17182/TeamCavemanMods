package com.mttc.tileentity;
 
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
 
public class TileBlastFurnace extends TileEntity {
    private boolean hasMaster, isMaster;
    private int masterX, masterY, masterZ;
 
    
    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!worldObj.isRemote) {
            if (hasMaster()) { 
                if (isMaster()) {
                    // Put stuff you want the multiblock to do here!
                }
            } else {
                if (checkMultiBlockForm()) {
                	setupStructure();
                }
            }
        }
    }
    
    public void checkIntegrity() {
    	if(!checkMultiBlockForm()) {
    		resetStructure();
    	}
    }
    
    /** Check that structure is properly formed */
	public boolean checkMultiBlockForm() {
		int tileCount = 0;
		// Scan a 3x3x3 area, starting with the bottom left corner
		for (int x = xCoord - 1; x < xCoord + 2; x++)
			for (int y = yCoord; y < yCoord + 3; y++)
				for (int z = zCoord - 1; z < zCoord + 2; z++) {
					TileEntity tile = worldObj.getTileEntity(x, y, z);
					// Make sure tile isn't null, is an instance of the same Tile, and isn't already a part of a multiblock
					if (tile != null && (tile instanceof TileBlastFurnace)) {
						if (this.isMaster()) {
							if (((TileBlastFurnace)tile).hasMaster())
								tileCount++;
						} else if (!((TileBlastFurnace)tile).hasMaster())
							tileCount++;
					}
			}
		// check if there are 26 blocks present ((3*3*3) - 1) and check that center block is empty
		return tileCount > 26;
	}
 
    /** Setup all the blocks in the structure*/
    public void setupStructure() {
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    // Check if block is bottom center block
                    boolean master = (x == xCoord && y == yCoord && z == zCoord);
                    if (tile != null && (tile instanceof TileBlastFurnace)) {
                    	//worldObj.setBlock(x, y, z, Blocks.diamond_block);
                    	((TileBlastFurnace) tile).setMasterCoords(xCoord, yCoord, zCoord);
                        ((TileBlastFurnace) tile).setHasMaster(true);
                        ((TileBlastFurnace) tile).setIsMaster(master);
                    }
                }
        System.out.println("Setup");
    }
 
    /** Reset method to be run when the master is gone or tells them to */
    public void reset() {
        masterX = 0;
        masterY = 0;
        masterZ = 0;
        hasMaster = false;
        isMaster = false;
        System.out.println("dissolved");
    }
 
    /** Check that the master exists */
    public boolean checkForMaster() {
        TileEntity tile = worldObj.getTileEntity(masterX, masterY, masterZ);
        return (tile != null && (tile instanceof TileBlastFurnace));
    }
    
    public TileBlastFurnace getMaster() {
    	TileEntity tile = worldObj.getTileEntity(masterX, masterY, masterZ);
    	if(tile != null && (tile instanceof TileBlastFurnace)) {
    		return ((TileBlastFurnace) tile);
    	} else {
    		return null;
    	}
    }
    
    /** Reset all the parts of the structure */
    public void resetStructure() {
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileBlastFurnace))
                        ((TileBlastFurnace) tile).reset();
                }
    }
 
    @Override
    public void writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("masterX", masterX);
        data.setInteger("masterY", masterY);
        data.setInteger("masterZ", masterZ);
        data.setBoolean("hasMaster", hasMaster);
        data.setBoolean("isMaster", isMaster);
        if (hasMaster() && isMaster()) {
            // Any other values should ONLY BE SAVED TO THE MASTER
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        masterX = data.getInteger("masterX");
        masterY = data.getInteger("masterY");
        masterZ = data.getInteger("masterZ");
        hasMaster = data.getBoolean("hasMaster");
        isMaster = data.getBoolean("isMaster");
        if (hasMaster() && isMaster()) {
            // Any other values should ONLY BE READ BY THE MASTER
        }
    }
 
    public boolean hasMaster() {
        return hasMaster;
    }
 
    public boolean isMaster() {
        return isMaster;
    }
 
    public int getMasterX() {
        return masterX;
    }
 
    public int getMasterY() {
        return masterY;
    }
 
    public int getMasterZ() {
        return masterZ;
    }
 
    public void setHasMaster(boolean bool) {
        hasMaster = bool;
    }
 
    public void setIsMaster(boolean bool) {
        isMaster = bool;
    }
 
    public void setMasterCoords(int x, int y, int z) {
        masterX = x;
        masterY = y;
        masterZ = z;
    }
}