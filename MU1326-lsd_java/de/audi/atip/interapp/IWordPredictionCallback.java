/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IWordPredictionCallback {
    public static final int MODE_USE_CCP;
    public static final int MODE_USE_DSI;

    default public int getMode() {
    }

    default public int getPoiXt9Mode() {
    }

    default public void databaseNamesAvailableCallback(String[] stringArray) {
    }
}

