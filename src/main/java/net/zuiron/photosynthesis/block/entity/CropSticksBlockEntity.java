package net.zuiron.photosynthesis.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.recipe.CookingPotRecipe;
import net.zuiron.photosynthesis.recipe.CropSticksRecipe;

import java.util.Optional;
import java.util.Random;

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
            if(hasRecipe(entity)) {
                craftItem(entity);
            } else {
                entity.resetProgress();
            }
        }
    }

    private static void craftItem(CropSticksBlockEntity entity) {

        Photosynthesis.LOGGER.info("crafting item attempt...");

        entity.resetProgress();
    }

    private static boolean hasRecipe(CropSticksBlockEntity entity) {
        int checkSize = 3;
        SimpleInventory inventory = new SimpleInventory(checkSize);
        for (int i = 0; i < checkSize; i++) {
            Random random = new Random();

            ItemStack seed_n = entity.world.getBlockState(entity.pos.north()).getBlock().asItem().getDefaultStack();
            ItemStack seed_s = entity.world.getBlockState(entity.pos.south()).getBlock().asItem().getDefaultStack();
            ItemStack seed_e = entity.world.getBlockState(entity.pos.east()).getBlock().asItem().getDefaultStack();
            ItemStack seed_w = entity.world.getBlockState(entity.pos.west()).getBlock().asItem().getDefaultStack();

            //if all is empty. return false.
            if(seed_n.isEmpty() && seed_s.isEmpty() && seed_e.isEmpty() && seed_w.isEmpty()) {
                return false;
            }

            //random selection
            ItemStack[] seeds = {seed_n, seed_s, seed_e, seed_w};
            int randomIndex = random.nextInt(seeds.length);

            if(i == 2) {
                inventory.setStack(i, entity.world.getBlockState(entity.pos.down()).getBlock().asItem().getDefaultStack());
            } else {
                ItemStack rando_seed = seeds[randomIndex];

                //loop until we fill both slots.
                while(rando_seed.isEmpty()) {
                    rando_seed = seeds[random.nextInt(seeds.length)];
                }

                inventory.setStack(i, rando_seed);
            }
        }

        Photosynthesis.LOGGER.info(inventory);

        Optional<CropSticksRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(CropSticksRecipe.Type.INSTANCE, inventory, entity.getWorld());

        entity.maxProgress = match.map(CropSticksRecipe::getCookTime).orElse(100);

        if (match.isPresent()) {
            return true;
        }
        else {
            return false;
        }
    }
}
