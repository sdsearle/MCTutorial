package com.zolon.examplemod.util.handler;

import com.zolon.examplemod.gui.GuiInventoryFurnace;
import com.zolon.examplemod.inventory.ContainerInventoryFurnace;
import com.zolon.examplemod.tile_entity.TileInventoryFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class GuiHandlerFurnaceExample implements IGuiHandler {

	private static final int GUIID_FURNACE = 31;
	public static int getGuiID() {return GUIID_FURNACE;}

	// Gets the server side element for the given gui id this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileInventoryFurnace) {
			TileInventoryFurnace tileInventoryFurnace = (TileInventoryFurnace) tileEntity;
			return new ContainerInventoryFurnace(player.inventory, tileInventoryFurnace);
		}
		return null;
	}

	// Gets the client side element for the given gui id this should return a gui
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileInventoryFurnace) {
			TileInventoryFurnace tileInventoryFurnace = (TileInventoryFurnace) tileEntity;
			return new GuiInventoryFurnace(player.inventory, tileInventoryFurnace);
		}
		return null;
}

}
