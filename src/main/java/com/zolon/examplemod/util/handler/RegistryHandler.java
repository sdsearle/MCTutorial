package com.zolon.examplemod.util.handler;

import com.zolon.examplemod.init.ModBlocks;
import com.zolon.examplemod.init.ModEntities;
import com.zolon.examplemod.init.ModItems;
import com.zolon.examplemod.tile_entity.TileEntityBase;
import com.zolon.examplemod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event){

	event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event){

	event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event){

		for(Item item : ModItems.ITEMS){
			if(item instanceof IHasModel ){
				
				((IHasModel) item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS){
			if(block instanceof IHasModel ){
				
				((IHasModel) block).registerModels();
			}
		}
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> e) {
		//DeGeweldigeMod.LOGGER.info("Registering Entities.");
		e.getRegistry().registerAll(ModEntities.CREATURES.toArray(new EntityEntry[0]));
	}
}
