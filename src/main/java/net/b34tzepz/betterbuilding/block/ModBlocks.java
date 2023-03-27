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

    public static final Block OAK_CHAIR = registerBlock("oak_chair",
            new OakChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.Building);

    public static final Block OAK_TABLE = registerBlock("oak_table",
            new TableBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModItemGroup.Building);

    public static final Block TELEPORTER_BLOCK = registerBlock("teleporter_block",
            new TeleporterBlock(FabricBlockSettings.of(Material.METAL).strength(5, 6).requiresTool()), ModItemGroup.Building);

    public static final Block FABRICATOR_BLOCK = registerBlock("fabricator_block",
            new FabricatorBlock(FabricBlockSettings.of(Material.METAL).strength(5, 6).requiresTool()), ModItemGroup.Building);


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
