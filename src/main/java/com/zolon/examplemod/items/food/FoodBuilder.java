package com.zolon.examplemod.items.food;

import net.minecraft.potion.PotionEffect;

public class FoodBuilder {
	private FoodBase tmpFood;
	
	public FoodBuilder(String name, int amount, float saturation, boolean isAnimalFood){
		tmpFood = new FoodBase(name, amount, saturation, isAnimalFood);
	}
	
	public FoodBuilder setEffect(PotionEffect effect){
		tmpFood.setEffect(effect);
		return this;
	}
	
	public FoodBuilder setAlwaysEdible(){
		tmpFood.setAlwaysEdible();
		return this;
	}

	public FoodBase build(){
		return tmpFood;
	}
}
