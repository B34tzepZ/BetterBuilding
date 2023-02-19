package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.block.entity.ModBlockEntities;
import net.b34tzepz.betterbuilding.block.entity.TeleporterBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.LiteralText;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Random;


public class TeleporterBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty PLAYING_SOUND = BooleanProperty.of("playing_sound");
    public static final IntProperty SOUND_COOLDOWN = IntProperty.of("sound_cooldown",0,25);
    public static final IntProperty TELEPORT_COOLDOWN = IntProperty.of("teleport_cooldown",0,110);
    public boolean play_sound=true;
    public static ArrayList<BlockPos> teleporters = new ArrayList<BlockPos>();

    public TeleporterBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(PLAYING_SOUND, false));
        this.setDefaultState((BlockState)this.getDefaultState().with(SOUND_COOLDOWN, 0));
        this.setDefaultState((BlockState)this.getDefaultState().with(TELEPORT_COOLDOWN, 0));
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }


    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING,PLAYING_SOUND, SOUND_COOLDOWN,TELEPORT_COOLDOWN);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.isClient) teleporters.add(pos);
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof TeleporterBlockEntity) {
                ItemScatterer.spawn(world, pos, (TeleporterBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            teleporters.remove(pos);
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(state.get(TELEPORT_COOLDOWN)<100)world.setBlockState(pos, state.with(TELEPORT_COOLDOWN, state.get(TELEPORT_COOLDOWN)+2), NOTIFY_ALL);
        if(state.get(TELEPORT_COOLDOWN)>=100){
            BlockEntity origin =world.getBlockEntity(pos);
            BlockPos destination= null;
            int destnumber=0;
            if(origin instanceof TeleporterBlockEntity){
                for (BlockPos destpos:
                     teleporters) {
                    if(!destpos.equals(pos)){
                        BlockEntity destinationEntity=world.getBlockEntity(destpos);
                        if(destinationEntity instanceof TeleporterBlockEntity){
                            if(((TeleporterBlockEntity) destinationEntity).getItem().equals(((TeleporterBlockEntity) origin).getItem())){
                                destnumber+=1;
                                destination=destpos;
                                if(destnumber>1){
                                    break; //too many teleporters with same identifier item
                                }
                            }
                        }
                    }
                }
            }
            if(destnumber==1){
                entity.teleport(destination.getX(),destination.getY()+1,destination.getZ());
            }
            else if(destnumber<1){
                if (!world.isClient) if (entity instanceof PlayerEntity) ((PlayerEntity) entity).sendMessage(new LiteralText("There is no different teleporter with this identifier item."), false);
            }
            else {
                if (!world.isClient) if (entity instanceof PlayerEntity) ((PlayerEntity) entity).sendMessage(new LiteralText("There are too many teleporters with this identifier item: "+(destnumber+1)), false);
            }

            world.setBlockState(pos, state.with(TELEPORT_COOLDOWN, 0), NOTIFY_ALL);
        }

        if (world.isClient) {
            if (!play_sound &&state.get(SOUND_COOLDOWN) == 0) {
                play_sound=true;
                world.setBlockState(pos, state.with(PLAYING_SOUND, false), NOTIFY_ALL);
            }
        }
        else {
            if(state.get(SOUND_COOLDOWN)<25) world.setBlockState(pos, state.with(SOUND_COOLDOWN, state.get(SOUND_COOLDOWN)+1), NOTIFY_ALL);
            if(play_sound){
                world.setBlockState(pos, state.with(PLAYING_SOUND, true), NOTIFY_ALL);
                world.playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_PORTAL_TRAVEL,
                        SoundCategory.BLOCKS,
                        1f,
                        1f
                );
            }
            play_sound=false;

        }
        super.onSteppedOn(world, pos, state, entity);
    }


    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if(state.get(TELEPORT_COOLDOWN)>0)world.setBlockState(pos, state.with(TELEPORT_COOLDOWN, state.get(TELEPORT_COOLDOWN)-1), NOTIFY_ALL);
        if(!state.get(PLAYING_SOUND)&&state.get(SOUND_COOLDOWN)<25) {
            world.setBlockState(pos, state.with(SOUND_COOLDOWN, state.get(SOUND_COOLDOWN)+1), NOTIFY_ALL);
        }
        if(state.get(SOUND_COOLDOWN)>=25&&state.get(PLAYING_SOUND)){
            world.setBlockState(pos, state.with(SOUND_COOLDOWN, 0), NOTIFY_ALL);
        }
        else if(state.get(SOUND_COOLDOWN)>=25){
            world.setBlockState(pos, state.with(PLAYING_SOUND, true), NOTIFY_ALL);
        }

        double d = (double)pos.getX() + random.nextDouble();
        double e = (double)pos.getY() + 0.8;
        double f = (double)pos.getZ() + random.nextDouble();
        world.addParticle(ParticleTypes.PORTAL, d, e, f, 0.0, 0.0, 0.0);
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TeleporterBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {

        return checkType(type, ModBlockEntities.TELEPORTER_BLOCK, TeleporterBlockEntity::tick);
    }
}
