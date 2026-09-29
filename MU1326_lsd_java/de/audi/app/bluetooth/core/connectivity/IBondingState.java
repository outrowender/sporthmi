/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity;

public interface IBondingState {
    public static final int BONDING_STATE_IDLE;
    public static final int BONDING_STATE_CONNECTING;
    public static final int BONDING_STATE_COMPARE;
    public static final int BONDING_STATE_ENTRY_MOBILE;
    public static final int BONDING_STATE_ENTRY_MU;
    public static final int BONDING_RESULT_SUCCESSFUL;
    public static final int BONDING_RESULT_TIMEOUT;
    public static final int BONDING_RESULT_ERROR_PIN;
    public static final int BONDING_RESULT_ERROR_EXTERNAL;
    public static final int BONDING_RESULT_ERROR_GENERAL;
    public static final int BONDING_RESULT_ERROR_ABORT;

    default public void updateBondingState(int n) {
    }

    default public void updateBondingResult(int n) {
    }

    default public void updateDeviceAddress(String string) {
    }

    default public void updateDeviceName(String string) {
    }

    default public int getBondingState() {
    }

    default public int getBondingResult() {
    }

    default public String getDeviceAddress() {
    }

    default public String getDeviceName() {
    }
}

