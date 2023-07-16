package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SidedStorageBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.BucketItem;
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
import net.zuiron.photosynthesis.block.custom.LatexExtractorBlock;
import net.zuiron.photosynthesis.block.custom.MilkSeperatorBlock;
import net.zuiron.photosynthesis.fluid.ModFluids;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.recipe.MilkSeperatorRecipe;
import net.zuiron.photosynthesis.screen.MilkSeperatorScreenHandler;
import net.zuiron.photosynthesis.util.FluidStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class MilkSeperatorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory, SidedStorageBlockEntity {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);

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

    public final SingleVariantStorage<FluidVariant> fluidInput = new SingleVariantStorage<FluidVariant>() {
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

    public final SingleVariantStorage<FluidVariant> fluidOutput2 = new SingleVariantStorage<FluidVariant>() {
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
        PacketByteBuf data = PacketByteBufs.create();
        PacketByteBuf data2 = PacketByteBufs.create();
        PacketByteBuf data3 = PacketByteBufs.create();

        fluidInput.variant.toPacket(data);
        data.writeLong(fluidInput.amount);

        fluidOutput.variant.toPacket(data2);
        data2.writeLong(fluidOutput.amount);

        fluidOutput2.variant.toPacket(data3);
        data3.writeLong(fluidOutput2.amount);

        data.writeBlockPos(getPos());
        data2.writeBlockPos(getPos());
        data3.writeBlockPos(getPos());

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
            ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC, data);
            ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC2, data2);
            ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC3, data3);
        }
    }

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 20;

    public MilkSeperatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MILKSEPERATOR, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return MilkSeperatorBlockEntity.this.progress;
                    case 1: return MilkSeperatorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: MilkSeperatorBlockEntity.this.progress = value; break;
                    case 1: MilkSeperatorBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    public void setInputFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidInput.variant = fluidVariant;
        this.fluidInput.amount = fluidLevel;
    }

    public void setOutputFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidOutput.variant = fluidVariant;
        this.fluidOutput.amount = fluidLevel;
    }

    public void setOutputFluidLevel2(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidOutput2.variant = fluidVariant;
        this.fluidOutput2.amount = fluidLevel;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal(""); //Milk Seperator
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        if(!world.isClient()) {
            sendFluidPacket(); //SYNC when we open gui.
        }
        return new MilkSeperatorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("milkseperator.progress", progress);
        nbt.putInt("milkseperator.cookingTime", maxProgress);

        nbt.put("inputFluid.variant", fluidInput.variant.toNbt());
        nbt.putLong("inputFluid.fluid", fluidInput.amount);

        nbt.put("outputFluid.variant", fluidOutput.variant.toNbt());
        nbt.putLong("outputFluid.fluid", fluidOutput.amount);

        nbt.put("outputFluid2.variant", fluidOutput2.variant.toNbt());
        nbt.putLong("outputFluid2.fluid", fluidOutput2.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("milkseperator.progress");
        maxProgress = nbt.getInt("milkseperator.cookingTime");

        fluidInput.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("inputFluid.variant"));
        fluidInput.amount = nbt.getLong("inputFluid.fluid");

        fluidOutput.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("outputFluid.variant"));
        fluidOutput.amount = nbt.getLong("outputFluid.fluid");

        fluidOutput2.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("outputFluid2.variant"));
        fluidOutput2.amount = nbt.getLong("outputFluid2.fluid");
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

    private static boolean hasFluidSourceInSlot(MilkSeperatorBlockEntity entity) {
        if (entity.getStack(0).getItem() instanceof BucketItem || entity.getStack(0).getItem() == Items.MILK_BUCKET) {
            //Photosynthesis.LOGGER.info(entity.getStack(0).getItem());
            if(entity.getStack(0).getItem() != Items.BUCKET) {
                return true;
            }
            else return false;
        }
        return false;
    }

    private static boolean hasEmptyBucketInSlot(MilkSeperatorBlockEntity entity, int slot) {
        if(entity.getStack(slot).getItem() == Items.BUCKET) { //slot 1 = skimmed, 2 = cream
            return true;
        }
        return false;
    }

    private static void transferFluidToFluidStorage(MilkSeperatorBlockEntity entity) {

        if(canTankAcceptBucketWorth(entity)) {
            //if (insertFluid(entity, FluidStack.convertDropletsToMb(FluidConstants.BUCKET))) {
            if (insertFluid(entity, FluidConstants.BUCKET)) {
                entity.setStack(0, new ItemStack(Items.BUCKET));
            }
        }
    }

    private static boolean insertFluid(MilkSeperatorBlockEntity entity, long amount) {
        try(Transaction transaction = Transaction.openOuter()) {
            Fluid fluid = Fluids.EMPTY;
            if(entity.getStack(0).getItem() == Items.MILK_BUCKET || entity.getStack(0).getItem() == ModFluids.MILK_BUCKET) {
                fluid = ModFluids.STILL_MILK.getDefaultState().getFluid();
            } else if(entity.getStack(0).getItem() == ModFluids.GOATMILK_BUCKET) {
                fluid = ModFluids.STILL_GOATMILK.getDefaultState().getFluid();
            }

            if(FluidVariant.of(fluid) == entity.fluidInput.variant || entity.fluidInput.amount == 0) { //only insert if already existing fluid is either empty or same.
                entity.fluidInput.insert(FluidVariant.of(fluid), amount, transaction);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }

    private static boolean canTankAcceptBucketWorth(MilkSeperatorBlockEntity entity) {
        long availableSpace = entity.fluidInput.getCapacity() - entity.fluidInput.getAmount();
        //if(availableSpace >= FluidStack.convertDropletsToMb(FluidConstants.BUCKET)) {
        if(availableSpace >= FluidConstants.BUCKET) {
            return true;
        }
        return false;
    }

    private static void extractFluidAndMakeBucket(MilkSeperatorBlockEntity entity, int slot) {
        if(slot == 1) { //1 = skimmed, 2 = cream
            //if (entity.fluidOutput.amount >= 1000) {
            if (entity.fluidOutput.amount >= FluidConstants.BUCKET) {
                ItemStack itemStack = new ItemStack(entity.fluidOutput.getResource().getFluid().getBucketItem());
                //if (extractFluid(entity, 1000, 1)) {
                if (extractFluid(entity, FluidConstants.BUCKET, 1)) {
                    entity.setStack(slot, itemStack);
                }
            }
        } else if (slot == 2) {
            //if (entity.fluidOutput2.amount >= 1000) {
            if (entity.fluidOutput2.amount >= FluidConstants.BUCKET) {
                ItemStack itemStack = new ItemStack(entity.fluidOutput2.getResource().getFluid().getBucketItem());
                //if (extractFluid(entity, 1000, 2)) {
                if (extractFluid(entity, FluidConstants.BUCKET, 2)) {
                    entity.setStack(slot, itemStack);
                }
            }
        }
    }

    private static boolean extractFluid(MilkSeperatorBlockEntity entity, long Amount, int slot) {
        try(Transaction transaction = Transaction.openOuter()) {

            if(slot == 1) {
                entity.fluidOutput.extract(FluidVariant.of(entity.fluidOutput.getResource().getFluid()),
                        Amount, transaction);
            } else if (slot == 2) {
                entity.fluidOutput2.extract(FluidVariant.of(entity.fluidOutput2.getResource().getFluid()),
                        Amount, transaction);
            }

            transaction.commit();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, MilkSeperatorBlockEntity entity) {
        animationTick(world, blockPos, state);

        if(world.isClient()) {
            return;
        }

        //------------------- BUCKET STUFF
        if(hasFluidSourceInSlot(entity)) {
            transferFluidToFluidStorage(entity);
        }
        if(hasEmptyBucketInSlot(entity, 1)) {
            extractFluidAndMakeBucket(entity, 1);
        }
        if(hasEmptyBucketInSlot(entity, 2)) {
            extractFluidAndMakeBucket(entity, 2);
        }
        //--------------------------------


        boolean isBelowHeat = isBlockBelowBurning(world, blockPos);

        //check see if belowblock is burning, if so. enable hot texture!
        state = (BlockState)state.with(MilkSeperatorBlock.LIT, isBelowHeat);
        world.setBlockState(blockPos, state, 3);
        if(isBelowHeat) {
            markDirty(world, blockPos, state);
        }

        if(hasRecipe(entity) && isBelowHeat) {
            entity.progress++;
            state = (BlockState)state.with(MilkSeperatorBlock.PROCESSING, true); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);

            loopKegSound(world, blockPos);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
                state = (BlockState)state.with(MilkSeperatorBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            }
        } else {
            entity.resetProgress();
            state = (BlockState)state.with(MilkSeperatorBlock.PROCESSING, false); world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);
        }
    }

    private static boolean isBlockBelowBurning(World world, BlockPos blockPos) {
        return true;
    }

    private static void craftItem(MilkSeperatorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(1);
        for (int i = 0; i < 1; i++) {
            //inventory.setStack(i, entity.getStack(i)); //ingredients start from slot1.
            inventory.setStack(i, entity.fluidInput.variant.getFluid().getBucketItem().getDefaultStack());
        }

        Optional<MilkSeperatorRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(MilkSeperatorRecipe.Type.INSTANCE, inventory, entity.getWorld());


        if(hasRecipe(entity)) {
            FluidStack inputFluid = recipe.get().getFluidInput();
            FluidStack outputFluid = recipe.get().getOutputFluid();
            FluidStack outputFluid2 = recipe.get().getOutputFluid2();

            //DONE - remove input fluid from input fluid tank
            try(Transaction transaction = Transaction.openOuter()) {
                entity.fluidInput.extract(FluidVariant.of(inputFluid.fluidVariant.getFluid()),
                        //FluidStack.convertDropletsToMb(inputFluid.amount), transaction);
                        inputFluid.amount, transaction);
                transaction.commit();
            }

            /*
            entity.removeStack(1, (Integer) recipe.get().getCounts().get(0));   //input
            entity.removeStack(2, (Integer) recipe.get().getCounts().get(1));   //input
            entity.removeStack(3, (Integer) recipe.get().getCounts().get(2));   //input
            entity.removeStack(4, (Integer) recipe.get().getCounts().get(3));   //input
            */


            try(Transaction transaction = Transaction.openOuter()) {
                entity.fluidOutput.insert(FluidVariant.of(outputFluid.fluidVariant.getFluid()),
                        //FluidStack.convertDropletsToMb(outputFluid.amount), transaction);
                        outputFluid.amount, transaction);
                transaction.commit();
            }

            try(Transaction transaction = Transaction.openOuter()) {
                entity.fluidOutput2.insert(FluidVariant.of(outputFluid2.fluidVariant.getFluid()),
                        //FluidStack.convertDropletsToMb(outputFluid2.amount), transaction);
                        outputFluid2.amount, transaction);
                transaction.commit();
            }



            entity.resetProgress();
            //Photosynthesis.LOGGER.info("Item crafted! SUCCESS.");
        }
    }

    private static boolean hasRecipe(MilkSeperatorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(1);
        for (int i = 0; i < 1; i++) {
            //inventory.setStack(i, entity.getStack(i+1));
            inventory.setStack(i, entity.fluidInput.variant.getFluid().getBucketItem().getDefaultStack());
        }

        Optional<MilkSeperatorRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(MilkSeperatorRecipe.Type.INSTANCE, inventory, entity.getWorld());

        entity.maxProgress = match.map(MilkSeperatorRecipe::getCookTime).orElse(20);

        if (match.isPresent()) {
            //Photosynthesis.LOGGER.info("match is present! continue");
            MilkSeperatorRecipe recipe = match.get();
            //List<Ingredient> ingredients = recipe.getIngredients();
            //DefaultedList counts = recipe.getCounts();

            FluidStack inputFluid = recipe.getFluidInput();
            FluidStack outputFluid = recipe.getOutputFluid();
            FluidStack outputFluid2 = recipe.getOutputFluid2();
            /*return canInsertFluidIntoFluidOutput(entity, outputFluid, outputFluid2, FluidStack.convertDropletsToMb(outputFluid.amount), FluidStack.convertDropletsToMb(outputFluid2.amount)) &&
                    doesInputTankContainEnoughRecipeInputFluid(entity, inputFluid, FluidStack.convertDropletsToMb(inputFluid.amount));*/
            return canInsertFluidIntoFluidOutput(entity, outputFluid, outputFluid2, outputFluid.amount, outputFluid2.amount) &&
                    doesInputTankContainEnoughRecipeInputFluid(entity, inputFluid, inputFluid.amount);
        } else {
            //Photosynthesis.LOGGER.info("no match is present...");
            return false;
        }
    }

    private static boolean doesInputTankContainEnoughRecipeInputFluid(MilkSeperatorBlockEntity entity, FluidStack inputFluid, long amount) {
        FluidVariant inputTankFluidVariant = entity.fluidInput.getResource();
        long inputTankFluidAmount = entity.fluidInput.getAmount();

        //if input tank is empty, no go.
        if(inputTankFluidVariant.isOf(Fluids.EMPTY)) { return false; }

        //is it the required variant?
        if(inputTankFluidVariant != inputFluid.fluidVariant) { return false; }

        //do we have enough?
        if(inputTankFluidAmount < amount) { return false; }

        return true;
    }

    private static boolean canInsertFluidIntoFluidOutput(MilkSeperatorBlockEntity entity, FluidStack outputFluid, FluidStack outputFluid2, long amount, long amount2) {
        long outputTankCapacity = entity.fluidOutput.getCapacity();
        long outputTankAmount = entity.fluidOutput.getAmount();
        long outputTankRemainingCapacity = outputTankCapacity - outputTankAmount;

        long outputTankCapacity2 = entity.fluidOutput2.getCapacity();
        long outputTankAmount2 = entity.fluidOutput2.getAmount();
        long outputTankRemainingCapacity2 = outputTankCapacity2 - outputTankAmount2;

        if(outputTankRemainingCapacity < amount) { return false; } //WORKING - capacity check
        if(outputTankRemainingCapacity2 < amount2) { return false; } //WORKING - capacity check

        FluidVariant outputTankFluidVariant = entity.fluidOutput.getResource();
        FluidVariant recipeFluidVariant = outputFluid.fluidVariant;

        FluidVariant outputTankFluidVariant2 = entity.fluidOutput2.getResource();
        FluidVariant recipeFluidVariant2 = outputFluid2.fluidVariant;

        //DONE -- check if output fluid is equal to outputtankfluid or is empty.
        if(!outputTankFluidVariant.isOf(Fluids.EMPTY) && outputTankFluidVariant != recipeFluidVariant) { return false; } //? - is recipe and output tank same variant?
        if(!outputTankFluidVariant2.isOf(Fluids.EMPTY) && outputTankFluidVariant2 != recipeFluidVariant2) { return false; } //? - is recipe and output tank same variant?

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

    /*@Override
    public boolean canInsertFluid(int tank, FluidVariant fluid, @Nullable Direction direction) {
        // Allow fluid insertion from the top side
        return direction == Direction.UP && fluid.matches(fluidInput);
    }

    @Override
    public boolean canExtractFluid(int tank, FluidVariant fluid, Direction direction) {
        // Allow fluid extraction from the bottom side
        return direction == Direction.DOWN && fluid.matches(fluidOutput);
    }*/

    /*
     @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(GemInfusingStationBlock.FACING);
     */

    @Override
    public Storage<FluidVariant> getFluidStorage(Direction direction) {
        //my block is FACING which way? north, south, west, east ?
        Direction blockFacing = this.getWorld().getBlockState(this.pos).get(MilkSeperatorBlock.FACING);

        if(direction == Direction.DOWN) {
            // Side is at the bottom of the block
            return fluidOutput;
        } else if (direction == Direction.UP) {
            // Side is at the top of the block
            return fluidInput;
        } else if (direction == blockFacing.rotateYCounterclockwise()) {
            // Side is to the right of the block
            return fluidOutput2;
        } else if (direction == blockFacing.rotateYClockwise()) {
            // Side is to the left of the block
            return null;
        } else if (direction == blockFacing.getOpposite()) {
            // Side is at the back of the block
            return null;
        } else if (direction == blockFacing) {
            // Side is at the front of the block
            return null;
        } else {
            return null;
        }
    }
}