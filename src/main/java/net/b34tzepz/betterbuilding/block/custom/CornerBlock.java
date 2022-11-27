package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.block.enums.CornerShape;
import net.b34tzepz.betterbuilding.block.enums.RelativeDirection;
import net.b34tzepz.betterbuilding.state.property.Properties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;
import java.util.stream.IntStream;

public class CornerBlock extends Block implements Waterloggable {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<RelativeDirection> DIRECTION = Properties.RELATIVE_DIRECTION;
    public static final EnumProperty<CornerShape> SHAPE = Properties.CORNER_SHAPE;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape WEST_SHAPE = SideBlock.WEST_SHAPE;
    protected static final VoxelShape EAST_SHAPE = SideBlock.EAST_SHAPE;
    protected static final VoxelShape NORTH_SHAPE = SideBlock.NORTH_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE = SideBlock.SOUTH_SHAPE;
    protected static final VoxelShape BOTTOM_NORTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 8.0, 8.0);
    protected static final VoxelShape BOTTOM_SOUTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0, 0.0, 8.0, 8.0, 8.0, 16.0);
    protected static final VoxelShape TOP_NORTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0, 8.0, 0.0, 8.0, 16.0, 8.0);
    protected static final VoxelShape TOP_SOUTH_WEST_CORNER_SHAPE = Block.createCuboidShape(0.0, 8.0, 8.0, 8.0, 16.0, 16.0);
    protected static final VoxelShape BOTTOM_NORTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 8.0, 8.0);
    protected static final VoxelShape BOTTOM_SOUTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0, 0.0, 8.0, 16.0, 8.0, 16.0);
    protected static final VoxelShape TOP_NORTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0, 8.0, 0.0, 16.0, 16.0, 8.0);
    protected static final VoxelShape TOP_SOUTH_EAST_CORNER_SHAPE = Block.createCuboidShape(8.0, 8.0, 8.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape[] WEST_SHAPES = CornerBlock.composeShapes(WEST_SHAPE, BOTTOM_SOUTH_EAST_CORNER_SHAPE, TOP_SOUTH_EAST_CORNER_SHAPE, BOTTOM_NORTH_EAST_CORNER_SHAPE, TOP_NORTH_EAST_CORNER_SHAPE);
    protected static final VoxelShape[] EAST_SHAPES = CornerBlock.composeShapes(EAST_SHAPE, BOTTOM_NORTH_WEST_CORNER_SHAPE, TOP_NORTH_WEST_CORNER_SHAPE, BOTTOM_SOUTH_WEST_CORNER_SHAPE, TOP_SOUTH_WEST_CORNER_SHAPE);
    protected static final VoxelShape[] NORTH_SHAPES = CornerBlock.composeShapes(NORTH_SHAPE, BOTTOM_SOUTH_WEST_CORNER_SHAPE, TOP_SOUTH_WEST_CORNER_SHAPE, BOTTOM_SOUTH_EAST_CORNER_SHAPE, TOP_SOUTH_EAST_CORNER_SHAPE);
    protected static final VoxelShape[] SOUTH_SHAPES = CornerBlock.composeShapes(SOUTH_SHAPE, BOTTOM_NORTH_EAST_CORNER_SHAPE, TOP_NORTH_EAST_CORNER_SHAPE, BOTTOM_NORTH_WEST_CORNER_SHAPE, TOP_NORTH_WEST_CORNER_SHAPE);
    private static final int[] SHAPE_INDICES = new int[]{3, 12, 7, 13, 11, 14, 1, 4, 2, 8};
    private final Block baseBlock;
    private final BlockState baseBlockState;

    private static VoxelShape[] composeShapes(VoxelShape base, VoxelShape bottomLeft, VoxelShape topLeft, VoxelShape bottomRight, VoxelShape topRight) {
        return IntStream.range(0, 16).mapToObj(i -> CornerBlock.composeShape(i, base, bottomLeft, topLeft, bottomRight, topRight)).toArray(VoxelShape[]::new);
    }

    private static VoxelShape composeShape(int i, VoxelShape base, VoxelShape bottomLeft, VoxelShape topLeft, VoxelShape bottomRight, VoxelShape topRight) {
        VoxelShape voxelShape = base;
        if ((i & 1) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, bottomLeft);
        }
        if ((i & 2) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, topLeft);
        }
        if ((i & 4) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, bottomRight);
        }
        if ((i & 8) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, topRight);
        }
        return voxelShape;
    }

    public CornerBlock(BlockState baseBlockState, AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((((this.stateManager.getDefaultState().with(FACING, Direction.NORTH)).with(DIRECTION, RelativeDirection.LEFT)).with(SHAPE, CornerShape.STRAIGHT)).with(WATERLOGGED, false));
        this.baseBlock = baseBlockState.getBlock();
        this.baseBlockState = baseBlockState;
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case WEST -> {
                return WEST_SHAPES[SHAPE_INDICES[this.getShapeIndexIndex(state)]];
            }
            case EAST -> {
                return EAST_SHAPES[SHAPE_INDICES[this.getShapeIndexIndex(state)]];
            }
            case SOUTH -> {
                return SOUTH_SHAPES[SHAPE_INDICES[this.getShapeIndexIndex(state)]];
            }
        }
        return NORTH_SHAPES[SHAPE_INDICES[this.getShapeIndexIndex(state)]];
    }

    private int getShapeIndexIndex(BlockState state) {
        return state.get(SHAPE).ordinal() * 2 + state.get(DIRECTION).ordinal();
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        this.baseBlock.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        this.baseBlockState.onBlockBreakStart(world, pos, player);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        this.baseBlock.onBroken(world, pos, state);
    }

    @Override
    public float getBlastResistance() {
        return this.baseBlock.getBlastResistance();
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (state.isOf(state.getBlock())) {
            return;
        }
        this.baseBlockState.neighborUpdate(world, pos, Blocks.AIR, pos, false);
        this.baseBlock.onBlockAdded(this.baseBlockState, world, pos, oldState, false);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())) {
            return;
        }
        this.baseBlockState.onStateReplaced(world, pos, newState, moved);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        this.baseBlock.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return this.baseBlock.hasRandomTicks(state);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.baseBlock.randomTick(state, world, pos, random);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.baseBlock.scheduledTick(state, world, pos, random);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return this.baseBlockState.onUse(world, player, hand, hit);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        this.baseBlock.onDestroyedByExplosion(world, pos, explosion);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        RelativeDirection relativeDirection = RelativeDirection.LEFT;
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        switch (ctx.getPlayerFacing()) {
            case EAST -> {
                if (ctx.getHitPos().z - (double) blockPos.getZ() > 0.5) {
                    relativeDirection = RelativeDirection.RIGHT;
                }
            }
            case WEST -> {
                if (ctx.getHitPos().z - (double) blockPos.getZ() < 0.5) {
                    relativeDirection = RelativeDirection.RIGHT;
                }
            }
            case NORTH -> {
                if (ctx.getHitPos().x - (double) blockPos.getX() > 0.5) {
                    relativeDirection = RelativeDirection.RIGHT;
                }
            }
            case SOUTH -> {
                if (ctx.getHitPos().x - (double) blockPos.getX() < 0.5) {
                    relativeDirection = RelativeDirection.RIGHT;
                }
            }
        }
        BlockState blockState = ((this.getDefaultState().with(FACING, ctx.getPlayerFacing())).with(DIRECTION, relativeDirection)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        return blockState.with(SHAPE, CornerBlock.getCornerShape(blockState, ctx.getWorld(), blockPos));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        if (direction.getAxis().isHorizontal()) {
            return state.with(SHAPE, CornerBlock.getCornerShape(state, world, pos));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    private static CornerShape getCornerShape(BlockState state, BlockView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockState neighborInDirection, neighborOppositeDirection;
        if (state.get(DIRECTION) == RelativeDirection.LEFT) {
            neighborInDirection = world.getBlockState(pos.offset(direction.rotateYCounterclockwise()));
            neighborOppositeDirection = world.getBlockState(pos.offset(direction.rotateYClockwise()));
        } else {
            neighborInDirection = world.getBlockState(pos.offset(direction.rotateYClockwise()));
            neighborOppositeDirection = world.getBlockState(pos.offset(direction.rotateYCounterclockwise()));
        }
        if (StairsBlock.isStairs(neighborInDirection)) {
            if (state.get(FACING) == neighborInDirection.get(FACING)) {
                if (!((neighborInDirection.get(StairsBlock.SHAPE) == StairShape.INNER_RIGHT && state.get(DIRECTION) == RelativeDirection.LEFT) ||
                        (neighborInDirection.get(StairsBlock.SHAPE) == StairShape.INNER_LEFT && state.get(DIRECTION) == RelativeDirection.RIGHT))) {
                    if (neighborInDirection.get(StairsBlock.HALF) == BlockHalf.BOTTOM) {
                        return CornerShape.OUTER_BOTTOM;
                    }
                    return CornerShape.OUTER_TOP;
                }
            }
        }
        if (StairsBlock.isStairs(neighborOppositeDirection)) {
            if (state.get(FACING) == neighborOppositeDirection.get(FACING)) {
                if (!((neighborOppositeDirection.get(StairsBlock.SHAPE) == StairShape.INNER_RIGHT && state.get(DIRECTION) == RelativeDirection.RIGHT) ||
                        (neighborOppositeDirection.get(StairsBlock.SHAPE) == StairShape.INNER_LEFT && state.get(DIRECTION) == RelativeDirection.LEFT))) {
                    if (neighborOppositeDirection.get(StairsBlock.HALF) == BlockHalf.BOTTOM) {
                        return CornerShape.INNER_BOTTOM;
                    }
                    return CornerShape.INNER_TOP;
                }
            }
        }
        return CornerShape.STRAIGHT;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        Direction direction = state.get(FACING);
        CornerShape cornerShape = state.get(SHAPE);
        switch (mirror) {
            case LEFT_RIGHT -> {
                if (direction.getAxis() != Direction.Axis.Z) break;
                switch (cornerShape) {
                    case INNER_BOTTOM -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.INNER_TOP);
                    }
                    case INNER_TOP -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.INNER_BOTTOM);
                    }
                    case OUTER_BOTTOM -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.OUTER_TOP);
                    }
                    case OUTER_TOP -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.OUTER_BOTTOM);
                    }
                }
                return state.rotate(BlockRotation.CLOCKWISE_180);
            }
            case FRONT_BACK -> {
                if (direction.getAxis() != Direction.Axis.X) break;
                switch (cornerShape) {
                    case INNER_BOTTOM -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.INNER_BOTTOM);
                    }
                    case INNER_TOP -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.INNER_TOP);
                    }
                    case OUTER_BOTTOM -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.OUTER_TOP);
                    }
                    case OUTER_TOP -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.OUTER_BOTTOM);
                    }
                    case STRAIGHT -> {
                        return state.rotate(BlockRotation.CLOCKWISE_180);
                    }
                }
            }
        }
        return super.mirror(state, mirror);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, DIRECTION, SHAPE, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
