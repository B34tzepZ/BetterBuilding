package net.b34tzepz.betterbuilding.util;

import net.b34tzepz.betterbuilding.entity.ModEntities;
import net.b34tzepz.betterbuilding.entity.custom.RaccoonEntity;
import net.b34tzepz.betterbuilding.entity.custom.TigerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.RACCOON, RaccoonEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.setAttributes());
    }
}
