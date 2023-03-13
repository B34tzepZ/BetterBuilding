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
        BetterBuilding.LOGGER.info("Registering Fuels for " + BetterBuilding.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModBlocks.OAK_SIDE, 150);
        registry.add(ModBlocks.SPRUCE_SIDE, 150);
        registry.add(ModBlocks.BIRCH_SIDE, 150);
        registry.add(ModBlocks.JUNGLE_SIDE, 150);
        registry.add(ModBlocks.ACACIA_SIDE, 150);
        registry.add(ModBlocks.DARK_OAK_SIDE, 150);

        registry.add(ModBlocks.OAK_CORNER, 300);
        registry.add(ModBlocks.SPRUCE_CORNER, 300);
        registry.add(ModBlocks.BIRCH_CORNER, 300);
        registry.add(ModBlocks.JUNGLE_CORNER, 300);
        registry.add(ModBlocks.ACACIA_CORNER, 300);
        registry.add(ModBlocks.DARK_OAK_CORNER, 300);
    }

    private static void registerFlammables() {
        BetterBuilding.LOGGER.info("Registering Flammables for " + BetterBuilding.MOD_ID);
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.OAK_SIDE, 20, 5);
        registry.add(ModBlocks.SPRUCE_SIDE, 20, 5);
        registry.add(ModBlocks.BIRCH_SIDE, 20, 5);
        registry.add(ModBlocks.JUNGLE_SIDE, 20, 5);
        registry.add(ModBlocks.ACACIA_SIDE, 20, 5);
        registry.add(ModBlocks.DARK_OAK_SIDE, 20, 5);

        registry.add(ModBlocks.OAK_CORNER,20,5);
        registry.add(ModBlocks.SPRUCE_CORNER,20,5);
        registry.add(ModBlocks.BIRCH_CORNER,20,5);
        registry.add(ModBlocks.JUNGLE_CORNER,20,5);
        registry.add(ModBlocks.ACACIA_CORNER,20,5);
        registry.add(ModBlocks.DARK_OAK_CORNER,20,5);

        registry.add(ModBlocks.TELEPORTER_BLOCK, 0,0);

    }
}
