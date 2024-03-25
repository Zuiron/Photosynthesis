package net.zuiron.photosynthesis.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;

public class CropSticksBlockEntity extends BlockEntity {
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 100; //5sec
    public CropSticksBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CROPSTICKS, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return CropSticksBlockEntity.this.progress;
                    case 1: return CropSticksBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: CropSticksBlockEntity.this.progress = value; break;
                    case 1: CropSticksBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("cropsticks.progress", progress);
        nbt.putInt("cropsticks.cookingTime", maxProgress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        progress = nbt.getInt("cropsticks.progress");
        maxProgress = nbt.getInt("cropsticks.cookingTime");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, CropSticksBlockEntity entity) {
        if (world.isClient()) {
            return;
        }

        entity.progress++;

        if(entity.progress >= entity.maxProgress) {
            craftItem(entity);
        }
    }

    private static void craftItem(CropSticksBlockEntity entity) {

        Photosynthesis.LOGGER.info("crafting item attempt...");

        entity.resetProgress();
    }
}
