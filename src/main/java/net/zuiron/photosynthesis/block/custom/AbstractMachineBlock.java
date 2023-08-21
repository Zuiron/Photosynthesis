package net.zuiron.photosynthesis.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.zuiron.photosynthesis.state.property.ModProperties;

public abstract class AbstractMachineBlock extends BlockWithEntity {
    public static BooleanProperty SLOT_LOCKED = ModProperties.SLOT_LOCKED;

    protected AbstractMachineBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(SLOT_LOCKED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SLOT_LOCKED);
    }
}
