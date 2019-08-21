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
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ShulkerArmor extends ArmorItem
{
	boolean soundPlayed = false;
	
	public ShulkerArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) 
	{
		super(materialIn, slot, builder);
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
	{
		if(ArmorUtil.isFullSetEquipped(player, MMPItems.shulker_helmet, MMPItems.shulker_chestplate, MMPItems.shulker_leggings, MMPItems.shulker_boots))
		{
			if(soundPlayed && !player.isSneaking())
			{
				soundPlayed = false;
			}
			
			if(player.isSneaking())
			{
				player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 1, 3));
				player.addPotionEffect(new EffectInstance(Effects.WEAKNESS));
				
				if(!this.soundPlayed)
				{
					player.playSound(SoundEvents.BLOCK_SHULKER_BOX_OPEN, 1.0f, 1.0f);
					soundPlayed = true;
				}
			}
		}
	}
	
	 
}
