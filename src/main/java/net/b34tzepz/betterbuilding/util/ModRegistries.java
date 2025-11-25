package net.b34tzepz.betterbuilding.util;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

import static net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry.registerOxidizableBlockPair;

public class ModRegistries {
    public static void registerModRegistries() {
        registerFuels();
        registerFlammables();
        registerOxidizables();
    }

    private static void registerFuels() {
        BetterBuilding.LOGGER.info("Registering Fuels for {}", BetterBuilding.MOD_ID);
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModTags.Items.WOODEN_SIDES, 150); //context.baseSmeltTime() = 200
            builder.add(ModTags.Items.WOODEN_CORNERS, 300);
            builder.remove(ModTags.Items.NON_FLAMMABLE_WOOD);

            builder.add(ModBlocks.OAK_CHAIR, 300);
            builder.add(ModBlocks.SPRUCE_CHAIR, 300);
            builder.add(ModBlocks.BIRCH_CHAIR, 300);
            builder.add(ModBlocks.JUNGLE_CHAIR, 300);
            builder.add(ModBlocks.ACACIA_CHAIR, 300);
            builder.add(ModBlocks.DARK_OAK_CHAIR, 300);

            builder.add(ModBlocks.OAK_TABLE, 300);
        });
    }

    private static void registerFlammables() {
        BetterBuilding.LOGGER.info("Registering Flammables for {}", BetterBuilding.MOD_ID);
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.Sides.OAK_SIDE, 5, 20);
        registry.add(ModBlocks.Sides.SPRUCE_SIDE, 5, 20);
        registry.add(ModBlocks.Sides.BIRCH_SIDE, 5, 20);
        registry.add(ModBlocks.Sides.JUNGLE_SIDE, 5, 20);
        registry.add(ModBlocks.Sides.ACACIA_SIDE, 5, 20);
        registry.add(ModBlocks.Sides.DARK_OAK_SIDE, 5, 20);
        registry.add(ModBlocks.Sides.CRIMSON_SIDE, 0, 0);
        registry.add(ModBlocks.Sides.WARPED_SIDE, 0, 0);

        //registry.add(ModTags.Blocks.WOODEN_SIDES,20,5);       Registry already frozen
        //registry.remove(ModTags.Blocks.NON_FLAMMABLE_WOOD);

        registry.add(ModBlocks.Corners.OAK_CORNER, 5, 20);
        registry.add(ModBlocks.Corners.SPRUCE_CORNER, 5, 20);
        registry.add(ModBlocks.Corners.BIRCH_CORNER, 5, 20);
        registry.add(ModBlocks.Corners.JUNGLE_CORNER, 5, 20);
        registry.add(ModBlocks.Corners.ACACIA_CORNER, 5, 20);
        registry.add(ModBlocks.Corners.DARK_OAK_CORNER, 5, 20);

        registry.add(ModBlocks.OAK_CHAIR, 5, 20);
        registry.add(ModBlocks.SPRUCE_CHAIR, 5, 20);
        registry.add(ModBlocks.BIRCH_CHAIR, 5, 20);
        registry.add(ModBlocks.JUNGLE_CHAIR, 5, 20);
        registry.add(ModBlocks.ACACIA_CHAIR, 5, 20);
        registry.add(ModBlocks.DARK_OAK_CHAIR, 5, 20);

        registry.add(ModBlocks.OAK_TABLE, 5, 20);
    }

    private static void registerOxidizables() {
        BetterBuilding.LOGGER.info("Registering Oxidizables for {}", BetterBuilding.MOD_ID);
        registerOxidizableBlockPair(ModBlocks.Sides.CUT_COPPER_SIDE, ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE);
        registerOxidizableBlockPair(ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE, ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE);
        registerOxidizableBlockPair(ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE, ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE);
        registerOxidizableBlockPair(ModBlocks.Corners.CUT_COPPER_CORNER, ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER);
        registerOxidizableBlockPair(ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER, ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER);
        registerOxidizableBlockPair(ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER, ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER);
        registerOxidizableBlockPair(ModBlocks.Pillars.COPPER_PILLAR, ModBlocks.Pillars.EXPOSED_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.EXPOSED_COPPER_PILLAR, ModBlocks.Pillars.WEATHERED_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.WEATHERED_COPPER_PILLAR, ModBlocks.Pillars.OXIDIZED_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.CUT_COPPER_PILLAR, ModBlocks.Pillars.EXPOSED_CUT_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.EXPOSED_CUT_COPPER_PILLAR, ModBlocks.Pillars.WEATHERED_CUT_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.WEATHERED_CUT_COPPER_PILLAR, ModBlocks.Pillars.OXIDIZED_CUT_COPPER_PILLAR);
    }
}
