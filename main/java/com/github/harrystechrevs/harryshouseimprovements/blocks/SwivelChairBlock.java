package com.github.harrystechrevs.harryshouseimprovements.blocks;

import com.github.harrystechrevs.harryshouseimprovements.init.HHIBlocks;
import com.github.harrystechrevs.harryshouseimprovements.init.HHIItemBlocks;
import com.github.harrystechrevs.harryshouseimprovements.util.VoxelShapeHelper;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SwivelChairBlock extends FurnitureBlock
{	
	public SwivelChairBlock(Properties properties, double height) 
	{
		super(properties, height);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack)
	{
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		worldIn.setBlockState(pos.up(), HHIBlocks.swivel_chair_top.getDefaultState().with(FACING, state.get(FACING)));
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) 
	{
		super.onBlockHarvested(worldIn, pos, state, player);
		worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
	}
	
	public static class SwivelChairTopBlock extends FurnitureBlock
	{
		public SwivelChairTopBlock(Properties properties, double height) 
		{
			super(properties, height);
		}
		
		@Override
		public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
		{
			return VoxelShapeHelper.rotate(VoxelShapes.or(VoxelShapes.create(0.0625d, 0.0d, 0.0625d, 0.9375d, 0.625d, 0.125d), VoxelShapes.create(0.1875d, 0.3125d, 0.125d, 0.8125d, 0.5625d, 0.1875d)), state.get(FACING));
		}
		
		@Override
		public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) 
		{
			super.onBlockHarvested(worldIn, pos, state, player);
			worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(HHIItemBlocks.swivel_chair)));
			worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
		}
	}
}
