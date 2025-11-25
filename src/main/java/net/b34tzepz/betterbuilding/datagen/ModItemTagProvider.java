package net.b34tzepz.betterbuilding.datagen;

import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.STAIRS)
                .add(ModBlocks.SMOOTH_STONE_STAIRS.asItem())
                .add(ModBlocks.CUT_SANDSTONE_STAIRS.asItem())
                .add(ModBlocks.CUT_RED_SANDSTONE_STAIRS.asItem());

        valueLookupBuilder(ModTags.Items.SIDES)
                .addTag(ModTags.Items.WOODEN_SIDES)
                .add(ModBlocks.Sides.STONE_SIDE.asItem())
                .add(ModBlocks.Sides.COBBLESTONE_SIDE.asItem())
                .add(ModBlocks.Sides.MOSSY_COBBLESTONE_SIDE.asItem())
                .add(ModBlocks.Sides.SMOOTH_STONE_SIDE.asItem())
                .add(ModBlocks.Sides.STONE_BRICK_SIDE.asItem())
                .add(ModBlocks.Sides.MOSSY_STONE_BRICK_SIDE.asItem())
                .add(ModBlocks.Sides.GRANITE_SIDE.asItem())
                .add(ModBlocks.Sides.POLISHED_GRANITE_SIDE.asItem())
                .add(ModBlocks.Sides.DIORITE_SIDE.asItem())
                .add(ModBlocks.Sides.POLISHED_DIORITE_SIDE.asItem())
                .add(ModBlocks.Sides.ANDESITE_SIDE.asItem())
                .add(ModBlocks.Sides.POLISHED_ANDESITE_SIDE.asItem())
                .add(ModBlocks.Sides.COBBLED_DEEPSLATE_SIDE.asItem())
                .add(ModBlocks.Sides.POLISHED_DEEPSLATE_SIDE.asItem())
                .add(ModBlocks.Sides.DEEPSLATE_BRICK_SIDE.asItem())
                .add(ModBlocks.Sides.DEEPSLATE_TILE_SIDE.asItem())
                .add(ModBlocks.Sides.SANDSTONE_SIDE.asItem())
                .add(ModBlocks.Sides.SMOOTH_SANDSTONE_SIDE.asItem())
                .add(ModBlocks.Sides.CUT_SANDSTONE_SIDE.asItem())
                .add(ModBlocks.Sides.RED_SANDSTONE_SIDE.asItem())
                .add(ModBlocks.Sides.SMOOTH_RED_SANDSTONE_SIDE.asItem())
                .add(ModBlocks.Sides.CUT_RED_SANDSTONE_SIDE.asItem())
                .add(ModBlocks.Sides.PRISMARINE_SIDE.asItem())
                .add(ModBlocks.Sides.PRISMARINE_BRICK_SIDE.asItem())
                .add(ModBlocks.Sides.DARK_PRISMARINE_SIDE.asItem())
                .add(ModBlocks.Sides.NETHER_BRICK_SIDE.asItem())
                .add(ModBlocks.Sides.RED_NETHER_BRICK_SIDE.asItem())
                .add(ModBlocks.Sides.BLACKSTONE_SIDE.asItem())
                .add(ModBlocks.Sides.POLISHED_BLACKSTONE_SIDE.asItem())
                .add(ModBlocks.Sides.POLISHED_BLACKSTONE_BRICK_SIDE.asItem())
                .add(ModBlocks.Sides.END_STONE_BRICK_SIDE.asItem())
                .add(ModBlocks.Sides.PURPUR_SIDE.asItem())
                .add(ModBlocks.Sides.QUARTZ_SIDE.asItem())
                .add(ModBlocks.Sides.SMOOTH_QUARTZ_SIDE.asItem())
                .add(ModBlocks.Sides.CUT_COPPER_SIDE.asItem())
                .add(ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE.asItem())
                .add(ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE.asItem())
                .add(ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE.asItem())
                .add(ModBlocks.Sides.WAXED_CUT_COPPER_SIDE.asItem())
                .add(ModBlocks.Sides.WAXED_EXPOSED_CUT_COPPER_SIDE.asItem())
                .add(ModBlocks.Sides.WAXED_WEATHERED_CUT_COPPER_SIDE.asItem())
                .add(ModBlocks.Sides.WAXED_OXIDIZED_CUT_COPPER_SIDE.asItem());

        valueLookupBuilder(ModTags.Items.WOODEN_SIDES)
                .add(ModBlocks.Sides.OAK_SIDE.asItem())
                .add(ModBlocks.Sides.SPRUCE_SIDE.asItem())
                .add(ModBlocks.Sides.BIRCH_SIDE.asItem())
                .add(ModBlocks.Sides.JUNGLE_SIDE.asItem())
                .add(ModBlocks.Sides.ACACIA_SIDE.asItem())
                .add(ModBlocks.Sides.DARK_OAK_SIDE.asItem())
                .add(ModBlocks.Sides.CRIMSON_SIDE.asItem())
                .add(ModBlocks.Sides.WARPED_SIDE.asItem());

        valueLookupBuilder(ModTags.Items.CORNERS)
                .addTag(ModTags.Items.WOODEN_CORNERS)
                .add(ModBlocks.Corners.STONE_CORNER.asItem())
                .add(ModBlocks.Corners.COBBLESTONE_CORNER.asItem())
                .add(ModBlocks.Corners.MOSSY_COBBLESTONE_CORNER.asItem())
                .add(ModBlocks.Corners.SMOOTH_STONE_CORNER.asItem())
                .add(ModBlocks.Corners.STONE_BRICK_CORNER.asItem())
                .add(ModBlocks.Corners.MOSSY_STONE_BRICK_CORNER.asItem())
                .add(ModBlocks.Corners.GRANITE_CORNER.asItem())
                .add(ModBlocks.Corners.POLISHED_GRANITE_CORNER.asItem())
                .add(ModBlocks.Corners.DIORITE_CORNER.asItem())
                .add(ModBlocks.Corners.POLISHED_DIORITE_CORNER.asItem())
                .add(ModBlocks.Corners.ANDESITE_CORNER.asItem())
                .add(ModBlocks.Corners.POLISHED_ANDESITE_CORNER.asItem())
                .add(ModBlocks.Corners.COBBLED_DEEPSLATE_CORNER.asItem())
                .add(ModBlocks.Corners.POLISHED_DEEPSLATE_CORNER.asItem())
                .add(ModBlocks.Corners.DEEPSLATE_BRICK_CORNER.asItem())
                .add(ModBlocks.Corners.DEEPSLATE_TILE_CORNER.asItem())
                .add(ModBlocks.Corners.SANDSTONE_CORNER.asItem())
                .add(ModBlocks.Corners.SMOOTH_SANDSTONE_CORNER.asItem())
                .add(ModBlocks.Corners.CUT_SANDSTONE_CORNER.asItem())
                .add(ModBlocks.Corners.RED_SANDSTONE_CORNER.asItem())
                .add(ModBlocks.Corners.SMOOTH_RED_SANDSTONE_CORNER.asItem())
                .add(ModBlocks.Corners.CUT_RED_SANDSTONE_CORNER.asItem())
                .add(ModBlocks.Corners.PRISMARINE_CORNER.asItem())
                .add(ModBlocks.Corners.PRISMARINE_BRICK_CORNER.asItem())
                .add(ModBlocks.Corners.DARK_PRISMARINE_CORNER.asItem())
                .add(ModBlocks.Corners.NETHER_BRICK_CORNER.asItem())
                .add(ModBlocks.Corners.RED_NETHER_BRICK_CORNER.asItem())
                .add(ModBlocks.Corners.BLACKSTONE_CORNER.asItem())
                .add(ModBlocks.Corners.POLISHED_BLACKSTONE_CORNER.asItem())
                .add(ModBlocks.Corners.POLISHED_BLACKSTONE_BRICK_CORNER.asItem())
                .add(ModBlocks.Corners.END_STONE_BRICK_CORNER.asItem())
                .add(ModBlocks.Corners.PURPUR_CORNER.asItem())
                .add(ModBlocks.Corners.QUARTZ_CORNER.asItem())
                .add(ModBlocks.Corners.SMOOTH_QUARTZ_CORNER.asItem())
                .add(ModBlocks.Corners.CUT_COPPER_CORNER.asItem())
                .add(ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER.asItem())
                .add(ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER.asItem())
                .add(ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER.asItem())
                .add(ModBlocks.Corners.WAXED_CUT_COPPER_CORNER.asItem())
                .add(ModBlocks.Corners.WAXED_EXPOSED_CUT_COPPER_CORNER.asItem())
                .add(ModBlocks.Corners.WAXED_WEATHERED_CUT_COPPER_CORNER.asItem())
                .add(ModBlocks.Corners.WAXED_OXIDIZED_CUT_COPPER_CORNER.asItem());

        valueLookupBuilder(ModTags.Items.WOODEN_CORNERS)
                .add(ModBlocks.Corners.OAK_CORNER.asItem())
                .add(ModBlocks.Corners.SPRUCE_CORNER.asItem())
                .add(ModBlocks.Corners.BIRCH_CORNER.asItem())
                .add(ModBlocks.Corners.JUNGLE_CORNER.asItem())
                .add(ModBlocks.Corners.ACACIA_CORNER.asItem())
                .add(ModBlocks.Corners.DARK_OAK_CORNER.asItem())
                .add(ModBlocks.Corners.CRIMSON_CORNER.asItem())
                .add(ModBlocks.Corners.WARPED_CORNER.asItem());

        valueLookupBuilder(ModTags.Items.PILLARS);

        valueLookupBuilder(ModTags.Items.WOODEN_PILLARS);
    }
}
