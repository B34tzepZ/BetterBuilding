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


    public static final BooleanProperty NORTHBOWLPLACED = BooleanProperty.of("north_bowl_placed");
    public static final BooleanProperty SOUTHBOWLPLACED = BooleanProperty.of("south_bowl_placed");
    public static final BooleanProperty EASTBOWLPLACED = BooleanProperty.of("east_bowl_placed");
    public static final BooleanProperty WESTBOWLPLACED = BooleanProperty.of("west_bowl_placed");

    public static VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(12, 0, 2, 14, 14, 4),
            Block.createCuboidShape(12, 0, 12, 14, 14, 14),
            Block.createCuboidShape(2, 0, 2, 4, 14, 4),
            Block.createCuboidShape(2, 0, 12, 4, 14, 14),
            Block.createCuboidShape(0, 14, 0, 16, 16, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public TableBlock(Settings settings) {
        super(settings);
        this.setDefaultState((((this.stateManager.getDefaultState()
                .with(NORTHBOWLPLACED, false))
                .with(SOUTHBOWLPLACED, false))
                .with(EASTBOWLPLACED, false))
                .with(WESTBOWLPLACED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTHBOWLPLACED, SOUTHBOWLPLACED, EASTBOWLPLACED, WESTBOWLPLACED);
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
            itemStack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    private ActionResult takeBowl(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        Direction dir = player.getHorizontalFacing();

        if(state.get(getOppositeBowlPropertyByDir(dir))){
            world.setBlockState(pos, state.with(getOppositeBowlPropertyByDir(dir), false), NOTIFY_ALL);
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

    private BooleanProperty getOppositeBowlPropertyByDir(Direction dir){
        return switch (dir) {
            case SOUTH -> NORTHBOWLPLACED;
            case NORTH -> SOUTHBOWLPLACED;
            case WEST -> EASTBOWLPLACED;
            case EAST -> WESTBOWLPLACED;
            default -> null;
        };
    }


}
