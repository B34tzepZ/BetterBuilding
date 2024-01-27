package net.b34tzepz.betterbuilding;

import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.screen.FabricatorScreen;
import net.b34tzepz.betterbuilding.screen.ModScreenHandlers;
import net.b34tzepz.betterbuilding.screen.TeleporterBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class BetterBuildingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.TELEPORTER_BLOCK_SCREEN_HANDLER, TeleporterBlockScreen::new);
        ScreenRegistry.register(ModScreenHandlers.FABRICATOR_SCREEN_HANDLER, FabricatorScreen::new);
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks./*Add Block here*/, RenderLayer.getCutout()); //for blocks with transparency like doors, many other options for rendering instead of getCutout()-
    }
}
