package net.b34tzepz.betterbuilding.block.custom;

import com.google.common.collect.Maps;
import net.b34tzepz.betterbuilding.block.enums.CornerDirection;
import net.b34tzepz.betterbuilding.block.enums.CornerShape;
import net.b34tzepz.betterbuilding.state.property.ModProperties;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

import java.util.Map;

public class CornerBlock extends Block implements Waterloggable {
    public static final EnumProperty<CornerDirection> DIRECTION = ModProperties.CORNER_DIRECTION;
    public static final EnumProperty<CornerShape> SHAPE = ModProperties.CORNER_SHAPE;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape BOTTOM_NORTH_WEST_CUBE = Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 8.0, 8.0);
    protected static final VoxelShape BOTTOM_SOUTH_WEST_CUBE = Block.createCuboidShape(0.0, 0.0, 8.0, 8.0, 8.0, 16.0);
    protected static final VoxelShape TOP_NORTH_WEST_CUBE = Block.createCuboidShape(0.0, 8.0, 0.0, 8.0, 16.0, 8.0);
    protected static final VoxelShape TOP_SOUTH_WEST_CUBE = Block.createCuboidShape(0.0, 8.0, 8.0, 8.0, 16.0, 16.0);
    protected static final VoxelShape BOTTOM_NORTH_EAST_CUBE = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 8.0, 8.0);
    protected static final VoxelShape BOTTOM_SOUTH_EAST_CUBE = Block.createCuboidShape(8.0, 0.0, 8.0, 16.0, 8.0, 16.0);
    protected static final VoxelShape TOP_NORTH_EAST_CUBE = Block.createCuboidShape(8.0, 8.0, 0.0, 16.0, 16.0, 8.0);
    protected static final VoxelShape TOP_SOUTH_EAST_CUBE = Block.createCuboidShape(8.0, 8.0, 8.0, 16.0, 16.0, 16.0);
    private static final VoxelShape OUTER_DOUBLE_SHAPE = VoxelShapes.union(BOTTOM_NORTH_WEST_CUBE, BOTTOM_NORTH_EAST_CUBE, BOTTOM_SOUTH_EAST_CUBE, TOP_NORTH_EAST_CUBE);
    private static final VoxelShape OUTER_SHAPE = VoxelShapes.union(OUTER_DOUBLE_SHAPE, TOP_SOUTH_EAST_CUBE);
    private static final VoxelShape STRAIGHT_SHAPE = VoxelShapes.union(OUTER_SHAPE, TOP_NORTH_WEST_CUBE);
    private static final VoxelShape INNER_SHAPE = VoxelShapes.union(STRAIGHT_SHAPE, BOTTOM_SOUTH_WEST_CUBE);
    private static final Map<CornerDirection, VoxelShape> OUTER_DOUBLE_BOTTOM_SHAPES = createHorizontalFacingShapeMap(OUTER_DOUBLE_SHAPE);
    private static final Map<CornerDirection, VoxelShape> OUTER_PREV_BOTTOM_SHAPES = createHorizontalFacingShapeMap(OUTER_SHAPE);
    private static final Map<CornerDirection, VoxelShape> OUTER_NEXT_BOTTOM_SHAPES = createHorizontalFacingShapeMap(VoxelShapes.transform(OUTER_SHAPE, DirectionTransformation.ROT_120_NPP));
    private static final Map<CornerDirection, VoxelShape> STRAIGHT_SHAPES = createHorizontalFacingShapeMap(STRAIGHT_SHAPE);
    private static final Map<CornerDirection, VoxelShape> INNER_BOTTOM_SHAPES = createHorizontalFacingShapeMap(INNER_SHAPE);
    private static final Map<CornerDirection, VoxelShape> OUTER_DOUBLE_TOP_SHAPES = createHorizontalFacingShapeMap(VoxelShapes.transform(OUTER_DOUBLE_SHAPE,  DirectionTransformation.INVERT_Y));
    private static final Map<CornerDirection, VoxelShape> OUTER_PREV_TOP_SHAPES = createHorizontalFacingShapeMap(VoxelShapes.transform(OUTER_SHAPE,  DirectionTransformation.INVERT_Y));
    private static final Map<CornerDirection, VoxelShape> OUTER_NEXT_TOP_SHAPES = createHorizontalFacingShapeMap(VoxelShapes.transform(VoxelShapes.transform(OUTER_SHAPE, DirectionTransformation.ROT_120_NPP),  DirectionTransformation.INVERT_Y));
    private static final Map<CornerDirection, VoxelShape> INNER_TOP_SHAPES = createHorizontalFacingShapeMap(VoxelShapes.transform(INNER_SHAPE, DirectionTransformation.INVERT_Y));

    private static Map<CornerDirection, VoxelShape> createHorizontalFacingShapeMap(VoxelShape shape) {
        return Maps.newEnumMap(Map.of(
                        CornerDirection.NORTHEAST,
                        shape,
                        CornerDirection.SOUTHEAST,
                        VoxelShapes.transform(shape, DirectionTransformation.ROT_90_Y_NEG),
                        CornerDirection.SOUTHWEST,
                        VoxelShapes.transform(shape, DirectionTransformation.ROT_180_FACE_XZ),
                        CornerDirection.NORTHWEST,
                        VoxelShapes.transform(shape, DirectionTransformation.ROT_90_Y_POS)
                )
        );
    }

    public CornerBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(DIRECTION, CornerDirection.NORTHEAST)
                .with(SHAPE, CornerShape.STRAIGHT)
                .with(WATERLOGGED, false));
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Map<CornerDirection, VoxelShape> shapes = switch (state.get(SHAPE)) {
            case STRAIGHT -> STRAIGHT_SHAPES;
            case INNER_BOTTOM -> INNER_BOTTOM_SHAPES;
            case INNER_TOP -> INNER_TOP_SHAPES;
            case OUTER_NEXT_BOTTOM -> OUTER_NEXT_BOTTOM_SHAPES;
            case OUTER_NEXT_TOP -> OUTER_NEXT_TOP_SHAPES;
            case OUTER_PREV_BOTTOM -> OUTER_PREV_BOTTOM_SHAPES;
            case OUTER_PREV_TOP -> OUTER_PREV_TOP_SHAPES;
            case OUTER_DOUBLE_BOTTOM -> OUTER_DOUBLE_BOTTOM_SHAPES;
            case OUTER_DOUBLE_TOP -> OUTER_DOUBLE_TOP_SHAPES;
        };
        return shapes.get(state.get(DIRECTION));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        CornerDirection cornerDirection = CornerDirection.NORTHWEST;
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);

        switch (ctx.getHorizontalPlayerFacing()) {
            case NORTH -> {
                if (ctx.getHitPos().x - (double) blockPos.getX() > 0.5) {
                    cornerDirection = CornerDirection.NORTHEAST;
                }
            }
            case EAST -> {
                if (ctx.getHitPos().z - (double) blockPos.getZ() < 0.5) {
                    cornerDirection = CornerDirection.NORTHEAST;
                } else {
                    cornerDirection = CornerDirection.SOUTHEAST;
                }
            }
            case SOUTH -> {
                if (ctx.getHitPos().x - (double) blockPos.getX() > 0.5) {
                    cornerDirection = CornerDirection.SOUTHEAST;
                } else {
                    cornerDirection = CornerDirection.SOUTHWEST;
                }
            }
            case WEST -> {
                if (ctx.getHitPos().z - (double) blockPos.getZ() > 0.5) {
                    cornerDirection = CornerDirection.SOUTHWEST;
                }
            }
        }
        BlockState blockState = this.getDefaultState().with(DIRECTION, cornerDirection).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        return blockState.with(SHAPE, getCornerShape(blockState, ctx.getWorld(), blockPos));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction,
                                                BlockPos neighborPos, BlockState neighborState, Random random) {
        if (state.get(WATERLOGGED)) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        if (direction.getAxis().isHorizontal()) {
            return state.with(SHAPE, getCornerShape(state, world, pos));
        }
        return state;
    }

    private static CornerShape getCornerShape(BlockState state, BlockView world, BlockPos pos) {
        Direction blockDirectionNS = Direction.valueOf(state.get(DIRECTION).asString().substring(0, 5).toUpperCase());
        Direction blockDirectionEW = Direction.valueOf(state.get(DIRECTION).asString().substring(5, 9).toUpperCase());
        BlockState neighborNS = world.getBlockState(pos.offset(blockDirectionNS.getOpposite())); // Nachbarn an den offenen Seiten der Corner
        BlockState neighborEW = world.getBlockState(pos.offset(blockDirectionEW.getOpposite()));

        CornerDirection compareDirection = CornerDirection.values()[Math.floorMod(state.get(DIRECTION).ordinal() + 1, CornerDirection.values().length)]; // nächste CornerDirection im Enum
        Direction compareDirectionNS = Direction.valueOf(compareDirection.asString().substring(0, 5).toUpperCase());
        Direction compareDirectionEW = Direction.valueOf(compareDirection.asString().substring(5, 9).toUpperCase());

        if (compareDirectionNS == blockDirectionNS) { // gucken welche Directionkomponente erhalten bleibt
            if (innerCheckNext(neighborEW, blockDirectionNS) != CornerShape.STRAIGHT) {
                return innerCheckNext(neighborEW, blockDirectionNS);
            }
        } else if (compareDirectionEW == blockDirectionEW) {
            if (innerCheckNext(neighborNS, blockDirectionEW) != CornerShape.STRAIGHT) {
                return innerCheckNext(neighborNS, blockDirectionEW);
            }
        }

        compareDirection = CornerDirection.values()[Math.floorMod(state.get(DIRECTION).ordinal() - 1, CornerDirection.values().length)]; //vorherige CornerDirection im Enum
        compareDirectionNS = Direction.valueOf(compareDirection.asString().substring(0, 5).toUpperCase());
        compareDirectionEW = Direction.valueOf(compareDirection.asString().substring(5, 9).toUpperCase());

        if (compareDirectionNS == blockDirectionNS) {
            if (innerCheckPrev(neighborEW, blockDirectionNS) != CornerShape.STRAIGHT) {
                return innerCheckPrev(neighborEW, blockDirectionNS);
            }
        } else if (compareDirectionEW == blockDirectionEW) {
            if (innerCheckPrev(neighborNS, blockDirectionEW) != CornerShape.STRAIGHT) {
                return innerCheckPrev(neighborNS, blockDirectionEW);
            }
        }

        Direction clockwiseDirection = compareDirections(blockDirectionNS, blockDirectionEW);
        Direction counterClockwiseDirection = compareDirections(blockDirectionNS, blockDirectionEW).rotateYCounterclockwise();
        BlockState clockwiseNeighbor = world.getBlockState(pos.offset(clockwiseDirection));
        BlockState counterClockwiseNeighbor =  world.getBlockState(pos.offset(counterClockwiseDirection));
        CornerShape tempShape = CornerShape.STRAIGHT;

        if (StairsBlock.isStairs(clockwiseNeighbor)) {
            if (clockwiseNeighbor.get(StairsBlock.FACING) == counterClockwiseDirection) {
                if (!(clockwiseNeighbor.get(StairsBlock.SHAPE) == StairShape.INNER_LEFT || clockwiseNeighbor.get(StairsBlock.SHAPE) == StairShape.OUTER_RIGHT)) {
                    tempShape = clockwiseNeighbor.get(StairsBlock.HALF) == BlockHalf.BOTTOM ? CornerShape.OUTER_NEXT_BOTTOM : CornerShape.OUTER_NEXT_TOP;
                }
            }
        }

        if (StairsBlock.isStairs(counterClockwiseNeighbor)) {
            if (counterClockwiseNeighbor.get(StairsBlock.FACING) == clockwiseDirection) {
                if (!(counterClockwiseNeighbor.get(StairsBlock.SHAPE) == StairShape.INNER_RIGHT || counterClockwiseNeighbor.get(StairsBlock.SHAPE) == StairShape.OUTER_LEFT)) {
                    if (tempShape != CornerShape.STRAIGHT) {
                        if (counterClockwiseNeighbor.get(StairsBlock.HALF) == clockwiseNeighbor.get(StairsBlock.HALF)) {
                            return counterClockwiseNeighbor.get(StairsBlock.HALF) == BlockHalf.BOTTOM ? CornerShape.OUTER_DOUBLE_BOTTOM : CornerShape.OUTER_DOUBLE_TOP;
                        } else {
                            return CornerShape.STRAIGHT;
                        }
                    } else {
                        return  counterClockwiseNeighbor.get(StairsBlock.HALF) == BlockHalf.BOTTOM ? CornerShape.OUTER_PREV_BOTTOM : CornerShape.OUTER_PREV_TOP;
                    }
                }
            }
        }
        return tempShape;
    }

    private static Direction compareDirections(Direction a, Direction b) { // ermittelt von zwei benachbarten Directions welche im Uhrzeigersinn später kommt
        if (a.getHorizontalQuarterTurns() == 0 && b.getHorizontalQuarterTurns() == 3) return a;
        if (a.getHorizontalQuarterTurns() > b.getHorizontalQuarterTurns()) return a;
        return b;
    }

    private static CornerShape innerCheckNext(BlockState neighbor, Direction direction) {
        if  (StairsBlock.isStairs(neighbor)) {
            if (neighbor.get(StairsBlock.FACING) == direction) {
                if (!(neighbor.get(StairsBlock.SHAPE) == StairShape.INNER_LEFT || neighbor.get(StairsBlock.SHAPE) == StairShape.OUTER_RIGHT)) {
                    if (neighbor.get(StairsBlock.HALF) == BlockHalf.BOTTOM) {
                        return CornerShape.INNER_BOTTOM;
                    }
                    return CornerShape.INNER_TOP;
                }
            }
        }
        return CornerShape.STRAIGHT;
    }

    private static CornerShape innerCheckPrev(BlockState neighbor, Direction direction) {
        if  (StairsBlock.isStairs(neighbor)) {
            if (neighbor.get(StairsBlock.FACING) == direction) {
                if (!(neighbor.get(StairsBlock.SHAPE) == StairShape.INNER_RIGHT || neighbor.get(StairsBlock.SHAPE) == StairShape.OUTER_LEFT)) {
                    if(neighbor.get(StairsBlock.HALF) == BlockHalf.BOTTOM) {
                        return CornerShape.INNER_BOTTOM;
                    }
                    return CornerShape.INNER_TOP;
                }
            }
        }
        return CornerShape.STRAIGHT;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, SHAPE, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return Fluids.EMPTY.getDefaultState();
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
