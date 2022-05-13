package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.block.enums.SideType;
import net.b34tzepz.betterbuilding.state.property.Properties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class SideBlock extends Block implements Waterloggable {
    public static final EnumProperty<SideType> TYPE = Properties.SIDE_TYPE;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0);    //x: west -> east
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0);    //z: north -> south
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0);

    public SideBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((this.getDefaultState().with(TYPE, SideType.NORTH)).with(WATERLOGGED, false));
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return state.get(TYPE) != SideType.DOUBLE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        SideType sideType = state.get(TYPE);
        switch (sideType) {
            case DOUBLE -> {
                return VoxelShapes.fullCube();
            }
            case WEST -> {
                return WEST_SHAPE;
            }
            case EAST -> {
                return EAST_SHAPE;
            }
            case SOUTH -> {
                return SOUTH_SHAPE;
            }
        }
        return NORTH_SHAPE;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = ctx.getWorld().getBlockState(blockPos);
        if (blockState.isOf(this)) {
            return (blockState.with(TYPE, SideType.DOUBLE)).with(WATERLOGGED, false);
        }
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        BlockState blockStateDefault = (this.getDefaultState().with(TYPE, SideType.NORTH)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        Direction clickedOn = ctx.getSide();
        Direction facing = ctx.getPlayerFacing();
        if (clickedOn == Direction.EAST || clickedOn == Direction.WEST) {
            if (ctx.getHitPos().z - (double) blockPos.getZ() <= 0.5) {
                return blockStateDefault.with(TYPE, SideType.NORTH);
            } else {
                return blockStateDefault.with(TYPE, SideType.SOUTH);
            }
        }
        if (clickedOn == Direction.NORTH || clickedOn == Direction.SOUTH) {
            if (ctx.getHitPos().x - (double) blockPos.getX() <= 0.5) {
                return blockStateDefault.with(TYPE, SideType.WEST);
            } else {
                return blockStateDefault.with(TYPE, SideType.EAST);
            }
        }
        if (facing == Direction.EAST || facing == Direction.WEST) {
            if (ctx.getHitPos().z - (double) blockPos.getZ() <= 0.5) {
                return blockStateDefault.with(TYPE, SideType.NORTH);
            } else {
                return blockStateDefault.with(TYPE, SideType.SOUTH);
            }
        }
        if (ctx.getHitPos().x - (double) blockPos.getX() <= 0.5) {
            return blockStateDefault.with(TYPE, SideType.WEST);
        }
        return blockStateDefault.with(TYPE, SideType.EAST);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        ItemStack itemStack = context.getStack();
        SideType sideType = state.get(TYPE);
        if (sideType == SideType.DOUBLE || !itemStack.isOf(this.asItem())) {
            return false;
        }
        if (context.canReplaceExisting()) {
            boolean eastClicked = context.getHitPos().x - (double) context.getBlockPos().getX() > 0.5;
            boolean southClicked = context.getHitPos().z - (double) context.getBlockPos().getZ() > 0.5;
            Direction direction = context.getSide();
            if (sideType == SideType.WEST) {
                return direction == Direction.EAST || eastClicked && direction.getAxis().isVertical();
            }
            if (sideType == SideType.EAST) {
                return direction == Direction.WEST || !eastClicked && direction.getAxis().isVertical();
            }
            if (sideType == SideType.NORTH) {
                return direction == Direction.SOUTH || southClicked && direction.getAxis().isVertical();
            }
            return direction == Direction.NORTH || !southClicked && direction.getAxis().isVertical();
        }
        return true;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (state.get(TYPE) != SideType.DOUBLE) {
            return Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState);
        }
        return false;
    }

    @Override
    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        if (state.get(TYPE) != SideType.DOUBLE) {
            return Waterloggable.super.canFillWithFluid(world, pos, state, fluid);
        }
        return false;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        if (type == NavigationType.WATER) {
            return world.getFluidState(pos).isIn(FluidTags.WATER);
        }
        return false;
    }

}
