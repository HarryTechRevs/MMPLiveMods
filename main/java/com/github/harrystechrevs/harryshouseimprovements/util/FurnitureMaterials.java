package com.github.harrystechrevs.harryshouseimprovements.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public enum FurnitureMaterials implements IStringSerializable
{
	BASIC("basic", Blocks.IRON_BLOCK),
	OAK("oak", Blocks.OAK_PLANKS),
	SPRUCE("spruce", Blocks.SPRUCE_PLANKS),
	BIRCH("birch", Blocks.BIRCH_PLANKS),
	ACACIA("acacia", Blocks.ACACIA_PLANKS),
	DARK_OAK("dark_oak", Blocks.DARK_OAK_PLANKS),
	JUNGLE("jungle", Blocks.JUNGLE_PLANKS);
	
	private String name;
	private Block material;
	
	private FurnitureMaterials(String name, Block material) 
	{
		this.name = name;
		this.material = material;
	}
	
	@Override
	public String getName() 
	{
		return name;
	}
	
	public ItemStack getMaterial()
	{
		return new ItemStack(material);
	}
}
