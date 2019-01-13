package com.zolon.examplemod.items.food;

import com.zolon.examplemod.ExampleMod;
import com.zolon.examplemod.init.ModItems;
import com.zolon.examplemod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FoodBase extends ItemFood implements IHasModel {

	PotionEffect effect;
	
	public FoodBase(String name, int amount, float saturation, boolean isAnimalFood){
		super(amount, saturation, isAnimalFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		ExampleMod.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote && effect != null){
			player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier()
					,effect.getIsAmbient(), effect.doesShowParticles()));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack){
		if(effect != null){
			return true;
		}else{
			return false;
		}
	}

	public void setEffect(PotionEffect effect) {
		this.effect = effect;
		
	}
	
}
