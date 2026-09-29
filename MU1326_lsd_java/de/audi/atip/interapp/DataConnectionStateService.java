/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface DataConnectionStateService {
    public static final int DATA_CONNECTION_STATE_PHONE_NOT_ACTIVE;
    public static final int DATA_CONNECTION_STATE_HFP_CONNECTED;
    public static final int DATA_CONNECTION_STATE_GSM_CALL_ACTIVE;
    public static final int DATA_CONNECTION_STATE_PHONE_READY;
    public static final int DATA_CONNECTION_CONFIG_ALWAYS_CONNECT;
    public static final int DATA_CONNECTION_CONFIG_NEVER_CONNECT;
    public static final int DATA_CONNECTION_CONFIG_NOT_AVAILABLE;
    public static final int DATA_CONNECTION_CONFIG_ON_DEMAND;
    public static final int DATAAPPLICATIONID_HOTSPOT;
    public static final int DATAAPPLICATIONID_REAR_SEAT;
    public static final int DATAAPPLICATIONID_ONLINE_SERVICES;

    default public boolean isConnectionConfirmed(int n) {
    }

    default public void connectionConfirmed(int n) {
    }

    default public void connectionConfirmed(int n, boolean bl) {
    }

    default public void connectionDenied(int n) {
    }

    default public void connectionDenied(int n, boolean bl) {
    }

    default public void updateRoamingState(boolean bl) {
    }

    default public void requestConnect(int n) {
    }

    default public void requestDisconnect(int n) {
    }

    default public int getDataConnectionState() {
    }

    default public boolean isConnected(int n) {
    }
}

