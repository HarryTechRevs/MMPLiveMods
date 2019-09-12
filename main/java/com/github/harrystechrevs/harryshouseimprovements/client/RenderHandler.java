package com.github.harrystechrevs.harryshouseimprovements.client;

import com.github.harrystechrevs.harryshouseimprovements.entities.ChairEntity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(ChairEntity.class, ChairRenderer::new);
	}
}
