/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import java.util.ArrayList;
import java.util.List;

public class PictureWallCache$CacheBlock {
    static final Integer NO_VALUE = new Integer(-1);
    Integer blockNumber;
    List data;
    Integer requestID = NO_VALUE;
    boolean loaded = false;

    public PictureWallCache$CacheBlock(int n) {
        this.data = new ArrayList(12);
        this.blockNumber = new Integer(n);
    }

    public Integer getBlockNumber() {
        return this.blockNumber;
    }

    public boolean isLoaded() {
        return this.loaded;
    }
}

