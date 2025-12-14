package net.b34tzepz.betterbuilding.block.entity;

import net.b34tzepz.betterbuilding.item.inventory.ImplementedInventory;
import net.b34tzepz.betterbuilding.screen.custom.TeleporterBlockScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class TeleporterBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    private final DefaultedList<ItemStack> inventory= DefaultedList.ofSize(1, ItemStack.EMPTY);
    public static ArrayList<BlockPos> teleporters = new ArrayList<>();
    public static int arraylength=0;
    public static int[] posX = new int[arraylength];
    public static int[] posY = new int[arraylength];
    public static int[] posZ = new int[arraylength];

    public TeleporterBlockEntity(BlockPos pos, BlockState state) {
        super(ModEntities.TELEPORTER_BLOCK, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public Item getItem(){
        return inventory.getFirst().getItem();
    }

    public static void tick(World world, BlockPos pos, BlockState state, TeleporterBlockEntity entity) {

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
        teleporters = new ArrayList<>();
        for (int i = 0; i < arraylength; i++) {
            teleporters.add(new BlockPos(posX[i],posY[i],posZ[i]));
        }
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        Inventories.writeData(view, inventory);
        view.putInt("arraylength",arraylength);
        transferToArrays();
        view.putIntArray("posX",posX);
        view.putIntArray("posY",posY);
        view.putIntArray("posZ",posZ);
    }

    @Override
    protected void readData(ReadView view) {
        Inventories.readData(view, inventory);
        arraylength = view.getInt("arraylength", arraylength);
        posX=view.getOptionalIntArray("posX").orElse(new int[arraylength]);
        posY=view.getOptionalIntArray("posY").orElse(new int[arraylength]);
        posZ=view.getOptionalIntArray("posZ").orElse(new int[arraylength]);
        super.readData(view);
        transferFromArrays();
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Teleporter Block");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new TeleporterBlockScreenHandler(syncId, inv, this.pos);
    }
}
