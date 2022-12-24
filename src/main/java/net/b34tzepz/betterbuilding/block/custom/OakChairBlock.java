package net.b34tzepz.betterbuilding.block.custom;

import net.b34tzepz.betterbuilding.block.entity.OakChairEntity;
import net.b34tzepz.betterbuilding.block.enums.ChairType;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
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

import java.util.Objects;
import java.util.stream.Stream;

public class OakChairBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<ChairType> TYPE = net.b34tzepz.betterbuilding.state.property.Properties.CHAIR_TYPE;
    public static BooleanProperty OCCUPIED = BooleanProperty.of("OCCUPIED");
    public static BoatEntity boat = null;

    public OakChairBlock(Settings settings){
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        //this.setDefaultState((this.getDefaultState().with(TYPE, ChairType.NORTH)));
    }

    private static final VoxelShape NORTH_SHAPE = Stream.of(
            Block.createCuboidShape(0, 12, 2, 2, 14, 15),
            Block.createCuboidShape(14, 0, 0, 16, 10, 2),
            Block.createCuboidShape(0, 0, 14, 2, 10, 16),
            Block.createCuboidShape(0, 0, 0, 2, 10, 2),
            Block.createCuboidShape(14, 12, 2, 16, 14, 15),
            Block.createCuboidShape(14, 12, 0, 16, 28, 2),
            Block.createCuboidShape(0, 12, 0, 2, 28, 2),
            Block.createCuboidShape(2, 12, 0, 14, 28, 2),
            Block.createCuboidShape(0, 10, 0, 16, 12, 16),
            Block.createCuboidShape(14, 0, 14, 16, 10, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(); //Block.createCuboidShape();

    private static final VoxelShape EAST_SHAPE = Stream.of(
            Block.createCuboidShape(1, 12, 0, 14, 14, 2),
            Block.createCuboidShape(14, 0, 14, 16, 10, 16),
            Block.createCuboidShape(0, 0, 0, 2, 10, 2),
            Block.createCuboidShape(14, 0, 0, 16, 10, 2),
            Block.createCuboidShape(1, 12, 14, 14, 14, 16),
            Block.createCuboidShape(14, 12, 14, 16, 28, 16),
            Block.createCuboidShape(14, 12, 0, 16, 28, 2),
            Block.createCuboidShape(14, 12, 2, 16, 28, 14),
            Block.createCuboidShape(0, 10, 0, 16, 12, 16),
            Block.createCuboidShape(0, 0, 14, 2, 10, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SOUTH_SHAPE = Stream.of(
            Block.createCuboidShape(14, 12, 1, 16, 14, 14),
            Block.createCuboidShape(0, 0, 14, 2, 10, 16),
            Block.createCuboidShape(14, 0, 0, 16, 10, 2),
            Block.createCuboidShape(14, 0, 14, 16, 10, 16),
            Block.createCuboidShape(0, 12, 1, 2, 14, 14),
            Block.createCuboidShape(0, 12, 14, 2, 28, 16),
            Block.createCuboidShape(14, 12, 14, 16, 28, 16),
            Block.createCuboidShape(2, 12, 14, 14, 28, 16),
            Block.createCuboidShape(0, 10, 0, 16, 12, 16),
            Block.createCuboidShape(0, 0, 0, 2, 10, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape WEST_SHAPE = Stream.of(
            Block.createCuboidShape(2, 12, 14, 15, 14, 16),
            Block.createCuboidShape(0, 0, 0, 2, 10, 2),
            Block.createCuboidShape(14, 0, 14, 16, 10, 16),
            Block.createCuboidShape(0, 0, 14, 2, 10, 16),
            Block.createCuboidShape(2, 12, 0, 15, 14, 2),
            Block.createCuboidShape(0, 12, 0, 2, 28, 2),
            Block.createCuboidShape(0, 12, 14, 2, 28, 16),
            Block.createCuboidShape(0, 12, 2, 2, 28, 14),
            Block.createCuboidShape(0, 10, 0, 16, 12, 16),
            Block.createCuboidShape(14, 0, 0, 16, 10, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        switch (dir){
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
        /*if (placer instanceof PlayerEntity) ((PlayerEntity) placer).sendMessage(new LiteralText("placed"), false);
        ZombieEntity zombie = new ZombieEntity(world);

        super.onPlaced(world, pos, state, placer, itemStack);*/
    }

   /* public boolean startRiding(Entity entity, boolean force) {
        if (entity == this.vehicle) {
            return false;
        } else {
            for(Entity entity2 = entity; entity2.vehicle != null; entity2 = entity2.vehicle) {
                if (entity2.vehicle == this) {
                    return false;
                }
            }

            if (!force && (!this.canStartRiding(entity) || !entity.canAddPassenger(this))) {
                return false;
            } else {
                if (this.hasVehicle()) {
                    this.stopRiding();
                }

                this.setPose(EntityPose.STANDING);
                this.vehicle = entity;
                this.vehicle.addPassenger(this);
                entity.streamIntoPassengers().filter((passenger) -> {
                    return passenger instanceof ServerPlayerEntity;
                }).forEach((player) -> {
                    Criteria.STARTED_RIDING.trigger((ServerPlayerEntity)player);
                });
                return true;
            }
        }
    }*/


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient()){
            if(hand == Hand.MAIN_HAND){
                //MinecartEntity minecart = new MinecartEntity(world, pos.getX(),pos.getY(),pos.getZ());
               /* BoatEntity boat = new BoatEntity(world, pos.getX(),pos.getY(),pos.getZ());
                ItemScatterer.spawn(world,pos,boat);
                player.startRiding(boat);*/ //Stuhl muss entity sein bzw im Stuhl muss entity erstellt werden
                /*CatEntity catEntity = (CatEntity) EntityType.CAT.create(world);
                if (catEntity == null) {
                    return 0;
                } else {
                    catEntity.initialize(world, world.getLocalDifficulty(pos), SpawnReason.NATURAL, (EntityData)null, (NbtCompound)null);
                    catEntity.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                    world.spawnEntityAndPassengers(catEntity);*/
                /*LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world); // Create the lightning bolt
                lightning.setPosition(player.getPos()); // Set its position. This will make the lightning bolt strike the player (probably not what you want)
                world.spawnEntity(lightning);*/


                boat = new BoatEntity(world, pos.getX(),pos.getY(),pos.getZ());
                world.spawnEntity(boat);

            }

        }
        if(!world.isClient){
            if(boat!=null){
                return player.startRiding(boat) ? ActionResult.CONSUME : ActionResult.PASS;
            }
            else {
                boat = new BoatEntity(world, pos.getX(),pos.getY(),pos.getZ());
                world.spawnEntity(boat);
                return player.startRiding(boat) ? ActionResult.CONSUME : ActionResult.PASS;
            }
        }
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
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockPos above = new BlockPos(pos.getX(),pos.getY()+1,pos.getZ());
        if(!world.isAir(above)){
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
