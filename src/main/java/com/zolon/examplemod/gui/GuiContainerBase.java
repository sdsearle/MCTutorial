package com.zolon.examplemod.gui;

import java.awt.Color;

import com.zolon.examplemod.inventory.ContainerBase;
import com.zolon.examplemod.tile_entity.TileEntityInventoryBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiContainerBase extends GuiContainer {

	// This is the resource location for the background image for the GUI
		private static final ResourceLocation texture = new ResourceLocation("examplemod", "textures/gui/modexample_inventory_basic_bg.png");
		private TileEntityInventoryBase TileEntityInventoryBase;

		public GuiContainerBase(InventoryPlayer invPlayer, TileEntityInventoryBase tile) {
			//super(new ContainerBase(invPlayer, tile, Minecraft.getMinecraft().player, 6, 9));
			super(new ContainerBase(invPlayer, tile));
			TileEntityInventoryBase = tile;
			// Set the width and height of the gui.  Should match the size of the texture!
			xSize = 176;
			ySize = 133;
		}

		// draw the background for the GUI - rendered first
		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
			// Bind the image texture of our custom container
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			// Draw the image
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		}

		// draw the foreground for the GUI - rendered after the slots, but before the dragged items and tooltips
		// renders relative to the top left corner of the background
		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			final int LABEL_XPOS = 5;
			final int LABEL_YPOS = 5;
			fontRenderer.drawString(TileEntityInventoryBase.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());
	}
}
