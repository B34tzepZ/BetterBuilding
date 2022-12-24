package net.b34tzepz.betterbuilding.entity;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.entity.custom.RaccoonEntity;
import net.b34tzepz.betterbuilding.entity.custom.SittingEntity;
import net.b34tzepz.betterbuilding.entity.custom.TigerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<RaccoonEntity> RACCOON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "raccoon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RaccoonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build());

    public static final EntityType<TigerEntity> TIGER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "tiger"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TigerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 0.75f)).build());

    public static final EntityType<SittingEntity> SITTING=Registry.register(
            Registry.ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, SittingEntity::new)
                    .dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build());
}
