package net.b34tzepz.betterbuilding.item;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.item.custom.DowsingRodItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item Screw = registerItem("screw",              //Screw is colored because its the icon of ModItemGroup.Building
            new Item(new FabricItemSettings().group(ModItemGroup.Building)));

    public static final Item Table_Leg = registerItem("table_leg",
            new Item(new FabricItemSettings().group(ModItemGroup.Building)));

    public static final Item Dowsing_Rod = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.Building).maxDamage(64)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterBuilding.LOGGER.info("Registering Mod Items for BetterBuilding" + BetterBuilding.MOD_ID);
    }
}
