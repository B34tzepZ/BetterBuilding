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

import java.util.stream.Stream;

public class TableBlock extends Block {


    public static final BooleanProperty NORTH_BOWL_PLACED = BooleanProperty.of("north_bowl_placed");
    public static final BooleanProperty SOUTH_BOWL_PLACED = BooleanProperty.of("south_bowl_placed");
    public static final BooleanProperty EAST_BOWL_PLACED = BooleanProperty.of("east_bowl_placed");
    public static final BooleanProperty WEST_BOWL_PLACED = BooleanProperty.of("west_bowl_placed");

    public static final VoxelShape legNW = Block.createCuboidShape(2, 0, 2, 4, 14, 4);
    public static final VoxelShape legNE = Block.createCuboidShape(12, 0, 2, 14, 14, 4);
    public static final VoxelShape legSW = Block.createCuboidShape(2, 0, 12, 4, 14, 14);
    public static final VoxelShape legSE = Block.createCuboidShape(12, 0, 12, 14, 14, 14);
    public static final VoxelShape plate = Block.createCuboidShape(0, 14, 0, 16, 16, 16);
    public static VoxelShape SHAPE = VoxelShapes.union(legNW, legNE, legSW, legSE, plate);

    public TableBlock(Settings settings) {
        super(settings);
        this.setDefaultState((((this.stateManager.getDefaultState()
                .with(NORTH_BOWL_PLACED, false))
                .with(SOUTH_BOWL_PLACED, false))
                .with(EAST_BOWL_PLACED, false))
                .with(WEST_BOWL_PLACED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH_BOWL_PLACED, SOUTH_BOWL_PLACED, EAST_BOWL_PLACED, WEST_BOWL_PLACED);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());

        if (itemStack.isOf(Items.BOWL) && player.getActiveHand() == Hand.MAIN_HAND) {
            return placeBowl(state, world, pos, player, itemStack);
        } else {
            return takeBowl(state, world, pos, player);
        }
    }

    private ActionResult placeBowl(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack itemStack) {
        Direction dir = player.getHorizontalFacing();

        if(!state.get(getOppositeBowlPropertyByDir(dir))){
            world.setBlockState(pos, state.with(getOppositeBowlPropertyByDir(dir), true), NOTIFY_ALL);
            itemStack.decrementUnlessCreative(1, player);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
    }

    private ActionResult takeBowl(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        Direction dir = player.getHorizontalFacing();

        if(state.get(getOppositeBowlPropertyByDir(dir))){
            world.setBlockState(pos, state.with(getOppositeBowlPropertyByDir(dir), false), NOTIFY_ALL);
            dropBowl(world, pos);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
    }

    private void dropBowl(World world, BlockPos pos) {
        if (!world.isClient()) {
            double d = (world.random.nextDouble() * 0.7f) + 0.15;
            double e = (world.random.nextDouble() * 0.7f) + 0.66;
            double g = (world.random.nextDouble() * 0.7f) + 0.15;
            ItemEntity itemEntity = new ItemEntity(world, (double) pos.getX() + d, (double) pos.getY() + e, (double) pos.getZ() + g, new ItemStack(Items.BOWL));
            itemEntity.setToDefaultPickupDelay();
            world.spawnEntity(itemEntity);
        }
    }

    private BooleanProperty getOppositeBowlPropertyByDir(Direction dir){
        return switch (dir) {
            case SOUTH -> NORTH_BOWL_PLACED;
            case NORTH -> SOUTH_BOWL_PLACED;
            case WEST -> EAST_BOWL_PLACED;
            case EAST -> WEST_BOWL_PLACED;
            default -> null;
        };
    }


}
