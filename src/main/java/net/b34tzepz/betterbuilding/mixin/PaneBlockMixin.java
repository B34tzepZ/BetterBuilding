package net.b34tzepz.betterbuilding.mixin;

import net.b34tzepz.betterbuilding.block.custom.CornerBlock;
import net.b34tzepz.betterbuilding.block.custom.SideBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.Block.cannotConnect;

@Mixin(PaneBlock.class)
public abstract class PaneBlockMixin implements BlockAccessor {

    @Shadow public abstract boolean connectsTo(BlockState state, boolean sideSolidFullSquare);

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
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        for (Direction direction : Properties.HORIZONTAL_FACING.getValues()) {
            BlockState neighborState = blockView.getBlockState(blockPos.offset(direction));
            if (!(neighborState.getBlock() instanceof SideBlock) || !(neighborState.get(SideBlock.TYPE).asString().equals(direction.getId()))) {
                defaultState = defaultState.with(ConnectingBlock.FACING_PROPERTIES.get(direction), connectsTo(neighborState, neighborState.isSideSolidFullSquare(blockView, blockPos.offset(direction), direction.getOpposite())));
            }
        }
        cir.setReturnValue(defaultState.with(PaneBlock.WATERLOGGED, fluidState.getFluid() == Fluids.WATER));
    }
}

