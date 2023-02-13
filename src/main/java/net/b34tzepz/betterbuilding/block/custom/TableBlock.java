package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.stream.Stream;

public class TableBlock extends Block {


    public static final BooleanProperty NORTHBOWLPLACED = BooleanProperty.of("north_bowl_placed");
    public static final BooleanProperty SOUTHBOWLPLACED = BooleanProperty.of("south_bowl_placed");
    public static final BooleanProperty EASTBOWLPLACED = BooleanProperty.of("east_bowl_placed");
    public static final BooleanProperty WESTBOWLPLACED = BooleanProperty.of("west_bowl_placed");
    public static final BooleanProperty NORTHERNTABLE = BooleanProperty.of("northern_table");
    public static final BooleanProperty SOUTHERNTABLE = BooleanProperty.of("southern_table");
    public static final BooleanProperty EASTERNTABLE = BooleanProperty.of("eastern_table");
    public static final BooleanProperty WESTERNTABLE = BooleanProperty.of("western_table");

    public static VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(12, 0, 2, 14, 14, 4),
            Block.createCuboidShape(12, 0, 12, 14, 14, 14),
            Block.createCuboidShape(2, 0, 2, 4, 14, 4),
            Block.createCuboidShape(2, 0, 12, 4, 14, 14),
            Block.createCuboidShape(0, 14, 0, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public TableBlock(Settings settings) {
        super(settings);
        this.setDefaultState((((((((this.stateManager.getDefaultState()
                .with(NORTHBOWLPLACED, false))
                .with(SOUTHBOWLPLACED, false))
                .with(EASTBOWLPLACED, false))
                .with(WESTBOWLPLACED, false))
                .with(NORTHERNTABLE, false))
                .with(SOUTHERNTABLE, false))
                .with(WESTERNTABLE, false))
                .with(EASTERNTABLE, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTHBOWLPLACED, SOUTHBOWLPLACED, EASTBOWLPLACED, WESTBOWLPLACED, NORTHERNTABLE, SOUTHERNTABLE, EASTERNTABLE, WESTERNTABLE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.isOf(Items.BOWL) && hand == Hand.MAIN_HAND) {
            return placeBowl(state, world, pos, player, itemStack);
        } else {
            return takeBowl(state, world, pos, player);
        }
    }

    private ActionResult placeBowl(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack itemStack) {
        Direction dir = player.getHorizontalFacing();

        if (dir == Direction.NORTH && !state.get(SOUTHBOWLPLACED) && !state.get(SOUTHERNTABLE)) {
            world.setBlockState(pos, state.with(SOUTHBOWLPLACED, true), NOTIFY_ALL);
            itemStack.decrement(1);
        } else if (dir == Direction.WEST && !state.get(EASTBOWLPLACED) && !state.get(EASTERNTABLE)) {
            world.setBlockState(pos, state.with(EASTBOWLPLACED, true), NOTIFY_ALL);
            itemStack.decrement(1);
        } else if (dir == Direction.EAST && !state.get(WESTBOWLPLACED) && !state.get(WESTERNTABLE)) {
            world.setBlockState(pos, state.with(WESTBOWLPLACED, true), NOTIFY_ALL);
            itemStack.decrement(1);
        } else if (dir == Direction.SOUTH && !state.get(NORTHBOWLPLACED) && !state.get(NORTHERNTABLE)) {
            world.setBlockState(pos, state.with(NORTHBOWLPLACED, true), NOTIFY_ALL);
            itemStack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    private ActionResult takeBowl(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        Direction dir = player.getHorizontalFacing();

        if (dir == Direction.NORTH && state.get(SOUTHBOWLPLACED)) {
            world.setBlockState(pos, state.with(SOUTHBOWLPLACED, false), NOTIFY_ALL);
            dropBowl(world, pos);
        } else if (dir == Direction.WEST && state.get(EASTBOWLPLACED)) {
            world.setBlockState(pos, state.with(EASTBOWLPLACED, false), NOTIFY_ALL);
            dropBowl(world, pos);
        } else if (dir == Direction.EAST && state.get(WESTBOWLPLACED)) {
            world.setBlockState(pos, state.with(WESTBOWLPLACED, false), NOTIFY_ALL);
            dropBowl(world, pos);
        } else if (dir == Direction.SOUTH && state.get(NORTHBOWLPLACED)) {
            world.setBlockState(pos, state.with(NORTHBOWLPLACED, false), NOTIFY_ALL);
            dropBowl(world, pos);
        }

        return ActionResult.SUCCESS;
    }

    private void dropBowl(World world, BlockPos pos) {
        if (!world.isClient) {
            double d = (double) (world.random.nextFloat() * 0.7f) + (double) 0.15f;
            double e = (double) (world.random.nextFloat() * 0.7f) + 0.06000000238418579 + 0.6;
            double g = (double) (world.random.nextFloat() * 0.7f) + (double) 0.15f;
            ItemEntity itemEntity = new ItemEntity(world, (double) pos.getX() + d, (double) pos.getY() + e, (double) pos.getZ() + g, new ItemStack(Items.BOWL));
            itemEntity.setToDefaultPickupDelay();
            world.spawnEntity(itemEntity);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis().isHorizontal()) {
            if(direction == Direction.NORTH) {
                return state.with(NORTHERNTABLE, TableBlock.isTable(neighborState));
            }
            else if(direction == Direction.SOUTH){
                return state.with(SOUTHERNTABLE, TableBlock.isTable(neighborState));
            }
            else if(direction == Direction.WEST){
                return state.with(WESTERNTABLE, TableBlock.isTable(neighborState));
            }
            else if(direction == Direction.EAST){
                return state.with(EASTERNTABLE, TableBlock.isTable(neighborState));
            }
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public static boolean isTable(BlockState state) {
        return state.getBlock() instanceof TableBlock;
    }


}
