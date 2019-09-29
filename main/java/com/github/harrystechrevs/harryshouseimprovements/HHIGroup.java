package com.github.harrystechrevs.harryshouseimprovements;

import com.github.harrystechrevs.harryshouseimprovements.init.HHIBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class HHIGroup extends ItemGroup 
{
	public HHIGroup() 
	{
		super("harryshouseimprovements");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(HHIBlocks.chair);
	}

}
