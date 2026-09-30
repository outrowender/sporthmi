/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.CFResponseData;
import org.dsi.ifc.telephone.CallDuration;
import org.dsi.ifc.telephone.CallInformation;
import org.dsi.ifc.telephone.DisconnectReason;
import org.dsi.ifc.telephone.EmergencyCallSetting;
import org.dsi.ifc.telephone.EmergencyNumbers;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.MailboxDialingNumber;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.SIMAliasInformation;
import org.dsi.ifc.telephone.ServiceCodeTypeStruct;
import org.dsi.ifc.telephone.ServiceNumbers;
import org.dsi.ifc.telephone.ServiceProvider;
import org.dsi.ifc.telephone.SuppServiceResponseStruct;

public interface DSITelephoneReply {
    public static final String IPL_COMM_UUID = "25f12cfd-9271-53a9-85ac-a32c7e22c883";
    public static final String IPL_COMM_INTERFACE_KEY = "e93a466b-517c-5536-8f06-34a36a204a42";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.27";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.27";

    public void responseAbortNetworkRegistration(int var1) throws MethodException;

    public void responseAbortNetworkSearch(int var1) throws MethodException;

    public void responseAcceptCall(int var1) throws MethodException;

    public void responseCallForward(CFResponseData[] var1, int var2) throws MethodException;

    public void responseCallWaiting(int var1, int var2) throws MethodException;

    public void responseChangeSIMCode(int var1, int var2) throws MethodException;

    public void responseCLIR(int var1, int var2, int var3) throws MethodException;

    public void responseDialNumber(int var1, SuppServiceResponseStruct var2) throws MethodException;

    public void responseDialOperator(int var1, SuppServiceResponseStruct var2) throws MethodException;

    public void responseSendDTMF(int var1) throws MethodException;

    public void updateDTMFTonePlaying(String var1, int var2) throws MethodException;

    public void updateEmergencyNumbers(EmergencyNumbers var1, int var2) throws MethodException;

    public void responseRemoveOtherSIM(int var1) throws MethodException;

    public void responseAbortAlternatePhoneActivity(int var1) throws MethodException;

    public void responseTogglePrioritizedPhoneDevice(int var1) throws MethodException;

    public void responseSIMPINRequired(int var1) throws MethodException;

    public void updateOtherSIMAvailable(boolean var1, int var2) throws MethodException;

    public void updateSIMPINRequired(boolean var1, int var2) throws MethodException;

    public void responseHangupCall(int var1) throws MethodException;

    public void responseJoinCalls(int var1) throws MethodException;

    public void responseNetworkRegistration(int var1) throws MethodException;

    public void responseNetworkSearch(NetworkProvider[] var1, int var2) throws MethodException;

    public void responseUnlockOtherSIM(int var1) throws MethodException;

    public void responseUnlockSIM(int var1) throws MethodException;

    public void responseCheckSIMPINCode(int var1) throws MethodException;

    public void responseRestoreFactorySettings(int var1) throws MethodException;

    public void responseSetHandsFreeMode(int var1) throws MethodException;

    public void responseSetAutomaticPinEntryActive(int var1) throws MethodException;

    public void responseSetAutomaticRedialActive(int var1) throws MethodException;

    public void responseServiceCodeAbort(int var1) throws MethodException;

    public void responseSplitCall(int var1) throws MethodException;

    public void responseSwapCalls(int var1) throws MethodException;

    public void responseTelPower(int var1) throws MethodException;

    public void updateActivationState(ActivationStateStruct var1, int var2) throws MethodException;

    public void updateActivationStateAssociated(ActivationStateStruct var1, int var2) throws MethodException;

    public void updateAutomaticPinEntryActive(boolean var1, int var2) throws MethodException;

    public void updateAutomaticRedialActive(boolean var1, int var2) throws MethodException;

    public void updateBatteryChargeLevel(int var1, int var2) throws MethodException;

    public void updateCallDurationList(CallDuration[] var1, int var2) throws MethodException;

    public void updateCallList(CallInformation[] var1, int var2) throws MethodException;

