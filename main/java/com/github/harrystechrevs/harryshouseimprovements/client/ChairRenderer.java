package com.github.harrystechrevs.harryshouseimprovements.client;

import com.github.harrystechrevs.harryshouseimprovements.entities.ChairEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChairRenderer extends EntityRenderer<ChairEntity>
{
	public ChairRenderer(EntityRendererManager renderManager)
	{
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(ChairEntity entity) 
	{
		return null;
	}
	
	@Override
	public void doRender(ChairEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {}
}
