package com.github.harrytechrevs.mmpmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mmpmod")
public class MMPMod 
{
	public static MMPMod instance;
	public static final String MODID = "mmpmod";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup MMP_GROUP = new MMPItemGroup();
	
	public MMPMod() 
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
		LOGGER.info("clientRegistries method registered.");
	}
}
