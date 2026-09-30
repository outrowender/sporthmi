/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IOnlineConnectivityStateListener {
    public static final int USER_ACTION_UNKNOWN = 0;
    public static final int USER_ACTION_CONFIRMED_CONECTION = 1;
    public static final int USER_ACTION_DECLINED_CONECTION = 2;
    public static final int ERROR_UNKNOWN = 0;
    public static final int ERROR_NONE = 1;
    public static final int ERROR_SIM_STATE_NAD_OFF = 2;
    public static final int ERROR_SIM_STATE_NA_DATA_ONLY = 3;
    public static final int ERROR_SIM_STATE_NA = 4;
    public static final int ERROR_SIM_STATE_SAP_NA = 5;
    public static final int ERROR_SIM_STATE_SAP = 6;
    public static final int ERROR_SIM_STATE_PIN_REQUIRED = 7;
    public static final int ERROR_SIM_STATE_PUK_REQUIRED = 8;
    public static final int ERROR_SIM_STATE_PUK_BLOCKED = 9;
    public static final int ERROR_SIM_STATE_FAILURE = 10;
    public static final int ERROR_SIM_STATE_GSM_CALL_ACTIVE = 11;
    public static final int ERROR_PROFILE_INVALID = 12;
    public static final int ERROR_PROFILE_NA = 13;
    public static final int ERROR_PROFILE_MULTI = 14;
    public static final int ERROR_GENERAL_PERMISSION_MANUAL = 15;
    public static final int ERROR_GENERAL_PERMISSION_NEVER = 16;
    public static final int ERROR_PERMISSION_CONFIRMED = 17;
    public static final int ERROR_DATA_DEACTIVATED = 18;
    public static final int ERROR_ROAMING_DEACTIVATED = 19;
    public static final int ERROR_ROAMING_ALLOWED = 20;
    public static final int ERROR_ROAMING_CONFIRMED = 21;
    public static final int ERROR_SIM_STATE_PENDING_DATA_ONLY = 22;
    public static final int ERROR_SIM_STATE_PENDING = 23;
    public static final int MAX_ERROR = 24;
    public static final String[] errorCode2String = new String[]{"ERROR_UNKNOWN", "ERROR_NONE", "ERROR_SIM_STATE_NAD_OFF", "ERROR_SIM_STATE_NA_DATA_ONLY", "ERROR_SIM_STATE_NA", "ERROR_SIM_STATE_SAP_NA", "ERROR_SIM_STATE_SAP", "ERROR_SIM_STATE_PIN_REQUIRED", "ERROR_SIM_STATE_PUK_REQUIRED", "ERROR_SIM_STATE_PUK_BLOCKED", "ERROR_SIM_STATE_FAILURE", "ERROR_SIM_STATE_GSM_CALL_ACTIVE", "ERROR_PROFILE_INVALID", "ERROR_PROFILE_NA", "ERROR_PROFILE_MULTI", "ERROR_GENERAL_PERMISSION_MANUAL", "ERROR_GENERAL_PERMISSION_NEVER", "ERROR_PERMISSION_CONFIRMED", "ERROR_DATA_DEACTIVATED", "ERROR_ROAMING_DEACTIVATED", "ERROR_ROAMING_ALLOWED", "ERROR_ROAMING_CONFIRMED", "ERROR_SIM_STATE_PENDING_DATA_ONLY", "ERROR_SIM_STATE_PENDING"};

    public void onlineStateChanged();

    public void updateErrorState(boolean var1, int var2);

    public void updateConnectionState(boolean var1);

    public void connectivityCheckEntryAction();

    public void connectivityCheckExitAction(boolean var1);

    public void connectivityCheckExitAction(int var1, boolean var2);
}

