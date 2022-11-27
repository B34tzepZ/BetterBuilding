package net.b34tzepz.betterbuilding.entity.client;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.entity.custom.TigerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TigerModel extends AnimatedGeoModel<TigerEntity> {
    @Override
    public Identifier getModelLocation(TigerEntity entity) {
        return new Identifier(BetterBuilding.MOD_ID, "geo/tiger.geo.json");
    }

    @Override
    public Identifier getTextureLocation(TigerEntity entity) {
        return new Identifier(BetterBuilding.MOD_ID, "textures/entity/tiger/tiger.png");
    }

    @Override
    public Identifier getAnimationFileLocation(TigerEntity entity) {
        return new Identifier(BetterBuilding.MOD_ID, "animations/tiger.animation.json");
    }
}