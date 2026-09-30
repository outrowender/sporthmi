/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

public interface ITVStateListener {
    public static final int TV_STATE_READY = 0;
    public static final int TV_STATE_NOT_READY = 1;

    public void updateState(int var1, int[] var2);
}

