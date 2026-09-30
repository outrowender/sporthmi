/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.Favorite;

public interface ITelDSIMobileEquipmentRequestWrapper {
    public void acceptCall(int var1);

    public void hangupCall(int var1);

    public void swapCalls();

    public void splitCall(short var1);

    public void joinCalls();

    public void dialNumber(String var1);

    public void dialOperator(int var1, String var2);

    public void dialNumberFromDBEntry(String var1, long var2, String var4, short var5, short var6, ResourceLocator var7, int var8, int var9);

    public void sendDTMF(String var1);

    public void requestNetworkRegistration(String var1, int var2);

    public void requestAbortNetworkRegistration();

    public void requestNetworkSearch();

    public void requestAbortNetworkSearch();

    public void requestCallForward(CFRequestData[] var1);

    public void requestCallWaiting(int var1);

    public void requestCLIR(int var1);

    public void requestServiceCodeAbort();

    public void requestSetAutomaticPinEntryActive(boolean var1);

    public void requestSetAutomaticRedialActive(boolean var1);

    public void requestSetCDMAThreeWayCallingSetting(boolean var1);

    public void requestSetAutomaticEmergencyCallActive(boolean var1);

    public void requestSetEnhancedPrivacyMode(boolean var1);

    public void requestSetMailboxContent(String var1);

    public void requestSetPrivacyMode(boolean var1);

    public void requestTelPower(int var1);

    public void requestUnlockSIM(int var1, String var2, String var3);

    public void requestCheckSIMPINCode(String var1);

    public void requestChangeSIMCode(int var1, String var2, String var3);

    public void requestSetHandsFreeMode(int var1);

    public void requestSetMICMuteState(int var1);

    public void requestSetLanguage(String var1);

    public void requestSIMPINRequired(String var1, boolean var2);

    public void restoreFactorySettings();

    public void requestSetMicGainLevel(int var1);

    public void requestDecreaseMicGainLevel(short var1);

    public void requestIncreaseMicGainLevel(short var1);

    public void requestSetOptimizationMode(int var1);

    public void requestUnlockOtherSIM(int var1, String var2);

    public void requestSetSIMAliases(String var1, String var2);

    public void requestSetNADMode(int var1);

    public void requestRemoveOtherSIM();

    public void requestSetPhoneReminderSetting(boolean var1);

    public void requestSetPrefixActivated(boolean var1);

    public void requestSetPrefixContent(String var1);

    public void requestSetPhoneRingtone(int var1, String var2);

    public void requestSetFavorites(Favorite[] var1);

    public void requestSetSIMName(String var1);

    public void requestSetESIMActive(boolean var1);

    public void deleteCallstacksAll(int var1);

    public void deleteCallstacksEntry(int var1, int var2);

    public void resetMissedCallIndicator();

    public void revertCallstacks(boolean var1);

    public boolean isDSIAvailable();
}

