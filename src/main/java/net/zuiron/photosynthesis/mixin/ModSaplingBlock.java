package net.zuiron.photosynthesis.mixin;

import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.zuiron.photosynthesis.Photosynthesis;
import net.zuiron.photosynthesis.api.CropData;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.util.ModConstants;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SaplingBlock.class)
public abstract class ModSaplingBlock extends PlantBlock
        implements Fertilizable {

    @Final
    @Shadow public static final IntProperty STAGE = Properties.STAGE;
    @Mutable
    @Final
    @Shadow
    private final SaplingGenerator generator;

    @Shadow public abstract void generate(ServerWorld world, BlockPos pos, BlockState state, Random random);

    @Unique
    private final int MAX_AGE = 7;
    @Unique
    private static final IntProperty AGE = Properties.AGE_7;


    public ModSaplingBlock(SaplingGenerator generator, AbstractBlock.Settings settings) {
        super(settings);
        this.generator = generator;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(STAGE, 0));
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(this.getAgeProperty(), 0));
    }

    @Unique
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Unique
    public int getMaxAge() {
        return this.MAX_AGE;
    }

    @Unique
    public int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    @Unique
    public BlockState withAge(int age) {
        return (BlockState)this.getDefaultState().with(this.getAgeProperty(), age);
    }

    @Unique
    public final boolean isMature(BlockState blockState) {
        return this.getAge(blockState) >= this.getMaxAge();
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        //return !this.isMature(state);
        return true;
    }



    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {

        if(Seasons.isSeasonsEnabled()) {
            CropData cropData = CropData.getCropDataFor(state.getBlock().getTranslationKey());
            //CropData cropData = CropData.getCropDataFor("nonexist.block.photosynthesis.trees"); //use this data for ALL saplings!
            if(cropData != null) {

                int minAge = cropData.getMinAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                int maxAge = cropData.getMaxAge(Seasons.getCurrentSeason(world.getTimeOfDay()));
                float seasonPercentage = Seasons.getSeasonPercentage(world.getTimeOfDay());
                int currentCropAge = this.getAge(state);

                /*int i;
                Photosynthesis.LOGGER.info("Sapling had a randomTick...");
                //if (world.getLightLevel(pos.up()) >= 9 && (i = this.getAge(state)) < this.getMaxAge() && random.nextInt((int)(25.0f / (f = 4.0f)) + 1) == 0) {
                if (world.getLightLevel(pos.up()) >= 9 && (i = this.getAge(state)) < this.getMaxAge()) {
                    Photosynthesis.LOGGER.info("Sapling can now grow. AGE: " + this.getAge(state) + ", newAGE: " + (i + 1));
                    world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
                }*/
                //if sapling is MAXAGE attempt to generate.
                if (this.getAge(state) >= this.getMaxAge()) {
                    //Photosynthesis.LOGGER.info("Sapling is mature, attempt generate now!");
                    //this.generate(world, pos, state, random, ci);
                    this.generate(world,pos,state,random);
                }

                if(currentCropAge >= minAge && currentCropAge < maxAge && seasonPercentage > ModConstants.GROWATABOVEPCT && world.getLightLevel(pos.up()) >= 9) { //0.5f = 50% "halfway thru season"
                    //Photosynthesis.LOGGER.info("Sapling: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NewCropAge: "+(this.getAge(state) + 1)+", %:"+seasonPercentage);
                    world.setBlockState(pos, this.withAge(this.getAge(state) + 1), 2);
                } else {
                    //Photosynthesis.LOGGER.info("Sapling: "+state.getBlock().getTranslationKey()+", minAge:"+minAge+", maxAge:"+maxAge+", CurrentCropAge: "+currentCropAge+", NO GROW"+", %:"+seasonPercentage);
                }

                ci.cancel(); //do not run vanilla code...
            }
        } else { //seasons disabled
            //set age to 7 to display "fully grown sapling texture"
            world.setBlockState(pos, this.withAge(this.getMaxAge()), 2);
        }
        /*Photosynthesis.LOGGER.info("randomTick - Sapling - stage: "+state.get(STAGE));
        //TODO - implement growing like crops with stages, make it so all saplings needs to be planted in summer and grow into trees in spring
        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(7) == 0) {
            this.generate(world, pos, state, random, ci);
        }*/
        //ci.cancel();
    }

    @Unique
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int j;
        int i = this.getAge(state) + this.getGrowthAmount(world);
        if (i > (j = this.getMaxAge())) {
            i = j;
        }
        world.setBlockState(pos, this.withAge(i), Block.NOTIFY_LISTENERS);
    }

    @Unique
    protected int getGrowthAmount(World world) {
        return MathHelper.nextInt(world.random, 1, 1);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        if(Seasons.isSeasonsEnabled()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.applyGrowth(world, pos, state);
    }

    @Inject(method = "generate", at = @At("HEAD"), cancellable = true)
    public void generate(ServerWorld world, BlockPos pos, BlockState state, Random random, CallbackInfo ci) {
        if(Seasons.isSeasonsEnabled()) {
            //this.generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
            //Photosynthesis.LOGGER.info("Generating Tree!");

            if (state.get(STAGE) == 0) {
                world.setBlockState(pos, (BlockState)state.cycle(STAGE), Block.NO_REDRAW);
            } else {
                this.generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
                Photosynthesis.LOGGER.info("Generating Tree!");
            }
            ci.cancel(); //do not run vanilla code
        }
    }

    @Inject(method = "appendProperties", at = @At("HEAD"), cancellable = true)
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
        //builder.add(this.AGE, STAGE);
        builder.add(AGE);
        //ci.cancel();
    }
}
