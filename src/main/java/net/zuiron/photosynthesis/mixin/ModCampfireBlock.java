package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.item.ModItems;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CampfireBlock.class)
public abstract class ModCampfireBlock extends BlockWithEntity
        implements Waterloggable {

    private static final BooleanProperty LIT = Properties.LIT;
    private static final BooleanProperty CHARCOALED = BooleanProperty.of("charcoaled");

    protected ModCampfireBlock(boolean emitsParticles, int fireDamage, AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        state = (BlockState)state.with(LIT, false).with(CHARCOALED,false);
        world.setBlockState(pos, state, 3);
    }

    @Inject(method = "onUse", at = @At("HEAD"))
    public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        //if we have tiny charcoal in hand, LIT it up!
        if(!state.get(LIT).booleanValue()) {
            if (player.getStackInHand(hand).getItem() == ModItems.FIRESTARTER) {

                if(player.getStackInHand(hand).getMaxDamage() - player.getStackInHand(hand).getDamage() < 1) {
                    player.setStackInHand(hand, ItemStack.EMPTY);
                    //play sound.
                    if (!world.isClient) {
                        world.playSound(
                                null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                                pos, // The position of where the sound will come from
                                SoundEvents.ITEM_SHIELD_BREAK, // The sound that will play, in this case, the sound the anvil plays when it lands.
                                SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                                1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                                1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
                        );
                    }
                }
                player.getStackInHand(hand).damage(1, Random.create(0), null);

                state = (BlockState) state.with(LIT, true).with(CHARCOALED, true);
                world.setBlockState(pos, state, 3);
            }
        }
    }

    @Inject(method = "appendProperties", at = @At("HEAD"))
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(CHARCOALED);
    }
}
