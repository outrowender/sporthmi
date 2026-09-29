/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IOnlineConnectivityStateListener {
    public static final int USER_ACTION_UNKNOWN;
    public static final int USER_ACTION_CONFIRMED_CONECTION;
    public static final int USER_ACTION_DECLINED_CONECTION;
    public static final int ERROR_UNKNOWN;
    public static final int ERROR_NONE;
    public static final int ERROR_SIM_STATE_NAD_OFF;
    public static final int ERROR_SIM_STATE_NA_DATA_ONLY;
    public static final int ERROR_SIM_STATE_NA;
    public static final int ERROR_SIM_STATE_SAP_NA;
    public static final int ERROR_SIM_STATE_SAP;
    public static final int ERROR_SIM_STATE_PIN_REQUIRED;
    public static final int ERROR_SIM_STATE_PUK_REQUIRED;
    public static final int ERROR_SIM_STATE_PUK_BLOCKED;
    public static final int ERROR_SIM_STATE_FAILURE;
    public static final int ERROR_SIM_STATE_GSM_CALL_ACTIVE;
    public static final int ERROR_PROFILE_INVALID;
    public static final int ERROR_PROFILE_NA;
    public static final int ERROR_PROFILE_MULTI;
    public static final int ERROR_GENERAL_PERMISSION_MANUAL;
    public static final int ERROR_GENERAL_PERMISSION_NEVER;
    public static final int ERROR_PERMISSION_CONFIRMED;
    public static final int ERROR_DATA_DEACTIVATED;
    public static final int ERROR_ROAMING_DEACTIVATED;
    public static final int ERROR_ROAMING_ALLOWED;
    public static final int ERROR_ROAMING_CONFIRMED;
    public static final int ERROR_SIM_STATE_PENDING_DATA_ONLY;
    public static final int ERROR_SIM_STATE_PENDING;
    public static final int MAX_ERROR;
    public static final String[] errorCode2String;

    default public void onlineStateChanged() {
    }

    default public void updateErrorState(boolean bl, int n) {
    }

    default public void updateConnectionState(boolean bl) {
    }

    default public void connectivityCheckEntryAction() {
    }

    default public void connectivityCheckExitAction(boolean bl) {
    }

    default public void connectivityCheckExitAction(int n, boolean bl) {
    }

    static {
        errorCode2String = new String[]{"ERROR_UNKNOWN", "ERROR_NONE", "ERROR_SIM_STATE_NAD_OFF", "ERROR_SIM_STATE_NA_DATA_ONLY", "ERROR_SIM_STATE_NA", "ERROR_SIM_STATE_SAP_NA", "ERROR_SIM_STATE_SAP", "ERROR_SIM_STATE_PIN_REQUIRED", "ERROR_SIM_STATE_PUK_REQUIRED", "ERROR_SIM_STATE_PUK_BLOCKED", "ERROR_SIM_STATE_FAILURE", "ERROR_SIM_STATE_GSM_CALL_ACTIVE", "ERROR_PROFILE_INVALID", "ERROR_PROFILE_NA", "ERROR_PROFILE_MULTI", "ERROR_GENERAL_PERMISSION_MANUAL", "ERROR_GENERAL_PERMISSION_NEVER", "ERROR_PERMISSION_CONFIRMED", "ERROR_DATA_DEACTIVATED", "ERROR_ROAMING_DEACTIVATED", "ERROR_ROAMING_ALLOWED", "ERROR_ROAMING_CONFIRMED", "ERROR_SIM_STATE_PENDING_DATA_ONLY", "ERROR_SIM_STATE_PENDING"};
    }
}

