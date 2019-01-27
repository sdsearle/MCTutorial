package com.zolon.examplemod.init;

import java.util.ArrayList;
import java.util.List;

import com.zolon.examplemod.mob.EntityCreatureMobBase;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.EntityAnimal;


public class ModEntities {
	
	public static final List<EntityCreature> CREATURES = new ArrayList<>();
	public static final EntityCreatureMobBase TEST_MOB_BASE = new EntityCreatureMobBase("test_mob");
	//public static final EntityCreature TEST_MOB = TEST_MOB_BASE.createEntity(entityClass, entityName, solidColor, spotColor);
}
