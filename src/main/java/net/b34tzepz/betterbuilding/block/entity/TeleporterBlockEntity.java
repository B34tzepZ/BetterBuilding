package net.b34tzepz.betterbuilding.block.entity;

import net.b34tzepz.betterbuilding.item.inventory.ImplementedInventory;
import net.b34tzepz.betterbuilding.screen.TeleporterBlockScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class TeleporterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory= DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static ArrayList<BlockPos> teleporters = new ArrayList<BlockPos>();
    public static int arraylength=0;
    public static int[] posX = new int[arraylength];
    public static int[] posY = new int[arraylength];
    public static int[] posZ = new int[arraylength];

    public TeleporterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TELEPORTER_BLOCK, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public Item getItem(){
        return inventory.get(0).getItem();
    }

    public static void tick(World world, BlockPos pos, BlockState state, TeleporterBlockEntity entity) {

    }


    @Override
    public Text getDisplayName() {
        return new LiteralText("Teleporter Block");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new TeleporterBlockScreenHandler(syncId, inv, this);
    }

    public void transferToArrays(){
        posX = new int[arraylength];
        posY = new int[arraylength];
        posZ = new int[arraylength];
        for (int i = 0; i < arraylength; i++) {
            posX[i]=teleporters.get(i).getX();
        }
        for (int i = 0; i < arraylength; i++) {
            posY[i]=teleporters.get(i).getY();
        }
        for (int i = 0; i < arraylength; i++) {
            posZ[i]=teleporters.get(i).getZ();
        }
    }

    public void transferFromArrays(){
        teleporters = new ArrayList<BlockPos>();
        for (int i = 0; i < arraylength; i++) {
            teleporters.add(new BlockPos(posX[i],posY[i],posZ[i]));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("arraylength",arraylength);
        transferToArrays();
        nbt.putIntArray("posX",posX);
        nbt.putIntArray("posY",posY);
        nbt.putIntArray("posZ",posZ);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        arraylength = nbt.getInt("arraylength");
        posX=nbt.getIntArray("posX");
        posY=nbt.getIntArray("posY");
        posZ=nbt.getIntArray("posZ");
        super.readNbt(nbt);
        transferFromArrays();
    }
}
