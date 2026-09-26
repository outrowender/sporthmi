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

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public int getInstanceID() {
        this.log.log(1078071040, "[NullTelDSIMobileEquipmentDeviceAccess#getInstanceID] returning -1");
        return -1;
    }

    @Override
    public void setDeviceRole(int n) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#setDeviceRole] NOP!");
    }

    @Override
    public void acceptCall(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#acceptCall] NOP!");
    }

    @Override
    public void deleteCallstacksAll(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#deleteCallstacksAll] NOP!");
    }

    @Override
    public void deleteCallstacksEntry(int n, int n2, boolean bl, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#deleteCallstacksEntry] NOP!");
    }

    @Override
    public void dialSOSNumber(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#dialSOSNumber] NOP!");
    }

    @Override
    public void dialNumber(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#dialNumber] NOP!");
    }

    @Override
    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, boolean bl, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#dialNumberFromDBEntry] NOP!");
    }

    @Override
    public void dialOperator(int n, String string, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#dialOperator] NOP!");
    }

    @Override
    public void hangupCall(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#hangupCall] NOP!");
    }

    @Override
    public void joinCalls(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#joinCalls] NOP!");
    }

    @Override
    public void requestAbortNetworkRegistration() {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestAbortNetworkRegistration] NOP!");
    }

    @Override
    public void requestAbortNetworkSearch() {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestAbortNetworkSearch] NOP!");
    }

    @Override
    public void requestCallForward(CFRequestData[] cFRequestDataArray, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestCallForward] NOP!");
    }

    @Override
    public void requestCallWaiting(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestCallWaiting] NOP!");
    }

    @Override
    public void requestChangeSIMCode(int n, String string, String string2, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestChangeSIMCode] NOP!");
    }

    @Override
    public void requestCLIR(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestCLIR] NOP!");
    }

    @Override
    public void requestDecreaseMicGainLevel(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestDecreaseMicGainLevel] NOP!");
    }

    @Override
    public void requestIncreaseMicGainLevel(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestIncreaseMicGainLevel] NOP!");
    }

    @Override
    public void requestNetworkRegistration(String string, int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestNetworkRegistration] NOP!");
    }

    @Override
    public void requestNetworkSearch(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestNetworkSearch] NOP!");
    }

    @Override
    public void abortCallForwardRequest() {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#abortCallForwardRequest] NOP!");
    }

    @Override
    public void abortCallWaitingRequest() {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#abortCallWaitingRequest] NOP!");
    }

    @Override
    public void abortCallerIDRequest() {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#abortCallerIDRequest] NOP!");
    }

    @Override
    public void requestSetAutomaticEmergencyCallActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetAutomaticEmergencyCallActive] NOP!");
    }

    @Override
    public void requestSetAutomaticPinEntryActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetAutomaticPinEntryActive] NOP!");
    }

    @Override
    public void requestSetAutomaticRedialActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetAutomaticRedialActive] NOP!");
    }

    @Override
    public void requestSetCDMAThreeWayCallingSetting(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetCDMAThreeWayCallingSetting] NOP!");
    }

    @Override
    public void requestSetEnhancedPrivacyMode(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetEnhancedPrivacyMode] NOP!");
    }

    @Override
    public void requestSetESIMActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetESIMActive] NOP!");
    }

    @Override
    public void requestSetHandsFreeMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetHandsFreeMode] NOP!");
    }

    @Override
    public void requestSetLanguage(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetLanguage] NOP!");
    }

    @Override
    public void requestSetMailboxContent(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetMailboxContent] NOP!");
    }

    @Override
    public void requestSetMicGainLevel(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetMicGainLevel] NOP!");
    }

    @Override
    public void requestSetMICMuteState(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetMICMuteState] NOP!");
    }

    @Override
    public void requestSetNADMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetNADMode] NOP!");
    }

    @Override
    public void requestSetOptimizationMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetOptimizationMode] NOP!");
    }

    @Override
    public void requestSetPhoneRingtone(int n, String string, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetPhoneRingtone] NOP!");
    }

    @Override
    public void requestSetPrivacyMode(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetPrivacyMode] NOP!");
    }

    @Override
    public void requestSIMPINRequired(String string, boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSIMPINRequired] NOP!");
    }

    @Override
    public void requestTelPower(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestTelPower] NOP!");
    }

    @Override
    public void requestUnlockSIM(int n, String string, String string2, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestUnlockSIM] NOP!");
    }

    @Override
    public void resetMissedCallIndicator(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#resetMissedCallIndicator] NOP!");
    }

    @Override
    public void restoreFactorySettings(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#restoreFactorySettings] NOP!");
    }

    @Override
    public void sendDTMF(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#sendDTMF] NOP!");
    }

    @Override
    public void splitCall(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#splitCall] NOP!");
    }

    @Override
    public void swapCalls(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#swapCalls] NOP!");
    }

    @Override
    public void revertCallstacks(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#revertCallstacks] NOP!");
    }

    @Override
    public void requestSetPhoneReminderSetting(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        this.log.log(-1601830656, "[NullTelDSIMobileEquipmentDeviceAccess#requestSetPhoneReminderSetting] NOP!");
    }

    @Override
    public int getDeviceRole() {
        this.log.log(1078071040, "[NullTelDSIMobileEquipmentDeviceAccess#getInstanceID] returning ROLE_UNKNOWN");
        return 65535;
    }

    @Override
    public void setIsNadInstance(boolean bl) {
        this.log.log(1078071040, "[NullTelDSIMobileEquipmentDeviceAccess#setIsNadInstance] NOP!");
    }

    @Override
    public boolean isNadInstance() {
        this.log.log(1078071040, "[NullTelDSIMobileEquipmentDeviceAccess#isNadInstance] returning false");
        return false;
    }

    @Override
    public void setNotification() {
        this.log.log(1078071040, "[NullTelDSIMobileEquipmentDeviceAccess#setNotification] NOP!");
    }
}

