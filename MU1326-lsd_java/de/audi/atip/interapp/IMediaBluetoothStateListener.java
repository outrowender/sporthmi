/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IMediaBluetoothStateListener {
    public static final int STATE_BT_OFF;
    public static final int STATE_A2DP_SETTING_OFF;
    public static final int STATE_A2DP_CONNECTED;
    public static final int STATE_A2DP_RECONNECTING;
    public static final int STATE_A2DP_IDLE;

    default public void updateBluetoothState(int n) {
    }

    default public void actionStarted() {
    }

    default public void actionStopped() {
    }
}

