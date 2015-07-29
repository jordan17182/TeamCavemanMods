package com.foodstuffs.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.foodstuffs.FoodstuffsMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBarrel extends Item {

	/** The ID of the block the reed will spawn when used from inventory bar. */
    private Block spawnID;

    public ItemBarrel(String unlocalizedName, Block par2Block)
    {
        super();
        this.spawnID = par2Block;
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(FoodstuffsMod.foodTab);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        Block b1 = par3World.getBlock(par4, par5, par6);

        if (b1.equals(Blocks.snow) && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
        {
            par7 = 1;
        }
        else if (!b1.equals(Blocks.vine) && !b1.equals(Blocks.tallgrass) && !b1.equals(Blocks.deadbush))
        {
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else if (par1ItemStack.stackSize == 0)
        {
            return false;
        }
        else
        {
            //if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, (Entity)null, par1ItemStack))
            //{
                Block block = this.spawnID;
                int j1 = block.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);

                if (par3World.setBlock(par4, par5, par6, this.spawnID, j1, 3))
                {
                    if (par3World.getBlock(par4, par5, par6) == this.spawnID)
                    {
                        this.spawnID.onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
                        this.spawnID.onPostBlockPlaced(par3World, par4, par5, par6, j1);
                    }

                    par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), "random.break", (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                    --par1ItemStack.stackSize;
                }
            //}

            return true;
        }
    }
	
	@SideOnly(Side.CLIENT) 
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List textList, boolean bool) {
		textList.add("Right-click on barrel with a bucket or a cup");
		textList.add("to transfer fluid to and from the barrel.");
	}

}
