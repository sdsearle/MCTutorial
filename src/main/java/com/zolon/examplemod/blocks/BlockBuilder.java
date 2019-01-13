package com.zolon.examplemod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBuilder {
	private BlockBase tmpBlockBase;

	public BlockBuilder(String name, Material material) {
		tmpBlockBase = new BlockBase(name, material);
	}
	
	public BlockBuilder(String name, Material material, SoundType soundType) {
		tmpBlockBase = new BlockBase(name, material, soundType);
	}
	
	public BlockBuilder setResistance(float resistance){
		tmpBlockBase.setResistance(resistance);
		return this;
	}
	
	public BlockBuilder setHardness(float hardness){
		tmpBlockBase.setHardness(hardness);
		return this;
	}
	
	public BlockBuilder setHarvestLevel(String tool, int toolLevel){
		tmpBlockBase.setHarvestLevel(tool, toolLevel);
		return this;
	}
	
	public BlockBuilder setLightLevel(float lightLevel){
		tmpBlockBase.setLightLevel(lightLevel);
		return this;
	}
	
	public BlockBuilder setLightLevel(int lightOpacity){
		tmpBlockBase.setLightOpacity(lightOpacity);
		return this;
	}
	
	public BlockBuilder setUnbreakable(){
		tmpBlockBase.setBlockUnbreakable();
		return this;
	}
	
	public BlockBuilder setDrop(Item item, int max, int min){
		tmpBlockBase.setDrop(item, max, min);
		return this;
	}
	
	public BlockBase build(){
		return tmpBlockBase;
	}

}
