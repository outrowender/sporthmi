/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.networking.Profile;

public interface DSIWLAN
extends DSIBase {
    public static final String VERSION = "2.11.14";
    public static final int ATTR_ROLE = 1;
    public static final int ATTR_RFACTIVE = 12;
    public static final int ATTR_NODELIST = 13;
    public static final int ATTR_WLANENABLED = 17;
    public static final int ATTR_STARTUPSTATE = 18;
    public static final int ATTR_DISCOVEREDNETWORK = 19;
    public static final int ATTR_CONNECTEDNETWORK = 20;
    public static final int ATTR_TRUSTEDNETWORKS = 21;
    public static final int ATTR_PROFILE = 22;
    public static final int ATTR_WPSRUNNING = 23;
    public static final int ATTR_WPSSTOPPEDANDCONNECTING = 24;
    public static final int CRYPTOMODELS_CM_PLAINTEXT = 1;
    public static final int CRYPTOMODELS_CM_WEP64 = 2;
    public static final int CRYPTOMODELS_CM_WEP128 = 3;
    public static final int CRYPTOMODELS_CM_TKIP = 4;
    public static final int CRYPTOMODELS_CM_AES_CCMP = 5;
    public static final int CRYPTOMODELS_CM_WPA2_TKIP = 6;
    public static final int CRYPTOMODELS_CM_WPA2_AES_CCMP = 7;
    public static final int CRYPTOMODELS_CM_WPA_TKIP_CCMP = 8;
    public static final int CRYPTOMODELS_CM_WPA2_TKIP_CCMP = 9;
    public static final int CRYPTOMODELS_CM_WAPI = 10;
    public static final int AUTHENTICATIONMODELS_AM_NONE = 1;
    public static final int AUTHENTICATIONMODELS_AM_PSK = 2;
    public static final int AUTHENTICATIONMODELS_AM_EAP_802_1X = 3;
    public static final int ROLES_ROLE_AP = 1;
    public static final int ROLES_ROLE_CLIENT = 2;
    public static final int ROLES_ROLE_ADHOC = 3;
    public static final int ROLES_ROLE_AP_CLIENT_COMBINED = 4;
    public static final int RESULT_RESULT_OK = 0;
    public static final int RESULT_ERROR_NOT_SUPPORTED = 1;
    public static final int RESULT_ERROR_INVALID_PARAMETER = 2;
    public static final int RESULT_ERROR_REQUEST_TOO_EARLY = 3;
    public static final int RESULT_ERROR_INVALID_PASSWORD = 4;
    public static final int RESULT_RESULT_ABORTED = 5;
    public static final int RESULT_ERROR_GENERAL = 6;
    public static final int RESULT_RESULT_PASSWORD_REQUIRED = 7;
    public static final int RESULT_RESULT_TIMEOUT = 8;
    public static final int RESULT_ERROR_SECURITYISSUE = 9;
    public static final int ERRORS_OK = 0;
    public static final int ERRORS_ERROR_NOT_SUPPORTED = 1;
    public static final int ERRORS_ERROR_INVALID_PARAMETER = 2;
    public static final int ERRORS_ERROR_REQUEST_TOO_EARLY = 3;
    public static final int RFSTATES_RF_OFF = 0;
    public static final int RFSTATES_RF_ON = 1;
    public static final int RFSTATES_RF_NOT_OPERATIONAL = 2;
    public static final int RFSTATES_RF_NOT_OPERATIONAL_TEMPERATURE = 3;
    public static final int RFSTATES_RF_NOT_ALLOWED = 4;
    public static final int STARTUPSTATES_SUS_BOOTING = 1;
    public static final int STARTUPSTATES_SUS_READY = 2;
    public static final int STARTUPSTATES_SUS_FAILED = 3;
    public static final int WPSMODE_PUSHBUTTON = 1;
    public static final int WPSMODE_PIN = 2;
    public static final int RT_FACTORYRESET = 1000;
    public static final int RT_SETRFACTIVE = 1003;
    public static final int RT_SETPROFILE = 1004;
    public static final int RT_REQUESTNETWORKSEARCH = 1007;
    public static final int RT_REQUESTABORTSEARCH = 1008;
    public static final int RT_REQUESTCONNECTNETWORK = 1009;
    public static final int RT_REQUESTDISCONNECTNETWORK = 1010;
    public static final int RT_REQUESTDELETETRUSTEDNETWORK = 1011;
    public static final int RT_SETROLE = 1013;
    public static final int RT_REQUESTACTIVATEWPS = 1014;
    public static final int RT_REQUESTCANCELWPS = 1015;
    public static final int RP_RESPONSENETWORKSEARCH = 2007;
    public static final int RP_RESPONSEABORTSEARCH = 2008;
    public static final int RP_RESPONSECONNECTNETWORK = 2009;
    public static final int RP_RESPONSEDISCONNECTNETWORK = 2010;
    public static final int RP_RESPONSEDELETETRUSTEDNETWORK = 2011;
    public static final int RP_RESPONSEFACTORYRESET = 2012;
    public static final int RP_RESPONSESETROLE = 2013;
    public static final int RP_RESPONSESETRFACTIVE = 2014;
    public static final int RP_RESPONSESETPROFILE = 2015;
    public static final int RP_RESPONSEACTIVATEWPS = 2016;

    public void factoryReset();

    public void setRole(int var1);

    public void setRFActive(boolean var1);

    public void setProfile(Profile var1);

    public void requestNetworkSearch(int var1, int var2);

    public void requestAbortSearch();

    public void requestConnectNetwork(String var1, String var2, String var3, int var4);

    public void requestDisconnectNetwork(String var1, String var2);

    public void requestDeleteTrustedNetwork(String var1, String var2);

    public void requestActivateWps(int var1, int var2, int var3);

    public void requestCancelWPS();
}

