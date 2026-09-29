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
    public static final int ROLE_UNKNOWN;
    public static final int ROLE_PRIMARY;
    public static final int ROLE_ASSOCIATED;
    public static final int ROLE_DATA;
    public static final int RT_ACCEPTCALL;
    public static final int RT_HANGUPCALL;
    public static final int RT_SWAPCALLS;
    public static final int RT_SPLITCALL;
    public static final int RT_JOINCALLS;
    public static final int RT_DIALNUMBER;
    public static final int RT_DIALNUMBERFROMDBENTRY;
    public static final int RT_SENDDTMF;
    public static final int RT_REQUESTNETWORKREGISTRATION;
    public static final int RT_REQUESTABORTNETWORKREGISTRATION;
    public static final int RT_REQUESTNETWORKSEARCH;
    public static final int RT_REQUESTABORTNETWORKSEARCH;
    public static final int RT_REQUESTCALLFORWARD;
    public static final int RT_REQUESTCALLWAITING;
    public static final int RT_REQUESTCLIR;
    public static final int RT_REQUESTSERVICECODEABORT;
    public static final int RT_REQUESTSETAUTOMATICPINENTRYACTIVE;
    public static final int RT_REQUESTSETAUTOMATICREDIALACTIVE;
    public static final int RT_REQUESTSETCDMATHREEWAYCALLINGSETTING;
    public static final int RT_REQUESTSETAUTOMATICEMERGENCYCALLACTIVE;
    public static final int RT_REQUESTSETENHANCEDPRIVACYMODE;
    public static final int RT_REQUESTSETMAILBOXCONTENT;
    public static final int RT_REQUESTSETPRIVACYMODE;
    public static final int RT_REQUESTTELPOWER;
    public static final int RT_REQUESTUNLOCKSIM;
    public static final int RT_REQUESTCHECKSIMPINCODE;
    public static final int RT_REQUESTCHANGESIMCODE;
    public static final int RT_REQUESTSETHANDSFREEMODE;
    public static final int RT_REQUESTSETMICMUTESTATE;
    public static final int RT_REQUESTSETLANGUAGE;
    public static final int RT_REQUESTSIMPINREQUIRED;
    public static final int RT_RESTOREFACTORYSETTINGS;
    public static final int RT_REQUESTUNLOCKOTHERSIM;
    public static final int RT_REQUESTSETSIMALIASES;
    public static final int RT_REQUESTSETMICGAINLEVEL;
    public static final int RT_REQUESTDECREASEMICGAINLEVEL;
    public static final int RT_REQUESTINCREASEMICGAINLEVEL;
    public static final int RT_REQUESTSETOPTIMIZATIONMODE;
    public static final int RT_REQUESTSETNADMODE;
    public static final int RT_REQUESTREMOVEOTHERSIM;
    public static final int RT_DIALOPERATOR;
    public static final int RT_REQUESTSETPREFIXCONTENT;
    public static final int RT_REQUESTSETPHONEREMINDERSETTING;
    public static final int RT_REQUESTSETPREFIXACTIVATED;
    public static final int RT_REQUESTSETPHONERINGTONE;
    public static final int RT_REQUESTSETFAVORITES;
    public static final int RT_REQUESTSETSIMNAME;
    public static final int RT_REQUESTSETESIMACTIVE;
    public static final int RT_DELETECALLSTACKSALL;
    public static final int RT_DELETECALLSTACKSENTRY;
    public static final int RT_RESETMISSEDCALLINDICATOR;
    public static final int RT_REVERTCALLSTACKS;
    public static final int ATTR_DTMFTONEPLAYING;
    public static final int ATTR_EMERGENCYNUMBERS;
    public static final int ATTR_SIMPINREQUIRED;
    public static final int ATTR_ACTIVATIONSTATE;
    public static final int ATTR_AUTOMATICPINENTRYACTIVE;
    public static final int ATTR_AUTOMATICREDIALACTIVE;
    public static final int ATTR_BATTERYCHARGELEVEL;
    public static final int ATTR_CALLDURATIONLIST;
    public static final int ATTR_CALLLIST;
    public static final int ATTR_CDMATHREEWAYCALLINGSETTING;
    public static final int ATTR_CRADLEPLUGINSTATE;
    public static final int ATTR_DISCONNECTREASON;
    public static final int ATTR_EMERGENCYCALLACTIVE;
    public static final int ATTR_ENHANCEDPRIVACYMODE;
    public static final int ATTR_HANDSFREEMODE;
    public static final int ATTR_LOCKSTATE;
    public static final int ATTR_MAILBOXCONTENT;
    public static final int ATTR_MICMUTESTATE;
    public static final int ATTR_NADTEMPERATURE;
    public static final int ATTR_PHONEINFORMATION;
    public static final int ATTR_NETWORKPROVIDER;
    public static final int ATTR_NETWORKTYPE;
    public static final int ATTR_PRIVACYMODE;
    public static final int ATTR_REGISTERSTATE;
    public static final int ATTR_SERVICECODETYPE;
    public static final int ATTR_SERVICENUMBERS;
    public static final int ATTR_SIGNALQUALITY;
    public static final int ATTR_SUPPSERVICERESPONSE;
    public static final int ATTR_SERVICEPROVIDER;
    public static final int ATTR_SIMALIASINFORMATION;
    public static final int ATTR_MICGAINLEVEL;
    public static final int ATTR_OPTIMIZATIONMODE;
    public static final int ATTR_NADMODE;
    public static final int ATTR_OTHERSIMAVAILABLE;
    public static final int ATTR_PREFIXCONTENT;
    public static final int ATTR_PHONEREMINDERSETTING;
    public static final int ATTR_PREFIXACTIVATED;
    public static final int ATTR_WIDEBANDSPEECH;
    public static final int ATTR_PHONERINGTONE;
    public static final int ATTR_FAVORITES;
    public static final int ATTR_SAPUPGRADEACTIVE;
    public static final int ATTR_EUICCID;
    public static final int ATTR_ESIMMSISDN;
    public static final int ATTR_ESIMACTIVE;
    public static final int ATTR_ESIMB2BMODE;
    public static final int ATTR_CALLSTACKSISREVERTED;
    public static final int ATTR_LASTANSWEREDNUMBERS;
    public static final int ATTR_LASTDIALEDNUMBERS;
    public static final int ATTR_MISSEDNUMBERS;
    public static final int ATTR_MEDATAVALIDITY;
    public static final int ATTR_MISSEDCALLINDICATOR;
    public static final int ATTR_PRIMARY_DTMFTONEPLAYING;
    public static final int ATTR_PRIMARY_EMERGENCYNUMBERS;
    public static final int ATTR_PRIMARY_SIMPINREQUIRED;
    public static final int ATTR_PRIMARY_ACTIVATIONSTATE;
    public static final int ATTR_PRIMARY_AUTOMATICPINENTRYACTIVE;
    public static final int ATTR_PRIMARY_AUTOMATICREDIALACTIVE;
    public static final int ATTR_PRIMARY_BATTERYCHARGELEVEL;
    public static final int ATTR_PRIMARY_CALLDURATIONLIST;
    public static final int ATTR_PRIMARY_CALLLIST;
    public static final int ATTR_PRIMARY_CDMATHREEWAYCALLINGSETTING;
    public static final int ATTR_PRIMARY_CRADLEPLUGINSTATE;
    public static final int ATTR_PRIMARY_DISCONNECTREASON;
    public static final int ATTR_PRIMARY_EMERGENCYCALLACTIVE;
    public static final int ATTR_PRIMARY_ENHANCEDPRIVACYMODE;
    public static final int ATTR_PRIMARY_HANDSFREEMODE;
    public static final int ATTR_PRIMARY_LOCKSTATE;
    public static final int ATTR_PRIMARY_MAILBOXCONTENT;
    public static final int ATTR_PRIMARY_MICMUTESTATE;
    public static final int ATTR_PRIMARY_NADTEMPERATURE;
    public static final int ATTR_PRIMARY_PHONEINFORMATION;
    public static final int ATTR_PRIMARY_NETWORKPROVIDER;
    public static final int ATTR_PRIMARY_NETWORKTYPE;
    public static final int ATTR_PRIMARY_PRIVACYMODE;
    public static final int ATTR_PRIMARY_REGISTERSTATE;
    public static final int ATTR_PRIMARY_SERVICECODETYPE;
    public static final int ATTR_PRIMARY_SERVICENUMBERS;
    public static final int ATTR_PRIMARY_SIGNALQUALITY;
    public static final int ATTR_PRIMARY_SUPPSERVICERESPONSE;
    public static final int ATTR_PRIMARY_SERVICEPROVIDER;
    public static final int ATTR_PRIMARY_SIMALIASINFORMATION;
    public static final int ATTR_PRIMARY_MICGAINLEVEL;
    public static final int ATTR_PRIMARY_OPTIMIZATIONMODE;
    public static final int ATTR_PRIMARY_NADMODE;
    public static final int ATTR_PRIMARY_OTHERSIMAVAILABLE;
    public static final int ATTR_PRIMARY_PREFIXCONTENT;
    public static final int ATTR_PRIMARY_PHONEREMINDERSETTING;
    public static final int ATTR_PRIMARY_PREFIXACTIVATED;
    public static final int ATTR_PRIMARY_WIDEBANDSPEECH;
    public static final int ATTR_PRIMARY_PHONERINGTONE;
    public static final int ATTR_PRIMARY_FAVORITES;
    public static final int ATTR_PRIMARY_SAPUPGRADEACTIVE;
    public static final int ATTR_PRIMARY_EUICCID;
    public static final int ATTR_PRIMARY_ESIMMSISDN;
    public static final int ATTR_PRIMARY_ESIMACTIVE;
    public static final int ATTR_PRIMARY_ESIMB2BMODE;
    public static final int ATTR_PRIMARY_CALLSTACKSISREVERTED;
    public static final int ATTR_PRIMARY_LASTANSWEREDNUMBERS;
    public static final int ATTR_PRIMARY_LASTDIALEDNUMBERS;
    public static final int ATTR_PRIMARY_MISSEDNUMBERS;
    public static final int ATTR_PRIMARY_MEDATAVALIDITY;
    public static final int ATTR_PRIMARY_MISSEDCALLINDICATOR;
    public static final int ATTR_ASSOCIATED_DTMFTONEPLAYING;
    public static final int ATTR_ASSOCIATED_EMERGENCYNUMBERS;
    public static final int ATTR_ASSOCIATED_SIMPINREQUIRED;
    public static final int ATTR_ASSOCIATED_ACTIVATIONSTATE;
    public static final int ATTR_ASSOCIATED_AUTOMATICPINENTRYACTIVE;
    public static final int ATTR_ASSOCIATED_AUTOMATICREDIALACTIVE;
    public static final int ATTR_ASSOCIATED_BATTERYCHARGELEVEL;
    public static final int ATTR_ASSOCIATED_CALLDURATIONLIST;
    public static final int ATTR_ASSOCIATED_CALLLIST;
    public static final int ATTR_ASSOCIATED_CDMATHREEWAYCALLINGSETTING;
    public static final int ATTR_ASSOCIATED_CRADLEPLUGINSTATE;
    public static final int ATTR_ASSOCIATED_DISCONNECTREASON;
    public static final int ATTR_ASSOCIATED_EMERGENCYCALLACTIVE;
    public static final int ATTR_ASSOCIATED_ENHANCEDPRIVACYMODE;
    public static final int ATTR_ASSOCIATED_HANDSFREEMODE;
    public static final int ATTR_ASSOCIATED_LOCKSTATE;
    public static final int ATTR_ASSOCIATED_MAILBOXCONTENT;
    public static final int ATTR_ASSOCIATED_MICMUTESTATE;
    public static final int ATTR_ASSOCIATED_NADTEMPERATURE;
    public static final int ATTR_ASSOCIATED_PHONEINFORMATION;
    public static final int ATTR_ASSOCIATED_NETWORKPROVIDER;
    public static final int ATTR_ASSOCIATED_NETWORKTYPE;
    public static final int ATTR_ASSOCIATED_PRIVACYMODE;
    public static final int ATTR_ASSOCIATED_REGISTERSTATE;
    public static final int ATTR_ASSOCIATED_SERVICECODETYPE;
    public static final int ATTR_ASSOCIATED_SERVICENUMBERS;
    public static final int ATTR_ASSOCIATED_SIGNALQUALITY;
    public static final int ATTR_ASSOCIATED_SUPPSERVICERESPONSE;
    public static final int ATTR_ASSOCIATED_SERVICEPROVIDER;
    public static final int ATTR_ASSOCIATED_SIMALIASINFORMATION;
    public static final int ATTR_ASSOCIATED_MICGAINLEVEL;
    public static final int ATTR_ASSOCIATED_OPTIMIZATIONMODE;
    public static final int ATTR_ASSOCIATED_NADMODE;
    public static final int ATTR_ASSOCIATED_OTHERSIMAVAILABLE;
    public static final int ATTR_ASSOCIATED_PREFIXCONTENT;
    public static final int ATTR_ASSOCIATED_PHONEREMINDERSETTING;
    public static final int ATTR_ASSOCIATED_PREFIXACTIVATED;
    public static final int ATTR_ASSOCIATED_WIDEBANDSPEECH;
    public static final int ATTR_ASSOCIATED_PHONERINGTONE;
    public static final int ATTR_ASSOCIATED_FAVORITES;
    public static final int ATTR_ASSOCIATED_SAPUPGRADEACTIVE;
    public static final int ATTR_ASSOCIATED_EUICCID;
    public static final int ATTR_ASSOCIATED_ESIMMSISDN;
    public static final int ATTR_ASSOCIATED_ESIMACTIVE;
    public static final int ATTR_ASSOCIATED_ESIMB2BMODE;
    public static final int ATTR_ASSOCIATED_CALLSTACKSISREVERTED;
    public static final int ATTR_ASSOCIATED_LASTANSWEREDNUMBERS;
    public static final int ATTR_ASSOCIATED_LASTDIALEDNUMBERS;
    public static final int ATTR_ASSOCIATED_MISSEDNUMBERS;
    public static final int ATTR_ASSOCIATED_MEDATAVALIDITY;
    public static final int ATTR_ASSOCIATED_MISSEDCALLINDICATOR;
    public static final int ATTR_DATA_DTMFTONEPLAYING;
    public static final int ATTR_DATA_EMERGENCYNUMBERS;
    public static final int ATTR_DATA_SIMPINREQUIRED;
    public static final int ATTR_DATA_ACTIVATIONSTATE;
    public static final int ATTR_DATA_AUTOMATICPINENTRYACTIVE;
    public static final int ATTR_DATA_AUTOMATICREDIALACTIVE;
    public static final int ATTR_DATA_BATTERYCHARGELEVEL;
    public static final int ATTR_DATA_CALLDURATIONLIST;
    public static final int ATTR_DATA_CALLLIST;
    public static final int ATTR_DATA_CDMATHREEWAYCALLINGSETTING;
    public static final int ATTR_DATA_CRADLEPLUGINSTATE;
    public static final int ATTR_DATA_DISCONNECTREASON;
    public static final int ATTR_DATA_EMERGENCYCALLACTIVE;
    public static final int ATTR_DATA_ENHANCEDPRIVACYMODE;
    public static final int ATTR_DATA_HANDSFREEMODE;
    public static final int ATTR_DATA_LOCKSTATE;
    public static final int ATTR_DATA_MAILBOXCONTENT;
    public static final int ATTR_DATA_MICMUTESTATE;
    public static final int ATTR_DATA_NADTEMPERATURE;
    public static final int ATTR_DATA_PHONEINFORMATION;
    public static final int ATTR_DATA_NETWORKPROVIDER;
    public static final int ATTR_DATA_NETWORKTYPE;
    public static final int ATTR_DATA_PRIVACYMODE;
    public static final int ATTR_DATA_REGISTERSTATE;
    public static final int ATTR_DATA_SERVICECODETYPE;
    public static final int ATTR_DATA_SERVICENUMBERS;
    public static final int ATTR_DATA_SIGNALQUALITY;
    public static final int ATTR_DATA_SUPPSERVICERESPONSE;
    public static final int ATTR_DATA_SERVICEPROVIDER;
    public static final int ATTR_DATA_SIMALIASINFORMATION;
    public static final int ATTR_DATA_MICGAINLEVEL;
    public static final int ATTR_DATA_OPTIMIZATIONMODE;
    public static final int ATTR_DATA_NADMODE;
    public static final int ATTR_DATA_OTHERSIMAVAILABLE;
    public static final int ATTR_DATA_PREFIXCONTENT;
    public static final int ATTR_DATA_PHONEREMINDERSETTING;
    public static final int ATTR_DATA_PREFIXACTIVATED;
    public static final int ATTR_DATA_WIDEBANDSPEECH;
    public static final int ATTR_DATA_PHONERINGTONE;
    public static final int ATTR_DATA_FAVORITES;
    public static final int ATTR_DATA_SAPUPGRADEACTIVE;
    public static final int ATTR_DATA_EUICCID;
    public static final int ATTR_DATA_ESIMMSISDN;
    public static final int ATTR_DATA_ESIMACTIVE;
    public static final int ATTR_DATA_ESIMB2BMODE;
    public static final int ATTR_DATA_CALLSTACKSISREVERTED;
    public static final int ATTR_DATA_LASTANSWEREDNUMBERS;
    public static final int ATTR_DATA_LASTDIALEDNUMBERS;
    public static final int ATTR_DATA_MISSEDNUMBERS;
    public static final int ATTR_DATA_MEDATAVALIDITY;
    public static final int ATTR_DATA_MISSEDCALLINDICATOR;

    default public int getInstanceID() {
    }

    default public void setDeviceRole(int n) {
    }

    default public void acceptCall(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void deleteCallstacksAll(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void deleteCallstacksEntry(int n, int n2, boolean bl, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void dialSOSNumber(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void dialNumber(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, boolean bl, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void dialOperator(int n, String string, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void hangupCall(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void joinCalls(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestAbortNetworkRegistration() {
    }

    default public void requestAbortNetworkSearch() {
    }

    default public void requestCallForward(CFRequestData[] cFRequestDataArray, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestCallWaiting(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestChangeSIMCode(int n, String string, String string2, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestCLIR(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestDecreaseMicGainLevel(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestIncreaseMicGainLevel(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestNetworkRegistration(String string, int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestNetworkSearch(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void abortCallForwardRequest() {
    }

    default public void abortCallWaitingRequest() {
    }

    default public void abortCallerIDRequest() {
    }

    default public void requestSetAutomaticEmergencyCallActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetAutomaticPinEntryActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetAutomaticRedialActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetCDMAThreeWayCallingSetting(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetEnhancedPrivacyMode(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetESIMActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetHandsFreeMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetLanguage(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetMailboxContent(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetMicGainLevel(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetMICMuteState(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetNADMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetOptimizationMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetPhoneRingtone(int n, String string, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetPrivacyMode(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSIMPINRequired(String string, boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestTelPower(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestUnlockSIM(int n, String string, String string2, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void resetMissedCallIndicator(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void restoreFactorySettings(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void sendDTMF(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void splitCall(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void swapCalls(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void revertCallstacks(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetPhoneReminderSetting(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public int getDeviceRole() {
    }

    default public void setIsNadInstance(boolean bl) {
    }

    default public boolean isNadInstance() {
    }

    default public void setNotification() {
    }
}

