/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface DataConnectionStateListener {
    public static final int DATA_CONNECTION_ERROR_STATE_CONNECTION_FAILED;
    public static final int DATA_CONNECTION_ERROR_STATE_NO_SIGNAL;
    public static final int DATA_CONNECTION_ERROR_STATE_ABORTED;
    public static final int DATA_CONNECTION_ERROR_STATE_ROAMING_DISCONNECT;
    public static final int DATA_CONNECTION_ERROR_STATE_DATA_REQUEST_DECLINED;
    public static final int DATA_CONNECTION_STATE_NOT_CONNECTED;
    public static final int DATA_CONNECTION_STATE_CONNECTED_GPRS;
    public static final int DATA_CONNECTION_STATE_CONNECTED_UMTS;
    public static final int DATA_CONNECTION_STATE_CONNECTED_GPRS_ROAMING;
    public static final int DATA_CONNECTION_STATE_CONNECTED_UMTS_ROAMING;

    default public void updateDataConnectionErrorState(int n) {
    }

    default public void updateDataConnectionState(int n) {
    }

    default public void resetOfflineFlags() {
    }
}

