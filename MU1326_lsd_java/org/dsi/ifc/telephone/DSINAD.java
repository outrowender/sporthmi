/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIBase;

public interface DSINAD
extends DSIBase {
    public static final String VERSION = "2.11.27";
    public static final int RT_REQUESTNETWORKREGISTRATION = 1008;
    public static final int RT_REQUESTABORTNETWORKREGISTRATION = 1009;
    public static final int RT_REQUESTNETWORKSEARCH = 1010;
    public static final int RT_REQUESTABORTNETWORKSEARCH = 1011;
    public static final int RT_REQUESTSETAUTOMATICPINENTRYACTIVE = 1016;
    public static final int RT_REQUESTTELPOWER = 1023;
    public static final int RT_REQUESTUNLOCKSIM = 1024;
    public static final int RT_REQUESTCHECKSIMPINCODE = 1025;
    public static final int RT_REQUESTCHANGESIMCODE = 1026;
    public static final int RT_REQUESTSIMPINREQUIRED = 1030;
    public static final int RT_RESTOREFACTORYSETTINGS = 1031;
    public static final int ATTR_SIMPINREQUIRED = 3;
    public static final int ATTR_ACTIVATIONSTATE = 4;
    public static final int ATTR_AUTOMATICPINENTRYACTIVE = 5;
    public static final int ATTR_LOCKSTATE = 16;
    public static final int ATTR_NADTEMPERATURE = 19;
    public static final int ATTR_PHONEINFORMATION = 20;
    public static final int ATTR_NETWORKPROVIDER = 21;
    public static final int ATTR_NETWORKTYPE = 22;
    public static final int ATTR_REGISTERSTATE = 24;
    public static final int ATTR_SIGNALQUALITY = 27;
    public static final int ATTR_SERVICEPROVIDER = 29;
    public static final int RP_RESPONSEABORTNETWORKREGISTRATION = 2000;
    public static final int RP_RESPONSEABORTNETWORKSEARCH = 2001;
    public static final int RP_RESPONSECHANGESIMCODE = 2005;
    public static final int RP_RESPONSESIMPINREQUIRED = 2009;
    public static final int RP_RESPONSENETWORKREGISTRATION = 2012;
    public static final int RP_RESPONSENETWORKSEARCH = 2013;
    public static final int RP_RESPONSEUNLOCKSIM = 2014;
    public static final int RP_RESPONSECHECKSIMPINCODE = 2015;
    public static final int RP_RESPONSERESTOREFACTORYSETTINGS = 2016;
    public static final int RP_RESPONSETELPOWER = 2023;
    public static final int RP_RESPONSESETAUTOMATICPINENTRYACTIVE = 2024;
    public static final int ACTIVATIONSTATE_INIT = 0;
    public static final int ACTIVATIONSTATE_NOT_ATTACHED = 1;
    public static final int ACTIVATIONSTATE_TEL_ACTIVE_CALL = 2;
    public static final int ACTIVATIONSTATE_PHONE_OFF = 4;
    public static final int ACTIVATIONSTATE_PHONE_ON = 5;
    public static final int ACTIVATIONSTATE_ATTACHED_NOT_READY = 7;
    public static final int ACTIVATIONSTATE_ATTACHED_NOT_FUNC = 9;
    public static final int ACTIVATIONSTATE_ME_RECONNECT = 12;
    public static final int PHONEMODULESTATE_N_A = 0;
    public static final int PHONEMODULESTATE_OFF_TEMP = 1;
    public static final int PHONEMODULESTATE_ON = 2;
    public static final int PHONEMODULESTATE_OFF = 3;
    public static final int PHONEMODULESTATE_OFF_DIAG = 4;
    public static final int PHONEMODULESTATE_NOT_FUNCTION = 5;
    public static final int PHONEMODULESTATE_INIT = 6;
    public static final int NADTEMPLEVEL_NORMAL = 0;
    public static final int NADTEMPLEVEL_UNDER = 1;
    public static final int NADTEMPLEVEL_WARNING = 2;
    public static final int NADTEMPLEVEL_HIGH = 3;
    public static final int NADTEMPLEVEL_UNKNOWN = 4;
    public static final int POWER_OFF_PERS = 0;
    public static final int POWER_ON_PERS = 1;
    public static final int LOCKSTATE_UNKNOWN = 0;
    public static final int LOCKSTATE_UNLOCK_INPR = 1;
    public static final int LOCKSTATE_NO_LOCK = 2;
    public static final int LOCKSTATE_PIN_REQUIRED = 3;
    public static final int LOCKSTATE_PIN2_REQUIRED = 4;
    public static final int LOCKSTATE_PUK_REQUIRED = 5;
    public static final int LOCKSTATE_PUK2_REQUIRED = 6;
    public static final int LOCKSTATE_PUK_BLOCKED = 7;
    public static final int LOCKSTATE_PUK2_BLOCKED = 8;
    public static final int LOCKSTATE_SECCO_REQUIRED = 9;
    public static final int LOCKSTATE_SECCO_BLOCKED = 10;
    public static final int LOCKSTATE_SIMNOTFUNC = 11;
    public static final int REGISTERSTATE_UNKNOWN = 0;
    public static final int REGISTERSTATE_REGISTERED = 1;
    public static final int REGISTERSTATE_ROAMING = 2;
    public static final int REGISTERSTATE_SEARCHING = 3;
    public static final int REGISTERSTATE_NOT_SEARCHING = 4;
    public static final int REGISTERSTATE_DENIED = 5;
    public static final int REGMODE_MANUAL = 0;
    public static final int REGMODE_AUTOMATIC = 1;
    public static final int NETTYPE_UNKNOWN = 0;
    public static final int NETTYPE_GSM = 1;
    public static final int NETTYPE_CDMA = 2;
    public static final int NETTYPE_PDC = 3;
    public static final int NETTYPE_UMTS = 4;
    public static final int NETTYPE_LTE = 5;
    public static final int LOCKCODE_PIN = 0;
    public static final int LOCKCODE_PIN2 = 1;
    public static final int LOCKCODE_PUK = 2;
    public static final int LOCKCODE_PUK2 = 3;
    public static final int LOCKCODE_SECCO = 4;
    public static final int SERVICESTATE_IDLE = 0;
    public static final int SERVICESTATE_SESSION = 1;
    public static final int SERVICESTATE_TERMINATED = 2;
    public static final int SERVICESTATE_RESPONDED = 3;
    public static final int SERVICESTATE_NOSUP = 4;
    public static final int SERVICESTATE_ERROR = 5;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ABORTED = 1;
    public static final int RESULT_ERROR_NOSUP_PHONE = 2;
    public static final int RESULT_ERROR_NOSUP_NW = 3;
    public static final int RESULT_ERROR_UNSPECIFIED = 4;
    public static final int RESULT_ERROR_CODE_WRONG = 5;
    public static final int RESULT_ERROR_SERV_BUSY = 6;
    public static final int RESULT_ERROR_NOT_ALLOWED = 7;
    public static final int RESULT_ERROR_SIM_FAILURE = 8;
    public static final int RESULT_ERROR_CODE_INVALID_FORMAT = 9;
    public static final int RESULT_ERROR_STRING_TOO_LONG = 11;
    public static final int RESULT_ERROR_NO_NW_REPLY = 12;
    public static final int RESULT_ERROR_NO_NW_ACCESS = 13;
    public static final int RESULT_ERROR_INVALID_CALL_ID = 14;
    public static final int RESULT_ERROR_NW_REGISTRATION_NOT_ALLOWED = 15;
    public static final int RESULT_ERROR_VOICE_NOT_POSSIBLE_CARPLAY_ACTIVE = 17;
    public static final int RESULT_ERROR_VOICE_NOT_POSSIBLE_ANDROID_AUTO_ACTIVE = 18;
    public static final int PROVIDERSTATE_UNKNOWN = 0;
    public static final int PROVIDERSTATE_SELECTED = 1;
    public static final int PROVIDERSTATE_FORBIDDEN = 2;
    public static final int PROVIDERSTATE_AVAILABLE = 3;
    public static final int FACMODE_LOCK = 0;
    public static final int FACMODE_UNLOCK = 1;
    public static final int FACMODE_QUERY = 2;
    public static final int FACILITY_UNKNOWN = 0;
    public static final int FACILITY_SC = 1;
    public static final int FACSTATE_NOT_ACTIVE = 0;
    public static final int FACSTATE_ACTIVE = 1;
    public static final int NETIDAVAIL_TEMP_NOT_AVAIL = 0;
    public static final int NETIDAVAIL_NOT_AVAIL = 1;
    public static final int NETIDAVAIL_AVAIL = 2;
    public static final int SERVICECODEREQTYPE_UNKNOWN = 0;
    public static final int SERVICECODEREQTYPE_ACTIVATION = 1;
    public static final int SERVICECODEREQTYPE_DEACTIVATION = 2;
    public static final int SERVICECODEREQTYPE_INTERROGATION = 3;
    public static final int SERVICECODEREQTYPE_REGISTRATION = 4;
    public static final int SERVICECODEREQTYPE_ERASURE = 5;

    public void requestNetworkRegistration(String var1, int var2);

    public void requestAbortNetworkRegistration();

    public void requestNetworkSearch();

    public void requestAbortNetworkSearch();

    public void requestSetAutomaticPinEntryActive(boolean var1);

    public void requestTelPower(int var1);

    public void requestUnlockSIM(int var1, String var2, String var3);

    public void requestCheckSIMPINCode(String var1);

    public void requestChangeSIMCode(int var1, String var2, String var3);

    public void requestSIMPINRequired(String var1, boolean var2);

    public void restoreFactorySettings();
}

