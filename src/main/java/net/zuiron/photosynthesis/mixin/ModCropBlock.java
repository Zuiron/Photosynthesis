package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.block.ModBlocks;
import net.zuiron.photosynthesis.item.ModItems;
import net.zuiron.photosynthesis.state.property.ModProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public abstract class ModCropBlock extends PlantBlock
        implements Fertilizable {

    public ModCropBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(MOD_FERTILIZED, 0).with(MOD_PESTICIDED,0));
    }

    @Shadow protected abstract int getAge(BlockState state);

    @Shadow public abstract BlockState withAge(int age);

    @Shadow @Final public static IntProperty AGE;

    //@Shadow public abstract void applyGrowth(World world, BlockPos pos, BlockState state);

    @Unique
    private static final IntProperty MOD_FERTILIZED = ModProperties.MOD_FERTILIZED;

    @Unique
    private static final IntProperty MOD_PESTICIDED = ModProperties.MOD_PESTICIDED;

    @Inject(method = "appendProperties", at = @At("HEAD"), cancellable = true)
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(MOD_FERTILIZED,MOD_PESTICIDED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        //if MATURE, disallow any interactions.
        if(state.contains(AGE) && state.get(Properties.AGE_7) < 7 && state.contains(ModProperties.MOD_PESTICIDED) && state.contains(ModProperties.MOD_FERTILIZED)) {
            if (player.getStackInHand(hand).isOf(ModItems.MANURE)) {
                //you can only apply first stage fertilizer at below age 3.
                if (state.get(MOD_FERTILIZED) == 0 && state.get(Properties.AGE_7) < 3) {
                    world.setBlockState(pos, state.with(MOD_FERTILIZED, 1), 2);
                    player.getStackInHand(hand).decrement(1);
                    if(world.isClient) {
                        BoneMealItem.createParticles(world, pos, 20);
                        world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                    }
                    return ActionResult.SUCCESS;
                }
                //you can only apply second stage fertilizer at above age 3. requires pesticide applied.
                else if (state.get(MOD_FERTILIZED) == 1 && state.get(MOD_PESTICIDED) == 1 && state.get(Properties.AGE_7) > 3) {
                    world.setBlockState(pos, state.with(MOD_FERTILIZED, 2), 2);
                    player.getStackInHand(hand).decrement(1);
                    if(world.isClient) {
                        BoneMealItem.createParticles(world, pos, 20);
                        world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                    }
                    return ActionResult.SUCCESS;
                }
            }
            //you can only apply pesticide if one stage of fertilizer is applied.
            else if (player.getStackInHand(hand).isOf(ModItems.SULFUR_DUST)) {
                if (state.get(MOD_PESTICIDED) == 0 && state.get(MOD_FERTILIZED) == 1) {
                    world.setBlockState(pos, state.with(MOD_PESTICIDED, 1), 2);
                    player.getStackInHand(hand).decrement(1);
                    if(world.isClient) {
                        BoneMealItem.createParticles(world, pos, 20);
                        world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                    }
                    return ActionResult.SUCCESS;
                }
            }
        }
        //custom fixed bone mealing code.
        if(state.get(Properties.AGE_7) < 7 && player.getStackInHand(hand).isOf(Items.BONE_MEAL) && !Seasons.isSeasonsEnabled()) {
            /*world.setBlockState(pos, state.with(AGE, state.get(AGE) + 1), 2);
            player.getStackInHand(hand).decrement(1);
            if(world.isClient) {
                BoneMealItem.createParticles(world, pos, 20);
                world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            }
            return ActionResult.SUCCESS;*/
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Inject(method = "applyGrowth", at = @At("HEAD"), cancellable = true)
    public void applyGrowth(World world, BlockPos pos, BlockState state, CallbackInfo ci) {
        //fix vanilla code!
        world.setBlockState(pos, state.with(AGE, state.get(AGE) + 1), Block.NOTIFY_LISTENERS);
        ci.cancel(); //cancel vanilla code.
    }

    @Inject(method = "isFertilizable", at = @At("HEAD"), cancellable = true)
    public void isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient, CallbackInfoReturnable<Boolean> cir) {
        //disable bonemealing on crops we have cropdata for.
        if(Seasons.isSeasonsEnabled()) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
        //disable bonemeal completely, it ruins our properties. withAge fucks it up.
        //cir.setReturnValue(false);
        //cir.cancel();
    }

    @Inject(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/CropBlock;withAge(I)Lnet/minecraft/block/BlockState;", ordinal = 0), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {

        if(Seasons.isSeasonsEnabled()) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            if(cropData != null) {
                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = this.getAge(state);

                /*Biome biome = world.getBiome(pos).value();
                float temperature = biome.getTemperature();
                Photosynthesis.LOGGER.info("current temperature: "+temperature);*/

                if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > 0.5f) { //0.5f = 50% "halfway thru season"
                    //Photosynthesis.LOGGER.info("Crop: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(this.getAge(state) + 1)+", %:"+seasonPercentage);
                    //world.setBlockState(pos, this.withAge(this.getAge(state) + 1), 2);
                    world.setBlockState(pos, state.with(AGE, this.getAge(state) + 1), 2);
                } else {
                    //Photosynthesis.LOGGER.info("Crop: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                }
                ci.cancel(); //cancel, do not run vanilla code.
                //Note we only cancel IF we found seasons data for the crop. otherwise vanilla code runs.
            }
        } else {
            //fix vanilla code to not mess with our fertilizer properties...
            world.setBlockState(pos, state.with(AGE, this.getAge(state) + 1), 2);
            ci.cancel(); //cancel, do not run vanilla code.
        }
        //world.setBlockState(pos, this.withAge(i + 1), 2); //Original MC Code
    }

    /*@Inject(method = "randomTick", at = @At("HEAD"))
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        Photosynthesis.LOGGER.info("test");
    }*/
}
