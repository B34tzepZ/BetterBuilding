/*package net.b34tzepz.betterbuilding.block.custom;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Degradable;

import java.util.Optional;
import java.util.function.Supplier;

public interface Oxidizable extends Degradable<net.minecraft.block.Oxidizable.OxidationLevel> {
     Supplier<BiMap<Block, Block>> OXIDATION_LEVEL_INCREASES = Suppliers.memoize(() -> {
        ImmutableBiMap.Builder<Block, Block> builder = ImmutableBiMap.builder();
        builder.put(ModBlocks.Sides.CUT_COPPER_SIDE, ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE);
        builder.put(ModBlocks.Sides.EXPOSED_CUT_COPPER_SIDE, ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE);
        builder.put(ModBlocks.Sides.WEATHERED_CUT_COPPER_SIDE, ModBlocks.Sides.OXIDIZED_CUT_COPPER_SIDE);
        builder.put(ModBlocks.Corners.CUT_COPPER_CORNER, ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER);
        builder.put(ModBlocks.Corners.EXPOSED_CUT_COPPER_CORNER, ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER);
        builder.put(ModBlocks.Corners.WEATHERED_CUT_COPPER_CORNER, ModBlocks.Corners.OXIDIZED_CUT_COPPER_CORNER);
        builder.put(ModBlocks.Pillars.COPPER_PILLAR, ModBlocks.Pillars.EXPOSED_COPPER_PILLAR);
        builder.put(ModBlocks.Pillars.EXPOSED_COPPER_PILLAR, ModBlocks.Pillars.WEATHERED_COPPER_PILLAR);
        builder.put(ModBlocks.Pillars.WEATHERED_COPPER_PILLAR, ModBlocks.Pillars.OXIDIZED_COPPER_PILLAR);
        builder.put(ModBlocks.Pillars.CUT_COPPER_PILLAR, ModBlocks.Pillars.EXPOSED_CUT_COPPER_PILLAR);
        builder.put(ModBlocks.Pillars.EXPOSED_CUT_COPPER_PILLAR, ModBlocks.Pillars.WEATHERED_CUT_COPPER_PILLAR);
        builder.put(ModBlocks.Pillars.WEATHERED_CUT_COPPER_PILLAR, ModBlocks.Pillars.OXIDIZED_CUT_COPPER_PILLAR);
        return builder.build();
    });

    Supplier<BiMap<Block, Block>> OXIDATION_LEVEL_DECREASES = Suppliers.memoize(() -> OXIDATION_LEVEL_INCREASES.get().inverse());

    static Optional<Block> getDecreasedOxidationBlock(Block block) {
        return Optional.ofNullable((Block)((BiMap<?, ?>)OXIDATION_LEVEL_DECREASES.get()).get(block));
    }

    static Block getUnaffectedOxidationBlock(Block block) {
        Block block2 = block;

        for (Block block3 = (Block)((BiMap<?, ?>)OXIDATION_LEVEL_DECREASES.get()).get(block);
             block3 != null;
             block3 = (Block)((BiMap<?, ?>)OXIDATION_LEVEL_DECREASES.get()).get(block3)
        ) {
            block2 = block3;
        }

        return block2;
    }

    static Optional<BlockState> getDecreasedOxidationState(BlockState state) {
        return getDecreasedOxidationBlock(state.getBlock()).map(block -> block.getStateWithProperties(state));
    }

    static Optional<Block> getIncreasedOxidationBlock(Block block) {
        return Optional.ofNullable((Block)((BiMap<?, ?>)OXIDATION_LEVEL_INCREASES.get()).get(block));
    }

    static BlockState getUnaffectedOxidationState(BlockState state) {
        return getUnaffectedOxidationBlock(state.getBlock()).getStateWithProperties(state);
    }

    @Override
    default Optional<BlockState> getDegradationResult(BlockState state) {
        return getIncreasedOxidationBlock(state.getBlock()).map(block -> block.getStateWithProperties(state));
    }

    @Override
    default float getDegradationChanceMultiplier() {
        return this.getDegradationLevel() == net.minecraft.block.Oxidizable.OxidationLevel.UNAFFECTED ? 0.75F : 1.0F;
    }
}
*/