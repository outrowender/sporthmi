/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephone.CFRequestData;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.MailboxDialingNumber;

public interface DSITelephone
extends DSIBase {
    public static final String VERSION = "2.11.27";
    public static final int RT_ACCEPTCALL = 1000;
    public static final int RT_HANGUPCALL = 1001;
    public static final int RT_SWAPCALLS = 1002;
    public static final int RT_SPLITCALL = 1003;
    public static final int RT_JOINCALLS = 1004;
    public static final int RT_DIALNUMBER = 1005;
    public static final int RT_DIALNUMBERFROMDBENTRY = 1006;
    public static final int RT_SENDDTMF = 1007;
    public static final int RT_REQUESTNETWORKREGISTRATION = 1008;
    public static final int RT_REQUESTABORTNETWORKREGISTRATION = 1009;
    public static final int RT_REQUESTNETWORKSEARCH = 1010;
    public static final int RT_REQUESTABORTNETWORKSEARCH = 1011;
    public static final int RT_REQUESTCALLFORWARD = 1012;
    public static final int RT_REQUESTCALLWAITING = 1013;
    public static final int RT_REQUESTCLIR = 1014;
    public static final int RT_REQUESTSERVICECODEABORT = 1015;
    public static final int RT_REQUESTSETAUTOMATICPINENTRYACTIVE = 1016;
    public static final int RT_REQUESTSETAUTOMATICREDIALACTIVE = 1017;
    public static final int RT_REQUESTSETCDMATHREEWAYCALLINGSETTING = 1018;
    public static final int RT_REQUESTSETAUTOMATICEMERGENCYCALLACTIVE = 1019;
    public static final int RT_REQUESTSETENHANCEDPRIVACYMODE = 1020;
    public static final int RT_REQUESTSETMAILBOXCONTENT = 1021;
    public static final int RT_REQUESTSETPRIVACYMODE = 1022;
    public static final int RT_REQUESTTELPOWER = 1023;
    public static final int RT_REQUESTUNLOCKSIM = 1024;
    public static final int RT_REQUESTCHECKSIMPINCODE = 1025;
    public static final int RT_REQUESTCHANGESIMCODE = 1026;
    public static final int RT_REQUESTSETHANDSFREEMODE = 1027;
    public static final int RT_REQUESTSETMICMUTESTATE = 1028;
    public static final int RT_REQUESTSETLANGUAGE = 1029;
    public static final int RT_REQUESTSIMPINREQUIRED = 1030;
    public static final int RT_RESTOREFACTORYSETTINGS = 1031;
    public static final int RT_REQUESTUNLOCKOTHERSIM = 1032;
    public static final int RT_REQUESTSETSIMALIASES = 1033;
    public static final int RT_REQUESTSETMICGAINLEVEL = 1034;
    public static final int RT_REQUESTDECREASEMICGAINLEVEL = 1035;
    public static final int RT_REQUESTINCREASEMICGAINLEVEL = 1036;
    public static final int RT_REQUESTSETOPTIMIZATIONMODE = 1037;
    public static final int RT_REQUESTSETNADMODE = 1038;
    public static final int RT_REQUESTREMOVEOTHERSIM = 1039;
    public static final int RT_DIALOPERATOR = 1040;
    public static final int RT_REQUESTABORTALTERNATEPHONEACTIVITY = 1041;
    public static final int RT_REQUESTTOGGLEPRIORITIZEDPHONEDEVICE = 1042;
    public static final int RT_REQUESTSETPREFIXCONTENT = 1043;
    public static final int RT_REQUESTSETPHONEREMINDERSETTING = 1044;
    public static final int RT_REQUESTSETPREFIXACTIVATED = 1045;
    public static final int RT_REQUESTSETPHONERINGTONE = 1046;
    public static final int RT_REQUESTSETFAVORITES = 1047;
    public static final int RT_REQUESTSETSIMNAME = 1048;
    public static final int RT_REQUESTSETESIMACTIVE = 1049;
    public static final int ATTR_DTMFTONEPLAYING = 1;
    public static final int ATTR_EMERGENCYNUMBERS = 2;
    public static final int ATTR_SIMPINREQUIRED = 3;
    public static final int ATTR_ACTIVATIONSTATE = 4;
    public static final int ATTR_AUTOMATICPINENTRYACTIVE = 5;
    public static final int ATTR_AUTOMATICREDIALACTIVE = 6;
    public static final int ATTR_BATTERYCHARGELEVEL = 7;
    public static final int ATTR_CALLDURATIONLIST = 8;
    public static final int ATTR_CALLLIST = 9;
    public static final int ATTR_CDMATHREEWAYCALLINGSETTING = 10;
    public static final int ATTR_CRADLEPLUGINSTATE = 11;
    public static final int ATTR_DISCONNECTREASON = 12;
    public static final int ATTR_EMERGENCYCALLACTIVE = 13;
    public static final int ATTR_ENHANCEDPRIVACYMODE = 14;
    public static final int ATTR_HANDSFREEMODE = 15;
    public static final int ATTR_LOCKSTATE = 16;
    public static final int ATTR_MAILBOXCONTENT = 17;
    public static final int ATTR_MICMUTESTATE = 18;
    public static final int ATTR_NADTEMPERATURE = 19;
    public static final int ATTR_PHONEINFORMATION = 20;
    public static final int ATTR_NETWORKPROVIDER = 21;
    public static final int ATTR_NETWORKTYPE = 22;
    public static final int ATTR_PRIVACYMODE = 23;
    public static final int ATTR_REGISTERSTATE = 24;
    public static final int ATTR_SERVICECODETYPE = 25;
    public static final int ATTR_SERVICENUMBERS = 26;
    public static final int ATTR_SIGNALQUALITY = 27;
    public static final int ATTR_SUPPSERVICERESPONSE = 28;
    public static final int ATTR_SERVICEPROVIDER = 29;
    public static final int ATTR_SIMALIASINFORMATION = 30;
    public static final int ATTR_MICGAINLEVEL = 31;
    public static final int ATTR_OPTIMIZATIONMODE = 32;
    public static final int ATTR_NADMODE = 33;
    public static final int ATTR_OTHERSIMAVAILABLE = 34;
    public static final int ATTR_ALTERNATEPHONEACTIVITY = 35;
    public static final int ATTR_PREFIXCONTENT = 36;
    public static final int ATTR_PHONEREMINDERSETTING = 37;
    public static final int ATTR_ACTIVATIONSTATEASSOCIATED = 38;
    public static final int ATTR_PREFIXACTIVATED = 39;
    public static final int ATTR_WIDEBANDSPEECH = 40;
    public static final int ATTR_PHONERINGTONE = 41;
    public static final int ATTR_FAVORITES = 42;
    public static final int ATTR_SAPUPGRADEACTIVE = 43;
    public static final int ATTR_EUICCID = 44;
    public static final int ATTR_ESIMMSISDN = 45;
    public static final int ATTR_ESIMACTIVE = 46;
    public static final int ATTR_ESIMB2BMODE = 47;
    public static final int RP_RESPONSEABORTNETWORKREGISTRATION = 2000;
    public static final int RP_RESPONSEABORTNETWORKSEARCH = 2001;
    public static final int RP_RESPONSEACCEPTCALL = 2002;
    public static final int RP_RESPONSECALLFORWARD = 2003;
    public static final int RP_RESPONSECALLWAITING = 2004;
    public static final int RP_RESPONSECHANGESIMCODE = 2005;
    public static final int RP_RESPONSECLIR = 2006;
    public static final int RP_RESPONSEDIALNUMBER = 2007;
    public static final int RP_RESPONSESENDDTMF = 2008;
    public static final int RP_RESPONSESIMPINREQUIRED = 2009;
    public static final int RP_RESPONSEHANGUPCALL = 2010;
    public static final int RP_RESPONSEJOINCALLS = 2011;
    public static final int RP_RESPONSENETWORKREGISTRATION = 2012;
    public static final int RP_RESPONSENETWORKSEARCH = 2013;
    public static final int RP_RESPONSEUNLOCKSIM = 2014;
    public static final int RP_RESPONSECHECKSIMPINCODE = 2015;
    public static final int RP_RESPONSERESTOREFACTORYSETTINGS = 2016;
    public static final int RP_RESPONSESETHANDSFREEMODE = 2017;
    public static final int RP_RESPONSESETAUTOMATICPINENTRYACTIVE = 2018;
    public static final int RP_RESPONSESETAUTOMATICREDIALACTIVE = 2019;
    public static final int RP_RESPONSESERVICECODEABORT = 2020;
    public static final int RP_RESPONSESPLITCALL = 2021;
    public static final int RP_RESPONSESWAPCALLS = 2022;
    public static final int RP_RESPONSETELPOWER = 2023;
    public static final int RP_RESPONSESETCDMATHREEWAYCALLINGSETTING = 2024;
    public static final int RP_RESPONSESETAUTOMATICEMERGENCYCALLACTIVE = 2025;
    public static final int RP_RESPONSESETMAILBOXCONTENT = 2026;
    public static final int RP_RESPONSESETPRIVACYMODE = 2027;
    public static final int RP_RESPONSESETMICMUTESTATE = 2028;
    public static final int RP_RESPONSESETOPTIMIZATIONMODE = 2029;
    public static final int RP_RESPONSESETNADMODE = 2030;
    public static final int RP_RESPONSEUNLOCKOTHERSIM = 2031;
    public static final int RP_RESPONSESETSIMALIASES = 2032;
    public static final int RP_RESPONSEREMOVEOTHERSIM = 2033;
    public static final int RP_RESPONSEDIALOPERATOR = 2034;
    public static final int RP_RESPONSEABORTALTERNATEPHONEACTIVITY = 2035;
    public static final int RP_RESPONSETOGGLEPRIORITIZEDPHONEDEVICE = 2036;
    public static final int RP_RESPONSESETPREFIXCONTENT = 2037;
    public static final int RP_RESPONSESETPHONEREMINDERSETTING = 2038;
    public static final int RP_RESPONSESETPREFIXACTIVATED = 2039;
    public static final int RP_RESPONSESETPHONERINGTONE = 2040;
    public static final int RP_RESPONSESETFAVORITES = 2041;
    public static final int RP_RESPONSESETSIMNAME = 2042;
    public static final int RP_RESPONSESETESIMACTIVE = 2043;
    public static final int MEBATTERYCHARGELEVEL_UNKNOWN = 255;
    public static final int MEBATTERYCHARGELEVEL_0 = 0;
    public static final int MEBATTERYCHARGELEVEL_0_19 = 1;
    public static final int MEBATTERYCHARGELEVEL_20_39 = 2;
    public static final int MEBATTERYCHARGELEVEL_40_59 = 3;
    public static final int MEBATTERYCHARGELEVEL_60_79 = 4;
    public static final int MEBATTERYCHARGELEVEL_80_100 = 5;
    public static final int ACTIVATIONSTATE_INIT = 0;
    public static final int ACTIVATIONSTATE_NOT_ATTACHED = 1;
    public static final int ACTIVATIONSTATE_TEL_ACTIVE_CALL = 2;
    public static final int ACTIVATIONSTATE_PHONE_OFF = 4;
    public static final int ACTIVATIONSTATE_PHONE_ON = 5;
    public static final int ACTIVATIONSTATE_ATTACHED_NOT_READY = 7;
    public static final int ACTIVATIONSTATE_ATTACHED_NOT_FUNC = 9;
    public static final int ACTIVATIONSTATE_ME_RECONNECT = 12;
    public static final int TELMODE_INTERNAL_SIM = 0;
    public static final int TELMODE_SIMAP_BTHS = 1;
    public static final int TELMODE_EXTERNAL_SIMAP = 2;
    public static final int TELMODE_HFP = 3;
    public static final int TELMODE_NO_SIM_AVAILABLE = 4;
    public static final int TELFEAT_UNKNOWN = 0;
    public static final int TELFEAT_INBAND = 1;
    public static final int TELFEAT_REJECTCALL = 2;
    public static final int TELFEAT_RESPHOLD = 4;
    public static final int TELFEAT_THREEWAY = 8;
    public static final int TELFEAT_ENHCALL = 16;
    public static final int TELFEAT_ENHSTAT = 32;
    public static final int TELFEAT_ADD_TO_CONFERENCE = 64;
    public static final int TELFEAT_ENHCONFERENCE_TRANSFER = 128;
    public static final int TELFEAT_REJECTMOBILE = 256;
    public static final int TELDEVICE_HMI = 0;
    public static final int TELDEVICE_BTHS1 = 1;
    public static final int TELDEVICE_BTHS2 = 2;
    public static final int PHONEMODULESTATE_N_A = 0;
    public static final int PHONEMODULESTATE_OFF_TEMP = 1;
    public static final int PHONEMODULESTATE_ON = 2;
    public static final int PHONEMODULESTATE_OFF = 3;
    public static final int PHONEMODULESTATE_OFF_DIAG = 4;
    public static final int PHONEMODULESTATE_NOT_FUNCTION = 5;
    public static final int PHONEMODULESTATE_INIT = 6;
    public static final int PHONEMODULESTATE_SWITCHING_ON = 7;
    public static final int PHONEMODULESTATE_SWITCHING_OFF = 8;
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
    public static final int NUMTYPE_NOINT = 129;
    public static final int NUMTYPE_INT = 145;
    public static final int ACCEPTMODE_SINGLE = 0;
    public static final int ACCEPTMODE_REPLACE = 1;
    public static final int ACCEPTMODE_HOLD = 2;
    public static final int ACCEPTMODE_RESPONSE_HOLD = 3;
    public static final int HANGUPMODE_REJECT = 0;
    public static final int HANGUPMODE_CONFERENCE = 254;
    public static final int HANGUPMODE_ALLCALLS = 255;
    public static final int DISCREASON_NORMAL = 0;
    public static final int DISCREASON_NOLINE = 1;
    public static final int DISCREASON_SYSTEM_BUSY = 2;
    public static final int DISCREASON_NUMBER_BUSY = 3;
    public static final int DISCREASON_NUMBER_NOT_ASSIGNED = 4;
    public static final int DISCREASON_NUMBER_NOT_REACHABLE = 5;
    public static final int DISCREASON_NETWORK_FAILURE = 6;
    public static final int DISCREASON_CALL_BARRING_ACTIVE = 7;
    public static final int DISCREASON_USER_NOT_RESPONDING = 8;
    public static final int DISCREASON_CALL_REJECTED = 9;
    public static final int DISCREASON_NUMBER_CHANGED = 10;
    public static final int DISCREASON_NUMBER_INVALID_INCOMPLETE = 11;
    public static final int DISCREASON_SERVICE_NOT_AVAILABLE = 12;
    public static final int DISCREASON_NO_INFO_AVAILABLE = 13;
    public static final int DISCREASON_NUMBER_TEMP_FORBIDDEN = 14;
    public static final int HANDSFREEMODE_HANDSFREE = 0;
    public static final int HANDSFREEMODE_PRIVATE_BTHS1 = 1;
    public static final int HANDSFREEMODE_PRIVATE_BTHS2 = 2;
    public static final int HANDSFREEMODE_PRIVATE_HS = 3;
    public static final int HANDSFREEMODE_PRIVATE_HFP = 4;
    public static final int MICMUTESTATE_ON = 0;
    public static final int MICMUTESTATE_OFF = 1;
    public static final int LOCKCODE_PIN = 0;
    public static final int LOCKCODE_PIN2 = 1;
    public static final int LOCKCODE_PUK = 2;
    public static final int LOCKCODE_PUK2 = 3;
    public static final int LOCKCODE_SECCO = 4;
    public static final int COMMCLASS_VOICE = 1;
    public static final int COMMCLASS_DATA = 2;
    public static final int COMMCLASS_FAX = 4;
    public static final int COMMCLASS_SMS = 8;
    public static final int COMMCLASS_DCS = 16;
    public static final int COMMCLASS_DCA = 32;
    public static final int COMMCLASS_DDPA = 64;
    public static final int COMMCLASS_DDPADA = 128;
    public static final int COMMCLASS_UNCONDITIONAL = 255;
    public static final int CWMODE_DISABLE = 0;
    public static final int CWMODE_ENABLE = 1;
    public static final int CWMODE_QUERY = 2;
    public static final int CLIRSTATE_PRESENTATION = 0;
    public static final int CLIRSTATE_INVOCATION = 1;
    public static final int CLIRSTATE_SUPPRESSION = 2;
    public static final int CLIRSTATE_QUERY = 3;
    public static final int CLIRNWSTATE_OFF = 0;
    public static final int CLIRNWSTATE_ON = 1;
    public static final int CLIRNWSTATE_UNKNOWN = 2;
    public static final int CLIRNWSTATE_RESTRICTED = 3;
    public static final int CLIRNWSTATE_ALLOWED = 4;
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
    public static final int RESULT_ERROR_PIN_IDENTICAL_PROFILE_NOT_CHANGED = 16;
    public static final int RESULT_ERROR_VOICE_NOT_POSSIBLE_CARPLAY_ACTIVE = 17;
    public static final int RESULT_ERROR_VOICE_NOT_POSSIBLE_ANDROID_AUTO_ACTIVE = 18;
    public static final int CALLSTATE_DIALING = 1;
    public static final int CALLSTATE_ALERTING = 2;
    public static final int CALLSTATE_RINGING = 3;
    public static final int CALLSTATE_ACTIVE = 4;
    public static final int CALLSTATE_DISCONNECTING = 5;
    public static final int CALLSTATE_HOLD = 6;
    public static final int CALLSTATE_AUTOREDIAL = 7;
    public static final int CALLSTATE_RESP_HOLD = 8;
    public static final int MPTY_SINGLE = 0;
    public static final int MPTY_CONFERENCE = 1;
    public static final int CALLCARRIER_NONE = 0;
    public static final int CALLCARRIER_PRIO = 1;
    public static final int CALLCARRIER_ASSOCIATED = 2;
    public static final int CALLTYPE_VOICE = 0;
    public static final int CALLTYPE_DATA = 1;
    public static final int CALLTYPE_FAX = 2;
    public static final int CALLTYPE_EMERGENCY = 3;
    public static final int CALLTYPE_CONFERENCE = 4;
    public static final int CALLTYPE_INFO = 5;
    public static final int CALLTYPE_BREAKDOWN = 6;
    public static final int CALLTYPE_OPERATOR = 7;
    public static final int CALLTYPE_MAILBOX = 8;
    public static final int CALLTYPE_NO_NUMBER = 9;
    public static final int PROVIDERSTATE_UNKNOWN = 0;
    public static final int PROVIDERSTATE_SELECTED = 1;
    public static final int PROVIDERSTATE_FORBIDDEN = 2;
    public static final int PROVIDERSTATE_AVAILABLE = 3;
    public static final int CWSTATE_NOT_ACTIVE = 0;
    public static final int CWSTATE_ACTIVE = 1;
    public static final int CFMODE_DISABLE = 0;
    public static final int CFMODE_ENABLE = 1;
    public static final int CFMODE_QUERY = 2;
    public static final int CFMODE_REGISTRATION = 3;
    public static final int CFMODE_ERASURE = 4;
    public static final int CFMODE_UNKNOWN = 5;
    public static final int CFCONDITION_UNCONDITIONAL = 0;
    public static final int CFCONDITION_MOBILE_BUSY = 1;
    public static final int CFCONDITION_NO_REPLY = 2;
    public static final int CFCONDITION_NOT_REACHABLE = 3;
    public static final int CFCONDITION_ALL_CFWD = 4;
    public static final int CFCONDITION_ALL_CCFWD = 5;
    public static final int CFSTATE_NOT_ACTIVE = 0;
    public static final int CFSTATE_ACTIVE = 1;
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
    public static final int DIALNUMTYPE_NORMALCALL = 0;
    public static final int DIALNUMTYPE_USSD = 1;
    public static final int DIALNUMTYPE_SSD = 2;
    public static final int SERVICECODEREQTYPE_UNKNOWN = 0;
    public static final int SERVICECODEREQTYPE_ACTIVATION = 1;
    public static final int SERVICECODEREQTYPE_DEACTIVATION = 2;
    public static final int SERVICECODEREQTYPE_INTERROGATION = 3;
    public static final int SERVICECODEREQTYPE_REGISTRATION = 4;
    public static final int SERVICECODEREQTYPE_ERASURE = 5;
    public static final int CRADLEPLUGINSTATE_NOTBUILTIN = 0;
    public static final int CRADLEPLUGINSTATE_UNPLUGGED = 1;
    public static final int CRADLEPLUGINSTATE_PLUGGED = 2;
    public static final int CALLLISTNAMENUMBERSTATUS_VALID = 0;
    public static final int CALLLISTNAMENUMBERSTATUS_TEMPINVALID = 1;
    public static final int MBIDENTIFIERS_VOICE = 1;
    public static final int MBIDENTIFIERS_FAX = 2;
    public static final int MBIDENTIFIERS_EMAIL = 3;
    public static final int MBIDENTIFIERS_OTHERS = 4;
    public static final int OPTIMIZATIONMODE_INVALID = 0;
    public static final int OPTIMIZATIONMODE_AUTO = 1;
    public static final int OPTIMIZATIONMODE_TELEPHONE = 2;
    public static final int OPTIMIZATIONMODE_DATA = 3;
    public static final int NADMODE_INVALID = 0;
    public static final int NADMODE_VOICE_DATA = 1;
    public static final int NADMODE_DATA = 2;
    public static final int NADMODE_VOICE = 3;

    public void acceptCall(int var1);

    public void hangupCall(int var1);

    public void swapCalls();

    public void splitCall(short var1);

    public void joinCalls();

    public void dialNumber(String var1);

    public void dialOperator(int var1, String var2);

    public void dialNumberFromDBEntry(String var1, long var2, String var4, short var5, short var6, ResourceLocator var7, int var8, int var9);

    public void sendDTMF(String var1);

    public void requestNetworkRegistration(String var1, int var2);

    public void requestAbortNetworkRegistration();

    public void requestNetworkSearch();

    public void requestAbortNetworkSearch();

    public void requestCallForward(CFRequestData[] var1);

    public void requestCallWaiting(int var1);

    public void requestCLIR(int var1);

    public void requestServiceCodeAbort();

    public void requestSetAutomaticPinEntryActive(boolean var1);

    public void requestSetAutomaticRedialActive(boolean var1);

    public void requestSetCDMAThreeWayCallingSetting(boolean var1);

    public void requestSetAutomaticEmergencyCallActive(boolean var1);

    public void requestSetEnhancedPrivacyMode(boolean var1);

    public void requestSetMailboxContent(MailboxDialingNumber[] var1);

    public void requestSetPrivacyMode(boolean var1);

    public void requestTelPower(int var1);

    public void requestUnlockSIM(int var1, String var2, String var3);

    public void requestCheckSIMPINCode(String var1);

    public void requestChangeSIMCode(int var1, String var2, String var3);

    public void requestSetHandsFreeMode(int var1);

    public void requestSetMICMuteState(int var1);

    public void requestSetLanguage(String var1);

    public void requestSIMPINRequired(String var1, boolean var2);

    public void restoreFactorySettings();

    public void requestSetMicGainLevel(int var1);

    public void requestDecreaseMicGainLevel(short var1);

    public void requestIncreaseMicGainLevel(short var1);

    public void requestSetOptimizationMode(int var1);

    public void requestUnlockOtherSIM(int var1, String var2);

    public void requestSetSIMAliases(String var1, String var2);

    public void requestSetNADMode(int var1);

    public void requestRemoveOtherSIM();

    public void requestAbortAlternatePhoneActivity();

    public void requestTogglePrioritizedPhoneDevice();

    public void requestSetPhoneReminderSetting(boolean var1);

    public void requestSetPrefixActivated(boolean var1);

    public void requestSetPrefixContent(String var1);

    public void requestSetPhoneRingtone(int var1, String var2);

    public void requestSetFavorites(Favorite[] var1);

    public void requestSetSIMName(String var1);

    public void requestSetESIMActive(boolean var1);
}

