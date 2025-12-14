package net.b34tzepz.betterbuilding.datagen;


import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, ModItems.SCREW)
                        .pattern("#")
                        .pattern("#")
                        .input('#',  Items.IRON_NUGGET)
                        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                        .offerTo(exporter);

                createReinforcedRecipe(ModBlocks.REINFORCED_OAK_PLANKS, Items.OAK_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_SPRUCE_PLANKS, Items.SPRUCE_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_BIRCH_PLANKS, Items.BIRCH_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_JUNGLE_PLANKS, Items.JUNGLE_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_ACACIA_PLANKS, Items.ACACIA_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_DARK_OAK_PLANKS, Items.DARK_OAK_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_MANGROVE_PLANKS, Items.MANGROVE_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_CHERRY_PLANKS, Items.CHERRY_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_PALE_OAK_PLANKS, Items.PALE_OAK_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_BAMBOO_PLANKS, Items.BAMBOO_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_BAMBOO_MOSAIC, Items.BAMBOO_MOSAIC);
                createReinforcedRecipe(ModBlocks.REINFORCED_CRIMSON_PLANKS, Items.CRIMSON_PLANKS);
                createReinforcedRecipe(ModBlocks.REINFORCED_WARPED_PLANKS, Items.WARPED_PLANKS);

                createSideRecipe(ModBlocks.Sides.OAK_SIDE, Items.OAK_PLANKS);
                createSideRecipe(ModBlocks.Sides.SPRUCE_SIDE, Items.SPRUCE_PLANKS);
                createSideRecipe(ModBlocks.Sides.BIRCH_SIDE, Items.BIRCH_PLANKS);
                createSideRecipe(ModBlocks.Sides.JUNGLE_SIDE, Items.JUNGLE_PLANKS);
                createSideRecipe(ModBlocks.Sides.ACACIA_SIDE, Items.ACACIA_PLANKS);
                createSideRecipe(ModBlocks.Sides.DARK_OAK_SIDE, Items.DARK_OAK_PLANKS);
                createSideRecipe(ModBlocks.Sides.MANGROVE_SIDE, Items.MANGROVE_PLANKS);
                createSideRecipe(ModBlocks.Sides.CHERRY_SIDE, Items.CHERRY_PLANKS);
                createSideRecipe(ModBlocks.Sides.PALE_OAK_SIDE, Items.PALE_OAK_PLANKS);
                createSideRecipe(ModBlocks.Sides.BAMBOO_SIDE, Items.BAMBOO_PLANKS);
                createSideRecipe(ModBlocks.Sides.BAMBOO_MOSAIC_SIDE, Items.BAMBOO_PLANKS);
                createSideRecipe(ModBlocks.Sides.CRIMSON_SIDE, Items.CRIMSON_PLANKS);
                createSideRecipe(ModBlocks.Sides.WARPED_SIDE, Items.WARPED_PLANKS);
                createSideRecipe(ModBlocks.Sides.STONE_SIDE, Items.STONE);
                createSideRecipe(ModBlocks.Sides.COBBLESTONE_SIDE, Items.COBBLESTONE);
                createSideRecipe(ModBlocks.Sides.MOSSY_COBBLESTONE_SIDE, Items.MOSSY_COBBLESTONE);
                createSideRecipe(ModBlocks.Sides.SMOOTH_STONE_SIDE, Items.SMOOTH_STONE);
                createSideRecipe(ModBlocks.Sides.STONE_BRICK_SIDE, Items.STONE_BRICKS);
                createSideRecipe(ModBlocks.Sides.MOSSY_STONE_BRICK_SIDE, Items.MOSSY_STONE_BRICKS);
                createSideRecipe(ModBlocks.Sides.GRANITE_SIDE, Items.GRANITE);
                createSideRecipe(ModBlocks.Sides.POLISHED_GRANITE_SIDE, Items.POLISHED_GRANITE);
                createSideRecipe(ModBlocks.Sides.DIORITE_SIDE, Items.DIORITE);
                createSideRecipe(ModBlocks.Sides.POLISHED_DIORITE_SIDE, Items.POLISHED_DIORITE);
                createSideRecipe(ModBlocks.Sides.ANDESITE_SIDE, Items.ANDESITE);
                createSideRecipe(ModBlocks.Sides.POLISHED_ANDESITE_SIDE, Items.POLISHED_ANDESITE);
                createSideRecipe(ModBlocks.Sides.COBBLED_DEEPSLATE_SIDE, Items.COBBLED_DEEPSLATE);
                createSideRecipe(ModBlocks.Sides.POLISHED_DEEPSLATE_SIDE, Items.POLISHED_DEEPSLATE);
                createSideRecipe(ModBlocks.Sides.DEEPSLATE_BRICK_SIDE, Items.DEEPSLATE_BRICKS);
                createSideRecipe(ModBlocks.Sides.DEEPSLATE_TILE_SIDE, Items.DEEPSLATE_TILES);
                createSideRecipe(ModBlocks.Sides.TUFF_SIDE, Items.TUFF);
                createSideRecipe(ModBlocks.Sides.POLISHED_TUFF_SIDE, Items.POLISHED_TUFF);
                createSideRecipe(ModBlocks.Sides.TUFF_BRICK_SIDE, Items.TUFF_BRICKS);
                createSideRecipe(ModBlocks.Sides.BRICK_SIDE, Items.BRICKS);
                createSideRecipe(ModBlocks.Sides.MUD_BRICK_SIDE, Items.MUD_BRICKS);
                createSideRecipe(ModBlocks.Sides.RESIN_BRICK_SIDE, Items.RESIN_BRICKS);
                createSideRecipe(ModBlocks.Sides.SANDSTONE_SIDE, Items.SANDSTONE);
                createSideRecipe(ModBlocks.Sides.SMOOTH_SANDSTONE_SIDE, Items.SMOOTH_SANDSTONE);
                createSideRecipe(ModBlocks.Sides.CUT_SANDSTONE_SIDE, Items.CUT_SANDSTONE);
                createSideRecipe(ModBlocks.Sides.RED_SANDSTONE_SIDE, Items.RED_SANDSTONE);
                createSideRecipe(ModBlocks.Sides.SMOOTH_RED_SANDSTONE_SIDE, Items.SMOOTH_RED_SANDSTONE);
                createSideRecipe(ModBlocks.Sides.CUT_RED_SANDSTONE_SIDE, Items.CUT_RED_SANDSTONE);
                createSideRecipe(ModBlocks.Sides.PRISMARINE_SIDE, Items.PRISMARINE);
                createSideRecipe(ModBlocks.Sides.PRISMARINE_BRICK_SIDE, Items.PRISMARINE_BRICKS);
                createSideRecipe(ModBlocks.Sides.DARK_PRISMARINE_SIDE, Items.DARK_PRISMARINE);
                createSideRecipe(ModBlocks.Sides.NETHER_BRICK_SIDE, Items.NETHER_BRICKS);
                createSideRecipe(ModBlocks.Sides.RED_NETHER_BRICK_SIDE, Items.RED_NETHER_BRICKS);
                createSideRecipe(ModBlocks.Sides.BLACKSTONE_SIDE, Items.BLACKSTONE);
                createSideRecipe(ModBlocks.Sides.POLISHED_BLACKSTONE_SIDE, Items.POLISHED_BLACKSTONE);
                createSideRecipe(ModBlocks.Sides.POLISHED_BLACKSTONE_BRICK_SIDE, Items.POLISHED_BLACKSTONE_BRICKS);
                createSideRecipe(ModBlocks.Sides.END_STONE_BRICK_SIDE, Items.END_STONE_BRICKS);
                createSideRecipe(ModBlocks.Sides.PURPUR_SIDE, Items.PURPUR_BLOCK);
                createSideRecipe(ModBlocks.Sides.QUARTZ_SIDE, Items.QUARTZ_BLOCK);
                createSideRecipe(ModBlocks.Sides.SMOOTH_QUARTZ_SIDE, Items.SMOOTH_QUARTZ);
                createSideRecipe(ModBlocks.Sides.CUT_COPPER_SIDE, Items.CUT_COPPER);
                createSideRecipe(ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE, Items.EXPOSED_CUT_COPPER);
                createSideRecipe(ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE, Items.WEATHERED_CUT_COPPER);
                createSideRecipe(ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE, Items.OXIDIZED_CUT_COPPER);
                createSideRecipe(ModBlocks.Sides.WAXED_CUT_COPPER_SIDE, Items.WAXED_CUT_COPPER);
                createSideRecipe(ModBlocks.Sides.WAXED_EXPOSED_CUT_COPPER_SIDE, Items.WAXED_EXPOSED_CUT_COPPER);
                createSideRecipe(ModBlocks.Sides.WAXED_WEATHERED_CUT_COPPER_SIDE, Items.WAXED_WEATHERED_CUT_COPPER);
                createSideRecipe(ModBlocks.Sides.WAXED_OXIDIZED_CUT_COPPER_SIDE, Items.WAXED_OXIDIZED_CUT_COPPER);

                createStairsRecipe(ModBlocks.SMOOTH_STONE_STAIRS, Ingredient.ofItem(Items.SMOOTH_STONE))
                        .criterion(hasItem(Items.SMOOTH_STONE), conditionsFromItem(Items.SMOOTH_STONE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.CUT_SANDSTONE_STAIRS, Ingredient.ofItem(Items.CUT_SANDSTONE))
                        .criterion(hasItem(Items.CUT_SANDSTONE), conditionsFromItem(Items.CUT_SANDSTONE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.CUT_RED_SANDSTONE_STAIRS, Ingredient.ofItem(Items.CUT_RED_SANDSTONE))
                        .criterion(hasItem(Items.CUT_RED_SANDSTONE), conditionsFromItem(Items.CUT_RED_SANDSTONE))
                        .offerTo(exporter);

                createCornerRecipe(ModBlocks.Corners.OAK_CORNER, Items.OAK_PLANKS);
                createCornerRecipe(ModBlocks.Corners.SPRUCE_CORNER, Items.SPRUCE_PLANKS);
                createCornerRecipe(ModBlocks.Corners.BIRCH_CORNER, Items.BIRCH_PLANKS);
                createCornerRecipe(ModBlocks.Corners.JUNGLE_CORNER, Items.JUNGLE_PLANKS);
                createCornerRecipe(ModBlocks.Corners.ACACIA_CORNER, Items.ACACIA_PLANKS);
                createCornerRecipe(ModBlocks.Corners.DARK_OAK_CORNER, Items.DARK_OAK_PLANKS);
                createCornerRecipe(ModBlocks.Corners.MANGROVE_CORNER, Items.MANGROVE_PLANKS);
                createCornerRecipe(ModBlocks.Corners.CHERRY_CORNER, Items.CHERRY_PLANKS);
                createCornerRecipe(ModBlocks.Corners.PALE_OAK_CORNER, Items.PALE_OAK_PLANKS);
                createCornerRecipe(ModBlocks.Corners.BAMBOO_CORNER, Items.BAMBOO_PLANKS);
                createCornerRecipe(ModBlocks.Corners.BAMBOO_MOSAIC_CORNER, Items.BAMBOO_PLANKS);
                createCornerRecipe(ModBlocks.Corners.CRIMSON_CORNER, Items.CRIMSON_PLANKS);
                createCornerRecipe(ModBlocks.Corners.WARPED_CORNER, Items.WARPED_PLANKS);
                createCornerRecipe(ModBlocks.Corners.STONE_CORNER, Items.STONE);
                createCornerRecipe(ModBlocks.Corners.COBBLESTONE_CORNER, Items.COBBLESTONE);
                createCornerRecipe(ModBlocks.Corners.MOSSY_COBBLESTONE_CORNER, Items.MOSSY_COBBLESTONE);
                createCornerRecipe(ModBlocks.Corners.SMOOTH_STONE_CORNER, Items.SMOOTH_STONE);
                createCornerRecipe(ModBlocks.Corners.STONE_BRICK_CORNER, Items.STONE_BRICKS);
                createCornerRecipe(ModBlocks.Corners.MOSSY_STONE_BRICK_CORNER, Items.MOSSY_STONE_BRICKS);
                createCornerRecipe(ModBlocks.Corners.GRANITE_CORNER, Items.GRANITE);
                createCornerRecipe(ModBlocks.Corners.POLISHED_GRANITE_CORNER, Items.POLISHED_GRANITE);
                createCornerRecipe(ModBlocks.Corners.DIORITE_CORNER, Items.DIORITE);
                createCornerRecipe(ModBlocks.Corners.POLISHED_DIORITE_CORNER, Items.POLISHED_DIORITE);
                createCornerRecipe(ModBlocks.Corners.ANDESITE_CORNER, Items.ANDESITE);
                createCornerRecipe(ModBlocks.Corners.POLISHED_ANDESITE_CORNER, Items.POLISHED_ANDESITE);
                createCornerRecipe(ModBlocks.Corners.COBBLED_DEEPSLATE_CORNER, Items.COBBLED_DEEPSLATE);
                createCornerRecipe(ModBlocks.Corners.POLISHED_DEEPSLATE_CORNER, Items.POLISHED_DEEPSLATE);
                createCornerRecipe(ModBlocks.Corners.DEEPSLATE_BRICK_CORNER, Items.DEEPSLATE_BRICKS);
                createCornerRecipe(ModBlocks.Corners.DEEPSLATE_TILE_CORNER, Items.DEEPSLATE_TILES);
                createCornerRecipe(ModBlocks.Corners.TUFF_CORNER, Items.TUFF);
                createCornerRecipe(ModBlocks.Corners.POLISHED_TUFF_CORNER, Items.POLISHED_TUFF);
                createCornerRecipe(ModBlocks.Corners.TUFF_BRICK_CORNER, Items.TUFF_BRICKS);
                createCornerRecipe(ModBlocks.Corners.BRICK_CORNER, Items.BRICKS);
                createCornerRecipe(ModBlocks.Corners.MUD_BRICK_CORNER, Items.MUD_BRICKS);
                createCornerRecipe(ModBlocks.Corners.RESIN_BRICK_CORNER, Items.RESIN_BRICKS);
                createCornerRecipe(ModBlocks.Corners.SANDSTONE_CORNER, Items.SANDSTONE);
                createCornerRecipe(ModBlocks.Corners.SMOOTH_SANDSTONE_CORNER, Items.SMOOTH_SANDSTONE);
                createCornerRecipe(ModBlocks.Corners.CUT_SANDSTONE_CORNER, Items.CUT_SANDSTONE);
                createCornerRecipe(ModBlocks.Corners.RED_SANDSTONE_CORNER, Items.RED_SANDSTONE);
                createCornerRecipe(ModBlocks.Corners.SMOOTH_RED_SANDSTONE_CORNER, Items.SMOOTH_RED_SANDSTONE);
                createCornerRecipe(ModBlocks.Corners.CUT_RED_SANDSTONE_CORNER, Items.CUT_RED_SANDSTONE);
                createCornerRecipe(ModBlocks.Corners.PRISMARINE_CORNER, Items.PRISMARINE);
                createCornerRecipe(ModBlocks.Corners.PRISMARINE_BRICK_CORNER, Items.PRISMARINE_BRICKS);
                createCornerRecipe(ModBlocks.Corners.DARK_PRISMARINE_CORNER, Items.DARK_PRISMARINE);
                createCornerRecipe(ModBlocks.Corners.NETHER_BRICK_CORNER, Items.NETHER_BRICKS);
                createCornerRecipe(ModBlocks.Corners.RED_NETHER_BRICK_CORNER, Items.RED_NETHER_BRICKS);
                createCornerRecipe(ModBlocks.Corners.BLACKSTONE_CORNER, Items.BLACKSTONE);
                createCornerRecipe(ModBlocks.Corners.POLISHED_BLACKSTONE_CORNER, Items.POLISHED_BLACKSTONE);
                createCornerRecipe(ModBlocks.Corners.POLISHED_BLACKSTONE_BRICK_CORNER, Items.POLISHED_BLACKSTONE_BRICKS);
                createCornerRecipe(ModBlocks.Corners.END_STONE_BRICK_CORNER, Items.END_STONE_BRICKS);
                createCornerRecipe(ModBlocks.Corners.PURPUR_CORNER, Items.PURPUR_BLOCK);
                createCornerRecipe(ModBlocks.Corners.QUARTZ_CORNER, Items.QUARTZ_BLOCK);
                createCornerRecipe(ModBlocks.Corners.SMOOTH_QUARTZ_CORNER, Items.SMOOTH_QUARTZ);
                createCornerRecipe(ModBlocks.Corners.CUT_COPPER_CORNER, Items.CUT_COPPER);
                createCornerRecipe(ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER, Items.EXPOSED_CUT_COPPER);
                createCornerRecipe(ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER, Items.WEATHERED_CUT_COPPER);
                createCornerRecipe(ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER, Items.OXIDIZED_CUT_COPPER);
                createCornerRecipe(ModBlocks.Corners.WAXED_CUT_COPPER_CORNER, Items.WAXED_CUT_COPPER);
                createCornerRecipe(ModBlocks.Corners.WAXED_EXPOSED_CUT_COPPER_CORNER, Items.WAXED_EXPOSED_CUT_COPPER);
                createCornerRecipe(ModBlocks.Corners.WAXED_WEATHERED_CUT_COPPER_CORNER, Items.WAXED_WEATHERED_CUT_COPPER);
                createCornerRecipe(ModBlocks.Corners.WAXED_OXIDIZED_CUT_COPPER_CORNER, Items.WAXED_OXIDIZED_CUT_COPPER);

                createShaped(RecipeCategory.TOOLS, ModItems.CHISEL)
                        .pattern(" #")
                        .pattern("/ ")
                        .input('#',  Items.IRON_INGOT)
                        .input('/',  Items.STICK)
                        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SANDSTONE_STAIRS, Blocks.SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SANDSTONE_STAIRS, Blocks.CUT_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RED_SANDSTONE_STAIRS, Blocks.RED_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RED_SANDSTONE_STAIRS, Blocks.CUT_RED_SANDSTONE);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.STONE_SIDE, Blocks.STONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.STONE_BRICK_SIDE, Blocks.STONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.COBBLESTONE_SIDE, Blocks.COBBLESTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.MOSSY_COBBLESTONE_SIDE, Blocks.MOSSY_COBBLESTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.SMOOTH_STONE_SIDE, Blocks.SMOOTH_STONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.STONE_BRICK_SIDE, Blocks.STONE_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.GRANITE_SIDE, Blocks.GRANITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_GRANITE_SIDE, Blocks.GRANITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_GRANITE_SIDE, Blocks.POLISHED_GRANITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DIORITE_SIDE, Blocks.DIORITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_DIORITE_SIDE, Blocks.DIORITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_DIORITE_SIDE, Blocks.POLISHED_DIORITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.ANDESITE_SIDE, Blocks.ANDESITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_ANDESITE_SIDE, Blocks.ANDESITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_ANDESITE_SIDE, Blocks.POLISHED_ANDESITE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.COBBLED_DEEPSLATE_SIDE, Blocks.COBBLED_DEEPSLATE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_DEEPSLATE_SIDE, Blocks.COBBLED_DEEPSLATE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DEEPSLATE_BRICK_SIDE, Blocks.COBBLED_DEEPSLATE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DEEPSLATE_TILE_SIDE, Blocks.COBBLED_DEEPSLATE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_DEEPSLATE_SIDE, Blocks.POLISHED_DEEPSLATE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DEEPSLATE_BRICK_SIDE, Blocks.POLISHED_DEEPSLATE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DEEPSLATE_TILE_SIDE, Blocks.POLISHED_DEEPSLATE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DEEPSLATE_BRICK_SIDE, Blocks.DEEPSLATE_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DEEPSLATE_TILE_SIDE, Blocks.DEEPSLATE_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DEEPSLATE_TILE_SIDE, Blocks.DEEPSLATE_TILES, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.TUFF_SIDE, Blocks.TUFF, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_TUFF_SIDE, Blocks.TUFF, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.TUFF_BRICK_SIDE, Blocks.TUFF, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_TUFF_SIDE, Blocks.POLISHED_TUFF, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.TUFF_BRICK_SIDE, Blocks.POLISHED_TUFF, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.TUFF_BRICK_SIDE, Blocks.TUFF_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.BRICK_SIDE, Blocks.BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.MUD_BRICK_SIDE, Blocks.MUD_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.RESIN_BRICK_SIDE, Blocks.RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.SANDSTONE_SIDE, Blocks.SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.CUT_SANDSTONE_SIDE, Blocks.SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.SMOOTH_SANDSTONE_SIDE, Blocks.SMOOTH_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.CUT_SANDSTONE_SIDE, Blocks.CUT_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.RED_SANDSTONE_SIDE, Blocks.RED_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.CUT_RED_SANDSTONE_SIDE, Blocks.RED_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.SMOOTH_RED_SANDSTONE_SIDE, Blocks.SMOOTH_RED_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.CUT_RED_SANDSTONE_SIDE, Blocks.CUT_RED_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.PRISMARINE_SIDE, Blocks.PRISMARINE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.PRISMARINE_BRICK_SIDE, Blocks.PRISMARINE_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.DARK_PRISMARINE_SIDE, Blocks.DARK_PRISMARINE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.NETHER_BRICK_SIDE, Blocks.NETHER_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.RED_NETHER_BRICK_SIDE, Blocks.RED_NETHER_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.BLACKSTONE_SIDE, Blocks.BLACKSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_BLACKSTONE_SIDE, Blocks.BLACKSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_BLACKSTONE_BRICK_SIDE, Blocks.BLACKSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_BLACKSTONE_SIDE, Blocks.POLISHED_BLACKSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_BLACKSTONE_BRICK_SIDE, Blocks.POLISHED_BLACKSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.POLISHED_BLACKSTONE_BRICK_SIDE, Blocks.POLISHED_BLACKSTONE_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.END_STONE_BRICK_SIDE, Blocks.END_STONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.END_STONE_BRICK_SIDE, Blocks.END_STONE_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.PURPUR_SIDE, Blocks.PURPUR_BLOCK, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.QUARTZ_SIDE, Blocks.QUARTZ_BLOCK, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.SMOOTH_QUARTZ_SIDE, Blocks.SMOOTH_QUARTZ, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.CUT_COPPER_SIDE, Blocks.COPPER_BLOCK, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.CUT_COPPER_SIDE, Blocks.CUT_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE, Blocks.EXPOSED_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE, Blocks.EXPOSED_CUT_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE, Blocks.WEATHERED_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE, Blocks.WEATHERED_CUT_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE, Blocks.OXIDIZED_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE, Blocks.OXIDIZED_CUT_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WAXED_CUT_COPPER_SIDE, Blocks.WAXED_COPPER_BLOCK, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WAXED_CUT_COPPER_SIDE, Blocks.WAXED_CUT_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WAXED_EXPOSED_CUT_COPPER_SIDE, Blocks.WAXED_EXPOSED_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WAXED_EXPOSED_CUT_COPPER_SIDE, Blocks.WAXED_EXPOSED_CUT_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WAXED_WEATHERED_CUT_COPPER_SIDE, Blocks.WAXED_WEATHERED_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WAXED_WEATHERED_CUT_COPPER_SIDE, Blocks.WAXED_WEATHERED_CUT_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WAXED_OXIDIZED_CUT_COPPER_SIDE, Blocks.WAXED_OXIDIZED_COPPER, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Sides.WAXED_OXIDIZED_CUT_COPPER_SIDE, Blocks.WAXED_OXIDIZED_CUT_COPPER, 2);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.STONE_CORNER, Blocks.STONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.STONE_BRICK_CORNER, Blocks.STONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.COBBLESTONE_CORNER, Blocks.COBBLESTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.MOSSY_COBBLESTONE_CORNER, Blocks.MOSSY_COBBLESTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.SMOOTH_STONE_CORNER, Blocks.SMOOTH_STONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.STONE_BRICK_CORNER, Blocks.STONE_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.GRANITE_CORNER, Blocks.GRANITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_GRANITE_CORNER, Blocks.GRANITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_GRANITE_CORNER, Blocks.POLISHED_GRANITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DIORITE_CORNER, Blocks.DIORITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_DIORITE_CORNER, Blocks.DIORITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_DIORITE_CORNER, Blocks.POLISHED_DIORITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.ANDESITE_CORNER, Blocks.ANDESITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_ANDESITE_CORNER, Blocks.ANDESITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_ANDESITE_CORNER, Blocks.POLISHED_ANDESITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.COBBLED_DEEPSLATE_CORNER, Blocks.COBBLED_DEEPSLATE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_DEEPSLATE_CORNER, Blocks.COBBLED_DEEPSLATE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DEEPSLATE_BRICK_CORNER, Blocks.COBBLED_DEEPSLATE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DEEPSLATE_TILE_CORNER, Blocks.COBBLED_DEEPSLATE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_DEEPSLATE_CORNER, Blocks.POLISHED_DEEPSLATE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DEEPSLATE_BRICK_CORNER, Blocks.POLISHED_DEEPSLATE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DEEPSLATE_TILE_CORNER, Blocks.POLISHED_DEEPSLATE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DEEPSLATE_BRICK_CORNER, Blocks.DEEPSLATE_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DEEPSLATE_TILE_CORNER, Blocks.DEEPSLATE_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DEEPSLATE_TILE_CORNER, Blocks.DEEPSLATE_TILES);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.TUFF_CORNER, Blocks.TUFF);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_TUFF_CORNER, Blocks.TUFF);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.TUFF_BRICK_CORNER, Blocks.TUFF);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_TUFF_CORNER, Blocks.POLISHED_TUFF);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.TUFF_BRICK_CORNER, Blocks.POLISHED_TUFF);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.TUFF_BRICK_CORNER, Blocks.TUFF_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.BRICK_CORNER, Blocks.BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.MUD_BRICK_CORNER, Blocks.MUD_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.RESIN_BRICK_CORNER, Blocks.RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.SANDSTONE_CORNER, Blocks.SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.CUT_SANDSTONE_CORNER, Blocks.SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.SMOOTH_SANDSTONE_CORNER, Blocks.SMOOTH_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.CUT_SANDSTONE_CORNER, Blocks.CUT_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.RED_SANDSTONE_CORNER, Blocks.RED_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.CUT_RED_SANDSTONE_CORNER, Blocks.RED_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.SMOOTH_RED_SANDSTONE_CORNER, Blocks.SMOOTH_RED_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.CUT_RED_SANDSTONE_CORNER, Blocks.CUT_RED_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.PRISMARINE_CORNER, Blocks.PRISMARINE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.PRISMARINE_BRICK_CORNER, Blocks.PRISMARINE_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.DARK_PRISMARINE_CORNER, Blocks.DARK_PRISMARINE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.NETHER_BRICK_CORNER, Blocks.NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.RED_NETHER_BRICK_CORNER, Blocks.RED_NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.BLACKSTONE_CORNER, Blocks.BLACKSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_BLACKSTONE_CORNER, Blocks.BLACKSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_BLACKSTONE_BRICK_CORNER, Blocks.BLACKSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_BLACKSTONE_CORNER, Blocks.POLISHED_BLACKSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_BLACKSTONE_BRICK_CORNER, Blocks.POLISHED_BLACKSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.POLISHED_BLACKSTONE_BRICK_CORNER, Blocks.POLISHED_BLACKSTONE_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.END_STONE_BRICK_CORNER, Blocks.END_STONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.END_STONE_BRICK_CORNER, Blocks.END_STONE_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.PURPUR_CORNER, Blocks.PURPUR_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.QUARTZ_CORNER, Blocks.QUARTZ_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.SMOOTH_QUARTZ_CORNER, Blocks.SMOOTH_QUARTZ);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.CUT_COPPER_CORNER, Blocks.COPPER_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.CUT_COPPER_CORNER, Blocks.CUT_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER, Blocks.EXPOSED_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER, Blocks.EXPOSED_CUT_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER, Blocks.WEATHERED_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER, Blocks.WEATHERED_CUT_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER, Blocks.OXIDIZED_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER, Blocks.OXIDIZED_CUT_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WAXED_CUT_COPPER_CORNER, Blocks.WAXED_COPPER_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WAXED_CUT_COPPER_CORNER, Blocks.WAXED_CUT_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WAXED_EXPOSED_CUT_COPPER_CORNER, Blocks.WAXED_EXPOSED_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WAXED_EXPOSED_CUT_COPPER_CORNER, Blocks.WAXED_EXPOSED_CUT_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WAXED_WEATHERED_CUT_COPPER_CORNER, Blocks.WAXED_WEATHERED_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WAXED_WEATHERED_CUT_COPPER_CORNER, Blocks.WAXED_WEATHERED_CUT_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WAXED_OXIDIZED_CUT_COPPER_CORNER, Blocks.WAXED_OXIDIZED_COPPER);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.Corners.WAXED_OXIDIZED_CUT_COPPER_CORNER, Blocks.WAXED_OXIDIZED_CUT_COPPER);

                createChairRecipe(ModBlocks.OAK_CHAIR, ModBlocks.Sides.OAK_SIDE, Items.OAK_SLAB);
                createChairRecipe(ModBlocks.SPRUCE_CHAIR, ModBlocks.Sides.SPRUCE_SIDE, Items.SPRUCE_SLAB);
                createChairRecipe(ModBlocks.BIRCH_CHAIR, ModBlocks.Sides.BIRCH_SIDE, Items.BIRCH_SLAB);
                createChairRecipe(ModBlocks.JUNGLE_CHAIR, ModBlocks.Sides.JUNGLE_SIDE, Items.JUNGLE_SLAB);
                createChairRecipe(ModBlocks.ACACIA_CHAIR, ModBlocks.Sides.ACACIA_SIDE, Items.ACACIA_SLAB);
                createChairRecipe(ModBlocks.DARK_OAK_CHAIR, ModBlocks.Sides.DARK_OAK_SIDE, Items.DARK_OAK_SLAB);
                createChairRecipe(ModBlocks.MANGROVE_CHAIR, ModBlocks.Sides.MANGROVE_SIDE, Items.MANGROVE_SLAB);
                createChairRecipe(ModBlocks.CHERRY_CHAIR, ModBlocks.Sides.CHERRY_SIDE, Items.CHERRY_SLAB);
                createChairRecipe(ModBlocks.PALE_OAK_CHAIR, ModBlocks.Sides.PALE_OAK_SIDE, Items.PALE_OAK_SLAB);
                createChairRecipe(ModBlocks.BAMBOO_CHAIR, ModBlocks.Sides.BAMBOO_SIDE, Items.BAMBOO_SLAB);
                createChairRecipe(ModBlocks.BAMBOO_MOSAIC_CHAIR, ModBlocks.Sides.BAMBOO_MOSAIC_SIDE, Items.BAMBOO_MOSAIC_SLAB);
                createChairRecipe(ModBlocks.CRIMSON_CHAIR, ModBlocks.Sides.CRIMSON_SIDE, Items.CRIMSON_SLAB);
                createChairRecipe(ModBlocks.WARPED_CHAIR, ModBlocks.Sides.WARPED_SIDE, Items.WARPED_SLAB);

                createTableRecipe(ModBlocks.OAK_TABLE, Items.OAK_SLAB);
                createTableRecipe(ModBlocks.SPRUCE_TABLE, Items.SPRUCE_SLAB);
                createTableRecipe(ModBlocks.BIRCH_TABLE, Items.BIRCH_SLAB);
                createTableRecipe(ModBlocks.JUNGLE_TABLE, Items.JUNGLE_SLAB);
                createTableRecipe(ModBlocks.ACACIA_TABLE, Items.ACACIA_SLAB);
                createTableRecipe(ModBlocks.DARK_OAK_TABLE, Items.DARK_OAK_SLAB);
                createTableRecipe(ModBlocks.MANGROVE_TABLE, Items.MANGROVE_SLAB);
                createTableRecipe(ModBlocks.CHERRY_TABLE, Items.CHERRY_SLAB);
                createTableRecipe(ModBlocks.PALE_OAK_TABLE, Items.PALE_OAK_SLAB);
                createTableRecipe(ModBlocks.BAMBOO_TABLE, Items.BAMBOO_SLAB);
                createTableRecipe(ModBlocks.BAMBOO_MOSAIC_TABLE, Items.BAMBOO_MOSAIC_SLAB);
                createTableRecipe(ModBlocks.CRIMSON_TABLE, Items.CRIMSON_SLAB);
                createTableRecipe(ModBlocks.WARPED_TABLE, Items.WARPED_SLAB);
            }

            private void createReinforcedRecipe(Block reinforcedBlock, ItemConvertible material) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, reinforcedBlock)
                        .pattern("/ /")
                        .pattern(" # ")
                        .pattern("/ /")
                        .input('#',  material)
                        .input('/', ModItems.SCREW)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .criterion(hasItem(ModItems.SCREW), conditionsFromItem(ModItems.SCREW))
                        .offerTo(exporter);
            }

            private void createSideRecipe(Block sideBlock, ItemConvertible material) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, sideBlock, 6)
                        .pattern("#  ")
                        .pattern("#  ")
                        .pattern("#  ")
                        .input('#',  material)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }

            private void createCornerRecipe(Block cornerBlock, ItemConvertible material) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, cornerBlock, 4)
                        .pattern("###")
                        .pattern("## ")
                        .pattern("#  ")
                        .input('#',  material)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }

            private void createChairRecipe(Block chairBlock, ItemConvertible side, ItemConvertible slab) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, chairBlock)
                        .pattern("/ ")
                        .pattern("__")
                        .pattern("##")
                        .input('/',  side)
                        .input('_',  slab)
                        .input('#',  Items.STICK)
                        .criterion(hasItem(side), conditionsFromItem(side))
                        .criterion(hasItem(slab), conditionsFromItem(slab))
                        .offerTo(exporter);
            }

            private void createTableRecipe(Block tableBlock, ItemConvertible slab) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, tableBlock)
                        .pattern("___")
                        .pattern("/ /")
                        .pattern("/ /")
                        .input('_',  slab)
                        .input('/',  Items.STICK)
                        .criterion(hasItem(slab), conditionsFromItem(slab))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "BetterBuilding Recipes";
    }
}
