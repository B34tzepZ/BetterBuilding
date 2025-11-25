package net.b34tzepz.betterbuilding.mixin;

import net.b34tzepz.betterbuilding.block.custom.CornerBlock;
import net.b34tzepz.betterbuilding.block.custom.SideBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.Block.cannotConnect;

@Mixin(PaneBlock.class)
public abstract class PaneBlockMixin implements BlockAccessor{

    @Inject(method = "connectsTo", at = @At("RETURN"), cancellable = true)
    protected void injectConnectsTo(BlockState state, boolean sideSolidFullSquare, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(!cannotConnect(state) && sideSolidFullSquare ||
                state.getBlock() instanceof PaneBlock ||
                state.isIn(BlockTags.WALLS) ||
                state.getBlock() instanceof CornerBlock ||
                state.getBlock() instanceof SideBlock);
    }

    @Inject(method = "getStateForNeighborUpdate", at = @At(value = "RETURN", ordinal = 0), cancellable = true)
    protected void injectGetStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random
        random, CallbackInfoReturnable<BlockState> cir){
        if(neighborState.getBlock() instanceof SideBlock && neighborState.get(SideBlock.TYPE).asString().equals(direction.getId())){
            cir.setReturnValue(state);
        }
    }

    @Inject(method = "getPlacementState", at = @At("HEAD"), cancellable = true)
    protected void injectGetPlacementState(ItemPlacementContext ctx, CallbackInfoReturnable<BlockState> cir){
        BlockState defaultState = this.getDefaultState();
        World blockView = ctx.getWorld();
        ScheduledTickView tickView = (ScheduledTickView) blockView.getBlockTickScheduler();
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        BlockState blockStateNorth = blockView.getBlockState(blockPos.north());
        BlockState blockStateSouth = blockView.getBlockState(blockPos.south());
        BlockState blockStateWest = blockView.getBlockState(blockPos.west());
        BlockState blockStateEast = blockView.getBlockState(blockPos.east());
        defaultState = defaultState.getStateForNeighborUpdate(blockView, tickView, blockPos, Direction.NORTH, blockPos.north(), blockStateNorth, Random.create());
        defaultState = defaultState.getStateForNeighborUpdate(blockView, tickView, blockPos, Direction.SOUTH, blockPos.south(), blockStateSouth, Random.create());
        defaultState = defaultState.getStateForNeighborUpdate(blockView, tickView, blockPos, Direction.WEST, blockPos.west(), blockStateWest, Random.create());
        defaultState = defaultState.getStateForNeighborUpdate(blockView, tickView, blockPos, Direction.EAST, blockPos.east(), blockStateEast, Random.create());
        cir.setReturnValue(defaultState.with(PaneBlock.WATERLOGGED, fluidState.getFluid() == Fluids.WATER));
    }
}

