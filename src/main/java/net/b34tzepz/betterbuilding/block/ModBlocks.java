package net.b34tzepz.betterbuilding.block;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.custom.*;
import net.b34tzepz.betterbuilding.block.custom.PillarBlock;
import net.minecraft.block.*;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.block.AbstractBlock.Settings;

import java.util.function.Function;

public class ModBlocks {
    public static final Block REINFORCED_OAK_PLANKS = registerBlock("reinforced_oak_planks", Block::new,
            Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f,5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_SPRUCE_PLANKS = registerBlock("reinforced_spruce_planks", Block::new,
            Settings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_BIRCH_PLANKS = registerBlock("reinforced_birch_planks", Block::new,
            Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_JUNGLE_PLANKS = registerBlock("reinforced_jungle_planks", Block::new,
            Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_ACACIA_PLANKS = registerBlock("reinforced_acacia_planks", Block::new,
            Settings.create().mapColor(MapColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_DARK_OAK_PLANKS = registerBlock("reinforced_dark_oak_planks", Block::new,
            Settings.create().mapColor(MapColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_MANGROVE_PLANKS = registerBlock("reinforced_mangrove_planks", Block::new,
            Settings.create().mapColor(MapColor.RED).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_CHERRY_PLANKS = registerBlock("reinforced_cherry_planks", Block::new,
            Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_PALE_OAK_PLANKS = registerBlock("reinforced_pale_oak_planks", Block::new,
            Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_BAMBOO_PLANKS = registerBlock("reinforced_bamboo_planks", Block::new,
            Settings.create().mapColor(MapColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_BAMBOO_MOSAIC = registerBlock("reinforced_bamboo_mosaic", Block::new,
            Settings.create().mapColor(MapColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_CRIMSON_PLANKS = registerBlock("reinforced_crimson_planks", Block::new,
            Settings.create().mapColor(MapColor.DULL_PINK).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static final Block REINFORCED_WARPED_PLANKS = registerBlock("reinforced_warped_planks", Block::new,
            Settings.create().mapColor(MapColor.DARK_AQUA).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5f, 5).sounds(BlockSoundGroup.WOOD));

    public static class Sides{
        public static final Block OAK_SIDE = registerBlock("oak_side",
                SideBlock::new, (Settings.copy(Blocks.OAK_SLAB)));

        public static final Block SPRUCE_SIDE = registerBlock("spruce_side",
                SideBlock::new, (Settings.copy(Blocks.SPRUCE_SLAB)));

        public static final Block BIRCH_SIDE = registerBlock("birch_side",
                SideBlock::new, (Settings.copy(Blocks.BIRCH_SLAB)));

        public static final Block JUNGLE_SIDE = registerBlock("jungle_side",
                SideBlock::new, (Settings.copy(Blocks.JUNGLE_SLAB)));

        public static final Block ACACIA_SIDE = registerBlock("acacia_side",
                SideBlock::new, (Settings.copy(Blocks.ACACIA_SLAB)));

        public static final Block DARK_OAK_SIDE = registerBlock("dark_oak_side",
                SideBlock::new, (Settings.copy(Blocks.DARK_OAK_SLAB)));

        public static final Block MANGROVE_SIDE = registerBlock("mangrove_side",
                SideBlock::new, (Settings.copy(Blocks.MANGROVE_SLAB)));

        public static final Block CHERRY_SIDE = registerBlock("cherry_side",
                SideBlock::new, (Settings.copy(Blocks.CHERRY_SLAB)));

        public static final Block PALE_OAK_SIDE = registerBlock("pale_oak_side",
                SideBlock::new, (Settings.copy(Blocks.PALE_OAK_SLAB)));

        public static final Block BAMBOO_SIDE = registerBlock("bamboo_side",
                SideBlock::new, (Settings.copy(Blocks.BAMBOO_SLAB)));

        public static final Block BAMBOO_MOSAIC_SIDE = registerBlock("bamboo_mosaic_side",
                SideBlock::new, (Settings.copy(Blocks.BAMBOO_MOSAIC_SLAB)));

        public static final Block CRIMSON_SIDE = registerBlock("crimson_side",
                SideBlock::new, (Settings.copy(Blocks.CRIMSON_SLAB)));

        public static final Block WARPED_SIDE = registerBlock("warped_side",
                SideBlock::new, (Settings.copy(Blocks.WARPED_SLAB)));

        public static final Block STONE_SIDE = registerBlock("stone_side",
                SideBlock::new, (Settings.copy(Blocks.STONE_SLAB)));

        public static final Block COBBLESTONE_SIDE = registerBlock("cobblestone_side",
                SideBlock::new, (Settings.copy(Blocks.COBBLESTONE_SLAB)));

        public static final Block MOSSY_COBBLESTONE_SIDE = registerBlock("mossy_cobblestone_side",
                SideBlock::new, (Settings.copy(Blocks.MOSSY_COBBLESTONE_SLAB)));

        public static final Block SMOOTH_STONE_SIDE = registerBlock("smooth_stone_side",
                SideBlock::new, (Settings.copy(Blocks.SMOOTH_STONE_SLAB)));

        public static final Block STONE_BRICK_SIDE = registerBlock("stone_brick_side",
                SideBlock::new, (Settings.copy(Blocks.STONE_BRICK_SLAB)));

        public static final Block MOSSY_STONE_BRICK_SIDE = registerBlock("mossy_stone_brick_side",
                SideBlock::new, (Settings.copy(Blocks.MOSSY_STONE_BRICK_SLAB)));

        public static final Block GRANITE_SIDE = registerBlock("granite_side",
                SideBlock::new, (Settings.copy(Blocks.GRANITE_SLAB)));

        public static final Block POLISHED_GRANITE_SIDE = registerBlock("polished_granite_side",
                SideBlock::new, (Settings.copy(Blocks.POLISHED_GRANITE_SLAB)));

        public static final Block DIORITE_SIDE = registerBlock("diorite_side",
                SideBlock::new, (Settings.copy(Blocks.DIORITE_SLAB)));

        public static final Block POLISHED_DIORITE_SIDE = registerBlock("polished_diorite_side",
                SideBlock::new, (Settings.copy(Blocks.POLISHED_DIORITE_SLAB)));

        public static final Block ANDESITE_SIDE = registerBlock("andesite_side",
                SideBlock::new, (Settings.copy(Blocks.ANDESITE_SLAB)));

        public static final Block POLISHED_ANDESITE_SIDE = registerBlock("polished_andesite_side",
                SideBlock::new, (Settings.copy(Blocks.POLISHED_ANDESITE_SLAB)));

        public static final Block COBBLED_DEEPSLATE_SIDE = registerBlock("cobbled_deepslate_side",
                SideBlock::new, (Settings.copy(Blocks.COBBLED_DEEPSLATE_SLAB)));

        public static final Block POLISHED_DEEPSLATE_SIDE = registerBlock("polished_deepslate_side",
                SideBlock::new, (Settings.copy(Blocks.POLISHED_DEEPSLATE_SLAB)));

        public static final Block DEEPSLATE_BRICK_SIDE = registerBlock("deepslate_brick_side",
                SideBlock::new, (Settings.copy(Blocks.DEEPSLATE_BRICK_SLAB)));

        public static final Block DEEPSLATE_TILE_SIDE = registerBlock("deepslate_tile_side",
                SideBlock::new, (Settings.copy(Blocks.DEEPSLATE_TILE_SLAB)));

        public static final Block TUFF_SIDE = registerBlock("tuff_side",
                SideBlock::new, (Settings.copy(Blocks.TUFF_SLAB)));

        public static final Block POLISHED_TUFF_SIDE = registerBlock("polished_tuff_side",
                SideBlock::new, (Settings.copy(Blocks.POLISHED_TUFF_SLAB)));

        public static final Block TUFF_BRICK_SIDE = registerBlock("tuff_brick_side",
                SideBlock::new, (Settings.copy(Blocks.TUFF_BRICK_SLAB)));

        public static final Block BRICK_SIDE = registerBlock("brick_side",
                SideBlock::new, (Settings.copy(Blocks.BRICK_SLAB)));

        public static final Block MUD_BRICK_SIDE = registerBlock("mud_brick_side",
                SideBlock::new, (Settings.copy(Blocks.MUD_BRICK_SLAB)));

        public static final Block RESIN_BRICK_SIDE = registerBlock("resin_brick_side",
                SideBlock::new, (Settings.copy(Blocks.RESIN_BRICK_SLAB)));

        public static final Block SANDSTONE_SIDE = registerBlock("sandstone_side",
                SideBlock::new, (Settings.copy(Blocks.SANDSTONE_SLAB)));

        public static final Block SMOOTH_SANDSTONE_SIDE = registerBlock("smooth_sandstone_side",
                SideBlock::new, (Settings.copy(Blocks.SMOOTH_SANDSTONE_SLAB)));

        public static final Block CUT_SANDSTONE_SIDE = registerBlock("cut_sandstone_side",
                SideBlock::new, (Settings.copy(Blocks.CUT_SANDSTONE_SLAB)));

        public static final Block RED_SANDSTONE_SIDE = registerBlock("red_sandstone_side",
                SideBlock::new, (Settings.copy(Blocks.RED_SANDSTONE_SLAB)));

        public static final Block SMOOTH_RED_SANDSTONE_SIDE = registerBlock("smooth_red_sandstone_side",
                SideBlock::new, (Settings.copy(Blocks.SMOOTH_RED_SANDSTONE_SLAB)));

        public static final Block CUT_RED_SANDSTONE_SIDE = registerBlock("cut_red_sandstone_side",
                SideBlock::new, (Settings.copy(Blocks.CUT_RED_SANDSTONE_SLAB)));

        public static final Block PRISMARINE_SIDE = registerBlock("prismarine_side",
                SideBlock::new, (Settings.copy(Blocks.PRISMARINE_SLAB)));

        public static final Block PRISMARINE_BRICK_SIDE = registerBlock("prismarine_brick_side",
                SideBlock::new, (Settings.copy(Blocks.PRISMARINE_BRICK_SLAB)));

        public static final Block DARK_PRISMARINE_SIDE = registerBlock("dark_prismarine_side",
                SideBlock::new, (Settings.copy(Blocks.DARK_PRISMARINE_SLAB)));

        public static final Block NETHER_BRICK_SIDE = registerBlock("nether_brick_side",
                SideBlock::new, (Settings.copy(Blocks.NETHER_BRICK_SLAB)));

        public static final Block RED_NETHER_BRICK_SIDE = registerBlock("red_nether_brick_side",
                SideBlock::new, (Settings.copy(Blocks.RED_NETHER_BRICK_SLAB)));

        public static final Block BLACKSTONE_SIDE = registerBlock("blackstone_side",
                SideBlock::new, (Settings.copy(Blocks.BLACKSTONE_SLAB)));

        public static final Block POLISHED_BLACKSTONE_SIDE = registerBlock("polished_blackstone_side",
                SideBlock::new, (Settings.copy(Blocks.POLISHED_BLACKSTONE_SLAB)));

        public static final Block POLISHED_BLACKSTONE_BRICK_SIDE = registerBlock("polished_blackstone_brick_side",
                SideBlock::new, (Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB)));

        public static final Block END_STONE_BRICK_SIDE = registerBlock("end_stone_brick_side",
                SideBlock::new, (Settings.copy(Blocks.END_STONE_BRICK_SLAB)));

        public static final Block PURPUR_SIDE = registerBlock("purpur_side",
                SideBlock::new, (Settings.copy(Blocks.PURPUR_SLAB)));

        public static final Block QUARTZ_SIDE = registerBlock("quartz_side",
                SideBlock::new, (Settings.copy(Blocks.QUARTZ_SLAB)));

        public static final Block SMOOTH_QUARTZ_SIDE = registerBlock("smooth_quartz_side",
                SideBlock::new, (Settings.copy(Blocks.SMOOTH_QUARTZ_SLAB)));

        public static final Block CUT_COPPER_SIDE = registerBlock("cut_copper_side",
                settings -> new OxidizableSideBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), Settings.copy(Blocks.CUT_COPPER_SLAB));

        public static final Block EXPOSED_CUT_COPPER_SIDE = registerBlock("exposed_cut_copper_side",
                settings -> new OxidizableSideBlock(Oxidizable.OxidationLevel.EXPOSED, settings), Settings.copy(Blocks.EXPOSED_CUT_COPPER_SLAB));

        public static final Block WEATHERED_CUT_COPPER_SIDE = registerBlock("weathered_cut_copper_side",
                settings -> new OxidizableSideBlock(Oxidizable.OxidationLevel.WEATHERED, settings), Settings.copy(Blocks.WEATHERED_CUT_COPPER_SLAB));

        public static final Block OXIDIZED_CUT_COPPER_SIDE = registerBlock("oxidized_cut_copper_side",
                settings -> new OxidizableSideBlock(Oxidizable.OxidationLevel.OXIDIZED, settings), Settings.copy(Blocks.OXIDIZED_CUT_COPPER_SLAB));

        public static final Block WAXED_CUT_COPPER_SIDE = registerBlock("waxed_cut_copper_side",
                SideBlock::new, (Settings.copy(Blocks.WAXED_CUT_COPPER_SLAB)));

        public static final Block WAXED_EXPOSED_CUT_COPPER_SIDE = registerBlock("waxed_exposed_cut_copper_side",
                SideBlock::new, (Settings.copy(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB)));

        public static final Block WAXED_WEATHERED_CUT_COPPER_SIDE = registerBlock("waxed_weathered_cut_copper_side",
                SideBlock::new, (Settings.copy(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB)));

        public static final Block WAXED_OXIDIZED_CUT_COPPER_SIDE = registerBlock("waxed_oxidized_cut_copper_side",
                SideBlock::new, (Settings.copy(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB)));
    }

    public static final Block SMOOTH_STONE_STAIRS = registerBlock("smooth_stone_stairs",
            settings -> new StairsBlock(Blocks.SMOOTH_STONE.getDefaultState(), settings), Settings.copy(Blocks.SMOOTH_STONE));

    public static final Block CUT_SANDSTONE_STAIRS = registerBlock("cut_sandstone_stairs",
            settings -> new StairsBlock(Blocks.CUT_SANDSTONE.getDefaultState(), settings), Settings.copy(Blocks.CUT_SANDSTONE));

    public static final Block CUT_RED_SANDSTONE_STAIRS = registerBlock("cut_red_sandstone_stairs",
            settings -> new StairsBlock(Blocks.CUT_RED_SANDSTONE.getDefaultState(), settings), Settings.copy(Blocks.CUT_RED_SANDSTONE));

    public static class Corners{
        public static final Block OAK_CORNER = registerBlock("oak_corner",
                CornerBlock::new, (Settings.copy(Blocks.OAK_STAIRS)));

        public static final Block SPRUCE_CORNER = registerBlock("spruce_corner",
                CornerBlock::new, (Settings.copy(Blocks.SPRUCE_STAIRS)));

        public static final Block BIRCH_CORNER = registerBlock("birch_corner",
                CornerBlock::new, (Settings.copy(Blocks.BIRCH_STAIRS)));

        public static final Block JUNGLE_CORNER = registerBlock("jungle_corner",
                CornerBlock::new, (Settings.copy(Blocks.JUNGLE_STAIRS)));

        public static final Block ACACIA_CORNER = registerBlock("acacia_corner",
                CornerBlock::new, (Settings.copy(Blocks.ACACIA_STAIRS)));

        public static final Block DARK_OAK_CORNER = registerBlock("dark_oak_corner",
                CornerBlock::new, (Settings.copy(Blocks.DARK_OAK_STAIRS)));

        public static final Block MANGROVE_CORNER = registerBlock("mangrove_corner",
                CornerBlock::new, (Settings.copy(Blocks.MANGROVE_STAIRS)));

        public static final Block CHERRY_CORNER = registerBlock("cherry_corner",
                CornerBlock::new, (Settings.copy(Blocks.CHERRY_STAIRS)));

        public static final Block PALE_OAK_CORNER = registerBlock("pale_oak_corner",
                CornerBlock::new, (Settings.copy(Blocks.PALE_OAK_STAIRS)));

        public static final Block BAMBOO_CORNER = registerBlock("bamboo_corner",
                CornerBlock::new, (Settings.copy(Blocks.BAMBOO_STAIRS)));

        public static final Block BAMBOO_MOSAIC_CORNER = registerBlock("bamboo_mosaic_corner",
                CornerBlock::new, (Settings.copy(Blocks.BAMBOO_MOSAIC_STAIRS)));

        public static final Block CRIMSON_CORNER = registerBlock("crimson_corner",
                CornerBlock::new, (Settings.copy(Blocks.CRIMSON_STAIRS)));

        public static final Block WARPED_CORNER = registerBlock("warped_corner",
                CornerBlock::new, (Settings.copy(Blocks.WARPED_STAIRS)));

        public static final Block STONE_CORNER = registerBlock("stone_corner",
                CornerBlock::new, (Settings.copy(Blocks.STONE_STAIRS)));

        public static final Block SMOOTH_STONE_CORNER = registerBlock("smooth_stone_corner",
                CornerBlock::new, (Settings.copy(ModBlocks.SMOOTH_STONE_STAIRS)));

        public static final Block SANDSTONE_CORNER = registerBlock("sandstone_corner",
                CornerBlock::new, (Settings.copy(Blocks.SANDSTONE_STAIRS)));

        public static final Block CUT_SANDSTONE_CORNER = registerBlock("cut_sandstone_corner",
                CornerBlock::new, (Settings.copy(ModBlocks.CUT_SANDSTONE_STAIRS)));

        public static final Block COBBLESTONE_CORNER = registerBlock("cobblestone_corner",
                CornerBlock::new, (Settings.copy(Blocks.COBBLESTONE_STAIRS)));

        public static final Block BRICK_CORNER = registerBlock("brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.BRICK_STAIRS)));

        public static final Block MUD_BRICK_CORNER = registerBlock("mud_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.MUD_BRICK_STAIRS)));

        public static final Block RESIN_BRICK_CORNER = registerBlock("resin_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.RESIN_BRICK_STAIRS)));

        public static final Block STONE_BRICK_CORNER = registerBlock("stone_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.STONE_BRICK_STAIRS)));

        public static final Block NETHER_BRICK_CORNER = registerBlock("nether_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.NETHER_BRICK_STAIRS)));

        public static final Block QUARTZ_CORNER = registerBlock("quartz_corner",
                CornerBlock::new, (Settings.copy(Blocks.QUARTZ_STAIRS)));

        public static final Block RED_SANDSTONE_CORNER = registerBlock("red_sandstone_corner",
                CornerBlock::new, (Settings.copy(Blocks.RED_SANDSTONE_STAIRS)));

        public static final Block CUT_RED_SANDSTONE_CORNER = registerBlock("cut_red_sandstone_corner",
                CornerBlock::new, (Settings.copy(ModBlocks.CUT_RED_SANDSTONE_STAIRS)));

        public static final Block PURPUR_CORNER = registerBlock("purpur_corner",
                CornerBlock::new, (Settings.copy(Blocks.PURPUR_STAIRS)));

        public static final Block PRISMARINE_CORNER = registerBlock("prismarine_corner",
                CornerBlock::new, (Settings.copy(Blocks.PRISMARINE_STAIRS)));

        public static final Block PRISMARINE_BRICK_CORNER = registerBlock("prismarine_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.PRISMARINE_BRICK_STAIRS)));

        public static final Block DARK_PRISMARINE_CORNER = registerBlock("dark_prismarine_corner",
                CornerBlock::new, (Settings.copy(Blocks.DARK_PRISMARINE_STAIRS)));

        public static final Block POLISHED_GRANITE_CORNER = registerBlock("polished_granite_corner",
                CornerBlock::new, (Settings.copy(Blocks.POLISHED_GRANITE_STAIRS)));

        public static final Block SMOOTH_RED_SANDSTONE_CORNER = registerBlock("smooth_red_sandstone_corner",
                CornerBlock::new, (Settings.copy(Blocks.SMOOTH_RED_SANDSTONE_STAIRS)));

        public static final Block MOSSY_STONE_BRICK_CORNER = registerBlock("mossy_stone_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.MOSSY_STONE_BRICK_STAIRS)));

        public static final Block POLISHED_DIORITE_CORNER = registerBlock("polished_diorite_corner",
                CornerBlock::new, (Settings.copy(Blocks.POLISHED_DIORITE_STAIRS)));

        public static final Block MOSSY_COBBLESTONE_CORNER = registerBlock("mossy_cobblestone_corner",
                CornerBlock::new, (Settings.copy(Blocks.MOSSY_COBBLESTONE_STAIRS)));

        public static final Block END_STONE_BRICK_CORNER = registerBlock("end_stone_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.END_STONE_BRICK_STAIRS)));

        public static final Block SMOOTH_SANDSTONE_CORNER = registerBlock("smooth_sandstone_corner",
                CornerBlock::new, (Settings.copy(Blocks.SMOOTH_SANDSTONE_STAIRS)));

        public static final Block SMOOTH_QUARTZ_CORNER = registerBlock("smooth_quartz_corner",
                CornerBlock::new, (Settings.copy(Blocks.SMOOTH_QUARTZ_STAIRS)));

        public static final Block GRANITE_CORNER = registerBlock("granite_corner",
                CornerBlock::new, (Settings.copy(Blocks.GRANITE_STAIRS)));

        public static final Block ANDESITE_CORNER = registerBlock("andesite_corner",
                CornerBlock::new, (Settings.copy(Blocks.ANDESITE_STAIRS)));

        public static final Block RED_NETHER_BRICK_CORNER = registerBlock("red_nether_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.RED_NETHER_BRICK_STAIRS)));

        public static final Block POLISHED_ANDESITE_CORNER = registerBlock("polished_andesite_corner",
                CornerBlock::new, (Settings.copy(Blocks.POLISHED_ANDESITE_STAIRS)));

        public static final Block DIORITE_CORNER = registerBlock("diorite_corner",
                CornerBlock::new, (Settings.copy(Blocks.DIORITE_STAIRS)));

        public static final Block COBBLED_DEEPSLATE_CORNER = registerBlock("cobbled_deepslate_corner",
                CornerBlock::new, (Settings.copy(Blocks.COBBLED_DEEPSLATE_STAIRS)));

        public static final Block POLISHED_DEEPSLATE_CORNER = registerBlock("polished_deepslate_corner",
                CornerBlock::new, (Settings.copy(Blocks.POLISHED_DEEPSLATE_STAIRS)));

        public static final Block DEEPSLATE_BRICK_CORNER = registerBlock("deepslate_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.DEEPSLATE_BRICK_STAIRS)));

        public static final Block DEEPSLATE_TILE_CORNER = registerBlock("deepslate_tile_corner",
                CornerBlock::new, (Settings.copy(Blocks.DEEPSLATE_TILE_STAIRS)));

        public static final Block TUFF_CORNER = registerBlock("tuff_corner",
                CornerBlock::new, (Settings.copy(Blocks.TUFF_STAIRS)));

        public static final Block POLISHED_TUFF_CORNER = registerBlock("polished_tuff_corner",
                CornerBlock::new, (Settings.copy(Blocks.POLISHED_TUFF_STAIRS)));

        public static final Block TUFF_BRICK_CORNER = registerBlock("tuff_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.TUFF_BRICK_STAIRS)));

        public static final Block BLACKSTONE_CORNER = registerBlock("blackstone_corner",
                CornerBlock::new, (Settings.copy(Blocks.BLACKSTONE_STAIRS)));

        public static final Block POLISHED_BLACKSTONE_CORNER = registerBlock("polished_blackstone_corner",
                CornerBlock::new, (Settings.copy(Blocks.POLISHED_BLACKSTONE_STAIRS)));

        public static final Block POLISHED_BLACKSTONE_BRICK_CORNER = registerBlock("polished_blackstone_brick_corner",
                CornerBlock::new, (Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS)));

        public static final Block CUT_COPPER_CORNER = registerBlock("cut_copper_corner",
                settings -> new OxidizableCornerBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), Settings.copy(Blocks.CUT_COPPER_STAIRS));

        public static final Block EXPOSED_CUT_COPPER_CORNER = registerBlock("exposed_cut_copper_corner",
                settings -> new OxidizableCornerBlock(Oxidizable.OxidationLevel.EXPOSED, settings), Settings.copy(Blocks.EXPOSED_CUT_COPPER_STAIRS));

        public static final Block WEATHERED_CUT_COPPER_CORNER = registerBlock("weathered_cut_copper_corner",
                settings -> new OxidizableCornerBlock(Oxidizable.OxidationLevel.WEATHERED, settings), Settings.copy(Blocks.WEATHERED_CUT_COPPER_STAIRS));

        public static final Block OXIDIZED_CUT_COPPER_CORNER = registerBlock("oxidized_cut_copper_corner",
                settings -> new OxidizableCornerBlock(Oxidizable.OxidationLevel.OXIDIZED, settings), Settings.copy(Blocks.OXIDIZED_CUT_COPPER_STAIRS));

        public static final Block WAXED_CUT_COPPER_CORNER = registerBlock("waxed_cut_copper_corner",
                settings -> new OxidizableCornerBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), Settings.copy(Blocks.WAXED_CUT_COPPER_STAIRS));

        public static final Block WAXED_EXPOSED_CUT_COPPER_CORNER = registerBlock("waxed_exposed_cut_copper_corner",
                settings -> new OxidizableCornerBlock(Oxidizable.OxidationLevel.EXPOSED, settings), Settings.copy(Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS));

        public static final Block WAXED_WEATHERED_CUT_COPPER_CORNER = registerBlock("waxed_weathered_cut_copper_corner",
                settings -> new OxidizableCornerBlock(Oxidizable.OxidationLevel.WEATHERED, settings), Settings.copy(Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS));

        public static final Block WAXED_OXIDIZED_CUT_COPPER_CORNER = registerBlock("waxed_oxidized_cut_copper_corner",
                settings -> new OxidizableCornerBlock(Oxidizable.OxidationLevel.OXIDIZED, settings), Settings.copy(Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS));
    }

    public static final Block OAK_CHAIR = registerBlock("oak_chair",
            ChairBlock::new, (Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));

    public static final Block SPRUCE_CHAIR = registerBlock("spruce_chair",
            ChairBlock::new, (Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));

    public static final Block BIRCH_CHAIR = registerBlock("birch_chair",
            ChairBlock::new, (Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));

    public static final Block JUNGLE_CHAIR = registerBlock("jungle_chair",
            ChairBlock::new, (Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));

    public static final Block ACACIA_CHAIR = registerBlock("acacia_chair",
            ChairBlock::new, (Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));

    public static final Block DARK_OAK_CHAIR = registerBlock("dark_oak_chair",
            ChairBlock::new, (Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));

    public static final Block MANGROVE_CHAIR = registerBlock("mangrove_chair",
            ChairBlock::new, (Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));

    public static final Block CHERRY_CHAIR = registerBlock("cherry_chair",
            ChairBlock::new, (Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));

    public static final Block PALE_OAK_CHAIR = registerBlock("pale_oak_chair",
            ChairBlock::new, (Settings.copy(Blocks.PALE_OAK_PLANKS).nonOpaque()));

    public static final Block BAMBOO_CHAIR = registerBlock("bamboo_chair",
            ChairBlock::new, (Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));

    public static final Block BAMBOO_MOSAIC_CHAIR = registerBlock("bamboo_mosaic_chair",
            ChairBlock::new, (Settings.copy(Blocks.BAMBOO_MOSAIC).nonOpaque()));

    public static final Block CRIMSON_CHAIR = registerBlock("crimson_chair",
            ChairBlock::new, (Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));

    public static final Block WARPED_CHAIR = registerBlock("warped_chair",
            ChairBlock::new, (Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));

    public static final Block OAK_TABLE = registerBlock("oak_table",
            TableBlock::new, (Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block SPRUCE_TABLE = registerBlock("spruce_table",
            TableBlock::new, (Settings.copy(Blocks.SPRUCE_PLANKS)));

    public static final Block BIRCH_TABLE = registerBlock("birch_table",
            TableBlock::new, (Settings.copy(Blocks.BIRCH_PLANKS)));

    public static final Block JUNGLE_TABLE = registerBlock("jungle_table",
            TableBlock::new, (Settings.copy(Blocks.JUNGLE_PLANKS)));

    public static final Block ACACIA_TABLE = registerBlock("acacia_table",
            TableBlock::new, (Settings.copy(Blocks.ACACIA_PLANKS)));

    public static final Block DARK_OAK_TABLE = registerBlock("dark_oak_table",
            TableBlock::new, (Settings.copy(Blocks.DARK_OAK_PLANKS)));

    public static final Block MANGROVE_TABLE = registerBlock("mangrove_table",
            TableBlock::new, (Settings.copy(Blocks.MANGROVE_PLANKS)));

    public static final Block CHERRY_TABLE = registerBlock("cherry_table",
            TableBlock::new, (Settings.copy(Blocks.CHERRY_PLANKS)));

    public static final Block PALE_OAK_TABLE = registerBlock("pale_oak_table",
            TableBlock::new, (Settings.copy(Blocks.PALE_OAK_PLANKS)));

    public static final Block BAMBOO_TABLE = registerBlock("bamboo_table",
            TableBlock::new, (Settings.copy(Blocks.BAMBOO_PLANKS)));

    public static final Block BAMBOO_MOSAIC_TABLE = registerBlock("bamboo_mosaic_table",
            TableBlock::new, (Settings.copy(Blocks.BAMBOO_MOSAIC)));

    public static final Block CRIMSON_TABLE = registerBlock("crimson_table",
            TableBlock::new, (Settings.copy(Blocks.CRIMSON_PLANKS)));

    public static final Block WARPED_TABLE = registerBlock("warped_table",
            TableBlock::new, (Settings.copy(Blocks.WARPED_PLANKS)));

    public static final Block TELEPORTER_BLOCK = registerBlock("teleporter_block",
            TeleporterBlock::new, (Settings.create().strength(5, 6).requiresTool()));

    public static class Pillars{
        public static final Block OAK_LOG_PILLAR = registerBlock("oak_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.OAK_LOG)));

        public static final Block OAK_WOOD_PILLAR = registerBlock("oak_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.OAK_WOOD)));

        public static final Block STRIPPED_OAK_LOG_PILLAR = registerBlock("stripped_oak_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_OAK_LOG)));

        public static final Block STRIPPED_OAK_WOOD_PILLAR = registerBlock("stripped_oak_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

        public static final Block OAK_PLANK_PILLAR = registerBlock("oak_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.OAK_PLANKS)));

        public static final Block SPRUCE_LOG_PILLAR = registerBlock("spruce_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SPRUCE_LOG)));

        public static final Block SPRUCE_WOOD_PILLAR = registerBlock("spruce_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SPRUCE_WOOD)));

        public static final Block STRIPPED_SPRUCE_LOG_PILLAR = registerBlock("stripped_spruce_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_SPRUCE_LOG)));

        public static final Block STRIPPED_SPRUCE_WOOD_PILLAR = registerBlock("stripped_spruce_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_SPRUCE_WOOD)));

        public static final Block SPRUCE_PLANK_PILLAR = registerBlock("spruce_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SPRUCE_PLANKS)));

        public static final Block BIRCH_LOG_PILLAR = registerBlock("birch_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BIRCH_LOG)));

        public static final Block BIRCH_WOOD_PILLAR = registerBlock("birch_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BIRCH_WOOD)));

        public static final Block STRIPPED_BIRCH_LOG_PILLAR = registerBlock("stripped_birch_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_BIRCH_LOG)));

        public static final Block STRIPPED_BIRCH_WOOD_PILLAR = registerBlock("stripped_birch_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_BIRCH_WOOD)));

        public static final Block BIRCH_PLANK_PILLAR = registerBlock("birch_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BIRCH_PLANKS)));

        public static final Block JUNGLE_LOG_PILLAR = registerBlock("jungle_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.JUNGLE_LOG)));

        public static final Block JUNGLE_WOOD_PILLAR = registerBlock("jungle_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.JUNGLE_WOOD)));

        public static final Block STRIPPED_JUNGLE_LOG_PILLAR = registerBlock("stripped_jungle_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_JUNGLE_LOG)));

        public static final Block STRIPPED_JUNGLE_WOOD_PILLAR = registerBlock("stripped_jungle_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_JUNGLE_WOOD)));

        public static final Block JUNGLE_PLANK_PILLAR = registerBlock("jungle_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.JUNGLE_PLANKS)));

        public static final Block ACACIA_LOG_PILLAR = registerBlock("acacia_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.ACACIA_LOG)));

        public static final Block ACACIA_WOOD_PILLAR = registerBlock("acacia_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.ACACIA_WOOD)));

        public static final Block STRIPPED_ACACIA_LOG_PILLAR = registerBlock("stripped_acacia_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_ACACIA_LOG)));

        public static final Block STRIPPED_ACACIA_WOOD_PILLAR = registerBlock("stripped_acacia_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_ACACIA_WOOD)));

        public static final Block ACACIA_PLANK_PILLAR = registerBlock("acacia_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.ACACIA_PLANKS)));

        public static final Block DARK_OAK_LOG_PILLAR = registerBlock("dark_oak_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DARK_OAK_LOG)));

        public static final Block DARK_OAK_WOOD_PILLAR = registerBlock("dark_oak_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DARK_OAK_WOOD)));

        public static final Block STRIPPED_DARK_OAK_LOG_PILLAR = registerBlock("stripped_dark_oak_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_DARK_OAK_LOG)));

        public static final Block STRIPPED_DARK_OAK_WOOD_PILLAR = registerBlock("stripped_dark_oak_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_DARK_OAK_WOOD)));

        public static final Block DARK_OAK_PLANK_PILLAR = registerBlock("dark_oak_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DARK_OAK_PLANKS)));

        public static final Block MANGROVE_LOG_PILLAR = registerBlock("mangrove_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MANGROVE_LOG)));

        public static final Block MANGROVE_WOOD_PILLAR = registerBlock("mangrove_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MANGROVE_WOOD)));

        public static final Block STRIPPED_MANGROVE_LOG_PILLAR = registerBlock("stripped_mangrove_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_MANGROVE_LOG)));

        public static final Block STRIPPED_MANGROVE_WOOD_PILLAR = registerBlock("stripped_mangrove_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_MANGROVE_WOOD)));

        public static final Block MANGROVE_PLANK_PILLAR = registerBlock("mangrove_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MANGROVE_PLANKS)));

        public static final Block CHERRY_LOG_PILLAR = registerBlock("cherry_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHERRY_LOG)));

        public static final Block CHERRY_WOOD_PILLAR = registerBlock("cherry_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHERRY_WOOD)));

        public static final Block STRIPPED_CHERRY_LOG_PILLAR = registerBlock("stripped_cherry_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_CHERRY_LOG)));

        public static final Block STRIPPED_CHERRY_WOOD_PILLAR = registerBlock("stripped_cherry_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_CHERRY_WOOD)));

        public static final Block CHERRY_PLANK_PILLAR = registerBlock("cherry_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHERRY_PLANKS)));

        public static final Block PALE_OAK_LOG_PILLAR = registerBlock("pale_oak_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PALE_OAK_LOG)));

        public static final Block PALE_OAK_WOOD_PILLAR = registerBlock("pale_oak_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PALE_OAK_WOOD)));

        public static final Block STRIPPED_PALE_OAK_LOG_PILLAR = registerBlock("stripped_pale_oak_log_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_PALE_OAK_LOG)));

        public static final Block STRIPPED_PALE_OAK_WOOD_PILLAR = registerBlock("stripped_pale_oak_wood_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_PALE_OAK_WOOD)));

        public static final Block PALE_OAK_PLANK_PILLAR = registerBlock("pale_oak_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PALE_OAK_PLANKS)));

        public static final Block BAMBOO_PILLAR = registerBlock("bamboo_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BAMBOO_BLOCK)));

        public static final Block STRIPPED_BAMBOO_PILLAR = registerBlock("stripped_bamboo_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_BAMBOO_BLOCK)));

        public static final Block BAMBOO_PLANK_PILLAR = registerBlock("bamboo_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BAMBOO_PLANKS)));

        public static final Block BAMBOO_MOSAIC_PILLAR = registerBlock("bamboo_mosaic_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BAMBOO_MOSAIC)));

        public static final Block CRIMSON_STEM_PILLAR = registerBlock("crimson_stem_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CRIMSON_STEM)));

        public static final Block CRIMSON_HYPHAE_PILLAR = registerBlock("crimson_hyphae_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CRIMSON_HYPHAE)));

        public static final Block STRIPPED_CRIMSON_STEM_PILLAR = registerBlock("stripped_crimson_stem_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_CRIMSON_STEM)));

        public static final Block STRIPPED_CRIMSON_HYPHAE_PILLAR = registerBlock("stripped_crimson_hyphae_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_CRIMSON_HYPHAE)));

        public static final Block CRIMSON_PLANK_PILLAR = registerBlock("crimson_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CRIMSON_PLANKS)));

        public static final Block WARPED_STEM_PILLAR = registerBlock("warped_stem_pillar",
                PillarBlock::new, (Settings.copy(Blocks.WARPED_STEM)));

        public static final Block WARPED_HYPHAE_PILLAR = registerBlock("warped_hyphae_pillar",
                PillarBlock::new, (Settings.copy(Blocks.WARPED_HYPHAE)));

        public static final Block STRIPPED_WARPED_STEM_PILLAR = registerBlock("stripped_warped_stem_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_WARPED_STEM)));

        public static final Block STRIPPED_WARPED_HYPHAE_PILLAR = registerBlock("stripped_warped_hyphae_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STRIPPED_WARPED_HYPHAE)));

        public static final Block WARPED_PLANK_PILLAR = registerBlock("warped_plank_pillar",
                PillarBlock::new, (Settings.copy(Blocks.WARPED_PLANKS)));

        public static final Block STONE_PILLAR = registerBlock("stone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STONE)));

        public static final Block COBBLESTONE_PILLAR = registerBlock("cobblestone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.COBBLESTONE)));

        public static final Block MOSSY_COBBLESTONE_PILLAR = registerBlock("mossy_cobblestone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MOSSY_COBBLESTONE)));

        public static final Block SMOOTH_STONE_PILLAR = registerBlock("smooth_stone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SMOOTH_STONE)));

        public static final Block STONE_BRICK_PILLAR = registerBlock("stone_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.STONE_BRICKS)));

        public static final Block CRACKED_STONE_BRICK_PILLAR = registerBlock("cracked_stone_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CRACKED_STONE_BRICKS)));

        public static final Block CHISELED_STONE_BRICK_PILLAR = registerBlock("chiseled_stone_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_STONE_BRICKS)));

        public static final Block MOSSY_STONE_BRICK_PILLAR = registerBlock("mossy_stone_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MOSSY_STONE_BRICKS)));

        public static final Block GRANITE_PILLAR = registerBlock("granite_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GRANITE)));

        public static final Block POLISHED_GRANITE_PILLAR = registerBlock("polished_granite_pillar",
                PillarBlock::new, (Settings.copy(Blocks.POLISHED_GRANITE)));

        public static final Block DIORITE_PILLAR = registerBlock("diorite_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DIORITE)));

        public static final Block POLISHED_DIORITE_PILLAR = registerBlock("polished_diorite_pillar",
                PillarBlock::new, (Settings.copy(Blocks.POLISHED_DIORITE)));

        public static final Block ANDESITE_PILLAR = registerBlock("andesite_pillar",
                PillarBlock::new, (Settings.copy(Blocks.ANDESITE)));

        public static final Block POLISHED_ANDESITE_PILLAR = registerBlock("polished_andesite_pillar",
                PillarBlock::new, (Settings.copy(Blocks.POLISHED_ANDESITE)));

        public static final Block DEEPSLATE_PILLAR = registerBlock("deepslate_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DEEPSLATE)));

        public static final Block COBBLED_DEEPSLATE_PILLAR = registerBlock("cobbled_deepslate_pillar",
                PillarBlock::new, (Settings.copy(Blocks.COBBLED_DEEPSLATE)));

        public static final Block CHISELED_DEEPSLATE_PILLAR = registerBlock("chiseled_deepslate_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_DEEPSLATE)));

        public static final Block POLISHED_DEEPSLATE_PILLAR = registerBlock("polished_deepslate_pillar",
                PillarBlock::new, (Settings.copy(Blocks.POLISHED_DEEPSLATE)));

        public static final Block DEEPSLATE_BRICK_PILLAR = registerBlock("deepslate_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DEEPSLATE_BRICKS)));

        public static final Block CRACKED_DEEPSLATE_BRICK_PILLAR = registerBlock("cracked_deepslate_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));

        public static final Block DEEPSLATE_TILE_PILLAR = registerBlock("deepslate_tile_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DEEPSLATE_TILES)));

        public static final Block CRACKED_DEEPSLATE_TILE_PILLAR = registerBlock("cracked_deepslate_tile_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

        public static final Block REINFORCED_DEEPSLATE_PILLAR = registerBlock("reinforced_deepslate_pillar",
                PillarBlock::new, (Settings.copy(Blocks.REINFORCED_DEEPSLATE)));

        public static final Block TUFF_PILLAR = registerBlock("tuff_pillar",
                PillarBlock::new, (Settings.copy(Blocks.TUFF)));

        public static final Block CHISELED_TUFF_PILLAR = registerBlock("chiseled_tuff_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_TUFF)));

        public static final Block POLISHED_TUFF_PILLAR = registerBlock("polished_tuff_pillar",
                PillarBlock::new, (Settings.copy(Blocks.POLISHED_TUFF)));

        public static final Block TUFF_BRICK_PILLAR = registerBlock("tuff_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.TUFF_BRICKS)));

        public static final Block CHISELED_TUFF_BRICK_PILLAR = registerBlock("chiseled_tuff_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_TUFF_BRICKS)));

        public static final Block BRICK_PILLAR = registerBlock("brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BRICKS)));

        public static final Block PACKED_MUD_PILLAR = registerBlock("packed_mud_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PACKED_MUD)));

        public static final Block MUD_BRICK_PILLAR = registerBlock("mud_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MUD_BRICKS)));

        public static final Block RESIN_BRICK_PILLAR = registerBlock("resin_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.RESIN_BRICKS)));

        public static final Block CHISELED_RESIN_BRICK_PILLAR = registerBlock("chiseled_resin_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_RESIN_BRICKS)));

        public static final Block SANDSTONE_PILLAR = registerBlock("sandstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SANDSTONE)));

        public static final Block CHISELED_SANDSTONE_PILLAR = registerBlock("chiseled_sandstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_SANDSTONE)));

        public static final Block SMOOTH_SANDSTONE_PILLAR = registerBlock("smooth_sandstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SMOOTH_SANDSTONE)));

        public static final Block CUT_SANDSTONE_PILLAR = registerBlock("cut_sandstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CUT_SANDSTONE)));

        public static final Block RED_SANDSTONE_PILLAR = registerBlock("red_sandstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.RED_SANDSTONE)));

        public static final Block CHISELED_RED_SANDSTONE_PILLAR = registerBlock("chiseled_red_sandstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_RED_SANDSTONE)));

        public static final Block SMOOTH_RED_SANDSTONE_PILLAR = registerBlock("smooth_red_sandstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SMOOTH_RED_SANDSTONE)));

        public static final Block CUT_RED_SANDSTONE_PILLAR = registerBlock("cut_red_sandstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CUT_RED_SANDSTONE)));

        public static final Block SEA_LANTERN_PILLAR = registerBlock("sea_lantern_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SEA_LANTERN)));

        public static final Block PRISMARINE_PILLAR = registerBlock("prismarine_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PRISMARINE)));

        public static final Block PRISMARINE_BRICK_PILLAR = registerBlock("prismarine_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PRISMARINE_BRICKS)));

        public static final Block DARK_PRISMARINE_PILLAR = registerBlock("dark_prismarine_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DARK_PRISMARINE)));

        public static final Block NETHERRACK_PILLAR = registerBlock("netherrack_pillar",
                PillarNetherrackBlock::new, (Settings.copy(Blocks.NETHERRACK)));

        public static final Block NETHER_BRICK_PILLAR = registerBlock("nether_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.NETHER_BRICKS)));

        public static final Block CRACKED_NETHER_BRICK_PILLAR = registerBlock("cracked_nether_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CRACKED_NETHER_BRICKS)));

        public static final Block CHISELED_NETHER_BRICK_PILLAR = registerBlock("chiseled_nether_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_NETHER_BRICKS)));

        public static final Block RED_NETHER_BRICK_PILLAR = registerBlock("red_nether_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.RED_NETHER_BRICKS)));

        public static final Block BASALT_PILLAR = registerBlock("basalt_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BASALT)));

        public static final Block SMOOTH_BASALT_PILLAR = registerBlock("smooth_basalt_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SMOOTH_BASALT)));

        public static final Block POLISHED_BASALT_PILLAR = registerBlock("polished_basalt_pillar",
                PillarBlock::new, (Settings.copy(Blocks.POLISHED_BASALT)));

        public static final Block BLACKSTONE_PILLAR = registerBlock("blackstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BLACKSTONE)));

        public static final Block GILDED_BLACKSTONE_PILLAR = registerBlock("gilded_blackstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GILDED_BLACKSTONE)));

        public static final Block CHISELED_POLISHED_BLACKSTONE_PILLAR = registerBlock("chiseled_polished_blackstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));

        public static final Block POLISHED_BLACKSTONE_PILLAR = registerBlock("polished_blackstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.POLISHED_BLACKSTONE)));

        public static final Block POLISHED_BLACKSTONE_BRICK_PILLAR = registerBlock("polished_blackstone_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));

        public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_PILLAR = registerBlock("cracked_polished_blackstone_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));

        public static final Block END_STONE_PILLAR = registerBlock("end_stone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.END_STONE)));

        public static final Block END_STONE_BRICK_PILLAR = registerBlock("end_stone_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.END_STONE_BRICKS)));

        public static final Block PURPUR_PILLAR = registerBlock("purpur_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PURPUR_BLOCK)));

        public static final Block PURPUR_PILLAR_PILLAR = registerBlock("purpur_pillar_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PURPUR_PILLAR)));

        public static final Block COAL_PILLAR = registerBlock("coal_pillar",
                PillarBlock::new, (Settings.copy(Blocks.COAL_BLOCK)));

        public static final Block IRON_PILLAR = registerBlock("iron_pillar",
                PillarBlock::new, (Settings.copy(Blocks.IRON_BLOCK)));

        public static final Block GOLD_PILLAR = registerBlock("gold_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GOLD_BLOCK)));

        public static final Block REDSTONE_PILLAR = registerBlock("redstone_pillar",
                PillarRedstoneBlock::new, (Settings.copy(Blocks.REDSTONE_BLOCK)));

        public static final Block LAPIS_PILLAR = registerBlock("lapis_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LAPIS_BLOCK)));

        public static final Block EMERALD_PILLAR = registerBlock("emerald_pillar",
                PillarBlock::new, (Settings.copy(Blocks.EMERALD_BLOCK)));

        public static final Block DIAMOND_PILLAR = registerBlock("diamond_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DIAMOND_BLOCK)));

        public static final Block NETHERITE_PILLAR = registerBlock("netherite_pillar",
                PillarBlock::new, (Settings.copy(Blocks.NETHERITE_BLOCK)));

        public static final Block QUARTZ_PILLAR = registerBlock("quartz_pillar",
                PillarBlock::new, (Settings.copy(Blocks.QUARTZ_BLOCK)));

        public static final Block CHISELED_QUARTZ_PILLAR = registerBlock("chiseled_quartz_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CHISELED_QUARTZ_BLOCK)));

        public static final Block QUARTZ_BRICK_PILLAR = registerBlock("quartz_brick_pillar",
                PillarBlock::new, (Settings.copy(Blocks.QUARTZ_BRICKS)));

        public static final Block QUARTZ_PILLAR_PILLAR = registerBlock("quartz_pillar_pillar",
                PillarBlock::new, (Settings.copy(Blocks.QUARTZ_PILLAR)));

        public static final Block SMOOTH_QUARTZ_PILLAR = registerBlock("smooth_quartz_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SMOOTH_QUARTZ)));

        public static final Block AMETHYST_PILLAR = registerBlock("amethyst_pillar",
                PillarAmethystBlock::new, (Settings.copy(Blocks.AMETHYST_BLOCK)));

        public static final Block COPPER_PILLAR = registerBlock("copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), Settings.copy(Blocks.COPPER_BLOCK));

        public static final Block CHISELED_COPPER_PILLAR = registerBlock("chiseled_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), Settings.copy(Blocks.CHISELED_COPPER));

        public static final Block COPPER_GRATE_PILLAR = registerBlock("copper_grate_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), Settings.copy(Blocks.COPPER_GRATE));

        public static final Block CUT_COPPER_PILLAR = registerBlock("cut_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), Settings.copy(Blocks.CUT_COPPER));

        public static final Block COPPER_BULB_PILLAR = registerBlock("copper_bulb_pillar",
                settings -> new OxidizableBulbPillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings), Settings.copy(Blocks.COPPER_BULB));

        public static final Block EXPOSED_COPPER_PILLAR = registerBlock("exposed_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, settings), Settings.copy(Blocks.EXPOSED_COPPER));

        public static final Block EXPOSED_CHISELED_COPPER_PILLAR = registerBlock("exposed_chiseled_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, settings), Settings.copy(Blocks.EXPOSED_CHISELED_COPPER));

        public static final Block EXPOSED_COPPER_GRATE_PILLAR = registerBlock("exposed_copper_grate_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, settings), Settings.copy(Blocks.EXPOSED_COPPER_GRATE));

        public static final Block EXPOSED_CUT_COPPER_PILLAR = registerBlock("exposed_cut_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, settings), Settings.copy(Blocks.EXPOSED_CUT_COPPER));

        public static final Block EXPOSED_COPPER_BULB_PILLAR = registerBlock("exposed_copper_bulb_pillar",
                settings -> new OxidizableBulbPillarBlock(Oxidizable.OxidationLevel.EXPOSED, settings), Settings.copy(Blocks.EXPOSED_COPPER_BULB));

        public static final Block WEATHERED_COPPER_PILLAR = registerBlock("weathered_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, settings), Settings.copy(Blocks.WEATHERED_COPPER));

        public static final Block WEATHERED_CHISELED_COPPER_PILLAR = registerBlock("weathered_chiseled_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, settings), Settings.copy(Blocks.WEATHERED_CHISELED_COPPER));

        public static final Block WEATHERED_COPPER_GRATE_PILLAR = registerBlock("weathered_copper_grate_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, settings), Settings.copy(Blocks.WEATHERED_COPPER_GRATE));

        public static final Block WEATHERED_CUT_COPPER_PILLAR = registerBlock("weathered_cut_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, settings), Settings.copy(Blocks.WEATHERED_CUT_COPPER));

        public static final Block WEATHERED_COPPER_BULB_PILLAR = registerBlock("weathered_copper_bulb_pillar",
                settings -> new OxidizableBulbPillarBlock(Oxidizable.OxidationLevel.WEATHERED, settings), Settings.copy(Blocks.WEATHERED_COPPER_BULB));

        public static final Block OXIDIZED_COPPER_PILLAR = registerBlock("oxidized_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, settings), Settings.copy(Blocks.OXIDIZED_COPPER));

        public static final Block OXIDIZED_CHISELED_COPPER_PILLAR = registerBlock("oxidized_chiseled_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, settings), Settings.copy(Blocks.OXIDIZED_CHISELED_COPPER));

        public static final Block OXIDIZED_COPPER_GRATE_PILLAR = registerBlock("oxidized_copper_grate_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, settings), Settings.copy(Blocks.OXIDIZED_COPPER_GRATE));

        public static final Block OXIDIZED_CUT_COPPER_PILLAR = registerBlock("oxidized_cut_copper_pillar",
                settings -> new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, settings), Settings.copy(Blocks.OXIDIZED_CUT_COPPER));

        public static final Block OXIDIZED_COPPER_BULB_PILLAR = registerBlock("oxidized_copper_bulb_pillar",
                settings -> new OxidizableBulbPillarBlock(Oxidizable.OxidationLevel.OXIDIZED, settings), Settings.copy(Blocks.OXIDIZED_COPPER_BULB));

        public static final Block WAXED_COPPER_PILLAR = registerBlock("waxed_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_COPPER_BLOCK));

        public static final Block WAXED_CHISELED_COPPER_PILLAR = registerBlock("waxed_chiseled_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_CHISELED_COPPER));

        public static final Block WAXED_COPPER_GRATE_PILLAR = registerBlock("waxed_copper_grate_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_COPPER_GRATE));

        public static final Block WAXED_CUT_COPPER_PILLAR = registerBlock("waxed_cut_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_CUT_COPPER));

        public static final Block WAXED_COPPER_BULB_PILLAR = registerBlock("waxed_copper_bulb_pillar",
                PillarBulbBlock::new, Settings.copy(Blocks.WAXED_COPPER_BULB));

        public static final Block WAXED_EXPOSED_COPPER_PILLAR = registerBlock("waxed_exposed_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_EXPOSED_COPPER));

        public static final Block WAXED_EXPOSED_CHISELED_COPPER_PILLAR = registerBlock("waxed_exposed_chiseled_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_EXPOSED_CHISELED_COPPER));

        public static final Block WAXED_EXPOSED_COPPER_GRATE_PILLAR = registerBlock("waxed_exposed_copper_grate_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_EXPOSED_COPPER_GRATE));

        public static final Block WAXED_EXPOSED_CUT_COPPER_PILLAR = registerBlock("waxed_exposed_cut_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_EXPOSED_CUT_COPPER));

        public static final Block WAXED_EXPOSED_COPPER_BULB_PILLAR = registerBlock("waxed_exposed_copper_bulb_pillar",
                PillarBulbBlock::new, Settings.copy(Blocks.WAXED_EXPOSED_COPPER_BULB));

        public static final Block WAXED_WEATHERED_COPPER_PILLAR = registerBlock("waxed_weathered_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_WEATHERED_COPPER));

        public static final Block WAXED_WEATHERED_CHISELED_COPPER_PILLAR = registerBlock("waxed_weathered_chiseled_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_WEATHERED_CHISELED_COPPER));

        public static final Block WAXED_WEATHERED_COPPER_GRATE_PILLAR = registerBlock("waxed_weathered_copper_grate_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_WEATHERED_COPPER_GRATE));

        public static final Block WAXED_WEATHERED_CUT_COPPER_PILLAR = registerBlock("waxed_weathered_cut_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_WEATHERED_CUT_COPPER));

        public static final Block WAXED_WEATHERED_COPPER_BULB_PILLAR = registerBlock("waxed_weathered_copper_bulb_pillar",
                PillarBulbBlock::new, Settings.copy(Blocks.WAXED_WEATHERED_COPPER_BULB));

        public static final Block WAXED_OXIDIZED_COPPER_PILLAR = registerBlock("waxed_oxidized_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_OXIDIZED_COPPER));

        public static final Block WAXED_OXIDIZED_CHISELED_COPPER_PILLAR = registerBlock("waxed_oxidized_chiseled_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_OXIDIZED_CHISELED_COPPER));

        public static final Block WAXED_OXIDIZED_COPPER_GRATE_PILLAR = registerBlock("waxed_oxidized_copper_grate_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_OXIDIZED_COPPER_GRATE));

        public static final Block WAXED_OXIDIZED_CUT_COPPER_PILLAR = registerBlock("waxed_oxidized_cut_copper_pillar",
                PillarBlock::new, Settings.copy(Blocks.WAXED_OXIDIZED_CUT_COPPER));

        public static final Block WAXED_OXIDIZED_COPPER_BULB_PILLAR = registerBlock("waxed_oxidized_copper_bulb_pillar",
                PillarBulbBlock::new, Settings.copy(Blocks.WAXED_OXIDIZED_COPPER_BULB));

        public static final Block WHITE_WOOL_PILLAR = registerBlock("white_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.WHITE_WOOL)));

        public static final Block LIGHT_GRAY_WOOL_PILLAR = registerBlock("light_gray_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIGHT_GRAY_WOOL)));

        public static final Block GRAY_WOOL_PILLAR = registerBlock("gray_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GRAY_WOOL)));

        public static final Block BLACK_WOOL_PILLAR = registerBlock("black_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BLACK_WOOL)));

        public static final Block BROWN_WOOL_PILLAR = registerBlock("brown_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BROWN_WOOL)));

        public static final Block RED_WOOL_PILLAR = registerBlock("red_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.RED_WOOL)));

        public static final Block ORANGE_WOOL_PILLAR = registerBlock("orange_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.ORANGE_WOOL)));

        public static final Block YELLOW_WOOL_PILLAR = registerBlock("yellow_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.YELLOW_WOOL)));

        public static final Block LIME_WOOL_PILLAR = registerBlock("lime_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIME_WOOL)));

        public static final Block GREEN_WOOL_PILLAR = registerBlock("green_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GREEN_WOOL)));

        public static final Block CYAN_WOOL_PILLAR = registerBlock("cyan_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CYAN_WOOL)));

        public static final Block LIGHT_BLUE_WOOL_PILLAR = registerBlock("light_blue_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIGHT_BLUE_WOOL)));

        public static final Block BLUE_WOOL_PILLAR = registerBlock("blue_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BLUE_WOOL)));

        public static final Block PURPLE_WOOL_PILLAR = registerBlock("purple_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PURPLE_WOOL)));

        public static final Block MAGENTA_WOOL_PILLAR = registerBlock("magenta_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MAGENTA_WOOL)));

        public static final Block PINK_WOOL_PILLAR = registerBlock("pink_wool_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PINK_WOOL)));

        public static final Block TERRACOTTA_PILLAR = registerBlock("terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.TERRACOTTA)));

        public static final Block WHITE_TERRACOTTA_PILLAR = registerBlock("white_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.WHITE_TERRACOTTA)));

        public static final Block LIGHT_GRAY_TERRACOTTA_PILLAR = registerBlock("light_gray_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIGHT_GRAY_TERRACOTTA)));

        public static final Block GRAY_TERRACOTTA_PILLAR = registerBlock("gray_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GRAY_TERRACOTTA)));

        public static final Block BLACK_TERRACOTTA_PILLAR = registerBlock("black_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BLACK_TERRACOTTA)));

        public static final Block BROWN_TERRACOTTA_PILLAR = registerBlock("brown_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BROWN_TERRACOTTA)));

        public static final Block RED_TERRACOTTA_PILLAR = registerBlock("red_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.RED_TERRACOTTA)));

        public static final Block ORANGE_TERRACOTTA_PILLAR = registerBlock("orange_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.ORANGE_TERRACOTTA)));

        public static final Block YELLOW_TERRACOTTA_PILLAR = registerBlock("yellow_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.YELLOW_TERRACOTTA)));

        public static final Block LIME_TERRACOTTA_PILLAR = registerBlock("lime_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIME_TERRACOTTA)));

        public static final Block GREEN_TERRACOTTA_PILLAR = registerBlock("green_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GREEN_TERRACOTTA)));

        public static final Block CYAN_TERRACOTTA_PILLAR = registerBlock("cyan_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CYAN_TERRACOTTA)));

        public static final Block LIGHT_BLUE_TERRACOTTA_PILLAR = registerBlock("light_blue_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIGHT_BLUE_TERRACOTTA)));

        public static final Block BLUE_TERRACOTTA_PILLAR = registerBlock("blue_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BLUE_TERRACOTTA)));

        public static final Block PURPLE_TERRACOTTA_PILLAR = registerBlock("purple_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PURPLE_TERRACOTTA)));

        public static final Block MAGENTA_TERRACOTTA_PILLAR = registerBlock("magenta_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MAGENTA_TERRACOTTA)));

        public static final Block PINK_TERRACOTTA_PILLAR = registerBlock("pink_terracotta_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PINK_TERRACOTTA)));

        public static final Block WHITE_CONCRETE_PILLAR = registerBlock("white_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.WHITE_CONCRETE)));

        public static final Block LIGHT_GRAY_CONCRETE_PILLAR = registerBlock("light_gray_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIGHT_GRAY_CONCRETE)));

        public static final Block GRAY_CONCRETE_PILLAR = registerBlock("gray_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GRAY_CONCRETE)));

        public static final Block BLACK_CONCRETE_PILLAR = registerBlock("black_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BLACK_CONCRETE)));

        public static final Block BROWN_CONCRETE_PILLAR = registerBlock("brown_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BROWN_CONCRETE)));

        public static final Block RED_CONCRETE_PILLAR = registerBlock("red_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.RED_CONCRETE)));

        public static final Block ORANGE_CONCRETE_PILLAR = registerBlock("orange_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.ORANGE_CONCRETE)));

        public static final Block YELLOW_CONCRETE_PILLAR = registerBlock("yellow_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.YELLOW_CONCRETE)));

        public static final Block LIME_CONCRETE_PILLAR = registerBlock("lime_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIME_CONCRETE)));

        public static final Block GREEN_CONCRETE_PILLAR = registerBlock("green_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GREEN_CONCRETE)));

        public static final Block CYAN_CONCRETE_PILLAR = registerBlock("cyan_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CYAN_CONCRETE)));

        public static final Block LIGHT_BLUE_CONCRETE_PILLAR = registerBlock("light_blue_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LIGHT_BLUE_CONCRETE)));

        public static final Block BLUE_CONCRETE_PILLAR = registerBlock("blue_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BLUE_CONCRETE)));

        public static final Block PURPLE_CONCRETE_PILLAR = registerBlock("purple_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PURPLE_CONCRETE)));

        public static final Block MAGENTA_CONCRETE_PILLAR = registerBlock("magenta_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MAGENTA_CONCRETE)));

        public static final Block PINK_CONCRETE_PILLAR = registerBlock("pink_concrete_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PINK_CONCRETE)));

        public static final Block GLASS_PILLAR = registerBlock("glass_pillar",
                PillarTransparentBlock::new, (Settings.copy(Blocks.GLASS)));

        public static final Block WHITE_STAINED_GLASS_PILLAR = registerBlock("white_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.WHITE, settings), Settings.copy(Blocks.WHITE_STAINED_GLASS));

        public static final Block LIGHT_GRAY_STAINED_GLASS_PILLAR = registerBlock("light_gray_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.LIGHT_GRAY, settings), (Settings.copy(Blocks.LIGHT_GRAY_STAINED_GLASS)));

        public static final Block GRAY_STAINED_GLASS_PILLAR = registerBlock("gray_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.GRAY, settings), (Settings.copy(Blocks.GRAY_STAINED_GLASS)));

        public static final Block BLACK_STAINED_GLASS_PILLAR = registerBlock("black_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.BLACK, settings), (Settings.copy(Blocks.BLACK_STAINED_GLASS)));

        public static final Block BROWN_STAINED_GLASS_PILLAR = registerBlock("brown_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.BROWN, settings), (Settings.copy(Blocks.BROWN_STAINED_GLASS)));

        public static final Block RED_STAINED_GLASS_PILLAR = registerBlock("red_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.RED, settings), (Settings.copy(Blocks.RED_STAINED_GLASS)));

        public static final Block ORANGE_STAINED_GLASS_PILLAR = registerBlock("orange_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.ORANGE, settings), (Settings.copy(Blocks.ORANGE_STAINED_GLASS)));

        public static final Block YELLOW_STAINED_GLASS_PILLAR = registerBlock("yellow_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.YELLOW, settings), (Settings.copy(Blocks.YELLOW_STAINED_GLASS)));

        public static final Block LIME_STAINED_GLASS_PILLAR = registerBlock("lime_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.LIME, settings), (Settings.copy(Blocks.LIME_STAINED_GLASS)));

        public static final Block GREEN_STAINED_GLASS_PILLAR = registerBlock("green_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.GREEN, settings), (Settings.copy(Blocks.GREEN_STAINED_GLASS)));

        public static final Block CYAN_STAINED_GLASS_PILLAR = registerBlock("cyan_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.CYAN, settings), (Settings.copy(Blocks.CYAN_STAINED_GLASS)));

        public static final Block LIGHT_BLUE_STAINED_GLASS_PILLAR = registerBlock("light_blue_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.LIGHT_BLUE, settings), (Settings.copy(Blocks.LIGHT_BLUE_STAINED_GLASS)));

        public static final Block BLUE_STAINED_GLASS_PILLAR = registerBlock("blue_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.BLUE, settings), (Settings.copy(Blocks.BLUE_STAINED_GLASS)));

        public static final Block PURPLE_STAINED_GLASS_PILLAR = registerBlock("purple_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.PURPLE, settings), (Settings.copy(Blocks.PURPLE_STAINED_GLASS)));

        public static final Block MAGENTA_STAINED_GLASS_PILLAR = registerBlock("magenta_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.MAGENTA, settings), (Settings.copy(Blocks.MAGENTA_STAINED_GLASS)));

        public static final Block PINK_STAINED_GLASS_PILLAR = registerBlock("pink_stained_glass_pillar",
                settings -> new PillarStainedGlassBlock(DyeColor.PINK, settings), (Settings.copy(Blocks.PINK_STAINED_GLASS)));

        public static final Block PODZOL_PILLAR = registerBlock("podzol_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PODZOL)));

        public static final Block MYCELIUM_PILLAR = registerBlock("mycelium_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MYCELIUM)));

        public static final Block DIRT_PILLAR = registerBlock("dirt_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DIRT)));

        public static final Block COARSE_DIRT_PILLAR = registerBlock("coarse_dirt_pillar",
                PillarBlock::new, (Settings.copy(Blocks.COARSE_DIRT)));

        public static final Block ROOTED_DIRT_PILLAR = registerBlock("rooted_dirt_pillar",
                PillarRootedDirtBlock::new, (Settings.copy(Blocks.ROOTED_DIRT)));

        public static final Block MUD_PILLAR = registerBlock("mud_pillar",
                PillarMudBlock::new, (Settings.copy(Blocks.MUD)));

        public static final Block CLAY_PILLAR = registerBlock("clay_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CLAY)));

        public static final Block ICE_PILLAR = registerBlock("ice_pillar",
                PillarIceBlock::new, (Settings.copy(Blocks.ICE)));

        public static final Block PACKED_ICE_PILLAR = registerBlock("packed_ice_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PACKED_ICE)));

        public static final Block BLUE_ICE_PILLAR = registerBlock("blue_ice_pillar",
                PillarTransparentBlock::new, (Settings.copy(Blocks.BLUE_ICE)));

        public static final Block SNOW_PILLAR = registerBlock("snow_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SNOW_BLOCK)));

        public static final Block MOSS_PILLAR = registerBlock("moss_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MOSS_BLOCK)));

        public static final Block PALE_MOSS_PILLAR = registerBlock("pale_moss_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PALE_MOSS_BLOCK)));

        public static final Block CALCITE_PILLAR = registerBlock("calcite_pillar",
                PillarBlock::new, (Settings.copy(Blocks.CALCITE)));

        public static final Block DRIPSTONE_PILLAR = registerBlock("dripstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DRIPSTONE_BLOCK)));

        public static final Block MAGMA_PILLAR = registerBlock("magma_pillar",
                PillarMagmaBlock::new, (Settings.copy(Blocks.MAGMA_BLOCK)));

        public static final Block OBSIDIAN_PILLAR = registerBlock("obsidian_pillar",
                PillarBlock::new, (Settings.copy(Blocks.OBSIDIAN)));

        public static final Block CRYING_OBSIDIAN_PILLAR = registerBlock("crying_obsidian_pillar",
                PillarCryingObsidianBlock::new, (Settings.copy(Blocks.CRYING_OBSIDIAN)));

        public static final Block CRIMSON_NYLIUM_PILLAR = registerBlock("crimson_nylium_pillar",
                PillarNyliumBlock::new, (Settings.copy(Blocks.CRIMSON_NYLIUM)));

        public static final Block WARPED_NYLIUM_PILLAR = registerBlock("warped_nylium_pillar",
                PillarNyliumBlock::new, (Settings.copy(Blocks.WARPED_NYLIUM)));

        public static final Block SOUL_SAND_PILLAR = registerBlock("soul_sand_pillar",
                PillarSoulSandBlock::new, (Settings.copy(Blocks.SOUL_SAND)));

        public static final Block SOUL_SOIL_PILLAR = registerBlock("soul_soil_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SOUL_SOIL)));

        public static final Block BONE_PILLAR = registerBlock("bone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BONE_BLOCK)));

        public static final Block GLOWSTONE_PILLAR = registerBlock("glowstone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.GLOWSTONE)));

        public static final Block MUDDY_MANGROVE_ROOT_PILLAR = registerBlock("muddy_mangrove_root_pillar",
                PillarBlock::new, (Settings.copy(Blocks.MUDDY_MANGROVE_ROOTS)));

        public static final Block MUSHROOM_STEM_PILLAR = registerBlock("mushroom_stem_pillar",
                PillarMushroomBlock::new, (Settings.copy(Blocks.MUSHROOM_STEM)));

        public static final Block BROWN_MUSHROOM_PILLAR = registerBlock("brown_mushroom_pillar",
                PillarMushroomBlock::new, (Settings.copy(Blocks.BROWN_MUSHROOM_BLOCK)));

        public static final Block RED_MUSHROOM_PILLAR = registerBlock("red_mushroom_pillar",
                PillarMushroomBlock::new, (Settings.copy(Blocks.RED_MUSHROOM_BLOCK)));

        public static final Block NETHER_WART_PILLAR = registerBlock("nether_wart_pillar",
                PillarBlock::new, (Settings.copy(Blocks.NETHER_WART_BLOCK)));

        public static final Block WARPED_WART_PILLAR = registerBlock("warped_wart_pillar",
                PillarBlock::new, (Settings.copy(Blocks.WARPED_WART_BLOCK)));

        public static final Block SHROOMLIGHT_PILLAR = registerBlock("shroomlight_pillar",
                PillarBlock::new, (Settings.copy(Blocks.SHROOMLIGHT)));

        public static final Block DEAD_TUBE_CORAL_PILLAR = registerBlock("dead_tube_coral_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DEAD_TUBE_CORAL_BLOCK)));

        public static final Block DEAD_BRAIN_CORAL_PILLAR = registerBlock("dead_brain_coral_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));

        public static final Block DEAD_BUBBLE_CORAL_PILLAR = registerBlock("dead_bubble_coral_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DEAD_BUBBLE_CORAL_BLOCK)));

        public static final Block DEAD_FIRE_CORAL_PILLAR = registerBlock("dead_fire_coral_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DEAD_FIRE_CORAL_BLOCK)));

        public static final Block DEAD_HORN_CORAL_PILLAR = registerBlock("dead_horn_coral_pillar",
                PillarBlock::new, (Settings.copy(Blocks.DEAD_HORN_CORAL_BLOCK)));

        public static final Block TUBE_CORAL_PILLAR = registerBlock("tube_coral_pillar",
                settings -> new PillarCoralBlock(DEAD_TUBE_CORAL_PILLAR, settings), Settings.copy(Blocks.TUBE_CORAL_BLOCK));

        public static final Block BRAIN_CORAL_PILLAR = registerBlock("brain_coral_pillar",
                settings -> new PillarCoralBlock(DEAD_BRAIN_CORAL_PILLAR, settings), Settings.copy(Blocks.BRAIN_CORAL_BLOCK));

        public static final Block BUBBLE_CORAL_PILLAR = registerBlock("bubble_coral_pillar",
                settings -> new PillarCoralBlock(DEAD_BUBBLE_CORAL_PILLAR, settings), Settings.copy(Blocks.BUBBLE_CORAL_BLOCK));

        public static final Block FIRE_CORAL_PILLAR = registerBlock("fire_coral_pillar",
                settings -> new PillarCoralBlock(DEAD_FIRE_CORAL_PILLAR, settings), Settings.copy(Blocks.FIRE_CORAL_BLOCK));

        public static final Block HORN_CORAL_PILLAR = registerBlock("horn_coral_pillar",
                settings -> new PillarCoralBlock(DEAD_HORN_CORAL_PILLAR, settings), Settings.copy(Blocks.HORN_CORAL_BLOCK));

        public static final Block SPONGE_PILLAR = registerBlock("sponge_pillar",
                PillarSpongeBlock::new, (Settings.copy(Blocks.SPONGE)));

        public static final Block WET_SPONGE_PILLAR = registerBlock("wet_sponge_pillar",
                PillarBlock::new, (Settings.copy(Blocks.WET_SPONGE)));

        public static final Block HAY_PILLAR = registerBlock("hay_pillar",
                PillarHayBlock::new, (Settings.copy(Blocks.HAY_BLOCK)));

        public static final Block HONEYCOMB_PILLAR = registerBlock("honeycomb_pillar",
                PillarBlock::new, (Settings.copy(Blocks.HONEYCOMB_BLOCK)));

        public static final Block SLIME_PILLAR = registerBlock("slime_pillar",
                PillarSlimeBlock::new, (Settings.copy(Blocks.SLIME_BLOCK)));

        public static final Block HONEY_PILLAR = registerBlock("honey_pillar",
                PillarHoneyBlock::new, (Settings.copy(Blocks.HONEY_BLOCK)));

        public static final Block RESIN_PILLAR = registerBlock("resin_pillar",
                PillarBlock::new, (Settings.copy(Blocks.RESIN_BLOCK)));

        public static final Block OCHRE_FROGLIGHT_PILLAR = registerBlock("ochre_froglight_pillar",
                PillarBlock::new, (Settings.copy(Blocks.OCHRE_FROGLIGHT)));

        public static final Block VERDANT_FROGLIGHT_PILLAR = registerBlock("verdant_froglight_pillar",
                PillarBlock::new, (Settings.copy(Blocks.VERDANT_FROGLIGHT)));

        public static final Block PEARLESCENT_FROGLIGHT_PILLAR = registerBlock("pearlescent_froglight_pillar",
                PillarBlock::new, (Settings.copy(Blocks.PEARLESCENT_FROGLIGHT)));

        public static final Block SCULK_PILLAR = registerBlock("sculk_pillar",
                PillarSculkBlock::new, (Settings.copy(Blocks.SCULK)));

//        public static final Block SCULK_CATALYST_PILLAR = registerBlock("sculk_catalyst_pillar",
//                PillarSculkCatalystBlock::new, (Settings.copy(Blocks.SCULK_CATALYST)));

        public static final Block LODESTONE_PILLAR = registerBlock("lodestone_pillar",
                PillarBlock::new, (Settings.copy(Blocks.LODESTONE)));

        public static final Block BOOKSHELF_PILLAR = registerBlock("bookshelf_pillar",
                PillarBlock::new, (Settings.copy(Blocks.BOOKSHELF)));

//        public static final Block CHISELED_BOOKSHELF_PILLAR = registerBlock("chiseled_bookshelf_pillar",
//                PillarChiseledBookshelfBlock::new, (Settings.copy(Blocks.CHISELED_BOOKSHELF)));

        public static final Block TARGET_PILLAR = registerBlock("target_pillar",
                PillarTargetBlock::new, (Settings.copy(Blocks.TARGET)));

        public static final Block TNT_PILLAR = registerBlock("tnt_pillar",
                PillarTntBlock::new, (Settings.copy(Blocks.TNT)));

//        public static final Block CREAKING_HEART_PILLAR = registerBlock("creaking_heart_pillar",
//                PillarCreakingHeartBlock::new, (Settings.copy(Blocks.CREAKING_HEART)));
    }

    private static Block registerBlock(String name, Function<Settings, Block> function, Settings settings) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(BetterBuilding.MOD_ID, name));
        Block block = function.apply(settings.registryKey(blockKey));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<Settings, Block> function, Settings settings) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(BetterBuilding.MOD_ID, name));
        Block block = function.apply(settings.registryKey(blockKey));
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Item registerBlockItem(String name, Block block) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BetterBuilding.MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey, blockItem);
    }

    public static void registerModBlocks() {
        BetterBuilding.LOGGER.info("Registering Mod Blocks for BetterBuilding" + BetterBuilding.MOD_ID);
    }
}
