package net.zuiron.photosynthesis.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.entity.custom.AlligatorEntity;
import net.zuiron.photosynthesis.sound.ModSoundEvents;

public class AlligatorAttackGoal extends MeleeAttackGoal {
    private final AlligatorEntity entity;
    private int attackDelay = 8; //5
    private int ticksUntilNextAttack = 7; //14
    private boolean shouldCountTillNextAttack = false;

    public AlligatorAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((AlligatorEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 8;
        ticksUntilNextAttack = 7;
    }

    @Override
    protected void attack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getSquaredMaxAttackDistance(pEnemy);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
        this.mob.getWorld().playSound(null, this.mob.getBlockPos(), ModSoundEvents.ALLIGATOR_ATTACK_SOUND_EVENT, SoundCategory.HOSTILE, 1.0F, 0.8f + this.mob.getWorld().random.nextFloat() * 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
