package net.b34tzepz.betterbuilding.block.entity;

import net.b34tzepz.betterbuilding.item.inventory.ImplementedInventory;
import net.b34tzepz.betterbuilding.recipe.FabricatorCraftingRecipe;
import net.b34tzepz.betterbuilding.recipe.ModRecipes;
import net.b34tzepz.betterbuilding.screen.FabricatorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Optional;

public class FabricatorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(19, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public FabricatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FABRICATOR_BLOCK, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> FabricatorBlockEntity.this.progress;
                    case 1 -> FabricatorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> FabricatorBlockEntity.this.progress = value;
                    case 1 -> FabricatorBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        if (slot < 9) {
            ItemStack newStack = new ItemStack(stack.getItem());
            getItems().set(slot, newStack);
        } else {
            getItems().set(slot, stack);
            if (stack.getCount() > getMaxCountPerStack()) {
                stack.setCount(getMaxCountPerStack());
            }
        }
    }

    @Override
    public ItemStack removeStack(int slot) {
        if (slot < 9) {
            Inventories.removeStack(getItems(), slot);
            return ItemStack.EMPTY;
        }
        return Inventories.removeStack(getItems(), slot);
    }

    @Override
    public ItemStack removeStack(int slot, int count) {
        if (slot < 9) {
            Inventories.removeStack(getItems(), slot);
            return ItemStack.EMPTY;
        }
        return Inventories.removeStack(getItems(), slot);
    }

//    @Override
//    public void onOpen(PlayerEntity player) {
//        System.out.println(inventory);
//        SimpleInventory inventory = new SimpleInventory(this.inventory.size());
//        for (int i = 0; i < this.inventory.size(); i++) {
//            inventory.setStack(i, this.getStack(i));
//        }
//        System.out.println(hasIngredients(inventory));
//    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("block.betterbuilding.fabricator");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new FabricatorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("fabricator.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("fabricator.progress");
    }

    public static void tick(World world, BlockPos pos, BlockState state, FabricatorBlockEntity entity) {
        Optional<FabricatorCraftingRecipe> match = checkMatch(entity);
        if (canCraftRecipe(entity, match)) {
            entity.progress++;
            if (entity.progress > entity.maxProgress) {
                craftItem(entity, match);
                consumeIngredients(entity);
            }
        } else {
            entity.resetProgress();
        }
    }

    private static Optional<FabricatorCraftingRecipe> checkMatch(FabricatorBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        return world.getRecipeManager().getFirstMatch(ModRecipes.FABRICATOR_CRAFTING, inventory, world);

    }

    private static boolean canCraftRecipe(FabricatorBlockEntity entity, Optional<FabricatorCraftingRecipe> match) {
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) && hasIngredients(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static boolean hasIngredients(SimpleInventory inventory) {
        HashMap<Item, Integer> neededItems = getNeededIngredients(inventory);

        for (int i = 10; i < 19; i++) {
            Item item = inventory.getStack(i).getItem();
            int itemCount = inventory.getStack(i).getCount();
            if (neededItems.containsKey(item)) {
                if (itemCount >= neededItems.get(item)) {
                    neededItems.remove(item);
                } else {
                    neededItems.replace(item, neededItems.get(item) - itemCount);
                }
            }
        }

        return neededItems.isEmpty();
    }

    private static void craftItem(FabricatorBlockEntity entity, Optional<FabricatorCraftingRecipe> match) {
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if (match.isPresent()) {
            entity.setStack(9, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(9).getCount() + match.get().getOutput().getCount()));

            entity.resetProgress();
        }
    }

    private static void consumeIngredients(FabricatorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        HashMap<Item, Integer> neededItems = getNeededIngredients(inventory);

        for (int i = 10; i < 19; i++) {
            Item item = inventory.getStack(i).getItem();
            int itemCount = inventory.getStack(i).getCount();
            if (neededItems.containsKey(item)) {
                if (itemCount >= neededItems.get(item)) {
                    entity.setStack(i, new ItemStack(item, itemCount - neededItems.get(item)));
                    neededItems.remove(item);
                } else {
                    entity.removeStack(i);
                    neededItems.replace(item, neededItems.get(item) - itemCount);
                }
            }
        }
    }

    private static HashMap<Item, Integer> getNeededIngredients(SimpleInventory inventory) {
        HashMap<Item, Integer> neededItems = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Item item = inventory.getStack(i).getItem();
            if(item.equals(Items.AIR)) continue;
            int itemCount = inventory.getStack(i).getCount();
            if (neededItems.containsKey(item)) {
                neededItems.replace(item, neededItems.get(item) + itemCount);
            } else {
                neededItems.put(item, itemCount);
            }
        }

        return neededItems;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(9).getItem() == output.getItem() || inventory.getStack(9).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(9).getMaxCount() > inventory.getStack(9).getCount();
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) {
            return new int[]{9};
        }
        return new int[]{10,11,12,13,14,15,16,17,18};
    }
}
