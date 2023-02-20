package net.b34tzepz.betterbuilding.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class ModSymbolSlot extends Slot {
    public ModSymbolSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return true;
    }

    @Override
    public int getMaxItemCount(ItemStack stack) {
        return 1;

    }
}
