/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity;

public interface IBondingState {
    public static final int BONDING_STATE_IDLE = 0;
    public static final int BONDING_STATE_CONNECTING = 1;
    public static final int BONDING_STATE_COMPARE = 2;
    public static final int BONDING_STATE_ENTRY_MOBILE = 3;
    public static final int BONDING_STATE_ENTRY_MU = 4;
    public static final int BONDING_RESULT_SUCCESSFUL = 0;
    public static final int BONDING_RESULT_TIMEOUT = 1;
    public static final int BONDING_RESULT_ERROR_PIN = 2;
    public static final int BONDING_RESULT_ERROR_EXTERNAL = 3;
    public static final int BONDING_RESULT_ERROR_GENERAL = 4;
    public static final int BONDING_RESULT_ERROR_ABORT = 5;

    public void updateBondingState(int var1);

    public void updateBondingResult(int var1);

    public void updateDeviceAddress(String var1);

    public void updateDeviceName(String var1);

    public int getBondingState();

    public int getBondingResult();

    public String getDeviceAddress();

    public String getDeviceName();
}

