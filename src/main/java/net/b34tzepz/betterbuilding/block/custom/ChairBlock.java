package net.b34tzepz.betterbuilding.block.custom;

import com.mojang.serialization.MapCodec;
import net.b34tzepz.betterbuilding.block.entity.ChairEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;
import net.minecraft.util.math.random.Random;

import java.util.stream.Stream;

public class ChairBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final MapCodec<ChairBlock> CODEC = Block.createCodec(ChairBlock::new);
    public ArmorStandEntity stand = null;

    public ChairBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
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
        return switch (dir) {
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST -> EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
    }


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

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
    protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        if (stand != null) stand.kill(world);
        super.onStateReplaced(state, world, pos, moved);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (stand != null) {
            if (!stand.hasPlayerRider()) {
                stand.kill((ServerWorld) world);
                stand = null;
            }
        }
        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction,
                                                   BlockPos neighborPos, BlockState neighborState, Random random) {
        BlockPos above = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        if (!world.isAir(above)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
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
        return new ChairEntity(pos, state);
    }
}
