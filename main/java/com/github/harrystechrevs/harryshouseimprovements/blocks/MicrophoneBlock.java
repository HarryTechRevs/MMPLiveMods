package com.github.harrystechrevs.harryshouseimprovements.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class MicrophoneBlock extends RotatableBlock 
{
	VoxelShape shape = VoxelShapes.create(0.3125d, 0.0d, 0.3125d, 0.6875d, 0.5625d, 0.6875d);
	
	public MicrophoneBlock(Properties properties) 
	{
		super(properties);
	}

	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) 
	{
		return false;
	}
	
	@Override
	public boolean isSolid(BlockState state) 
	{
		return false;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return shape;
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return getShape(state, worldIn, pos, context);
	}
}
