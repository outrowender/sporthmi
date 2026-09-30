/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface DataConnectionStateService {
    public static final int DATA_CONNECTION_STATE_PHONE_NOT_ACTIVE = 0;
    public static final int DATA_CONNECTION_STATE_HFP_CONNECTED = 1;
    public static final int DATA_CONNECTION_STATE_GSM_CALL_ACTIVE = 2;
    public static final int DATA_CONNECTION_STATE_PHONE_READY = 3;
    public static final int DATA_CONNECTION_CONFIG_ALWAYS_CONNECT = 0;
    public static final int DATA_CONNECTION_CONFIG_NEVER_CONNECT = 1;
    public static final int DATA_CONNECTION_CONFIG_NOT_AVAILABLE = 2;
    public static final int DATA_CONNECTION_CONFIG_ON_DEMAND = 3;
    public static final int DATAAPPLICATIONID_HOTSPOT = 6;
    public static final int DATAAPPLICATIONID_REAR_SEAT = 7;
    public static final int DATAAPPLICATIONID_ONLINE_SERVICES = 8;

    public boolean isConnectionConfirmed(int var1);

    public void connectionConfirmed(int var1);

    public void connectionConfirmed(int var1, boolean var2);

    public void connectionDenied(int var1);

    public void connectionDenied(int var1, boolean var2);

    public void updateRoamingState(boolean var1);

    public void requestConnect(int var1);

    public void requestDisconnect(int var1);

    public int getDataConnectionState();

    public boolean isConnected(int var1);
}

