package net.b34tzepz.betterbuilding.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.block.custom.PillarBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import java.util.Map;

public class ChiselItem extends Item {
        public static final Map<Block, BlockState> PILLAR_STATES = Maps.newHashMap(new ImmutableMap.Builder<Block, BlockState>()
                .put(Blocks.STONE, ModBlocks.Pillars.STONE_PILLAR.getDefaultState())
                .put(Blocks.GRANITE, ModBlocks.Pillars.GRANITE_PILLAR.getDefaultState())
                .put(Blocks.POLISHED_GRANITE, ModBlocks.Pillars.POLISHED_GRANITE_PILLAR.getDefaultState())
                .put(Blocks.DIORITE, ModBlocks.Pillars.DIORITE_PILLAR.getDefaultState())
                .put(Blocks.POLISHED_DIORITE, ModBlocks.Pillars.POLISHED_DIORITE_PILLAR.getDefaultState())
                .put(Blocks.ANDESITE, ModBlocks.Pillars.ANDESITE_PILLAR.getDefaultState())
                .put(Blocks.POLISHED_ANDESITE, ModBlocks.Pillars.POLISHED_ANDESITE_PILLAR.getDefaultState())
                .put(Blocks.DIRT, ModBlocks.Pillars.DIRT_PILLAR.getDefaultState())
                .put(Blocks.COARSE_DIRT, ModBlocks.Pillars.COARSE_DIRT_PILLAR.getDefaultState())
                .put(Blocks.COBBLESTONE, ModBlocks.Pillars.COBBLESTONE_PILLAR.getDefaultState())
                .put(Blocks.OAK_PLANKS, ModBlocks.Pillars.OAK_PLANKS_PILLAR.getDefaultState())
                .put(Blocks.SPRUCE_PLANKS, ModBlocks.Pillars.SPRUCE_PLANKS_PILLAR.getDefaultState())
                .put(Blocks.BIRCH_PLANKS, ModBlocks.Pillars.BIRCH_PLANKS_PILLAR.getDefaultState())
                .put(Blocks.JUNGLE_PLANKS, ModBlocks.Pillars.JUNGLE_PLANKS_PILLAR.getDefaultState())
                .put(Blocks.ACACIA_PLANKS, ModBlocks.Pillars.ACACIA_PLANKS_PILLAR.getDefaultState())
                .put(Blocks.DARK_OAK_PLANKS, ModBlocks.Pillars.DARK_OAK_PLANKS_PILLAR.getDefaultState())
                .put(Blocks.BEDROCK, ModBlocks.Pillars.BEDROCK_PILLAR.getDefaultState())
                .put(Blocks.LAPIS_BLOCK, ModBlocks.Pillars.LAPIS_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.SANDSTONE, ModBlocks.Pillars.SANDSTONE_PILLAR.getDefaultState())
                .put(Blocks.CHISELED_SANDSTONE, ModBlocks.Pillars.CHISELED_SANDSTONE_PILLAR.getDefaultState())
                .put(Blocks.CUT_SANDSTONE, ModBlocks.Pillars.CUT_SANDSTONE_PILLAR.getDefaultState())
                .put(Blocks.WHITE_WOOL, ModBlocks.Pillars.WHITE_WOOL_PILLAR.getDefaultState())
                .put(Blocks.ORANGE_WOOL, ModBlocks.Pillars.ORANGE_WOOL_PILLAR.getDefaultState())
                .put(Blocks.MAGENTA_WOOL, ModBlocks.Pillars.MAGENTA_WOOL_PILLAR.getDefaultState())
                .put(Blocks.LIGHT_BLUE_WOOL, ModBlocks.Pillars.LIGHT_BLUE_WOOL_PILLAR.getDefaultState())
                .put(Blocks.YELLOW_WOOL, ModBlocks.Pillars.YELLOW_WOOL_PILLAR.getDefaultState())
                .put(Blocks.LIME_WOOL, ModBlocks.Pillars.LIME_WOOL_PILLAR.getDefaultState())
                .put(Blocks.PINK_WOOL, ModBlocks.Pillars.PINK_WOOL_PILLAR.getDefaultState())
                .put(Blocks.GRAY_WOOL, ModBlocks.Pillars.GRAY_WOOL_PILLAR.getDefaultState())
                .put(Blocks.LIGHT_GRAY_WOOL, ModBlocks.Pillars.LIGHT_GRAY_WOOL_PILLAR.getDefaultState())
                .put(Blocks.CYAN_WOOL, ModBlocks.Pillars.CYAN_WOOL_PILLAR.getDefaultState())
                .put(Blocks.PURPLE_WOOL, ModBlocks.Pillars.PURPLE_WOOL_PILLAR.getDefaultState())
                .put(Blocks.BLUE_WOOL, ModBlocks.Pillars.BLUE_WOOL_PILLAR.getDefaultState())
                .put(Blocks.BROWN_WOOL, ModBlocks.Pillars.BROWN_WOOL_PILLAR.getDefaultState())
                .put(Blocks.GREEN_WOOL, ModBlocks.Pillars.GREEN_WOOL_PILLAR.getDefaultState())
                .put(Blocks.RED_WOOL, ModBlocks.Pillars.RED_WOOL_PILLAR.getDefaultState())
                .put(Blocks.BLACK_WOOL, ModBlocks.Pillars.BLACK_WOOL_PILLAR.getDefaultState())
                .put(Blocks.GOLD_BLOCK, ModBlocks.Pillars.GOLD_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.IRON_BLOCK, ModBlocks.Pillars.IRON_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.BRICKS, ModBlocks.Pillars.BRICKS_PILLAR.getDefaultState())
                .put(Blocks.BOOKSHELF, ModBlocks.Pillars.BOOKSHELF_PILLAR.getDefaultState())
                .put(Blocks.MOSSY_COBBLESTONE, ModBlocks.Pillars.MOSSY_COBBLESTONE_PILLAR.getDefaultState())
                .put(Blocks.OBSIDIAN, ModBlocks.Pillars.OBSIDIAN_PILLAR.getDefaultState())
                .put(Blocks.DIAMOND_BLOCK, ModBlocks.Pillars.DIAMOND_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.SNOW_BLOCK, ModBlocks.Pillars.SNOW_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.CLAY, ModBlocks.Pillars.CLAY_PILLAR.getDefaultState())
                .put(Blocks.SOUL_SOIL, ModBlocks.Pillars.SOUL_SOIL_PILLAR.getDefaultState())
                .put(Blocks.GLOWSTONE, ModBlocks.Pillars.GLOWSTONE_PILLAR.getDefaultState())
                .put(Blocks.STONE_BRICKS, ModBlocks.Pillars.STONE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.MOSSY_STONE_BRICKS, ModBlocks.Pillars.MOSSY_STONE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.CRACKED_STONE_BRICKS, ModBlocks.Pillars.CRACKED_STONE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.CHISELED_STONE_BRICKS, ModBlocks.Pillars.CHISELED_STONE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.NETHER_BRICKS, ModBlocks.Pillars.NETHER_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.END_STONE, ModBlocks.Pillars.END_STONE_PILLAR.getDefaultState())
                .put(Blocks.EMERALD_BLOCK, ModBlocks.Pillars.EMERALD_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.QUARTZ_BLOCK, ModBlocks.Pillars.QUARTZ_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.CHISELED_QUARTZ_BLOCK, ModBlocks.Pillars.CHISELED_QUARTZ_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.WHITE_TERRACOTTA, ModBlocks.Pillars.WHITE_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.ORANGE_TERRACOTTA, ModBlocks.Pillars.ORANGE_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.MAGENTA_TERRACOTTA, ModBlocks.Pillars.MAGENTA_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.Pillars.LIGHT_BLUE_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.YELLOW_TERRACOTTA, ModBlocks.Pillars.YELLOW_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.LIME_TERRACOTTA, ModBlocks.Pillars.LIME_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.PINK_TERRACOTTA, ModBlocks.Pillars.PINK_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.GRAY_TERRACOTTA, ModBlocks.Pillars.GRAY_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.Pillars.LIGHT_GRAY_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.CYAN_TERRACOTTA, ModBlocks.Pillars.CYAN_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.PURPLE_TERRACOTTA, ModBlocks.Pillars.PURPLE_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.BLUE_TERRACOTTA, ModBlocks.Pillars.BLUE_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.BROWN_TERRACOTTA, ModBlocks.Pillars.BROWN_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.GREEN_TERRACOTTA, ModBlocks.Pillars.GREEN_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.RED_TERRACOTTA, ModBlocks.Pillars.RED_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.BLACK_TERRACOTTA, ModBlocks.Pillars.BLACK_TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.PRISMARINE, ModBlocks.Pillars.PRISMARINE_PILLAR.getDefaultState())
                .put(Blocks.PRISMARINE_BRICKS, ModBlocks.Pillars.PRISMARINE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.DARK_PRISMARINE, ModBlocks.Pillars.DARK_PRISMARINE_PILLAR.getDefaultState())
                .put(Blocks.SEA_LANTERN, ModBlocks.Pillars.SEA_LANTERN_PILLAR.getDefaultState())
                .put(Blocks.TERRACOTTA, ModBlocks.Pillars.TERRACOTTA_PILLAR.getDefaultState())
                .put(Blocks.COAL_BLOCK, ModBlocks.Pillars.COAL_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.PACKED_ICE, ModBlocks.Pillars.PACKED_ICE_PILLAR.getDefaultState())
                .put(Blocks.RED_SANDSTONE, ModBlocks.Pillars.RED_SANDSTONE_PILLAR.getDefaultState())
                .put(Blocks.CHISELED_RED_SANDSTONE, ModBlocks.Pillars.CHISELED_RED_SANDSTONE_PILLAR.getDefaultState())
                .put(Blocks.CUT_RED_SANDSTONE, ModBlocks.Pillars.CUT_RED_SANDSTONE_PILLAR.getDefaultState())
                .put(Blocks.SMOOTH_STONE, ModBlocks.Pillars.SMOOTH_STONE_PILLAR.getDefaultState())
                .put(Blocks.SMOOTH_SANDSTONE, ModBlocks.Pillars.SMOOTH_SANDSTONE_PILLAR.getDefaultState())
                .put(Blocks.SMOOTH_QUARTZ, ModBlocks.Pillars.SMOOTH_QUARTZ_PILLAR.getDefaultState())
                .put(Blocks.SMOOTH_RED_SANDSTONE, ModBlocks.Pillars.SMOOTH_RED_SANDSTONE_PILLAR.getDefaultState())
                .put(Blocks.PURPUR_BLOCK, ModBlocks.Pillars.PURPUR_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.END_STONE_BRICKS, ModBlocks.Pillars.END_STONE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.NETHER_WART_BLOCK, ModBlocks.Pillars.NETHER_WART_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.RED_NETHER_BRICKS, ModBlocks.Pillars.RED_NETHER_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.WHITE_CONCRETE, ModBlocks.Pillars.WHITE_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.ORANGE_CONCRETE, ModBlocks.Pillars.ORANGE_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.MAGENTA_CONCRETE, ModBlocks.Pillars.MAGENTA_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.Pillars.LIGHT_BLUE_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.YELLOW_CONCRETE, ModBlocks.Pillars.YELLOW_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.LIME_CONCRETE, ModBlocks.Pillars.LIME_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.PINK_CONCRETE, ModBlocks.Pillars.PINK_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.GRAY_CONCRETE, ModBlocks.Pillars.GRAY_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.Pillars.LIGHT_GRAY_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.CYAN_CONCRETE, ModBlocks.Pillars.CYAN_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.PURPLE_CONCRETE, ModBlocks.Pillars.PURPLE_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.BLUE_CONCRETE, ModBlocks.Pillars.BLUE_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.BROWN_CONCRETE, ModBlocks.Pillars.BROWN_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.GREEN_CONCRETE, ModBlocks.Pillars.GREEN_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.RED_CONCRETE, ModBlocks.Pillars.RED_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.BLACK_CONCRETE, ModBlocks.Pillars.BLACK_CONCRETE_PILLAR.getDefaultState())
                .put(Blocks.DRIED_KELP_BLOCK, ModBlocks.Pillars.DRIED_KELP_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.DEAD_TUBE_CORAL_BLOCK, ModBlocks.Pillars.DEAD_TUBE_CORAL_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.DEAD_BRAIN_CORAL_BLOCK, ModBlocks.Pillars.DEAD_BRAIN_CORAL_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.DEAD_BUBBLE_CORAL_BLOCK, ModBlocks.Pillars.DEAD_BUBBLE_CORAL_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.DEAD_FIRE_CORAL_BLOCK, ModBlocks.Pillars.DEAD_FIRE_CORAL_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.DEAD_HORN_CORAL_BLOCK, ModBlocks.Pillars.DEAD_HORN_CORAL_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.WARPED_WART_BLOCK, ModBlocks.Pillars.WARPED_WART_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.SHROOMLIGHT, ModBlocks.Pillars.SHROOMLIGHT_PILLAR.getDefaultState())
                .put(Blocks.CRIMSON_PLANKS, ModBlocks.Pillars.CRIMSON_PLANKS_PILLAR.getDefaultState())
                .put(Blocks.WARPED_PLANKS, ModBlocks.Pillars.WARPED_PLANKS_PILLAR.getDefaultState())
                .put(Blocks.HONEYCOMB_BLOCK, ModBlocks.Pillars.HONEYCOMB_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.NETHERITE_BLOCK, ModBlocks.Pillars.NETHERITE_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.ANCIENT_DEBRIS, ModBlocks.Pillars.ANCIENT_DEBRIS_PILLAR.getDefaultState())
                .put(Blocks.LODESTONE, ModBlocks.Pillars.LODESTONE_PILLAR.getDefaultState())
                .put(Blocks.BLACKSTONE, ModBlocks.Pillars.BLACKSTONE_PILLAR.getDefaultState())
                .put(Blocks.POLISHED_BLACKSTONE, ModBlocks.Pillars.POLISHED_BLACKSTONE_PILLAR.getDefaultState())
                .put(Blocks.POLISHED_BLACKSTONE_BRICKS, ModBlocks.Pillars.POLISHED_BLACKSTONE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, ModBlocks.Pillars.CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.CHISELED_POLISHED_BLACKSTONE, ModBlocks.Pillars.CHISELED_POLISHED_BLACKSTONE_PILLAR.getDefaultState())
                .put(Blocks.GILDED_BLACKSTONE, ModBlocks.Pillars.GILDED_BLACKSTONE_PILLAR.getDefaultState())
                .put(Blocks.CHISELED_NETHER_BRICKS, ModBlocks.Pillars.CHISELED_NETHER_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.CRACKED_NETHER_BRICKS, ModBlocks.Pillars.CRACKED_NETHER_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.QUARTZ_BRICKS, ModBlocks.Pillars.QUARTZ_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.TUFF, ModBlocks.Pillars.TUFF_PILLAR.getDefaultState())
                .put(Blocks.CALCITE, ModBlocks.Pillars.CALCITE_PILLAR.getDefaultState())
                .put(Blocks.WAXED_COPPER_BLOCK, ModBlocks.Pillars.WAXED_COPPER_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.WAXED_WEATHERED_COPPER, ModBlocks.Pillars.WAXED_WEATHERED_COPPER_PILLAR.getDefaultState())
                .put(Blocks.WAXED_EXPOSED_COPPER, ModBlocks.Pillars.WAXED_EXPOSED_COPPER_PILLAR.getDefaultState())
                .put(Blocks.WAXED_OXIDIZED_COPPER, ModBlocks.Pillars.WAXED_OXIDIZED_COPPER_PILLAR.getDefaultState())
                .put(Blocks.WAXED_OXIDIZED_CUT_COPPER, ModBlocks.Pillars.WAXED_OXIDIZED_CUT_COPPER_PILLAR.getDefaultState())
                .put(Blocks.WAXED_WEATHERED_CUT_COPPER, ModBlocks.Pillars.WAXED_WEATHERED_CUT_COPPER_PILLAR.getDefaultState())
                .put(Blocks.WAXED_EXPOSED_CUT_COPPER, ModBlocks.Pillars.WAXED_EXPOSED_CUT_COPPER_PILLAR.getDefaultState())
                .put(Blocks.WAXED_CUT_COPPER, ModBlocks.Pillars.WAXED_CUT_COPPER_PILLAR.getDefaultState())
                .put(Blocks.DRIPSTONE_BLOCK, ModBlocks.Pillars.DRIPSTONE_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.COBBLED_DEEPSLATE, ModBlocks.Pillars.COBBLED_DEEPSLATE_PILLAR.getDefaultState())
                .put(Blocks.POLISHED_DEEPSLATE, ModBlocks.Pillars.POLISHED_DEEPSLATE_PILLAR.getDefaultState())
                .put(Blocks.DEEPSLATE_TILES, ModBlocks.Pillars.DEEPSLATE_TILES_PILLAR.getDefaultState())
                .put(Blocks.DEEPSLATE_BRICKS, ModBlocks.Pillars.DEEPSLATE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.CHISELED_DEEPSLATE, ModBlocks.Pillars.CHISELED_DEEPSLATE_PILLAR.getDefaultState())
                .put(Blocks.CRACKED_DEEPSLATE_BRICKS, ModBlocks.Pillars.CRACKED_DEEPSLATE_BRICKS_PILLAR.getDefaultState())
                .put(Blocks.CRACKED_DEEPSLATE_TILES, ModBlocks.Pillars.CRACKED_DEEPSLATE_TILES_PILLAR.getDefaultState())
                .put(Blocks.SMOOTH_BASALT, ModBlocks.Pillars.SMOOTH_BASALT_PILLAR.getDefaultState())
                .put(Blocks.RAW_IRON_BLOCK, ModBlocks.Pillars.RAW_IRON_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.RAW_COPPER_BLOCK, ModBlocks.Pillars.RAW_COPPER_BLOCK_PILLAR.getDefaultState())
                .put(Blocks.RAW_GOLD_BLOCK, ModBlocks.Pillars.RAW_GOLD_BLOCK_PILLAR.getDefaultState())
                .build());

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Direction side = context.getSide();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState2 = PILLAR_STATES.get(blockState.getBlock());
        if (blockState2 != null) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0f, 1.0f);
            blockState2 = blockState2.with(PillarBlock.AXIS, side.getAxis());
        }
        if (!world.isClient) {
            world.setBlockState(blockPos, blockState2, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            if (playerEntity != null) {
                context.getStack().damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
            }
        }
        return super.useOnBlock(context);
    }
}
