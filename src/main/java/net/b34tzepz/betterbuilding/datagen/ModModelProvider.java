package net.b34tzepz.betterbuilding.datagen;

import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.block.custom.SideBlock;
import net.b34tzepz.betterbuilding.block.enums.SideType;
import net.b34tzepz.betterbuilding.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public static final Model SIDE = new Model(Optional.of(Identifier.of("betterbuilding", "block/side")), Optional.empty(), TextureKey.SIDE, TextureKey.TOP, TextureKey.BOTTOM); //Model mit parent und keys on textures


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_SPRUCE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_BIRCH_PLANKS);

        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.OAK_SIDE, Blocks.OAK_PLANKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SPRUCE_SIDE, Blocks.SPRUCE_PLANKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.BIRCH_SIDE, Blocks.BIRCH_PLANKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.JUNGLE_SIDE, Blocks.JUNGLE_PLANKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.ACACIA_SIDE, Blocks.ACACIA_PLANKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DARK_OAK_SIDE, Blocks.DARK_OAK_PLANKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CRIMSON_SIDE, Blocks.CRIMSON_PLANKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WARPED_SIDE, Blocks.WARPED_PLANKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.STONE_SIDE, Blocks.STONE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.COBBLESTONE_SIDE, Blocks.COBBLESTONE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.MOSSY_COBBLESTONE_SIDE, Blocks.MOSSY_COBBLESTONE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SMOOTH_STONE_SIDE, Blocks.SMOOTH_STONE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.STONE_BRICK_SIDE, Blocks.STONE_BRICKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.MOSSY_STONE_BRICK_SIDE, Blocks.MOSSY_STONE_BRICKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.GRANITE_SIDE, Blocks.GRANITE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_GRANITE_SIDE, Blocks.POLISHED_GRANITE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DIORITE_SIDE, Blocks.DIORITE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_DIORITE_SIDE, Blocks.POLISHED_DIORITE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.ANDESITE_SIDE, Blocks.ANDESITE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_ANDESITE_SIDE, Blocks.POLISHED_ANDESITE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.COBBLED_DEEPSLATE_SIDE, Blocks.COBBLED_DEEPSLATE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_DEEPSLATE_SIDE, Blocks.POLISHED_DEEPSLATE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DEEPSLATE_BRICK_SIDE, Blocks.DEEPSLATE_BRICKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DEEPSLATE_TILE_SIDE, Blocks.DEEPSLATE_TILES, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SANDSTONE_SIDE, Blocks.SANDSTONE, false);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SMOOTH_SANDSTONE_SIDE, Blocks.SMOOTH_SANDSTONE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CUT_SANDSTONE_SIDE, Blocks.CUT_SANDSTONE, false);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.RED_SANDSTONE_SIDE, Blocks.RED_SANDSTONE, false);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SMOOTH_RED_SANDSTONE_SIDE, Blocks.SMOOTH_RED_SANDSTONE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CUT_RED_SANDSTONE_SIDE, Blocks.CUT_RED_SANDSTONE, false);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.PRISMARINE_SIDE, Blocks.PRISMARINE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.PRISMARINE_BRICK_SIDE, Blocks.PRISMARINE_BRICKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.DARK_PRISMARINE_SIDE, Blocks.DARK_PRISMARINE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.NETHER_BRICK_SIDE, Blocks.NETHER_BRICKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.RED_NETHER_BRICK_SIDE, Blocks.RED_NETHER_BRICKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.BLACKSTONE_SIDE, Blocks.BLACKSTONE, false);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_BLACKSTONE_SIDE, Blocks.POLISHED_BLACKSTONE, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.POLISHED_BLACKSTONE_BRICK_SIDE, Blocks.POLISHED_BLACKSTONE_BRICKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.END_STONE_BRICK_SIDE, Blocks.END_STONE_BRICKS, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.PURPUR_SIDE, Blocks.PURPUR_BLOCK, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.QUARTZ_SIDE, Blocks.QUARTZ_BLOCK, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.SMOOTH_QUARTZ_SIDE, Blocks.SMOOTH_QUARTZ, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.CUT_COPPER_SIDE, Blocks.CUT_COPPER, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE, Blocks.EXPOSED_CUT_COPPER, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE, Blocks.WEATHERED_CUT_COPPER, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE, Blocks.OXIDIZED_CUT_COPPER, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WAXED_CUT_COPPER_SIDE, Blocks.WAXED_CUT_COPPER, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WAXED_EXPOSED_CUT_COPPER_SIDE, Blocks.WAXED_EXPOSED_CUT_COPPER, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WAXED_WEATHERED_CUT_COPPER_SIDE, Blocks.WAXED_WEATHERED_CUT_COPPER, true);
        registerSideBlock(blockStateModelGenerator, ModBlocks.Sides.WAXED_OXIDIZED_CUT_COPPER_SIDE, Blocks.WAXED_OXIDIZED_CUT_COPPER, true);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SCREW, Models.GENERATED);
        itemModelGenerator.register(ModItems.TABLE_LEG, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
    }

    private void registerSideBlock(BlockStateModelGenerator gen, Block sideBlock, Block baseBlock, boolean all) {
        //Model JSON
        //TextureMap hat bereits viele Optionen sonst selbst definieren, siehe unten
        Identifier fullModelId = ModelIds.getBlockModelId(baseBlock);
        Identifier sideModelId;
        if (all){
            sideModelId = SIDE.upload(sideBlock, sideAll(baseBlock), gen.modelCollector); //TextureKeys wird TextureMap zugeordnet und JSON generiert
        } else {
            sideModelId = SIDE.upload(sideBlock, sideTopBottom(baseBlock), gen.modelCollector);
        }
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

    private TextureMap sideAll(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getId(baseBlock))
                .put(TextureKey.TOP,TextureMap.getId(baseBlock))
                .put(TextureKey.BOTTOM,TextureMap.getId(baseBlock));
    }

    private TextureMap sideTopBottom(Block baseBlock) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getId(baseBlock))
                .put(TextureKey.TOP, TextureMap.getSubId(baseBlock, "_top"))
                .put(TextureKey.BOTTOM,TextureMap.getSubId(baseBlock, "_bottom"));
    }
}
