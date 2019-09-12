package com.github.harrystechrevs.harryshouseimprovements.blocks;

import com.github.harrystechrevs.harryshouseimprovements.util.VoxelShapeHelper;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class VoxelShapeBlock extends RotatableBlock
{
	VoxelShape shape;

	public VoxelShapeBlock(Properties properties, VoxelShape shape) 
	{
		super(properties);
		this.shape = shape;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return VoxelShapeHelper.rotate(shape, state.get(FACING));
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return getShape(state, worldIn, pos, context);
	}
}
