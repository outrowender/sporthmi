/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelTopology;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;

public interface IGlobalTelephoneState {
    public static final int ROLE_UNKNOWN;
    public static final int SCOPE_PRIMARY;
    public static final int SCOPE_ASSOCIATED;
    public static final int SCOPE_DATA;
    public static final int SCOPE_GLOBAL;
    public static final int ATTR_DEFAULT;
    public static final int ATTR_GLOBAL_EMERGENCYNUMBERS;
    public static final int ATTR_GLOBAL_NADTEMPERATURE;
    public static final int ATTR_GLOBAL_NADMODE;
    public static final int ATTR_GLOBAL_NEWMESSAGESAVAILABLE;
    public static final int ATTR_GLOBAL_RINGTONE_MUTE_SETTING;
    public static final int ATTR_GLOBAL_RINGTONE_MUTE_STATUS;
    public static final int ATTR_GLOBAL_EUICCID;
    public static final int ATTR_GLOBAL_ESIMMSISDN;
    public static final int ATTR_GLOBAL_ESIMACTIVE;
    public static final int ATTR_GLOBAL_ESIMB2BMODE;
    public static final int ATTR_GLOBAL_SERVICENUMBERS;
    public static final int ATTR_GLOBAL_ECALL_STATE;
    public static final int ATTR_GLOBAL_TOPOLOGY;
    public static final int ATTR_PRIMARY_DTMFTONEPLAYING;
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
    public static final int ATTR_PRIMARY_PHONEINFORMATION;
    public static final int ATTR_PRIMARY_NETWORKPROVIDER;
    public static final int ATTR_PRIMARY_NETWORKTYPE;
    public static final int ATTR_PRIMARY_PRIVACYMODE;
    public static final int ATTR_PRIMARY_REGISTERSTATE;
    public static final int ATTR_PRIMARY_SERVICECODETYPE;
    public static final int ATTR_PRIMARY_SIGNALQUALITY;
    public static final int ATTR_PRIMARY_SUPPSERVICERESPONSE;
    public static final int ATTR_PRIMARY_SERVICEPROVIDER;
    public static final int ATTR_PRIMARY_SIMALIASINFORMATION;
    public static final int ATTR_PRIMARY_MICGAINLEVEL;
    public static final int ATTR_PRIMARY_OPTIMIZATIONMODE;
    public static final int ATTR_PRIMARY_OTHERSIMAVAILABLE;
    public static final int ATTR_PRIMARY_WIDEBANDSPEECH;
    public static final int ATTR_PRIMARY_PHONERINGTONE;
    public static final int ATTR_PRIMARY_SAPUPGRADEACTIVE;
    public static final int ATTR_PRIMARY_MPCALLSTATE;
    public static final int ATTR_PRIMARY_CALLSTACKS_ISREVERTED;
    public static final int ATTR_PRIMARY_CALLSTACKS_LASTANSWEREDNUMBERS;
    public static final int ATTR_PRIMARY_CALLSTACKS_LASTDIALEDNUMBERS;
    public static final int ATTR_PRIMARY_CALLSTACKS_MISSEDNUMBERS;
    public static final int ATTR_PRIMARY_CALLSTACKS_COMBINEDCALLSTACKS;
    public static final int ATTR_PRIMARY_CALLSTACKS_MEDATAVALIDITY;
    public static final int ATTR_PRIMARY_CALLSTACKS_MISSEDCALLINDICATOR;
    public static final int ATTR_PRIMARY_PHONEREMINDERSETTING;
    public static final int ATTR_ASSOCIATED_DTMFTONEPLAYING;
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
    public static final int ATTR_ASSOCIATED_PHONEINFORMATION;
    public static final int ATTR_ASSOCIATED_NETWORKPROVIDER;
    public static final int ATTR_ASSOCIATED_NETWORKTYPE;
    public static final int ATTR_ASSOCIATED_PRIVACYMODE;
    public static final int ATTR_ASSOCIATED_REGISTERSTATE;
    public static final int ATTR_ASSOCIATED_SERVICECODETYPE;
    public static final int ATTR_ASSOCIATED_SIGNALQUALITY;
    public static final int ATTR_ASSOCIATED_SUPPSERVICERESPONSE;
    public static final int ATTR_ASSOCIATED_SERVICEPROVIDER;
    public static final int ATTR_ASSOCIATED_SIMALIASINFORMATION;
    public static final int ATTR_ASSOCIATED_MICGAINLEVEL;
    public static final int ATTR_ASSOCIATED_OPTIMIZATIONMODE;
    public static final int ATTR_ASSOCIATED_OTHERSIMAVAILABLE;
    public static final int ATTR_ASSOCIATED_WIDEBANDSPEECH;
    public static final int ATTR_ASSOCIATED_PHONERINGTONE;
    public static final int ATTR_ASSOCIATED_SAPUPGRADEACTIVE;
    public static final int ATTR_ASSOCIATED_MPCALLSTATE;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_ISREVERTED;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_LASTANSWEREDNUMBERS;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_LASTDIALEDNUMBERS;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_MISSEDNUMBERS;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_COMBINEDCALLSTACKS;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_MEDATAVALIDITY;
    public static final int ATTR_ASSOCIATED_CALLSTACKS_MISSEDCALLINDICATOR;
    public static final int ATTR_ASSOCIATED_PHONEREMINDERSETTING;
    public static final int ATTR_DATA_DTMFTONEPLAYING;
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
    public static final int ATTR_DATA_PHONEINFORMATION;
    public static final int ATTR_DATA_NETWORKPROVIDER;
    public static final int ATTR_DATA_NETWORKTYPE;
    public static final int ATTR_DATA_PRIVACYMODE;
    public static final int ATTR_DATA_REGISTERSTATE;
    public static final int ATTR_DATA_SERVICECODETYPE;
    public static final int ATTR_DATA_SIGNALQUALITY;
    public static final int ATTR_DATA_SUPPSERVICERESPONSE;
    public static final int ATTR_DATA_SERVICEPROVIDER;
    public static final int ATTR_DATA_SIMALIASINFORMATION;
    public static final int ATTR_DATA_MICGAINLEVEL;
    public static final int ATTR_DATA_OPTIMIZATIONMODE;
    public static final int ATTR_DATA_OTHERSIMAVAILABLE;
    public static final int ATTR_DATA_WIDEBANDSPEECH;
    public static final int ATTR_DATA_PHONERINGTONE;
    public static final int ATTR_DATA_SAPUPGRADEACTIVE;
    public static final int ATTR_DATA_MPCALLSTATE;
    public static final int ATTR_DATA_CALLSTACKS_ISREVERTED;
    public static final int ATTR_DATA_CALLSTACKS_LASTANSWEREDNUMBERS;
    public static final int ATTR_DATA_CALLSTACKS_LASTDIALEDNUMBERS;
    public static final int ATTR_DATA_CALLSTACKS_MISSEDNUMBERS;
    public static final int ATTR_DATA_CALLSTACKS_COMBINEDCALLSTACKS;
    public static final int ATTR_DATA_CALLSTACKS_MEDATAVALIDITY;
    public static final int ATTR_DATA_CALLSTACKS_MISSEDCALLINDICATOR;
    public static final int ATTR_DATA_PHONEREMINDERSETTING;
    public static final int NAD_USAGE_PRIMARY;
    public static final int NAD_USAGE_ASSOCIATED;
    public static final int NAD_USAGE_DATA;

    default public void init() {
    }

    default public void deinit() {
    }

    default public void removeListener(IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
    }

    default public void registerListener(IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
    }

    default public void updateNewMessagesAvailable(boolean bl, boolean bl2) {
    }

    default public void updateRingtoneMuteSetting(boolean bl) {
    }

    default public void updateTopology(ITelTopology iTelTopology) {
    }

    default public void updateRingtoneMuteActive(boolean bl) {
    }

    default public void removeListenerForSpecificAttributeUpdate(int n, IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
    }

    default public void registerListenerForSpecificAttributeUpdate(int n, IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
    }

    default public void registerListenerForSpecificAttributeUpdate(int[] nArray, IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
    }

    default public void removeListenerForSpecificAttributeUpdate(int[] nArray, IGlobalTelephoneStateListener iGlobalTelephoneStateListener) {
    }

    default public void updateMEDevice(int n, int n2, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
    }

    default public void setNadUsageData() {
    }

    default public void setNadUsageAssociated() {
    }

    default public void setNadUsagePrimary() {
    }

    default public void setNadUsageUnknown() {
    }

    default public void setAcceptIncomingCallOnNonCallLeadingDevicePending(boolean bl) {
    }
}

