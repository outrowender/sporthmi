/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.CallStackEntry;

public interface ITelephoneDSIAccess {
    public static final int ROLE_PRIMARY;
    public static final int ROLE_ASSOCIATED;
    public static final int ROLE_DATA;
    public static final boolean USE_DEFAULT_ERROR_HANDLING;
    public static final boolean DO_NOT_USE_DEFAULT_ERROR_HANDLING;

    default public void acceptCall(int n) {
    }

    default public void acceptCall(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void acceptWaitingCallReplaceActiveCall(int n) {
    }

    default public void acceptWaitingCallReplaceActiveCall(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void placeIncomingCallOnHold(int n) {
    }

    default public void placeIncomingCallOnHold(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialNumber(String string, int n) {
    }

    default public void dialChinaSOSNumber(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialNumber(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3) {
    }

    default public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n) {
    }

    default public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2) {
    }

    default public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void hangupCall(int n, int n2) {
    }

    default public void hangupCall(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void hangupCall(int n, int n2, int n3, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void splitCall(int n, int n2) {
    }

    default public void splitCall(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void unlockSIMWithPIN(String string, int n) {
    }

    default public void unlockSIMWithPIN(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void unlockSIMWithPUK(String string, String string2, int n) {
    }

    default public void unlockSIMWithPUK(String string, String string2, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void setAutomaticPINEntryActive(boolean bl, int n) {
    }

    default public void setAutomaticPINEntryActive(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void swapCalls(int n) {
    }

    default public void swapCalls(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void joinCallsToConference(int n) {
    }

    default public void joinCallsToConference(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void sendDTMF(String string, int n) {
    }

    default public void sendDTMF(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetOptimizationMode(int n, int n2) {
    }

    default public void requestSetOptimizationMode(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void restoreFactorySettings(int n) {
    }

    default public void restoreFactorySettings(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSIMPINRequired(String string, boolean bl, int n) {
    }

    default public void requestSIMPINRequired(String string, boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetLanguage(String string, int n) {
    }

    default public void requestSetLanguage(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetMICMuteState(int n, int n2) {
    }

    default public void requestSetMICMuteState(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetHandsFreeMode(int n, int n2) {
    }

    default public void requestSetHandsFreeMode(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetMailboxNumber(String string, int n) {
    }

    default public void requestSetMailboxNumber(String string, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestTelPower(int n, int n2) {
    }

    default public void requestTelPower(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetNadMode(int n, int n2) {
    }

    default public void requestSetNadMode(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestNetworkRegistration(String string, int n, int n2) {
    }

    default public void requestNetworkRegistration(String string, int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestAbortNetworkRegistration() {
    }

    default public void requestNetworkSearch(int n) {
    }

    default public void requestNetworkSearch(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestAbortNetworkSearch() {
    }

    default public void requestCallForward(CFRequestData[] cFRequestDataArray, int n) {
    }

    default public void requestCallForward(CFRequestData[] cFRequestDataArray, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void abortCallForwardRequest() {
    }

    default public void requestCallWaiting(int n, int n2) {
    }

    default public void requestCallWaiting(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void abortCallWaitingRequest() {
    }

    default public void requestCLIR(int n, int n2) {
    }

    default public void requestCLIR(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetCDMAThreeWayCallingSetting(boolean bl, int n) {
    }

    default public void requestSetCDMAThreeWayCallingSetting(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetAutomaticEmergencyCallActive(boolean bl, int n) {
    }

    default public void requestSetAutomaticEmergencyCallActive(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestChangeSIMCode(String string, String string2, int n) {
    }

    default public void requestChangeSIMCode(String string, String string2, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialOperator(String string, int n, int n2) {
    }

    default public void dialOperator(String string, int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void abortCallerIDRequest() {
    }

    default public void requestSetPhoneRingtone(int n, String string, int n2) {
    }

    default public void requestSetPhoneRingtone(int n, String string, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetMicGainLevel(int n, int n2) {
    }

    default public void requestIncreaseMicGainLevel(short s, int n) {
    }

    default public void requestDecreaseMicGainLevel(short s, int n) {
    }

    default public void requestSetESIMActive(boolean bl, int n) {
    }

    default public void requestSetPhoneReminderSetting(boolean bl, int n) {
    }

    default public void requestSetPhoneReminderSetting(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetESIMActive(boolean bl, int n, boolean bl2, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void deleteAllCallStacks(int n, int n2) {
    }

    default public void deleteCallStackEntry(int n, int n2, int n3) {
    }

    default public void resetMissedCallIndicator(int n) {
    }

    default public void revertCallstacks(boolean bl, int n) {
    }

    default public void togglePhones(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void removeGlobalDSIResponseListener(ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void addGlobalDSIResponseListener(ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void acceptIncomingCallOnNonCallLeadingDevice(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void rejectIncomingCallOnNonCallLeadingDevice(int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void rejectIncomingCallOnNonCallLeadingDevice(int n) {
    }

    default public void acceptIncomingCallOnNonCallLeadingDevice(int n) {
    }

    default public void requestSetHandsFreeModeNonCallLeadingDevice(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetHandsFreeModeNonCallLeadingDevice(int n, int n2) {
    }

    default public void requestSetHandsFreeModeCallLeadingDevice(int n, int n2, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void requestSetHandsFreeModeCallLeadingDevice(int n, int n2) {
    }

    default public void requestSetNadRole(int n, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
    }
}

