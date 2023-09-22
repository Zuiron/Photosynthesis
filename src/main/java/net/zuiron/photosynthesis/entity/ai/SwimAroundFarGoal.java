package net.zuiron.photosynthesis.entity.ai;

import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class SwimAroundFarGoal extends WanderAroundGoal {
    public SwimAroundFarGoal(PathAwareEntity pathAwareEntity, double speed, int chance) {
        super(pathAwareEntity, speed, chance);
    }

    @Override
    @Nullable
    protected Vec3d getWanderTarget() {
        return LookTargetUtil.find(this.mob, 16, 7);
    }
}
