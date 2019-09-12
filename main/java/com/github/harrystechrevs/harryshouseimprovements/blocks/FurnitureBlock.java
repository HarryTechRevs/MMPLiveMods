package com.github.harrystechrevs.harryshouseimprovements.blocks;

import com.github.harrystechrevs.harryshouseimprovements.entities.ChairEntity;
import com.github.harrystechrevs.harryshouseimprovements.util.FurnitureMaterials;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class FurnitureBlock extends RotatableBlock
{
	public static final EnumProperty<FurnitureMaterials> MATERIAL = EnumProperty.create("material", FurnitureMaterials.class);
	
	public FurnitureBlock(Properties properties)
	{
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(MATERIAL, FurnitureMaterials.BASIC));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(MATERIAL, FurnitureMaterials.BASIC);
	}
	
	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) 
	{
		return state.with(FACING, direction.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) 
	{
		return state.rotate(mirror.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) 
	{
		builder.add(FACING, MATERIAL);
	}
	
	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{	
		Item item = player.getHeldItemMainhand().getItem();
		for(FurnitureMaterials mat : FurnitureMaterials.values())
		{
			Item material = mat.getMaterial().getItem();
			if(material == item)
			{
				worldIn.setBlockState(pos, this.getDefaultState().with(FACING, state.get(FACING)).with(MATERIAL, mat));
				player.getHeldItemMainhand().shrink(1);
			}
			else
			{
				ChairEntity.createChair(worldIn, pos, player);
			}
		}
		
		return true;
	}
}
