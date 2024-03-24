package net.zuiron.photosynthesis.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CropSticksBlockEntity extends BlockEntity {
    public CropSticksBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CROPSTICKS, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, CropSticksBlockEntity entity) {
        if (world.isClient()) {
            return;
        }
    }
}
