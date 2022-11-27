package net.b34tzepz.betterbuilding.entity.client;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.entity.custom.TigerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TigerRenderer extends GeoEntityRenderer<TigerEntity> {
    public TigerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new TigerModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public Identifier getTextureLocation(TigerEntity entity) {
        return new Identifier(BetterBuilding.MOD_ID, "textures/entity/tiger/tiger.png");
    }
}
