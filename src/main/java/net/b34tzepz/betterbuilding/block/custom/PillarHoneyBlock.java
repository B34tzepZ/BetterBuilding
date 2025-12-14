package net.b34tzepz.betterbuilding.block.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.*;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PillarHoneyBlock extends PillarBlock {
    private static final VoxelShape SHAPE = Block.createColumnShape(14.0, 0.0, 15.0);

    public PillarHoneyBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) && stateFrom.get(AXIS) == state.get(AXIS) || super.isSideInvisible(state, stateFrom, direction);
    }

    private static boolean hasHoneyBlockEffects(Entity entity) {
        return entity instanceof LivingEntity || entity instanceof AbstractMinecartEntity || entity instanceof TntEntity || entity instanceof AbstractBoatEntity;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
        if (!world.isClient) {
            world.sendEntityStatus(entity, EntityStatuses.DRIP_RICH_HONEY);
        }

        if (entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall())) {
            entity.playSound(this.soundGroup.getFallSound(), this.soundGroup.getVolume() * 0.5F, this.soundGroup.getPitch() * 0.75F);
        }
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (this.isSliding(pos, entity)) {
            this.triggerAdvancement(entity, pos);
            this.updateSlidingVelocity(entity);
            this.addCollisionEffects(world, entity);
        }

        super.onEntityCollision(state, world, pos, entity, handler);
    }

    private boolean isSliding(BlockPos pos, Entity entity) {
        if (entity.isOnGround()) {
            return false;
        } else if (entity.getY() > pos.getY() + 0.9375 - 1.0E-7) {
            return false;
        } else if ((entity.getVelocity().y / 0.98F + 0.08) >= -0.08) {
            return false;
        } else {
            double d = Math.abs(pos.getX() + 0.5 - entity.getX());
            double e = Math.abs(pos.getZ() + 0.5 - entity.getZ());
            double f = 0.4375 + entity.getWidth() / 2.0F;
            return d + 1.0E-7 > f || e + 1.0E-7 > f;
        }
    }

    private void triggerAdvancement(Entity entity, BlockPos pos) {
        if (entity instanceof ServerPlayerEntity && entity.getWorld().getTime() % 20L == 0L) {
            Criteria.SLIDE_DOWN_BLOCK.trigger((ServerPlayerEntity)entity, entity.getWorld().getBlockState(pos));
        }
    }

    private void updateSlidingVelocity(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if ((entity.getVelocity().y / 0.98F + 0.08) < -0.13) {
            double d = -0.05 / (entity.getVelocity().y / 0.98F + 0.08);
            entity.setVelocity(new Vec3d(vec3d.x * d, (-0.05 - 0.08) * 0.98F, vec3d.z * d));
        } else {
            entity.setVelocity(new Vec3d(vec3d.x, (-0.05 - 0.08) * 0.98F, vec3d.z));
        }

        entity.onLanding();
    }

    private void addCollisionEffects(World world, Entity entity) {
        if (hasHoneyBlockEffects(entity)) {
            if (world.random.nextInt(5) == 0) {
                entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
            }

            if (!world.isClient && world.random.nextInt(5) == 0) {
                world.sendEntityStatus(entity, EntityStatuses.DRIP_HONEY);
            }
        }
    }
}
