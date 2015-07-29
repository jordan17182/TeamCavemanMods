package com.caveman.genetics.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.caveman.genetics.tileentity.PlantEnums.BreakType;
import com.caveman.genetics.tileentity.PlantEnums.ChopType;
import com.caveman.genetics.tileentity.PlantEnums.CropColor;
import com.caveman.genetics.tileentity.PlantEnums.CropForm;
import com.caveman.genetics.tileentity.PlantEnums.CropType;
import com.caveman.genetics.tileentity.PlantEnums.Deffence;
import com.caveman.genetics.tileentity.PlantEnums.FlowerColor;
import com.caveman.genetics.tileentity.PlantEnums.Harvestability;
import com.caveman.genetics.tileentity.PlantEnums.LeafTexture;
import com.caveman.genetics.tileentity.PlantEnums.PlantOrientation;
import com.caveman.genetics.tileentity.PlantEnums.Planting;
import com.caveman.genetics.tileentity.PlantEnums.SeedType;
import com.caveman.genetics.tileentity.PlantEnums.Spread;
import com.caveman.genetics.tileentity.PlantEnums.TreeShape;
import com.caveman.genetics.tileentity.PlantEnums.WoodType;



public class TileEntityPlant extends TileEntity {
	
	//Generic traits
	private SeedType seedType;
	private CropType cropType;
	private Harvestability harvest;
	private float growthSpeed;
	private Spread spread;
	private boolean canFertalize;
	private Planting planting;
	private BreakType breakType;
	private int lightMin;
	private int lightMax;
	private PlantOrientation plantOrient;
	private Deffence deffence;	
	
	//Crop traits
	private CropForm cropForm;
	private CropColor cropColor;
	
	//Tree traits
	private LeafTexture leafTexture;
	private TreeShape treeShape;
	private WoodType woodType;
	private ChopType chopType;
	
	//Flower traits
	private boolean isFlowering;
	private FlowerColor flowerColor;
	
	public TileEntityPlant() {
	}
	
	public void setPlant(NBTTagCompound tagToCopy) {
		this.seedType = SeedType.valueOf(tagToCopy.getString("seedType"));
		this.cropType = CropType.valueOf(tagToCopy.getString("cropType"));
		this.harvest = Harvestability.valueOf(tagToCopy.getString("harvest"));
		this.growthSpeed = tagToCopy.getFloat("growthSpeed");
		this.spread = Spread.valueOf(tagToCopy.getString("spread"));
		this.canFertalize = tagToCopy.getBoolean("canFertalize");
		this.planting = Planting.valueOf(tagToCopy.getString("planting"));
		this.breakType = BreakType.valueOf(tagToCopy.getString("breakType"));
		this.lightMin = tagToCopy.getInteger("lightMin");
		this.lightMax = tagToCopy.getInteger("lightMax");
		this.plantOrient = PlantOrientation.valueOf(tagToCopy.getString("plantOrient"));
		this.deffence = Deffence.valueOf(tagToCopy.getString("deffence"));
		sendUpdate();
	}
	
	
	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		System.out.println(seedType != null);
		par1.setString("seedType", seedType.toString());
		par1.setString("cropType", cropType.toString());
		par1.setString("harvest", harvest.toString());
		par1.setFloat("growthSpeed", growthSpeed);
		par1.setString("spread", spread.toString());
		par1.setBoolean("canFertalize", canFertalize);
		par1.setString("planting", planting.toString());
		par1.setString("breakType", breakType.toString());
		par1.setInteger("lightMin", lightMin);
		par1.setInteger("lightMax", lightMax);
		par1.setString("plantOrient", plantOrient.toString());
		par1.setString("deffence", deffence.toString());
		
		System.out.println(par1.toString());
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.seedType = SeedType.valueOf(par1.getString("seedType"));
		this.cropType = CropType.valueOf(par1.getString("cropType"));
		this.harvest = Harvestability.valueOf(par1.getString("harvest"));
		this.growthSpeed = par1.getFloat("growthSpeed");
		this.spread = Spread.valueOf(par1.getString("spread"));
		this.canFertalize = par1.getBoolean("canFertalize");
		this.planting = Planting.valueOf(par1.getString("planting"));
		this.breakType = BreakType.valueOf(par1.getString("breakType"));
		this.lightMin = par1.getInteger("lightMin");
		this.lightMax = par1.getInteger("lightMax");
		this.plantOrient = PlantOrientation.valueOf(par1.getString("plantOrient"));
		this.deffence = Deffence.valueOf(par1.getString("deffence"));

	}
	
	//Marks the block for a packet update to the server
	private void sendUpdate() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	@Override
	public Packet getDescriptionPacket() {
		S35PacketUpdateTileEntity packet = (S35PacketUpdateTileEntity) super.getDescriptionPacket();
		NBTTagCompound tag = packet != null ? packet.func_148857_g() : new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 2, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		NBTTagCompound tag = pkt.func_148857_g();
		readFromNBT(pkt.func_148857_g());
	}

}
