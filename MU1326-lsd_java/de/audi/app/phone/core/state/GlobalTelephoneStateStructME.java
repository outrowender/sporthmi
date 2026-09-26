/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.ITelTopology;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
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

public class GlobalTelephoneStateStructME
implements IGlobalTelephoneStateStruct {
    private final ITelDSIMobileEquipmentDeviceState primaryDevice;
    private final ITelDSIMobileEquipmentDeviceState associatedDevice;
    private final ITelDSIMobileEquipmentDeviceState dataOnlyNadDevice;
    private final ITelDSIMobileEquipmentDeviceState callLeadingDevice;
    private final ITelDSIMobileEquipmentDeviceState nonCallLeadingDevice;
    private final ITelDSIMobileEquipmentDeviceState nadInstance;
    private final boolean newSMSAvailable;
    private final boolean newEmailAvailable;
    private final boolean ringtoneMuteActive;
    private final boolean ringtoneMuteSettingOn;
    private final IEcallState ecallState;
    private final int nadMode;
    private final NADTemperatureStruct nadTemp;
    private final EmergencyNumbers telEmerNums;
    private final ServiceNumbers serviceNumbers;
    private final String eUICCID;
    private final String eSIMMSISDN;
    private final boolean eSIMActive;
    private final boolean eSIMB2BMode;
    private final boolean acceptIncomingCallOnNonCallLeadingDevicePending;
    private final ITelTopology topology;

    private static boolean hasOperatorCallViaNad(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && iTelDSIMobileEquipmentDeviceState.getCallState().isHasOperatorCall();
    }

    public GlobalTelephoneStateStructME(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState3, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState4, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState5, boolean bl, boolean bl2, boolean bl3, boolean bl4, IEcallState iEcallState, int n, NADTemperatureStruct nADTemperatureStruct, EmergencyNumbers emergencyNumbers, ServiceNumbers serviceNumbers, String string, String string2, boolean bl5, boolean bl6, int n2, boolean bl7, ITelTopology iTelTopology) {
        this.primaryDevice = iTelDSIMobileEquipmentDeviceState;
        this.associatedDevice = iTelDSIMobileEquipmentDeviceState2;
        this.dataOnlyNadDevice = iTelDSIMobileEquipmentDeviceState3;
        this.callLeadingDevice = iTelDSIMobileEquipmentDeviceState4;
        this.nonCallLeadingDevice = iTelDSIMobileEquipmentDeviceState5;
        this.acceptIncomingCallOnNonCallLeadingDevicePending = bl7;
        this.newSMSAvailable = bl;
        this.newEmailAvailable = bl2;
        this.ringtoneMuteActive = bl3;
        this.ringtoneMuteSettingOn = bl4;
        this.ecallState = iEcallState;
        this.nadMode = n;
        this.nadTemp = nADTemperatureStruct;
        this.telEmerNums = emergencyNumbers;
        this.serviceNumbers = serviceNumbers;
        this.eUICCID = string;
        this.eSIMMSISDN = string2;
        this.eSIMActive = bl5;
        this.eSIMB2BMode = bl6;
        this.topology = iTelTopology;
        this.nadInstance = this.primaryDevice != null && n2 == 0 ? this.primaryDevice : (this.associatedDevice != null && n2 == 1 ? this.associatedDevice : (this.dataOnlyNadDevice != null && n2 == 2 ? this.dataOnlyNadDevice : null));
    }

    @Override
    public ITelDSIMobileEquipmentDeviceState getPrimaryDeviceState() {
        return this.primaryDevice;
    }

    @Override
    public ITelDSIMobileEquipmentDeviceState getAssociatedDeviceState() {
        return this.associatedDevice;
    }

    @Override
    public ITelDSIMobileEquipmentDeviceState getNadInstanceState() {
        return this.nadInstance;
    }

    @Override
    public ITelDSIMobileEquipmentDeviceState getDataOnlyNadDeviceState() {
        return this.dataOnlyNadDevice;
    }

    @Override
    public ITelDSIMobileEquipmentDeviceState getCallLeadingDevice() {
        return this.callLeadingDevice;
    }

    @Override
    public ITelDSIMobileEquipmentDeviceState getNonCallLeadingDevice() {
        return this.nonCallLeadingDevice;
    }

    @Override
    public ActivationStateStruct getActivationState() {
        return this.primaryDevice != null ? this.primaryDevice.getActivationState() : null;
    }

    @Override
    public ActivationStateStruct getActivationStateAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.getActivationState() : null;
    }

    @Override
    public int getTelMode() {
        return this.primaryDevice != null && this.primaryDevice.getActivationState() != null ? this.primaryDevice.getActivationState().getTelMode() : -1;
    }

    @Override
    public boolean isAutomaticPinEntryActive() {
        return this.primaryDevice != null ? this.primaryDevice.isAutomaticPinEntryActive() : false;
    }

    @Override
    public boolean isAutomaticPinEntryActiveAssoicated() {
        return this.associatedDevice != null ? this.associatedDevice.isAutomaticPinEntryActive() : false;
    }

    @Override
    public boolean isAutomaticRedialActive() {
        return this.primaryDevice != null ? this.primaryDevice.isAutomaticRedialActive() : false;
    }

    @Override
    public int getBatteryChargeLevel() {
        return this.primaryDevice != null ? this.primaryDevice.getBatteryChargeLevel() : 255;
    }

    @Override
    public int getBatteryChargeLevelAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.getBatteryChargeLevel() : 255;
    }

    @Override
    public boolean isMailboxNumberAvailable() {
        return this.primaryDevice != null ? this.primaryDevice.isMailboxNumberAvailable() : false;
    }

    @Override
    public boolean isMultipartySupported() {
        return this.primaryDevice != null ? this.primaryDevice.isMultipartySupported() : false;
    }

    @Override
    public CallDuration[] getCallDurationList() {
        return this.primaryDevice != null ? this.primaryDevice.getCallDurationList() : null;
    }

    @Override
    public CallInformation[] getCallList() {
        return this.primaryDevice != null ? this.primaryDevice.getCallList() : null;
    }

    @Override
    public CallInformation getCall(int n) {
        return this.primaryDevice != null ? this.primaryDevice.getCall(n) : null;
    }

    @Override
    public boolean isCdmaThreeWayCallingSetting() {
        return this.primaryDevice != null ? this.primaryDevice.isCdmaThreeWayCallingSetting() : false;
    }

    @Override
    public int getCradlePlugInState() {
        return this.primaryDevice != null ? this.primaryDevice.getCradlePlugInState() : -1;
    }

    @Override
    public DisconnectReason getDisconnectReason() {
        return this.primaryDevice != null ? this.primaryDevice.getDisconnectReason() : null;
    }

    @Override
    public String getDtmfTone() {
        return this.primaryDevice != null ? this.primaryDevice.getDtmfTone() : null;
    }

    @Override
    public EmergencyCallSetting getEmergencyCallActive() {
        return this.primaryDevice != null ? this.primaryDevice.getEmergencyCallActive() : null;
    }

    @Override
    public boolean isEnhancedPrivacyMode() {
        return this.primaryDevice != null ? this.primaryDevice.isEnhancedPrivacyMode() : false;
    }

    @Override
    public int getHandsFreeMode() {
        return this.primaryDevice != null ? this.primaryDevice.getHandsFreeMode() : -1;
    }

    @Override
    public LockStateStruct getLockState() {
        return this.primaryDevice != null ? this.primaryDevice.getLockState() : null;
    }

    @Override
    public LockStateStruct getLockStateAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.getLockState() : null;
    }

    @Override
    public MailboxDialingNumber[] getMailboxContent() {
        return this.primaryDevice != null ? this.primaryDevice.getMailboxContent() : null;
    }

    @Override
    public int getMicGainLevel() {
        return this.primaryDevice != null ? this.primaryDevice.getMicGainLevel() : -1;
    }

    @Override
    public int getmICMuteState() {
        return this.primaryDevice != null ? this.primaryDevice.getmICMuteState() : -1;
    }

    @Override
    public int getNadMode() {
        return this.nadMode;
    }

    @Override
    public NADTemperatureStruct getnADTemperature() {
        return this.nadTemp;
    }

    @Override
    public NetworkProviderName getNetworkProvider() {
        return this.primaryDevice != null ? this.primaryDevice.getNetworkProvider() : null;
    }

    @Override
    public int getNetworkType() {
        return this.primaryDevice != null ? this.primaryDevice.getNetworkType() : -1;
    }

    @Override
    public int getOptimizationMode() {
        return this.primaryDevice != null ? this.primaryDevice.getOptimizationMode() : -1;
    }

    @Override
    public boolean isOtherSIMAvailable() {
        return this.primaryDevice != null ? this.primaryDevice.isOtherSIMAvailable() : false;
    }

    @Override
    public PhoneInformation getPhoneInformation() {
        return this.primaryDevice != null ? this.primaryDevice.getPhoneInformation() : null;
    }

    @Override
    public PhoneInformation getPhoneInformationAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.getPhoneInformation() : null;
    }

    @Override
    public boolean isPrivacyMode() {
        return this.primaryDevice != null ? this.primaryDevice.isPrivacyMode() : false;
    }

    @Override
    public RegisterStateStruct getRegisterState() {
        return this.primaryDevice != null ? this.primaryDevice.getRegisterState() : null;
    }

    @Override
    public ServiceCodeTypeStruct getServiceCodeType() {
        return this.primaryDevice != null ? this.primaryDevice.getServiceCodeType() : null;
    }

    @Override
    public ServiceNumbers getServiceNumbers() {
        return this.serviceNumbers;
    }

    @Override
    public ServiceProvider getServiceProvider() {
        return this.primaryDevice != null ? this.primaryDevice.getServiceProvider() : null;
    }

    @Override
    public int getSignalQuality() {
        return this.primaryDevice != null ? this.primaryDevice.getSignalQuality() : 255;
    }

    @Override
    public SIMAliasInformation getSimAliasInformation() {
        return this.primaryDevice != null ? this.primaryDevice.getSimAliasInformation() : null;
    }

    @Override
    public boolean isSimPINRequired() {
        return this.nadInstance != null ? this.nadInstance.isSimPINRequired() : false;
    }

    @Override
    public SuppServiceResponseStruct getSuppServiceResponse() {
        return this.primaryDevice != null ? this.primaryDevice.getSuppServiceResponse() : null;
    }

    @Override
    public EmergencyNumbers getTelEmerNums() {
        return this.telEmerNums;
    }

    @Override
    public int getMpCallState() {
        return this.primaryDevice != null && this.primaryDevice.getCallState() != null ? this.primaryDevice.getCallState().getMpCallState() : -1;
    }

    @Override
    public CallStateStruct getCallState() {
        return this.primaryDevice != null ? this.primaryDevice.getCallState() : null;
    }

    @Override
    public CallStateStruct getCallStateAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.getCallState() : null;
    }

    @Override
    public CallStateStruct getCallStateData() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getCallState() : null;
    }

    @Override
    public CallStateStruct getCallStateForRole(int n) {
        switch (n) {
            case 65536: {
                return this.getCallState();
            }
            case 131072: {
                return this.getCallStateAssociated();
            }
            case 196608: {
                return this.getCallStateData();
            }
        }
        return null;
    }

    @Override
    public boolean inbandRingingSupported() {
        return this.primaryDevice != null ? this.primaryDevice.inbandRingingSupported() : false;
    }

    @Override
    public boolean isRejectCallSupported() {
        return this.primaryDevice != null ? this.primaryDevice.isRejectCallSupported() : false;
    }

    @Override
    public boolean isRejectMobileSupported() {
        return this.primaryDevice != null ? this.primaryDevice.isRejectMobileSupported() : false;
    }

    @Override
    public boolean isResponseAndHoldSupported() {
        return this.primaryDevice != null ? this.primaryDevice.isResponseAndHoldSupported() : false;
    }

    @Override
    public boolean isThreeWaySupported() {
        return this.primaryDevice != null ? this.primaryDevice.isThreeWaySupported() : false;
    }

    @Override
    public boolean isEnhancedCallFeaturesSupported() {
        return this.primaryDevice != null ? this.primaryDevice.isEnhancedCallFeaturesSupported() : false;
    }

    @Override
    public boolean isEnhancedStatSupported() {
        return this.primaryDevice != null ? this.primaryDevice.isEnhancedStatSupported() : false;
    }

    @Override
    public boolean isAddToConferenceSupported() {
        return this.primaryDevice != null ? this.primaryDevice.isAddToConferenceSupported() : false;
    }

    @Override
    public boolean isEnhancedConferenceTransferSupported() {
        return this.primaryDevice != null ? this.primaryDevice.isEnhancedConferenceTransferSupported() : false;
    }

    @Override
    public boolean isAudiServiceAvailable() {
        return this.isInfoCallSupported() || this.isBreakdownCallSupported();
    }

    @Override
    public CallStackEntry getLastDialedNumber() {
        return this.primaryDevice != null ? this.primaryDevice.getLastDialedNumber() : null;
    }

    @Override
    public boolean isCallStackReverted() {
        return this.primaryDevice != null ? this.primaryDevice.isCallStackReverted() : false;
    }

    @Override
    public CallStackEntry[] getLastAnsweredNumbers() {
        return this.primaryDevice != null ? this.primaryDevice.getLastAnsweredNumbers() : null;
    }

    @Override
    public CallStackEntry[] getLastDialedNumbers() {
        return this.primaryDevice != null ? this.primaryDevice.getLastDialedNumbers() : null;
    }

    @Override
    public CallStackEntry[] getMissedNumbers() {
        return this.primaryDevice != null ? this.primaryDevice.getMissedNumbers() : null;
    }

    @Override
    public CallStackEntry[] getCombinedCallStackEntries() {
        return this.primaryDevice != null ? this.primaryDevice.getCombinedCallStackEntries() : null;
    }

    @Override
    public MissedCallIndicator getMissedCallIndicator() {
        return this.primaryDevice != null ? this.primaryDevice.getMissedCallIndicator() : null;
    }

    @Override
    public int getmEDataValidity() {
        return this.primaryDevice != null ? this.primaryDevice.getmEDataValidity() : -1;
    }

    @Override
    public ActivationStateStruct getActivationStateDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getActivationState() : null;
    }

    @Override
    public boolean isAutomaticPinEntryActiveDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.isAutomaticPinEntryActive() : false;
    }

    @Override
    public LockStateStruct getLockStateDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getLockState() : null;
    }

    @Override
    public NADTemperatureStruct getnADTemperatureDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getnADTemperature() : null;
    }

    @Override
    public PhoneInformation getPhoneInformationDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getPhoneInformation() : null;
    }

    @Override
    public NetworkProviderName getNetworkProviderDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getNetworkProvider() : null;
    }

    @Override
    public int getNetworkTypeDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getNetworkType() : -1;
    }

    @Override
    public RegisterStateStruct getRegisterStateDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getRegisterState() : null;
    }

    @Override
    public int getSignalQualityDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getSignalQuality() : 255;
    }

    @Override
    public ServiceProvider getServiceProviderdDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getServiceProvider() : null;
    }

    @Override
    public boolean isSimPINRequiredDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.isSimPINRequired() : false;
    }

    @Override
    public int getPhoneModuleState() {
        return this.nadInstance != null && this.nadInstance.getActivationState() != null ? this.nadInstance.getActivationState().getTelPhoneModuleState() : 0;
    }

    @Override
    public String getDisplayProviderName() {
        return this.primaryDevice != null ? this.primaryDevice.getDisplayProviderName() : null;
    }

    @Override
    public String getDisplayProviderNameAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.getDisplayProviderName() : null;
    }

    @Override
    public boolean isEmergencyNumber(String string) {
        return this.primaryDevice != null ? this.primaryDevice.isEmergencyNumber(string) : false;
    }

    @Override
    public boolean isChinaSOSEmergencyNumber(String string) {
        return this.nadInstance != null ? this.nadInstance.isEmergencyNumber(string) : false;
    }

    @Override
    public boolean isMailboxNumber(String string) {
        return this.primaryDevice != null ? this.primaryDevice.isMailboxNumber(string) : false;
    }

    @Override
    public boolean isInfoNumber(String string) {
        if (this.serviceNumbers != null && string != null && string.length() > 0) {
            boolean bl;
            String string2 = this.serviceNumbers.getInfonumber() != null ? this.serviceNumbers.getInfonumber() : "";
            String string3 = this.serviceNumbers.getInfonumberRoaming() != null ? this.serviceNumbers.getInfonumberRoaming() : "";
            boolean bl2 = string2.length() > 0;
            boolean bl3 = bl = string3.length() > 0;
            if (!bl2 && !bl) {
                return false;
            }
            boolean bl4 = PhoneUtils.compareTelNumber(string, string2);
            boolean bl5 = PhoneUtils.compareTelNumber(string, string3);
            return bl4 || bl5;
        }
        return false;
    }

    @Override
    public boolean isBreakdownNumber(String string) {
        if (this.serviceNumbers != null && string != null && string.length() > 0) {
            boolean bl;
            String string2 = this.serviceNumbers.getBreakdownNumber() != null ? this.serviceNumbers.getBreakdownNumber() : "";
            String string3 = this.serviceNumbers.getBreakdownNumberRoaming() != null ? this.serviceNumbers.getBreakdownNumberRoaming() : "";
            boolean bl2 = string2.length() > 0;
            boolean bl3 = bl = string3.length() > 0;
            if (!bl2 && !bl) {
                return false;
            }
            boolean bl4 = PhoneUtils.compareTelNumber(string, string2);
            boolean bl5 = PhoneUtils.compareTelNumber(string, string3);
            return bl4 || bl5;
        }
        return false;
    }

    @Override
    public String getMailboxNumber() {
        return this.primaryDevice != null ? this.primaryDevice.getMailboxNumber() : null;
    }

    @Override
    public boolean isPhoneReady() {
        return this.primaryDevice != null ? this.primaryDevice.isPhoneReady() : false;
    }

    @Override
    public boolean hasMissedCalls() {
        return this.primaryDevice != null ? this.primaryDevice.hasMissedCalls() : false;
    }

    @Override
    public boolean isDialingPossible() {
        if (this.callLeadingDevice != null && this.callLeadingDevice.isRoleAssociated() && this.callLeadingDevice.getCallState() != null && !this.callLeadingDevice.getCallState().isIdle()) {
            return false;
        }
        if (this.callLeadingDevice != null && this.callLeadingDevice.getCallState() != null && this.callLeadingDevice.getCallState().isHasCCall()) {
            return false;
        }
        return this.primaryDevice != null ? this.primaryDevice.isDialingPossible() : false;
    }

    @Override
    public boolean isDialNumberPossible(String string) {
        if (this.callLeadingDevice != null && this.callLeadingDevice.isRoleAssociated() && this.callLeadingDevice.getCallState() != null && !this.callLeadingDevice.getCallState().isIdle()) {
            return false;
        }
        return this.primaryDevice != null ? this.primaryDevice.isDialNumberPossible(string) : false;
    }

    @Override
    public boolean isDialSOSNumberPossible(String string) {
        return this.nadInstance != null ? this.nadInstance.isDialNumberPossible(string) : false;
    }

    @Override
    public boolean isWidebandSpeechActive() {
        return this.primaryDevice != null ? this.primaryDevice.isWidebandSpeechActive() : false;
    }

    @Override
    public String getRingtonePath() {
        return this.primaryDevice != null ? this.primaryDevice.getRingtonePath() : null;
    }

    @Override
    public int getRingtoneIndex() {
        return this.primaryDevice != null ? this.primaryDevice.getRingtoneIndex() : -1;
    }

    @Override
    public String getDisplayNetworkName() {
        return this.primaryDevice != null ? this.primaryDevice.getDisplayNetworkName() : null;
    }

    @Override
    public boolean isNewSMSAvailable() {
        return this.newSMSAvailable;
    }

    @Override
    public String getDisplayName(String string, String string2) {
        return this.primaryDevice != null ? this.primaryDevice.getDisplayName(string, string2) : null;
    }

    @Override
    public String getDisplayNumber(String string, String string2) {
        return this.primaryDevice != null ? this.primaryDevice.getDisplayNumber(string, string2) : null;
    }

    @Override
    public boolean isSapUpgradeActive() {
        return this.primaryDevice != null ? this.primaryDevice.isSapUpgradeActive() : false;
    }

    @Override
    public boolean isRingtoneMuteActive() {
        return this.ringtoneMuteActive;
    }

    @Override
    public boolean isRingtoneMuteSettingOn() {
        return this.ringtoneMuteSettingOn;
    }

    @Override
    public String getDisplayNetworkNameDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getDisplayNetworkName() : null;
    }

    @Override
    public String getDisplayNumber(AbstractPhoneCall abstractPhoneCall) {
        return this.primaryDevice != null ? this.primaryDevice.getDisplayNumber(abstractPhoneCall) : "";
    }

    @Override
    public String getDisplayName(AbstractPhoneCall abstractPhoneCall) {
        return this.primaryDevice != null ? this.primaryDevice.getDisplayName(abstractPhoneCall) : "";
    }

    @Override
    public int getTelModeDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getTelMode() : -1;
    }

    @Override
    public boolean isNewEMailAvailable() {
        return this.newEmailAvailable;
    }

    @Override
    public String getDisplayProviderNameDSINAD() {
        return this.dataOnlyNadDevice != null ? this.dataOnlyNadDevice.getDisplayProviderName() : "";
    }

    @Override
    public boolean isBreakdownCallSupported() {
        return this.serviceNumbers != null && this.serviceNumbers.getBreakdownNumber() != null && this.serviceNumbers.getBreakdownNumber().length() > 0 && this.serviceNumbers.getBreakdownNumberRoaming() != null && this.serviceNumbers.getBreakdownNumberRoaming().length() > 0;
    }

    @Override
    public boolean isInfoCallSupported() {
        return this.serviceNumbers != null && this.serviceNumbers.getInfonumber() != null && this.serviceNumbers.getInfonumber().length() > 0 && this.serviceNumbers.getInfonumberRoaming() != null && this.serviceNumbers.getInfonumberRoaming().length() > 0;
    }

    @Override
    public boolean isEmergencyNumberAvailable() {
        if (this.telEmerNums != null) {
            if (this.telEmerNums.getMainEmergencyNumber() != null && this.telEmerNums.getMainEmergencyNumber().length() > 0) {
                return true;
            }
            String[] stringArray = this.telEmerNums.getAdditionalEmergencyNumber();
            if (stringArray != null && stringArray.length > 0) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    if (stringArray[i2] == null || stringArray[i2].length() <= 0) continue;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDisplayProviderNameForDataConnection() {
        return this.nadInstance != null ? this.nadInstance.getDisplayProviderName() : "";
    }

    @Override
    public boolean isESIMB2BModeActive() {
        return this.eSIMB2BMode;
    }

    @Override
    public boolean isESIMActive() {
        return this.eSIMActive;
    }

    @Override
    public String getESIMMSISDN() {
        return this.eSIMMSISDN;
    }

    @Override
    public String getEUICCID() {
        return this.eUICCID;
    }

    @Override
    public IEcallState getConnectedGatewayState() {
        return this.ecallState;
    }

    @Override
    public int getHandsFreeModeAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.getHandsFreeMode() : -1;
    }

    @Override
    public int getTelModeAssociated() {
        return this.associatedDevice != null && this.associatedDevice.getActivationState() != null ? this.associatedDevice.getActivationState().getTelMode() : -1;
    }

    @Override
    public int getmICMuteStateAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.getmICMuteState() : -1;
    }

    @Override
    public boolean inbandRingingSupportedAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.inbandRingingSupported() : false;
    }

    @Override
    public boolean isWidebandSpeechActiveAssociated() {
        return this.associatedDevice != null ? this.associatedDevice.isWidebandSpeechActive() : false;
    }

    @Override
    public boolean isOperatorCallViaNadPresent() {
        return GlobalTelephoneStateStructME.hasOperatorCallViaNad(this.primaryDevice) || GlobalTelephoneStateStructME.hasOperatorCallViaNad(this.associatedDevice) || GlobalTelephoneStateStructME.hasOperatorCallViaNad(this.dataOnlyNadDevice);
    }

    @Override
    public boolean isAcceptIncomingCallOnNonCallLeadingDevicePending() {
        return this.acceptIncomingCallOnNonCallLeadingDevicePending;
    }

    @Override
    public ITelTopology getTopology() {
        return this.topology;
    }

    @Override
    public boolean isSimCardInserted() {
        return this.nadInstance != null && this.nadInstance.getTelMode() == 0 && this.nadInstance.getPhoneInformation() != null && !this.nadInstance.getPhoneInformation().getSimId().equals("");
    }
}

