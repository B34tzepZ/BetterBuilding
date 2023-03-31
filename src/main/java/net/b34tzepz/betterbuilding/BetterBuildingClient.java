package net.b34tzepz.betterbuilding;

import net.b34tzepz.betterbuilding.screen.FabricatorScreen;
import net.b34tzepz.betterbuilding.screen.ModScreenHandlers;
import net.b34tzepz.betterbuilding.screen.TeleporterBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class BetterBuildingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.TELEPORTER_BLOCK_SCREEN_HANDLER, TeleporterBlockScreen::new);
        ScreenRegistry.register(ModScreenHandlers.FABRICATOR_SCREEN_HANDLER, FabricatorScreen::new);
    }
}
