package net.b34tzepz.betterbuilding.block.entity;

import net.b34tzepz.betterbuilding.item.inventory.ImplementedInventory;
import net.b34tzepz.betterbuilding.screen.FabricatorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

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
                switch (index) {
                    case 0:
                        return FabricatorBlockEntity.this.progress;
                    case 1:
                        return FabricatorBlockEntity.this.maxProgress;
                    default:
                        return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        FabricatorBlockEntity.this.progress = value;
                        break;
                    case 1:
                        FabricatorBlockEntity.this.maxProgress = value;
                        break;
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
        if(slot < 9) {
            ItemStack newStack = new ItemStack(stack.getItem());
            getItems().set(slot, newStack);
        }
        else{
            getItems().set(slot, stack);
            if (stack.getCount() > getMaxCountPerStack()) {
                stack.setCount(getMaxCountPerStack());
            }
        }
    }

    @Override
    public ItemStack removeStack(int slot){
        if(slot < 9) {
            Inventories.removeStack(getItems(), slot);
            return ItemStack.EMPTY;
        }
        return Inventories.removeStack(getItems(), slot);
    }

    @Override
    public ItemStack removeStack(int slot, int count){
        if(slot < 9) {
            Inventories.removeStack(getItems(), slot);
            return ItemStack.EMPTY;
        }
        return Inventories.removeStack(getItems(), slot);
    }

    @Override
    public void onOpen(PlayerEntity player) {
        System.out.println(inventory);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Fabricator");
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
        //TODO
        if (hasRecipe(entity)) {
            entity.progress++;
            if(entity.progress > entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(FabricatorBlockEntity entity) {
        //TODO
//        World world = entity.world;
//        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
//        for (int i = 0; i < entity.inventory.size(); i++){
//            inventory.setStack(i, entity.getStack(i));
//        }
//
//        Optional<CraftingRecipe> match = world.getRecipeManager()
//                .getFirstMatch(RecipeType.CRAFTING, inventory, world);
//
//        return  match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
//                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
        return false;
    }

//    private static boolean hasIngredients(FabricatorBlockEntity entity) {
//        //TODO
//    }

    private static void craftItem(FabricatorBlockEntity entity){
        //TODO
//        World world = entity.world;
//        CraftingInventory inventory = new CraftingInventory(handler, 3,3);
//        for (int i = 0; i < entity.inventory.size(); i++){
//            inventory.setStack(i, entity.getStack(i));
//        }
//
//        Optional<CraftingRecipe> match = world.getServer().getRecipeManager()
//                .getFirstMatch(RecipeType.CRAFTING, inventory, world);
//
//        if(match.isPresent()) {
//            entity.removeStack(1,1);
//            entity.removeStack(2,1);
//
//            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(), entity.getStack(3).getCount() + 1));
//        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(9).getItem() == output.getItem() || inventory.getStack(0).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(9).getMaxCount() > inventory.getStack(0).getCount();
    }

    private ItemStack getCraftingGridStack(int i){
        if(i<9) {
            return inventory.get(i);
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }
}
