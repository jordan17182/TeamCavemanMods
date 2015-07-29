package com.foodstuffs.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.foodstuffs.FoodstuffsMod;
import com.foodstuffs.misc.CropRegistry;

public class ItemFSCrop extends ItemFood implements IPlantable{

	public ItemFSCrop(int halfDrumsticks, float saturationModifier, boolean tameWolf, String unlocalizedName) {
		super(halfDrumsticks, saturationModifier, tameWolf);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(FoodstuffsMod.foodTab);
	}
	
	@Override
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
	    if (p_77648_7_ != 1)
	    {
	            return false;
	        }
	        else if (p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_))
	        {
	            if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).canSustainPlant(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, ForgeDirection.UP, this) && p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
	            {
	                p_77648_3_.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, CropRegistry.getPlant(this));
	                --p_77648_1_.stackSize;
	                return true;
	            }
	            else
	            {
	                return false;
	            }
	        }
	        else
	        {
	            return false;
	        }
	    }

	    @Override
	    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
	        return CropRegistry.getPlant(this) == Blocks.nether_wart ? EnumPlantType.Nether : EnumPlantType.Crop;
	    }

	    @Override
	    public Block getPlant(IBlockAccess world, int x, int y, int z) {
	        return CropRegistry.getPlant(this);
	    }

		@Override
		public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
			return 0;
		}
}
