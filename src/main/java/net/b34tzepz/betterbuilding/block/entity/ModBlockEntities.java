package net.b34tzepz.betterbuilding.block.entity;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<OakChairEntity> OAK_CHAIR;

    public static void  registerAllEntities(){
        OAK_CHAIR = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterBuilding.MOD_ID, "oak_chair"),
                FabricBlockEntityTypeBuilder.create(OakChairEntity::new,
                        ModBlocks.OAK_CHAIR).build(null));
    }
}
