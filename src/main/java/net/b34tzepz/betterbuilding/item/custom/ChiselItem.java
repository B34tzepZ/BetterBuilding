package net.b34tzepz.betterbuilding.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.block.custom.PillarBlock;
import net.b34tzepz.betterbuilding.util.ModTags;
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
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {
    protected static final Map<Block, BlockState> PILLAR_STATES = Maps.newHashMap(new ImmutableMap.Builder<Block, BlockState>().put(Blocks.OAK_LOG, ModBlocks.OAK_LOG_PILLAR.getDefaultState()).build());

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
        BlockState blockState2 = PILLAR_STATES.get(blockState.getBlock());//blockState.getBlock().getTranslationKey()
        if (Registry.BLOCK.getOrCreateEntry(Registry.BLOCK.getKey(blockState.getBlock()).get()).isIn(ModTags.Blocks.TRANSFORMABLE_TO_PILLAR)) {  //Registry.BLOCK.getOrCreateEntry(Registry.BLOCK.getKey(blockState.getBlock()).get()).isIn(ModTags.Blocks.TRANSFORMABLE_TO_PILLAR)
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
