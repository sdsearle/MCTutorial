package com.zolon.examplemod.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id){
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	public static void preInitClientOnly()
	{
		// This is currently necessary in order to make your block render properly when it is an item (i.e. in the inventory
		//   or in your hand or thrown on the ground).
		// Minecraft knows to look for the item model based on the GameRegistry.registerBlock.  However the registration of
		//  the model for each item is normally done by RenderItem.registerItems(), and this is not currently aware
		//   of any extra items you have created.  Hence you have to do it manually.
		// It must be done on client only, and must be done after the block has been created in Common.preinit().
		//ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("examplemod:modexample_inventory_basic", "inventory");
		//final int DEFAULT_ITEM_SUBTYPE = 0;
		//ModelLoader.setCustomModelResourceLocation(StartupCommon.itemBlockInventoryBasic, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	}
	
}
