/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

public interface IPictureWallCallbackReceiver {
    public static final int TYP_SET_MODEL_ROWS = 0;
    public static final int TYP_SET_VIEWPORT_OFFSET = 1;
    public static final int TYP_BLOCK_CACHE = 2;
    public static final int TYP_BLOCK_CACHE_UPDATE = 3;
    public static final int TYP_TEXTURE_CACHE = 4;
    public static final int TYP_TEXTURE_CACHE_UPDATE = 5;
    public static final int TYP_ASYNC_TEXTURE_LOADER = 6;
    public static final int TYP_QUEUE_CHANGED = 7;

    public void receivePictureViewerCallback(int var1, Object[] var2);
}

