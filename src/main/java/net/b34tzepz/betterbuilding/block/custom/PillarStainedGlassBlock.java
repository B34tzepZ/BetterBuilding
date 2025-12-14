package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.Stainable;
import net.minecraft.util.DyeColor;

public class PillarStainedGlassBlock extends PillarBlock implements Stainable {
    private final DyeColor color;

    public PillarStainedGlassBlock(DyeColor color, Settings settings) {
        super(settings);
        this.color = color;
    }

    @Override
    public DyeColor getColor() {
        return this.color;
    }
}
