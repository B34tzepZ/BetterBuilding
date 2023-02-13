package net.b34tzepz.betterbuilding.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class BlockTags {
    public static final TagKey<Block> SIDES = register("sides");

    private BlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
    }
}
