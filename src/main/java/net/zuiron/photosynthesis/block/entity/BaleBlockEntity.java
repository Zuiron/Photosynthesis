package net.zuiron.photosynthesis.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;

public class BaleBlockEntity extends BlockEntity {
    public BaleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BALE, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, BaleBlockEntity baleBlockEntity) {
        Photosynthesis.LOGGER.info("i am ticking. "+blockState.getBlock());
    }
}
