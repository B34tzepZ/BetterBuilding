package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class PillarTintedGlassBlock extends PillarGlassBlock{
    public PillarTintedGlassBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean isTransparent(BlockState state) {
        return false;
    }

    @Override
    protected int getOpacity(BlockState state) {
        return 15;
    }
}
