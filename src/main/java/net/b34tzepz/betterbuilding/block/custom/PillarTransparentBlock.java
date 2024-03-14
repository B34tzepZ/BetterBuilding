package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;

public class PillarTransparentBlock extends PillarBlock{
    public PillarTransparentBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
}
