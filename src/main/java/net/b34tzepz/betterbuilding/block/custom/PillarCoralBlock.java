package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class PillarCoralBlock extends PillarBlock{
    private final Block deadCoralBlock;

    public PillarCoralBlock(Block deadCoralBlock, Settings settings) {
        super(settings);
        this.deadCoralBlock = deadCoralBlock;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!this.isInWater(world, pos)) {
            world.setBlockState(pos, this.deadCoralBlock.getDefaultState(), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!this.isInWater(world, pos)) {
            world.createAndScheduleBlockTick(pos, this, 60 + world.getRandom().nextInt(40));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected boolean isInWater(BlockView world, BlockPos pos) {
        if(world.getBlockState(pos).getBlock() instanceof PillarCoralBlock && world.getBlockState(pos).get(WATERLOGGED)){
            return true;
        }
        for (Direction direction : Direction.values()) {
            FluidState fluidState = world.getFluidState(pos.offset(direction));
            if (!fluidState.isIn(FluidTags.WATER)) continue;
            return true;
        }
        return false;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (!this.isInWater(ctx.getWorld(), ctx.getBlockPos())) {
            ctx.getWorld().createAndScheduleBlockTick(ctx.getBlockPos(), this, 60 + ctx.getWorld().getRandom().nextInt(40));
        }
        return super.getPlacementState(ctx);
    }
}
