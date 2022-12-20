package net.b34tzepz.betterbuilding.block;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.custom.OakChairBlock;
import net.b34tzepz.betterbuilding.block.custom.CornerBlock;
import net.b34tzepz.betterbuilding.block.custom.SideBlock;
import net.b34tzepz.betterbuilding.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block REINFORCED_OAK_PLANKS = registerBlock("reinforced_oak_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(3, 4.5f)), ModItemGroup.Building);

    public static final Block REINFORCED_BIRCH_PLANKS = registerBlock("reinforced_birch_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(3, 4.5f)), ModItemGroup.Building);

    public static final Block OAK_SIDE = registerBlock("oak_side",
            new SideBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3)), ModItemGroup.Building);

    public static final Block OAK_CHAIR = registerBlock("oak_chair",
            new OakChairBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 3).nonOpaque()), ModItemGroup.Building);

    public static final Block OAK_CORNER = registerBlock("oak_corner",
            new CornerBlock(Blocks.OAK_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD)), ModItemGroup.Building);

    public static final Block TELEPORTER_BLOCK = registerBlock("teleporter_block", new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ItemGroup.MISC);

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
