package com.zolon.examplemod.init;

import java.util.ArrayList;
import java.util.List;

import com.zolon.examplemod.ExampleMod;
import com.zolon.examplemod.items.ItemBase;
import com.zolon.examplemod.items.armour.ArmourBase;
import com.zolon.examplemod.items.food.FoodBase;
import com.zolon.examplemod.items.food.FoodBuilder;
import com.zolon.examplemod.items.food.FoodEffectBase;
import com.zolon.examplemod.items.tools.ToolAxe;
import com.zolon.examplemod.items.tools.ToolHoe;
import com.zolon.examplemod.items.tools.ToolPickaxe;
import com.zolon.examplemod.items.tools.ToolSpade;
import com.zolon.examplemod.items.tools.ToolSword;

import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List <Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 1000, 8.0f, 4.0f, 10); 
	public static final ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armour_material_ruby", ExampleMod.MODID + ":ruby", 14, 
			new int[]{2,5,7,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f);
	
	//Items
	public static final Item RUBY = new ItemBase("ruby");
	
	//Tools
	public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
	public static final ItemSpade RUBY_SPADE = new ToolSpade("ruby_spade", MATERIAL_RUBY);
	public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY, 6.0f, 3.0f);
	public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);
	public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", MATERIAL_RUBY);
	
	//Armour
	public static final Item RUBY_HELMET = new ArmourBase("ruby_helmet", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item RUBY_CHESTPLATE = new ArmourBase("ruby_chestplate", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item RUBY_LEGGINGS = new ArmourBase("ruby_leggings", ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item RUBY_BOOTS = new ArmourBase("ruby_boots", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET);

	//Food
	//public static final Item EVIL_APPLE = new FoodBase("evil_apple", 4, 2.4f, false);
	//public static final Item EVIL_APPLE = new FoodEffectBase("evil_apple", 4, 2.4f, false, new PotionEffect(MobEffects.POISON, 60 * 20, 1, false, true));
	public static final Item EVIL_APPLE = new FoodBuilder("evil_apple", 4, 2.4f, false).setAlwaysEdible().setEffect(new PotionEffect(MobEffects.POISON, 60 * 20, 1, false, true)).build();

}
