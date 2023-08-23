package net.zuiron.photosynthesis.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.zuiron.photosynthesis.api.Seasons;
import net.zuiron.photosynthesis.block.custom.SeasonsCalendarBlock;
import net.zuiron.photosynthesis.state.property.ModProperties;

import java.util.Objects;

public class SeasonsCalendarBlockEntity extends BlockEntity {
    public SeasonsCalendarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SEASONSCALENDAR, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, SeasonsCalendarBlockEntity entity) {
        if(Seasons.isSeasonsEnabled()) {
            if(state.contains(ModProperties.RPOWER) && state.contains(Properties.POWERED) && state.contains(ModProperties.SEASON)) {
                //set red-stone power based on time of year.
                if(state.get(Properties.POWERED)) {
                    if (state.get(ModProperties.RPOWER) != entity.getSeasonRedstonePower(world)) {
                        world.setBlockState(blockPos, state.with(ModProperties.RPOWER, entity.getSeasonRedstonePower(world)), Block.NOTIFY_ALL);
                    }
                }
                //set season state to current season.
                int currentSeason = Seasons.getCurrentSeason(world.getTimeOfDay());
                if(state.get(ModProperties.SEASON) != currentSeason) {
                    world.setBlockState(blockPos, state.with(ModProperties.SEASON, currentSeason), 2);
                }
            }
        }
    }

    public int getSeasonRedstonePower(World world) {
        long time = world.getTimeOfDay();
        int daysPerYear = Seasons.getDaysPerYear();
        int dayOfYear = Seasons.getDayOfYear(time);

        int redstonePower = Math.max(1, (int) Math.ceil((15.0 / daysPerYear) * dayOfYear));
        return redstonePower;
    }
}
