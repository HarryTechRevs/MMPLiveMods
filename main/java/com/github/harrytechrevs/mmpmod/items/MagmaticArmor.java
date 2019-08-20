package com.github.harrytechrevs.mmpmod.items;

import com.github.harrytechrevs.mmpmod.init.MMPItems;
import com.github.harrytechrevs.mmpmod.util.ArmorUtil;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class MagmaticArmor extends ArmorItem
{
	public MagmaticArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) 
	{
		super(materialIn, slot, builder);
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
	{
		if(ArmorUtil.isFullSetEquipped(player, MMPItems.magmatic_helmet, MMPItems.magmatic_chestplate, MMPItems.magmatic_leggings, MMPItems.magmatic_boots))
		{
			player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE));
		}
	}
}
