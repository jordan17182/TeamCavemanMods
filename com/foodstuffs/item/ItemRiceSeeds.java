package com.foodstuffs.item;



import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.foodstuffs.FoodstuffsMod;

public class ItemRiceSeeds extends ItemSeeds {

	private Block toPlant;
	
	public ItemRiceSeeds(Block toGrow, Block toGrowOn, String unlocalizedName) {
		super(toGrow, toGrowOn);
		this.toPlant = toGrow;
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(FoodstuffsMod.foodTab);
	}

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1) {
            return false;
        }
        else if (par2EntityPlayer.canPlayerEdit(x, y, z, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(x, y + 1, z, par7, par1ItemStack)) {
        	boolean hasWater = (par3World.getBlock(x - 1, y, z).getMaterial() == Material.water ||
        			 par3World.getBlock(x + 1, y, z).getMaterial() == Material.water ||
        			 par3World.getBlock(x, y, z - 1).getMaterial() == Material.water ||
        			 par3World.getBlock(x, y, z + 1).getMaterial() == Material.water);
        	
        	if (par3World.getBlock(x, y, z).canSustainPlant(par3World, x, y, z, ForgeDirection.UP, this) && par3World.isAirBlock(x, y + 1, z) && hasWater) {
                par3World.setBlock(x, y + 1, z, this.toPlant);
                --par1ItemStack.stackSize;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
	
	
}
