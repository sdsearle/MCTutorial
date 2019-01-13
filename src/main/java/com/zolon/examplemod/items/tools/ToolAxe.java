package com.zolon.examplemod.items.tools;

import com.zolon.examplemod.ExampleMod;
import com.zolon.examplemod.init.ModItems;
import com.zolon.examplemod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

public class ToolAxe extends ItemAxe implements IHasModel {

	public ToolAxe(String name, ToolMaterial material, float damage, float speed){
		super(material, damage, speed);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		ExampleMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
