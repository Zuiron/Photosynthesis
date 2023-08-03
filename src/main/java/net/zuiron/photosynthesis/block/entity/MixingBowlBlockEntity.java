package net.zuiron.photosynthesis.block.entity;

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
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.custom.DryingNetBlock;
import net.zuiron.photosynthesis.block.custom.MixingBowlBlock;
import net.zuiron.photosynthesis.block.custom.SkilletBlock;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.recipe.MixingBowlRecipe;
import net.zuiron.photosynthesis.recipe.SkilletRecipe;
import net.zuiron.photosynthesis.screen.MixingBowlScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class MixingBowlBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(18, ItemStack.EMPTY); //6

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

    public MixingBowlBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MIXINGBOWL, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return MixingBowlBlockEntity.this.progress;
                    case 1: return MixingBowlBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: MixingBowlBlockEntity.this.progress = value; break;
                    case 1: MixingBowlBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItemsNoConflicts() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal(""); //Mixing Bowl
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new MixingBowlScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("mixingbowl.progress", progress);
        nbt.putInt("mixingbowl.cookingTime", maxProgress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("mixingbowl.progress");
        maxProgress = nbt.getInt("mixingbowl.cookingTime");
    }

    private void resetProgress() {
        this.progress = 0;
        syncItems();
    }

    public static void animationTick(World level, BlockPos pos, BlockState state) {
        if (level.isClient()) {
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


    public static void playMixingBowlSound(World world, BlockPos blockPos) {
        if(!world.isClient()) { world.playSound(null, blockPos, Photosynthesis.MIXINGBOWL_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f); }
    }

    private static int tickCounter = 0;

    public static void loopMixingBowlSound(World world, BlockPos blockPos) {
        int ticksPerLoop = (int) (2.193 * 20);
        tickCounter++;
        if (tickCounter >= ticksPerLoop) {
            playMixingBowlSound(world, blockPos);
            tickCounter = 0;
        }
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, MixingBowlBlockEntity entity) {
        //animationTick(world, blockPos, state);

        if(world.isClient()) {
            return;
        }
        boolean isBelowHeat = isBlockBelowBurning(world, blockPos);

        //check see if belowblock is burning, if so. enable hot texture!
        state = (BlockState)state.with(MixingBowlBlock.LIT, isBelowHeat);
        world.setBlockState(blockPos, state, 3);
        if(isBelowHeat) {
            markDirty(world, blockPos, state);
        }

        if(hasRecipe(entity) && isBelowHeat) {
            entity.progress++;
            state = (BlockState)state.with(MixingBowlBlock.PROCESSING, true); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);

            loopMixingBowlSound(world, blockPos);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
                state = (BlockState)state.with(MixingBowlBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            }
        } else {
            entity.resetProgress();
            state = (BlockState)state.with(MixingBowlBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);
        }
    }

    private static boolean isBlockBelowBurning(World world, BlockPos blockPos) {
        return true;
    }

    private static void craftItem(MixingBowlBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<MixingBowlRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(MixingBowlRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            //empty recipe remainder items.
            //entity.setStack(5, new ItemStack(entity.getStack(0).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(0)));

            //output
            int recipeOutputCount = recipe.get().getOutputStack().getCount();
            int outputSlotCount = entity.getStack(9).getCount();
            entity.setStack(9, new ItemStack(recipe.get().getOutputStack().getItem(), outputSlotCount + recipeOutputCount));

            //IF any items have recipe remainders, give here.
            entity.setStack(10, new ItemStack(entity.getStack(1).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(1)));
            entity.setStack(11, new ItemStack(entity.getStack(2).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(2)));
            entity.setStack(12, new ItemStack(entity.getStack(3).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(3)));
            entity.setStack(13, new ItemStack(entity.getStack(4).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(4)));
            entity.setStack(14, new ItemStack(entity.getStack(5).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(5)));
            entity.setStack(15, new ItemStack(entity.getStack(6).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(6)));
            entity.setStack(16, new ItemStack(entity.getStack(7).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(7)));
            entity.setStack(17, new ItemStack(entity.getStack(8).getRecipeRemainder().getItem(), (Integer) recipe.get().getCounts().get(8)));

            //entity.removeStack(0, (Integer) recipe.get().getCounts().get(0));   //input TOOL! DO NOT REMOVE SLOT0, ITS TOOL SLOT
            entity.removeStack(1, (Integer) recipe.get().getCounts().get(1));   //input
            entity.removeStack(2, (Integer) recipe.get().getCounts().get(2));   //input
            entity.removeStack(3, (Integer) recipe.get().getCounts().get(3));   //input
            entity.removeStack(4, (Integer) recipe.get().getCounts().get(4));   //input
            entity.removeStack(5, (Integer) recipe.get().getCounts().get(5));   //input
            entity.removeStack(6, (Integer) recipe.get().getCounts().get(6));   //input
            entity.removeStack(7, (Integer) recipe.get().getCounts().get(7));   //input
            entity.removeStack(8, (Integer) recipe.get().getCounts().get(8));   //input

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(MixingBowlBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<MixingBowlRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(MixingBowlRecipe.Type.INSTANCE, inventory, entity.getWorld());

        entity.maxProgress = match.map(MixingBowlRecipe::getCookTime).orElse(20);

        if (match.isPresent() &&
                inventory.getStack(9).isEmpty() &&
                inventory.getStack(10).isEmpty() &&
                inventory.getStack(11).isEmpty() &&
                inventory.getStack(12).isEmpty() &&
                inventory.getStack(13).isEmpty() &&
                inventory.getStack(14).isEmpty() &&
                inventory.getStack(15).isEmpty() &&
                inventory.getStack(16).isEmpty() &&
                inventory.getStack(17).isEmpty()) {
            //Photosynthesis.LOGGER.info("match is present! continue");
            MixingBowlRecipe recipe = match.get();
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



    private static final int[] INPUT_SLOTS = {0,1,2,3,4,5,6,7,8};
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(pos).get(MixingBowlBlock.FACING);

        if (side == Direction.DOWN) {
            return false;
        }

        if (side == Direction.UP) {
            return isInputSlot(slot);
        }

        //input top, left, back
        return switch (localDir) {
            default -> //NORTH
                    (side.getOpposite() == Direction.NORTH || side.getOpposite() == Direction.WEST) && isInputSlot(slot);
            case EAST ->
                    (side.rotateYClockwise() == Direction.NORTH || side.rotateYClockwise() == Direction.WEST) && isInputSlot(slot);
            case SOUTH ->
                    (side == Direction.NORTH || side == Direction.WEST) && isInputSlot(slot);
            case WEST ->
                    (side.rotateYCounterclockwise() == Direction.NORTH || side.rotateYCounterclockwise() == Direction.WEST) && isInputSlot(slot);
        };
    }

    private boolean isInputSlot(int slot) {
        for (int inputSlot : INPUT_SLOTS) {
            if (slot == inputSlot) {
                return true;
            }
        }
        return false;
    }


    private static final int[] OUTPUT_SLOTS = {9,10,11,12,13,14,15,16,17};
    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(MixingBowlBlock.FACING);

        if (side == Direction.UP) {
            return false;
        }

        if (side == Direction.DOWN) {
            return isOutputSlot(slot);
        }

        //extract front, right, and down.
        return switch (localDir) {
            default -> (side.getOpposite() == Direction.SOUTH || side.getOpposite() == Direction.EAST) && isOutputSlot(slot);
            case EAST -> (side.rotateYClockwise() == Direction.SOUTH || side.rotateYClockwise() == Direction.EAST) && isOutputSlot(slot);
            case SOUTH -> (side == Direction.SOUTH || side == Direction.EAST) && isOutputSlot(slot);
            case WEST -> (side.rotateYCounterclockwise() == Direction.SOUTH || side.rotateYCounterclockwise() == Direction.EAST) && isOutputSlot(slot);
        };
    }

    private boolean isOutputSlot(int slot) {
        for (int outputSlot : OUTPUT_SLOTS) {
            if (slot == outputSlot) {
                return true;
            }
        }
        return false;
    }


    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        //return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty(); //crafts up to a stack.
        //make it so output has to be empty. (more manual labor) *evil*
        if(inventory.getStack(9).isEmpty() &&
                inventory.getStack(10).isEmpty() &&
                inventory.getStack(11).isEmpty() &&
                inventory.getStack(12).isEmpty() &&
                inventory.getStack(13).isEmpty() &&
                inventory.getStack(14).isEmpty() &&
                inventory.getStack(15).isEmpty() &&
                inventory.getStack(16).isEmpty() &&
                inventory.getStack(17).isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int amount) {
        return inventory.getStack(9).getMaxCount() >= inventory.getStack(9).getCount() + amount;
    }
}