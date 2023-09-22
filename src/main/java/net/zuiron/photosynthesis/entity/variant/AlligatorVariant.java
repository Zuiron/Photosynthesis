package net.zuiron.photosynthesis.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum AlligatorVariant {
    DEFAULT(0),
    BROWN(1),
    BLACK(2);

    private static final AlligatorVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(AlligatorVariant::getId)).toArray(AlligatorVariant[]::new);
    private final int id;

    AlligatorVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static AlligatorVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
