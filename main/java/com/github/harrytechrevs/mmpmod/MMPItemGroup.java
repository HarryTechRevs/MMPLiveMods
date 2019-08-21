package com.github.harrytechrevs.mmpmod;

import com.github.harrytechrevs.mmpmod.init.MMPItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MMPItemGroup extends ItemGroup
{
	public MMPItemGroup() 
	{
		super("mmpgroup");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(MMPItems.magmatium);
	}
}
