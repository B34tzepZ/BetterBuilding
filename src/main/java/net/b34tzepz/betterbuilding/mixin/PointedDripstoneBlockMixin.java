package net.b34tzepz.betterbuilding.mixin;

import net.b34tzepz.betterbuilding.block.custom.PillarBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PointedDripstoneBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PointedDripstoneBlock.class)
public abstract class PointedDripstoneBlockMixin implements BlockAccessor {

//    @Shadow
//    private static boolean canPlaceAtWithDirection(WorldView world, BlockPos pos, Direction direction) {
//        return false;
//    }

    @Inject(method = "canPlaceAtWithDirection", at = @At("HEAD"),  cancellable = true)
    private static void canPlaceAtWithDirection(WorldView world, BlockPos pos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        cir.setReturnValue(blockState.isSideSolidFullSquare(world, blockPos, direction) ||
                (blockState.isOf(Blocks.POINTED_DRIPSTONE) && blockState.get(PointedDripstoneBlock.VERTICAL_DIRECTION) == direction) ||
                (blockState.getBlock() instanceof PillarBlock && blockState.get(PillarBlock.AXIS) == Direction.Axis.Y));
    }
}
