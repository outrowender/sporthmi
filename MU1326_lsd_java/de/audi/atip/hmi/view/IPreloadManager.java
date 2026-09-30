/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

public interface IPreloadManager {
    public void addPreloadingBatch(int[] var1);

    public void addPreloadingBatches(int[][] var1);

    public void start();
}

