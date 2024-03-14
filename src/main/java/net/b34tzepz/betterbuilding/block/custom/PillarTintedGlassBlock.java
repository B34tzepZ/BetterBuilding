package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class PillarTintedGlassBlock extends PillarGlassBlock{
    public PillarTintedGlassBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return world.getMaxLightLevel();
    }
}
