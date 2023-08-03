package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.block.custom.DryingNetBlock;
import net.zuiron.photosynthesis.block.custom.FluidPressBlock;
import net.zuiron.photosynthesis.block.custom.KegBlock;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.recipe.FluidPressRecipe;
import net.zuiron.photosynthesis.recipe.KegRecipe;
import net.zuiron.photosynthesis.screen.FluidPressScreenHandler;
import net.zuiron.photosynthesis.screen.KegScreenHandler;
import net.zuiron.photosynthesis.util.FluidStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class FluidPressBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

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
        if(!world.isClient()) {
            sendFluidPacket();
        }
        super.markDirty();
    }



    public final SingleVariantStorage<FluidVariant> fluidOutput = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            //return FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 4; // 4 buckets
            return FluidConstants.BUCKET * 4; // 4 buckets
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient()) {
                sendFluidPacket();
            }
        }
    };

    private void sendFluidPacket() {
        //PacketByteBuf data = PacketByteBufs.create();
        PacketByteBuf data2 = PacketByteBufs.create();

        fluidOutput.variant.toPacket(data2);
        data2.writeLong(fluidOutput.amount);

        //data.writeBlockPos(getPos());
        data2.writeBlockPos(getPos());

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
            //ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC, data);
            ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC2, data2);
        }
    }

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 20;

    public FluidPressBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FLUID_PRESS, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return FluidPressBlockEntity.this.progress;
                    case 1: return FluidPressBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: FluidPressBlockEntity.this.progress = value; break;
                    case 1: FluidPressBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    public void setOutputFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidOutput.variant = fluidVariant;
        this.fluidOutput.amount = fluidLevel;
    }

    @Override
    public DefaultedList<ItemStack> getItemsNoConflicts() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal(""); //Fluid Press
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        if(!world.isClient()) {
            sendFluidPacket(); //SYNC when we open gui.
        }
        return new FluidPressScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("fluid_press.progress", progress);
        nbt.putInt("fluid_press.cookingTime", maxProgress);

        nbt.put("outputFluid.variant", fluidOutput.variant.toNbt());
        nbt.putLong("outputFluid.fluid", fluidOutput.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("fluid_press.progress");
        maxProgress = nbt.getInt("fluid_press.cookingTime");

        fluidOutput.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("outputFluid.variant"));
        fluidOutput.amount = nbt.getLong("outputFluid.fluid");
    }

    private void resetProgress() {
        this.progress = 0;
        syncItems();
    }

    public static void animationTick(World level, BlockPos pos, BlockState state) {
        if (isBlockBelowBurning(level, pos) && level.isClient()) {
            Random random = level.random;
            /*if (random.nextFloat() < 0.2F) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double y = (double) pos.getY() + 1.1D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0.0D, motionY, 0.0D);
            }*/
            if (state.get(BooleanProperty.of("processing"))) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double y = (double) pos.getY() + 0.1D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.4D - 0.2D);
                double motionY = random.nextBoolean() ? 0.015D : 0.005D;
                level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, motionY, 0.0D); //ENCHANTED_HIT
            }
        }
    }


    public static void playKegSound(World world, BlockPos blockPos) {
        if(!world.isClient()) { world.playSound(null, blockPos, Photosynthesis.KEG_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f); }
    }

    private static int tickCounter = 0;

    public static void loopKegSound(World world, BlockPos blockPos) {
        int ticksPerLoop = (int) (2 * 20);
        tickCounter++;
        if (tickCounter >= ticksPerLoop) {
            playKegSound(world, blockPos);
            tickCounter = 0;
        }
    }

    /*private static boolean hasFluidSourceInSlot(FluidPressBlockEntity entity) {
        //TODO - what if we can use other fluid than water?
        return entity.getStack(0).getItem() == Items.WATER_BUCKET;
    }*/

    private static boolean hasEmptyBucketInSlot(FluidPressBlockEntity entity) {
        if(entity.getStack(1).getItem() == Items.BUCKET) {
            return true;
        }
        return false;
    }

    /*private static void transferFluidToFluidStorage(FluidPressBlockEntity entity) {

        if(canTankAcceptBucketWorth(entity)) {
            if (insertFluid(entity, FluidStack.convertDropletsToMb(FluidConstants.BUCKET))) {
                entity.setStack(0, new ItemStack(Items.BUCKET));
            }
        }
    }*/

    /*private static boolean insertFluid(FluidPressBlockEntity entity, long convertDropletsToMb) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidInput.insert(FluidVariant.of(Fluids.WATER), convertDropletsToMb, transaction);
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }*/

    /*private static boolean canTankAcceptBucketWorth(FluidPressBlockEntity entity) {
        long availableSpace = entity.fluidInput.getCapacity() - entity.fluidInput.getAmount();
        if(availableSpace >= FluidStack.convertDropletsToMb(FluidConstants.BUCKET)) {
            return true;
        }
        return false;
    }*/

    private static void extractFluidAndMakeBucket(FluidPressBlockEntity entity) {
        //if(entity.fluidOutput.amount >= 1000) {
        if(entity.fluidOutput.amount >= FluidConstants.BUCKET) {
            ItemStack itemStack = new ItemStack(entity.fluidOutput.getResource().getFluid().getBucketItem());
            //if(extractFluid(entity, 1000)) {
            if(extractFluid(entity, FluidConstants.BUCKET)) {
                entity.setStack(1, itemStack);
            }
        }
    }

    private static boolean extractFluid(FluidPressBlockEntity entity, long Amount) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidOutput.extract(FluidVariant.of(entity.fluidOutput.getResource().getFluid()),
                    Amount, transaction);
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, FluidPressBlockEntity entity) {
        animationTick(world, blockPos, state);

        if(world.isClient()) {
            return;
        }

        //------------------- BUCKET STUFF
        /*if(hasFluidSourceInSlot(entity)) {
            transferFluidToFluidStorage(entity);
        }*/
        if(hasEmptyBucketInSlot(entity)) {
            extractFluidAndMakeBucket(entity);
        }
        //--------------------------------


        boolean isBelowHeat = isBlockBelowBurning(world, blockPos);

        //check see if belowblock is burning, if so. enable hot texture!
        state = (BlockState)state.with(FluidPressBlock.LIT, isBelowHeat);
        world.setBlockState(blockPos, state, 3);
        if(isBelowHeat) {
            markDirty(world, blockPos, state);
        }

        if(hasRecipe(entity) && isBelowHeat) {
            entity.progress++;
            state = (BlockState)state.with(FluidPressBlock.PROCESSING, true); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);

            loopKegSound(world, blockPos);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
                state = (BlockState)state.with(FluidPressBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            }
        } else {
            entity.resetProgress();
            state = (BlockState)state.with(FluidPressBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);
        }
    }

    private static boolean isBlockBelowBurning(World world, BlockPos blockPos) {
        return true;
    }

    private static void craftItem(FluidPressBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(1);
        for (int i = 0; i < 1; i++) {
            inventory.setStack(i, entity.getStack(i)); //ingredients start from slot0.
        }

        Optional<FluidPressRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(FluidPressRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            //FluidStack inputFluid = recipe.get().getFluidInput();
            FluidStack outputFluid = recipe.get().getOutputFluid();

            //DONE - remove input fluid from input fluid tank
            /*try(Transaction transaction = Transaction.openOuter()) {
                entity.fluidInput.extract(FluidVariant.of(inputFluid.fluidVariant.getFluid()),
                        FluidStack.convertDropletsToMb(inputFluid.amount), transaction);
                transaction.commit();
            }*/

            entity.removeStack(0, (Integer) recipe.get().getCounts().get(0));   //input
            //entity.removeStack(2, (Integer) recipe.get().getCounts().get(1));   //input
            //entity.removeStack(3, (Integer) recipe.get().getCounts().get(2));   //input
            //entity.removeStack(4, (Integer) recipe.get().getCounts().get(3));   //input


            try(Transaction transaction = Transaction.openOuter()) {
                entity.fluidOutput.insert(FluidVariant.of(outputFluid.fluidVariant.getFluid()),
                        //FluidStack.convertDropletsToMb(outputFluid.amount), transaction);
                        outputFluid.amount, transaction);
                transaction.commit();
            }


            entity.resetProgress();
            //Photosynthesis.LOGGER.info("Item crafted! SUCCESS.");
        }
    }

    private static boolean hasRecipe(FluidPressBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(1);
        for (int i = 0; i < 1; i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<FluidPressRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(FluidPressRecipe.Type.INSTANCE, inventory, entity.getWorld());

        entity.maxProgress = match.map(FluidPressRecipe::getCookTime).orElse(20);

        if (match.isPresent()) {
            //Photosynthesis.LOGGER.info("match is present! continue");
            FluidPressRecipe recipe = match.get();
            List<Ingredient> ingredients = recipe.getIngredients();
            DefaultedList counts = recipe.getCounts();

            //FluidStack inputFluid = recipe.getFluidInput();
            FluidStack outputFluid = recipe.getOutputFluid();

            //check item counts.
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

            //return canInsertFluidIntoFluidOutput(entity, outputFluid, FluidStack.convertDropletsToMb(outputFluid.amount));
            return canInsertFluidIntoFluidOutput(entity, outputFluid, outputFluid.amount);
        } else {
            //Photosynthesis.LOGGER.info("no match is present...");
            return false;
        }
    }

    private static final int[] INPUT_SLOTS = {0};
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(pos).get(FluidPressBlock.FACING);

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


    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return false;
    }

    /*private static boolean doesInputTankContainEnoughRecipeInputFluid(FluidPressBlockEntity entity, FluidStack inputFluid, long amount) {
        FluidVariant inputTankFluidVariant = entity.fluidInput.getResource();
        long inputTankFluidAmount = entity.fluidInput.getAmount();

        //if input tank is empty, no go.
        if(inputTankFluidVariant.isOf(Fluids.EMPTY)) { return false; }

        //is it the required variant?
        if(inputTankFluidVariant != inputFluid.fluidVariant) { return false; }

        //do we have enough?
        if(inputTankFluidAmount < amount) { return false; }

        return true;
    }*/

    private static boolean canInsertFluidIntoFluidOutput(FluidPressBlockEntity entity, FluidStack outputFluid, long amount) {
        long outputTankCapacity = entity.fluidOutput.getCapacity();
        long outputTankAmount = entity.fluidOutput.getAmount();
        long outputTankRemainingCapacity = outputTankCapacity - outputTankAmount;

        if(outputTankRemainingCapacity < amount) { return false; } //WORKING - capacity check

        FluidVariant outputTankFluidVariant = entity.fluidOutput.getResource();
        FluidVariant recipeFluidVariant = outputFluid.fluidVariant;

        //DONE -- check if output fluid is equal to outputtankfluid or is empty.
        if(!outputTankFluidVariant.isOf(Fluids.EMPTY) && outputTankFluidVariant != recipeFluidVariant) { return false; } //? - is recipe and output tank same variant?

        //Photosynthesis.LOGGER.info("capacity: "+outputTankCapacity+", Amount: "+outputTankAmount+", of: "+outputTankFluidVariant);
        //Photosynthesis.LOGGER.info("trying to insert: "+recipeFluidVariant+", amount: "+amount);
        return true;
    }


    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return false;
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int amount) {
        return false;
    }
}