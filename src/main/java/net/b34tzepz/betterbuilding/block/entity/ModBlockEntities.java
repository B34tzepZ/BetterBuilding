package net.b34tzepz.betterbuilding.block.entity;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<ChairEntity> OAK_CHAIR;
    public static BlockEntityType<ChairEntity> BIRCH_CHAIR;
    public static BlockEntityType<ChairEntity> SPRUCE_CHAIR;
    public static BlockEntityType<ChairEntity> JUNGLE_CHAIR;
    public static BlockEntityType<ChairEntity> ACACIA_CHAIR;
    public static BlockEntityType<ChairEntity> DARK_OAK_CHAIR;
    public static BlockEntityType<ChairEntity> CRIMSON_CHAIR;
    public static BlockEntityType<ChairEntity> WARPED_CHAIR;
    public static BlockEntityType<TeleporterBlockEntity> TELEPORTER_BLOCK;
    public static BlockEntityType<FabricatorBlockEntity> FABRICATOR_BLOCK;

    public static void registerAllEntities() {
        OAK_CHAIR = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "oak_chair"),
                FabricBlockEntityTypeBuilder.create(ChairEntity::new,
                        ModBlocks.OAK_CHAIR).build(null));

        SPRUCE_CHAIR = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "spruce_chair"),
                FabricBlockEntityTypeBuilder.create(ChairEntity::new,
                        ModBlocks.SPRUCE_CHAIR).build(null));

        BIRCH_CHAIR = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "birch_chair"),
                FabricBlockEntityTypeBuilder.create(ChairEntity::new,
                        ModBlocks.BIRCH_CHAIR).build(null));

        ACACIA_CHAIR = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "acacia_chair"),
                FabricBlockEntityTypeBuilder.create(ChairEntity::new,
                        ModBlocks.ACACIA_CHAIR).build(null));

        DARK_OAK_CHAIR = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "dark_oak_chair"),
                FabricBlockEntityTypeBuilder.create(ChairEntity::new,
                        ModBlocks.DARK_OAK_CHAIR).build(null));

        CRIMSON_CHAIR = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "crimson_chair"),
                FabricBlockEntityTypeBuilder.create(ChairEntity::new,
                        ModBlocks.CRIMSON_CHAIR).build(null));

        WARPED_CHAIR = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "warped_chair"),
                FabricBlockEntityTypeBuilder.create(ChairEntity::new,
                        ModBlocks.WARPED_CHAIR).build(null));

        TELEPORTER_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "teleporter_block"),
                FabricBlockEntityTypeBuilder.create(TeleporterBlockEntity::new,
                        ModBlocks.TELEPORTER_BLOCK).build(null));

        FABRICATOR_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "fabricator_block"),
                FabricBlockEntityTypeBuilder.create(FabricatorBlockEntity::new,
                        ModBlocks.FABRICATOR_BLOCK).build(null));
    }
}
