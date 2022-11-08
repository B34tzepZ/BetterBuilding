package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.block.enums.ChairType;
import net.b34tzepz.betterbuilding.block.enums.SideType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class OakChairBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<ChairType> TYPE = net.b34tzepz.betterbuilding.state.property.Properties.CHAIR_TYPE;

    public OakChairBlock(Settings settings){
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        //this.setDefaultState((this.getDefaultState().with(TYPE, ChairType.NORTH)));
    }

    //TODO: VoxelShape dreht sich nicht korrekt mit
    private static final VoxelShape NORTH_SHAPE = Stream.of(
            Block.createCuboidShape(0, 12, 2, 2, 14, 15),
            Block.createCuboidShape(14, 0, 0, 16, 10, 2),
            Block.createCuboidShape(0, 0, 14, 2, 10, 16),
            Block.createCuboidShape(0, 0, 0, 2, 10, 2),
            Block.createCuboidShape(14, 12, 2, 16, 14, 15),
            Block.createCuboidShape(14, 12, 0, 16, 28, 2),
            Block.createCuboidShape(0, 12, 0, 2, 28, 2),
            Block.createCuboidShape(2, 12, 0, 14, 28, 2),
            Block.createCuboidShape(0, 10, 0, 16, 12, 16),
            Block.createCuboidShape(14, 0, 14, 16, 10, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(); //Block.createCuboidShape();

    private static final VoxelShape EAST_SHAPE = Stream.of(
            Block.createCuboidShape(1, 12, 0, 14, 14, 2),
            Block.createCuboidShape(14, 0, 14, 16, 10, 16),
            Block.createCuboidShape(0, 0, 0, 2, 10, 2),
            Block.createCuboidShape(14, 0, 0, 16, 10, 2),
            Block.createCuboidShape(1, 12, 14, 14, 14, 16),
            Block.createCuboidShape(14, 12, 14, 16, 28, 16),
            Block.createCuboidShape(14, 12, 0, 16, 28, 2),
            Block.createCuboidShape(14, 12, 2, 16, 28, 14),
            Block.createCuboidShape(0, 10, 0, 16, 12, 16),
            Block.createCuboidShape(0, 0, 14, 2, 10, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SOUTH_SHAPE = Stream.of(
            Block.createCuboidShape(14, 12, 1, 16, 14, 14),
            Block.createCuboidShape(0, 0, 14, 2, 10, 16),
            Block.createCuboidShape(14, 0, 0, 16, 10, 2),
            Block.createCuboidShape(14, 0, 14, 16, 10, 16),
            Block.createCuboidShape(0, 12, 1, 2, 14, 14),
            Block.createCuboidShape(0, 12, 14, 2, 28, 16),
            Block.createCuboidShape(14, 12, 14, 16, 28, 16),
            Block.createCuboidShape(2, 12, 14, 14, 28, 16),
            Block.createCuboidShape(0, 10, 0, 16, 12, 16),
            Block.createCuboidShape(0, 0, 0, 2, 10, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape WEST_SHAPE = Stream.of(
            Block.createCuboidShape(2, 12, 14, 15, 14, 16),
            Block.createCuboidShape(0, 0, 0, 2, 10, 2),
            Block.createCuboidShape(14, 0, 14, 16, 10, 16),
            Block.createCuboidShape(0, 0, 14, 2, 10, 16),
            Block.createCuboidShape(2, 12, 0, 15, 14, 2),
            Block.createCuboidShape(0, 12, 0, 2, 28, 2),
            Block.createCuboidShape(0, 12, 14, 2, 28, 16),
            Block.createCuboidShape(0, 12, 2, 2, 28, 14),
            Block.createCuboidShape(0, 10, 0, 16, 12, 16),
            Block.createCuboidShape(14, 0, 0, 16, 10, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        switch (dir){
            case NORTH:
                return NORTH_SHAPE;

            case SOUTH:
                return SOUTH_SHAPE;

            case WEST:
                return WEST_SHAPE;

            case EAST:
                return EAST_SHAPE;
        }
        //ChairType chairType = state.get(TYPE);
        //System.out.println(chairType);
        /*switch (chairType) {
            case WEST -> {
                return WEST_SHAPE;
            }
            case EAST -> {
                return EAST_SHAPE;
            }
            case SOUTH -> {
                return SOUTH_SHAPE;
            }
        }*/
        return NORTH_SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing()); //.getOpposite()
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
