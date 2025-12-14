package net.b34tzepz.betterbuilding.block.entity;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModEntities {
    public static BlockEntityType<TeleporterBlockEntity> TELEPORTER_BLOCK;

    private static final RegistryKey<EntityType<?>> CHAIR_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(BetterBuilding.MOD_ID, "chair_entity"));

    public static final EntityType<ChairEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BetterBuilding.MOD_ID, "chair_entity"),
            EntityType.Builder.create(ChairEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.7f).build(CHAIR_KEY));

    public static void registerAllEntities() {
        TELEPORTER_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BetterBuilding.MOD_ID, "teleporter_block"),
                FabricBlockEntityTypeBuilder.create(TeleporterBlockEntity::new,
                        ModBlocks.TELEPORTER_BLOCK).build(null));
    }
}
