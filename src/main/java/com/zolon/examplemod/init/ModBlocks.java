package com.zolon.examplemod.init;

import java.util.ArrayList;
import java.util.List;

import com.zolon.examplemod.blocks.BlockBase;
import com.zolon.examplemod.blocks.BlockBuilder;
import com.zolon.examplemod.blocks.BlockContainerBase;
import com.zolon.examplemod.blocks.BlockInventoryFurnace;
import com.zolon.examplemod.blocks.BlockTileEntityBase;
import com.zolon.examplemod.blocks.RubyBlock;
import com.zolon.examplemod.blocks.RubyOre;
import com.zolon.examplemod.inventory.ContainerBase;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RUBY_BLOCKS = new RubyBlock("ruby_block", Material.IRON);
	/*public static final Block MY_BLOCK = new BlockBuilder("example", Material.IRON, SoundType.GROUND)
			.setHardness(1f).setHarvestLevel("axe", 0).build();*/
	public static final Block RUBY_ORE = new BlockBuilder("ruby_ore", Material.ROCK, SoundType.METAL).setHardness(5.0f)
			.setResistance(15.0f).setHarvestLevel("pickaxe", 2).setDrop(ModItems.RUBY, 4, 1).build();
	//public static final Block RUBY_ORE = new RubyOre("ruby_ore", Material.ROCK);
	//public static final Block RUBY_CHEST = new BlockContainerBase("ruby_chest", Material.IRON);
	
	public static final Block TEST_ENTITY_BLOCK = new BlockTileEntityBase("test_entity_block");
	public static final Block TEST_CHEST_BLOCK = new BlockContainerBase("test_chest_block", Material.GRASS);
	public static final Block TEST_FURNACE_BLOCK = new BlockInventoryFurnace("test_furnace_block");
}
