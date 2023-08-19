package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
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
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.networking.ModMessages;
import net.zuiron.photosynthesis.screen.FeedingTroughScreenHandler;
import net.zuiron.photosynthesis.util.getCustomVarsPassiveEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class FeedingTroughBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY); //N#:SLOTS

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

    public FeedingTroughBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FEEDINGTROUGH, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItemsNoConflicts() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("");
    } //Feeding Trough

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new FeedingTroughScreenHandler(syncId, inv, this);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, FeedingTroughBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        if(entity.getStack(0).isEmpty()) {
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
        Predicate<Entity> entityPredicate = entityP -> {
            return entityP instanceof PassiveEntity;
        };

        List<Entity> filteredEntities = world.getEntitiesByClass(Entity.class, boundingBox, entityPredicate);
        for (Entity ScannedPassiveEntity : filteredEntities) {

            ItemStack itemStack = entity.getStack(0);
            if(ScannedPassiveEntity instanceof CowEntity) {
                if(itemStack.isOf(ModItems.TMR)) {
                    int mod_Food = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food();
                    int mod_Food_max = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food_max();

                    int missing = mod_Food_max - mod_Food;
                    if(missing >= 16800) { //how much does one item give?
                        ((getCustomVarsPassiveEntity) ScannedPassiveEntity).setMod_Food(mod_Food + 16800);
                        entity.getStack(0).decrement(1);
                        world.playSound(null, ScannedPassiveEntity.getBlockPos(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                    }
                }
            }
            else if(ScannedPassiveEntity instanceof GoatEntity) {
                if(itemStack.isIn(ItemTags.SAPLINGS) || itemStack.isIn(ItemTags.LEAVES)) {
                    int mod_Food = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food();
                    int mod_Food_max = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food_max();

                    int missing = mod_Food_max - mod_Food;
                    if(missing >= 16800) { //how much does one item give?
                        ((getCustomVarsPassiveEntity) ScannedPassiveEntity).setMod_Food(mod_Food + 16800);
                        entity.getStack(0).decrement(1);
                        world.playSound(null, ScannedPassiveEntity.getBlockPos(), SoundEvents.ENTITY_GOAT_EAT, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                    }
                }
            }
            else if(ScannedPassiveEntity instanceof ChickenEntity) {
                if(itemStack.isOf(Items.WHEAT) || itemStack.isOf(ModItems.BARLEY)) {
                    int mod_Food = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food();
                    int mod_Food_max = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food_max();

                    int missing = mod_Food_max - mod_Food;
                    if(missing >= 33600) { //how much does one item give?
                        ((getCustomVarsPassiveEntity) ScannedPassiveEntity).setMod_Food(mod_Food + 33600);
                        entity.getStack(0).decrement(1);
                        world.playSound(null, ScannedPassiveEntity.getBlockPos(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                    }
                }
            }
            else if(ScannedPassiveEntity instanceof PigEntity) {
                if(itemStack.isOf(Items.WHEAT) || itemStack.isOf(ModItems.BARLEY) || itemStack.isOf(ModItems.CORN) || itemStack.isOf(ModItems.SOYBEAN) || itemStack.isOf(ModItems.CANOLA) || itemStack.isOf(Items.POTATO) || itemStack.isOf(ModItems.SUGARBEET)) {
                    int mod_Food = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food();
                    int mod_Food_max = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food_max();

                    int missing = mod_Food_max - mod_Food;
                    if(missing >= 16800) { //how much does one item give?
                        ((getCustomVarsPassiveEntity) ScannedPassiveEntity).setMod_Food(mod_Food + 16800);
                        entity.getStack(0).decrement(1);
                        world.playSound(null, ScannedPassiveEntity.getBlockPos(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                    }
                }
            }
            else if(ScannedPassiveEntity instanceof HorseEntity) {
                if(itemStack.isOf(ModItems.OAT)) {
                    int mod_Food = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food();
                    int mod_Food_max = ((getCustomVarsPassiveEntity) ScannedPassiveEntity).getMod_Food_max();

                    int missing = mod_Food_max - mod_Food;
                    if(missing >= 16800) { //how much does one item give?
                        ((getCustomVarsPassiveEntity) ScannedPassiveEntity).setMod_Food(mod_Food + 16800);
                        entity.getStack(0).decrement(1);
                        world.playSound(null, ScannedPassiveEntity.getBlockPos(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                    }
                }
            }

        }



        entity.syncItems();
        markDirty(world, blockPos, state);
    }

}