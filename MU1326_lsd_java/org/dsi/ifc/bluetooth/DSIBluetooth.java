/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIBase;

public interface DSIBluetooth
extends DSIBase {
    public static final String VERSION = "2.11.13";
    public static final int ATTR_ACCESSIBLEMODE = 1;
    public static final int ATTR_BTSTATE = 3;
    public static final int ATTR_DISCOVEREDDEVICES = 4;
    public static final int ATTR_TRUSTEDDEVICES = 6;
    public static final int ATTR_PASSKEYSTATE = 7;
    public static final int ATTR_SERVICEREQUESTSTATE = 8;
    public static final int ATTR_USERFRIENDLYNAME = 9;
    public static final int ATTR_RECONNECTINDICATOR = 10;
    public static final int ATTR_INCOMINGSERVICEREQUEST = 11;
    public static final int ATTR_SUPPORTEDBTPROFILES = 12;
    public static final int ATTR_MASTERROLEREQUESTERROR = 14;
    public static final int ATTR_HUCANDBTHSSTATE = 15;
    public static final int ATTR_A2DPUSERSETTING = 16;
    public static final int ATTR_PRIORIZEDDEVICERECONNECT = 17;
    public static final int RT_SETACCESSIBLEMODE = 1000;
    public static final int RT_REQUESTCONNECTSERVICE = 1001;
    public static final int RT_REQUESTCONNECTSERVICETOINSTANCE = 1002;
    public static final int RT_ABORTCONNECTSERVICE = 1003;
    public static final int RT_REQUESTDISCONNECTSERVICE = 1004;
    public static final int RT_REQUESTGETSERVICES = 1005;
    public static final int RT_REQUESTINQUIRY = 1006;
    public static final int RT_ABORTINQUIRY = 1007;
    public static final int RT_REQUESTRECONNECTSUSPEND = 1008;
    public static final int RT_REQUESTPASSKEYRESPONSE = 1009;
    public static final int RT_REQUESTREMOVEAUTHENTICATION = 1010;
    public static final int RT_SETUSERFRIENDLYNAME = 1011;
    public static final int RT_REQUESTSWITCHBTSTATE = 1012;
    public static final int RT_REQUESTRESTOREFACTORYSETTINGS = 1014;
    public static final int RT_REQUESTACCEPTINCOMINGSERVICEREQUEST = 1015;
    public static final int RT_REQUESTSETA2DPUSERSETTING = 1016;
    public static final int RT_REQUESTSETPRIORIZEDDEVICERECONNECT = 1017;
    public static final int RP_RESPONSECONNECTSERVICE = 2000;
    public static final int RP_RESPONSECONNECTSERVICETOINSTANCE = 2001;
    public static final int RP_RESPONSEABORTCONNECTSERVICE = 2002;
    public static final int RP_RESPONSEDISCONNECTSERVICE = 2003;
    public static final int RP_RESPONSEGETSERVICES = 2004;
    public static final int RP_RESPONSEINQUIRY = 2005;
    public static final int RP_RESPONSEABORTINQUIRY = 2006;
    public static final int RP_RESPONSERECONNECTSUSPEND = 2007;
    public static final int RP_RESPONSEPASSKEYRESPONSE = 2008;
    public static final int RP_RESPONSEREMOVEAUTHENTICATION = 2009;
    public static final int RP_RESPONSESWITCHBTSTATE = 2010;
    public static final int RP_RESPONSERESTOREFACTORYSETTINGS = 2012;
    public static final int RP_RESPONSEACCEPTINCOMINGSERVICEREQUEST = 2013;
    public static final int RP_RESPONSESETA2DPUSERSETTING = 2014;
    public static final int RP_RESPONSESETPRIORIZEDDEVICERECONNECT = 2015;
    public static final int RP_RESPONSESETACCESSIBLEMODE = 2016;
    public static final int IN_REMOVEAUTHENTICATIONNOSUPPORT = 3000;
    public static final int IN_DEVICEDISONNECTIONINFO = 3001;
    public static final int IN_SERVICEREJECTNOSUPPORT = 3002;
    public static final int AM_UNSPECIFIED = 0;
    public static final int AM_NOT_ACCESSIBLE = 1;
    public static final int AM_DISCOVERABLE_ONLY = 2;
    public static final int AM_CONNECTABLE_ONLY = 3;
    public static final int AM_GENERAL_ACCESSIBLE = 4;
    public static final int AM_AUTO_DISCOVERABLE_FULL_ACCESSIBLE = 5;
    public static final int AM_LIMITED_DISCOVERABLE = 6;
    public static final int AUTHENTICATION_REJECT = 0;
    public static final int AUTHENTICATION_ACCEPT = 1;
    public static final int BTSTATE_ON = 0;
    public static final int BTSTATE_OFF = 1;
    public static final int BTSTATE_NOT_FUNCTIONAL = 2;
    public static final int BTSTATE_SWITCHING_ON = 3;
    public static final int BTSTATE_SWITCHING_OFF = 4;
    public static final int BTSTATE_DIAGNOSE_NOT_ON_ALLOWED = 5;
    public static final int CONNECTION_REJECT = 0;
    public static final int CONNECTION_ACCEPT = 1;
    public static final int DEVICEROLE_NONE = 0;
    public static final int DEVICEROLE_PRIO = 1;
    public static final int DEVICEROLE_ASSOCIATED = 2;
    public static final int DEVICEROLE_PIM = 3;
    public static final int RESULT_OK = 0;
    public static final int RESULT_INTERMEDIATE = 1;
    public static final int RESULT_ABORTED = 2;
    public static final int RESULT_ERROR_GENERAL = 3;
    public static final int RESULT_ERROR_PAIRING_GENERAL = 4;
    public static final int RESULT_ERROR_PAIRING_TIMEOUT = 5;
    public static final int RESULT_ERROR_PAIRING_WRONG_PASSKEY = 6;
    public static final int RESULT_ERROR_SERVICE_NOT_SUPPORTED = 7;
    public static final int RESULT_ERROR_PAGE_TIMEOUT = 8;
    public static final int RESULT_ERROR_INSTANCE_NOT_EXIST = 9;
    public static final int RESULT_ERROR_INSTANCE_ALREADY_CONNECTED = 10;
    public static final int RESULT_ERROR_DEVICE_NOT_TRUSTED = 11;
    public static final int RESULT_ERROR_HW_FAILURE = 12;
    public static final int RESULT_ERROR_CONNECTION_LIMIT_EXCEEDED = 13;
    public static final int RESULT_ERROR_CONNECTION_REJECTED_SECURITY_REASONS = 14;
    public static final int RESULT_ERROR_REMOTE_USER_TERMINATED_CONNECTION_LOW_RESOURCES = 15;
    public static final int RESULT_ERROR_REMOTE_USER_TERMINATED_CONNECTION_POWER_OFF = 16;
    public static final int RESULT_ERROR_NOT_APPLICABLE = 17;
    public static final int RESULT_ERROR_SERVICE_REJECTED = 18;
    public static final int RESULT_ERROR_SERVICE_CONNECT_TIMEOUT = 19;
    public static final int RESULT_ERROR_SIM_INSERTED = 20;
    public static final int RESULT_ERROR_2ND_PHONE_NOT_POSSIBLE_WITH_SAP = 21;
    public static final int RESULT_ERROR_CARPLAY_ACTIVE = 22;
    public static final int RESULT_ERROR_ANDROID_AUTO_ACTIVE = 23;
    public static final int HUCANDBTHSSTATE_HBSTATE_0_HUC_0_BTHS = 0;
    public static final int HUCANDBTHSSTATE_HBSTATE_1_HUC_0_BTHS = 1;
    public static final int HUCANDBTHSSTATE_HBSTATE_1_HUC_1_BTHS = 2;
    public static final int HUCANDBTHSSTATE_HBSTATE_2_HUC_0_BTHS = 3;
    public static final int HUCANDBTHSSTATE_HBSTATE_2_HUC_1_BTHS = 4;
    public static final int HUCANDBTHSSTATE_HBSTATE_2_HUC_2_BTHS = 5;
    public static final int IM_UNSPECIFIED = 0;
    public static final int IM_DEVICE_DISCOVERY_ONLY = 1;
    public static final int IM_INCL_NAME_DISCOVERY = 2;
    public static final int IM_INCL_SERVICE_DISCOVERY = 3;
    public static final int IM_INCL_NAME_AND_SERVICE_DISCOVERY = 4;
    public static final int INSTANCENUMBER_NOT_AVAILABLE = 0;
    public static final int INSTANCENUMBER_1 = 1;
    public static final int INSTANCENUMBER_2 = 2;
    public static final int INSTANCENUMBER_3 = 3;
    public static final int LINKMODE_UNSPECIFIED = 0;
    public static final int LINKMODE_ACTIVE = 1;
    public static final int LINKMODE_HOLD = 2;
    public static final int LINKMODE_SNIFF = 3;
    public static final int LINKMODE_PARK = 4;
    public static final int LS_UNDEFINED = 0;
    public static final int LS_WEAK_KEY = 1;
    public static final int LS_STRONG_KEY = 2;
    public static final int LS_SIMPLE_PAIRING_UNAUTHENTICATED = 3;
    public static final int LS_SIMPLE_PAIRING_AUTHENTICATED = 4;
    public static final int PS_NO_PASSKEY_REQUIRED = 0;
    public static final int PS_WAITING_FOR_PASSKEY = 1;
    public static final int PS_DISPLAY_PASSKEY = 2;
    public static final int PS_PASSKEY_ERROR = 3;
    public static final int PS_PASSKEY_ERROR_WRONG_PIN = 4;
    public static final int PS_PASSKEY_ERROR_TIMEOUT = 5;
    public static final int PS_SSP_SHOW_ONLY = 6;
    public static final int PS_SSP_SHOW_AND_CONFIRM = 7;
    public static final int PS_SSP_JUST_WORKS = 8;
    public static final int SERVICEREQUESTSTATE_NOT_ACTIVE = 0;
    public static final int SERVICEREQUESTSTATE_ACTIVE = 1;
    public static final int SERVICETYPE_NONE = 0;
    public static final int SERVICETYPE_UNSPECIFIED = 1;
    public static final int SERVICETYPE_TELEPHONY_HFP = 2;
    public static final int SERVICETYPE_TELEPHONY_SIMAP = 4;
    public static final int SERVICETYPE_TELEPHONY_HEADSET = 8;
    public static final int SERVICETYPE_TELEPHONY_HANDSET = 16;
    public static final int SERVICETYPE_ADRDL = 32;
    public static final int SERVICETYPE_OBJECTPUSH_CLIENT = 64;
    public static final int SERVICETYPE_SYNCML = 128;
    public static final int SERVICETYPE_DUN_CLIENT = 256;
    public static final int SERVICETYPE_DUN_SERVER = 512;
    public static final int SERVICETYPE_HID = 1024;
    public static final int SERVICETYPE_BIP = 2048;
    public static final int SERVICETYPE_FTP = 4096;
    public static final int SERVICETYPE_OBJECTPUSH_SERVER = 8192;
    public static final int SERVICETYPE_SPP = 16384;
    public static final int SERVICETYPE_A2DP_AVRCP_SINK = 32768;
    public static final int SERVICETYPE_A2DP_AVRCP_SOURCE = 65536;
    public static final int SERVICETYPE_TELEPHONY_HFP_HF = 131072;
    public static final int SERVICETYPE_PAN_NAP = 262144;
    public static final int SERVICETYPE_PAN_GN = 524288;
    public static final int SERVICETYPE_PAN_USER = 0x100000;
    public static final int SERVICETYPE_MAP = 0x200000;
    public static final int SERVICETYPE_MAP2 = 0x400000;
    public static final int SERVICETYPE_ALL = -1;
    public static final int DEVICESECURITY_PAIRED = 0;
    public static final int DEVICESECURITY_TRUSTED = 2;
    public static final int DEVICESECURITY_ENCRYPTED = 4;
    public static final int DEVICESECURITY_STRONG_PASSKEY = 8;
    public static final int DISCONNECTINFORMATION_OTHER_REASON = 0;
    public static final int DISCONNECTINFORMATION_LINK_LOSS = 1;
    public static final int DISCONNECTINFORMATION_USER_INIT_VIA_EXT_DEVICE = 2;

    public void abortConnectService(String var1);

    public void abortInquiry();

    public void requestAcceptIncomingServiceRequest(String var1, int var2, boolean var3);

    public void requestConnectService(String var1, int var2, int var3);

    public void requestConnectServiceToInstance(String var1, int var2, int var3);

    public void requestDisconnectService(String var1, int var2);

    public void requestGetServices(String var1);

    public void requestInquiry(int var1, int var2, int var3);

    public void requestPasskeyResponse(String var1, String var2, int var3);

    public void requestReconnectSuspend(boolean var1);

    public void requestRemoveAuthentication(String var1);

    public void requestRestoreFactorySettings();

    public void requestSetA2DPUserSetting(boolean var1);

    public void requestSwitchBTState(int var1);

    public void setAccessibleMode(int var1);

    public void setUserFriendlyName(String var1);

    public void requestSetPriorizedDeviceReconnect(boolean var1, String var2);
}

