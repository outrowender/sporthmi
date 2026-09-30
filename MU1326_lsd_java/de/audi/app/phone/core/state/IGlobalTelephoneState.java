/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelTopology;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;

public interface IGlobalTelephoneState {
    public static final int ROLE_UNKNOWN = 0;
    public static final int SCOPE_PRIMARY = 65536;
    public static final int SCOPE_ASSOCIATED = 131072;
    public static final int SCOPE_DATA = 196608;
    public static final int SCOPE_GLOBAL = 262144;
    public static final int ATTR_DEFAULT = 0;
    public static final int ATTR_GLOBAL_EMERGENCYNUMBERS = 262145;
    public static final int ATTR_GLOBAL_NADTEMPERATURE = 262146;
    public static final int ATTR_GLOBAL_NADMODE = 262147;
    public static final int ATTR_GLOBAL_NEWMESSAGESAVAILABLE = 262148;
    public static final int ATTR_GLOBAL_RINGTONE_MUTE_SETTING = 262149;
    public static final int ATTR_GLOBAL_RINGTONE_MUTE_STATUS = 262150;
    public static final int ATTR_GLOBAL_EUICCID = 262151;
    public static final int ATTR_GLOBAL_ESIMMSISDN = 262152;
    public static final int ATTR_GLOBAL_ESIMACTIVE = 262153;
    public static final int ATTR_GLOBAL_ESIMB2BMODE = 262154;
    public static final int ATTR_GLOBAL_SERVICENUMBERS = 262155;
    public static final int ATTR_GLOBAL_ECALL_STATE = 262156;
    public static final int ATTR_GLOBAL_TOPOLOGY = 262157;
    public static final int ATTR_PRIMARY_DTMFTONEPLAYING = 65537;
    public static final int ATTR_PRIMARY_SIMPINREQUIRED = 65538;
    public static final int ATTR_PRIMARY_ACTIVATIONSTATE = 65539;
    public static final int ATTR_PRIMARY_AUTOMATICPINENTRYACTIVE = 65540;
    public static final int ATTR_PRIMARY_AUTOMATICREDIALACTIVE = 65541;
    public static final int ATTR_PRIMARY_BATTERYCHARGELEVEL = 65542;
    public static final int ATTR_PRIMARY_CALLDURATIONLIST = 65543;
    public static final int ATTR_PRIMARY_CALLLIST = 65544;
    public static final int ATTR_PRIMARY_CDMATHREEWAYCALLINGSETTING = 65545;
    public static final int ATTR_PRIMARY_CRADLEPLUGINSTATE = 65546;
    public static final int ATTR_PRIMARY_DISCONNECTREASON = 65547;
    public static final int ATTR_PRIMARY_EMERGENCYCALLACTIVE = 65548;
    public static final int ATTR_PRIMARY_ENHANCEDPRIVACYMODE = 65549;
    public static final int ATTR_PRIMARY_HANDSFREEMODE = 65550;
    public static final int ATTR_PRIMARY_LOCKSTATE = 65551;
    public static final int ATTR_PRIMARY_MAILBOXCONTENT = 65552;
    public static final int ATTR_PRIMARY_MICMUTESTATE = 65553;
    public static final int ATTR_PRIMARY_PHONEINFORMATION = 65554;
    public static final int ATTR_PRIMARY_NETWORKPROVIDER = 65555;
    public static final int ATTR_PRIMARY_NETWORKTYPE = 65556;
    public static final int ATTR_PRIMARY_PRIVACYMODE = 65557;
    public static final int ATTR_PRIMARY_REGISTERSTATE = 65558;
    public static final int ATTR_PRIMARY_SERVICECODETYPE = 65559;
    public static final int ATTR_PRIMARY_SIGNALQUALITY = 65561;
    public static final int ATTR_PRIMARY_SUPPSERVICERESPONSE = 65562;
    public static final int ATTR_PRIMARY_SERVICEPROVIDER = 65563;
    public static final int ATTR_PRIMARY_SIMALIASINFORMATION = 65564;
    public static final int ATTR_PRIMARY_MICGAINLEVEL = 65565;
    public static final int ATTR_PRIMARY_OPTIMIZATIONMODE = 65566;
    public static final int ATTR_PRIMARY_OTHERSIMAVAILABLE = 65567;
    public static final int ATTR_PRIMARY_WIDEBANDSPEECH = 65568;
    public static final int ATTR_PRIMARY_PHONERINGTONE = 65569;
    public static final int ATTR_PRIMARY_SAPUPGRADEACTIVE = 65570;
    public static final int ATTR_PRIMARY_MPCALLSTATE = 65571;
    public static final int ATTR_PRIMARY_CALLSTACKS_ISREVERTED = 65572;
    public static final int ATTR_PRIMARY_CALLSTACKS_LASTANSWEREDNUMBERS = 65573;
    public static final int ATTR_PRIMARY_CALLSTACKS_LASTDIALEDNUMBERS = 65574;
    public static final int ATTR_PRIMARY_CALLSTACKS_MISSEDNUMBERS = 65575;
    public static final int ATTR_PRIMARY_CALLSTACKS_COMBINEDCALLSTACKS = 65576;
    public static final int ATTR_PRIMARY_CALLSTACKS_MEDATAVALIDITY = 65577;
    public static final int ATTR_PRIMARY_CALLSTACKS_MISSEDCALLINDICATOR = 65578;
    public static final int ATTR_PRIMARY_PHONEREMINDERSETTING = 65579;
    public static final int ATTR_ASSOCIATED_DTMFTONEPLAYING = 131073;
    public static final int ATTR_ASSOCIATED_SIMPINREQUIRED = 131074;
    public static final int ATTR_ASSOCIATED_ACTIVATIONSTATE = 131075;
    public static final int ATTR_ASSOCIATED_AUTOMATICPINENTRYACTIVE = 131076;
    public static final int ATTR_ASSOCIATED_AUTOMATICREDIALACTIVE = 131077;
    public static final int ATTR_ASSOCIATED_BATTERYCHARGELEVEL = 131078;
    public static final int ATTR_ASSOCIATED_CALLDURATIONLIST = 131079;
    public static final int ATTR_ASSOCIATED_CALLLIST = 131080;
    public static final int ATTR_ASSOCIATED_CDMATHREEWAYCALLINGSETTING = 131081;
    public static final int ATTR_ASSOCIATED_CRADLEPLUGINSTATE = 131082;
    public static final int ATTR_ASSOCIATED_DISCONNECTREASON = 131083;
    public static final int ATTR_ASSOCIATED_EMERGENCYCALLACTIVE = 131084;
    public static final int ATTR_ASSOCIATED_ENHANCEDPRIVACYMODE = 131085;
    public static final int ATTR_ASSOCIATED_HANDSFREEMODE = 131086;
    public static final int ATTR_ASSOCIATED_LOCKSTATE = 131087;
    public static final int ATTR_ASSOCIATED_MAILBOXCONTENT = 131088;
    public static final int ATTR_ASSOCIATED_MICMUTESTATE = 131089;
    public static final int ATTR_ASSOCIATED_PHONEINFORMATION = 131090;
    public static final int ATTR_ASSOCIATED_NETWORKPROVIDER = 131091;
    public static final int ATTR_ASSOCIATED_NETWORKTYPE = 131092;
    public static final int ATTR_ASSOCIATED_PRIVACYMODE = 131093;
    public static final int ATTR_ASSOCIATED_REGISTERSTATE = 131094;
    public static final int ATTR_ASSOCIATED_SERVICECODETYPE = 131095;
    public static final int ATTR_ASSOCIATED_SIGNALQUALITY = 131097;
    public static final int ATTR_ASSOCIATED_SUPPSERVICERESPONSE = 131098;
    public static final int ATTR_ASSOCIATED_SERVICEPROVIDER = 131099;
    public static final int ATTR_ASSOCIATED_SIMALIASINFORMATION = 131100;
    public static final int ATTR_ASSOCIATED_MICGAINLEVEL = 131101;
    public static final int ATTR_ASSOCIATED_OPTIMIZATIONMODE = 131102;
    public static final int ATTR_ASSOCIATED_OTHERSIMAVAILABLE = 131103;
    public static final int ATTR_ASSOCIATED_WIDEBANDSPEECH = 131104;
    public static final int ATTR_ASSOCIATED_PHONERINGTONE = 131105;
    public static final int ATTR_ASSOCIATED_SAPUPGRADEACTIVE = 131106;
    public static final int ATTR_ASSOCIATED_MPCALLSTATE = 131107;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_ISREVERTED = 131108;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_LASTANSWEREDNUMBERS = 131109;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_LASTDIALEDNUMBERS = 131110;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_MISSEDNUMBERS = 131111;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_COMBINEDCALLSTACKS = 131112;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_MEDATAVALIDITY = 131113;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_MISSEDCALLINDICATOR = 131114;
    public static final int ATTR_ASSOCIATED_PHONEREMINDERSETTING = 131115;
    public static final int ATTR_DATA_DTMFTONEPLAYING = 196609;
    public static final int ATTR_DATA_SIMPINREQUIRED = 196610;
    public static final int ATTR_DATA_ACTIVATIONSTATE = 196611;
    public static final int ATTR_DATA_AUTOMATICPINENTRYACTIVE = 196612;
    public static final int ATTR_DATA_AUTOMATICREDIALACTIVE = 196613;
    public static final int ATTR_DATA_BATTERYCHARGELEVEL = 196614;
    public static final int ATTR_DATA_CALLDURATIONLIST = 196615;
    public static final int ATTR_DATA_CALLLIST = 196616;
    public static final int ATTR_DATA_CDMATHREEWAYCALLINGSETTING = 196617;
    public static final int ATTR_DATA_CRADLEPLUGINSTATE = 196618;
    public static final int ATTR_DATA_DISCONNECTREASON = 196619;
    public static final int ATTR_DATA_EMERGENCYCALLACTIVE = 196620;
    public static final int ATTR_DATA_ENHANCEDPRIVACYMODE = 196621;
    public static final int ATTR_DATA_HANDSFREEMODE = 196622;
    public static final int ATTR_DATA_LOCKSTATE = 196623;
    public static final int ATTR_DATA_MAILBOXCONTENT = 196624;
    public static final int ATTR_DATA_MICMUTESTATE = 196625;
    public static final int ATTR_DATA_PHONEINFORMATION = 196626;
    public static final int ATTR_DATA_NETWORKPROVIDER = 196627;
    public static final int ATTR_DATA_NETWORKTYPE = 196628;
    public static final int ATTR_DATA_PRIVACYMODE = 196629;
    public static final int ATTR_DATA_REGISTERSTATE = 196630;
    public static final int ATTR_DATA_SERVICECODETYPE = 196631;
    public static final int ATTR_DATA_SIGNALQUALITY = 196633;
    public static final int ATTR_DATA_SUPPSERVICERESPONSE = 196634;
    public static final int ATTR_DATA_SERVICEPROVIDER = 196635;
    public static final int ATTR_DATA_SIMALIASINFORMATION = 196636;
    public static final int ATTR_DATA_MICGAINLEVEL = 196637;
    public static final int ATTR_DATA_OPTIMIZATIONMODE = 196638;
    public static final int ATTR_DATA_OTHERSIMAVAILABLE = 196639;
    public static final int ATTR_DATA_WIDEBANDSPEECH = 196640;
    public static final int ATTR_DATA_PHONERINGTONE = 196641;
    public static final int ATTR_DATA_SAPUPGRADEACTIVE = 196642;
    public static final int ATTR_DATA_MPCALLSTATE = 196643;
    public static final int ATTR_DATA_CALLSTACKS_ISREVERTED = 196644;
    public static final int ATTR_DATA_CALLSTACKS_LASTANSWEREDNUMBERS = 196645;
    public static final int ATTR_DATA_CALLSTACKS_LASTDIALEDNUMBERS = 196646;
    public static final int ATTR_DATA_CALLSTACKS_MISSEDNUMBERS = 196647;
    public static final int ATTR_DATA_CALLSTACKS_COMBINEDCALLSTACKS = 196648;
    public static final int ATTR_DATA_CALLSTACKS_MEDATAVALIDITY = 196649;
    public static final int ATTR_DATA_CALLSTACKS_MISSEDCALLINDICATOR = 196650;
    public static final int ATTR_DATA_PHONEREMINDERSETTING = 196651;
    public static final int NAD_USAGE_PRIMARY = 0;
    public static final int NAD_USAGE_ASSOCIATED = 1;
    public static final int NAD_USAGE_DATA = 2;

    public void init();

    public void deinit();

    public void removeListener(IGlobalTelephoneStateListener var1);

    public void registerListener(IGlobalTelephoneStateListener var1);

    public void updateNewMessagesAvailable(boolean var1, boolean var2);

    public void updateRingtoneMuteSetting(boolean var1);

    public void updateTopology(ITelTopology var1);

    public void updateRingtoneMuteActive(boolean var1);

    public void removeListenerForSpecificAttributeUpdate(int var1, IGlobalTelephoneStateListener var2);

    public void registerListenerForSpecificAttributeUpdate(int var1, IGlobalTelephoneStateListener var2);

    public void registerListenerForSpecificAttributeUpdate(int[] var1, IGlobalTelephoneStateListener var2);

    public void removeListenerForSpecificAttributeUpdate(int[] var1, IGlobalTelephoneStateListener var2);

    public void updateMEDevice(int var1, int var2, ITelDSIMobileEquipmentDeviceState var3);

    public void setNadUsageData();

    public void setNadUsageAssociated();

    public void setNadUsagePrimary();

    public void setNadUsageUnknown();

    public void setAcceptIncomingCallOnNonCallLeadingDevicePending(boolean var1);
}

