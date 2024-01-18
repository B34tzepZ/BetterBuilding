package net.b34tzepz.betterbuilding.util;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerFlammables();
    }

    private static void registerFuels() {
        BetterBuilding.LOGGER.info("Registering Fuels for {}", BetterBuilding.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModTags.Items.WOODEN_SIDES, 150);
        registry.add(ModTags.Items.WOODEN_CORNERS, 300);
        registry.remove(ModTags.Items.NON_FLAMMABLE_WOOD);

        registry.add(ModBlocks.OAK_CHAIR, 300);
        registry.add(ModBlocks.SPRUCE_CHAIR, 300);
        registry.add(ModBlocks.BIRCH_CHAIR, 300);
        registry.add(ModBlocks.JUNGLE_CHAIR, 300);
        registry.add(ModBlocks.ACACIA_CHAIR, 300);
        registry.add(ModBlocks.DARK_OAK_CHAIR, 300);

        registry.add(ModBlocks.OAK_TABLE, 300);
    }

    private static void registerFlammables() {
        BetterBuilding.LOGGER.info("Registering Flammables for {}", BetterBuilding.MOD_ID);
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.Sides.OAK_SIDE, 20, 5);
        registry.add(ModBlocks.Sides.SPRUCE_SIDE, 20, 5);
        registry.add(ModBlocks.Sides.BIRCH_SIDE, 20, 5);
        registry.add(ModBlocks.Sides.JUNGLE_SIDE, 20, 5);
        registry.add(ModBlocks.Sides.ACACIA_SIDE, 20, 5);
        registry.add(ModBlocks.Sides.DARK_OAK_SIDE, 20, 5);
        registry.add(ModBlocks.Sides.CRIMSON_SIDE, 0, 0);
        registry.add(ModBlocks.Sides.WARPED_SIDE, 0, 0);

        //registry.add(ModTags.Blocks.WOODEN_SIDES,20,5);
        //registry.remove(ModTags.Blocks.NON_FLAMMABLE_WOOD);
        //registry.add(ModTags.Blocks.NON_FLAMMABLE_WOOD, 0,0);

        registry.add(ModBlocks.Corners.OAK_CORNER,20,5);
        registry.add(ModBlocks.Corners.SPRUCE_CORNER,20,5);
        registry.add(ModBlocks.Corners.BIRCH_CORNER,20,5);
        registry.add(ModBlocks.Corners.JUNGLE_CORNER,20,5);
        registry.add(ModBlocks.Corners.ACACIA_CORNER,20,5);
        registry.add(ModBlocks.Corners.DARK_OAK_CORNER,20,5);
        registry.add(ModBlocks.Corners.CRIMSON_CORNER,0,0);
        registry.add(ModBlocks.Corners.WARPED_CORNER,0,0);

        registry.add(ModBlocks.OAK_CHAIR,20,5);
        registry.add(ModBlocks.SPRUCE_CHAIR,20,5);
        registry.add(ModBlocks.BIRCH_CHAIR,20,5);
        registry.add(ModBlocks.JUNGLE_CHAIR,20,5);
        registry.add(ModBlocks.ACACIA_CHAIR,20,5);
        registry.add(ModBlocks.DARK_OAK_CHAIR,20,5);

        registry.add(ModBlocks.OAK_TABLE,20,5);

        registry.add(ModBlocks.TELEPORTER_BLOCK, 0,0);

        registry.add(ModBlocks.FABRICATOR_BLOCK, 0,0);

    }
}
