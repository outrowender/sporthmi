/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IWordPredictionCallback {
    public static final int MODE_USE_CCP = 0;
    public static final int MODE_USE_DSI = 1;

    public int getMode();

    public int getPoiXt9Mode();

    public void databaseNamesAvailableCallback(String[] var1);
}

