package com.zolon.examplemod.blocks;

import java.util.Random;

import com.zolon.examplemod.ExampleMod;
import com.zolon.examplemod.init.ModBlocks;
import com.zolon.examplemod.init.ModItems;
import com.zolon.examplemod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	//boolean hasSpecialDrop = false;
	Item dropItem;
	int maxDrop;
	int minDrop;
	
	public BlockBase(String name, Material material){
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public BlockBase(String name, Material material, SoundType soundType) {
		this(name, material);
		this.setSoundType(soundType);
	}

	@Override
	public void registerModels() {
		ExampleMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	public void setDrop(Item item, int max, int min) {
		//hasSpecialDrop = true;
		dropItem = item;
		maxDrop = max;
		minDrop = min;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		if(dropItem != null){
			return ModItems.RUBY;
		}
		else{
			return super.getItemDropped(state, rand, fortune);
		}
	}
	
	@Override
	public int quantityDropped(Random rand){
		if(dropItem != null){
			return rand.nextInt(maxDrop) + minDrop;
		}else{
			return super.quantityDropped(rand);
		}
	}

}
