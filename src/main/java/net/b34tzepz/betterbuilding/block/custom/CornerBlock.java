package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.block.enums.CornerShape;
import net.b34tzepz.betterbuilding.state.property.Properties;
import net.minecraft.block.*;
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
    public static final DirectionProperty HALF = Properties.HORIZONTAL_FACING;
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
    protected static final VoxelShape[] WEST_SHAPES = CornerBlock.composeShapes(WEST_SHAPE, BOTTOM_NORTH_EAST_CORNER_SHAPE, TOP_NORTH_EAST_CORNER_SHAPE, BOTTOM_SOUTH_EAST_CORNER_SHAPE, TOP_SOUTH_EAST_CORNER_SHAPE);
    protected static final VoxelShape[] EAST_SHAPES = CornerBlock.composeShapes(EAST_SHAPE, BOTTOM_NORTH_WEST_CORNER_SHAPE, TOP_NORTH_WEST_CORNER_SHAPE, BOTTOM_SOUTH_WEST_CORNER_SHAPE, TOP_SOUTH_WEST_CORNER_SHAPE);
    protected static final VoxelShape[] NORTH_SHAPES = CornerBlock.composeShapes(NORTH_SHAPE, BOTTOM_SOUTH_WEST_CORNER_SHAPE, TOP_SOUTH_WEST_CORNER_SHAPE, BOTTOM_SOUTH_EAST_CORNER_SHAPE, TOP_SOUTH_EAST_CORNER_SHAPE);
    protected static final VoxelShape[] SOUTH_SHAPES = CornerBlock.composeShapes(SOUTH_SHAPE, BOTTOM_NORTH_WEST_CORNER_SHAPE, TOP_NORTH_WEST_CORNER_SHAPE, BOTTOM_NORTH_EAST_CORNER_SHAPE, TOP_NORTH_EAST_CORNER_SHAPE);
    /*
    12: South 5: West 3: North 10: East
    14: NONorthWest 13: NONorthEast 7: NOSouthEast 11: NOSouthWest
    8: SouthEast 4: SouthWest 1: NorthWest 2: NorthEast
    [0,3]: Straight [4,7]: Inner_Left [8,11]: Inner_Right [12,15]: Outer_Left [16,19]: Outer_Right
    */
    private static final int[] SHAPE_INDICES = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};
    private final Block baseBlock;
    private final BlockState baseBlockState;

    private static VoxelShape[] composeShapes(VoxelShape base, VoxelShape northWest, VoxelShape northEast, VoxelShape southWest, VoxelShape southEast) {
        return IntStream.range(0, 16).mapToObj(i -> CornerBlock.composeShape(i, base, northWest, northEast, southWest, southEast)).toArray(VoxelShape[]::new);
    }

    private static VoxelShape composeShape(int i, VoxelShape base, VoxelShape northWest, VoxelShape northEast, VoxelShape southWest, VoxelShape southEast) {
        VoxelShape voxelShape = base;
        if ((i & 1) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, northWest);
        }
        if ((i & 2) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, northEast);
        }
        if ((i & 4) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, southWest);
        }
        if ((i & 8) != 0) {
            voxelShape = VoxelShapes.union(voxelShape, southEast);
        }
        return voxelShape;
    }

    public CornerBlock(BlockState baseBlockState, AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(((((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(HALF, Direction.WEST)).with(SHAPE, CornerShape.STRAIGHT)).with(WATERLOGGED, false));
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
        return state.get(SHAPE).ordinal() * 4 + state.get(FACING).getHorizontal();
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
        //Direction direction = ctx.getSide();
        Direction direction = Direction.EAST;
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        if (ctx.getPlayerFacing().getHorizontal() % 2 == 1) {
            if (ctx.getHitPos().z - (double) blockPos.getZ() < 0.5) {
                direction = Direction.NORTH;
            } else {
                direction = Direction.SOUTH;
            }
        } else if (ctx.getHitPos().x - (double) blockPos.getX() < 0.5) {
            direction = Direction.WEST;
        }

        BlockState blockState = ((this.getDefaultState().with(FACING, ctx.getPlayerFacing())).with(HALF, direction)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
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
        Direction direction3;
        Direction direction2;
        Direction direction = state.get(FACING);
        BlockState blockState = world.getBlockState(pos.offset(direction));
        if (CornerBlock.isCorner(blockState) && state.get(HALF) == blockState.get(HALF) && (direction2 = blockState.get(FACING)).getAxis() != state.get(FACING).getAxis() && CornerBlock.isDifferentOrientation(state, world, pos, direction2.getOpposite())) {
            if (direction2 == direction.rotateYCounterclockwise()) {
                return CornerShape.OUTER_LEFT;
            }
            return CornerShape.OUTER_RIGHT;
        }
        BlockState blockState2 = world.getBlockState(pos.offset(direction.getOpposite()));
        if (CornerBlock.isCorner(blockState2) && state.get(HALF) == blockState2.get(HALF) && (direction3 = blockState2.get(FACING)).getAxis() != state.get(FACING).getAxis() && CornerBlock.isDifferentOrientation(state, world, pos, direction3)) {
            if (direction3 == direction.rotateYCounterclockwise()) {
                return CornerShape.INNER_LEFT;
            }
            return CornerShape.INNER_RIGHT;
        }
        return CornerShape.STRAIGHT;
    }

    private static boolean isDifferentOrientation(BlockState state, BlockView world, BlockPos pos, Direction dir) {
        BlockState blockState = world.getBlockState(pos.offset(dir));
        return !CornerBlock.isCorner(blockState) || blockState.get(FACING) != state.get(FACING) || blockState.get(HALF) != state.get(HALF);
    }

    public static boolean isCorner(BlockState state) {
        return state.getBlock() instanceof CornerBlock;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        Direction direction = state.get(FACING);
        CornerShape stairShape = state.get(SHAPE);
        switch (mirror) {
            case LEFT_RIGHT: {
                if (direction.getAxis() != Direction.Axis.Z) break;
                switch (stairShape) {
                    case INNER_LEFT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.INNER_RIGHT);
                    }
                    case INNER_RIGHT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.INNER_LEFT);
                    }
                    case OUTER_LEFT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.OUTER_RIGHT);
                    }
                    case OUTER_RIGHT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.OUTER_LEFT);
                    }
                }
                return state.rotate(BlockRotation.CLOCKWISE_180);
            }
            case FRONT_BACK: {
                if (direction.getAxis() != Direction.Axis.X) break;
                switch (stairShape) {
                    case INNER_LEFT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.INNER_LEFT);
                    }
                    case INNER_RIGHT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.INNER_RIGHT);
                    }
                    case OUTER_LEFT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.OUTER_RIGHT);
                    }
                    case OUTER_RIGHT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180).with(SHAPE, CornerShape.OUTER_LEFT);
                    }
                    case STRAIGHT: {
                        return state.rotate(BlockRotation.CLOCKWISE_180);
                    }
                }
                break;
            }
        }
        return super.mirror(state, mirror);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, SHAPE, WATERLOGGED);
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
