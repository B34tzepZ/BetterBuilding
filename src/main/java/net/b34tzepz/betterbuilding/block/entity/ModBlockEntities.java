package net.b34tzepz.betterbuilding.block.entity;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<ChairEntity> OAK_CHAIR;
    public static BlockEntityType<TeleporterBlockEntity> TELEPORTER_BLOCK;
    //public static BlockEntityType<FabricatorBlockEntity> FABRICATOR_BLOCK;

    public static void registerAllEntities() {
        OAK_CHAIR = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BetterBuilding.MOD_ID, "oak_chair"),
                FabricBlockEntityTypeBuilder.create(ChairEntity::new,
                        ModBlocks.OAK_CHAIR).build(null));


        TELEPORTER_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BetterBuilding.MOD_ID, "teleporter_block"),
                FabricBlockEntityTypeBuilder.create(TeleporterBlockEntity::new,
                        ModBlocks.TELEPORTER_BLOCK).build(null));

        /*FABRICATOR_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BetterBuilding.MOD_ID, "fabricator"),
                FabricBlockEntityTypeBuilder.create(FabricatorBlockEntity::new,
                        ModBlocks.FABRICATOR_BLOCK).build(null));*/
    }
}
