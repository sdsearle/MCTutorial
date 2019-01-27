package com.zolon.examplemod.mob;

import com.zolon.examplemod.util.handler.LootTableHandler;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TestMob extends EntityMob {
	
	public TestMob(World par1World) {
		super(par1World);
		this.setSize(0.5F, 0.4F);
		this.tasks.addTask(0, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.5D, false));
		this.tasks.addTask(0, new EntityAIFindEntityNearestPlayer(this));
		this.tasks.addTask(0, new EntityAIMoveTowardsTarget(this, 0.5D, 64));
		//this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		//this.tasks.addTask(2, new EntityAITempt(this, 0.7D, Items.beef, false));
		
		
	}
	
	public boolean isAIEnabled(){
		return true;
	}
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32.0F);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2D);
	
	}
	
	@Override
	protected ResourceLocation getLootTable(){
		return LootTableHandler.TESTMOB;
		
	}

	//this is for animals
	/*@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		
		return new EntitySapphireMob(worldObj);
	}*/

}
