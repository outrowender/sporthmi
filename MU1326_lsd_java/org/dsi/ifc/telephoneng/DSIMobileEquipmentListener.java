/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DisconnectReason;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.Favorite;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.NetworkProviderName;
import org.dsi.ifc.telephoneng.PhoneInformation;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public interface DSIMobileEquipmentListener
extends DSIListener {
    public void responseAbortNetworkRegistration(int var1);

    public void responseAbortNetworkSearch(int var1);

    public void responseAcceptCall(int var1);

    public void responseCallForward(CFResponseData[] var1, int var2);

    public void responseCallWaiting(int var1, int var2);

    public void responseChangeSIMCode(int var1, int var2);

    public void responseCLIR(int var1, int var2, int var3);

    public void responseDialNumber(int var1, SuppServiceResponseStruct var2);

    public void responseDialOperator(int var1, SuppServiceResponseStruct var2);

    public void responseSendDTMF(int var1);

    public void updateDTMFTonePlaying(String var1, int var2);

    public void updateEmergencyNumbers(EmergencyNumbers var1, int var2);

    public void responseRemoveOtherSIM(int var1);

    public void responseSIMPINRequired(int var1);

    public void updateOtherSIMAvailable(boolean var1, int var2);

    public void updateSIMPINRequired(boolean var1, int var2);

    public void responseHangupCall(int var1);

    public void responseJoinCalls(int var1);

    public void responseNetworkRegistration(int var1);

    public void responseNetworkSearch(NetworkProvider[] var1, int var2);

    public void responseUnlockOtherSIM(int var1);

    public void responseUnlockSIM(int var1);

    public void responseCheckSIMPINCode(int var1);

    public void responseRestoreFactorySettings(int var1);

    public void responseSetHandsFreeMode(int var1);

    public void responseSetAutomaticPinEntryActive(int var1);

    public void responseSetAutomaticRedialActive(int var1);

    public void responseServiceCodeAbort(int var1);

    public void responseSplitCall(int var1);

    public void responseSwapCalls(int var1);

    public void responseTelPower(int var1);

    public void updateActivationState(ActivationStateStruct var1, int var2);

    public void updateAutomaticPinEntryActive(boolean var1, int var2);

    public void updateAutomaticRedialActive(boolean var1, int var2);

    public void updateBatteryChargeLevel(int var1, int var2);

    public void updateCallDurationList(CallDuration[] var1, int var2);

    public void updateCallList(CallInformation[] var1, int var2);

    public void updateCDMAThreeWayCallingSetting(boolean var1, int var2);

    public void updateCradlePlugInState(int var1, int var2);

    public void updateDisconnectReason(DisconnectReason var1, int var2);

    public void updateEmergencyCallActive(EmergencyCallSetting var1, int var2);

    public void updateEnhancedPrivacyMode(boolean var1, int var2);

    public void updateHandsFreeMode(int var1, int var2);

    public void updateLockState(LockStateStruct var1, int var2);

    public void updateMailboxContent(MailboxDialingNumber[] var1, int var2);

    public void updateMICMuteState(int var1, int var2);

    public void updateNADTemperature(NADTemperatureStruct var1, int var2);

    public void updatePhoneInformation(PhoneInformation var1, int var2);

    public void updateNetworkProvider(NetworkProviderName var1, int var2);

    public void updateNetworkType(int var1, int var2);

    public void updatePrivacyMode(boolean var1, int var2);

    public void updateRegisterState(RegisterStateStruct var1, int var2);

    public void updateServiceCodeType(ServiceCodeTypeStruct var1, int var2);

    public void updateServiceNumbers(ServiceNumbers var1, int var2);

    public void updateSignalQuality(int var1, int var2);

    public void updateSuppServiceResponse(SuppServiceResponseStruct var1, int var2);

    public void updateServiceProvider(ServiceProvider var1, int var2);

    public void updateNADMode(int var1, int var2);

    public void responseSetCDMAThreeWayCallingSetting(int var1);

    public void responseSetAutomaticEmergencyCallActive(int var1);

    public void responseSetMailboxContent(int var1);

    public void responseSetPrivacyMode(int var1);

    public void responseSetSIMAliases(int var1);

    public void responseSetMICMuteState(int var1);

    public void responseSetOptimizationMode(int var1, int var2);

    public void responseSetNADMode(int var1, int var2);

    public void updateMicGainLevel(int var1, int var2);

    public void updateSIMAliasInformation(SIMAliasInformation var1, int var2);

    public void updateOptimizationMode(int var1, int var2);

    public void responseSetPhoneReminderSetting(int var1);

    public void responseSetPrefixActivated(int var1);

    public void responseSetPrefixContent(int var1);

    public void updatePhoneReminderSetting(boolean var1, int var2);

    public void updatePrefixActivated(boolean var1, int var2);

    public void updatePrefixContent(String var1, int var2);

    public void updateWidebandSpeech(boolean var1, int var2);

    public void responseSetPhoneRingtone(int var1);

    public void updatePhoneRingtone(int var1, String var2, int var3);

    public void responseSetFavorites(int var1);

    public void updateFavorites(Favorite[] var1, int var2);

    public void updateSAPUpgradeActive(boolean var1, int var2);

    public void responseSetSIMName(int var1);

    public void responseSetESIMActive(int var1);

    public void updateEUICCID(String var1, int var2);

    public void updateESIMMSISDN(String var1, int var2);

    public void updateESimActive(boolean var1, int var2);

    public void updateESimB2BMode(boolean var1, int var2);

    public void updateCallstacksIsReverted(boolean var1, int var2);

    public void updateLastAnsweredNumbers(CallStackEntry[] var1, int var2);

    public void updateLastDialedNumbers(CallStackEntry[] var1, int var2);

    public void updateMissedNumbers(CallStackEntry[] var1, int var2);

    public void updateMEDataValidity(int var1, int var2);

    public void updateMissedCallIndicator(MissedCallIndicator var1, int var2);

    public void updateSpeechRecognitionAvailable(int var1, int var2);

    public void updateSpeechRecognitionActive(int var1, int var2);

    public void updateSpeechRecognitionType(int var1, int var2);

    public void responseStartSpeechRecognition(int var1);

    public void responseStopSpeechRecognition(int var1);
}

