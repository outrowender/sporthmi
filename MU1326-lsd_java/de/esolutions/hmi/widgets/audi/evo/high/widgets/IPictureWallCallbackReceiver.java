/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

public interface IPictureWallCallbackReceiver {
    public static final int TYP_SET_MODEL_ROWS;
    public static final int TYP_SET_VIEWPORT_OFFSET;
    public static final int TYP_BLOCK_CACHE;
    public static final int TYP_BLOCK_CACHE_UPDATE;
    public static final int TYP_TEXTURE_CACHE;
    public static final int TYP_TEXTURE_CACHE_UPDATE;
    public static final int TYP_ASYNC_TEXTURE_LOADER;
    public static final int TYP_QUEUE_CHANGED;

    default public void receivePictureViewerCallback(int n, Object[] objectArray) {
    }
}

