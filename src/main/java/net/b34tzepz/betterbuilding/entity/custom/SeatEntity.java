package net.b34tzepz.betterbuilding.entity.custom;

import com.google.common.collect.Lists;
import net.b34tzepz.betterbuilding.entity.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class SeatEntity extends Entity {

    public SeatEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

/*    public SeatEntity(World world, double x, double y, double z){
        super(ModEntities.SEAT,world);
        this.setPosition(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }*/

    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
    return dimensions.height;
}

    public boolean collidesWith(Entity other){
        return false;
    }



    public boolean isCollidable() {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    public double getMountedHeightOffset() {
        return -0.1;
    }

    public boolean collides() {
        return false;
    }

    public Direction getMovementDirection() {
        return this.getHorizontalFacing().rotateYClockwise();
    }

    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        Vec3d vec3d = getPassengerDismountOffset((double)(this.getWidth() * MathHelper.SQUARE_ROOT_OF_TWO), (double)passenger.getWidth(), passenger.getYaw());
        double d = this.getX() + vec3d.x;
        double e = this.getZ() + vec3d.z;
        BlockPos blockPos = new BlockPos(d, this.getBoundingBox().maxY, e);
        BlockPos blockPos2 = blockPos.down();
        if (!this.world.isWater(blockPos2)) {
            List<Vec3d> list = Lists.newArrayList();
            double f = this.world.getDismountHeight(blockPos);
            if (Dismounting.canDismountInBlock(f)) {
                list.add(new Vec3d(d, (double)blockPos.getY() + f, e));
            }

            double g = this.world.getDismountHeight(blockPos2);
            if (Dismounting.canDismountInBlock(g)) {
                list.add(new Vec3d(d, (double)blockPos2.getY() + g, e));
            }

            for (EntityPose entityPose : passenger.getPoses()) {

                for (Vec3d vec3d2 : list) {
                    if (Dismounting.canPlaceEntityAt(this.world, vec3d2, passenger, entityPose)) {
                        passenger.setPose(entityPose);
                        return vec3d2;
                    }
                }
            }
        }

        return super.updatePassengerForDismount(passenger);
    }

    protected void copyEntityData(Entity entity) {
        entity.setBodyYaw(this.getYaw());
        float f = MathHelper.wrapDegrees(entity.getYaw() - this.getYaw());
        float g = MathHelper.clamp(f, -105.0F, 105.0F);
        entity.prevYaw += g - f;
        entity.setYaw(entity.getYaw() + g - f);
        entity.setHeadYaw(entity.getYaw());
    }

    public void onPassengerLookAround(Entity passenger) {
        this.copyEntityData(passenger);
    }

    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().size() < 1 && !this.isSubmergedIn(FluidTags.WATER);
    }

    public boolean startRiding(Entity entity) {
        return this.startRiding(entity, false);
    }


    //************************************************************************

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public Packet<?> createSpawnPacket() {
        return null;
    }
}
