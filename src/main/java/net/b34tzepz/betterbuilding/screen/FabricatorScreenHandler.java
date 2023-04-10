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
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.Optional;

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
        this.addSlot(new ModResultSlot(inventory, 9, 80, 31, player));
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

    private Slot getFabricatorInventorySlot(int index) {
        if (index < 9) {
            return getSlot(10 + index);
        } else throw new IndexOutOfBoundsException();
    }

    private Slot getCraftingGridSlot(int index) {
        if (index < 9) {
            return getSlot(index);
        } else throw new IndexOutOfBoundsException();
    }

    private Slot getOutputSlot() {
        return getSlot(9);
    }

//    protected static void updateResult
//            (ScreenHandler handler, World world, PlayerEntity player, CraftingInventory craftingInventory) {
//        CraftingRecipe craftingRecipe;
//        if (world.isClient) {
//            return;
//        }
//        CraftingInventory ci = new CraftingInventory(ModScreenHandlers.FABRICATOR_SCREEN_HANDLER.create(this.syncId, ),3,3);
//        ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) player;
//        ItemStack itemStack = ItemStack.EMPTY;
//        Optional<CraftingRecipe> optional = world.getServer().getRecipeManager().getFirstMatch(RecipeType.CRAFTING, craftingInventory, world);
//        if (optional.isPresent() && resultInventory.shouldCraftRecipe(world, serverPlayerEntity, craftingRecipe = optional.get())) {
//            itemStack = craftingRecipe.craft(craftingInventory);
//        }
//        resultInventory.setStack(0, itemStack);
//        handler.setPreviousTrackedSlot(0, itemStack);
//        serverPlayerEntity.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(handler.syncId, handler.nextRevision(), 0, itemStack));
//    }

//    public static Optional<CraftingRecipe> getRecipe
//            (ScreenHandler handler, World world, PlayerEntity player, CraftingInventory craftingInventory,
//             CraftingResultInventory resultInventory) {
//        CraftingRecipe craftingRecipe;
//        if (world.isClient) {
//            return;
//        }
//        Optional<CraftingRecipe> optional = world.getServer().getRecipeManager().getFirstMatch(RecipeType.CRAFTING, craftingInventory, world);
//        return optional;
//    }

//    @Override
//    public void onContentChanged(Inventory inventory) {
//        this.context.run((world, pos) -> FabricatorScreenHandler.updateResult(this, world, this.player, this.craftingGrid, this.output));
//    }

//
//    @Override
//    public void clearCraftingSlots() {
//        //TODO
//    }
//
//    @Override
//    public boolean matches(Recipe<? super CraftingInventory> recipe) {
//        return recipe.matches(this.craftingGrid, this.player.world);
//    }
//
//    @Override
//    public int getCraftingResultSlotIndex() {
//        return 0;
//    }
//
//    @Override
//    public int getCraftingWidth() {
//        return 3;
//    }
//
//    @Override
//    public int getCraftingHeight() {
//        return 3;
//    }
//
//    @Override
//    public int getCraftingSlotCount() {
//        return 19;
//    }
//
//    @Override
//    public RecipeBookCategory getCategory() {
//        return RecipeBookCategory.CRAFTING;
//    }
//
//    @Override
//    public boolean canInsertIntoSlot(int index) {
//        return index >=10;
//    }
}
