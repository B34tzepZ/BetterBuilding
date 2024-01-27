package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class OxidizableCornerBlock extends CornerBlock implements Oxidizable{
    private final net.minecraft.block.Oxidizable.OxidationLevel oxidationLevel;

    public OxidizableCornerBlock(net.minecraft.block.Oxidizable.OxidationLevel oxidationLevel, AbstractBlock.Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public net.minecraft.block.Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
