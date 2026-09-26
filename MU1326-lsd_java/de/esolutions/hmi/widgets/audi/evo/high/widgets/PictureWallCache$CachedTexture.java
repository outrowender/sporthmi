/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconRenderer;

public class PictureWallCache$CachedTexture {
    public static final int STATE_LOADED;
    public static final int STATE_ENQUEUED;
    public static final int STATE_ENQUEUED_AND_LOADED;
    public static final int STATE_IN_CACHE;
    String path;
    IWrappedTexture data;
    boolean loadingError = false;
    PictureWallIconRenderer listener;
    int modelRow;
    public int state;

    public IWrappedTexture getData() {
        return this.data;
    }

    public int getModelRow() {
        return this.modelRow;
    }
}

