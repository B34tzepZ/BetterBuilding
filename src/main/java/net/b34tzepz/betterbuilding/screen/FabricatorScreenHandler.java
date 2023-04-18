package net.b34tzepz.betterbuilding.screen;

import net.b34tzepz.betterbuilding.screen.slot.FabricatorCraftingGridSlot;
import net.b34tzepz.betterbuilding.screen.slot.ModResultSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FabricatorScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    private final PlayerEntity player;

    public FabricatorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(19), new ArrayPropertyDelegate(2));
    }

    public FabricatorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.FABRICATOR_SCREEN_HANDLER, syncId);
        checkSize(inventory, 19);
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;
        this.player = playerInventory.player;
        this.inventory = inventory;

        //Crafting Grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.addSlot(new FabricatorCraftingGridSlot(inventory, i * 3 + j, 8 + j * 18, 17 + i * 18));
            }
        }
        //Result slot
        this.addSlot(new ModResultSlot(inventory, 9, 84, 35, player));
        //Inventar
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.addSlot(new Slot(inventory, i * 3 + j + 10, 116 + j * 18, 17 + i * 18));
            }
        }

        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);

        addProperties(delegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 12;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            if (invSlot < 9) {
                slot.setStack(ItemStack.EMPTY);
                return ItemStack.EMPTY;
            }
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size() - 9, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 9, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }

    private Set<Slot> quickCraftSlots = new HashSet<>();

    @Override
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
        if (actionType == SlotActionType.SWAP && slotIndex < 9) return;

        ItemStack cursorStack = this.getCursorStack().copy();
        if (actionType == SlotActionType.QUICK_CRAFT && slotIndex != EMPTY_SPACE_SLOT_INDEX) {
            if (!quickCraftSlots.contains(this.slots.get(slotIndex))) {
                quickCraftSlots.add(this.slots.get(slotIndex));
            }
            if(quickCraftContainsCraftingGridAndOtherSlots()){
                quickCraftSlots.clear();
                this.endQuickCraft();
            }
        }

        super.onSlotClick(slotIndex, button, actionType, player);

        if (actionType == SlotActionType.QUICK_CRAFT) {
            if (this.isCraftingGridQuickCraft()) this.setCursorStack(cursorStack);
        }
        if (getCursorStack().getCount() != cursorStack.getCount()) quickCraftSlots.clear();
    }

    private boolean isCraftingGridQuickCraft() {
        boolean bool = true;
        for (int i = 10; i < this.slots.size(); i++) {
            if (quickCraftSlots.contains(this.slots.get(i))) {
                bool = false;
                break;
            }
        }

        return bool;
    }

    private boolean quickCraftContainsCraftingGridAndOtherSlots() {
        boolean craftingGridSlot = false;
        boolean otherSlot = false;
        for (int i = 0; i < this.slots.size(); i++) {
            if (quickCraftSlots.contains(this.slots.get(i)))
                if (i < 9) {
                    craftingGridSlot = true;
                    i = 9;
                } else {
                    otherSlot = true;
                    break;
                }
        }

        return craftingGridSlot && otherSlot;
    }
}
