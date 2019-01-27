package com.zolon.examplemod.blocks;

import com.zolon.examplemod.init.ModBlocks;
import com.zolon.examplemod.init.ModItems;
import com.zolon.examplemod.tile_entity.TileEntityBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTileEntityBase extends Block {

	public BlockTileEntityBase(String name)
	  {
	    super(Material.ROCK);
	    
	    setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);   // the block will appear on the Blocks tab in creative
	  
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		// Each of your tile entities needs to be registered with a name that is unique to your mod.
		GameRegistry.registerTileEntity(TileEntityBase.class, this.getRegistryName() + "_tile_entity");
	  }

	  private final int TIMER_COUNTDOWN_TICKS = 20 * 10; // duration of the countdown, in ticks = 10 seconds

	  @Override
	  public boolean hasTileEntity(IBlockState state)
	  {
	    return true;
	  }

	  // Called when the block is placed or loaded client side to get the tile entity for the block
	  // Should return a new instance of the tile entity for the block
	  @Override
	  public TileEntity createTileEntity(World world, IBlockState state) {return new TileEntityBase();}

	  // Called just after the player places a block.  Start the tileEntity's timer
	  @Override
	  public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	    TileEntity tileentity = worldIn.getTileEntity(pos);
	    if (tileentity instanceof TileEntityBase) { // prevent a crash if not the right type, or is null
	    	TileEntityBase tileEntityBase = (TileEntityBase)tileentity;
	      tileEntityBase.setTicksLeftTillDisappear(TIMER_COUNTDOWN_TICKS);
	    }
	  }

	  // the block will render in the SOLID layer.  See http://greyminecraftcoder.blogspot.co.at/2014/12/block-rendering-18.html for more information.
	  @SideOnly(Side.CLIENT)
	  public BlockRenderLayer getBlockLayer()
	  {
	    return BlockRenderLayer.SOLID;
	  }

	  // used by the renderer to control lighting and visibility of other blocks.
	  // set to false because this block doesn't fill the entire 1x1x1 space
	  @Override
	  public boolean isOpaqueCube(IBlockState state)
	  {
	    return false;
	  }

	  // used by the renderer to control lighting and visibility of other blocks, also by
	  // (eg) wall or fence to control whether the fence joins itself to this block
	  // set to false because this block doesn't fill the entire 1x1x1 space
	  @Override
	  public boolean isFullCube(IBlockState state)
	  {
	    return false;
	  }

	  // render using a BakedModel
	  // not required because the default (super method) is MODEL
	  @Override
	  public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
	    return EnumBlockRenderType.MODEL;
	  }
}
