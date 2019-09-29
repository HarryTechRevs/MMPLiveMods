package com.github.harrystechrevs.harryshouseimprovements.entities;

import com.github.harrystechrevs.harryshouseimprovements.HHIRegistries;
import com.github.harrystechrevs.harryshouseimprovements.init.HHIEntities;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ChairEntity extends Entity
{
	private BlockPos chairPos;
	
	public ChairEntity(World world)
	{
		this(HHIEntities.chair, world);
	}
	
	public ChairEntity(EntityType<?> type, World world)
	{
		super(HHIEntities.chair, world);
		this.noClip = true;
	}
	
	private ChairEntity(EntityType<?> type, World world, BlockPos pos, double height) 
	{
		this(type, world);
		this.chairPos = pos;
		this.setPosition(chairPos.getX() + 0.5d, chairPos.getY() + height, chairPos.getZ() + 0.5d);
	}
	
	@Override
	public void tick() 
	{
		super.tick();
		if(chairPos == null) chairPos = this.getPosition();
		if(!world.isRemote)
		{
			if(this.getPassengers().isEmpty() || world.getBlockState(chairPos).getBlock() == Blocks.AIR)
			{
				this.remove();
			}
		}		
	}
	
	@Override
	protected void registerData() {}

	@Override
	protected void readAdditional(CompoundNBT compound) {}

	@Override
	protected void writeAdditional(CompoundNBT compound) {}

	@Override
	public IPacket<?> createSpawnPacket()
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	protected boolean canBeRidden(Entity entityIn) 
	{
		return true;
	}

	public static boolean createChair(World world, BlockPos pos, PlayerEntity player, double height)
	{
		if(!world.isRemote)
		{		
			if(world.getEntitiesWithinAABB(ChairEntity.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0d, pos.getY() + 1.0d, pos.getZ() + 1.0d)).isEmpty())
			{
				ChairEntity entity = new ChairEntity(HHIEntities.chair, world, pos, height);
				world.addEntity(entity);
				player.startRiding(entity);
				HHIRegistries.LOGGER.debug("entity spawned");
			}
		}
		
		return true;
	}
}
