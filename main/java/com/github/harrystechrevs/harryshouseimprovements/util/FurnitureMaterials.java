package com.github.harrystechrevs.harryshouseimprovements.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public enum FurnitureMaterials implements IStringSerializable
{
	BASIC("basic", Blocks.IRON_BLOCK),
	WOOD("wood", Blocks.OAK_PLANKS),
	WOOL("wool", Blocks.RED_WOOL);
	
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
