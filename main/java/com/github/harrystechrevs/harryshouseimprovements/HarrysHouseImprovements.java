package com.github.harrystechrevs.harryshouseimprovements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.harrystechrevs.harryshouseimprovements.client.RenderHandler;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("harryshouseimprovements")
public class HarrysHouseImprovements 
{
	public static HarrysHouseImprovements instance;
	public static final String MODID = "harryshouseimprovements";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup GROUP = new HHIGroup();
	
	public HarrysHouseImprovements() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		RenderHandler.registerEntityRenders();
		LOGGER.info("clientRegistries method registered.");
	}
}
