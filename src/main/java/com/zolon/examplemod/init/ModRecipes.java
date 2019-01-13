package com.zolon.examplemod.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init(){
		GameRegistry.addSmelting(ModItems.RUBY, new ItemStack(ModBlocks.RUBY_BLOCKS, 1), 1.5f);
		GameRegistry.addSmelting(ModBlocks.RUBY_BLOCKS, new ItemStack(Blocks.DIAMOND_BLOCK, 1), 3f);
	}
}
