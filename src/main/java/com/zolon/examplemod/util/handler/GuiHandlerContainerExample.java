package com.zolon.examplemod.util.handler;

import com.zolon.examplemod.gui.GuiContainerBase;
import com.zolon.examplemod.inventory.ContainerBase;
import com.zolon.examplemod.tile_entity.TileEntityInventoryBase;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerContainerExample implements IGuiHandler {

	private static final int GUIID_MODEXAMPLE = 30;
	public static int getGuiID() {return GUIID_MODEXAMPLE;}

	// Gets the server side element for the given gui id- this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityInventoryBase) {
			TileEntityInventoryBase TileEntityInventoryBase = (TileEntityInventoryBase) tileEntity;
			/*return new ContainerBase(player.inventory, TileEntityInventoryBase, Minecraft.getMinecraft().player,
					6, 9);*/
			return new ContainerBase(player.inventory, TileEntityInventoryBase);
		}
		return null;
	}

	// Gets the client side element for the given gui id- this should return a gui
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityInventoryBase) {
			TileEntityInventoryBase TileEntityInventoryBase = (TileEntityInventoryBase) tileEntity;
			return new GuiContainerBase(player.inventory, TileEntityInventoryBase);
		}
		return null;
}

}
