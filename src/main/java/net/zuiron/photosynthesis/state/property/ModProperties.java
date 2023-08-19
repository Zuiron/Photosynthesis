package net.zuiron.photosynthesis.state.property;

import net.minecraft.state.property.IntProperty;

public class ModProperties {
    public static final IntProperty MOD_FERTILIZED = IntProperty.of("mod_fertilized", 0, 2);
    public static final IntProperty MOD_PESTICIDED = IntProperty.of("mod_pesticided", 0, 1);
}
