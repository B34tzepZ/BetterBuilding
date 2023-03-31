package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.block.entity.OakChairEntity;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.*;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.stream.Stream;

public class OakChairBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public ArmorStandEntity stand = null;

    public OakChairBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    private static final VoxelShape NORTH_SHAPE =

            Stream.of(
                    Block.createCuboidShape(14, 9, 2, 16, 11, 15),
                    Block.createCuboidShape(0, 9, 0, 2, 22, 2),
                    Block.createCuboidShape(2, 9, 0, 14, 21, 2),
                    Block.createCuboidShape(0, 7, 0, 16, 9, 16),
                    Block.createCuboidShape(0, 0, 14, 2, 7, 14),
                    Block.createCuboidShape(14, 0, 14, 16, 7, 16),
                    Block.createCuboidShape(0, 0, 0, 2, 7, 2),
                    Block.createCuboidShape(14, 0, 0, 16, 7, 2),
                    Block.createCuboidShape(14, 9, 0, 16, 22, 2),
                    Block.createCuboidShape(0, 9, 2, 2, 11, 15)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private static final VoxelShape EAST_SHAPE =

            Stream.of(
                    Block.createCuboidShape(1, 9, 14, 14, 11, 16),
                    Block.createCuboidShape(14, 9, 0, 16, 22, 2),
                    Block.createCuboidShape(14, 9, 2, 16, 21, 14),
                    Block.createCuboidShape(0, 7, 0, 16, 9, 16),
                    Block.createCuboidShape(0, 0, 0, 2, 7, 2),
                    Block.createCuboidShape(0, 0, 14, 2, 7, 16),
                    Block.createCuboidShape(14, 0, 0, 16, 7, 2),
                    Block.createCuboidShape(14, 0, 14, 16, 7, 16),
                    Block.createCuboidShape(14, 9, 14, 16, 22, 16),
                    Block.createCuboidShape(1, 9, 0, 14, 11, 2)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private static final VoxelShape SOUTH_SHAPE =

            Stream.of(
                    Block.createCuboidShape(0, 9, 1, 2, 11, 14),
                    Block.createCuboidShape(14, 9, 14, 16, 22, 16),
                    Block.createCuboidShape(2, 9, 14, 14, 21, 16),
                    Block.createCuboidShape(0, 7, 0, 16, 9, 16),
                    Block.createCuboidShape(14, 0, 0, 16, 7, 2),
                    Block.createCuboidShape(0, 0, 0, 2, 7, 2),
                    Block.createCuboidShape(14, 0, 14, 16, 7, 16),
                    Block.createCuboidShape(0, 0, 14, 2, 7, 16),
                    Block.createCuboidShape(0, 9, 14, 2, 22, 16),
                    Block.createCuboidShape(14, 9, 1, 16, 11, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private static final VoxelShape WEST_SHAPE =

            Stream.of(
                    Block.createCuboidShape(2, 9, 0, 15, 11, 2),
                    Block.createCuboidShape(0, 9, 14, 2, 22, 16),
                    Block.createCuboidShape(0, 9, 2, 2, 21, 14),
                    Block.createCuboidShape(0, 7, 0, 16, 9, 16),
                    Block.createCuboidShape(14, 0, 14, 16, 7, 16),
                    Block.createCuboidShape(14, 0, 0, 16, 7, 2),
                    Block.createCuboidShape(0, 0, 14, 2, 7, 16),
                    Block.createCuboidShape(0, 0, 0, 2, 7, 2),
                    Block.createCuboidShape(0, 9, 0, 2, 22, 2),
                    Block.createCuboidShape(2, 9, 14, 15, 11, 16)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        switch (dir) {
            case SOUTH:
                return SOUTH_SHAPE;

            case WEST:
                return WEST_SHAPE;

            case EAST:
                return EAST_SHAPE;
        }
        return NORTH_SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (player.getVehicle() == null) {
            stand = new ArmorStandEntity(EntityType.ARMOR_STAND, world);
            stand.setNoGravity(true);
            stand.setPosition(pos.getX() + 0.5, pos.getY() - 1.2, pos.getZ() + 0.5); //Position of the chair
            stand.doesNotCollide(2, 2, 2);
            stand.setInvisible(true);
            world.spawnEntity(stand);
            stand.setVelocity(0, 0, 0);
        }
        if (stand != null) player.startRiding(stand);
        return ActionResult.SUCCESS;
    }

    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }


    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (stand != null) stand.kill();
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (stand != null) {
            if (!stand.hasPlayerRider()) {
                stand.kill();
                stand = null;
            }

        }
        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction,
                                                BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockPos above = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        if (!world.isAir(above)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OakChairEntity(pos, state);
    }
}
