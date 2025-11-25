package net.b34tzepz.betterbuilding.datagen;

import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.block.custom.SideBlock;
import net.b34tzepz.betterbuilding.block.enums.SideType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.REINFORCED_OAK_PLANKS, block -> drops(block, Blocks.OAK_PLANKS));
        addDrop(ModBlocks.REINFORCED_SPRUCE_PLANKS, block -> drops(block, Blocks.SPRUCE_PLANKS));
        addDrop(ModBlocks.REINFORCED_BIRCH_PLANKS, block -> drops(block, Blocks.BIRCH_PLANKS));

        addSideDrop(ModBlocks.Sides.OAK_SIDE);
        addSideDrop(ModBlocks.Sides.SPRUCE_SIDE);
        addSideDrop(ModBlocks.Sides.BIRCH_SIDE);
        addSideDrop(ModBlocks.Sides.JUNGLE_SIDE);
        addSideDrop(ModBlocks.Sides.ACACIA_SIDE);
        addSideDrop(ModBlocks.Sides.DARK_OAK_SIDE);
        addSideDrop(ModBlocks.Sides.CRIMSON_SIDE);
        addSideDrop(ModBlocks.Sides.WARPED_SIDE);
        addSideDrop(ModBlocks.Sides.STONE_SIDE);
        addSideDrop(ModBlocks.Sides.COBBLESTONE_SIDE);
        addSideDrop(ModBlocks.Sides.MOSSY_COBBLESTONE_SIDE);
        addSideDrop(ModBlocks.Sides.SMOOTH_STONE_SIDE);
        addSideDrop(ModBlocks.Sides.STONE_BRICK_SIDE);
        addSideDrop(ModBlocks.Sides.MOSSY_STONE_BRICK_SIDE);
        addSideDrop(ModBlocks.Sides.GRANITE_SIDE);
        addSideDrop(ModBlocks.Sides.POLISHED_GRANITE_SIDE);
        addSideDrop(ModBlocks.Sides.DIORITE_SIDE);
        addSideDrop(ModBlocks.Sides.POLISHED_DIORITE_SIDE);
        addSideDrop(ModBlocks.Sides.ANDESITE_SIDE);
        addSideDrop(ModBlocks.Sides.POLISHED_ANDESITE_SIDE);
        addSideDrop(ModBlocks.Sides.COBBLED_DEEPSLATE_SIDE);
        addSideDrop(ModBlocks.Sides.POLISHED_DEEPSLATE_SIDE);
        addSideDrop(ModBlocks.Sides.DEEPSLATE_BRICK_SIDE);
        addSideDrop(ModBlocks.Sides.DEEPSLATE_TILE_SIDE);
        addSideDrop(ModBlocks.Sides.SANDSTONE_SIDE);
        addSideDrop(ModBlocks.Sides.SMOOTH_SANDSTONE_SIDE);
        addSideDrop(ModBlocks.Sides.CUT_SANDSTONE_SIDE);
        addSideDrop(ModBlocks.Sides.RED_SANDSTONE_SIDE);
        addSideDrop(ModBlocks.Sides.SMOOTH_RED_SANDSTONE_SIDE);
        addSideDrop(ModBlocks.Sides.CUT_RED_SANDSTONE_SIDE);
        addSideDrop(ModBlocks.Sides.PRISMARINE_SIDE);
        addSideDrop(ModBlocks.Sides.PRISMARINE_BRICK_SIDE);
        addSideDrop(ModBlocks.Sides.DARK_PRISMARINE_SIDE);
        addSideDrop(ModBlocks.Sides.NETHER_BRICK_SIDE);
        addSideDrop(ModBlocks.Sides.RED_NETHER_BRICK_SIDE);
        addSideDrop(ModBlocks.Sides.BLACKSTONE_SIDE);
        addSideDrop(ModBlocks.Sides.POLISHED_BLACKSTONE_SIDE);
        addSideDrop(ModBlocks.Sides.POLISHED_BLACKSTONE_BRICK_SIDE);
        addSideDrop(ModBlocks.Sides.END_STONE_BRICK_SIDE);
        addSideDrop(ModBlocks.Sides.PURPUR_SIDE);
        addSideDrop(ModBlocks.Sides.QUARTZ_SIDE);
        addSideDrop(ModBlocks.Sides.SMOOTH_QUARTZ_SIDE);
        addSideDrop(ModBlocks.Sides.CUT_COPPER_SIDE);
        addSideDrop(ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE);
        addSideDrop(ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE);
        addSideDrop(ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE);
        addSideDrop(ModBlocks.Sides.WAXED_CUT_COPPER_SIDE);
        addSideDrop(ModBlocks.Sides.WAXED_EXPOSED_CUT_COPPER_SIDE);
        addSideDrop(ModBlocks.Sides.WAXED_WEATHERED_CUT_COPPER_SIDE);
        addSideDrop(ModBlocks.Sides.WAXED_OXIDIZED_CUT_COPPER_SIDE);

        addDrop(ModBlocks.SMOOTH_STONE_STAIRS);
        addDrop(ModBlocks.CUT_SANDSTONE_STAIRS);
        addDrop(ModBlocks.CUT_RED_SANDSTONE_STAIRS);

        addDrop(ModBlocks.Corners.OAK_CORNER);
        addDrop(ModBlocks.Corners.SPRUCE_CORNER);
        addDrop(ModBlocks.Corners.BIRCH_CORNER);
        addDrop(ModBlocks.Corners.JUNGLE_CORNER);
        addDrop(ModBlocks.Corners.ACACIA_CORNER);
        addDrop(ModBlocks.Corners.DARK_OAK_CORNER);
        addDrop(ModBlocks.Corners.CRIMSON_CORNER);
        addDrop(ModBlocks.Corners.WARPED_CORNER);
        addDrop(ModBlocks.Corners.STONE_CORNER);
        addDrop(ModBlocks.Corners.COBBLESTONE_CORNER);
        addDrop(ModBlocks.Corners.MOSSY_COBBLESTONE_CORNER);
        addDrop(ModBlocks.Corners.SMOOTH_STONE_CORNER);
        addDrop(ModBlocks.Corners.STONE_BRICK_CORNER);
        addDrop(ModBlocks.Corners.MOSSY_STONE_BRICK_CORNER);
        addDrop(ModBlocks.Corners.GRANITE_CORNER);
        addDrop(ModBlocks.Corners.POLISHED_GRANITE_CORNER);
        addDrop(ModBlocks.Corners.DIORITE_CORNER);
        addDrop(ModBlocks.Corners.POLISHED_DIORITE_CORNER);
        addDrop(ModBlocks.Corners.ANDESITE_CORNER);
        addDrop(ModBlocks.Corners.POLISHED_ANDESITE_CORNER);
        addDrop(ModBlocks.Corners.COBBLED_DEEPSLATE_CORNER);
        addDrop(ModBlocks.Corners.POLISHED_DEEPSLATE_CORNER);
        addDrop(ModBlocks.Corners.DEEPSLATE_BRICK_CORNER);
        addDrop(ModBlocks.Corners.DEEPSLATE_TILE_CORNER);
        addDrop(ModBlocks.Corners.SANDSTONE_CORNER);
        addDrop(ModBlocks.Corners.SMOOTH_SANDSTONE_CORNER);
        addDrop(ModBlocks.Corners.CUT_SANDSTONE_CORNER);
        addDrop(ModBlocks.Corners.RED_SANDSTONE_CORNER);
        addDrop(ModBlocks.Corners.SMOOTH_RED_SANDSTONE_CORNER);
        addDrop(ModBlocks.Corners.CUT_RED_SANDSTONE_CORNER);
        addDrop(ModBlocks.Corners.PRISMARINE_CORNER);
        addDrop(ModBlocks.Corners.PRISMARINE_BRICK_CORNER);
        addDrop(ModBlocks.Corners.DARK_PRISMARINE_CORNER);
        addDrop(ModBlocks.Corners.NETHER_BRICK_CORNER);
        addDrop(ModBlocks.Corners.RED_NETHER_BRICK_CORNER);
        addDrop(ModBlocks.Corners.BLACKSTONE_CORNER);
        addDrop(ModBlocks.Corners.POLISHED_BLACKSTONE_CORNER);
        addDrop(ModBlocks.Corners.POLISHED_BLACKSTONE_BRICK_CORNER);
        addDrop(ModBlocks.Corners.END_STONE_BRICK_CORNER);
        addDrop(ModBlocks.Corners.PURPUR_CORNER);
        addDrop(ModBlocks.Corners.QUARTZ_CORNER);
        addDrop(ModBlocks.Corners.SMOOTH_QUARTZ_CORNER);
        addDrop(ModBlocks.Corners.CUT_COPPER_CORNER);
        addDrop(ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER);
        addDrop(ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER);
        addDrop(ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER);
        addDrop(ModBlocks.Corners.WAXED_CUT_COPPER_CORNER);
        addDrop(ModBlocks.Corners.WAXED_EXPOSED_CUT_COPPER_CORNER);
        addDrop(ModBlocks.Corners.WAXED_WEATHERED_CUT_COPPER_CORNER);
        addDrop(ModBlocks.Corners.WAXED_OXIDIZED_CUT_COPPER_CORNER);

        addDrop(ModBlocks.OAK_CHAIR);
        addDrop(ModBlocks.SPRUCE_CHAIR);
        addDrop(ModBlocks.BIRCH_CHAIR);
        addDrop(ModBlocks.JUNGLE_CHAIR);
        addDrop(ModBlocks.ACACIA_CHAIR);
        addDrop(ModBlocks.DARK_OAK_CHAIR);
        addDrop(ModBlocks.CRIMSON_CHAIR);
        addDrop(ModBlocks.WARPED_CHAIR);

        addDrop(ModBlocks.TELEPORTER_BLOCK);
    }

    public void addSideDrop(Block block) {
        addDrop(block, LootTable.builder().pool(LootPool.builder()
                .rolls(new ConstantLootNumberProvider(1))
                .with(ItemEntry.builder(block.asItem())
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))
                                .conditionally(BlockStatePropertyLootCondition.builder(block)
                                        .properties(StatePredicate.Builder.create()
                                                .exactMatch(SideBlock.TYPE, SideType.DOUBLE))))
                        .apply(ExplosionDecayLootFunction.builder()))));
    }
}
