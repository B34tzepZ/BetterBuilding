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
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.TINTED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.WHITE_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.ORANGE_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.MAGENTA_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.LIGHT_BLUE_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.YELLOW_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.LIME_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.PINK_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.GRAY_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.LIGHT_GRAY_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.CYAN_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.PURPLE_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.BLUE_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.BROWN_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.GREEN_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.RED_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Pillars.BLACK_STAINED_GLASS_PILLAR,RenderLayer.getTranslucent());
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks./*Add Block here*/, RenderLayer.getCutout()); //for blocks with transparency like doors, many other options for rendering instead of getCutout()-
    }
}
