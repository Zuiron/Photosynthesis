package net.zuiron.photosynthesis.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.zuiron.photosynthesis.entity.ModEntities;
import net.zuiron.photosynthesis.entity.ai.AlligatorAttackGoal;
import net.zuiron.photosynthesis.sound.ModSoundEvents;
import org.jetbrains.annotations.Nullable;

public class AlligatorEntity extends AnimalEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(AlligatorEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public AlligatorEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0f);
        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 0.0f);
        this.moveControl = new AquaticMoveControl(this, 85, 6, 1.2f, 1.0f, true);
        this.setStepHeight(1.5f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new AlligatorAttackGoal(this, 1.2D, true));
        this.goalSelector.add(1, new FollowParentGoal(this, 1.0D));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0D, 30));
        this.targetSelector.add(1, new ActiveTargetGoal<PlayerEntity>((MobEntity)this, PlayerEntity.class, true));
        this.targetSelector.add(0, new RevengeGoal(this));
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0 && !this.isInsideWaterOrBubbleColumn()) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 15; // THIS IS LENGTH OF ANIMATION IN TICKS
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    protected void updateLimbs(float v) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.isLogicalSideForUpdatingMovement() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.6));
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    public void tick() {
        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }

        //fixes so alligator can walk out of water.
        if (this.horizontalCollision && this.isInsideWaterOrBubbleColumn()) {
            this.setVelocity(this.getVelocity().add(0D,0.1D,0D));
        }

        super.tick();
    }

    public static DefaultAttributeContainer.Builder createAlligatorAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50)
                .add(EntityAttributes.GENERIC_ARMOR, 15)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.ALLIGATOR.create(world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.ALLIGATOR_AMBIENT_SOUND_EVENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.ALLIGATOR_HURT_SOUND_EVENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSoundEvents.ALLIGATOR_HURT_SOUND_EVENT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_FROG_STEP, 0.15f, 1.0f);
    }

    public static boolean isValidSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.FROGS_SPAWNABLE_ON);
    }
}
