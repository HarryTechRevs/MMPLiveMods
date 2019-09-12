package com.github.harrystechrevs.harryshouseimprovements;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class HHIGroup extends ItemGroup 
{
	public HHIGroup() 
	{
		super("harryshouseimprovements");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(Items.APPLE);
	}

}
