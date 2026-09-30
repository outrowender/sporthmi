/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CFRequestData;

public class NullTelDSIMobileEquipmentDeviceAccess
implements ITelDSIMobileEquipmentDeviceAccess {
    private final LogChannel log;

    public NullTelDSIMobileEquipmentDeviceAccess(LogChannel logChannel) {
        this.log = logChannel;
    }

    public void init() {
    }

    public void deinit() {
    }

    public int getInstanceID() {
        this.log.log(1000000, "[NullTelDSIMobileEquipmentDeviceAccess#getInstanceID] returning -1");
        return -1;
    }

    public void setDeviceRole(int n) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#setDeviceRole] NOP!");
    }

    public void acceptCall(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#acceptCall] NOP!");
    }

    public void deleteCallstacksAll(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#deleteCallstacksAll] NOP!");
    }

    public void deleteCallstacksEntry(int n, int n2, boolean bl, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#deleteCallstacksEntry] NOP!");
    }

    public void dialSOSNumber(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#dialSOSNumber] NOP!");
    }

    public void dialNumber(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#dialNumber] NOP!");
    }

    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, boolean bl, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#dialNumberFromDBEntry] NOP!");
    }

    public void dialOperator(int n, String string, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#dialOperator] NOP!");
    }

    public void hangupCall(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#hangupCall] NOP!");
    }

    public void joinCalls(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#joinCalls] NOP!");
    }

    public void requestAbortNetworkRegistration() {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestAbortNetworkRegistration] NOP!");
    }

    public void requestAbortNetworkSearch() {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestAbortNetworkSearch] NOP!");
    }

    public void requestCallForward(CFRequestData[] cFRequestDataArray, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestCallForward] NOP!");
    }

    public void requestCallWaiting(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestCallWaiting] NOP!");
    }

    public void requestChangeSIMCode(int n, String string, String string2, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestChangeSIMCode] NOP!");
    }

    public void requestCLIR(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestCLIR] NOP!");
    }

    public void requestDecreaseMicGainLevel(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestDecreaseMicGainLevel] NOP!");
    }

    public void requestIncreaseMicGainLevel(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestIncreaseMicGainLevel] NOP!");
    }

    public void requestNetworkRegistration(String string, int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestNetworkRegistration] NOP!");
    }

    public void requestNetworkSearch(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestNetworkSearch] NOP!");
    }

    public void abortCallForwardRequest() {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#abortCallForwardRequest] NOP!");
    }

    public void abortCallWaitingRequest() {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#abortCallWaitingRequest] NOP!");
    }

    public void abortCallerIDRequest() {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#abortCallerIDRequest] NOP!");
    }

    public void requestSetAutomaticEmergencyCallActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetAutomaticEmergencyCallActive] NOP!");
    }

    public void requestSetAutomaticPinEntryActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetAutomaticPinEntryActive] NOP!");
    }

    public void requestSetAutomaticRedialActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetAutomaticRedialActive] NOP!");
    }

    public void requestSetCDMAThreeWayCallingSetting(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetCDMAThreeWayCallingSetting] NOP!");
    }

    public void requestSetEnhancedPrivacyMode(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetEnhancedPrivacyMode] NOP!");
    }

    public void requestSetESIMActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetESIMActive] NOP!");
    }

    public void requestSetHandsFreeMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetHandsFreeMode] NOP!");
    }

    public void requestSetLanguage(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetLanguage] NOP!");
    }

    public void requestSetMailboxContent(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetMailboxContent] NOP!");
    }

    public void requestSetMicGainLevel(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetMicGainLevel] NOP!");
    }

    public void requestSetMICMuteState(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetMICMuteState] NOP!");
    }

    public void requestSetNADMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetNADMode] NOP!");
    }

    public void requestSetOptimizationMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetOptimizationMode] NOP!");
    }

    public void requestSetPhoneRingtone(int n, String string, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetPhoneRingtone] NOP!");
    }

    public void requestSetPrivacyMode(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetPrivacyMode] NOP!");
    }

    public void requestSIMPINRequired(String string, boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSIMPINRequired] NOP!");
    }

    public void requestTelPower(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestTelPower] NOP!");
    }

    public void requestUnlockSIM(int n, String string, String string2, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestUnlockSIM] NOP!");
    }

    public void resetMissedCallIndicator(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#resetMissedCallIndicator] NOP!");
    }

    public void restoreFactorySettings(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#restoreFactorySettings] NOP!");
    }

    public void sendDTMF(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#sendDTMF] NOP!");
    }

    public void splitCall(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#splitCall] NOP!");
    }

    public void swapCalls(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#swapCalls] NOP!");
    }

    public void revertCallstacks(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#revertCallstacks] NOP!");
    }

    public void requestSetPhoneReminderSetting(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(100000, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetPhoneReminderSetting] NOP!");
    }

    public int getDeviceRole() {
        this.log.log(1000000, "[NullTelDSIMobileEquipmentDeviceAccess#getInstanceID] returning ROLE_UNKNOWN");
        return -65536;
    }

    public void setIsNadInstance(boolean bl) {
        this.log.log(1000000, "[NullTelDSIMobileEquipmentDeviceAccess#setIsNadInstance] NOP!");
    }

    public boolean isNadInstance() {
        this.log.log(1000000, "[NullTelDSIMobileEquipmentDeviceAccess#isNadInstance] returning false");
        return false;
    }

    public void setNotification() {
        this.log.log(1000000, "[NullTelDSIMobileEquipmentDeviceAccess#setNotification] NOP!");
    }
}

