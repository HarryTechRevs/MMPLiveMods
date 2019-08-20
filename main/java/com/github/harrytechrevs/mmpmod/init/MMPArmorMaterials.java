package com.github.harrytechrevs.mmpmod.init;

import com.github.harrytechrevs.mmpmod.MMPMod;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum MMPArmorMaterials implements IArmorMaterial
{
	magmatic("magmatic", 30, new int[] {4, 6, 5, 3}, 20, Items.MAGMA_BLOCK, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f),
	shulker("shulker", 30, new int[] {4, 6, 5, 3}, 20, Items.SHULKER_SHELL, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	private SoundEvent equipSound;
	
	private MMPArmorMaterials(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, SoundEvent equipSound, float toughness) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return MMPMod.MODID + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return this.equipSound;
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}
