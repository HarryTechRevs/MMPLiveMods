package com.github.harrytechrevs.mmpmod;

import org.apache.logging.log4j.Logger;

import com.github.harrytechrevs.mmpmod.init.MMPArmorMaterials;
import com.github.harrytechrevs.mmpmod.init.MMPItems;
import com.github.harrytechrevs.mmpmod.items.MagmaticArmor;
import com.github.harrytechrevs.mmpmod.items.ShulkerArmor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class MMPModRegistries 
{
	public static final ItemGroup MMP_GROUP = MMPMod.MMP_GROUP;
	public static final Logger LOGGER = MMPMod.LOGGER;
	public static final String MODID = MMPMod.MODID;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			MMPItems.test_item = new Item(new Item.Properties().group(MMP_GROUP)).setRegistryName(location("test_item")),
			MMPItems.magmatium = new Item(new Item.Properties().group(MMP_GROUP)).setRegistryName(location("magmatium")),
			
			MMPItems.magmatic_helmet = new MagmaticArmor(MMPArmorMaterials.magmatic, EquipmentSlotType.HEAD, new Item.Properties().group(MMP_GROUP)).setRegistryName(location("magmatic_helmet")),
			MMPItems.magmatic_chestplate = new MagmaticArmor(MMPArmorMaterials.magmatic, EquipmentSlotType.CHEST, new Item.Properties().group(MMP_GROUP)).setRegistryName(location("magmatic_chestplate")),
			MMPItems.magmatic_leggings = new MagmaticArmor(MMPArmorMaterials.magmatic, EquipmentSlotType.LEGS, new Item.Properties().group(MMP_GROUP)).setRegistryName(location("magmatic_leggings")),
			MMPItems.magmatic_boots = new MagmaticArmor(MMPArmorMaterials.magmatic, EquipmentSlotType.FEET, new Item.Properties().group(MMP_GROUP)).setRegistryName(location("magmatic_boots")),										
		
			MMPItems.shulker_helmet = new ShulkerArmor(MMPArmorMaterials.shulker, EquipmentSlotType.HEAD, new Item.Properties().group(MMP_GROUP)).setRegistryName(location("shulker_helmet")),
			MMPItems.shulker_chestplate = new ShulkerArmor(MMPArmorMaterials.shulker, EquipmentSlotType.CHEST, new Item.Properties().group(MMP_GROUP)).setRegistryName(location("shulker_chestplate")),
			MMPItems.shulker_leggings = new ShulkerArmor(MMPArmorMaterials.shulker, EquipmentSlotType.LEGS, new Item.Properties().group(MMP_GROUP)).setRegistryName(location("shulker_leggings")),
			MMPItems.shulker_boots = new ShulkerArmor(MMPArmorMaterials.shulker, EquipmentSlotType.FEET, new Item.Properties().group(MMP_GROUP)).setRegistryName(location("shulker_boots"))												
		);
				
		LOGGER.info("Items registered.");
	}
	
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(MODID, name);
	}
}	
