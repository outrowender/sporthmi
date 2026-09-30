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
    public static final int ROLE_PRIMARY = 65536;
    public static final int ROLE_ASSOCIATED = 131072;
    public static final int ROLE_DATA = 196608;
    public static final boolean USE_DEFAULT_ERROR_HANDLING = true;
    public static final boolean DO_NOT_USE_DEFAULT_ERROR_HANDLING = false;

    public void acceptCall(int var1);

    public void acceptCall(int var1, boolean var2, ITelDSIResponseListener var3);

    public void acceptWaitingCallReplaceActiveCall(int var1);

    public void acceptWaitingCallReplaceActiveCall(int var1, boolean var2, ITelDSIResponseListener var3);

    public void placeIncomingCallOnHold(int var1);

    public void placeIncomingCallOnHold(int var1, boolean var2, ITelDSIResponseListener var3);

    public void dialNumber(String var1, int var2);

    public void dialChinaSOSNumber(String var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void dialNumber(String var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void dialNumberFromDBEntry(String var1, long var2, String var4, short var5, short var6, ResourceLocator var7, int var8, int var9, int var10);

    public void dialNumberFromDBEntry(String var1, long var2, String var4, short var5, short var6, ResourceLocator var7, int var8, int var9, int var10, boolean var11, ITelDSIResponseListener var12);

    public void dialNumberFromCallStackEntry(CallStackEntry var1, int var2);

    public void dialNumberFromCallStackEntry(CallStackEntry var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void dialNumberFromADBEntry(AdbEntry var1, int var2, int var3);

    public void dialNumberFromADBEntry(AdbEntry var1, int var2, int var3, boolean var4, ITelDSIResponseListener var5);

    public void hangupCall(int var1, int var2);

    public void hangupCall(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void hangupCall(int var1, int var2, int var3, boolean var4, ITelDSIResponseListener var5);

    public void splitCall(int var1, int var2);

    public void splitCall(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void unlockSIMWithPIN(String var1, int var2);

    public void unlockSIMWithPIN(String var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void unlockSIMWithPUK(String var1, String var2, int var3);

    public void unlockSIMWithPUK(String var1, String var2, int var3, boolean var4, ITelDSIResponseListener var5);

    public void setAutomaticPINEntryActive(boolean var1, int var2);

    public void setAutomaticPINEntryActive(boolean var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void swapCalls(int var1);

    public void swapCalls(int var1, boolean var2, ITelDSIResponseListener var3);

    public void joinCallsToConference(int var1);

    public void joinCallsToConference(int var1, boolean var2, ITelDSIResponseListener var3);

    public void sendDTMF(String var1, int var2);

    public void sendDTMF(String var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetOptimizationMode(int var1, int var2);

    public void requestSetOptimizationMode(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void restoreFactorySettings(int var1);

    public void restoreFactorySettings(int var1, boolean var2, ITelDSIResponseListener var3);

    public void requestSIMPINRequired(String var1, boolean var2, int var3);

    public void requestSIMPINRequired(String var1, boolean var2, int var3, boolean var4, ITelDSIResponseListener var5);

    public void requestSetLanguage(String var1, int var2);

    public void requestSetLanguage(String var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetMICMuteState(int var1, int var2);

    public void requestSetMICMuteState(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetHandsFreeMode(int var1, int var2);

    public void requestSetHandsFreeMode(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetMailboxNumber(String var1, int var2);

    public void requestSetMailboxNumber(String var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestTelPower(int var1, int var2);

    public void requestTelPower(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetNadMode(int var1, int var2);

    public void requestSetNadMode(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestNetworkRegistration(String var1, int var2, int var3);

    public void requestNetworkRegistration(String var1, int var2, int var3, boolean var4, ITelDSIResponseListener var5);

    public void requestAbortNetworkRegistration();

    public void requestNetworkSearch(int var1);

    public void requestNetworkSearch(int var1, boolean var2, ITelDSIResponseListener var3);

    public void requestAbortNetworkSearch();

    public void requestCallForward(CFRequestData[] var1, int var2);

    public void requestCallForward(CFRequestData[] var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void abortCallForwardRequest();

    public void requestCallWaiting(int var1, int var2);

    public void requestCallWaiting(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void abortCallWaitingRequest();

    public void requestCLIR(int var1, int var2);

    public void requestCLIR(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetCDMAThreeWayCallingSetting(boolean var1, int var2);

    public void requestSetCDMAThreeWayCallingSetting(boolean var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetAutomaticEmergencyCallActive(boolean var1, int var2);

    public void requestSetAutomaticEmergencyCallActive(boolean var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestChangeSIMCode(String var1, String var2, int var3);

    public void requestChangeSIMCode(String var1, String var2, int var3, boolean var4, ITelDSIResponseListener var5);

    public void dialOperator(String var1, int var2, int var3);

    public void dialOperator(String var1, int var2, boolean var3, int var4, ITelDSIResponseListener var5);

    public void abortCallerIDRequest();

    public void requestSetPhoneRingtone(int var1, String var2, int var3);

    public void requestSetPhoneRingtone(int var1, String var2, int var3, boolean var4, ITelDSIResponseListener var5);

    public void requestSetMicGainLevel(int var1, int var2);

    public void requestIncreaseMicGainLevel(short var1, int var2);

    public void requestDecreaseMicGainLevel(short var1, int var2);

    public void requestSetESIMActive(boolean var1, int var2);

    public void requestSetPhoneReminderSetting(boolean var1, int var2);

    public void requestSetPhoneReminderSetting(boolean var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetESIMActive(boolean var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void deleteAllCallStacks(int var1, int var2);

    public void deleteCallStackEntry(int var1, int var2, int var3);

    public void resetMissedCallIndicator(int var1);

    public void revertCallstacks(boolean var1, int var2);

    public void togglePhones(int var1, boolean var2, ITelDSIResponseListener var3);

    public void removeGlobalDSIResponseListener(ITelDSIResponseListener var1);

    public void addGlobalDSIResponseListener(ITelDSIResponseListener var1);

    public void acceptIncomingCallOnNonCallLeadingDevice(int var1, boolean var2, ITelDSIResponseListener var3);

    public void rejectIncomingCallOnNonCallLeadingDevice(int var1, boolean var2, ITelDSIResponseListener var3);

    public void rejectIncomingCallOnNonCallLeadingDevice(int var1);

    public void acceptIncomingCallOnNonCallLeadingDevice(int var1);

    public void requestSetHandsFreeModeNonCallLeadingDevice(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetHandsFreeModeNonCallLeadingDevice(int var1, int var2);

    public void requestSetHandsFreeModeCallLeadingDevice(int var1, int var2, boolean var3, ITelDSIResponseListener var4);

    public void requestSetHandsFreeModeCallLeadingDevice(int var1, int var2);

    public void requestSetNadRole(int var1, int var2, ITelDSIResponseListener var3);
}

