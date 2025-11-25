package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class PillarSoulSandBlock extends PillarBlock{
    protected static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0);

    public PillarSoulSandBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.fullCube();
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BubbleColumnBlock.update(world, pos.up(), state);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (direction == Direction.UP && neighborState.isOf(Blocks.WATER)) {
            tickView.scheduleBlockTick(pos, this, 20);
        }
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.scheduleBlockTick(pos, this, 20);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 0.2f;
    }
}
