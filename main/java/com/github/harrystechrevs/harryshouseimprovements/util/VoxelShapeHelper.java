package com.github.harrystechrevs.harryshouseimprovements.util;

import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class VoxelShapeHelper 
{
	public static VoxelShape rotate(VoxelShape shape, Direction direction)
	{
		shape = rotate(direction, shape.getStart(Direction.Axis.X), shape.getStart(Direction.Axis.Y), shape.getStart(Direction.Axis.Z), shape.getEnd(Direction.Axis.X), shape.getEnd(Direction.Axis.Y), shape.getEnd(Direction.Axis.Z));
		return shape;
	}

	private static VoxelShape rotate(Direction direction, double startX, double startY, double startZ, double endX, double endY, double endZ) 
	{
		double tempStartX = startX;
		double tempEndX = endX;
		double tempStartZ = startZ;
		double tempEndZ = endZ;
		
		switch(direction)
		{
		case EAST:
			startZ = 1 - tempStartX;
			endZ = 1 - tempEndX;
			startX = tempStartZ;
			endX = tempEndZ;
			break;
		case WEST:
			startZ = tempStartX;
			endZ = tempEndX;
			startX = 1- tempStartZ;
			endX = 1 - tempEndZ;
			break;
		case SOUTH:
			endZ = tempStartZ;
			startZ = tempEndZ;
			endX = tempStartX;
			startX = tempEndX;
			break;
		case NORTH:
			endZ = 1 - tempEndZ;
			startZ = 1 - tempStartZ;
			break;
		default:
			break;
		}
		
		return VoxelShapes.create(startX, startY, startZ, endX, endY, endZ);
	}
	
	
}
