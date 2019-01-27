package com.zolon.examplemod.util.handler;

import com.zolon.examplemod.ExampleMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {

	public static final ResourceLocation TESTMOB = LootTableList.register(new ResourceLocation(ExampleMod.MODID, "test_mob"));
}
