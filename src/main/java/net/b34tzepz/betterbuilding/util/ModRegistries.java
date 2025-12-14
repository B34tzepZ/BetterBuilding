package net.b34tzepz.betterbuilding.util;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.registry.tag.BlockTags;

import static net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry.registerOxidizableBlockPair;
import static net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry.registerWaxableBlockPair;

public class ModRegistries {
    public static void registerModRegistries() {
        registerFuels();
        registerFlammables();
        registerOxidizables();
        registerWaxables();
        registerStrippables();
    }

    private static void registerFuels() {
        BetterBuilding.LOGGER.info("Registering Fuels for {}", BetterBuilding.MOD_ID);
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModTags.Items.WOODEN_SIDES, 150); //context.baseSmeltTime() = 200
            builder.add(ModTags.Items.WOODEN_CORNERS, 300);
            builder.add(ModTags.Items.CHAIRS, 300);
            builder.add(ModTags.Items.TABLES, 300);
        });
    }

    private static void registerFlammables() {
        BetterBuilding.LOGGER.info("Registering Flammables for {}", BetterBuilding.MOD_ID);
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModTags.Blocks.WOODEN_SIDES, 5, 20);
        registry.remove(ModBlocks.Sides.CRIMSON_SIDE);
        registry.remove(ModBlocks.Sides.WARPED_SIDE);
        registry.add(ModTags.Blocks.WOODEN_CORNERS, 5, 20);
        registry.remove(ModBlocks.Corners.CRIMSON_CORNER);
        registry.remove(ModBlocks.Corners.WARPED_CORNER);
        registry.add(ModTags.Blocks.WOODEN_PILLARS, 5, 5);
        registry.remove(ModBlocks.Pillars.CRIMSON_STEM_PILLAR);
        registry.remove(ModBlocks.Pillars.STRIPPED_CRIMSON_STEM_PILLAR);
        registry.remove(ModBlocks.Pillars.CRIMSON_HYPHAE_PILLAR);
        registry.remove(ModBlocks.Pillars.STRIPPED_CRIMSON_HYPHAE_PILLAR);
        registry.remove(ModBlocks.Pillars.CRIMSON_PLANK_PILLAR);
        registry.remove(ModBlocks.Pillars.WARPED_STEM_PILLAR);
        registry.remove(ModBlocks.Pillars.STRIPPED_WARPED_STEM_PILLAR);
        registry.remove(ModBlocks.Pillars.WARPED_HYPHAE_PILLAR);
        registry.remove(ModBlocks.Pillars.STRIPPED_WARPED_HYPHAE_PILLAR);
        registry.remove(ModBlocks.Pillars.WARPED_PLANK_PILLAR);
        registry.add(BlockTags.WOOL, 30, 60);

        registry.add(ModTags.Blocks.CHAIRS, 5, 20);
        registry.remove(ModBlocks.CRIMSON_CHAIR);
        registry.remove(ModBlocks.WARPED_CHAIR);
        registry.add(ModTags.Blocks.TABLES, 5, 20);
        registry.remove(ModBlocks.CRIMSON_TABLE);
        registry.remove(ModBlocks.WARPED_TABLE);
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
        registerOxidizableBlockPair(ModBlocks.Pillars.CHISELED_COPPER_PILLAR, ModBlocks.Pillars.EXPOSED_CHISELED_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.COPPER_GRATE_PILLAR, ModBlocks.Pillars.EXPOSED_COPPER_GRATE_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.CUT_COPPER_PILLAR, ModBlocks.Pillars.EXPOSED_CUT_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.COPPER_BULB_PILLAR, ModBlocks.Pillars.EXPOSED_COPPER_BULB_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.EXPOSED_COPPER_PILLAR, ModBlocks.Pillars.WEATHERED_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.EXPOSED_CHISELED_COPPER_PILLAR, ModBlocks.Pillars.WEATHERED_CHISELED_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.EXPOSED_COPPER_GRATE_PILLAR, ModBlocks.Pillars.WEATHERED_COPPER_GRATE_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.EXPOSED_CUT_COPPER_PILLAR, ModBlocks.Pillars.WEATHERED_CUT_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.EXPOSED_COPPER_BULB_PILLAR, ModBlocks.Pillars.WEATHERED_COPPER_BULB_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.WEATHERED_COPPER_PILLAR, ModBlocks.Pillars.OXIDIZED_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.WEATHERED_CHISELED_COPPER_PILLAR, ModBlocks.Pillars.OXIDIZED_CHISELED_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.WEATHERED_COPPER_GRATE_PILLAR, ModBlocks.Pillars.OXIDIZED_COPPER_GRATE_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.WEATHERED_CUT_COPPER_PILLAR, ModBlocks.Pillars.OXIDIZED_CUT_COPPER_PILLAR);
        registerOxidizableBlockPair(ModBlocks.Pillars.WEATHERED_COPPER_BULB_PILLAR, ModBlocks.Pillars.OXIDIZED_COPPER_BULB_PILLAR);
    }

    private static void registerWaxables() {
        BetterBuilding.LOGGER.info("Registering Waxables for {}", BetterBuilding.MOD_ID);
        registerWaxableBlockPair(ModBlocks.Sides.CUT_COPPER_SIDE, ModBlocks.Sides.WAXED_CUT_COPPER_SIDE);
        registerWaxableBlockPair(ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE, ModBlocks.Sides.WAXED_EXPOSED_CUT_COPPER_SIDE);
        registerWaxableBlockPair(ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE, ModBlocks.Sides.WAXED_WEATHERED_CUT_COPPER_SIDE);
        registerWaxableBlockPair(ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE, ModBlocks.Sides.WAXED_OXIDIZED_CUT_COPPER_SIDE);

        registerWaxableBlockPair(ModBlocks.Corners.CUT_COPPER_CORNER, ModBlocks.Corners.WAXED_CUT_COPPER_CORNER);
        registerWaxableBlockPair(ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER, ModBlocks.Corners.WAXED_EXPOSED_CUT_COPPER_CORNER);
        registerWaxableBlockPair(ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER, ModBlocks.Corners.WAXED_WEATHERED_CUT_COPPER_CORNER);
        registerWaxableBlockPair(ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER, ModBlocks.Corners.WAXED_OXIDIZED_CUT_COPPER_CORNER);

        registerWaxableBlockPair(ModBlocks.Pillars.COPPER_PILLAR, ModBlocks.Pillars.WAXED_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.CHISELED_COPPER_PILLAR, ModBlocks.Pillars.WAXED_CHISELED_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.COPPER_GRATE_PILLAR, ModBlocks.Pillars.WAXED_COPPER_GRATE_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.CUT_COPPER_PILLAR, ModBlocks.Pillars.WAXED_CUT_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.COPPER_BULB_PILLAR, ModBlocks.Pillars.WAXED_COPPER_BULB_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.EXPOSED_COPPER_PILLAR, ModBlocks.Pillars.WAXED_EXPOSED_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.EXPOSED_CHISELED_COPPER_PILLAR, ModBlocks.Pillars.WAXED_EXPOSED_CHISELED_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.EXPOSED_COPPER_GRATE_PILLAR, ModBlocks.Pillars.WAXED_EXPOSED_COPPER_GRATE_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.EXPOSED_CUT_COPPER_PILLAR, ModBlocks.Pillars.WAXED_EXPOSED_CUT_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.EXPOSED_COPPER_BULB_PILLAR, ModBlocks.Pillars.WAXED_EXPOSED_COPPER_BULB_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.WEATHERED_COPPER_PILLAR, ModBlocks.Pillars.WAXED_WEATHERED_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.WEATHERED_CHISELED_COPPER_PILLAR, ModBlocks.Pillars.WAXED_WEATHERED_CHISELED_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.WEATHERED_COPPER_GRATE_PILLAR, ModBlocks.Pillars.WAXED_WEATHERED_COPPER_GRATE_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.WEATHERED_CUT_COPPER_PILLAR, ModBlocks.Pillars.WAXED_WEATHERED_CUT_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.WEATHERED_COPPER_BULB_PILLAR, ModBlocks.Pillars.WAXED_WEATHERED_COPPER_BULB_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.OXIDIZED_COPPER_PILLAR, ModBlocks.Pillars.WAXED_OXIDIZED_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.OXIDIZED_CHISELED_COPPER_PILLAR, ModBlocks.Pillars.WAXED_OXIDIZED_CHISELED_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.OXIDIZED_COPPER_GRATE_PILLAR, ModBlocks.Pillars.WAXED_OXIDIZED_COPPER_GRATE_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.OXIDIZED_CUT_COPPER_PILLAR, ModBlocks.Pillars.WAXED_OXIDIZED_CUT_COPPER_PILLAR);
        registerWaxableBlockPair(ModBlocks.Pillars.OXIDIZED_COPPER_BULB_PILLAR, ModBlocks.Pillars.WAXED_OXIDIZED_COPPER_BULB_PILLAR);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.Pillars.OAK_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_OAK_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.OAK_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_OAK_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.SPRUCE_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_SPRUCE_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.SPRUCE_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_SPRUCE_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.BIRCH_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_BIRCH_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.BIRCH_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_BIRCH_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.JUNGLE_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_JUNGLE_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.JUNGLE_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_JUNGLE_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.ACACIA_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_ACACIA_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.ACACIA_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_ACACIA_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.DARK_OAK_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_DARK_OAK_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.DARK_OAK_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_DARK_OAK_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.MANGROVE_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_MANGROVE_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.MANGROVE_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_MANGROVE_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.CHERRY_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_CHERRY_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.CHERRY_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_CHERRY_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.PALE_OAK_LOG_PILLAR, ModBlocks.Pillars.STRIPPED_PALE_OAK_LOG_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.PALE_OAK_WOOD_PILLAR, ModBlocks.Pillars.STRIPPED_PALE_OAK_WOOD_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.BAMBOO_PILLAR, ModBlocks.Pillars.STRIPPED_BAMBOO_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.CRIMSON_STEM_PILLAR, ModBlocks.Pillars.STRIPPED_CRIMSON_STEM_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.CRIMSON_HYPHAE_PILLAR, ModBlocks.Pillars.STRIPPED_CRIMSON_HYPHAE_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.WARPED_STEM_PILLAR, ModBlocks.Pillars.STRIPPED_WARPED_STEM_PILLAR);
        StrippableBlockRegistry.register(ModBlocks.Pillars.WARPED_HYPHAE_PILLAR, ModBlocks.Pillars.STRIPPED_WARPED_HYPHAE_PILLAR);
    }
}
