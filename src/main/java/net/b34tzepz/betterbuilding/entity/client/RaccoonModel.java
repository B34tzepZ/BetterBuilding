package net.b34tzepz.betterbuilding.entity.client;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.entity.custom.RaccoonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RaccoonModel extends AnimatedGeoModel<RaccoonEntity> {
    @Override
    public Identifier getModelLocation(RaccoonEntity entity) {
        return new Identifier(BetterBuilding.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public Identifier getTextureLocation(RaccoonEntity entity) {
        return new Identifier(BetterBuilding.MOD_ID, "textures/entity/raccoon/raccoon.png");
    }

    @Override
    public Identifier getAnimationFileLocation(RaccoonEntity entity) {
        return new Identifier(BetterBuilding.MOD_ID, "animations/raccoon.animation.json");
    }
}
