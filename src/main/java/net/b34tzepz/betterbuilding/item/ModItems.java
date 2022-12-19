package net.b34tzepz.betterbuilding.item;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.entity.ModEntities;
import net.b34tzepz.betterbuilding.item.custom.DowsingRodItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item SCREW = registerItem("screw",              //Screw is colored because it's the icon of ModItemGroup.Building
            new Item(new FabricItemSettings().group(ModItemGroup.Building)));

    public static final Item Table_Leg = registerItem("table_leg",
            new Item(new FabricItemSettings().group(ModItemGroup.Building)));

    public static final Item Dowsing_Rod = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.Building).maxDamage(64)));

    public static final Item RACCOON_SPAWN_EGG = registerItem("raccoon_spawn_egg",
            new SpawnEggItem(ModEntities.RACCOON,0x948e8d, 0x3b3635,
                    new FabricItemSettings().group(ModItemGroup.Building)));

    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER,0xfcb603, 0x242321,
                    new FabricItemSettings().group(ModItemGroup.Building)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BetterBuilding.LOGGER.info("Registering Mod Items for BetterBuilding" + BetterBuilding.MOD_ID);
    }
}
