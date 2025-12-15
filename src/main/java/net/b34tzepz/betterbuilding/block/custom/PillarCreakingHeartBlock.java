package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CreakingHeartBlockEntity;
import net.minecraft.block.enums.CreakingHeartState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionImpl;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public class PillarCreakingHeartBlock extends PillarBlock implements BlockEntityProvider {
    public static final EnumProperty<CreakingHeartState> ACTIVE = Properties.CREAKING_HEART_STATE;
    public static final BooleanProperty NATURAL = Properties.NATURAL;

    public PillarCreakingHeartBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y).with(ACTIVE, CreakingHeartState.UPROOTED).with(NATURAL, false).with(WATERLOGGED, false));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CreakingHeartBlockEntity(pos, state);
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> validateTicker(
            BlockEntityType<A> givenType, BlockEntityTicker<? super E> ticker
    ) {
        return BlockEntityType.CREAKING_HEART == givenType ? (BlockEntityTicker<A>) ticker : null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient()) {
            return null;
        } else {
            return state.get(ACTIVE) != CreakingHeartState.UPROOTED
                    ? validateTicker(type, CreakingHeartBlockEntity::tick)
                    : null;
        }
    }

    public static boolean isNightAndNatural(World world) {
        return world.isNightAndNatural();
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (isNightAndNatural(world)) {
            if (state.get(ACTIVE) != CreakingHeartState.UPROOTED) {
                if (random.nextInt(16) == 0 && isSurroundedByPaleOakLogs(world, pos)) {
                    world.playSoundClient(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_CREAKING_HEART_IDLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
                }
            }
        }
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        tickView.scheduleBlockTick(pos, this, 1);
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState blockState = enableIfValid(state, world, pos);
        if (blockState != state) {
            world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
        }
    }

    private static BlockState enableIfValid(BlockState state, World world, BlockPos pos) {
        boolean bl = shouldBeEnabled(state, world, pos);
        boolean bl2 = state.get(ACTIVE) == CreakingHeartState.UPROOTED;
        return bl && bl2 ? state.with(ACTIVE, isNightAndNatural(world) ? CreakingHeartState.AWAKE : CreakingHeartState.DORMANT) : state;
    }

    public static boolean shouldBeEnabled(BlockState state, WorldView world, BlockPos pos) {
        Direction.Axis axis = state.get(AXIS);

        for (Direction direction : axis.getDirections()) {
            BlockState blockState = world.getBlockState(pos.offset(direction));
            if (!blockState.isIn(BlockTags.PALE_OAK_LOGS) || blockState.get(AXIS) != axis) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSurroundedByPaleOakLogs(WorldAccess world, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            if (!blockState.isIn(BlockTags.PALE_OAK_LOGS)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return enableIfValid(this.getDefaultState().with(AXIS, ctx.getSide().getAxis()), ctx.getWorld(), ctx.getBlockPos());
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return net.minecraft.block.PillarBlock.changeRotation(state, rotation);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, ACTIVE, NATURAL, WATERLOGGED);
    }

    @Override
    protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        ItemScatterer.onStateReplaced(state, world, pos);
    }

    @Override
    protected void onExploded(BlockState state, ServerWorld world, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> stackMerger) {
        if (world.getBlockEntity(pos) instanceof CreakingHeartBlockEntity creakingHeartBlockEntity
                && explosion instanceof ExplosionImpl explosionImpl
                && explosion.getDestructionType().destroysBlocks()) {
            creakingHeartBlockEntity.killPuppet(explosionImpl.getDamageSource());
            if (explosion.getCausingEntity() instanceof PlayerEntity playerEntity && explosion.getDestructionType().destroysBlocks()) {
                this.dropExperienceOnBreak(playerEntity, state, world, pos);
            }
        }

        super.onExploded(state, world, pos, explosion, stackMerger);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (world.getBlockEntity(pos) instanceof CreakingHeartBlockEntity creakingHeartBlockEntity) {
            creakingHeartBlockEntity.killPuppet(player.getDamageSources().playerAttack(player));
            this.dropExperienceOnBreak(player, state, world, pos);
        }

        return super.onBreak(world, pos, state, player);
    }

    private void dropExperienceOnBreak(PlayerEntity player, BlockState state, World world, BlockPos pos) {
        if (!player.shouldSkipBlockDrops() && !player.isSpectator() && state.get(NATURAL) && world instanceof ServerWorld serverWorld) {
            this.dropExperience(serverWorld, pos, world.random.nextBetween(20, 24));
        }
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos, Direction direction) {
        if (state.get(ACTIVE) == CreakingHeartState.UPROOTED) {
            return 0;
        } else {
            return world.getBlockEntity(pos) instanceof CreakingHeartBlockEntity creakingHeartBlockEntity ? creakingHeartBlockEntity.getComparatorOutput() : 0;
        }
    }
}
