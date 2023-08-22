package net.zuiron.photosynthesis.state.property;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;

public class ModProperties {
    public static final IntProperty MOD_FERTILIZED = IntProperty.of("mod_fertilized", 0, 2);
    public static final IntProperty MOD_PESTICIDED = IntProperty.of("mod_pesticided", 0, 1);
    public static final BooleanProperty SLOT_LOCKED = BooleanProperty.of("slot_locked");
    public static final IntProperty PROGRESS3 = IntProperty.of("progress3", 0, 2);
}
