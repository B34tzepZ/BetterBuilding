package net.b34tzepz.betterbuilding.entity.client;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.entity.custom.RaccoonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {

    public RaccoonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RaccoonModel());
    }

    @Override
    public Identifier getTextureLocation(RaccoonEntity entity) {
        return new Identifier(BetterBuilding.MOD_ID, "textures/entity/raccoon/raccoon.png");
    }
}
