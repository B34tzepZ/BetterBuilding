package net.b34tzepz.betterbuilding.screen.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class FabricatorCraftingGridSlot extends Slot {

    public FabricatorCraftingGridSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    protected void onCrafted(ItemStack stack) {
    }

    @Override
    public ItemStack insertStack(ItemStack stack, int count) {
        if (stack.isEmpty() || !this.canInsert(stack)) {
            return stack; //stack in hand
        }
        this.setStack(stack);

        return stack;
    }

//    @Override
//    public boolean canTakeItems(PlayerEntity playerEntity) {
//        return false;
//    }
}

