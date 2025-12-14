package net.b34tzepz.betterbuilding.block.custom;

import com.mojang.serialization.MapCodec;
import net.b34tzepz.betterbuilding.block.entity.ChairEntity;
import net.b34tzepz.betterbuilding.block.entity.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.AxisRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.DirectionTransformation;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

    public class ChairBlock extends HorizontalFacingBlock {
        public static final MapCodec<ChairBlock> CODEC = createCodec(ChairBlock::new);
        public static final VoxelShape legNW = Block.createCuboidShape(0, 0, 0, 2, 8, 2);
        public static final VoxelShape legNE = Block.createCuboidShape(14, 0, 0, 16, 8, 2);
        public static final VoxelShape legSW = Block.createCuboidShape(0, 0, 14, 2, 8, 16);
        public static final VoxelShape legSE = Block.createCuboidShape(14, 0, 14, 16, 8, 16);
        public static final VoxelShape plate = Block.createCuboidShape(0, 8, 0, 16, 10, 16);
        public static final VoxelShape lean = Block.createCuboidShape(0, 10, 0, 16, 20, 2);
        public static VoxelShape SHAPE = VoxelShapes.union(legNW, legNE, legSW, legSE, plate, lean);

        public ChairBlock(Settings settings) {
            super(settings);
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
            if(!world.isClient()) {
                Entity entity;
                List<ChairEntity> entities = world.getEntitiesByType(ModEntities.CHAIR, new Box(pos), chair -> true);
                if(entities.isEmpty()) {
                    entity = ModEntities.CHAIR.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
                } else {
                    entity = entities.getFirst();
                }

                player.startRiding(entity);
            }

            return ActionResult.SUCCESS;
        }

        @Override
        protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return switch (state.get(FACING)) {
                case EAST ->
                        VoxelShapes.transform(SHAPE, DirectionTransformation.fromRotations(AxisRotation.R0, AxisRotation.R90));
                case SOUTH ->
                        VoxelShapes.transform(SHAPE, DirectionTransformation.fromRotations(AxisRotation.R0, AxisRotation.R180));
                case WEST ->
                        VoxelShapes.transform(SHAPE, DirectionTransformation.fromRotations(AxisRotation.R0, AxisRotation.R270));
                case null, default -> SHAPE;
            };
        }

        @Override
        public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return getOutlineShape(state, world, pos, context);
        }

        @Override
        protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
            return CODEC;
        }

        @Nullable
        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(FACING);
        }
    }
