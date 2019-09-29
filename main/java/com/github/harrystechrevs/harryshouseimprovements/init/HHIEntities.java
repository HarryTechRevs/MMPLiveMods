package com.github.harrystechrevs.harryshouseimprovements.init;

import com.github.harrystechrevs.harryshouseimprovements.HHIRegistries;
import com.github.harrystechrevs.harryshouseimprovements.HarrysHouseImprovements;
import com.github.harrystechrevs.harryshouseimprovements.entities.ChairEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class HHIEntities 
{
	public static EntityType<?> chair = EntityType.Builder.create(ChairEntity::new, EntityClassification.MISC).size(1.0f, 0.01f).setCustomClientFactory((spawnEntity, world) -> new ChairEntity(world)).build(HarrysHouseImprovements.MODID + ":chair_entity").setRegistryName(HHIRegistries.location("chair_entity"));;
	

}
