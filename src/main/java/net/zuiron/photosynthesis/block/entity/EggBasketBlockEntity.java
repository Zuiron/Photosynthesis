package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.screen.EggBasketScreenHandler;
import net.zuiron.photosynthesis.screen.FeedingTroughScreenHandler;
import net.zuiron.photosynthesis.util.getCustomVarsPassiveEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class EggBasketBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY); //N#:SLOTS
    private int cooldown = 0;

    /*public ItemStack getRenderStack() {
        if(this.getStack(2).isEmpty()) {
            return this.getStack(1);
        } else {
            return this.getStack(2);
        }
    }*/

    public ItemStack getRenderStack() {
        return this.inventory.get(0);
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

    public EggBasketBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EGGBASKET, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItemsNoConflicts() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("");
    } //Egg Basket

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new EggBasketScreenHandler(syncId, inv, this);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("eggbasket.cooldown", cooldown);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        cooldown = nbt.getInt("eggbasket.cooldown");
        super.readNbt(nbt);
    }

    private void resetCooldown() {
        this.cooldown = 0;
        syncItems();
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, EggBasketBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        entity.cooldown++;

        if(entity.cooldown < 20) { //20 ticks per second. 1 item transfer per 1 seconds.
            return;
        }

        // Get the range in which you want to scan for entities
        double range = 10.0; // Adjust this value as needed

        // Calculate the bounding box around the block position
        Box boundingBox = new Box(
                blockPos.getX() - range, blockPos.getY() - range, blockPos.getZ() - range,
                blockPos.getX() + range, blockPos.getY() + range, blockPos.getZ() + range
        );

        // Look for passiveEntity entities
        Predicate<ItemEntity> entityPredicate = Objects::nonNull;

        List<ItemEntity> filteredEntities = world.getEntitiesByClass(ItemEntity.class, boundingBox, entityPredicate);
        for (ItemEntity scannedItemEntity : filteredEntities) {

            ItemStack itemStack = scannedItemEntity.getStack();
            if(itemStack.isOf(Items.EGG)) {
                //Photosynthesis.LOGGER.info(itemStack);
                //itemStack.decrement(1); //works.

                int maxCount = entity.getStack(0).getMaxCount();
                //int maxCount = 9;

                if(entity.getStack(0).isEmpty() || entity.getStack(0).isOf(itemStack.getItem())) { //is inventory empty or has same item?
                    if(maxCount > entity.getStack(0).getCount()) { //can we fit item?
                        entity.setStack(0, new ItemStack(itemStack.getItem(), entity.getStack(0).getCount() + 1));
                        itemStack.decrement(1);
                        entity.resetCooldown();
                        break;
                    }
                }
            }

        }
        entity.resetCooldown();
        entity.syncItems();
        markDirty(world, blockPos, state);
    }

    public DefaultedList<ItemStack> getInventoryMod() {
        return this.inventory;
    }
}