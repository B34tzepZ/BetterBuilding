package net.b34tzepz.betterbuilding.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class ChairEntity extends BlockEntity implements NamedScreenHandlerFactory {
    public ChairEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OAK_CHAIR, pos, state);
    }


    @Override
    public Text getDisplayName() {
        return Text.literal("Chair");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return null;
    }
}
