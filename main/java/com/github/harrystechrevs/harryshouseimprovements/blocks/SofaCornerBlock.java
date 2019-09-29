package com.github.harrystechrevs.harryshouseimprovements.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class SofaCornerBlock extends FurnitureBlock
{
	VoxelShape base = VoxelShapes.create(0.0d, 0.0d, 0.0d, 1.0d, 0.375d, 1.0d);
	VoxelShape backSouth = VoxelShapes.or(VoxelShapes.create(0.0d, 0.375d, 0.0d, 1.0d, 1.0d, 0.125d), VoxelShapes.create(0.0d, 0.375d, 0.0d, 0.125d, 1.0d, 1.0d));
	VoxelShape backWest = VoxelShapes.or(VoxelShapes.create(0.0d, 0.375d, 0.0d, 1.0d, 1.0d, 0.125d), VoxelShapes.create(0.875d, 0.375d, 0.0d, 1.0d, 1.0d, 1.0d));
	VoxelShape backNorth = VoxelShapes.or(VoxelShapes.create(0.875d, 0.375d, 0.0d, 1.0d, 1.0d, 1.0d), VoxelShapes.create(0.0d, 0.375d, 0.875d, 1.0d, 1.0d, 1.0d));
	VoxelShape backEast = VoxelShapes.or(VoxelShapes.create(0.0d, 0.375d, 0.0d, 0.125d, 1.0d, 1.0d), VoxelShapes.create(0.0d, 0.375d, 0.875d, 1.0d, 1.0d, 1.0d));
	
	public SofaCornerBlock(Properties properties) 
	{
		super(properties, 0.2d);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
	{
		switch(state.get(FACING))
		{
		case NORTH:
			return VoxelShapes.or(base, backNorth);
		case EAST:
			return VoxelShapes.or(base, backEast);
		case SOUTH:
			return VoxelShapes.or(base, backSouth);
		case WEST:
			return VoxelShapes.or(base, backWest);
		default:
			return VoxelShapes.or(base, backNorth);
		}
	}
}
