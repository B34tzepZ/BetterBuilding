package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.state.property.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class PillarBlock extends net.minecraft.block.PillarBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape firstLayer = Block.createCuboidShape(0, 0, 6, 1, 16, 10);
    protected static final VoxelShape secondLayer = Block.createCuboidShape(1, 0, 4, 2, 16, 12);
    protected static final VoxelShape thirdLayer = Block.createCuboidShape(2, 0, 3, 3, 16, 13);
    protected static final VoxelShape fourthLayer = Block.createCuboidShape(3, 0, 2, 4, 16, 14);
    protected static final VoxelShape fifthLayer = Block.createCuboidShape(4, 0, 1, 6, 16, 15);
    protected static final VoxelShape sixthLayer = Block.createCuboidShape(6, 0, 0, 10, 16, 16);
    protected static final VoxelShape seventhLayer = Block.createCuboidShape(10, 0, 1, 12, 16, 15);
    protected static final VoxelShape eighthLayer = Block.createCuboidShape(12, 0, 2, 13, 16, 14);
    protected static final VoxelShape ninthLayer = Block.createCuboidShape(13, 0, 3, 14, 16, 13);
    protected static final VoxelShape tenthLayer = Block.createCuboidShape(14, 0, 4, 15, 16, 12);
    protected static final VoxelShape eleventhLayer = Block.createCuboidShape(15, 0, 6, 16, 16, 10);
    protected static final VoxelShape yShape = VoxelShapes.union(firstLayer, secondLayer, thirdLayer, fourthLayer, fifthLayer, sixthLayer, seventhLayer, eighthLayer, ninthLayer, tenthLayer, eleventhLayer);
    protected static final VoxelShape xShape = VoxelShapes.union(rotateCuboidVoxelShapeBy90(firstLayer, Direction.Axis.X), rotateCuboidVoxelShapeBy90(secondLayer, Direction.Axis.X), rotateCuboidVoxelShapeBy90(thirdLayer, Direction.Axis.X),
            rotateCuboidVoxelShapeBy90(fourthLayer, Direction.Axis.X), rotateCuboidVoxelShapeBy90(fifthLayer, Direction.Axis.X), rotateCuboidVoxelShapeBy90(sixthLayer, Direction.Axis.X),
            rotateCuboidVoxelShapeBy90(seventhLayer, Direction.Axis.X), rotateCuboidVoxelShapeBy90(eighthLayer, Direction.Axis.X), rotateCuboidVoxelShapeBy90(ninthLayer, Direction.Axis.X),
            rotateCuboidVoxelShapeBy90(tenthLayer, Direction.Axis.X), rotateCuboidVoxelShapeBy90(eleventhLayer, Direction.Axis.X));
    protected static final VoxelShape zShape = VoxelShapes.union(rotateCuboidVoxelShapeBy90(firstLayer, Direction.Axis.Z), rotateCuboidVoxelShapeBy90(secondLayer, Direction.Axis.Z), rotateCuboidVoxelShapeBy90(thirdLayer, Direction.Axis.Z),
            rotateCuboidVoxelShapeBy90(fourthLayer, Direction.Axis.Z), rotateCuboidVoxelShapeBy90(fifthLayer, Direction.Axis.Z), rotateCuboidVoxelShapeBy90(sixthLayer, Direction.Axis.Z),
            rotateCuboidVoxelShapeBy90(seventhLayer, Direction.Axis.Z), rotateCuboidVoxelShapeBy90(eighthLayer, Direction.Axis.Z), rotateCuboidVoxelShapeBy90(ninthLayer, Direction.Axis.Z),
            rotateCuboidVoxelShapeBy90(tenthLayer, Direction.Axis.Z), rotateCuboidVoxelShapeBy90(eleventhLayer, Direction.Axis.Z));

    public PillarBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis()).with(WATERLOGGED,fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(AXIS))  {
            case X -> {
                return xShape;
            }
            case Z -> {
                return zShape;
            }
        }
        return yShape;
    }

    private static VoxelShape rotateCuboidVoxelShapeBy90(VoxelShape voxelShape, Direction.Axis axis) {
        Vec3d min = new Vec3d(voxelShape.getMin(Direction.Axis.X) * 16, voxelShape.getMin(Direction.Axis.Y) * 16, voxelShape.getMin(Direction.Axis.Z) * 16);
        Vec3d max = new Vec3d(voxelShape.getMax(Direction.Axis.X) * 16, voxelShape.getMax(Direction.Axis.Y) * 16, voxelShape.getMax(Direction.Axis.Z) * 16);
        Vec3d translation = new Vec3d(-8, -8, -8);

        min = min.add(translation);
        max = max.add(translation);

        switch (axis) {
            case X -> {
                min = new Vec3d(-min.y, min.x, min.z);
                max = new Vec3d(-max.y, max.x, max.z);
            }
            case Y -> {
                min = new Vec3d(min.z, min.y, -min.x);
                max = new Vec3d(max.z, max.y, -max.x);
            }
            case Z -> {
                min = new Vec3d(min.x, -min.z, min.y);
                max = new Vec3d(max.x, -max.z, max.y);
            }
        }

        min = min.add(translation.negate());
        max = max.add(translation.negate());

        if (min.x > max.x){
            double buffer = min.x;
            min = new Vec3d(max.x, min.y, min.z);
            max = new Vec3d(buffer, max.y, max.z);
        }
        if (min.y > max.y){
            double buffer = min.y;
            min = new Vec3d(min.x, max.y, min.z);
            max = new Vec3d(max.x, buffer, max.z);
        }
        if (min.z > max.z){
            double buffer = min.z;
            min = new Vec3d(min.x, min.y, max.z);
            max = new Vec3d(max.x, max.y, buffer);
        }
        return Block.createCuboidShape(min.x, min.y, min.z, max.x, max.y, max.z);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return Fluids.EMPTY.getDefaultState();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, WATERLOGGED);
    }
}