    public void updateCDMAThreeWayCallingSetting(boolean var1, int var2) throws MethodException;

    public void updateCradlePlugInState(int var1, int var2) throws MethodException;

    public void updateDisconnectReason(DisconnectReason var1, int var2) throws MethodException;

    public void updateEmergencyCallActive(EmergencyCallSetting var1, int var2) throws MethodException;

    public void updateEnhancedPrivacyMode(boolean var1, int var2) throws MethodException;

    public void updateHandsFreeMode(int var1, int var2) throws MethodException;

    public void updateLockState(LockStateStruct var1, int var2) throws MethodException;

    public void updateMailboxContent(MailboxDialingNumber[] var1, int var2) throws MethodException;

    public void updateMICMuteState(int var1, int var2) throws MethodException;

    public void updateNADTemperature(NADTemperatureStruct var1, int var2) throws MethodException;

    public void updatePhoneInformation(PhoneInformation var1, int var2) throws MethodException;

    public void updateNetworkProvider(NetworkProviderName var1, int var2) throws MethodException;

    public void updateNetworkType(int var1, int var2) throws MethodException;

    public void updatePrivacyMode(boolean var1, int var2) throws MethodException;

    public void updateRegisterState(RegisterStateStruct var1, int var2) throws MethodException;

    public void updateServiceCodeType(ServiceCodeTypeStruct var1, int var2) throws MethodException;

    public void updateServiceNumbers(ServiceNumbers var1, int var2) throws MethodException;

    public void updateSignalQuality(int var1, int var2) throws MethodException;

    public void updateSuppServiceResponse(SuppServiceResponseStruct var1, int var2) throws MethodException;

    public void updateServiceProvider(ServiceProvider var1, int var2) throws MethodException;

    public void updateNADMode(int var1, int var2) throws MethodException;

    public void updateAlternatePhoneActivity(boolean var1, int var2) throws MethodException;

    public void responseSetCDMAThreeWayCallingSetting(int var1) throws MethodException;

    public void responseSetAutomaticEmergencyCallActive(int var1) throws MethodException;

    public void responseSetMailboxContent(int var1) throws MethodException;

    public void responseSetPrivacyMode(int var1) throws MethodException;

    public void responseSetSIMAliases(int var1) throws MethodException;

    public void responseSetMICMuteState(int var1) throws MethodException;

    public void responseSetOptimizationMode(int var1, int var2) throws MethodException;

    public void responseSetNADMode(int var1, int var2) throws MethodException;

    public void updateMicGainLevel(int var1, int var2) throws MethodException;

    public void updateSIMAliasInformation(SIMAliasInformation var1, int var2) throws MethodException;

    public void updateOptimizationMode(int var1, int var2) throws MethodException;

    public void responseSetPhoneReminderSetting(int var1) throws MethodException;

    public void responseSetPrefixActivated(int var1) throws MethodException;

    public void responseSetPrefixContent(int var1) throws MethodException;

    public void updatePhoneReminderSetting(boolean var1, int var2) throws MethodException;

    public void updatePrefixActivated(boolean var1, int var2) throws MethodException;

    public void updatePrefixContent(String var1, int var2) throws MethodException;

    public void updateWidebandSpeech(boolean var1, int var2) throws MethodException;

    public void responseSetPhoneRingtone(int var1) throws MethodException;

    public void updatePhoneRingtone(int var1, String var2, int var3) throws MethodException;

    public void responseSetFavorites(int var1) throws MethodException;

    public void updateFavorites(Favorite[] var1, int var2) throws MethodException;

    public void updateSAPUpgradeActive(boolean var1, int var2) throws MethodException;

    public void responseSetSIMName(int var1) throws MethodException;

    public void responseSetESIMActive(int var1) throws MethodException;

    public void updateEUICCID(String var1, int var2) throws MethodException;

    public void updateESIMMSISDN(String var1, int var2) throws MethodException;

    public void updateESimActive(boolean var1, int var2) throws MethodException;

    public void updateESimB2BMode(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

