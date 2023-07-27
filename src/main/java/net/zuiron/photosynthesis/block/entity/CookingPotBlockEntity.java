package net.zuiron.photosynthesis.block.entity;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.block.custom.CookingPotBlock;
import net.zuiron.photosynthesis.config.ModConfig;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.recipe.CookingPotRecipe;
import net.zuiron.photosynthesis.screen.CookingPotScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CookingPotBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public ItemStack getRenderStack() {
        if(!this.getStack(0).isEmpty()) {
            return this.getStack(0);
        } else {
            return this.getStack(2);
        }
    }

    public void setInventory(DefaultedList<ItemStack> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    public void syncItems() {
        if(!world.isClient()) {
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(inventory.size());
            for(int i = 0; i < inventory.size(); i++) {
                data.writeItemStack(inventory.get(i));
            }
            data.writeBlockPos(getPos());

            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(player, ModMessages.ITEM_SYNC, data);
            }
        }
    }

    @Override
    public void markDirty() {
        syncItems();
        super.markDirty();
    }

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 20;

    public CookingPotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COOKINGPOT, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return CookingPotBlockEntity.this.progress;
                    case 1: return CookingPotBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: CookingPotBlockEntity.this.progress = value; break;
                    case 1: CookingPotBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal(""); //Cooking Pot
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new CookingPotScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("cookingpot.progress", progress);
        nbt.putInt("cookingpot.cookingTime", maxProgress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("cookingpot.progress");
        maxProgress = nbt.getInt("cookingpot.cookingTime");
    }

    private void resetProgress() {
        this.progress = 0;
        syncItems();
    }

    public static void animationTick(World level, BlockPos pos, BlockState state) {
        if (isBlockBelowBurning(level, pos) && level.isClient()) {
            Random random = level.random;
            if (random.nextFloat() < 0.2F) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double y = (double) pos.getY() + 1.1D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0.0D, motionY, 0.0D);
            }
            if (state.get(BooleanProperty.of("processing"))) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double y = (double) pos.getY() + 0.1D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, motionY, 0.0D); //ENCHANTED_HIT
            }
        }
    }


    public static void playCookingPotSound(World world, BlockPos blockPos) {
        if(!world.isClient()) { world.playSound(null, blockPos, Photosynthesis.COOKINGPOT_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f); }
    }

    private static int tickCounter = 0;

    public static void loopCookingPotSound(World world, BlockPos blockPos) {
        int ticksPerLoop = (int) (2 * 20);
        tickCounter++;
        if (tickCounter >= ticksPerLoop) {
            playCookingPotSound(world, blockPos);
            tickCounter = 0;
        }
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, CookingPotBlockEntity entity) {
        animationTick(world, blockPos, state);

        if(world.isClient()) {
            return;
        }
        boolean isBelowHeat = isBlockBelowBurning(world, blockPos);

        //check see if belowblock is burning, if so. enable hot texture!
        state = (BlockState)state.with(CookingPotBlock.LIT, isBelowHeat);
        world.setBlockState(blockPos, state, 3);
        if(isBelowHeat) {
            markDirty(world, blockPos, state);
        }

        if(hasRecipe(entity) && isBelowHeat) {
            entity.progress++;
            state = (BlockState)state.with(CookingPotBlock.PROCESSING, true); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);

            loopCookingPotSound(world, blockPos);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
                state = (BlockState)state.with(CookingPotBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            }
        } else {
            entity.resetProgress();
            state = (BlockState)state.with(CookingPotBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);
        }
    }

    private static boolean isBlockBelowBurning(World world, BlockPos blockPos) {
        //ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        //if(!config.requireHeatUnder) { return true; }

        BlockPos blockPosBelow = blockPos.down(); // assuming 'pos' is the BlockPos of your directional block
        BlockState blockStateBelow = world.getBlockState(blockPosBelow); // assuming 'world' is the World object

        if (blockStateBelow.getBlock() == Blocks.FURNACE ||
                blockStateBelow.getBlock() == Blocks.BLAST_FURNACE ||
                blockStateBelow.getBlock() == Blocks.SMOKER ||
                blockStateBelow.getBlock() == ModBlocks.WOOD_FIRED_STOVE ||
                blockStateBelow.getBlock() == ModBlocks.WOOD_FIRED_OVEN ||
            blockStateBelow.getBlock() == Blocks.CAMPFIRE) {
            // The block below your directional block is a furnace, blast furnace or smoker
            BlockEntity blockEntity = world.getBlockEntity(blockPosBelow);
                //if (furnaceBlockEntity.isBurning()) {
                if(blockStateBelow.get(Properties.LIT)) {
                    // The furnace below your directional block is currently smelting
                    //TODO -- if we decide to allow campfire, which is unlimited LIT. should we decrease cook time? YES!
                    return true;
                } else if(blockStateBelow.getBlock() == Blocks.CAMPFIRE && blockStateBelow.get(Properties.SIGNAL_FIRE)) {
                    return true;
                }
        }

        return false;
    }

    private static void craftItem(CookingPotBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<CookingPotRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(CookingPotRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            if(entity.getStack(0).getItem() instanceof PotionItem) {
                entity.setStack(8, new ItemStack(Items.GLASS_BOTTLE, 1));
            } else {
                //entity.setStack(8, entity.getStack(0).getRecipeRemainder());
                entity.setStack(8, new ItemStack(entity.getStack(0).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(0)));
            }

            entity.removeStack(0, (Integer) recipe.get().getCounts().get(0));   //fluid

            entity.removeStack(1, (Integer) recipe.get().getCounts().get(1));   //input
            entity.removeStack(2, (Integer) recipe.get().getCounts().get(2));   //input
            entity.removeStack(3, (Integer) recipe.get().getCounts().get(3));   //input
            entity.removeStack(4, (Integer) recipe.get().getCounts().get(4));   //input
            entity.removeStack(5, (Integer) recipe.get().getCounts().get(5));   //input
            entity.removeStack(6, (Integer) recipe.get().getCounts().get(6));   //input


            int recipeOutputCount = recipe.get().getOutputStack().getCount();
            int outputSlotCount = entity.getStack(7).getCount();

            entity.setStack(7, new ItemStack(recipe.get().getOutputStack().getItem(), outputSlotCount + recipeOutputCount));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(CookingPotBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<CookingPotRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(CookingPotRecipe.Type.INSTANCE, inventory, entity.getWorld());

        entity.maxProgress = match.map(CookingPotRecipe::getCookTime).orElse(20);

        if (match.isPresent() && inventory.getStack(7).isEmpty() && inventory.getStack(8).isEmpty()) {
            //Photosynthesis.LOGGER.info("match is present! continue");
            CookingPotRecipe recipe = match.get();
            List<Ingredient> ingredients = recipe.getIngredients();
            DefaultedList counts = recipe.getCounts();
            for (int i = 0; i < ingredients.size(); i++) {
                Ingredient ingredient = ingredients.get(i);
                ItemStack itemStack = entity.getStack(i);
                //Photosynthesis.LOGGER.info("ingredient:"+ingredient.toJson()+", itemStack:"+itemStack);

                int reqCount = (int) counts.get(i);

                if (ingredient.isEmpty() || itemStack.isEmpty()) {
                    continue;
                } else if (ingredient.test(itemStack) && itemStack.getCount() >= reqCount) {
                    //Photosynthesis.LOGGER.info("recipe requires min:"+reqCount+", we got:"+itemStack.getCount());
                    continue;
                } else {
                    //Photosynthesis.LOGGER.info("FAILED - recipe requires:"+reqCount+", we got:"+itemStack.getCount());
                    return false;
                }
            }

            return canInsertAmountIntoOutputSlot(inventory, recipe.getOutputStack().getCount())
                    && canInsertItemIntoOutputSlot(inventory, recipe.getOutputStack().getItem());
        } else {
            return false;
        }
    }




    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        //return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty(); //crafts up to a stack.
        //make it so output has to be empty. (more manual labor) *evil*
        if(inventory.getStack(7).isEmpty() && inventory.getStack(8).isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int amount) {
        return inventory.getStack(7).getMaxCount() >= inventory.getStack(7).getCount() + amount;
    }
}