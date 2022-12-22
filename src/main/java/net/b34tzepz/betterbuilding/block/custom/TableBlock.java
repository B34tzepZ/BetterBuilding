package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
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

public class TableBlock extends HorizontalFacingBlock {


    public static final BooleanProperty NORTHBOWLPLACED = BooleanProperty.of("north_bowl_placed");
    public static final BooleanProperty SOUTHBOWLPLACED = BooleanProperty.of("south_bowl_placed");
    public static final BooleanProperty EASTBOWLPLACED = BooleanProperty.of("east_bowl_placed");
    public static final BooleanProperty WESTBOWLPLACED = BooleanProperty.of("west_bowl_placed");

    public static VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(12, 0, 2, 14, 12, 4),
            Block.createCuboidShape(12, 0, 12, 14, 12, 14),
            Block.createCuboidShape(2, 0, 2, 4, 12, 4),
            Block.createCuboidShape(2, 0, 12, 4, 12, 14),
            Block.createCuboidShape(0, 12, 0, 16, 14, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public TableBlock(Settings settings) {
        super(settings);
        this.setDefaultState(((((this.stateManager.getDefaultState()
                .with(NORTHBOWLPLACED, false))
                .with(SOUTHBOWLPLACED, false))
                .with(EASTBOWLPLACED, false))
                .with(WESTBOWLPLACED, false)));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTHBOWLPLACED,SOUTHBOWLPLACED,EASTBOWLPLACED,WESTBOWLPLACED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        boolean north = state.get(NORTHBOWLPLACED);
        boolean west = state.get(WESTBOWLPLACED);
        boolean south = state.get(SOUTHBOWLPLACED);
        boolean east = state.get(EASTBOWLPLACED);

        if(itemStack.isOf(Items.BOWL) && hand == Hand.MAIN_HAND){
            Direction dir = player.getHorizontalFacing();

            if(dir == Direction.NORTH && !south){
                world.setBlockState(pos, state.with(SOUTHBOWLPLACED, true), NOTIFY_ALL);
            }
            else if(dir == Direction.WEST && !east){
                world.setBlockState(pos, state.with(EASTBOWLPLACED, true), NOTIFY_ALL);
            }
            else if(dir == Direction.EAST && !west){
                world.setBlockState(pos, state.with(WESTBOWLPLACED, true), NOTIFY_ALL);
            }
            else if(dir == Direction.SOUTH && !north){
                world.setBlockState(pos, state.with(NORTHBOWLPLACED, true), NOTIFY_ALL);
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }



}
