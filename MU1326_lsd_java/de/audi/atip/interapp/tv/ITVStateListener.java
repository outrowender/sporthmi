/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

public interface ITVStateListener {
    public static final int TV_STATE_READY;
    public static final int TV_STATE_NOT_READY;

    default public void updateState(int n, int[] nArray) {
    }
}

