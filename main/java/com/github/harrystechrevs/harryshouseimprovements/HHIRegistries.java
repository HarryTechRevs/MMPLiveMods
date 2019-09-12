package com.github.harrystechrevs.harryshouseimprovements;

import org.apache.logging.log4j.Logger;

import com.github.harrystechrevs.harryshouseimprovements.blocks.ChairBlock;
import com.github.harrystechrevs.harryshouseimprovements.blocks.SofaCornerBlock;
import com.github.harrystechrevs.harryshouseimprovements.blocks.VoxelShapeBlock;
import com.github.harrystechrevs.harryshouseimprovements.init.HHIBlocks;
import com.github.harrystechrevs.harryshouseimprovements.init.HHIEntities;
import com.github.harrystechrevs.harryshouseimprovements.init.HHIItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class HHIRegistries 
{
	public static final ItemGroup GROUP = HarrysHouseImprovements.GROUP;
	public static final Logger LOGGER = HarrysHouseImprovements.LOGGER;
	public static final String MODID = HarrysHouseImprovements.MODID;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll
		(
			HHIBlocks.basic_chair = new ChairBlock(Block.Properties.create(Material.ROCK)).setRegistryName(location("chair")),
			HHIBlocks.basic_sofa = new ChairBlock(Block.Properties.create(Material.ROCK)).setRegistryName(location("sofa")),
			HHIBlocks.basic_sofa_corner = new SofaCornerBlock(Block.Properties.create(Material.ROCK)).setRegistryName(location("sofa_corner")),
			HHIBlocks.monitor = new VoxelShapeBlock(Block.Properties.create(Material.ROCK), VoxelShapes.create(0.0625, 0.0d, 0.375d, 0.9375, 0.75d, 0.625d)).setRegistryName(location("monitor")),
			HHIBlocks.microphone = new VoxelShapeBlock(Block.Properties.create(Material.ROCK), VoxelShapes.create(0.3125d, 0.0d, 0.3125d, 0.6875d, 0.5625d, 0.6875d)).setRegistryName(location("microphone"))
		);
				
		LOGGER.info("Items registered.");
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			HHIItemBlocks.basic_chair = new BlockItem(HHIBlocks.basic_chair, new Item.Properties().group(GROUP)).setRegistryName(location("chair")),
			HHIItemBlocks.basic_sofa = new BlockItem(HHIBlocks.basic_sofa, new Item.Properties().group(GROUP)).setRegistryName(location("sofa")),
			HHIItemBlocks.basic_sofa_corner = new BlockItem(HHIBlocks.basic_sofa_corner, new Item.Properties().group(GROUP)).setRegistryName(location("sofa_corner")),
			HHIItemBlocks.monitor = new BlockItem(HHIBlocks.monitor, new Item.Properties().group(GROUP)).setRegistryName(location("monitor")),
			HHIItemBlocks.microphone = new BlockItem(HHIBlocks.microphone, new Item.Properties().group(GROUP)).setRegistryName(location("microphone"))
		);
				
		LOGGER.info("Items registered.");
	}
	
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
	{
		event.getRegistry().registerAll
		(
			HHIEntities.chair
		);
				
		LOGGER.info("Items registered.");
	}
	
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(MODID, name);
	}
}	
