package net.b34tzepz.betterbuilding.block;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.custom.*;
import net.b34tzepz.betterbuilding.block.custom.PillarBlock;
import net.b34tzepz.betterbuilding.block.custom.StairsBlock;
import net.b34tzepz.betterbuilding.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block REINFORCED_OAK_PLANKS = registerBlock("reinforced_oak_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block REINFORCED_SPRUCE_PLANKS = registerBlock("reinforced_spruce_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block REINFORCED_BIRCH_PLANKS = registerBlock("reinforced_birch_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static class Sides{
        public static final Block CUT_COPPER_SIDE = registerBlock("cut_copper_side",
                new OxidizableSideBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.CUT_COPPER_SLAB)), ModItemGroup.Building);

        public static final Block EXPOSED_CUT_COPPER_SIDE = registerBlock("exposed_cut_copper_side",
                new OxidizableSideBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.EXPOSED_CUT_COPPER_SLAB)), ModItemGroup.Building);

        public static final Block WEATHERED_CUT_COPPER_SIDE = registerBlock("weathered_cut_copper_side",
                new OxidizableSideBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.WEATHERED_CUT_COPPER_SLAB)), ModItemGroup.Building);

        public static final Block OXIDIZED_CUT_COPPER_SIDE = registerBlock("oxidized_cut_copper_side",
                new OxidizableSideBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.OXIDIZED_CUT_COPPER_SLAB)), ModItemGroup.Building);

        public static final Block WAXED_CUT_COPPER_SIDE = registerBlock("waxed_cut_copper_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.WAXED_CUT_COPPER_SLAB)), ModItemGroup.Building);

        public static final Block WAXED_EXPOSED_CUT_COPPER_SIDE = registerBlock("waxed_exposed_cut_copper_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB)), ModItemGroup.Building);
        public static final Block WAXED_WEATHERED_CUT_COPPER_SIDE = registerBlock("waxed_weathered_cut_copper_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB)), ModItemGroup.Building);

        public static final Block WAXED_OXIDIZED_CUT_COPPER_SIDE = registerBlock("waxed_oxidized_cut_copper_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB)), ModItemGroup.Building);

        public static final Block OAK_SIDE = registerBlock("oak_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)), ModItemGroup.Building);

        public static final Block SPRUCE_SIDE = registerBlock("spruce_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_SLAB)), ModItemGroup.Building);

        public static final Block BIRCH_SIDE = registerBlock("birch_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_SLAB)), ModItemGroup.Building);

        public static final Block JUNGLE_SIDE = registerBlock("jungle_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_SLAB)), ModItemGroup.Building);

        public static final Block ACACIA_SIDE = registerBlock("acacia_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_SLAB)), ModItemGroup.Building);

        public static final Block DARK_OAK_SIDE = registerBlock("dark_oak_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_SLAB)), ModItemGroup.Building);

        public static final Block CRIMSON_SIDE = registerBlock("crimson_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_SLAB)), ModItemGroup.Building);

        public static final Block WARPED_SIDE = registerBlock("warped_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB)), ModItemGroup.Building);

        public static final Block STONE_SIDE = registerBlock("stone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.STONE_SLAB)), ModItemGroup.Building);

        public static final Block SMOOTH_STONE_SIDE = registerBlock("smooth_stone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_STONE_SLAB)), ModItemGroup.Building);

        public static final Block SANDSTONE_SIDE = registerBlock("sandstone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB)), ModItemGroup.Building);

        public static final Block CUT_SANDSTONE_SIDE = registerBlock("cut_sandstone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE_SLAB)), ModItemGroup.Building);

        public static final Block COBBLESTONE_SIDE = registerBlock("cobblestone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE_SLAB)), ModItemGroup.Building);

        public static final Block BRICK_SIDE = registerBlock("brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.BRICK_SLAB)), ModItemGroup.Building);

        public static final Block STONE_BRICK_SIDE = registerBlock("stone_brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_SLAB)), ModItemGroup.Building);

        public static final Block NETHER_BRICK_SIDE = registerBlock("nether_brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_SLAB)), ModItemGroup.Building);

        public static final Block QUARTZ_SIDE = registerBlock("quartz_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_SLAB)), ModItemGroup.Building);

        public static final Block RED_SANDSTONE_SIDE = registerBlock("red_sandstone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.RED_SANDSTONE_SLAB)), ModItemGroup.Building);

        public static final Block CUT_RED_SANDSTONE_SIDE = registerBlock("cut_red_sandstone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.CUT_RED_SANDSTONE_SLAB)), ModItemGroup.Building);

        public static final Block PURPUR_SIDE = registerBlock("purpur_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.PURPUR_SLAB)), ModItemGroup.Building);

        public static final Block PRISMARINE_SIDE = registerBlock("prismarine_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB)), ModItemGroup.Building);

        public static final Block PRISMARINE_BRICK_SIDE = registerBlock("prismarine_brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICK_SLAB)), ModItemGroup.Building);

        public static final Block DARK_PRISMARINE_SIDE = registerBlock("dark_prismarine_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.DARK_PRISMARINE_SLAB)), ModItemGroup.Building);

        public static final Block POLISHED_GRANITE_SIDE = registerBlock("polished_granite_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE_SLAB)), ModItemGroup.Building);

        public static final Block SMOOTH_RED_SANDSTONE_SIDE = registerBlock("smooth_red_sandstone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_RED_SANDSTONE_SLAB)), ModItemGroup.Building);

        public static final Block MOSSY_STONE_BRICK_SIDE = registerBlock("mossy_stone_brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_STONE_BRICK_SLAB)), ModItemGroup.Building);

        public static final Block POLISHED_DIORITE_SIDE = registerBlock("polished_diorite_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE_SLAB)), ModItemGroup.Building);

        public static final Block MOSSY_COBBLESTONE_SIDE = registerBlock("mossy_cobblestone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_COBBLESTONE_SLAB)), ModItemGroup.Building);

        public static final Block END_STONE_BRICK_SIDE = registerBlock("end_stone_brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICK_SLAB)), ModItemGroup.Building);

        public static final Block SMOOTH_SANDSTONE_SIDE = registerBlock("smooth_sandstone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE_SLAB)), ModItemGroup.Building);

        public static final Block SMOOTH_QUARTZ_SIDE = registerBlock("smooth_quartz_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB)), ModItemGroup.Building);

        public static final Block GRANITE_SIDE = registerBlock("granite_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_SLAB)), ModItemGroup.Building);

        public static final Block ANDESITE_SIDE = registerBlock("andesite_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE_SLAB)), ModItemGroup.Building);

        public static final Block RED_NETHER_BRICK_SIDE = registerBlock("red_nether_brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICK_SLAB)), ModItemGroup.Building);

        public static final Block POLISHED_ANDESITE_SIDE = registerBlock("polished_andesite_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE_SLAB)), ModItemGroup.Building);

        public static final Block DIORITE_SIDE = registerBlock("diorite_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.DIORITE_SLAB)), ModItemGroup.Building);

        public static final Block COBBLED_DEEPSLATE_SIDE = registerBlock("cobbled_deepslate_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE_SLAB)), ModItemGroup.Building);

        public static final Block POLISHED_DEEPSLATE_SIDE = registerBlock("polished_deepslate_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE_SLAB)), ModItemGroup.Building);

        public static final Block DEEPSLATE_BRICK_SIDE = registerBlock("deepslate_brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_BRICK_SLAB)), ModItemGroup.Building);

        public static final Block DEEPSLATE_TILE_SIDE = registerBlock("deepslate_tile_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_TILE_SLAB)), ModItemGroup.Building);

        public static final Block BLACKSTONE_SIDE = registerBlock("blackstone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.BLACKSTONE_SLAB)), ModItemGroup.Building);

        public static final Block POLISHED_BLACKSTONE_SIDE = registerBlock("polished_blackstone_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_SLAB)), ModItemGroup.Building);

        public static final Block POLISHED_BLACKSTONE_BRICK_SIDE = registerBlock("polished_blackstone_brick_side",
                new SideBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB)), ModItemGroup.Building);
    }

    public static final Block SMOOTH_STONE_STAIRS = registerBlock("smooth_stone_stairs",
            new StairsBlock(Blocks.SMOOTH_STONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SMOOTH_STONE)), ModItemGroup.Building);

    public static final Block CUT_SANDSTONE_STAIRS = registerBlock("cut_sandstone_stairs",
            new StairsBlock(Blocks.CUT_SANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE)), ModItemGroup.Building);

    public static final Block CUT_RED_SANDSTONE_STAIRS = registerBlock("cut_red_sandstone_stairs",
            new StairsBlock(Blocks.CUT_RED_SANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CUT_RED_SANDSTONE)), ModItemGroup.Building);

    public static class Corners{
        public static final Block CUT_COPPER_CORNER = registerBlock("cut_copper_corner",
                new OxidizableCornerBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.CUT_COPPER_STAIRS)), ModItemGroup.Building);

        public static final Block EXPOSED_CUT_COPPER_CORNER = registerBlock("exposed_cut_copper_corner",
                new OxidizableCornerBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.EXPOSED_CUT_COPPER_STAIRS)), ModItemGroup.Building);

        public static final Block WEATHERED_CUT_COPPER_CORNER = registerBlock("weathered_cut_copper_corner",
                new OxidizableCornerBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.WEATHERED_CUT_COPPER_STAIRS)), ModItemGroup.Building);

        public static final Block OXIDIZED_CUT_COPPER_CORNER = registerBlock("oxidized_cut_copper_corner",
                new OxidizableCornerBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.OXIDIZED_CUT_COPPER_STAIRS)), ModItemGroup.Building);

        public static final Block WAXED_CUT_COPPER_CORNER = registerBlock("waxed_cut_copper_corner",
                new OxidizableCornerBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.WAXED_CUT_COPPER_STAIRS)), ModItemGroup.Building);

        public static final Block WAXED_EXPOSED_CUT_COPPER_CORNER = registerBlock("waxed_exposed_cut_copper_corner",
                new OxidizableCornerBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS)), ModItemGroup.Building);

        public static final Block WAXED_WEATHERED_CUT_COPPER_CORNER = registerBlock("waxed_weathered_cut_copper_corner",
                new OxidizableCornerBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS)), ModItemGroup.Building);

        public static final Block WAXED_OXIDIZED_CUT_COPPER_CORNER = registerBlock("waxed_oxidized_cut_copper_corner",
                new OxidizableCornerBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS)), ModItemGroup.Building);

        public static final Block OAK_CORNER = registerBlock("oak_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)), ModItemGroup.Building);

        public static final Block SPRUCE_CORNER = registerBlock("spruce_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_STAIRS)), ModItemGroup.Building);

        public static final Block BIRCH_CORNER = registerBlock("birch_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_STAIRS)), ModItemGroup.Building);

        public static final Block JUNGLE_CORNER = registerBlock("jungle_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_STAIRS)), ModItemGroup.Building);

        public static final Block ACACIA_CORNER = registerBlock("acacia_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_STAIRS)), ModItemGroup.Building);

        public static final Block DARK_OAK_CORNER = registerBlock("dark_oak_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_STAIRS)), ModItemGroup.Building);

        public static final Block CRIMSON_CORNER = registerBlock("crimson_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_STAIRS)), ModItemGroup.Building);

        public static final Block WARPED_CORNER = registerBlock("warped_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.WARPED_STAIRS)), ModItemGroup.Building);

        public static final Block STONE_CORNER = registerBlock("stone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.STONE_STAIRS)), ModItemGroup.Building);

        public static final Block SMOOTH_STONE_CORNER = registerBlock("smooth_stone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(ModBlocks.SMOOTH_STONE_STAIRS)), ModItemGroup.Building);

        public static final Block SANDSTONE_CORNER = registerBlock("sandstone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS)), ModItemGroup.Building);

        public static final Block CUT_SANDSTONE_CORNER = registerBlock("cut_sandstone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(ModBlocks.CUT_SANDSTONE_STAIRS)), ModItemGroup.Building);

        public static final Block COBBLESTONE_CORNER = registerBlock("cobblestone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE_STAIRS)), ModItemGroup.Building);

        public static final Block BRICK_CORNER = registerBlock("brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.BRICK_STAIRS)), ModItemGroup.Building);

        public static final Block STONE_BRICK_CORNER = registerBlock("stone_brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_STAIRS)), ModItemGroup.Building);

        public static final Block NETHER_BRICK_CORNER = registerBlock("nether_brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_STAIRS)), ModItemGroup.Building);

        public static final Block QUARTZ_CORNER = registerBlock("quartz_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_STAIRS)), ModItemGroup.Building);

        public static final Block RED_SANDSTONE_CORNER = registerBlock("red_sandstone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.RED_SANDSTONE_STAIRS)), ModItemGroup.Building);

        public static final Block CUT_RED_SANDSTONE_CORNER = registerBlock("cut_red_sandstone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(ModBlocks.CUT_RED_SANDSTONE_STAIRS)), ModItemGroup.Building);

        public static final Block PURPUR_CORNER = registerBlock("purpur_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.PURPUR_STAIRS)), ModItemGroup.Building);

        public static final Block PRISMARINE_CORNER = registerBlock("prismarine_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS)), ModItemGroup.Building);

        public static final Block PRISMARINE_BRICK_CORNER = registerBlock("prismarine_brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICK_STAIRS)), ModItemGroup.Building);

        public static final Block DARK_PRISMARINE_CORNER = registerBlock("dark_prismarine_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.DARK_PRISMARINE_STAIRS)), ModItemGroup.Building);

        public static final Block POLISHED_GRANITE_CORNER = registerBlock("polished_granite_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE_STAIRS)), ModItemGroup.Building);

        public static final Block SMOOTH_RED_SANDSTONE_CORNER = registerBlock("smooth_red_sandstone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_RED_SANDSTONE_STAIRS)), ModItemGroup.Building);

        public static final Block MOSSY_STONE_BRICK_CORNER = registerBlock("mossy_stone_brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_STONE_BRICK_STAIRS)), ModItemGroup.Building);

        public static final Block POLISHED_DIORITE_CORNER = registerBlock("polished_diorite_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE_STAIRS)), ModItemGroup.Building);

        public static final Block MOSSY_COBBLESTONE_CORNER = registerBlock("mossy_cobblestone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_COBBLESTONE_STAIRS)), ModItemGroup.Building);

        public static final Block END_STONE_BRICK_CORNER = registerBlock("end_stone_brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICK_STAIRS)), ModItemGroup.Building);

        public static final Block SMOOTH_SANDSTONE_CORNER = registerBlock("smooth_sandstone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE_STAIRS)), ModItemGroup.Building);

        public static final Block SMOOTH_QUARTZ_CORNER = registerBlock("smooth_quartz_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS)), ModItemGroup.Building);

        public static final Block GRANITE_CORNER = registerBlock("granite_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.GRANITE_STAIRS)), ModItemGroup.Building);

        public static final Block ANDESITE_CORNER = registerBlock("andesite_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE_STAIRS)), ModItemGroup.Building);

        public static final Block RED_NETHER_BRICK_CORNER = registerBlock("red_nether_brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICK_STAIRS)), ModItemGroup.Building);

        public static final Block POLISHED_ANDESITE = registerBlock("polished_andesite_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE_STAIRS)), ModItemGroup.Building);

        public static final Block DIORITE_CORNER = registerBlock("diorite_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.DIORITE_STAIRS)), ModItemGroup.Building);

        public static final Block COBBLED_DEEPSLATE_CORNER = registerBlock("cobbled_deepslate_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE_STAIRS)), ModItemGroup.Building);

        public static final Block POLISHED_DEEPSLATE_CORNER = registerBlock("polished_deepslate_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE_STAIRS)), ModItemGroup.Building);

        public static final Block DEEPSLATE_BRICK_CORNER = registerBlock("deepslate_brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_BRICK_STAIRS)), ModItemGroup.Building);

        public static final Block DEEPSLATE_TILE_CORNER = registerBlock("deepslate_tile_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_TILE_STAIRS)), ModItemGroup.Building);

        public static final Block BLACKSTONE_CORNER = registerBlock("blackstone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.BLACKSTONE_STAIRS)), ModItemGroup.Building);

        public static final Block POLISHED_BLACKSTONE_CORNER = registerBlock("polished_blackstone_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_STAIRS)), ModItemGroup.Building);

        public static final Block POLISHED_BLACKSTONE_BRICK_CORNER = registerBlock("polished_blackstone_brick_corner",
                new CornerBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS)), ModItemGroup.Building);


    }

    public static final Block OAK_CHAIR = registerBlock("oak_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block SPRUCE_CHAIR = registerBlock("spruce_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block BIRCH_CHAIR = registerBlock("birch_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block JUNGLE_CHAIR = registerBlock("jungle_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block ACACIA_CHAIR = registerBlock("acacia_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block DARK_OAK_CHAIR = registerBlock("dark_oak_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block CRIMSON_CHAIR = registerBlock("crimson_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block WARPED_CHAIR = registerBlock("warped_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block OAK_TABLE = registerBlock("oak_table",
            new TableBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModItemGroup.Building);

    public static final Block TELEPORTER_BLOCK = registerBlock("teleporter_block",
            new TeleporterBlock(FabricBlockSettings.of(Material.METAL).strength(5, 6).requiresTool()), ModItemGroup.Building);

    public static final Block FABRICATOR_BLOCK = registerBlock("fabricator",
            new FabricatorBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f, 6).requiresTool()), ModItemGroup.Building);

    public static class Pillars{
        public static final Block STONE_PILLAR = registerBlock("stone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE)), ModItemGroup.Pillars);
        public static final Block GRANITE_PILLAR = registerBlock("granite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GRANITE)), ModItemGroup.Pillars);
        public static final Block POLISHED_GRANITE_PILLAR = registerBlock("polished_granite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE)), ModItemGroup.Pillars);
        public static final Block DIORITE_PILLAR = registerBlock("diorite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DIORITE)), ModItemGroup.Pillars);
        public static final Block POLISHED_DIORITE_PILLAR = registerBlock("polished_diorite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE)), ModItemGroup.Pillars);
        public static final Block ANDESITE_PILLAR = registerBlock("andesite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE)), ModItemGroup.Pillars);
        public static final Block POLISHED_ANDESITE_PILLAR = registerBlock("polished_andesite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)), ModItemGroup.Pillars);
        public static final Block DEEPSLATE_PILLAR = registerBlock("deepslate_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)), ModItemGroup.Pillars);
        public static final Block DIRT_PILLAR = registerBlock("dirt_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DIRT)), ModItemGroup.Pillars);
        public static final Block COARSE_DIRT_PILLAR = registerBlock("coarse_dirt_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT)), ModItemGroup.Pillars);
        public static final Block MUD_PILLAR = registerBlock("mud_pillar",
                new PillarMudBlock(FabricBlockSettings.copyOf(Blocks.MUD)), ModItemGroup.Pillars);
        public static final Block COBBLESTONE_PILLAR = registerBlock("cobblestone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)), ModItemGroup.Pillars);
        public static final Block OAK_PLANK_PILLAR = registerBlock("oak_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModItemGroup.Pillars);
        public static final Block SPRUCE_PLANK_PILLAR = registerBlock("spruce_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)), ModItemGroup.Pillars);
        public static final Block BIRCH_PLANK_PILLAR = registerBlock("birch_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)), ModItemGroup.Pillars);
        public static final Block JUNGLE_PLANK_PILLAR = registerBlock("jungle_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS)), ModItemGroup.Pillars);
        public static final Block ACACIA_PLANK_PILLAR = registerBlock("acacia_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)), ModItemGroup.Pillars);
        public static final Block DARK_OAK_PLANK_PILLAR = registerBlock("dark_oak_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)), ModItemGroup.Pillars);
        public static final Block MANGROVE_PLANK_PILLAR = registerBlock("mangrove_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS)), ModItemGroup.Pillars);
        public static final Block CRIMSON_PLANK_PILLAR = registerBlock("crimson_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)), ModItemGroup.Pillars);
        public static final Block WARPED_PLANK_PILLAR = registerBlock("warped_plank_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)), ModItemGroup.Pillars);
        public static final Block BEDROCK_PILLAR = registerBlock("bedrock_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BEDROCK)), ModItemGroup.Pillars);
        public static final Block LAPIS_PILLAR = registerBlock("lapis_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_BLOCK)), ModItemGroup.Pillars);
        public static final Block SANDSTONE_PILLAR = registerBlock("sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), ModItemGroup.Pillars);
        public static final Block CHISELED_SANDSTONE_PILLAR = registerBlock("chiseled_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block CUT_SANDSTONE_PILLAR = registerBlock("cut_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block WHITE_WOOL_PILLAR = registerBlock("white_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)), ModItemGroup.Pillars);
        public static final Block ORANGE_WOOL_PILLAR = registerBlock("orange_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_WOOL)), ModItemGroup.Pillars);
        public static final Block MAGENTA_WOOL_PILLAR = registerBlock("magenta_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_WOOL)), ModItemGroup.Pillars);
        public static final Block LIGHT_BLUE_WOOL_PILLAR = registerBlock("light_blue_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_WOOL)), ModItemGroup.Pillars);
        public static final Block YELLOW_WOOL_PILLAR = registerBlock("yellow_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_WOOL)), ModItemGroup.Pillars);
        public static final Block LIME_WOOL_PILLAR = registerBlock("lime_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIME_WOOL)), ModItemGroup.Pillars);
        public static final Block PINK_WOOL_PILLAR = registerBlock("pink_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PINK_WOOL)), ModItemGroup.Pillars);
        public static final Block GRAY_WOOL_PILLAR = registerBlock("gray_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GRAY_WOOL)), ModItemGroup.Pillars);
        public static final Block LIGHT_GRAY_WOOL_PILLAR = registerBlock("light_gray_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_WOOL)), ModItemGroup.Pillars);
        public static final Block CYAN_WOOL_PILLAR = registerBlock("cyan_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CYAN_WOOL)), ModItemGroup.Pillars);
        public static final Block PURPLE_WOOL_PILLAR = registerBlock("purple_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_WOOL)), ModItemGroup.Pillars);
        public static final Block BLUE_WOOL_PILLAR = registerBlock("blue_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLUE_WOOL)), ModItemGroup.Pillars);
        public static final Block BROWN_WOOL_PILLAR = registerBlock("brown_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BROWN_WOOL)), ModItemGroup.Pillars);
        public static final Block GREEN_WOOL_PILLAR = registerBlock("green_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GREEN_WOOL)), ModItemGroup.Pillars);
        public static final Block RED_WOOL_PILLAR = registerBlock("red_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RED_WOOL)), ModItemGroup.Pillars);
        public static final Block BLACK_WOOL_PILLAR = registerBlock("black_wool_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLACK_WOOL)), ModItemGroup.Pillars);
        public static final Block GOLD_PILLAR = registerBlock("gold_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)), ModItemGroup.Pillars);
        public static final Block IRON_PILLAR = registerBlock("iron_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)), ModItemGroup.Pillars);
        public static final Block COPPER_PILLAR = registerBlock("copper_pillar",
                new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED ,FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), ModItemGroup.Pillars);
        public static final Block BRICK_PILLAR = registerBlock("brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BRICKS)), ModItemGroup.Pillars);
        public static final Block BOOKSHELF_PILLAR = registerBlock("bookshelf_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)), ModItemGroup.Pillars);
        public static final Block MOSSY_COBBLESTONE_PILLAR = registerBlock("mossy_cobblestone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_COBBLESTONE)), ModItemGroup.Pillars);
        public static final Block OBSIDIAN_PILLAR = registerBlock("obsidian_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)), ModItemGroup.Pillars);
        public static final Block DIAMOND_PILLAR = registerBlock("diamond_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)), ModItemGroup.Pillars);
        public static final Block SNOW_PILLAR = registerBlock("snow_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK)), ModItemGroup.Pillars);
        public static final Block CLAY_PILLAR = registerBlock("clay_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CLAY)), ModItemGroup.Pillars);
        public static final Block SOUL_SAND_PILLAR = registerBlock("soul_sand_pillar",
                new PillarSoulSandBlock(FabricBlockSettings.copyOf(Blocks.SOUL_SAND)), ModItemGroup.Pillars);
        public static final Block SOUL_SOIL_PILLAR = registerBlock("soul_soil_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SOUL_SOIL)), ModItemGroup.Pillars);
        public static final Block BASALT_PILLAR = registerBlock("basalt_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT)), ModItemGroup.Pillars);
        public static final Block POLISHED_BASALT_PILLAR = registerBlock("polished_basalt_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT)), ModItemGroup.Pillars);
        public static final Block GLOWSTONE_PILLAR = registerBlock("glowstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GLOWSTONE)), ModItemGroup.Pillars);
        public static final Block STONE_BRICK_PILLAR = registerBlock("stone_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block MOSSY_STONE_BRICK_PILLAR = registerBlock("mossy_stone_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CRACKED_STONE_BRICK_PILLAR = registerBlock("cracked_stone_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CHISELED_STONE_BRICK_PILLAR = registerBlock("chiseled_stone_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block PACKED_MUD_PILLAR = registerBlock("packed_mud_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PACKED_MUD)), ModItemGroup.Pillars);
        public static final Block MUD_BRICK_PILLAR = registerBlock("mud_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS)), ModItemGroup.Pillars);
        public static final Block NETHER_BRICK_PILLAR = registerBlock("nether_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.NETHER_BRICKS)), ModItemGroup.Pillars);
        public static final Block END_STONE_PILLAR = registerBlock("end_stone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.END_STONE)), ModItemGroup.Pillars);
        public static final Block EMERALD_PILLAR = registerBlock("emerald_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)), ModItemGroup.Pillars);
        public static final Block QUARTZ_PILLAR = registerBlock("quartz_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK)), ModItemGroup.Pillars);
        public static final Block CHISELED_QUARTZ_PILLAR = registerBlock("chiseled_quartz_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_QUARTZ_BLOCK)), ModItemGroup.Pillars);
        public static final Block WHITE_TERRACOTTA_PILLAR = registerBlock("white_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block ORANGE_TERRACOTTA_PILLAR = registerBlock("orange_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block MAGENTA_TERRACOTTA_PILLAR = registerBlock("magenta_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block LIGHT_BLUE_TERRACOTTA_PILLAR = registerBlock("light_blue_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block YELLOW_TERRACOTTA_PILLAR = registerBlock("yellow_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block LIME_TERRACOTTA_PILLAR = registerBlock("lime_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIME_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block PINK_TERRACOTTA_PILLAR = registerBlock("pink_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PINK_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block GRAY_TERRACOTTA_PILLAR = registerBlock("gray_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GRAY_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block LIGHT_GRAY_TERRACOTTA_PILLAR = registerBlock("light_gray_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block CYAN_TERRACOTTA_PILLAR = registerBlock("cyan_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CYAN_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block PURPLE_TERRACOTTA_PILLAR = registerBlock("purple_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block BLUE_TERRACOTTA_PILLAR = registerBlock("blue_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block BROWN_TERRACOTTA_PILLAR = registerBlock("brown_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BROWN_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block GREEN_TERRACOTTA_PILLAR = registerBlock("green_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GREEN_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block RED_TERRACOTTA_PILLAR = registerBlock("red_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RED_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block BLACK_TERRACOTTA_PILLAR = registerBlock("black_terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLACK_TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block PRISMARINE_PILLAR = registerBlock("prismarine_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE)), ModItemGroup.Pillars);
        public static final Block PRISMARINE_BRICK_PILLAR = registerBlock("prismarine_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS)), ModItemGroup.Pillars);
        public static final Block DARK_PRISMARINE_PILLAR = registerBlock("dark_prismarine_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_PRISMARINE)), ModItemGroup.Pillars);
        public static final Block SEA_LANTERN_PILLAR = registerBlock("sea_lantern_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SEA_LANTERN)), ModItemGroup.Pillars);
        public static final Block TERRACOTTA_PILLAR = registerBlock("terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block COAL_PILLAR = registerBlock("coal_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block PACKED_ICE_PILLAR = registerBlock("packed_ice_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PACKED_ICE)), ModItemGroup.Pillars);
        public static final Block RED_SANDSTONE_PILLAR = registerBlock("red_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block CHISELED_RED_SANDSTONE_PILLAR = registerBlock("chiseled_red_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_RED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block CUT_RED_SANDSTONE_PILLAR = registerBlock("cut_red_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CUT_RED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block MAGMA_PILLAR = registerBlock("magma_pillar",
                new PillarMagmaBlock(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK)), ModItemGroup.Pillars);
        public static final Block SMOOTH_STONE_PILLAR = registerBlock("smooth_stone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_STONE)), ModItemGroup.Pillars);
        public static final Block SMOOTH_SANDSTONE_PILLAR = registerBlock("smooth_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block SMOOTH_QUARTZ_PILLAR = registerBlock("smooth_quartz_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ)), ModItemGroup.Pillars);
        public static final Block SMOOTH_RED_SANDSTONE_PILLAR = registerBlock("smooth_red_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_RED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block PURPUR_PILLAR = registerBlock("purpur_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PURPUR_BLOCK)), ModItemGroup.Pillars);
        public static final Block PURPUR_PILLAR_PILLAR = registerBlock("purpur_pillar_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PURPUR_PILLAR)), ModItemGroup.Pillars);
        public static final Block ICE_PILLAR = registerBlock("ice_pillar",
                new PillarIceBlock(FabricBlockSettings.copyOf(Blocks.ICE)), ModItemGroup.Pillars);
        public static final Block END_STONE_BRICK_PILLAR = registerBlock("end_stone_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block NETHER_WART_PILLAR = registerBlock("nether_wart_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK)), ModItemGroup.Pillars);
        public static final Block RED_NETHER_BRICK_PILLAR = registerBlock("red_nether_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)), ModItemGroup.Pillars);
        public static final Block BONE_PILLAR = registerBlock("bone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK)), ModItemGroup.Pillars);
        public static final Block WHITE_CONCRETE_PILLAR = registerBlock("white_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE)), ModItemGroup.Pillars);
        public static final Block ORANGE_CONCRETE_PILLAR = registerBlock("orange_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE)), ModItemGroup.Pillars);
        public static final Block MAGENTA_CONCRETE_PILLAR = registerBlock("magenta_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE)), ModItemGroup.Pillars);
        public static final Block LIGHT_BLUE_CONCRETE_PILLAR = registerBlock("light_blue_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE)), ModItemGroup.Pillars);
        public static final Block YELLOW_CONCRETE_PILLAR = registerBlock("yellow_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE)), ModItemGroup.Pillars);
        public static final Block LIME_CONCRETE_PILLAR = registerBlock("lime_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE)), ModItemGroup.Pillars);
        public static final Block PINK_CONCRETE_PILLAR = registerBlock("pink_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE)), ModItemGroup.Pillars);
        public static final Block GRAY_CONCRETE_PILLAR = registerBlock("gray_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE)), ModItemGroup.Pillars);
        public static final Block LIGHT_GRAY_CONCRETE_PILLAR = registerBlock("light_gray_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE)), ModItemGroup.Pillars);
        public static final Block CYAN_CONCRETE_PILLAR = registerBlock("cyan_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE)), ModItemGroup.Pillars);
        public static final Block PURPLE_CONCRETE_PILLAR = registerBlock("purple_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE)), ModItemGroup.Pillars);
        public static final Block BLUE_CONCRETE_PILLAR = registerBlock("blue_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE)), ModItemGroup.Pillars);
        public static final Block BROWN_CONCRETE_PILLAR = registerBlock("brown_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE)), ModItemGroup.Pillars);
        public static final Block GREEN_CONCRETE_PILLAR = registerBlock("green_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE)), ModItemGroup.Pillars);
        public static final Block RED_CONCRETE_PILLAR = registerBlock("red_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RED_CONCRETE)), ModItemGroup.Pillars);
        public static final Block BLACK_CONCRETE_PILLAR = registerBlock("black_concrete_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)), ModItemGroup.Pillars);
        public static final Block DRIED_KELP_PILLAR = registerBlock("dried_kelp_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DRIED_KELP_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_TUBE_CORAL_PILLAR = registerBlock("dead_tube_coral_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_TUBE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_BRAIN_CORAL_PILLAR = registerBlock("dead_brain_coral_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BRAIN_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_BUBBLE_CORAL_PILLAR = registerBlock("dead_bubble_coral_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUBBLE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_FIRE_CORAL_PILLAR = registerBlock("dead_fire_coral_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_FIRE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_HORN_CORAL_PILLAR = registerBlock("dead_horn_coral_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_HORN_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block TUBE_CORAL_PILLAR = registerBlock("tube_coral_pillar",
                new PillarCoralBlock(DEAD_TUBE_CORAL_PILLAR, FabricBlockSettings.copyOf(Blocks.TUBE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block BRAIN_CORAL_PILLAR = registerBlock("brain_coral_pillar",
                new PillarCoralBlock(DEAD_BRAIN_CORAL_PILLAR, FabricBlockSettings.copyOf(Blocks.BRAIN_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block BUBBLE_CORAL_PILLAR = registerBlock("bubble_coral_pillar",
                new PillarCoralBlock(DEAD_BUBBLE_CORAL_PILLAR, FabricBlockSettings.copyOf(Blocks.BUBBLE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block FIRE_CORAL_PILLAR = registerBlock("fire_coral_pillar",
                new PillarCoralBlock(DEAD_FIRE_CORAL_PILLAR, FabricBlockSettings.copyOf(Blocks.FIRE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block HORN_CORAL_PILLAR = registerBlock("horn_coral_pillar",
                new PillarCoralBlock(DEAD_HORN_CORAL_PILLAR, FabricBlockSettings.copyOf(Blocks.HORN_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block BLUE_ICE_PILLAR = registerBlock("blue_ice_pillar",
                new PillarTransparentBlock(FabricBlockSettings.copyOf(Blocks.BLUE_ICE)), ModItemGroup.Pillars);
        public static final Block REDSTONE_PILLAR = registerBlock("redstone_pillar",
                new PillarRedstoneBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_BLOCK)), ModItemGroup.Pillars);
        public static final Block TNT_PILLAR = registerBlock("tnt_pillar",
                new PillarTntBlock(FabricBlockSettings.copyOf(Blocks.TNT)), ModItemGroup.Pillars);
        public static final Block WARPED_WART_PILLAR = registerBlock("warped_wart_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK)), ModItemGroup.Pillars);
        public static final Block SHROOMLIGHT_PILLAR = registerBlock("shroomlight_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SHROOMLIGHT)), ModItemGroup.Pillars);
        public static final Block HONEYCOMB_PILLAR = registerBlock("honeycomb_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK)), ModItemGroup.Pillars);
        public static final Block NETHERITE_PILLAR = registerBlock("netherite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)), ModItemGroup.Pillars);
        public static final Block EXPOSED_COPPER_PILLAR = registerBlock("exposed_copper_pillar",
                new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER)), ModItemGroup.Pillars);
        public static final Block WEATHERED_COPPER_PILLAR = registerBlock("weathered_copper_pillar",
                new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER)), ModItemGroup.Pillars);
        public static final Block OXIDIZED_COPPER_PILLAR = registerBlock("oxidized_copper_pillar",
                new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER)), ModItemGroup.Pillars);
        public static final Block CUT_COPPER_PILLAR = registerBlock("cut_copper_pillar",
                new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED ,FabricBlockSettings.copyOf(Blocks.CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block EXPOSED_CUT_COPPER_PILLAR = registerBlock("exposed_cut_copper_pillar",
                new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED ,FabricBlockSettings.copyOf(Blocks.EXPOSED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block WEATHERED_CUT_COPPER_PILLAR = registerBlock("weathered_cut_copper_pillar",
                new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED ,FabricBlockSettings.copyOf(Blocks.WEATHERED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block OXIDIZED_CUT_COPPER_PILLAR = registerBlock("oxidized_cut_copper_pillar",
                new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED ,FabricBlockSettings.copyOf(Blocks.OXIDIZED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block ANCIENT_DEBRIS_PILLAR = registerBlock("ancient_debris_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)), ModItemGroup.Pillars);
        public static final Block LODESTONE_PILLAR = registerBlock("lodestone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LODESTONE)), ModItemGroup.Pillars);
        public static final Block CRYING_OBSIDIAN_PILLAR = registerBlock("crying_obsidian_pillar",
                new PillarCryingObsidianBlock(FabricBlockSettings.copyOf(Blocks.CRYING_OBSIDIAN)), ModItemGroup.Pillars);
        public static final Block BLACKSTONE_PILLAR = registerBlock("blackstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)), ModItemGroup.Pillars);
        public static final Block POLISHED_BLACKSTONE_PILLAR = registerBlock("polished_blackstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)), ModItemGroup.Pillars);
        public static final Block POLISHED_BLACKSTONE_BRICK_PILLAR = registerBlock("polished_blackstone_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_PILLAR = registerBlock("cracked_polished_blackstone_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CHISELED_POLISHED_BLACKSTONE_PILLAR = registerBlock("chiseled_polished_blackstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_POLISHED_BLACKSTONE)), ModItemGroup.Pillars);
        public static final Block GILDED_BLACKSTONE_PILLAR = registerBlock("gilded_blackstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GILDED_BLACKSTONE)), ModItemGroup.Pillars);
        public static final Block CHISELED_NETHER_BRICK_PILLAR = registerBlock("chiseled_nether_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_NETHER_BRICKS)), ModItemGroup.Pillars);
        public static final Block CRACKED_NETHER_BRICK_PILLAR = registerBlock("cracked_nether_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_NETHER_BRICKS)), ModItemGroup.Pillars);
        public static final Block QUARTZ_BRICK_PILLAR = registerBlock("quartz_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS)), ModItemGroup.Pillars);
        public static final Block QUARTZ_PILLAR_PILLAR = registerBlock("quartz_pillar_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR)), ModItemGroup.Pillars);
        public static final Block HAY_PILLAR = registerBlock("hay_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK)), ModItemGroup.Pillars);
        public static final Block WHITE_STAINED_GLASS_PILLAR = registerBlock("white_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block ORANGE_STAINED_GLASS_PILLAR = registerBlock("orange_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block MAGENTA_STAINED_GLASS_PILLAR = registerBlock("magenta_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block LIGHT_BLUE_STAINED_GLASS_PILLAR = registerBlock("light_blue_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block YELLOW_STAINED_GLASS_PILLAR = registerBlock("yellow_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block LIME_STAINED_GLASS_PILLAR = registerBlock("lime_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.LIME_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block PINK_STAINED_GLASS_PILLAR = registerBlock("pink_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.PINK_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block GRAY_STAINED_GLASS_PILLAR = registerBlock("gray_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.GRAY_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block LIGHT_GRAY_STAINED_GLASS_PILLAR = registerBlock("light_gray_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block CYAN_STAINED_GLASS_PILLAR = registerBlock("cyan_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.CYAN_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block PURPLE_STAINED_GLASS_PILLAR = registerBlock("purple_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block BLUE_STAINED_GLASS_PILLAR = registerBlock("blue_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.BLUE_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block BROWN_STAINED_GLASS_PILLAR = registerBlock("brown_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.BROWN_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block GREEN_STAINED_GLASS_PILLAR = registerBlock("green_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.GREEN_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block RED_STAINED_GLASS_PILLAR = registerBlock("red_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.RED_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block BLACK_STAINED_GLASS_PILLAR = registerBlock("black_stained_glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.BLACK_STAINED_GLASS)), ModItemGroup.Pillars);
        public static final Block TUFF_PILLAR = registerBlock("tuff_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.TUFF)), ModItemGroup.Pillars);
        public static final Block CALCITE_PILLAR = registerBlock("calcite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CALCITE)), ModItemGroup.Pillars);
        public static final Block WAXED_COPPER_PILLAR = registerBlock("waxed_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_COPPER_BLOCK)), ModItemGroup.Pillars);
        public static final Block WAXED_WEATHERED_COPPER_PILLAR = registerBlock("waxed_weathered_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_WEATHERED_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_EXPOSED_COPPER_PILLAR = registerBlock("waxed_exposed_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_EXPOSED_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_OXIDIZED_COPPER_PILLAR = registerBlock("waxed_oxidized_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_OXIDIZED_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_CUT_COPPER_PILLAR = registerBlock("waxed_cut_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_EXPOSED_CUT_COPPER_PILLAR = registerBlock("waxed_exposed_cut_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_EXPOSED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_WEATHERED_CUT_COPPER_PILLAR = registerBlock("waxed_weathered_cut_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_WEATHERED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_OXIDIZED_CUT_COPPER_PILLAR = registerBlock("waxed_oxidized_cut_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_OXIDIZED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block OAK_LOG_PILLAR = registerBlock("oak_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ModItemGroup.Pillars);
        public static final Block SPRUCE_LOG_PILLAR = registerBlock("spruce_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_LOG)), ModItemGroup.Pillars);
        public static final Block BIRCH_LOG_PILLAR = registerBlock("birch_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_LOG)), ModItemGroup.Pillars);
        public static final Block JUNGLE_LOG_PILLAR = registerBlock("jungle_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_LOG)), ModItemGroup.Pillars);
        public static final Block ACACIA_LOG_PILLAR = registerBlock("acacia_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_LOG)), ModItemGroup.Pillars);
        public static final Block DARK_OAK_LOG_PILLAR = registerBlock("dark_oak_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_LOG)), ModItemGroup.Pillars);
        public static final Block MANGROVE_LOG_PILLAR = registerBlock("mangrove_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_LOG)), ModItemGroup.Pillars);
        public static final Block CRIMSON_STEM_PILLAR = registerBlock("crimson_stem_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_STEM)), ModItemGroup.Pillars);
        public static final Block WARPED_STEM_PILLAR = registerBlock("warped_stem_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_STEM)), ModItemGroup.Pillars);
        public static final Block STRIPPED_OAK_LOG_PILLAR = registerBlock("stripped_oak_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.Pillars);
        public static final Block STRIPPED_SPRUCE_LOG_PILLAR = registerBlock("stripped_spruce_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_SPRUCE_LOG)), ModItemGroup.Pillars);
        public static final Block STRIPPED_BIRCH_LOG_PILLAR = registerBlock("stripped_birch_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BIRCH_LOG)), ModItemGroup.Pillars);
        public static final Block STRIPPED_JUNGLE_LOG_PILLAR = registerBlock("stripped_jungle_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_JUNGLE_LOG)), ModItemGroup.Pillars);
        public static final Block STRIPPED_ACACIA_LOG_PILLAR = registerBlock("stripped_acacia_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_ACACIA_LOG)), ModItemGroup.Pillars);
        public static final Block STRIPPED_DARK_OAK_LOG_PILLAR = registerBlock("stripped_dark_oak_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_DARK_OAK_LOG)), ModItemGroup.Pillars);
        public static final Block STRIPPED_MANGROVE_LOG_PILLAR = registerBlock("stripped_mangrove_log_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_MANGROVE_LOG)), ModItemGroup.Pillars);
        public static final Block STRIPPED_CRIMSON_STEM_PILLAR = registerBlock("stripped_crimson_stem_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CRIMSON_STEM)), ModItemGroup.Pillars);
        public static final Block STRIPPED_WARPED_STEM_PILLAR = registerBlock("stripped_warped_stem_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM)), ModItemGroup.Pillars);
        public static final Block STRIPPED_OAK_WOOD_PILLAR = registerBlock("stripped_oak_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.Pillars);
        public static final Block STRIPPED_SPRUCE_WOOD_PILLAR = registerBlock("stripped_spruce_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_SPRUCE_WOOD)), ModItemGroup.Pillars);
        public static final Block STRIPPED_BIRCH_WOOD_PILLAR = registerBlock("stripped_birch_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BIRCH_WOOD)), ModItemGroup.Pillars);
        public static final Block STRIPPED_JUNGLE_WOOD_PILLAR = registerBlock("stripped_jungle_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_JUNGLE_WOOD)), ModItemGroup.Pillars);
        public static final Block STRIPPED_ACACIA_WOOD_PILLAR = registerBlock("stripped_acacia_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_ACACIA_WOOD)), ModItemGroup.Pillars);
        public static final Block STRIPPED_DARK_OAK_WOOD_PILLAR = registerBlock("stripped_dark_oak_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_DARK_OAK_WOOD)), ModItemGroup.Pillars);
        public static final Block STRIPPED_MANGROVE_WOOD_PILLAR = registerBlock("stripped_mangrove_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_MANGROVE_WOOD)), ModItemGroup.Pillars);
        public static final Block STRIPPED_CRIMSON_HYPHAE_PILLAR = registerBlock("stripped_crimson_hyphae_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CRIMSON_HYPHAE)), ModItemGroup.Pillars);
        public static final Block STRIPPED_WARPED_HYPHAE_PILLAR = registerBlock("stripped_warped_hyphae_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE)), ModItemGroup.Pillars);
        public static final Block OAK_WOOD_PILLAR = registerBlock("oak_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)), ModItemGroup.Pillars);
        public static final Block SPRUCE_WOOD_PILLAR = registerBlock("spruce_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WOOD)), ModItemGroup.Pillars);
        public static final Block BIRCH_WOOD_PILLAR = registerBlock("birch_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_WOOD)), ModItemGroup.Pillars);
        public static final Block JUNGLE_WOOD_PILLAR = registerBlock("jungle_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_WOOD)), ModItemGroup.Pillars);
        public static final Block ACACIA_WOOD_PILLAR = registerBlock("acacia_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_WOOD)), ModItemGroup.Pillars);
        public static final Block DARK_OAK_WOOD_PILLAR = registerBlock("dark_oak_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_WOOD)), ModItemGroup.Pillars);
        public static final Block MANGROVE_WOOD_PILLAR = registerBlock("mangrove_wood_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_WOOD)), ModItemGroup.Pillars);
        public static final Block CRIMSON_HYPHAE_PILLAR = registerBlock("crimson_hyphae_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_HYPHAE)), ModItemGroup.Pillars);
        public static final Block WARPED_HYPHAE_PILLAR = registerBlock("warped_hyphae_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE)), ModItemGroup.Pillars);
        public static final Block GLASS_PILLAR = registerBlock("glass_pillar",
                new PillarGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)), ModItemGroup.Pillars);
        public static final Block TINTED_GLASS_PILLAR = registerBlock("tinted_glass_pillar",
                new PillarTintedGlassBlock(FabricBlockSettings.copyOf(Blocks.TINTED_GLASS)), ModItemGroup.Pillars);
        public static final Block DRIPSTONE_PILLAR = registerBlock("dripstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)), ModItemGroup.Pillars);
        public static final Block COBBLED_DEEPSLATE_PILLAR = registerBlock("cobbled_deepslate_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE)), ModItemGroup.Pillars);
        public static final Block POLISHED_DEEPSLATE_PILLAR = registerBlock("polished_deepslate_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE)), ModItemGroup.Pillars);
        public static final Block DEEPSLATE_TILE_PILLAR = registerBlock("deepslate_tile_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_TILES)), ModItemGroup.Pillars);
        public static final Block DEEPSLATE_BRICK_PILLAR = registerBlock("deepslate_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CHISELED_DEEPSLATE_PILLAR = registerBlock("chiseled_deepslate_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_DEEPSLATE)), ModItemGroup.Pillars);
        public static final Block MUSHROOM_STEM_PILLAR = registerBlock("mushroom_stem_pillar",
                new PillarMushroomBlock(FabricBlockSettings.copyOf(Blocks.MUSHROOM_STEM)), ModItemGroup.Pillars);
        public static final Block CRACKED_DEEPSLATE_BRICK_PILLAR = registerBlock("cracked_deepslate_brick_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_DEEPSLATE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CRACKED_DEEPSLATE_TILE_PILLAR = registerBlock("cracked_deepslate_tile_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_DEEPSLATE_TILES)), ModItemGroup.Pillars);
        public static final Block SMOOTH_BASALT_PILLAR = registerBlock("smooth_basalt_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_BASALT)), ModItemGroup.Pillars);
        public static final Block RAW_IRON_PILLAR = registerBlock("raw_iron_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)), ModItemGroup.Pillars);
        public static final Block RAW_COPPER_PILLAR = registerBlock("raw_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RAW_COPPER_BLOCK)), ModItemGroup.Pillars);
        public static final Block RAW_GOLD_PILLAR = registerBlock("raw_gold_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK)), ModItemGroup.Pillars);
        public static final Block AMETHYST_PILLAR = registerBlock("amethyst_pillar",
                new PillarAmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)), ModItemGroup.Pillars);
        public static final Block OCHRE_FROGLIGHT_PILLAR = registerBlock("ochre_froglight_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.OCHRE_FROGLIGHT)), ModItemGroup.Pillars);
        public static final Block VERDANT_FROGLIGHT_PILLAR = registerBlock("verdant_froglight_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.VERDANT_FROGLIGHT)), ModItemGroup.Pillars);
        public static final Block PEARLESCENT_FROGLIGHT_PILLAR = registerBlock("pearlescent_froglight_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PEARLESCENT_FROGLIGHT)), ModItemGroup.Pillars);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        BetterBuilding.LOGGER.info("Registering Mod Blocks for BetterBuilding" + BetterBuilding.MOD_ID);
    }
}
