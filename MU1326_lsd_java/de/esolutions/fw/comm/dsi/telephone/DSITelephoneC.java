/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephone.CFRequestData;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.MailboxDialingNumber;

public interface DSITelephoneC {
    public void acceptCall(int var1) throws MethodException;

    public void hangupCall(int var1) throws MethodException;

    public void swapCalls() throws MethodException;

    public void splitCall(short var1) throws MethodException;

    public void joinCalls() throws MethodException;

    public void dialNumber(String var1) throws MethodException;

    public void dialOperator(int var1, String var2) throws MethodException;

    public void dialNumberFromDBEntry(String var1, long var2, String var4, short var5, short var6, ResourceLocator var7, int var8, int var9) throws MethodException;

    public void sendDTMF(String var1) throws MethodException;

    public void requestNetworkRegistration(String var1, int var2) throws MethodException;

    public void requestAbortNetworkRegistration() throws MethodException;

    public void requestNetworkSearch() throws MethodException;

    public void requestAbortNetworkSearch() throws MethodException;

    public void requestCallForward(CFRequestData[] var1) throws MethodException;

    public void requestCallWaiting(int var1) throws MethodException;

    public void requestCLIR(int var1) throws MethodException;

    public void requestServiceCodeAbort() throws MethodException;

    public void requestSetAutomaticPinEntryActive(boolean var1) throws MethodException;

    public void requestSetAutomaticRedialActive(boolean var1) throws MethodException;

    public void requestSetCDMAThreeWayCallingSetting(boolean var1) throws MethodException;

    public void requestSetAutomaticEmergencyCallActive(boolean var1) throws MethodException;

    public void requestSetEnhancedPrivacyMode(boolean var1) throws MethodException;

    public void requestSetMailboxContent(MailboxDialingNumber[] var1) throws MethodException;

    public void requestSetPrivacyMode(boolean var1) throws MethodException;

    public void requestTelPower(int var1) throws MethodException;

    public void requestUnlockSIM(int var1, String var2, String var3) throws MethodException;

    public void requestCheckSIMPINCode(String var1) throws MethodException;

    public void requestChangeSIMCode(int var1, String var2, String var3) throws MethodException;

    public void requestSetHandsFreeMode(int var1) throws MethodException;

    public void requestSetMICMuteState(int var1) throws MethodException;

    public void requestSetLanguage(String var1) throws MethodException;

    public void requestSIMPINRequired(String var1, boolean var2) throws MethodException;

    public void restoreFactorySettings() throws MethodException;

    public void requestSetMicGainLevel(int var1) throws MethodException;

    public void requestDecreaseMicGainLevel(short var1) throws MethodException;

    public void requestIncreaseMicGainLevel(short var1) throws MethodException;

    public void requestSetOptimizationMode(int var1) throws MethodException;

    public void requestUnlockOtherSIM(int var1, String var2) throws MethodException;

    public void requestSetSIMAliases(String var1, String var2) throws MethodException;

    public void requestSetNADMode(int var1) throws MethodException;

    public void requestRemoveOtherSIM() throws MethodException;

    public void requestAbortAlternatePhoneActivity() throws MethodException;

    public void requestTogglePrioritizedPhoneDevice() throws MethodException;

    public void requestSetPhoneReminderSetting(boolean var1) throws MethodException;

    public void requestSetPrefixActivated(boolean var1) throws MethodException;

    public void requestSetPrefixContent(String var1) throws MethodException;

    public void requestSetPhoneRingtone(int var1, String var2) throws MethodException;

    public void requestSetFavorites(Favorite[] var1) throws MethodException;

    public void requestSetSIMName(String var1) throws MethodException;

    public void requestSetESIMActive(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

