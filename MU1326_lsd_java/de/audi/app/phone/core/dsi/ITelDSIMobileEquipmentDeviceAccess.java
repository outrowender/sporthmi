/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.ITelComponent;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CFRequestData;

public interface ITelDSIMobileEquipmentDeviceAccess
extends ITelComponent {
    public static final int ROLE_UNKNOWN = -65536;
    public static final int ROLE_PRIMARY = 65536;
    public static final int ROLE_ASSOCIATED = 131072;
    public static final int ROLE_DATA = 196608;
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
    public static final int RT_REQUESTSETPREFIXCONTENT = 1041;
    public static final int RT_REQUESTSETPHONEREMINDERSETTING = 1042;
    public static final int RT_REQUESTSETPREFIXACTIVATED = 1043;
    public static final int RT_REQUESTSETPHONERINGTONE = 1044;
    public static final int RT_REQUESTSETFAVORITES = 1045;
    public static final int RT_REQUESTSETSIMNAME = 1046;
    public static final int RT_REQUESTSETESIMACTIVE = 1047;
    public static final int RT_DELETECALLSTACKSALL = 1048;
    public static final int RT_DELETECALLSTACKSENTRY = 1049;
    public static final int RT_RESETMISSEDCALLINDICATOR = 1050;
    public static final int RT_REVERTCALLSTACKS = 1051;
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
    public static final int ATTR_PREFIXCONTENT = 35;
    public static final int ATTR_PHONEREMINDERSETTING = 36;
    public static final int ATTR_PREFIXACTIVATED = 37;
    public static final int ATTR_WIDEBANDSPEECH = 38;
    public static final int ATTR_PHONERINGTONE = 39;
    public static final int ATTR_FAVORITES = 40;
    public static final int ATTR_SAPUPGRADEACTIVE = 41;
    public static final int ATTR_EUICCID = 42;
    public static final int ATTR_ESIMMSISDN = 43;
    public static final int ATTR_ESIMACTIVE = 44;
    public static final int ATTR_ESIMB2BMODE = 45;
    public static final int ATTR_CALLSTACKSISREVERTED = 46;
    public static final int ATTR_LASTANSWEREDNUMBERS = 47;
    public static final int ATTR_LASTDIALEDNUMBERS = 48;
    public static final int ATTR_MISSEDNUMBERS = 49;
    public static final int ATTR_MEDATAVALIDITY = 50;
    public static final int ATTR_MISSEDCALLINDICATOR = 51;
    public static final int ATTR_PRIMARY_DTMFTONEPLAYING = 65537;
    public static final int ATTR_PRIMARY_EMERGENCYNUMBERS = 65538;
    public static final int ATTR_PRIMARY_SIMPINREQUIRED = 65539;
    public static final int ATTR_PRIMARY_ACTIVATIONSTATE = 65540;
    public static final int ATTR_PRIMARY_AUTOMATICPINENTRYACTIVE = 65541;
    public static final int ATTR_PRIMARY_AUTOMATICREDIALACTIVE = 65542;
    public static final int ATTR_PRIMARY_BATTERYCHARGELEVEL = 65543;
    public static final int ATTR_PRIMARY_CALLDURATIONLIST = 65544;
    public static final int ATTR_PRIMARY_CALLLIST = 65545;
    public static final int ATTR_PRIMARY_CDMATHREEWAYCALLINGSETTING = 65546;
    public static final int ATTR_PRIMARY_CRADLEPLUGINSTATE = 65547;
    public static final int ATTR_PRIMARY_DISCONNECTREASON = 65548;
    public static final int ATTR_PRIMARY_EMERGENCYCALLACTIVE = 65549;
    public static final int ATTR_PRIMARY_ENHANCEDPRIVACYMODE = 65550;
    public static final int ATTR_PRIMARY_HANDSFREEMODE = 65551;
    public static final int ATTR_PRIMARY_LOCKSTATE = 65552;
    public static final int ATTR_PRIMARY_MAILBOXCONTENT = 65553;
    public static final int ATTR_PRIMARY_MICMUTESTATE = 65554;
    public static final int ATTR_PRIMARY_NADTEMPERATURE = 65555;
    public static final int ATTR_PRIMARY_PHONEINFORMATION = 65556;
    public static final int ATTR_PRIMARY_NETWORKPROVIDER = 65557;
    public static final int ATTR_PRIMARY_NETWORKTYPE = 65558;
    public static final int ATTR_PRIMARY_PRIVACYMODE = 65559;
    public static final int ATTR_PRIMARY_REGISTERSTATE = 65560;
    public static final int ATTR_PRIMARY_SERVICECODETYPE = 65561;
    public static final int ATTR_PRIMARY_SERVICENUMBERS = 65562;
    public static final int ATTR_PRIMARY_SIGNALQUALITY = 65563;
    public static final int ATTR_PRIMARY_SUPPSERVICERESPONSE = 65564;
    public static final int ATTR_PRIMARY_SERVICEPROVIDER = 65565;
    public static final int ATTR_PRIMARY_SIMALIASINFORMATION = 65566;
    public static final int ATTR_PRIMARY_MICGAINLEVEL = 65567;
    public static final int ATTR_PRIMARY_OPTIMIZATIONMODE = 65568;
    public static final int ATTR_PRIMARY_NADMODE = 65569;
    public static final int ATTR_PRIMARY_OTHERSIMAVAILABLE = 65570;
    public static final int ATTR_PRIMARY_PREFIXCONTENT = 65571;
    public static final int ATTR_PRIMARY_PHONEREMINDERSETTING = 65572;
    public static final int ATTR_PRIMARY_PREFIXACTIVATED = 65573;
    public static final int ATTR_PRIMARY_WIDEBANDSPEECH = 65574;
    public static final int ATTR_PRIMARY_PHONERINGTONE = 65575;
    public static final int ATTR_PRIMARY_FAVORITES = 65576;
    public static final int ATTR_PRIMARY_SAPUPGRADEACTIVE = 65577;
    public static final int ATTR_PRIMARY_EUICCID = 65578;
    public static final int ATTR_PRIMARY_ESIMMSISDN = 65579;
    public static final int ATTR_PRIMARY_ESIMACTIVE = 65580;
    public static final int ATTR_PRIMARY_ESIMB2BMODE = 65581;
    public static final int ATTR_PRIMARY_CALLSTACKSISREVERTED = 65582;
    public static final int ATTR_PRIMARY_LASTANSWEREDNUMBERS = 65583;
    public static final int ATTR_PRIMARY_LASTDIALEDNUMBERS = 65584;
    public static final int ATTR_PRIMARY_MISSEDNUMBERS = 65585;
    public static final int ATTR_PRIMARY_MEDATAVALIDITY = 65586;
    public static final int ATTR_PRIMARY_MISSEDCALLINDICATOR = 65587;
    public static final int ATTR_ASSOCIATED_DTMFTONEPLAYING = 131073;
    public static final int ATTR_ASSOCIATED_EMERGENCYNUMBERS = 131074;
    public static final int ATTR_ASSOCIATED_SIMPINREQUIRED = 131075;
    public static final int ATTR_ASSOCIATED_ACTIVATIONSTATE = 131076;
    public static final int ATTR_ASSOCIATED_AUTOMATICPINENTRYACTIVE = 131077;
    public static final int ATTR_ASSOCIATED_AUTOMATICREDIALACTIVE = 131078;
    public static final int ATTR_ASSOCIATED_BATTERYCHARGELEVEL = 131079;
    public static final int ATTR_ASSOCIATED_CALLDURATIONLIST = 131080;
    public static final int ATTR_ASSOCIATED_CALLLIST = 131081;
    public static final int ATTR_ASSOCIATED_CDMATHREEWAYCALLINGSETTING = 131082;
    public static final int ATTR_ASSOCIATED_CRADLEPLUGINSTATE = 131083;
    public static final int ATTR_ASSOCIATED_DISCONNECTREASON = 131084;
    public static final int ATTR_ASSOCIATED_EMERGENCYCALLACTIVE = 131085;
    public static final int ATTR_ASSOCIATED_ENHANCEDPRIVACYMODE = 131086;
    public static final int ATTR_ASSOCIATED_HANDSFREEMODE = 131087;
    public static final int ATTR_ASSOCIATED_LOCKSTATE = 131088;
    public static final int ATTR_ASSOCIATED_MAILBOXCONTENT = 131089;
    public static final int ATTR_ASSOCIATED_MICMUTESTATE = 131090;
    public static final int ATTR_ASSOCIATED_NADTEMPERATURE = 131091;
    public static final int ATTR_ASSOCIATED_PHONEINFORMATION = 131092;
    public static final int ATTR_ASSOCIATED_NETWORKPROVIDER = 131093;
    public static final int ATTR_ASSOCIATED_NETWORKTYPE = 131094;
    public static final int ATTR_ASSOCIATED_PRIVACYMODE = 131095;
    public static final int ATTR_ASSOCIATED_REGISTERSTATE = 131096;
    public static final int ATTR_ASSOCIATED_SERVICECODETYPE = 131097;
    public static final int ATTR_ASSOCIATED_SERVICENUMBERS = 131098;
    public static final int ATTR_ASSOCIATED_SIGNALQUALITY = 131099;
    public static final int ATTR_ASSOCIATED_SUPPSERVICERESPONSE = 131100;
    public static final int ATTR_ASSOCIATED_SERVICEPROVIDER = 131101;
    public static final int ATTR_ASSOCIATED_SIMALIASINFORMATION = 131102;
    public static final int ATTR_ASSOCIATED_MICGAINLEVEL = 131103;
    public static final int ATTR_ASSOCIATED_OPTIMIZATIONMODE = 131104;
    public static final int ATTR_ASSOCIATED_NADMODE = 131105;
    public static final int ATTR_ASSOCIATED_OTHERSIMAVAILABLE = 131106;
    public static final int ATTR_ASSOCIATED_PREFIXCONTENT = 131107;
    public static final int ATTR_ASSOCIATED_PHONEREMINDERSETTING = 131108;
    public static final int ATTR_ASSOCIATED_PREFIXACTIVATED = 131109;
    public static final int ATTR_ASSOCIATED_WIDEBANDSPEECH = 131110;
    public static final int ATTR_ASSOCIATED_PHONERINGTONE = 131111;
    public static final int ATTR_ASSOCIATED_FAVORITES = 131112;
    public static final int ATTR_ASSOCIATED_SAPUPGRADEACTIVE = 131113;
    public static final int ATTR_ASSOCIATED_EUICCID = 131114;
    public static final int ATTR_ASSOCIATED_ESIMMSISDN = 131115;
    public static final int ATTR_ASSOCIATED_ESIMACTIVE = 131116;
    public static final int ATTR_ASSOCIATED_ESIMB2BMODE = 131117;
    public static final int ATTR_ASSOCIATED_CALLSTACKSISREVERTED = 131118;
    public static final int ATTR_ASSOCIATED_LASTANSWEREDNUMBERS = 131119;
    public static final int ATTR_ASSOCIATED_LASTDIALEDNUMBERS = 131120;
    public static final int ATTR_ASSOCIATED_MISSEDNUMBERS = 131121;
    public static final int ATTR_ASSOCIATED_MEDATAVALIDITY = 131122;
    public static final int ATTR_ASSOCIATED_MISSEDCALLINDICATOR = 131123;
    public static final int ATTR_DATA_DTMFTONEPLAYING = 196609;
    public static final int ATTR_DATA_EMERGENCYNUMBERS = 196610;
    public static final int ATTR_DATA_SIMPINREQUIRED = 196611;
    public static final int ATTR_DATA_ACTIVATIONSTATE = 196612;
    public static final int ATTR_DATA_AUTOMATICPINENTRYACTIVE = 196613;
    public static final int ATTR_DATA_AUTOMATICREDIALACTIVE = 196614;
    public static final int ATTR_DATA_BATTERYCHARGELEVEL = 196615;
    public static final int ATTR_DATA_CALLDURATIONLIST = 196616;
    public static final int ATTR_DATA_CALLLIST = 196617;
    public static final int ATTR_DATA_CDMATHREEWAYCALLINGSETTING = 196618;
    public static final int ATTR_DATA_CRADLEPLUGINSTATE = 196619;
    public static final int ATTR_DATA_DISCONNECTREASON = 196620;
    public static final int ATTR_DATA_EMERGENCYCALLACTIVE = 196621;
    public static final int ATTR_DATA_ENHANCEDPRIVACYMODE = 196622;
    public static final int ATTR_DATA_HANDSFREEMODE = 196623;
    public static final int ATTR_DATA_LOCKSTATE = 196624;
    public static final int ATTR_DATA_MAILBOXCONTENT = 196625;
    public static final int ATTR_DATA_MICMUTESTATE = 196626;
    public static final int ATTR_DATA_NADTEMPERATURE = 196627;
    public static final int ATTR_DATA_PHONEINFORMATION = 196628;
    public static final int ATTR_DATA_NETWORKPROVIDER = 196629;
    public static final int ATTR_DATA_NETWORKTYPE = 196630;
    public static final int ATTR_DATA_PRIVACYMODE = 196631;
    public static final int ATTR_DATA_REGISTERSTATE = 196632;
    public static final int ATTR_DATA_SERVICECODETYPE = 196633;
    public static final int ATTR_DATA_SERVICENUMBERS = 196634;
    public static final int ATTR_DATA_SIGNALQUALITY = 196635;
    public static final int ATTR_DATA_SUPPSERVICERESPONSE = 196636;
    public static final int ATTR_DATA_SERVICEPROVIDER = 196637;
    public static final int ATTR_DATA_SIMALIASINFORMATION = 196638;
    public static final int ATTR_DATA_MICGAINLEVEL = 196639;
    public static final int ATTR_DATA_OPTIMIZATIONMODE = 196640;
    public static final int ATTR_DATA_NADMODE = 196641;
    public static final int ATTR_DATA_OTHERSIMAVAILABLE = 196642;
    public static final int ATTR_DATA_PREFIXCONTENT = 196643;
    public static final int ATTR_DATA_PHONEREMINDERSETTING = 196644;
    public static final int ATTR_DATA_PREFIXACTIVATED = 196645;
    public static final int ATTR_DATA_WIDEBANDSPEECH = 196646;
    public static final int ATTR_DATA_PHONERINGTONE = 196647;
    public static final int ATTR_DATA_FAVORITES = 196648;
    public static final int ATTR_DATA_SAPUPGRADEACTIVE = 196649;
    public static final int ATTR_DATA_EUICCID = 196650;
    public static final int ATTR_DATA_ESIMMSISDN = 196651;
    public static final int ATTR_DATA_ESIMACTIVE = 196652;
    public static final int ATTR_DATA_ESIMB2BMODE = 196653;
    public static final int ATTR_DATA_CALLSTACKSISREVERTED = 196654;
    public static final int ATTR_DATA_LASTANSWEREDNUMBERS = 196655;
    public static final int ATTR_DATA_LASTDIALEDNUMBERS = 196656;
    public static final int ATTR_DATA_MISSEDNUMBERS = 196657;
    public static final int ATTR_DATA_MEDATAVALIDITY = 196658;
    public static final int ATTR_DATA_MISSEDCALLINDICATOR = 196659;

    public int getInstanceID();

    public void setDeviceRole(int var1);

    public void acceptCall(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void deleteCallstacksAll(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void deleteCallstacksEntry(int var1, int var2, boolean var3, int var4, ITelDSIResponseListener var5, ITelDSIResponseListener[] var6);

    public void dialSOSNumber(String var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void dialNumber(String var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void dialNumberFromDBEntry(String var1, long var2, String var4, short var5, short var6, ResourceLocator var7, int var8, int var9, boolean var10, int var11, ITelDSIResponseListener var12, ITelDSIResponseListener[] var13);

    public void dialOperator(int var1, String var2, boolean var3, int var4, ITelDSIResponseListener var5, ITelDSIResponseListener[] var6);

    public void hangupCall(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void joinCalls(boolean var1, int var2, ITelDSIResponseListener var3, ITelDSIResponseListener[] var4);

    public void requestAbortNetworkRegistration();

    public void requestAbortNetworkSearch();

    public void requestCallForward(CFRequestData[] var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestCallWaiting(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestChangeSIMCode(int var1, String var2, String var3, boolean var4, int var5, ITelDSIResponseListener var6, ITelDSIResponseListener[] var7);

    public void requestCLIR(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestDecreaseMicGainLevel(short var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestIncreaseMicGainLevel(short var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestNetworkRegistration(String var1, int var2, boolean var3, int var4, ITelDSIResponseListener var5, ITelDSIResponseListener[] var6);

    public void requestNetworkSearch(boolean var1, int var2, ITelDSIResponseListener var3, ITelDSIResponseListener[] var4);

    public void abortCallForwardRequest();

    public void abortCallWaitingRequest();

    public void abortCallerIDRequest();

    public void requestSetAutomaticEmergencyCallActive(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetAutomaticPinEntryActive(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetAutomaticRedialActive(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetCDMAThreeWayCallingSetting(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetEnhancedPrivacyMode(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetESIMActive(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetHandsFreeMode(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetLanguage(String var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetMailboxContent(String var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetMicGainLevel(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetMICMuteState(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetNADMode(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetOptimizationMode(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetPhoneRingtone(int var1, String var2, boolean var3, int var4, ITelDSIResponseListener var5, ITelDSIResponseListener[] var6);

    public void requestSetPrivacyMode(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSIMPINRequired(String var1, boolean var2, boolean var3, int var4, ITelDSIResponseListener var5, ITelDSIResponseListener[] var6);

    public void requestTelPower(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestUnlockSIM(int var1, String var2, String var3, boolean var4, int var5, ITelDSIResponseListener var6, ITelDSIResponseListener[] var7);

    public void resetMissedCallIndicator(boolean var1, int var2, ITelDSIResponseListener var3, ITelDSIResponseListener[] var4);

    public void restoreFactorySettings(boolean var1, int var2, ITelDSIResponseListener var3, ITelDSIResponseListener[] var4);

    public void sendDTMF(String var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void splitCall(short var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void swapCalls(boolean var1, int var2, ITelDSIResponseListener var3, ITelDSIResponseListener[] var4);

    public void revertCallstacks(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetPhoneReminderSetting(boolean var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public int getDeviceRole();

    public void setIsNadInstance(boolean var1);

    public boolean isNadInstance();

    public void setNotification();
}

