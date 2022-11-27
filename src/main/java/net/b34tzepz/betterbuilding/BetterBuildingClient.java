package net.b34tzepz.betterbuilding;

import net.b34tzepz.betterbuilding.entity.ModEntities;
import net.b34tzepz.betterbuilding.entity.client.RaccoonRenderer;
import net.b34tzepz.betterbuilding.entity.client.TigerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class BetterBuildingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
    }
}
