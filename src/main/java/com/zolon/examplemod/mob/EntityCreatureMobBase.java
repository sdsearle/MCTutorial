package com.zolon.examplemod.mob;

import java.util.ArrayList;

import com.zolon.examplemod.ExampleMod;
import com.zolon.examplemod.init.ModBlocks;
import com.zolon.examplemod.init.ModItems;
import com.zolon.examplemod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityCreatureMobBase implements IHasModel{

	private static ResourceLocation creatureResource;

	public EntityCreatureMobBase(String name) {
		//setUnlocalizedName(name);
		//setRegistryName(name);
		 creatureResource = new ResourceLocation(name);
		//setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		//ModBlocks.BLOCKS.add(this);
		//ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		int solidColor = 0x0004FF;
		int spotColor = 0xFF00E1;
		//int randomId = 5613956;
		EntityList.ENTITY_EGGS.put(creatureResource, new EntityList.EntityEggInfo(creatureResource, solidColor, spotColor));
		createEntity(TestMob.class, name, 0x0004FF, 0xFF00E1);
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
		//int randomId = EntityRegistry.findGlobalUniqueEntityId();
		//EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(creatureResource, entityClass, entityName, spotColor, ExampleMod.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.MONSTER, Biomes.FOREST, Biomes.DESERT, Biomes.JUNGLE, Biomes.PLAINS);
		
		//createEgg(randomId, solidColor, spotColor);
		
}

}
