/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface DataConnectionStateListener {
    public static final int DATA_CONNECTION_ERROR_STATE_CONNECTION_FAILED = 1;
    public static final int DATA_CONNECTION_ERROR_STATE_NO_SIGNAL = 2;
    public static final int DATA_CONNECTION_ERROR_STATE_ABORTED = 3;
    public static final int DATA_CONNECTION_ERROR_STATE_ROAMING_DISCONNECT = 100;
    public static final int DATA_CONNECTION_ERROR_STATE_DATA_REQUEST_DECLINED = 101;
    public static final int DATA_CONNECTION_STATE_NOT_CONNECTED = 0;
    public static final int DATA_CONNECTION_STATE_CONNECTED_GPRS = 1;
    public static final int DATA_CONNECTION_STATE_CONNECTED_UMTS = 2;
    public static final int DATA_CONNECTION_STATE_CONNECTED_GPRS_ROAMING = 3;
    public static final int DATA_CONNECTION_STATE_CONNECTED_UMTS_ROAMING = 4;

    public void updateDataConnectionErrorState(int var1);

    public void updateDataConnectionState(int var1);

    public void resetOfflineFlags();
}

