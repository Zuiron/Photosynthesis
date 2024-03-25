package net.zuiron.photosynthesis.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
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

    private int selected_1 = -1;
    private int selected_2 = -1;
    public CropSticksBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CROPSTICKS, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return CropSticksBlockEntity.this.progress;
                    case 1: return CropSticksBlockEntity.this.maxProgress;
                    case 2: return CropSticksBlockEntity.this.selected_1;
                    case 3: return CropSticksBlockEntity.this.selected_2;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: CropSticksBlockEntity.this.progress = value; break;
                    case 1: CropSticksBlockEntity.this.maxProgress = value; break;
                    case 2: CropSticksBlockEntity.this.selected_1 = value; break;
                    case 3: CropSticksBlockEntity.this.selected_2 = value; break;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("cropsticks.progress", progress);
        nbt.putInt("cropsticks.cookingTime", maxProgress);
        nbt.putInt("cropsticks.selected_1", selected_1);
        nbt.putInt("cropsticks.selected_2", selected_2);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        progress = nbt.getInt("cropsticks.progress");
        maxProgress = nbt.getInt("cropsticks.cookingTime");
        selected_1 = nbt.getInt("cropsticks.selected_1");
        selected_2 = nbt.getInt("cropsticks.selected_2");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void resetSelection() {
        this.selected_1 = -1;
        this.selected_2 = -1;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, CropSticksBlockEntity entity) {
        if (world.isClient()) {
            return;
        }
        if(hasRecipe(entity)) {
            entity.progress++;
            Photosynthesis.LOGGER.info("found match in recipes! Working...");
            Photosynthesis.LOGGER.info("progress: "+entity.progress+"/"+entity.maxProgress);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            entity.resetSelection();
        }
    }

    private static void craftItem(CropSticksBlockEntity entity) {
        Photosynthesis.LOGGER.info("crafting item!");

        SimpleInventory inventory = new SimpleInventory(3);

        ItemStack seed_n = entity.world.getBlockState(entity.pos.north()).getBlock().asItem().getDefaultStack();    //selected - 0
        ItemStack seed_s = entity.world.getBlockState(entity.pos.south()).getBlock().asItem().getDefaultStack();    //selected - 1
        ItemStack seed_e = entity.world.getBlockState(entity.pos.east()).getBlock().asItem().getDefaultStack();     //selected - 2
        ItemStack seed_w = entity.world.getBlockState(entity.pos.west()).getBlock().asItem().getDefaultStack();     //selected - 3
        ItemStack[] seeds = {seed_n, seed_s, seed_e, seed_w};

        inventory.setStack(0, seeds[entity.selected_1]);
        inventory.setStack(1, seeds[entity.selected_2]);
        inventory.setStack(2, entity.world.getBlockState(entity.pos.down()).getBlock().asItem().getDefaultStack());

        Optional<CropSticksRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(CropSticksRecipe.Type.INSTANCE, inventory, entity.getWorld());

        ItemStack output = recipe.get().getOutputStack().getItem().getDefaultStack();

        Photosynthesis.LOGGER.info("crafted item complete! output should be: "+output);

        entity.resetProgress();
        entity.resetSelection();
    }

    private static boolean hasRecipe(CropSticksBlockEntity entity) {
        int checkSize = 3;
        SimpleInventory inventory = new SimpleInventory(checkSize);
        for (int i = 0; i < checkSize; i++) {
            Random random = new Random();

            ItemStack seed_n = entity.world.getBlockState(entity.pos.north()).getBlock().asItem().getDefaultStack();    //selected - 0
            ItemStack seed_s = entity.world.getBlockState(entity.pos.south()).getBlock().asItem().getDefaultStack();    //selected - 1
            ItemStack seed_e = entity.world.getBlockState(entity.pos.east()).getBlock().asItem().getDefaultStack();     //selected - 2
            ItemStack seed_w = entity.world.getBlockState(entity.pos.west()).getBlock().asItem().getDefaultStack();     //selected - 3

            //if all is empty. return false.
            if(seed_n.isEmpty() && seed_s.isEmpty() && seed_e.isEmpty() && seed_w.isEmpty()) {
                return false;
            }

            ItemStack[] seeds = {seed_n, seed_s, seed_e, seed_w};

            //double check if something has changed.
            if(entity.selected_1 != -1) {
                ItemStack selected_seed = seeds[entity.selected_1];
                if(selected_seed.isEmpty()) {
                    entity.selected_1 = -1;
                    entity.resetProgress();
                }
            }
            if(entity.selected_2 != -1) {
                ItemStack selected_seed = seeds[entity.selected_2];
                if(selected_seed.isEmpty()) {
                    entity.selected_2 = -1;
                    entity.resetProgress();
                }
            }

            //random selection - if not selected...
            if(entity.selected_1 == -1 || entity.selected_2 == -1) {
                int randomIndex = random.nextInt(seeds.length);

                if (i == 2) {
                    inventory.setStack(i, entity.world.getBlockState(entity.pos.down()).getBlock().asItem().getDefaultStack());
                } else {
                    ItemStack rando_seed = seeds[randomIndex];

                    //save selection.
                    if(!rando_seed.isEmpty()) {
                        if(i == 0) {
                            entity.selected_1 = randomIndex;
                        }
                        if (i == 1) {
                            entity.selected_2 = randomIndex;
                        }
                    }

                    //if empty... loop until we fill both slots.
                    while (rando_seed.isEmpty()) {
                        int newRandom = random.nextInt(seeds.length);

                        if(i == 0) {
                            entity.selected_1 = newRandom;
                        }
                        if(i == 1) {
                            entity.selected_2 = newRandom;
                        }

                        rando_seed = seeds[newRandom];
                    }

                    inventory.setStack(i, rando_seed);
                }
            } else {
                Photosynthesis.LOGGER.info(entity.selected_1+" , "+entity.selected_2);
                if(i == 0) {
                    inventory.setStack(i, seeds[entity.selected_1]);
                } else if (i == 1) {
                    inventory.setStack(i, seeds[entity.selected_2]);
                } else {
                    inventory.setStack(i, entity.world.getBlockState(entity.pos.down()).getBlock().asItem().getDefaultStack());
                }
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
