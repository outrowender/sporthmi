/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import java.util.List;

public class PictureWallCache$RequestQueue
implements Comparable {
    List data;
    int id;
    int blockNumber;
    int distanceToCurrentBlock;

    @Override
    public int compareTo(Object object) {
        if (object instanceof PictureWallCache$RequestQueue) {
            return this.distanceToCurrentBlock - ((PictureWallCache$RequestQueue)object).distanceToCurrentBlock;
        }
        throw new UnsupportedOperationException();
    }

    public List getData() {
        return this.data;
    }
}

