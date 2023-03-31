package net.b34tzepz.betterbuilding.util;


import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> DOWSING_ROD_DETECTABLE_BLOCKS = createTag("dowsing_rod_detectable_blocks");
        public static final TagKey<Block> TRANSFORMABLE_TO_PILLAR = createTag("transformable_to_pillar");
        public static final TagKey<Block> SIDES = createTag("sides");
        public static final TagKey<Block> CORNERS = createTag("corners");
        public static final TagKey<Block> WOODEN_SIDES = createTag("wooden_sides");
        public static final TagKey<Block> WOODEN_CORNERS = createTag("wooden_corners");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(BetterBuilding.MOD_ID, name));
        }

        private  static TagKey<Block> createCommonTag(String name){
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items{
        public static final TagKey<Item> SIDES = createTag("sides");
        public static final TagKey<Item> CORNERS = createTag("corners");
        public static final TagKey<Item> WOODEN_SIDES = createTag("wooden_sides");
        public static final TagKey<Item> WOODEN_CORNERS = createTag("wooden_corners");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(Registry.ITEM_KEY, new Identifier(BetterBuilding.MOD_ID, name));
        }

        private  static TagKey<Item> createCommonTag(String name){
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }
    }
}