package net.b34tzepz.betterbuilding;

import net.b34tzepz.betterbuilding.entity.ModEntities;
import net.b34tzepz.betterbuilding.entity.client.RaccoonRenderer;
import net.b34tzepz.betterbuilding.entity.client.TigerRenderer;
import net.b34tzepz.betterbuilding.screen.ModScreenHandlers;
import net.b34tzepz.betterbuilding.screen.TeleporterBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class BetterBuildingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        ScreenRegistry.register(ModScreenHandlers.TELEPORTER_BLOCK_SCREEN_HANDLER, TeleporterBlockScreen::new);
    }
}
