package net.b34tzepz.betterbuilding.tag;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ItemTags {
    public static final TagKey<Item> WOODEN_SIDES = ItemTags.register("wooden_sides");
    public static final TagKey<Item> WOODEN_CORNERS = ItemTags.register("wooden_corners");
    public static final TagKey<Item> SIDES = ItemTags.register("sides");
    public static final TagKey<Item> CORNERS = ItemTags.register("corners");

    private ItemTags() {
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(BetterBuilding.MOD_ID, id));
    }
}
