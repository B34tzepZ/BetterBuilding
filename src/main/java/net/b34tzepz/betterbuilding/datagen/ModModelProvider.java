package net.b34tzepz.betterbuilding.datagen;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.block.custom.CornerBlock;
import net.b34tzepz.betterbuilding.block.custom.OxidizableBulbPillarBlock;
import net.b34tzepz.betterbuilding.block.custom.PillarBlock;
import net.b34tzepz.betterbuilding.block.custom.SideBlock;
import net.b34tzepz.betterbuilding.block.enums.CornerDirection;
import net.b34tzepz.betterbuilding.block.enums.CornerShape;
import net.b34tzepz.betterbuilding.block.enums.SideType;
import net.b34tzepz.betterbuilding.item.ModItems;
import net.b34tzepz.betterbuilding.util.ModTags;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public static final Model SIDE = new Model(Optional.of(Identifier.of(BetterBuilding.MOD_ID, "block/side")), Optional.empty(), TextureKey.SIDE, TextureKey.TOP, TextureKey.BOTTOM); //Model mit parent und keys on textures
    public static final Model CORNER = new Model(Optional.of(Identifier.of(BetterBuilding.MOD_ID, "block/corner")), Optional.empty(), TextureKey.SIDE, TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model CORNER_INNER = new Model(Optional.of(Identifier.of(BetterBuilding.MOD_ID, "block/corner_inner")), Optional.empty(), TextureKey.SIDE, TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model CORNER_OUTER_PREV = new Model(Optional.of(Identifier.of(BetterBuilding.MOD_ID, "block/corner_outer_prev")), Optional.empty(), TextureKey.SIDE, TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model CORNER_OUTER_NEXT = new Model(Optional.of(Identifier.of(BetterBuilding.MOD_ID, "block/corner_outer_next")), Optional.empty(), TextureKey.SIDE, TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model CORNER_OUTER_DOUBLE = new Model(Optional.of(Identifier.of(BetterBuilding.MOD_ID, "block/corner_outer_double")), Optional.empty(), TextureKey.SIDE, TextureKey.TOP, TextureKey.BOTTOM);
    public static final Model PILLAR = new Model(Optional.of(Identifier.of(BetterBuilding.MOD_ID, "block/pillar_column")), Optional.empty(), TextureKey.SIDE, TextureKey.END);
    public static final Model CHAIR = new Model(Optional.of(Identifier.of(BetterBuilding.MOD_ID, "block/chair")), Optional.empty(), TextureKey.ALL);

    //TextureMap hat bereits viele Optionen sonst selbst definieren
    private TextureMap baseAll(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getId(baseBlock))
                .put(TextureKey.TOP, TextureMap.getId(baseBlock))
                .put(TextureKey.BOTTOM, TextureMap.getId(baseBlock))
                .put(TextureKey.END, TextureMap.getId(baseBlock));
    }

    private TextureMap baseTopBottom(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getId(baseBlock))
                .put(TextureKey.TOP, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(baseBlock, "_bottom"));
    }

    private TextureMap baseTop(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getId(baseBlock))
                .put(TextureKey.TOP, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_top"));
    }

    private TextureMap sideTop(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(baseBlock, "_side"))
                .put(TextureKey.TOP, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_top"));
    }

    private TextureMap topAll(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.TOP, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_top"));
    }

    private TextureMap bottomAll(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(baseBlock, "_bottom"))
                .put(TextureKey.TOP, TextureMap.getSubId(baseBlock, "_bottom"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(baseBlock, "_bottom"))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_bottom"));
    }

    private TextureMap cutTop(Block baseBlock) {
        String path = TextureMap.getId(baseBlock).getPath().replace("block/", "block/cut_");
        return new TextureMap()
                .put(TextureKey.SIDE, Identifier.ofVanilla(path))
                .put(TextureKey.TOP, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_top"));
    }

    private TextureMap columnSide(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(baseBlock, "_side"))
                .put(TextureKey.END, TextureMap.getId(baseBlock));
    }

    private TextureMap chiseledTop(Block baseBlock) {
        String path = TextureMap.getId(baseBlock).getPath().replace("block/", "block/chiseled_");
        return new TextureMap()
                .put(TextureKey.SIDE, Identifier.ofVanilla(path))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_top"));
    }

    private TextureMap noBlock(Block baseBlock) {
        String path = TextureMap.getId(baseBlock).getPath().replace("_block", "");
        return new TextureMap()
                .put(TextureKey.SIDE, Identifier.ofVanilla(path))
                .put(TextureKey.END, Identifier.ofVanilla(path));
    }

    private TextureMap bookshelf() {
        return new TextureMap()
                .put(TextureKey.SIDE, Identifier.ofVanilla("block/bookshelf"))
                .put(TextureKey.END, Identifier.ofVanilla("block/oak_planks"));
    }

    private TextureMap lit(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(baseBlock, "_lit"))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_lit"));
    }

    private TextureMap powered(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(baseBlock, "_powered"))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_powered"));
    }

    private TextureMap litPowered(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(baseBlock, "_lit_powered"))
                .put(TextureKey.END, TextureMap.getSubId(baseBlock, "_lit_powered"));
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_SPRUCE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_BIRCH_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_JUNGLE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_ACACIA_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_DARK_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_MANGROVE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_CHERRY_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_PALE_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_BAMBOO_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_BAMBOO_MOSAIC);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_CRIMSON_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_WARPED_PLANKS);

        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.OAK_SIDE, baseAll(Blocks.OAK_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SPRUCE_SIDE, baseAll(Blocks.SPRUCE_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.BIRCH_SIDE, baseAll(Blocks.BIRCH_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.JUNGLE_SIDE, baseAll(Blocks.JUNGLE_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.ACACIA_SIDE, baseAll(Blocks.ACACIA_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DARK_OAK_SIDE, baseAll(Blocks.DARK_OAK_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.MANGROVE_SIDE, baseAll(Blocks.MANGROVE_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CHERRY_SIDE, baseAll(Blocks.CHERRY_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.PALE_OAK_SIDE, baseAll(Blocks.PALE_OAK_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.BAMBOO_SIDE, baseAll(Blocks.BAMBOO_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.BAMBOO_MOSAIC_SIDE, baseAll(Blocks.BAMBOO_MOSAIC));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CRIMSON_SIDE, baseAll(Blocks.CRIMSON_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WARPED_SIDE, baseAll(Blocks.WARPED_PLANKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.STONE_SIDE, baseAll(Blocks.STONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.COBBLESTONE_SIDE, baseAll(Blocks.COBBLESTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.MOSSY_COBBLESTONE_SIDE, baseAll(Blocks.MOSSY_COBBLESTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SMOOTH_STONE_SIDE, baseAll(Blocks.SMOOTH_STONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.STONE_BRICK_SIDE, baseAll(Blocks.STONE_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.MOSSY_STONE_BRICK_SIDE, baseAll(Blocks.MOSSY_STONE_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.GRANITE_SIDE, baseAll(Blocks.GRANITE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_GRANITE_SIDE, baseAll(Blocks.POLISHED_GRANITE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DIORITE_SIDE, baseAll(Blocks.DIORITE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_DIORITE_SIDE, baseAll(Blocks.POLISHED_DIORITE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.ANDESITE_SIDE, baseAll(Blocks.ANDESITE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_ANDESITE_SIDE, baseAll(Blocks.POLISHED_ANDESITE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.COBBLED_DEEPSLATE_SIDE, baseAll(Blocks.COBBLED_DEEPSLATE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_DEEPSLATE_SIDE, baseAll(Blocks.POLISHED_DEEPSLATE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DEEPSLATE_BRICK_SIDE, baseAll(Blocks.DEEPSLATE_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DEEPSLATE_TILE_SIDE, baseAll(Blocks.DEEPSLATE_TILES));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.TUFF_SIDE, baseAll(Blocks.TUFF));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_TUFF_SIDE, baseAll(Blocks.POLISHED_TUFF));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.TUFF_BRICK_SIDE, baseAll(Blocks.TUFF_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.BRICK_SIDE, baseAll(Blocks.BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.MUD_BRICK_SIDE, baseAll(Blocks.MUD_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.RESIN_BRICK_SIDE, baseAll(Blocks.RESIN_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SANDSTONE_SIDE, baseTopBottom(Blocks.SANDSTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SMOOTH_SANDSTONE_SIDE, topAll(Blocks.SANDSTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CUT_SANDSTONE_SIDE, cutTop(Blocks.SANDSTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.RED_SANDSTONE_SIDE, baseTopBottom(Blocks.RED_SANDSTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SMOOTH_RED_SANDSTONE_SIDE, topAll(Blocks.RED_SANDSTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CUT_RED_SANDSTONE_SIDE, cutTop(Blocks.RED_SANDSTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.PRISMARINE_SIDE, baseAll(Blocks.PRISMARINE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.PRISMARINE_BRICK_SIDE, baseAll(Blocks.PRISMARINE_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DARK_PRISMARINE_SIDE, baseAll(Blocks.DARK_PRISMARINE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.NETHER_BRICK_SIDE, baseAll(Blocks.NETHER_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.RED_NETHER_BRICK_SIDE, baseAll(Blocks.RED_NETHER_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.BLACKSTONE_SIDE, baseTop(Blocks.BLACKSTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_BLACKSTONE_SIDE, baseAll(Blocks.POLISHED_BLACKSTONE));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_BLACKSTONE_BRICK_SIDE, baseAll(Blocks.POLISHED_BLACKSTONE_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.END_STONE_BRICK_SIDE, baseAll(Blocks.END_STONE_BRICKS));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.PURPUR_SIDE, baseAll(Blocks.PURPUR_BLOCK));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.QUARTZ_SIDE, sideTop(Blocks.QUARTZ_BLOCK));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SMOOTH_QUARTZ_SIDE, bottomAll(Blocks.QUARTZ_BLOCK));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CUT_COPPER_SIDE, baseAll(Blocks.CUT_COPPER));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE, baseAll(Blocks.EXPOSED_CUT_COPPER));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE, baseAll(Blocks.WEATHERED_CUT_COPPER));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE, baseAll(Blocks.OXIDIZED_CUT_COPPER));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WAXED_CUT_COPPER_SIDE, baseAll(Blocks.CUT_COPPER));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WAXED_EXPOSED_CUT_COPPER_SIDE, baseAll(Blocks.EXPOSED_CUT_COPPER));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WAXED_WEATHERED_CUT_COPPER_SIDE, baseAll(Blocks.WEATHERED_CUT_COPPER));
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WAXED_OXIDIZED_CUT_COPPER_SIDE, baseAll(Blocks.OXIDIZED_CUT_COPPER));

        BlockStateModelGenerator.BlockTexturePool blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.SMOOTH_STONE);
        blockTexturePool.stairs(ModBlocks.SMOOTH_STONE_STAIRS);
        blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CUT_SANDSTONE);
        blockTexturePool.stairs(ModBlocks.CUT_SANDSTONE_STAIRS);
        blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CUT_RED_SANDSTONE);
        blockTexturePool.stairs(ModBlocks.CUT_RED_SANDSTONE_STAIRS);

        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.OAK_CORNER, baseAll(Blocks.OAK_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.SPRUCE_CORNER, baseAll(Blocks.SPRUCE_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.BIRCH_CORNER, baseAll(Blocks.BIRCH_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.JUNGLE_CORNER, baseAll(Blocks.JUNGLE_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.ACACIA_CORNER, baseAll(Blocks.ACACIA_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.DARK_OAK_CORNER, baseAll(Blocks.DARK_OAK_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.MANGROVE_CORNER, baseAll(Blocks.MANGROVE_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.CHERRY_CORNER, baseAll(Blocks.CHERRY_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.PALE_OAK_CORNER, baseAll(Blocks.PALE_OAK_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.BAMBOO_CORNER, baseAll(Blocks.BAMBOO_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.BAMBOO_MOSAIC_CORNER, baseAll(Blocks.BAMBOO_MOSAIC));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.CRIMSON_CORNER, baseAll(Blocks.CRIMSON_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.WARPED_CORNER, baseAll(Blocks.WARPED_PLANKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.STONE_CORNER, baseAll(Blocks.STONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.COBBLESTONE_CORNER, baseAll(Blocks.COBBLESTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.MOSSY_COBBLESTONE_CORNER, baseAll(Blocks.MOSSY_COBBLESTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.SMOOTH_STONE_CORNER, baseAll(Blocks.SMOOTH_STONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.STONE_BRICK_CORNER, baseAll(Blocks.STONE_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.MOSSY_STONE_BRICK_CORNER, baseAll(Blocks.MOSSY_STONE_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.GRANITE_CORNER, baseAll(Blocks.GRANITE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.POLISHED_GRANITE_CORNER, baseAll(Blocks.POLISHED_GRANITE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.DIORITE_CORNER, baseAll(Blocks.DIORITE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.POLISHED_DIORITE_CORNER, baseAll(Blocks.POLISHED_DIORITE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.ANDESITE_CORNER, baseAll(Blocks.ANDESITE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.POLISHED_ANDESITE_CORNER, baseAll(Blocks.POLISHED_ANDESITE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.COBBLED_DEEPSLATE_CORNER, baseAll(Blocks.COBBLED_DEEPSLATE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.POLISHED_DEEPSLATE_CORNER, baseAll(Blocks.POLISHED_DEEPSLATE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.DEEPSLATE_BRICK_CORNER, baseAll(Blocks.DEEPSLATE_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.DEEPSLATE_TILE_CORNER, baseAll(Blocks.DEEPSLATE_TILES));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.TUFF_CORNER, baseAll(Blocks.TUFF));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.POLISHED_TUFF_CORNER, baseAll(Blocks.POLISHED_TUFF));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.TUFF_BRICK_CORNER, baseAll(Blocks.TUFF_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.BRICK_CORNER, baseAll(Blocks.BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.MUD_BRICK_CORNER, baseAll(Blocks.MUD_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.RESIN_BRICK_CORNER, baseAll(Blocks.RESIN_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.SANDSTONE_CORNER, baseTopBottom(Blocks.SANDSTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.SMOOTH_SANDSTONE_CORNER, topAll(Blocks.SANDSTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.CUT_SANDSTONE_CORNER, cutTop(Blocks.SANDSTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.RED_SANDSTONE_CORNER, baseTopBottom(Blocks.RED_SANDSTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.SMOOTH_RED_SANDSTONE_CORNER, topAll(Blocks.RED_SANDSTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.CUT_RED_SANDSTONE_CORNER, cutTop(Blocks.RED_SANDSTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.PRISMARINE_CORNER, baseAll(Blocks.PRISMARINE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.PRISMARINE_BRICK_CORNER, baseAll(Blocks.PRISMARINE_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.DARK_PRISMARINE_CORNER, baseAll(Blocks.DARK_PRISMARINE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.NETHER_BRICK_CORNER, baseAll(Blocks.NETHER_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.RED_NETHER_BRICK_CORNER, baseAll(Blocks.RED_NETHER_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.BLACKSTONE_CORNER, baseTop(Blocks.BLACKSTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.POLISHED_BLACKSTONE_CORNER, baseAll(Blocks.POLISHED_BLACKSTONE));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.POLISHED_BLACKSTONE_BRICK_CORNER, baseAll(Blocks.POLISHED_BLACKSTONE_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.END_STONE_BRICK_CORNER, baseAll(Blocks.END_STONE_BRICKS));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.PURPUR_CORNER, baseAll(Blocks.PURPUR_BLOCK));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.QUARTZ_CORNER, sideTop(Blocks.QUARTZ_BLOCK));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.SMOOTH_QUARTZ_CORNER, bottomAll(Blocks.QUARTZ_BLOCK));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.CUT_COPPER_CORNER, baseAll(Blocks.CUT_COPPER));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER, baseAll(Blocks.EXPOSED_CUT_COPPER));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER, baseAll(Blocks.WEATHERED_CUT_COPPER));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER, baseAll(Blocks.OXIDIZED_CUT_COPPER));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.WAXED_CUT_COPPER_CORNER, baseAll(Blocks.CUT_COPPER));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.WAXED_EXPOSED_CUT_COPPER_CORNER, baseAll(Blocks.EXPOSED_CUT_COPPER));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.WAXED_WEATHERED_CUT_COPPER_CORNER, baseAll(Blocks.WEATHERED_CUT_COPPER));
        registerCornerBlock(blockStateModelGenerator, ModBlocks.Corners.WAXED_OXIDIZED_CUT_COPPER_CORNER, baseAll(Blocks.OXIDIZED_CUT_COPPER));

        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OAK_LOG_PILLAR, baseTop(Blocks.OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OAK_WOOD_PILLAR, baseAll(Blocks.OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_OAK_LOG_PILLAR, baseTop(Blocks.STRIPPED_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_OAK_WOOD_PILLAR, baseAll(Blocks.STRIPPED_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OAK_PLANK_PILLAR, baseAll(Blocks.OAK_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SPRUCE_LOG_PILLAR, baseTop(Blocks.SPRUCE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SPRUCE_WOOD_PILLAR, baseAll(Blocks.SPRUCE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_SPRUCE_LOG_PILLAR, baseTop(Blocks.STRIPPED_SPRUCE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_SPRUCE_WOOD_PILLAR, baseAll(Blocks.STRIPPED_SPRUCE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SPRUCE_PLANK_PILLAR, baseAll(Blocks.SPRUCE_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BIRCH_LOG_PILLAR, baseTop(Blocks.BIRCH_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BIRCH_WOOD_PILLAR, baseAll(Blocks.BIRCH_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_BIRCH_LOG_PILLAR, baseTop(Blocks.STRIPPED_BIRCH_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_BIRCH_WOOD_PILLAR, baseAll(Blocks.STRIPPED_BIRCH_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BIRCH_PLANK_PILLAR, baseAll(Blocks.BIRCH_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.JUNGLE_LOG_PILLAR, baseTop(Blocks.JUNGLE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.JUNGLE_WOOD_PILLAR, baseAll(Blocks.JUNGLE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_JUNGLE_LOG_PILLAR, baseTop(Blocks.STRIPPED_JUNGLE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_JUNGLE_WOOD_PILLAR, baseAll(Blocks.STRIPPED_JUNGLE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.JUNGLE_PLANK_PILLAR, baseAll(Blocks.JUNGLE_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ACACIA_LOG_PILLAR, baseTop(Blocks.ACACIA_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ACACIA_WOOD_PILLAR, baseAll(Blocks.ACACIA_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_ACACIA_LOG_PILLAR, baseTop(Blocks.STRIPPED_ACACIA_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_ACACIA_WOOD_PILLAR, baseAll(Blocks.STRIPPED_ACACIA_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ACACIA_PLANK_PILLAR, baseAll(Blocks.ACACIA_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DARK_OAK_LOG_PILLAR, baseTop(Blocks.DARK_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DARK_OAK_WOOD_PILLAR, baseAll(Blocks.DARK_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_DARK_OAK_LOG_PILLAR, baseTop(Blocks.STRIPPED_DARK_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_DARK_OAK_WOOD_PILLAR, baseAll(Blocks.STRIPPED_DARK_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DARK_OAK_PLANK_PILLAR, baseAll(Blocks.DARK_OAK_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MANGROVE_LOG_PILLAR, baseTop(Blocks.MANGROVE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MANGROVE_WOOD_PILLAR, baseAll(Blocks.MANGROVE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_MANGROVE_LOG_PILLAR, baseTop(Blocks.STRIPPED_MANGROVE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_MANGROVE_WOOD_PILLAR, baseAll(Blocks.STRIPPED_MANGROVE_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MANGROVE_PLANK_PILLAR, baseAll(Blocks.MANGROVE_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHERRY_LOG_PILLAR, baseTop(Blocks.CHERRY_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHERRY_WOOD_PILLAR, baseAll(Blocks.CHERRY_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_CHERRY_LOG_PILLAR, baseTop(Blocks.STRIPPED_CHERRY_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_CHERRY_WOOD_PILLAR, baseAll(Blocks.STRIPPED_CHERRY_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHERRY_PLANK_PILLAR, baseAll(Blocks.CHERRY_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PALE_OAK_LOG_PILLAR, baseTop(Blocks.PALE_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PALE_OAK_WOOD_PILLAR, baseAll(Blocks.PALE_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_PALE_OAK_LOG_PILLAR, baseTop(Blocks.STRIPPED_PALE_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_PALE_OAK_WOOD_PILLAR, baseAll(Blocks.STRIPPED_PALE_OAK_LOG));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PALE_OAK_PLANK_PILLAR, baseAll(Blocks.PALE_OAK_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BAMBOO_PILLAR, baseTop(Blocks.BAMBOO_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_BAMBOO_PILLAR, baseTop(Blocks.STRIPPED_BAMBOO_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BAMBOO_PLANK_PILLAR, baseAll(Blocks.BAMBOO_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BAMBOO_MOSAIC_PILLAR, baseAll(Blocks.BAMBOO_MOSAIC));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRIMSON_STEM_PILLAR, baseTop(Blocks.CRIMSON_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRIMSON_HYPHAE_PILLAR, baseAll(Blocks.CRIMSON_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_CRIMSON_STEM_PILLAR, baseTop(Blocks.STRIPPED_CRIMSON_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_CRIMSON_HYPHAE_PILLAR, baseAll(Blocks.STRIPPED_CRIMSON_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRIMSON_PLANK_PILLAR, baseAll(Blocks.CRIMSON_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WARPED_STEM_PILLAR, baseTop(Blocks.WARPED_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WARPED_HYPHAE_PILLAR, baseAll(Blocks.WARPED_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_WARPED_STEM_PILLAR, baseTop(Blocks.STRIPPED_WARPED_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STRIPPED_WARPED_HYPHAE_PILLAR, baseAll(Blocks.STRIPPED_WARPED_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WARPED_PLANK_PILLAR, baseAll(Blocks.WARPED_PLANKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STONE_PILLAR, baseAll(Blocks.STONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.COBBLESTONE_PILLAR, baseAll(Blocks.COBBLESTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MOSSY_COBBLESTONE_PILLAR, baseAll(Blocks.MOSSY_COBBLESTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SMOOTH_STONE_PILLAR, baseAll(Blocks.SMOOTH_STONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.STONE_BRICK_PILLAR, baseAll(Blocks.STONE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRACKED_STONE_BRICK_PILLAR, baseAll(Blocks.CRACKED_STONE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_STONE_BRICK_PILLAR, baseAll(Blocks.CHISELED_STONE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MOSSY_STONE_BRICK_PILLAR, baseAll(Blocks.MOSSY_STONE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GRANITE_PILLAR, baseAll(Blocks.GRANITE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.POLISHED_GRANITE_PILLAR, baseAll(Blocks.POLISHED_GRANITE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DIORITE_PILLAR, baseAll(Blocks.DIORITE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.POLISHED_DIORITE_PILLAR, baseAll(Blocks.POLISHED_DIORITE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ANDESITE_PILLAR, baseAll(Blocks.ANDESITE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.POLISHED_ANDESITE_PILLAR, baseAll(Blocks.POLISHED_ANDESITE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DEEPSLATE_PILLAR, baseTop(Blocks.DEEPSLATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.COBBLED_DEEPSLATE_PILLAR, baseAll(Blocks.COBBLED_DEEPSLATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_DEEPSLATE_PILLAR, baseAll(Blocks.CHISELED_DEEPSLATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.POLISHED_DEEPSLATE_PILLAR, baseAll(Blocks.POLISHED_DEEPSLATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DEEPSLATE_BRICK_PILLAR, baseAll(Blocks.DEEPSLATE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRACKED_DEEPSLATE_BRICK_PILLAR, baseAll(Blocks.CRACKED_DEEPSLATE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DEEPSLATE_TILE_PILLAR, baseAll(Blocks.DEEPSLATE_TILES));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRACKED_DEEPSLATE_TILE_PILLAR, baseAll(Blocks.CRACKED_DEEPSLATE_TILES));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.REINFORCED_DEEPSLATE_PILLAR, sideTop(Blocks.REINFORCED_DEEPSLATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.TUFF_PILLAR, baseAll(Blocks.TUFF));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_TUFF_PILLAR, baseTop(Blocks.CHISELED_TUFF));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.POLISHED_TUFF_PILLAR, baseAll(Blocks.POLISHED_TUFF));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.TUFF_BRICK_PILLAR, baseAll(Blocks.TUFF_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_TUFF_BRICK_PILLAR, baseTop(Blocks.CHISELED_TUFF_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BRICK_PILLAR, baseAll(Blocks.BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PACKED_MUD_PILLAR, baseAll(Blocks.PACKED_MUD));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MUD_BRICK_PILLAR, baseAll(Blocks.MUD_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RESIN_BRICK_PILLAR, baseAll(Blocks.RESIN_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_RESIN_BRICK_PILLAR, baseAll(Blocks.CHISELED_RESIN_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SANDSTONE_PILLAR, baseTop(Blocks.SANDSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_SANDSTONE_PILLAR, chiseledTop(Blocks.SANDSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SMOOTH_SANDSTONE_PILLAR, topAll(Blocks.SANDSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CUT_SANDSTONE_PILLAR, cutTop(Blocks.SANDSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RED_SANDSTONE_PILLAR, baseTop(Blocks.RED_SANDSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_RED_SANDSTONE_PILLAR, chiseledTop(Blocks.RED_SANDSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SMOOTH_RED_SANDSTONE_PILLAR, topAll(Blocks.RED_SANDSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CUT_RED_SANDSTONE_PILLAR, cutTop(Blocks.RED_SANDSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SEA_LANTERN_PILLAR, baseAll(Blocks.SEA_LANTERN));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PRISMARINE_PILLAR, baseAll(Blocks.PRISMARINE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PRISMARINE_BRICK_PILLAR, baseAll(Blocks.PRISMARINE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DARK_PRISMARINE_PILLAR, baseAll(Blocks.DARK_PRISMARINE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.NETHERRACK_PILLAR, baseAll(Blocks.NETHERRACK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.NETHER_BRICK_PILLAR, baseAll(Blocks.NETHER_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRACKED_NETHER_BRICK_PILLAR, baseAll(Blocks.CRACKED_NETHER_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_NETHER_BRICK_PILLAR, baseAll(Blocks.CHISELED_NETHER_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RED_NETHER_BRICK_PILLAR, baseAll(Blocks.RED_NETHER_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BASALT_PILLAR, sideTop(Blocks.BASALT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SMOOTH_BASALT_PILLAR, baseAll(Blocks.SMOOTH_BASALT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.POLISHED_BASALT_PILLAR, sideTop(Blocks.POLISHED_BASALT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLACKSTONE_PILLAR, baseTop(Blocks.BLACKSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GILDED_BLACKSTONE_PILLAR, baseAll(Blocks.GILDED_BLACKSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_POLISHED_BLACKSTONE_PILLAR, baseAll(Blocks.CHISELED_POLISHED_BLACKSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.POLISHED_BLACKSTONE_PILLAR, baseAll(Blocks.POLISHED_BLACKSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.POLISHED_BLACKSTONE_BRICK_PILLAR, baseAll(Blocks.POLISHED_BLACKSTONE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRACKED_POLISHED_BLACKSTONE_BRICK_PILLAR, baseAll(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.END_STONE_PILLAR, baseAll(Blocks.END_STONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.END_STONE_BRICK_PILLAR, baseAll(Blocks.END_STONE_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PURPUR_PILLAR, baseAll(Blocks.PURPUR_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PURPUR_PILLAR_PILLAR, baseTop(Blocks.PURPUR_PILLAR));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.COAL_PILLAR, baseAll(Blocks.COAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.IRON_PILLAR, baseAll(Blocks.IRON_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GOLD_PILLAR, baseAll(Blocks.GOLD_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.REDSTONE_PILLAR, baseAll(Blocks.REDSTONE_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.EMERALD_PILLAR, baseAll(Blocks.EMERALD_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LAPIS_PILLAR, baseAll(Blocks.LAPIS_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DIAMOND_PILLAR, baseAll(Blocks.DIAMOND_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.NETHERITE_PILLAR, baseAll(Blocks.NETHERITE_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.QUARTZ_PILLAR, sideTop(Blocks.QUARTZ_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_QUARTZ_PILLAR, baseTop(Blocks.CHISELED_QUARTZ_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.QUARTZ_BRICK_PILLAR, baseAll(Blocks.QUARTZ_BRICKS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.QUARTZ_PILLAR_PILLAR, baseTop(Blocks.QUARTZ_PILLAR));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SMOOTH_QUARTZ_PILLAR, bottomAll(Blocks.QUARTZ_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.AMETHYST_PILLAR, baseAll(Blocks.AMETHYST_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.COPPER_PILLAR, baseAll(Blocks.COPPER_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_COPPER_PILLAR, baseAll(Blocks.CHISELED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.COPPER_GRATE_PILLAR, baseAll(Blocks.COPPER_GRATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CUT_COPPER_PILLAR, baseAll(Blocks.CUT_COPPER));
        registerCopperBulbPillar(blockStateModelGenerator, ModBlocks.Pillars.COPPER_BULB_PILLAR, Blocks.COPPER_BULB);
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.EXPOSED_COPPER_PILLAR, baseAll(Blocks.EXPOSED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.EXPOSED_CHISELED_COPPER_PILLAR, baseAll(Blocks.EXPOSED_CHISELED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.EXPOSED_COPPER_GRATE_PILLAR, baseAll(Blocks.EXPOSED_COPPER_GRATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.EXPOSED_CUT_COPPER_PILLAR, baseAll(Blocks.EXPOSED_CUT_COPPER));
        registerCopperBulbPillar(blockStateModelGenerator, ModBlocks.Pillars.EXPOSED_COPPER_BULB_PILLAR, Blocks.EXPOSED_COPPER_BULB);
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WEATHERED_COPPER_PILLAR, baseAll(Blocks.WEATHERED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WEATHERED_CHISELED_COPPER_PILLAR, baseAll(Blocks.WEATHERED_CHISELED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WEATHERED_COPPER_GRATE_PILLAR, baseAll(Blocks.WEATHERED_COPPER_GRATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WEATHERED_CUT_COPPER_PILLAR, baseAll(Blocks.WEATHERED_CUT_COPPER));
        registerCopperBulbPillar(blockStateModelGenerator, ModBlocks.Pillars.WEATHERED_COPPER_BULB_PILLAR, Blocks.WEATHERED_COPPER_BULB);
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OXIDIZED_COPPER_PILLAR, baseAll(Blocks.OXIDIZED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OXIDIZED_CHISELED_COPPER_PILLAR, baseAll(Blocks.OXIDIZED_CHISELED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OXIDIZED_COPPER_GRATE_PILLAR, baseAll(Blocks.OXIDIZED_COPPER_GRATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OXIDIZED_CUT_COPPER_PILLAR, baseAll(Blocks.OXIDIZED_CUT_COPPER));
        registerCopperBulbPillar(blockStateModelGenerator, ModBlocks.Pillars.OXIDIZED_COPPER_BULB_PILLAR, Blocks.OXIDIZED_COPPER_BULB);
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_COPPER_PILLAR, baseAll(Blocks.COPPER_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_CHISELED_COPPER_PILLAR, baseAll(Blocks.CHISELED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_COPPER_GRATE_PILLAR, baseAll(Blocks.COPPER_GRATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_CUT_COPPER_PILLAR, baseAll(Blocks.CUT_COPPER));
        registerCopperBulbPillar(blockStateModelGenerator, ModBlocks.Pillars.WAXED_COPPER_BULB_PILLAR, Blocks.COPPER_BULB);
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_EXPOSED_COPPER_PILLAR, baseAll(Blocks.EXPOSED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_EXPOSED_CHISELED_COPPER_PILLAR, baseAll(Blocks.EXPOSED_CHISELED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_EXPOSED_COPPER_GRATE_PILLAR, baseAll(Blocks.EXPOSED_COPPER_GRATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_EXPOSED_CUT_COPPER_PILLAR, baseAll(Blocks.EXPOSED_CUT_COPPER));
        registerCopperBulbPillar(blockStateModelGenerator, ModBlocks.Pillars.WAXED_EXPOSED_COPPER_BULB_PILLAR, Blocks.EXPOSED_COPPER_BULB);
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_WEATHERED_COPPER_PILLAR, baseAll(Blocks.WEATHERED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_WEATHERED_CHISELED_COPPER_PILLAR, baseAll(Blocks.WEATHERED_CHISELED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_WEATHERED_COPPER_GRATE_PILLAR, baseAll(Blocks.WEATHERED_COPPER_GRATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_WEATHERED_CUT_COPPER_PILLAR, baseAll(Blocks.WEATHERED_CUT_COPPER));
        registerCopperBulbPillar(blockStateModelGenerator, ModBlocks.Pillars.WAXED_WEATHERED_COPPER_BULB_PILLAR, Blocks.WEATHERED_COPPER_BULB);
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_OXIDIZED_COPPER_PILLAR, baseAll(Blocks.OXIDIZED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_OXIDIZED_CHISELED_COPPER_PILLAR, baseAll(Blocks.OXIDIZED_CHISELED_COPPER));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_OXIDIZED_COPPER_GRATE_PILLAR, baseAll(Blocks.OXIDIZED_COPPER_GRATE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WAXED_OXIDIZED_CUT_COPPER_PILLAR, baseAll(Blocks.OXIDIZED_CUT_COPPER));
        registerCopperBulbPillar(blockStateModelGenerator, ModBlocks.Pillars.WAXED_OXIDIZED_COPPER_BULB_PILLAR, Blocks.OXIDIZED_COPPER_BULB);
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WHITE_WOOL_PILLAR, baseAll(Blocks.WHITE_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIGHT_GRAY_WOOL_PILLAR, baseAll(Blocks.LIGHT_GRAY_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GRAY_WOOL_PILLAR, baseAll(Blocks.GRAY_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLACK_WOOL_PILLAR, baseAll(Blocks.BLACK_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BROWN_WOOL_PILLAR, baseAll(Blocks.BROWN_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RED_WOOL_PILLAR, baseAll(Blocks.RED_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ORANGE_WOOL_PILLAR, baseAll(Blocks.ORANGE_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.YELLOW_WOOL_PILLAR, baseAll(Blocks.YELLOW_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIME_WOOL_PILLAR, baseAll(Blocks.LIME_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GREEN_WOOL_PILLAR, baseAll(Blocks.GREEN_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CYAN_WOOL_PILLAR, baseAll(Blocks.CYAN_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIGHT_BLUE_WOOL_PILLAR, baseAll(Blocks.LIGHT_BLUE_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLUE_WOOL_PILLAR, baseAll(Blocks.BLUE_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PURPLE_WOOL_PILLAR, baseAll(Blocks.PURPLE_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MAGENTA_WOOL_PILLAR, baseAll(Blocks.MAGENTA_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PINK_WOOL_PILLAR, baseAll(Blocks.PINK_WOOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.TERRACOTTA_PILLAR, baseAll(Blocks.TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WHITE_TERRACOTTA_PILLAR, baseAll(Blocks.WHITE_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIGHT_GRAY_TERRACOTTA_PILLAR, baseAll(Blocks.LIGHT_GRAY_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GRAY_TERRACOTTA_PILLAR, baseAll(Blocks.GRAY_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLACK_TERRACOTTA_PILLAR, baseAll(Blocks.BLACK_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BROWN_TERRACOTTA_PILLAR, baseAll(Blocks.BROWN_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RED_TERRACOTTA_PILLAR, baseAll(Blocks.RED_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ORANGE_TERRACOTTA_PILLAR, baseAll(Blocks.ORANGE_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.YELLOW_TERRACOTTA_PILLAR, baseAll(Blocks.YELLOW_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIME_TERRACOTTA_PILLAR, baseAll(Blocks.LIME_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GREEN_TERRACOTTA_PILLAR, baseAll(Blocks.GREEN_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CYAN_TERRACOTTA_PILLAR, baseAll(Blocks.CYAN_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIGHT_BLUE_TERRACOTTA_PILLAR, baseAll(Blocks.LIGHT_BLUE_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLUE_TERRACOTTA_PILLAR, baseAll(Blocks.BLUE_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PURPLE_TERRACOTTA_PILLAR, baseAll(Blocks.PURPLE_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MAGENTA_TERRACOTTA_PILLAR, baseAll(Blocks.MAGENTA_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PINK_TERRACOTTA_PILLAR, baseAll(Blocks.PINK_TERRACOTTA));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WHITE_CONCRETE_PILLAR, baseAll(Blocks.WHITE_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIGHT_GRAY_CONCRETE_PILLAR, baseAll(Blocks.LIGHT_GRAY_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GRAY_CONCRETE_PILLAR, baseAll(Blocks.GRAY_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLACK_CONCRETE_PILLAR, baseAll(Blocks.BLACK_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BROWN_CONCRETE_PILLAR, baseAll(Blocks.BROWN_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RED_CONCRETE_PILLAR, baseAll(Blocks.RED_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ORANGE_CONCRETE_PILLAR, baseAll(Blocks.ORANGE_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.YELLOW_CONCRETE_PILLAR, baseAll(Blocks.YELLOW_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIME_CONCRETE_PILLAR, baseAll(Blocks.LIME_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GREEN_CONCRETE_PILLAR, baseAll(Blocks.GREEN_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CYAN_CONCRETE_PILLAR, baseAll(Blocks.CYAN_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIGHT_BLUE_CONCRETE_PILLAR, baseAll(Blocks.LIGHT_BLUE_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLUE_CONCRETE_PILLAR, baseAll(Blocks.BLUE_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PURPLE_CONCRETE_PILLAR, baseAll(Blocks.PURPLE_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MAGENTA_CONCRETE_PILLAR, baseAll(Blocks.MAGENTA_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PINK_CONCRETE_PILLAR, baseAll(Blocks.PINK_CONCRETE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GLASS_PILLAR, baseAll(Blocks.GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WHITE_STAINED_GLASS_PILLAR, baseAll(Blocks.WHITE_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIGHT_GRAY_STAINED_GLASS_PILLAR, baseAll(Blocks.LIGHT_GRAY_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GRAY_STAINED_GLASS_PILLAR, baseAll(Blocks.GRAY_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLACK_STAINED_GLASS_PILLAR, baseAll(Blocks.BLACK_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BROWN_STAINED_GLASS_PILLAR, baseAll(Blocks.BROWN_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RED_STAINED_GLASS_PILLAR, baseAll(Blocks.RED_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ORANGE_STAINED_GLASS_PILLAR, baseAll(Blocks.ORANGE_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.YELLOW_STAINED_GLASS_PILLAR, baseAll(Blocks.YELLOW_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIME_STAINED_GLASS_PILLAR, baseAll(Blocks.LIME_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GREEN_STAINED_GLASS_PILLAR, baseAll(Blocks.GREEN_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CYAN_STAINED_GLASS_PILLAR, baseAll(Blocks.CYAN_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LIGHT_BLUE_STAINED_GLASS_PILLAR, baseAll(Blocks.LIGHT_BLUE_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLUE_STAINED_GLASS_PILLAR, baseAll(Blocks.BLUE_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PURPLE_STAINED_GLASS_PILLAR, baseAll(Blocks.PURPLE_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MAGENTA_STAINED_GLASS_PILLAR, baseAll(Blocks.MAGENTA_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PINK_STAINED_GLASS_PILLAR, baseAll(Blocks.PINK_STAINED_GLASS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PODZOL_PILLAR, sideTop(Blocks.PODZOL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MYCELIUM_PILLAR, sideTop(Blocks.MYCELIUM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DIRT_PILLAR, baseAll(Blocks.DIRT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.COARSE_DIRT_PILLAR, baseAll(Blocks.COARSE_DIRT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ROOTED_DIRT_PILLAR, baseAll(Blocks.ROOTED_DIRT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MUD_PILLAR, baseAll(Blocks.MUD));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CLAY_PILLAR, baseAll(Blocks.CLAY));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.ICE_PILLAR, baseAll(Blocks.ICE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PACKED_ICE_PILLAR, baseAll(Blocks.PACKED_ICE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BLUE_ICE_PILLAR, baseAll(Blocks.BLUE_ICE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SNOW_PILLAR, baseAll(Blocks.SNOW));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MOSS_PILLAR, baseAll(Blocks.MOSS_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PALE_MOSS_PILLAR, baseAll(Blocks.PALE_MOSS_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CALCITE_PILLAR, baseAll(Blocks.CALCITE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DRIPSTONE_PILLAR, baseAll(Blocks.DRIPSTONE_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MAGMA_PILLAR, noBlock(Blocks.MAGMA_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OBSIDIAN_PILLAR, baseAll(Blocks.OBSIDIAN));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRYING_OBSIDIAN_PILLAR, baseAll(Blocks.CRYING_OBSIDIAN));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CRIMSON_NYLIUM_PILLAR, columnSide(Blocks.CRIMSON_NYLIUM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WARPED_NYLIUM_PILLAR, columnSide(Blocks.WARPED_NYLIUM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SOUL_SAND_PILLAR, baseAll(Blocks.SOUL_SAND));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SOUL_SOIL_PILLAR, baseAll(Blocks.SOUL_SOIL));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BONE_PILLAR, sideTop(Blocks.BONE_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.GLOWSTONE_PILLAR, baseAll(Blocks.GLOWSTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MUDDY_MANGROVE_ROOT_PILLAR, sideTop(Blocks.MUDDY_MANGROVE_ROOTS));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.MUSHROOM_STEM_PILLAR, baseAll(Blocks.MUSHROOM_STEM));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BROWN_MUSHROOM_PILLAR, baseAll(Blocks.BROWN_MUSHROOM_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RED_MUSHROOM_PILLAR, baseAll(Blocks.RED_MUSHROOM_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.NETHER_WART_PILLAR, baseAll(Blocks.NETHER_WART_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WARPED_WART_PILLAR, baseAll(Blocks.WARPED_WART_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SHROOMLIGHT_PILLAR, baseAll(Blocks.SHROOMLIGHT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.TUBE_CORAL_PILLAR, baseAll(Blocks.TUBE_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BRAIN_CORAL_PILLAR, baseAll(Blocks.BRAIN_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BUBBLE_CORAL_PILLAR, baseAll(Blocks.BUBBLE_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.FIRE_CORAL_PILLAR, baseAll(Blocks.FIRE_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.HORN_CORAL_PILLAR, baseAll(Blocks.HORN_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DEAD_TUBE_CORAL_PILLAR, baseAll(Blocks.DEAD_TUBE_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DEAD_BRAIN_CORAL_PILLAR, baseAll(Blocks.DEAD_BRAIN_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DEAD_BUBBLE_CORAL_PILLAR, baseAll(Blocks.DEAD_BUBBLE_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DEAD_FIRE_CORAL_PILLAR, baseAll(Blocks.DEAD_FIRE_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.DEAD_HORN_CORAL_PILLAR, baseAll(Blocks.DEAD_HORN_CORAL_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SPONGE_PILLAR, baseAll(Blocks.SPONGE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.WET_SPONGE_PILLAR, baseAll(Blocks.WET_SPONGE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.HAY_PILLAR, sideTop(Blocks.HAY_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.HONEYCOMB_PILLAR, baseAll(Blocks.HONEYCOMB_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SLIME_PILLAR, baseAll(Blocks.SLIME_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.HONEY_PILLAR, sideTop(Blocks.HONEY_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.RESIN_PILLAR, baseAll(Blocks.RESIN_BLOCK));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.OCHRE_FROGLIGHT_PILLAR, sideTop(Blocks.OCHRE_FROGLIGHT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.VERDANT_FROGLIGHT_PILLAR, sideTop(Blocks.VERDANT_FROGLIGHT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.PEARLESCENT_FROGLIGHT_PILLAR, sideTop(Blocks.PEARLESCENT_FROGLIGHT));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SCULK_PILLAR, baseAll(Blocks.SCULK));
//        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.SCULK_CATALYST_PILLAR, sideTop(Blocks.SCULK_CATALYST));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.LODESTONE_PILLAR, sideTop(Blocks.LODESTONE));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.BOOKSHELF_PILLAR, bookshelf());
//        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CHISELED_BOOKSHELF_PILLAR, sideTop(Blocks.CHISELED_BOOKSHELF));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.TARGET_PILLAR, sideTop(Blocks.TARGET));
        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.TNT_PILLAR, sideTop(Blocks.TNT));
//        registerPillarBlock(blockStateModelGenerator, ModBlocks.Pillars.CREAKING_HEART_PILLAR, baseTop(Blocks.CREAKING_HEART));

        registerChairBlock(blockStateModelGenerator, ModBlocks.OAK_CHAIR, Blocks.OAK_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.SPRUCE_CHAIR, Blocks.SPRUCE_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.BIRCH_CHAIR, Blocks.BIRCH_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.JUNGLE_CHAIR, Blocks.JUNGLE_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.ACACIA_CHAIR, Blocks.ACACIA_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.DARK_OAK_CHAIR, Blocks.DARK_OAK_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.MANGROVE_CHAIR, Blocks.MANGROVE_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.CHERRY_CHAIR, Blocks.CHERRY_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.PALE_OAK_CHAIR, Blocks.PALE_OAK_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.BAMBOO_CHAIR, Blocks.BAMBOO_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.BAMBOO_MOSAIC_CHAIR, Blocks.BAMBOO_MOSAIC);
        registerChairBlock(blockStateModelGenerator, ModBlocks.CRIMSON_CHAIR, Blocks.CRIMSON_PLANKS);
        registerChairBlock(blockStateModelGenerator, ModBlocks.WARPED_CHAIR, Blocks.WARPED_PLANKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SCREW, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
    }

    private void registerSideBlock(BlockStateModelGenerator gen, Block sideBlock, TextureMap textureMap) {
        String textureName = textureMap.getTexture(TextureKey.SIDE).toString();
        if (textureName.endsWith("_side")) {
            textureName = textureName.substring(0, textureName.lastIndexOf('_'));
        } else if (textureName.endsWith("_top")) {
            textureName = textureName.substring(0, textureName.lastIndexOf('_'));
            textureName = textureName.replace("/", "/smooth_");
        } else if (textureName.endsWith("_bottom")) {
            textureName = textureName.substring(0, textureName.indexOf("_block"));
            textureName = textureName.replace("/", "/smooth_");
        }

        Identifier fullModelId = Identifier.of(textureName);
        Identifier sideModelId;

        //Model JSON
        sideModelId = SIDE.upload(sideBlock, textureMap, gen.modelCollector); //TextureKeys wird TextureMap zugeordnet und JSON generiert
        gen.registerParentedItemModel(sideBlock, sideModelId); //ItemModel JSON

        //Blockstate
        gen.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator.of(sideBlock)
                        .with(BlockStateVariantMap.models(SideBlock.TYPE)
                                .register(SideType.NORTH, BlockStateModelGenerator.createWeightedVariant(sideModelId).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(SideType.EAST, BlockStateModelGenerator.createWeightedVariant(sideModelId))
                                .register(SideType.SOUTH, BlockStateModelGenerator.createWeightedVariant(sideModelId).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(SideType.WEST, BlockStateModelGenerator.createWeightedVariant(sideModelId).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(SideType.DOUBLE, BlockStateModelGenerator.createWeightedVariant(fullModelId))
                        )
                        .apply(BlockStateModelGenerator.UV_LOCK)
        );
    }

    private void registerCornerBlock(BlockStateModelGenerator gen, Block cornerBlock, TextureMap textureMap) {
        //Model JSON
        Identifier cornerModelId = CORNER.upload(cornerBlock, textureMap, gen.modelCollector);
        Identifier cornerInnerModelId = CORNER_INNER.upload(cornerBlock, "_inner", textureMap, gen.modelCollector);
        Identifier cornerOuterPrevModelId = CORNER_OUTER_PREV.upload(cornerBlock, "_outer_prev", textureMap, gen.modelCollector);
        Identifier cornerOuterNextModelId = CORNER_OUTER_NEXT.upload(cornerBlock, "_outer_next", textureMap, gen.modelCollector);
        Identifier cornerOuterDoubleModelId = CORNER_OUTER_DOUBLE.upload(cornerBlock, "_outer_double", textureMap, gen.modelCollector);
        gen.registerParentedItemModel(cornerBlock, cornerModelId);//ItemModel JSON

        // Blockstate
        gen.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator.of(cornerBlock)
                        .with(BlockStateVariantMap.DoubleProperty.models(CornerBlock.DIRECTION, CornerBlock.SHAPE)
                                .register(CornerDirection.SOUTHWEST, CornerShape.STRAIGHT, BlockStateModelGenerator.createWeightedVariant(cornerModelId))
                                .register(CornerDirection.SOUTHWEST, CornerShape.INNER_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerInnerModelId))
                                .register(CornerDirection.SOUTHWEST, CornerShape.INNER_TOP, BlockStateModelGenerator.createWeightedVariant(cornerInnerModelId).apply(BlockStateModelGenerator.ROTATE_X_90))
                                .register(CornerDirection.SOUTHWEST, CornerShape.OUTER_PREV_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterPrevModelId))
                                .register(CornerDirection.SOUTHWEST, CornerShape.OUTER_PREV_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterPrevModelId).apply(BlockStateModelGenerator.ROTATE_X_90))
                                .register(CornerDirection.SOUTHWEST, CornerShape.OUTER_NEXT_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterNextModelId).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.SOUTHWEST, CornerShape.OUTER_NEXT_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterNextModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.SOUTHWEST, CornerShape.OUTER_DOUBLE_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterDoubleModelId))
                                .register(CornerDirection.SOUTHWEST, CornerShape.OUTER_DOUBLE_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterDoubleModelId).apply(BlockStateModelGenerator.ROTATE_X_90))
                                .register(CornerDirection.NORTHWEST, CornerShape.STRAIGHT, BlockStateModelGenerator.createWeightedVariant(cornerModelId).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.NORTHWEST, CornerShape.INNER_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerInnerModelId).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.NORTHWEST, CornerShape.INNER_TOP, BlockStateModelGenerator.createWeightedVariant(cornerInnerModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.NORTHWEST, CornerShape.OUTER_PREV_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterPrevModelId).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.NORTHWEST, CornerShape.OUTER_PREV_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterPrevModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.NORTHWEST, CornerShape.OUTER_NEXT_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterNextModelId).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.NORTHWEST, CornerShape.OUTER_NEXT_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterNextModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.NORTHWEST, CornerShape.OUTER_DOUBLE_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterDoubleModelId).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.NORTHWEST, CornerShape.OUTER_DOUBLE_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterDoubleModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .register(CornerDirection.NORTHEAST, CornerShape.STRAIGHT, BlockStateModelGenerator.createWeightedVariant(cornerModelId).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.NORTHEAST, CornerShape.INNER_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerInnerModelId).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.NORTHEAST, CornerShape.INNER_TOP, BlockStateModelGenerator.createWeightedVariant(cornerInnerModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.NORTHEAST, CornerShape.OUTER_PREV_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterPrevModelId).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.NORTHEAST, CornerShape.OUTER_PREV_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterPrevModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.NORTHEAST, CornerShape.OUTER_NEXT_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterNextModelId).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(CornerDirection.NORTHEAST, CornerShape.OUTER_NEXT_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterNextModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(CornerDirection.NORTHEAST, CornerShape.OUTER_DOUBLE_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterDoubleModelId).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.NORTHEAST, CornerShape.OUTER_DOUBLE_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterDoubleModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .register(CornerDirection.SOUTHEAST, CornerShape.STRAIGHT, BlockStateModelGenerator.createWeightedVariant(cornerModelId).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(CornerDirection.SOUTHEAST, CornerShape.INNER_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerInnerModelId).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(CornerDirection.SOUTHEAST, CornerShape.INNER_TOP, BlockStateModelGenerator.createWeightedVariant(cornerInnerModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(CornerDirection.SOUTHEAST, CornerShape.OUTER_PREV_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterPrevModelId).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(CornerDirection.SOUTHEAST, CornerShape.OUTER_PREV_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterPrevModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(CornerDirection.SOUTHEAST, CornerShape.OUTER_NEXT_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterNextModelId))
                                .register(CornerDirection.SOUTHEAST, CornerShape.OUTER_NEXT_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterNextModelId).apply(BlockStateModelGenerator.ROTATE_X_90))
                                .register(CornerDirection.SOUTHEAST, CornerShape.OUTER_DOUBLE_BOTTOM, BlockStateModelGenerator.createWeightedVariant(cornerOuterDoubleModelId).apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .register(CornerDirection.SOUTHEAST, CornerShape.OUTER_DOUBLE_TOP, BlockStateModelGenerator.createWeightedVariant(cornerOuterDoubleModelId).apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_270))
                        )
                        .apply(BlockStateModelGenerator.UV_LOCK)
        );
    }

    private void registerPillarBlock(BlockStateModelGenerator gen, Block pillarBlock, TextureMap textureMap) {
        Identifier pillarModelId = PILLAR.upload(pillarBlock, textureMap, gen.modelCollector);
        gen.registerParentedItemModel(pillarBlock, pillarModelId);
        gen.blockStateCollector.accept(BlockStateModelGenerator.createAxisRotatedBlockState(pillarBlock, BlockStateModelGenerator.createWeightedVariant(pillarModelId)));
    }

    private void registerCopperBulbPillar(BlockStateModelGenerator gen, Block copperBulbPillar, Block copperBulbBlock) {
        Identifier copperBulbPillarModelId = PILLAR.upload(copperBulbPillar, baseAll(copperBulbBlock), gen.modelCollector);
        Identifier copperBulbPillarLitModelId = PILLAR.upload(copperBulbPillar, "_lit", lit(copperBulbBlock), gen.modelCollector);
        Identifier copperBulbPillarPoweredModelId = PILLAR.upload(copperBulbPillar, "_powered", powered(copperBulbBlock), gen.modelCollector);
        Identifier copperBulbPillarLitPoweredModelId = PILLAR.upload(copperBulbPillar, "_lit_powered", litPowered(copperBulbBlock), gen.modelCollector);
        gen.registerParentedItemModel(copperBulbPillar, copperBulbPillarModelId);

        WeightedVariant weightedVariant = BlockStateModelGenerator.createWeightedVariant(copperBulbPillarModelId);
        WeightedVariant weightedVariantLit = BlockStateModelGenerator.createWeightedVariant(copperBulbPillarLitModelId);
        WeightedVariant weightedVariantPowered = BlockStateModelGenerator.createWeightedVariant(copperBulbPillarPoweredModelId);
        WeightedVariant weightedVariantLitPowered = BlockStateModelGenerator.createWeightedVariant(copperBulbPillarLitPoweredModelId);
        gen.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(copperBulbPillar).with(BlockStateVariantMap.TripleProperty.models(PillarBlock.AXIS, OxidizableBulbPillarBlock.LIT, OxidizableBulbPillarBlock.POWERED).generate((axis, lit, powered) -> {
                            if (axis == Direction.Axis.Y) {
                                if (lit && powered) return weightedVariantLitPowered;
                                if (lit) return weightedVariantLit;
                                if (powered) return weightedVariantPowered;
                                return weightedVariant;
                            } else if (axis == Direction.Axis.Z) {
                                if (lit && powered) return weightedVariantLitPowered.apply(BlockStateModelGenerator.ROTATE_X_90);
                                if (lit) return weightedVariantLit.apply(BlockStateModelGenerator.ROTATE_X_90);
                                if (powered) return weightedVariantPowered.apply(BlockStateModelGenerator.ROTATE_X_90);
                                return weightedVariant.apply(BlockStateModelGenerator.ROTATE_X_90);
                            }
                            if (lit && powered)
                                return weightedVariantLitPowered.apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_90);
                            if (lit)
                                return weightedVariantLit.apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_90);
                            if (powered)
                                return weightedVariantPowered.apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_90);
                            return weightedVariant.apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.ROTATE_Y_90);
                        })
                )
        );
    }

    private void registerChairBlock(BlockStateModelGenerator gen, Block chairBlock, Block baseBlock) {
        Identifier chairModelId = CHAIR.upload(chairBlock, new TextureMap().put(TextureKey.ALL, TextureMap.getId(baseBlock)), gen.modelCollector);
        gen.registerParentedItemModel(chairBlock, chairModelId);
        gen.registerNorthDefaultHorizontalRotatable(chairBlock);
    }
}
