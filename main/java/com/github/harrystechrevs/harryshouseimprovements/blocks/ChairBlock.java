package com.github.harrystechrevs.harryshouseimprovements.blocks;

import com.github.harrystechrevs.harryshouseimprovements.util.VoxelShapeHelper;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class ChairBlock extends FurnitureBlock
{
	VoxelShape base = VoxelShapes.create(0.0d, 0.0d, 0.0d, 1.0d, 0.375d, 1.0d);
	VoxelShape back = VoxelShapes.create(0.0d, 0.375d, 0.0d, 1.0d, 1.0d, 0.125d);

	public ChairBlock(Properties properties, double height) 
	{
		super(properties, height);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return VoxelShapes.or(base, VoxelShapeHelper.rotate(back, state.get(FACING)));
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		return getShape(state, worldIn, pos, context);
	}
}