package net.b34tzepz.betterbuilding.tag;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class BlockTags {
    public static final TagKey<Block> WOODEN_SIDES = BlockTags.register("wooden_sides");
    public static final TagKey<Block> WOODEN_CORNERS = BlockTags.register("wooden_corners");
    public static final TagKey<Block> SIDES = BlockTags.register("sides");
    public static final TagKey<Block> CORNERS = BlockTags.register("corners");

    private BlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(BetterBuilding.MOD_ID, id));
    }
}
