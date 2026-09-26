/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelTopology;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.atip.interapp.phone.IEcallState;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DisconnectReason;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.NetworkProviderName;
import org.dsi.ifc.telephoneng.PhoneInformation;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public interface IGlobalTelephoneStateStruct {
    default public ActivationStateStruct getActivationState() {
    }

    default public ActivationStateStruct getActivationStateAssociated() {
    }

    default public int getTelMode() {
    }

    default public boolean isAutomaticPinEntryActive() {
    }

    default public boolean isAutomaticRedialActive() {
    }

    default public int getBatteryChargeLevel() {
    }

    default public int getBatteryChargeLevelAssociated() {
    }

    default public boolean isMailboxNumberAvailable() {
    }

    default public boolean isMultipartySupported() {
    }

    default public CallDuration[] getCallDurationList() {
    }

    default public CallInformation[] getCallList() {
    }

    default public CallInformation getCall(int n) {
    }

    default public boolean isCdmaThreeWayCallingSetting() {
    }

    default public int getCradlePlugInState() {
    }

    default public DisconnectReason getDisconnectReason() {
    }

    default public String getDtmfTone() {
    }

    default public EmergencyCallSetting getEmergencyCallActive() {
    }

    default public boolean isEnhancedPrivacyMode() {
    }

    default public int getHandsFreeMode() {
    }

    default public LockStateStruct getLockState() {
    }

    default public LockStateStruct getLockStateAssociated() {
    }

    default public MailboxDialingNumber[] getMailboxContent() {
    }

    default public int getMicGainLevel() {
    }

    default public int getmICMuteState() {
    }

    default public int getNadMode() {
    }

    default public NADTemperatureStruct getnADTemperature() {
    }

    default public NetworkProviderName getNetworkProvider() {
    }

    default public int getNetworkType() {
    }

    default public int getOptimizationMode() {
    }

    default public boolean isOtherSIMAvailable() {
    }

    default public PhoneInformation getPhoneInformation() {
    }

    default public PhoneInformation getPhoneInformationAssociated() {
    }

    default public boolean isPrivacyMode() {
    }

    default public RegisterStateStruct getRegisterState() {
    }

    default public ServiceCodeTypeStruct getServiceCodeType() {
    }

    default public ServiceNumbers getServiceNumbers() {
    }

    default public ServiceProvider getServiceProvider() {
    }

    default public int getSignalQuality() {
    }

    default public SIMAliasInformation getSimAliasInformation() {
    }

    default public boolean isSimPINRequired() {
    }

    default public SuppServiceResponseStruct getSuppServiceResponse() {
    }

    default public EmergencyNumbers getTelEmerNums() {
    }

    default public int getMpCallState() {
    }

    default public CallStateStruct getCallState() {
    }

    default public CallStateStruct getCallStateAssociated() {
    }

    default public CallStateStruct getCallStateData() {
    }

    default public CallStateStruct getCallStateForRole(int n) {
    }

    default public boolean inbandRingingSupported() {
    }

    default public boolean isRejectCallSupported() {
    }

    default public boolean isRejectMobileSupported() {
    }

    default public boolean isResponseAndHoldSupported() {
    }

    default public boolean isThreeWaySupported() {
    }

    default public boolean isEnhancedCallFeaturesSupported() {
    }

    default public boolean isEnhancedStatSupported() {
    }

    default public boolean isAddToConferenceSupported() {
    }

    default public boolean isEnhancedConferenceTransferSupported() {
    }

    default public boolean isAudiServiceAvailable() {
    }

    default public CallStackEntry getLastDialedNumber() {
    }

    default public boolean isCallStackReverted() {
    }

    default public CallStackEntry[] getLastAnsweredNumbers() {
    }

    default public CallStackEntry[] getLastDialedNumbers() {
    }

    default public CallStackEntry[] getMissedNumbers() {
    }

    default public CallStackEntry[] getCombinedCallStackEntries() {
    }

    default public MissedCallIndicator getMissedCallIndicator() {
    }

    default public int getmEDataValidity() {
    }

    default public ActivationStateStruct getActivationStateDSINAD() {
    }

    default public boolean isAutomaticPinEntryActiveDSINAD() {
    }

    default public LockStateStruct getLockStateDSINAD() {
    }

    default public NADTemperatureStruct getnADTemperatureDSINAD() {
    }

    default public PhoneInformation getPhoneInformationDSINAD() {
    }

    default public NetworkProviderName getNetworkProviderDSINAD() {
    }

    default public int getNetworkTypeDSINAD() {
    }

    default public RegisterStateStruct getRegisterStateDSINAD() {
    }

    default public int getSignalQualityDSINAD() {
    }

    default public ServiceProvider getServiceProviderdDSINAD() {
    }

    default public boolean isSimPINRequiredDSINAD() {
    }

    default public int getPhoneModuleState() {
    }

    default public String getDisplayProviderName() {
    }

    default public String getDisplayProviderNameAssociated() {
    }

    default public boolean isEmergencyNumber(String string) {
    }

    default public boolean isMailboxNumber(String string) {
    }

    default public boolean isInfoNumber(String string) {
    }

    default public boolean isBreakdownNumber(String string) {
    }

    default public String getMailboxNumber() {
    }

    default public boolean isPhoneReady() {
    }

    default public boolean hasMissedCalls() {
    }

    default public boolean isDialingPossible() {
    }

    default public boolean isDialNumberPossible(String string) {
    }

    default public boolean isDialSOSNumberPossible(String string) {
    }

    default public boolean isWidebandSpeechActive() {
    }

    default public String getRingtonePath() {
    }

    default public int getRingtoneIndex() {
    }

    default public String getDisplayNetworkName() {
    }

    default public boolean isNewSMSAvailable() {
    }

    default public String getDisplayName(String string, String string2) {
    }

    default public String getDisplayNumber(String string, String string2) {
    }

    default public boolean isSapUpgradeActive() {
    }

    default public boolean isRingtoneMuteActive() {
    }

    default public boolean isRingtoneMuteSettingOn() {
    }

    default public String getDisplayNetworkNameDSINAD() {
    }

    default public String getDisplayNumber(AbstractPhoneCall abstractPhoneCall) {
    }

    default public String getDisplayName(AbstractPhoneCall abstractPhoneCall) {
    }

    default public int getTelModeDSINAD() {
    }

    default public boolean isNewEMailAvailable() {
    }

    default public String getDisplayProviderNameDSINAD() {
    }

    default public boolean isBreakdownCallSupported() {
    }

    default public boolean isInfoCallSupported() {
    }

    default public boolean isEmergencyNumberAvailable() {
    }

    default public String getDisplayProviderNameForDataConnection() {
    }

    default public boolean isESIMB2BModeActive() {
    }

    default public boolean isESIMActive() {
    }

    default public String getESIMMSISDN() {
    }

    default public String getEUICCID() {
    }

    default public IEcallState getConnectedGatewayState() {
    }

    default public ITelDSIMobileEquipmentDeviceState getDataOnlyNadDeviceState() {
    }

    default public ITelDSIMobileEquipmentDeviceState getNadInstanceState() {
    }

    default public ITelDSIMobileEquipmentDeviceState getAssociatedDeviceState() {
    }

    default public ITelDSIMobileEquipmentDeviceState getPrimaryDeviceState() {
    }

    default public int getHandsFreeModeAssociated() {
    }

    default public int getTelModeAssociated() {
    }

    default public int getmICMuteStateAssociated() {
    }

    default public boolean inbandRingingSupportedAssociated() {
    }

    default public boolean isWidebandSpeechActiveAssociated() {
    }

    default public ITelDSIMobileEquipmentDeviceState getCallLeadingDevice() {
    }

    default public ITelDSIMobileEquipmentDeviceState getNonCallLeadingDevice() {
    }

    default public boolean isAutomaticPinEntryActiveAssoicated() {
    }

    default public boolean isOperatorCallViaNadPresent() {
    }

    default public boolean isAcceptIncomingCallOnNonCallLeadingDevicePending() {
    }

    default public ITelTopology getTopology() {
    }

    default public boolean isSimCardInserted() {
    }

    default public boolean isChinaSOSEmergencyNumber(String string) {
    }
}

