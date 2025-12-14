package net.b34tzepz.betterbuilding.util;


import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> REINFORCED_BLOCKS = createTag("reinforced_blocks");
        public static final TagKey<Block> REINFORCED_PLANKS = createTag("reinforced_planks");
        public static final TagKey<Block> REINFORCED_LOGS = createTag("reinforced_logs");
        public static final TagKey<Block> REINFORCED_WOODS = createTag("reinforced_woods");
        public static final TagKey<Block> SIDES = createTag("sides");
        public static final TagKey<Block> WOODEN_SIDES = createTag("wooden_sides");
        public static final TagKey<Block> CORNERS = createTag("corners");
        public static final TagKey<Block> WOODEN_CORNERS = createTag("wooden_corners");
        public static final TagKey<Block> PILLARS = createTag("pillars");
        public static final TagKey<Block> WOODEN_PILLARS = createTag("wooden_pillars");
        public static final TagKey<Block> PLANK_PILLARS = createTag("plank_pillars");
        public static final TagKey<Block> LOG_PILLARS = createTag("log_pillars");
        public static final TagKey<Block> TABLES = createTag("tables");
        public static final TagKey<Block> CHAIRS = createTag("chairs");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BetterBuilding.MOD_ID, name));
        }

        private  static TagKey<Block> createCommonTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
        }
    }

    public static class Items{
        public static final TagKey<Item> REINFORCED_BLOCKS = createTag("reinforced_blocks");
        public static final TagKey<Item> REINFORCED_PLANKS = createTag("reinforced_planks");
        public static final TagKey<Item> REINFORCED_LOGS = createTag("reinforced_logs");
        public static final TagKey<Item> REINFORCED_WOODS = createTag("reinforced_woods");
        public static final TagKey<Item> SIDES = createTag("sides");
        public static final TagKey<Item> WOODEN_SIDES = createTag("wooden_sides");
        public static final TagKey<Item> CORNERS = createTag("corners");
        public static final TagKey<Item> WOODEN_CORNERS = createTag("wooden_corners");
        public static final TagKey<Item> PILLARS = createTag("pillars");
        public static final TagKey<Item> WOODEN_PILLARS = createTag("wooden_pillars");
        public static final TagKey<Item> PLANK_PILLARS = createTag("plank_pillars");
        public static final TagKey<Item> LOG_PILLARS = createTag("log_pillars");
        public static final TagKey<Item> TABLES = createTag("tables");
        public static final TagKey<Item> CHAIRS = createTag("chairs");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BetterBuilding.MOD_ID, name));
        }

        private  static TagKey<Item> createCommonTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("c", name));
        }
    }
}
