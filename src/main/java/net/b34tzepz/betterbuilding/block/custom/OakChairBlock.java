package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.block.entity.OakChairEntity;
import net.b34tzepz.betterbuilding.block.enums.ChairType;
import net.b34tzepz.betterbuilding.entity.ModEntities;
import net.b34tzepz.betterbuilding.entity.custom.SeatEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.LiteralText;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

public class OakChairBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<ChairType> TYPE = net.b34tzepz.betterbuilding.state.property.Properties.CHAIR_TYPE;
    public static BooleanProperty OCCUPIED = BooleanProperty.of("OCCUPIED");
    public HorseEntity horse=null;
    public int horseKillWaitingTime=0;
    public OakChairBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        //this.setDefaultState((this.getDefaultState().with(TYPE, ChairType.NORTH)));
    }

    private static final VoxelShape NORTH_SHAPE =

            Stream.of(
                    Block.createCuboidShape(14, 9, 2, 16, 11, 15),
                    Block.createCuboidShape(0, 9, 0, 2, 22, 2),
                    Block.createCuboidShape(2, 9, 0, 14, 21, 2),
                    Block.createCuboidShape(0, 7, 0, 16, 9, 16),
                    Block.createCuboidShape(0, 0, 14, 2, 7, 14),
                    Block.createCuboidShape(14, 0, 14, 16, 7, 16),
                    Block.createCuboidShape(0, 0, 0, 2, 7, 2),
                    Block.createCuboidShape(14, 0, 0, 16, 7, 2),
                    Block.createCuboidShape(14, 9, 0, 16, 22, 2),
                    Block.createCuboidShape(0, 9, 2, 2, 11, 15)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private static final VoxelShape EAST_SHAPE =

            Stream.of(
                    Block.createCuboidShape(1, 9, 14, 14, 11, 16),
                    Block.createCuboidShape(14, 9, 0, 16, 22, 2),
                    Block.createCuboidShape(14, 9, 2, 16, 21, 14),
                    Block.createCuboidShape(0, 7, 0, 16, 9, 16),
                    Block.createCuboidShape(0, 0, 0, 2, 7, 2),
                    Block.createCuboidShape(0, 0, 14, 2, 7, 16),
                    Block.createCuboidShape(14, 0, 0, 16, 7, 2),
                    Block.createCuboidShape(14, 0, 14, 16, 7, 16),
                    Block.createCuboidShape(14, 9, 14, 16, 22, 16),
                    Block.createCuboidShape(1, 9, 0, 14, 11, 2)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private static final VoxelShape SOUTH_SHAPE =

            Stream.of(
                    Block.createCuboidShape(0, 9, 1, 2, 11, 14),
                    Block.createCuboidShape(14, 9, 14, 16, 22, 16),
                    Block.createCuboidShape(2, 9, 14, 14, 21, 16),
                    Block.createCuboidShape(0, 7, 0, 16, 9, 16),
                    Block.createCuboidShape(14, 0, 0, 16, 7, 2),
                    Block.createCuboidShape(0, 0, 0, 2, 7, 2),
                    Block.createCuboidShape(14, 0, 14, 16, 7, 16),
                    Block.createCuboidShape(0, 0, 14, 2, 7, 16),
                    Block.createCuboidShape(0, 9, 14, 2, 22, 16),
                    Block.createCuboidShape(14, 9, 1, 16, 11, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(); //Block.createCuboidShape()


    private static final VoxelShape WEST_SHAPE =

            Stream.of(
                    Block.createCuboidShape(2, 9, 0, 15, 11, 2),
                    Block.createCuboidShape(0, 9, 14, 2, 22, 16),
                    Block.createCuboidShape(0, 9, 2, 2, 21, 14),
                    Block.createCuboidShape(0, 7, 0, 16, 9, 16),
                    Block.createCuboidShape(14, 0, 14, 16, 7, 16),
                    Block.createCuboidShape(14, 0, 0, 16, 7, 2),
                    Block.createCuboidShape(0, 0, 14, 2, 7, 16),
                    Block.createCuboidShape(0, 0, 0, 2, 7, 2),
                    Block.createCuboidShape(0, 9, 0, 2, 22, 2),
                    Block.createCuboidShape(2, 9, 14, 15, 11, 16)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        switch (dir) {
            case SOUTH:
                return SOUTH_SHAPE;

            case WEST:
                return WEST_SHAPE;

            case EAST:
                return EAST_SHAPE;
        }
        return NORTH_SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing()); //.getOpposite()
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        //if (placer instanceof PlayerEntity) ((PlayerEntity) placer).sendMessage(new LiteralText("Coords: "+pos.getX()+" "+pos.getY()+" "+pos.getZ()), false);

        super.onPlaced(world, pos, state, placer, itemStack);
    }



/**
 * hilfreich?
 https://github.com/MrCrayfish/MrCrayfishFurnitureMod/blob/1.19.X/src/main/java/com/mrcrayfish/furniture/block/ChairBlock.java
 https://github.com/MrCrayfish/MrCrayfishFurnitureMod/blob/1.19.X/src/main/java/com/mrcrayfish/furniture/entity/SeatEntity.java
 */
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        /*if (world.isClient()) {
            if (hand == Hand.MAIN_HAND) {
            }

        }*/
        //if (!world.isClient) {
           /* LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.setPosition(player.getPos());
            world.spawnEntity(lightning);*/



            //if(horse==null){
                HorseEntity horse = new HorseEntity(EntityType.HORSE,world);
                //horse.setInvulnerable(true);
                horse.setPosition(pos.getX()+0.5, pos.getY()-0.5, pos.getZ()+0.5); //Position of the chair
                horse.bondWithPlayer(player);
                horse.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, Integer.MAX_VALUE, 1,false,false));
                horse.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,Integer.MAX_VALUE,200,false,false));
                world.spawnEntity(horse);
                horse.setVelocity(0,0,0);

            //return player.startRiding(horse); //? ActionResult.CONSUME : ActionResult.PASS;
        //}
        player.startRiding(horse);
        return ActionResult.SUCCESS;
    }

    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }


    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (horse!=null){
            if(!horse.hasPlayerRider()) {
                horseKillWaitingTime+=1;
                if(horseKillWaitingTime>=3){
                    horse.kill();
                    horseKillWaitingTime=0;
                    horse=null;
                }

            }

        }
        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockPos above = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        if (!world.isAir(above)) {
            // replace(state, Blocks.AIR.getDefaultState(), world, pos,1);
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OakChairEntity(pos, state);
    }
}
