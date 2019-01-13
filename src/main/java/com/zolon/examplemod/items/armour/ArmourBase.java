package com.zolon.examplemod.items.armour;

import com.zolon.examplemod.ExampleMod;
import com.zolon.examplemod.init.ModItems;
import com.zolon.examplemod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmourBase extends ItemArmor implements IHasModel {

	public ArmourBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ModItems.ITEMS.add(this);
	}
		
	@Override
	public void registerModels() {
		ExampleMod.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
