package net.b34tzepz.betterbuilding.item;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

import java.util.function.Function;

public class ModItems {
    public static final Item SCREW = registerItem("screw",              //Screw is colored because it's the icon of ModItemGroup.Building
            Item::new, new Item.Settings());

    public static final Item CHISEL = registerItem("chisel",
            ChiselItem::new, new Item.Settings().maxDamage(64));

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BetterBuilding.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey, item);
    }

    public static void registerModItems() {
        BetterBuilding.LOGGER.info("Registering Mod Items for BetterBuilding" + BetterBuilding.MOD_ID);
    }
}
