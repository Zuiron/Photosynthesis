package net.zuiron.photosynthesis.block.entity;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.Photosynthesis;

public class BaleBlockEntity extends BlockEntity {
    private int durability = 1000; //max 1000
    public BaleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BALE, pos, state);
    }

    public static int getDurability(BaleBlockEntity baleBlockEntity) {
        return baleBlockEntity.durability;
    }

    public static void setDurability(BaleBlockEntity baleBlockEntity, int durability) {
        baleBlockEntity.durability = durability;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("bale.durability", durability);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        durability = nbt.getInt("bale.durability");
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, BaleBlockEntity baleBlockEntity) {
        Photosynthesis.LOGGER.info("i am ticking. "+blockState.getBlock().getName()+", dura: "+ baleBlockEntity.durability);
        baleBlockEntity.durability--;
    }
}
