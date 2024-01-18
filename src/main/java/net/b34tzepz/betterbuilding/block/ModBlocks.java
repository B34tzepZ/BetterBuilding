package net.b34tzepz.betterbuilding.block;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.custom.*;
import net.b34tzepz.betterbuilding.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
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

    public static class Corners{
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
        public static final Block DIRT_PILLAR = registerBlock("dirt_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DIRT)), ModItemGroup.Pillars);
        public static final Block COARSE_DIRT_PILLAR = registerBlock("coarse_dirt_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.COARSE_DIRT)), ModItemGroup.Pillars);
        public static final Block COBBLESTONE_PILLAR = registerBlock("cobblestone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)), ModItemGroup.Pillars);
        public static final Block OAK_PLANKS_PILLAR = registerBlock("oak_planks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModItemGroup.Pillars);
        public static final Block SPRUCE_PLANKS_PILLAR = registerBlock("spruce_planks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)), ModItemGroup.Pillars);
        public static final Block BIRCH_PLANKS_PILLAR = registerBlock("birch_planks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)), ModItemGroup.Pillars);
        public static final Block JUNGLE_PLANKS_PILLAR = registerBlock("jungle_planks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS)), ModItemGroup.Pillars);
        public static final Block ACACIA_PLANKS_PILLAR = registerBlock("acacia_planks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)), ModItemGroup.Pillars);
        public static final Block DARK_OAK_PLANKS_PILLAR = registerBlock("dark_oak_planks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)), ModItemGroup.Pillars);
        public static final Block BEDROCK_PILLAR = registerBlock("bedrock_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BEDROCK)), ModItemGroup.Pillars);
        public static final Block LAPIS_BLOCK_PILLAR = registerBlock("lapis_block_pillar",
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
        public static final Block GOLD_BLOCK_PILLAR = registerBlock("gold_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)), ModItemGroup.Pillars);
        public static final Block IRON_BLOCK_PILLAR = registerBlock("iron_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)), ModItemGroup.Pillars);
        public static final Block BRICKS_PILLAR = registerBlock("bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BRICKS)), ModItemGroup.Pillars);
        public static final Block BOOKSHELF_PILLAR = registerBlock("bookshelf_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BOOKSHELF)), ModItemGroup.Pillars);
        public static final Block MOSSY_COBBLESTONE_PILLAR = registerBlock("mossy_cobblestone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_COBBLESTONE)), ModItemGroup.Pillars);
        public static final Block OBSIDIAN_PILLAR = registerBlock("obsidian_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)), ModItemGroup.Pillars);
        public static final Block DIAMOND_BLOCK_PILLAR = registerBlock("diamond_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)), ModItemGroup.Pillars);
        public static final Block SNOW_BLOCK_PILLAR = registerBlock("snow_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK)), ModItemGroup.Pillars);
        public static final Block CLAY_PILLAR = registerBlock("clay_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CLAY)), ModItemGroup.Pillars);
        public static final Block SOUL_SOIL_PILLAR = registerBlock("soul_soil_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SOUL_SOIL)), ModItemGroup.Pillars);
        public static final Block GLOWSTONE_PILLAR = registerBlock("glowstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GLOWSTONE)), ModItemGroup.Pillars);
        public static final Block STONE_BRICKS_PILLAR = registerBlock("stone_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block MOSSY_STONE_BRICKS_PILLAR = registerBlock("mossy_stone_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.MOSSY_STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CRACKED_STONE_BRICKS_PILLAR = registerBlock("cracked_stone_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CHISELED_STONE_BRICKS_PILLAR = registerBlock("chiseled_stone_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block NETHER_BRICKS_PILLAR = registerBlock("nether_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.NETHER_BRICKS)), ModItemGroup.Pillars);
        public static final Block END_STONE_PILLAR = registerBlock("end_stone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.END_STONE)), ModItemGroup.Pillars);
        public static final Block EMERALD_BLOCK_PILLAR = registerBlock("emerald_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)), ModItemGroup.Pillars);
        public static final Block QUARTZ_BLOCK_PILLAR = registerBlock("quartz_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK)), ModItemGroup.Pillars);
        public static final Block CHISELED_QUARTZ_BLOCK_PILLAR = registerBlock("chiseled_quartz_block_pillar",
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
        public static final Block PRISMARINE_BRICKS_PILLAR = registerBlock("prismarine_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS)), ModItemGroup.Pillars);
        public static final Block DARK_PRISMARINE_PILLAR = registerBlock("dark_prismarine_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_PRISMARINE)), ModItemGroup.Pillars);
        public static final Block SEA_LANTERN_PILLAR = registerBlock("sea_lantern_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SEA_LANTERN)), ModItemGroup.Pillars);
        public static final Block TERRACOTTA_PILLAR = registerBlock("terracotta_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA)), ModItemGroup.Pillars);
        public static final Block COAL_BLOCK_PILLAR = registerBlock("coal_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block PACKED_ICE_PILLAR = registerBlock("packed_ice_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PACKED_ICE)), ModItemGroup.Pillars);
        public static final Block RED_SANDSTONE_PILLAR = registerBlock("red_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block CHISELED_RED_SANDSTONE_PILLAR = registerBlock("chiseled_red_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_RED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block CUT_RED_SANDSTONE_PILLAR = registerBlock("cut_red_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CUT_RED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block SMOOTH_STONE_PILLAR = registerBlock("smooth_stone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_STONE)), ModItemGroup.Pillars);
        public static final Block SMOOTH_SANDSTONE_PILLAR = registerBlock("smooth_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block SMOOTH_QUARTZ_PILLAR = registerBlock("smooth_quartz_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ)), ModItemGroup.Pillars);
        public static final Block SMOOTH_RED_SANDSTONE_PILLAR = registerBlock("smooth_red_sandstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_RED_SANDSTONE)), ModItemGroup.Pillars);
        public static final Block PURPUR_BLOCK_PILLAR = registerBlock("purpur_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.PURPUR_BLOCK)), ModItemGroup.Pillars);
        public static final Block END_STONE_BRICKS_PILLAR = registerBlock("end_stone_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block NETHER_WART_BLOCK_PILLAR = registerBlock("nether_wart_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK)), ModItemGroup.Pillars);
        public static final Block RED_NETHER_BRICKS_PILLAR = registerBlock("red_nether_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)), ModItemGroup.Pillars);
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
        public static final Block DRIED_KELP_BLOCK_PILLAR = registerBlock("dried_kelp_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DRIED_KELP_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_TUBE_CORAL_BLOCK_PILLAR = registerBlock("dead_tube_coral_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_TUBE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_BRAIN_CORAL_BLOCK_PILLAR = registerBlock("dead_brain_coral_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BRAIN_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_BUBBLE_CORAL_BLOCK_PILLAR = registerBlock("dead_bubble_coral_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUBBLE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_FIRE_CORAL_BLOCK_PILLAR = registerBlock("dead_fire_coral_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_FIRE_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block DEAD_HORN_CORAL_BLOCK_PILLAR = registerBlock("dead_horn_coral_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEAD_HORN_CORAL_BLOCK)), ModItemGroup.Pillars);
        public static final Block WARPED_WART_BLOCK_PILLAR = registerBlock("warped_wart_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK)), ModItemGroup.Pillars);
        public static final Block SHROOMLIGHT_PILLAR = registerBlock("shroomlight_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SHROOMLIGHT)), ModItemGroup.Pillars);
        public static final Block CRIMSON_PLANKS_PILLAR = registerBlock("crimson_planks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)), ModItemGroup.Pillars);
        public static final Block WARPED_PLANKS_PILLAR = registerBlock("warped_planks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)), ModItemGroup.Pillars);
        public static final Block HONEYCOMB_BLOCK_PILLAR = registerBlock("honeycomb_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK)), ModItemGroup.Pillars);
        public static final Block NETHERITE_BLOCK_PILLAR = registerBlock("netherite_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)), ModItemGroup.Pillars);
        public static final Block ANCIENT_DEBRIS_PILLAR = registerBlock("ancient_debris_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)), ModItemGroup.Pillars);
        public static final Block LODESTONE_PILLAR = registerBlock("lodestone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.LODESTONE)), ModItemGroup.Pillars);
        public static final Block BLACKSTONE_PILLAR = registerBlock("blackstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.BLACKSTONE)), ModItemGroup.Pillars);
        public static final Block POLISHED_BLACKSTONE_PILLAR = registerBlock("polished_blackstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE)), ModItemGroup.Pillars);
        public static final Block POLISHED_BLACKSTONE_BRICKS_PILLAR = registerBlock("polished_blackstone_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR = registerBlock("cracked_polished_blackstone_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CHISELED_POLISHED_BLACKSTONE_PILLAR = registerBlock("chiseled_polished_blackstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_POLISHED_BLACKSTONE)), ModItemGroup.Pillars);
        public static final Block GILDED_BLACKSTONE_PILLAR = registerBlock("gilded_blackstone_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.GILDED_BLACKSTONE)), ModItemGroup.Pillars);
        public static final Block CHISELED_NETHER_BRICKS_PILLAR = registerBlock("chiseled_nether_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_NETHER_BRICKS)), ModItemGroup.Pillars);
        public static final Block CRACKED_NETHER_BRICKS_PILLAR = registerBlock("cracked_nether_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_NETHER_BRICKS)), ModItemGroup.Pillars);
        public static final Block QUARTZ_BRICKS_PILLAR = registerBlock("quartz_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS)), ModItemGroup.Pillars);
        public static final Block TUFF_PILLAR = registerBlock("tuff_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.TUFF)), ModItemGroup.Pillars);
        public static final Block CALCITE_PILLAR = registerBlock("calcite_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CALCITE)), ModItemGroup.Pillars);
        public static final Block WAXED_COPPER_BLOCK_PILLAR = registerBlock("waxed_copper_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_COPPER_BLOCK)), ModItemGroup.Pillars);
        public static final Block WAXED_WEATHERED_COPPER_PILLAR = registerBlock("waxed_weathered_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_WEATHERED_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_EXPOSED_COPPER_PILLAR = registerBlock("waxed_exposed_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_EXPOSED_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_OXIDIZED_COPPER_PILLAR = registerBlock("waxed_oxidized_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_OXIDIZED_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_OXIDIZED_CUT_COPPER_PILLAR = registerBlock("waxed_oxidized_cut_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_OXIDIZED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_WEATHERED_CUT_COPPER_PILLAR = registerBlock("waxed_weathered_cut_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_WEATHERED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_EXPOSED_CUT_COPPER_PILLAR = registerBlock("waxed_exposed_cut_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_EXPOSED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block WAXED_CUT_COPPER_PILLAR = registerBlock("waxed_cut_copper_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.WAXED_CUT_COPPER)), ModItemGroup.Pillars);
        public static final Block DRIPSTONE_BLOCK_PILLAR = registerBlock("dripstone_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK)), ModItemGroup.Pillars);
        public static final Block COBBLED_DEEPSLATE_PILLAR = registerBlock("cobbled_deepslate_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE)), ModItemGroup.Pillars);
        public static final Block POLISHED_DEEPSLATE_PILLAR = registerBlock("polished_deepslate_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE)), ModItemGroup.Pillars);
        public static final Block DEEPSLATE_TILES_PILLAR = registerBlock("deepslate_tiles_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_TILES)), ModItemGroup.Pillars);
        public static final Block DEEPSLATE_BRICKS_PILLAR = registerBlock("deepslate_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CHISELED_DEEPSLATE_PILLAR = registerBlock("chiseled_deepslate_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHISELED_DEEPSLATE)), ModItemGroup.Pillars);
        public static final Block CRACKED_DEEPSLATE_BRICKS_PILLAR = registerBlock("cracked_deepslate_bricks_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_DEEPSLATE_BRICKS)), ModItemGroup.Pillars);
        public static final Block CRACKED_DEEPSLATE_TILES_PILLAR = registerBlock("cracked_deepslate_tiles_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRACKED_DEEPSLATE_TILES)), ModItemGroup.Pillars);
        public static final Block SMOOTH_BASALT_PILLAR = registerBlock("smooth_basalt_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.SMOOTH_BASALT)), ModItemGroup.Pillars);
        public static final Block RAW_IRON_BLOCK_PILLAR = registerBlock("raw_iron_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)), ModItemGroup.Pillars);
        public static final Block RAW_COPPER_BLOCK_PILLAR = registerBlock("raw_copper_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RAW_COPPER_BLOCK)), ModItemGroup.Pillars);
        public static final Block RAW_GOLD_BLOCK_PILLAR = registerBlock("raw_gold_block_pillar",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK)), ModItemGroup.Pillars);
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
