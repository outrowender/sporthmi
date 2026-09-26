/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.atip.interapp.phone.ITelMESlotState;
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

public interface ITelDSIMobileEquipmentDeviceState {
    default public ActivationStateStruct getActivationState() {
    }

    default public boolean isAutomaticPinEntryActive() {
    }

    default public boolean isAutomaticRedialActive() {
    }

    default public int getBatteryChargeLevel() {
    }

    default public CallDuration[] getCallDurationList() {
    }

    default public CallInformation[] getCallList() {
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

    default public CallStateStruct getCallState() {
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

    default public boolean isWidebandSpeechActive() {
    }

    default public int getRingtoneIndex() {
    }

    default public String getRingtonePath() {
    }

    default public boolean isSapUpgradeActive() {
    }

    default public boolean isRingtoneMuteSettingOn() {
    }

    default public boolean isRingtoneMuteActive() {
    }

    default public String geteUICCID() {
    }

    default public String geteSIMMSISDN() {
    }

    default public boolean iseSIMActive() {
    }

    default public boolean iseSIMB2BModeActive() {
    }

    default public int getDeviceRole() {
    }

    default public int getInstanceID() {
    }

    default public boolean isCallStacksReverted() {
    }

    default public boolean isPhoneReminderSetting() {
    }

    default public boolean isPrefixActivated() {
    }

    default public String getPrefixContent() {
    }

    default public boolean isMailboxNumberAvailable() {
    }

    default public boolean isEmergencyNumberAvailable() {
    }

    default public String getDisplayNumber(AbstractPhoneCall abstractPhoneCall) {
    }

    default public String getDisplayName(AbstractPhoneCall abstractPhoneCall) {
    }

    default public String getDisplayNumber(String string, String string2) {
    }

    default public String getDisplayName(String string, String string2) {
    }

    default public boolean isDialingPossible() {
    }

    default public boolean hasMissedCalls() {
    }

    default public boolean isPhoneReady() {
    }

    default public String getMailboxNumber() {
    }

    default public boolean isBreakdownNumber(String string) {
    }

    default public boolean isInfoNumber(String string) {
    }

    default public boolean isMailboxNumber(String string) {
    }

    default public boolean isEmergencyNumber(String string) {
    }

    default public String getDisplayNetworkName() {
    }

    default public String getDisplayProviderName() {
    }

    default public int getPhoneModuleState() {
    }

    default public int getTelMode() {
    }

    default public CallStackEntry getLastDialedNumber() {
    }

    default public boolean isBreakdownCallSupported() {
    }

    default public boolean isInfoCallSupported() {
    }

    default public boolean isAudiServiceAvailable() {
    }

    default public boolean isEnhancedConferenceTransferSupported() {
    }

    default public boolean isAddToConferenceSupported() {
    }

    default public boolean isEnhancedStatSupported() {
    }

    default public boolean isEnhancedCallFeaturesSupported() {
    }

    default public boolean isThreeWaySupported() {
    }

    default public boolean isResponseAndHoldSupported() {
    }

    default public boolean isRejectMobileSupported() {
    }

    default public boolean isRejectCallSupported() {
    }

    default public boolean inbandRingingSupported() {
    }

    default public CallInformation getCall(int n) {
    }

    default public boolean isMultipartySupported() {
    }

    default public ITelMESlotState getDevice() {
    }

    default public boolean isDialNumberPossible(String string) {
    }

    default public boolean isRoleData() {
    }

    default public boolean isRoleAssociated() {
    }

    default public boolean isRolePrimary() {
    }
}

