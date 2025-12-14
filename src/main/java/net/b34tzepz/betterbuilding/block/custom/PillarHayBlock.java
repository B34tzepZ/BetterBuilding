package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PillarHayBlock extends PillarBlock{
    public PillarHayBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall());
    }
}
