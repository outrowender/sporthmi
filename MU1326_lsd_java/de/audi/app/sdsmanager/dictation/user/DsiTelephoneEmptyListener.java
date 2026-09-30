/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.user;

import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.CFResponseData;
import org.dsi.ifc.telephone.CallDuration;
import org.dsi.ifc.telephone.CallInformation;
import org.dsi.ifc.telephone.DSITelephoneListener;
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

class DsiTelephoneEmptyListener
implements DSITelephoneListener {
    DsiTelephoneEmptyListener() {
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void responseAbortNetworkRegistration(int n) {
    }

    public void responseAbortNetworkSearch(int n) {
    }

    public void responseAcceptCall(int n) {
    }

    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    public void responseCallWaiting(int n, int n2) {
    }

    public void responseChangeSIMCode(int n, int n2) {
    }

    public void responseCLIR(int n, int n2, int n3) {
    }

    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    public void responseSendDTMF(int n) {
    }

    public void updateDTMFTonePlaying(String string, int n) {
    }

    public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
    }

    public void responseRemoveOtherSIM(int n) {
    }

    public void responseAbortAlternatePhoneActivity(int n) {
    }

    public void responseTogglePrioritizedPhoneDevice(int n) {
    }

    public void responseSIMPINRequired(int n) {
    }

    public void updateOtherSIMAvailable(boolean bl, int n) {
    }

    public void updateSIMPINRequired(boolean bl, int n) {
    }

    public void responseHangupCall(int n) {
    }

    public void responseJoinCalls(int n) {
    }

    public void responseNetworkRegistration(int n) {
    }

    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    public void responseUnlockOtherSIM(int n) {
    }

    public void responseUnlockSIM(int n) {
    }

    public void responseCheckSIMPINCode(int n) {
    }

    public void responseRestoreFactorySettings(int n) {
    }

    public void responseSetHandsFreeMode(int n) {
    }

    public void responseSetAutomaticPinEntryActive(int n) {
    }

    public void responseSetAutomaticRedialActive(int n) {
    }

    public void responseServiceCodeAbort(int n) {
    }

    public void responseSplitCall(int n) {
    }

    public void responseSwapCalls(int n) {
    }

    public void responseTelPower(int n) {
    }

    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
    }

    public void updateActivationStateAssociated(ActivationStateStruct activationStateStruct, int n) {
    }

    public void updateAutomaticPinEntryActive(boolean bl, int n) {
    }

    public void updateAutomaticRedialActive(boolean bl, int n) {
    }

    public void updateBatteryChargeLevel(int n, int n2) {
    }

    public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
    }

    public void updateCallList(CallInformation[] callInformationArray, int n) {
    }

    public void updateCDMAThreeWayCallingSetting(boolean bl, int n) {
    }

    public void updateCradlePlugInState(int n, int n2) {
    }

    public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
    }

    public void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting, int n) {
    }

    public void updateEnhancedPrivacyMode(boolean bl, int n) {
    }

    public void updateHandsFreeMode(int n, int n2) {
    }

    public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    public void updateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
    }

    public void updateMICMuteState(int n, int n2) {
    }

    public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
    }

    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
    }

    public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
    }

    public void updateNetworkType(int n, int n2) {
    }

    public void updatePrivacyMode(boolean bl, int n) {
    }

    public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
    }

    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
    }

    public void updateSignalQuality(int n, int n2) {
    }

    public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
    }

    public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
    }

    public void updateNADMode(int n, int n2) {
    }

    public void updateAlternatePhoneActivity(boolean bl, int n) {
    }

    public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    public void responseSetMailboxContent(int n) {
    }

    public void responseSetPrivacyMode(int n) {
    }

    public void responseSetSIMAliases(int n) {
    }

    public void responseSetMICMuteState(int n) {
    }

    public void responseSetOptimizationMode(int n, int n2) {
    }

    public void responseSetNADMode(int n, int n2) {
    }

    public void updateMicGainLevel(int n, int n2) {
    }

    public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
    }

    public void updateOptimizationMode(int n, int n2) {
    }

    public void responseSetPhoneReminderSetting(int n) {
    }

    public void responseSetPrefixActivated(int n) {
    }

    public void responseSetPrefixContent(int n) {
    }

    public void updatePhoneReminderSetting(boolean bl, int n) {
    }

    public void updatePrefixActivated(boolean bl, int n) {
    }

    public void updatePrefixContent(String string, int n) {
    }

    public void updateWidebandSpeech(boolean bl, int n) {
    }

    public void responseSetPhoneRingtone(int n) {
    }

    public void updatePhoneRingtone(int n, String string, int n2) {
    }

    public void responseSetFavorites(int n) {
    }

    public void updateFavorites(Favorite[] favoriteArray, int n) {
    }

    public void updateSAPUpgradeActive(boolean bl, int n) {
    }

    public void responseSetSIMName(int n) {
    }

    public void responseSetESIMActive(int n) {
    }

    public void updateEUICCID(String string, int n) {
    }

    public void updateESIMMSISDN(String string, int n) {
    }

    public void updateESimActive(boolean bl, int n) {
    }

    public void updateESimB2BMode(boolean bl, int n) {
    }
}

