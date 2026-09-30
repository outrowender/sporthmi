/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IMediaBluetoothStateListener {
    public static final int STATE_BT_OFF = 0;
    public static final int STATE_A2DP_SETTING_OFF = 1;
    public static final int STATE_A2DP_CONNECTED = 2;
    public static final int STATE_A2DP_RECONNECTING = 3;
    public static final int STATE_A2DP_IDLE = 4;

    public void updateBluetoothState(int var1);

    public void actionStarted();

    public void actionStopped();
}

