package net.b34tzepz.betterbuilding;

import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.block.entity.ModEntities;
import net.b34tzepz.betterbuilding.block.entity.client.ChairRenderer;
import net.b34tzepz.betterbuilding.screen.custom.ModScreenHandlers;
import net.b34tzepz.betterbuilding.screen.custom.TeleporterBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;

public class BetterBuildingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);
        HandledScreens.register(ModScreenHandlers.TELEPORTER_BLOCK_SCREEN_HANDLER, TeleporterBlockScreen::new);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.WHITE_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.LIGHT_GRAY_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.GRAY_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.BLACK_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.BROWN_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.RED_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.ORANGE_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.YELLOW_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.LIME_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.GREEN_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.CYAN_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.LIGHT_BLUE_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.BLUE_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.PURPLE_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.MAGENTA_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.PINK_STAINED_GLASS_PILLAR, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.COPPER_GRATE_PILLAR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.EXPOSED_COPPER_GRATE_PILLAR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.WEATHERED_COPPER_GRATE_PILLAR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.OXIDIZED_COPPER_GRATE_PILLAR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.WAXED_COPPER_GRATE_PILLAR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.WAXED_EXPOSED_COPPER_GRATE_PILLAR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.WAXED_WEATHERED_COPPER_GRATE_PILLAR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.Pillars.WAXED_OXIDIZED_COPPER_GRATE_PILLAR, BlockRenderLayer.CUTOUT);
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks./*Add Block here*/, RenderLayer.getCutout()); //for blocks with transparency like doors, many other options for rendering instead of getCutout()-
    }
}
