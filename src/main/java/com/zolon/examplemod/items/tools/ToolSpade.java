package com.zolon.examplemod.items.tools;

import com.zolon.examplemod.ExampleMod;
import com.zolon.examplemod.init.ModItems;
import com.zolon.examplemod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

public class ToolSpade extends ItemSpade implements IHasModel {

	public ToolSpade(String name, ToolMaterial material){
		super(material);
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
