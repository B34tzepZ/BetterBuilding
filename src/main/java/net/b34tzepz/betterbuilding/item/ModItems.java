package net.b34tzepz.betterbuilding.item;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.item.custom.ChiselItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item SCREW = registerItem("screw",              //Screw is colored because it's the icon of ModItemGroup.Building
            new Item(new FabricItemSettings()));

    public static final Item TABLE_LEG = registerItem("table_leg",
            new Item(new FabricItemSettings()));

    public static final Item CHISEL = registerItem("chisel",
            new ChiselItem(new FabricItemSettings().maxDamage(64)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BetterBuilding.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterBuilding.LOGGER.info("Registering Mod Items for BetterBuilding" + BetterBuilding.MOD_ID);
    }
}
