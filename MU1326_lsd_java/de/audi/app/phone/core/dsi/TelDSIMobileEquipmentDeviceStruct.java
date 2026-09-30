/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.ITelTextFactory;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.calllist.ConferenceCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.TelDSIUtils;
import de.audi.app.phone.core.dsi.TelMESlotState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.esolutions.fw.util.commons.Buffer;
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

public class TelDSIMobileEquipmentDeviceStruct
implements ITelDSIMobileEquipmentDeviceState {
    private final ActivationStateStruct activationState;
    private final boolean automaticPinEntryActive;
    private final boolean automaticRedialActive;
    private final int batteryChargeLevel;
    private final CallDuration[] callDurationList;
    private final CallInformation[] callList;
    private final boolean cdmaThreeWayCallingSetting;
    private final int cradlePlugInState;
    private final DisconnectReason disconnectReason;
    private final String dtmfTone;
    private final EmergencyCallSetting emergencyCallActive;
    private final boolean enhancedPrivacyMode;
    private final int handsFreeMode;
    private final LockStateStruct lockState;
    private final MailboxDialingNumber[] mailboxContent;
    private final int micGainLevel;
    private final int mICMuteState;
    private final int nadMode;
    private final NADTemperatureStruct nADTemperature;
    private final NetworkProviderName networkProvider;
    private final int networkType;
    private final int optimizationMode;
    private final boolean otherSIMAvailable;
    private final PhoneInformation phoneInformation;
    private final boolean privacyMode;
    private final RegisterStateStruct registerState;
    private final ServiceCodeTypeStruct serviceCodeType;
    private final ServiceNumbers serviceNumbers;
    private final ServiceProvider serviceProvider;
    private final int signalQuality;
    private final SIMAliasInformation simAliasInformation;
    private final boolean simPINRequired;
    private final SuppServiceResponseStruct suppServiceResponse;
    private final EmergencyNumbers telEmerNums;
    private final CallStateStruct callState;
    private final boolean callStackReverted;
    private final CallStackEntry[] lastAnsweredNumbers;
    private final CallStackEntry[] lastDialedNumbers;
    private final CallStackEntry[] missedNumbers;
    private final CallStackEntry[] combinedCallStackEntries;
    private final MissedCallIndicator missedCallIndicator;
    private final int mEDataValidity;
    private final boolean widebandSpeechActive;
    private final int ringtoneIndex;
    private final String ringtonePath;
    private final boolean sapUpgradeActive;
    private final boolean ringtoneMuteSettingOn;
    private final boolean ringtoneMuteActive;
    private final String eUICCID;
    private final String eSIMMSISDN;
    private final boolean eSIMActive;
    private final boolean eSIMB2BModeActive;
    private final int deviceRole;
    private final int instanceID;
    private final boolean isCallStacksReverted;
    private final boolean phoneReminderSetting;
    private final boolean prefixActivated;
    private final String prefixContent;
    private final ITelTextFactory textFactory;

    public TelDSIMobileEquipmentDeviceStruct(ITelTextFactory iTelTextFactory, ActivationStateStruct activationStateStruct, boolean bl, boolean bl2, int n, CallDuration[] callDurationArray, CallInformation[] callInformationArray, boolean bl3, int n2, DisconnectReason disconnectReason, String string, EmergencyCallSetting emergencyCallSetting, boolean bl4, int n3, LockStateStruct lockStateStruct, MailboxDialingNumber[] mailboxDialingNumberArray, int n4, int n5, int n6, NADTemperatureStruct nADTemperatureStruct, NetworkProviderName networkProviderName, int n7, int n8, boolean bl5, PhoneInformation phoneInformation, boolean bl6, RegisterStateStruct registerStateStruct, ServiceCodeTypeStruct serviceCodeTypeStruct, ServiceNumbers serviceNumbers, ServiceProvider serviceProvider, int n9, SIMAliasInformation sIMAliasInformation, boolean bl7, SuppServiceResponseStruct suppServiceResponseStruct, EmergencyNumbers emergencyNumbers, CallStateStruct callStateStruct, boolean bl8, CallStackEntry[] callStackEntryArray, CallStackEntry[] callStackEntryArray2, CallStackEntry[] callStackEntryArray3, CallStackEntry[] callStackEntryArray4, MissedCallIndicator missedCallIndicator, int n10, boolean bl9, int n11, String string2, boolean bl10, boolean bl11, boolean bl12, String string3, String string4, boolean bl13, boolean bl14, int n12, int n13, boolean bl15, boolean bl16, boolean bl17, String string5) {
        this.textFactory = iTelTextFactory;
        this.activationState = activationStateStruct;
        this.automaticPinEntryActive = bl;
        this.automaticRedialActive = bl2;
        this.batteryChargeLevel = n;
        this.callDurationList = callDurationArray;
        this.callList = callInformationArray;
        this.cdmaThreeWayCallingSetting = bl3;
        this.cradlePlugInState = n2;
        this.disconnectReason = disconnectReason;
        this.dtmfTone = string;
        this.emergencyCallActive = emergencyCallSetting;
        this.enhancedPrivacyMode = bl4;
        this.handsFreeMode = n3;
        this.lockState = lockStateStruct;
        this.mailboxContent = mailboxDialingNumberArray;
        this.micGainLevel = n4;
        this.mICMuteState = n5;
        this.nadMode = n6;
        this.nADTemperature = nADTemperatureStruct;
        this.networkProvider = networkProviderName;
        this.networkType = n7;
        this.optimizationMode = n8;
        this.otherSIMAvailable = bl5;
        this.phoneInformation = phoneInformation;
        this.privacyMode = bl6;
        this.registerState = registerStateStruct;
        this.serviceCodeType = serviceCodeTypeStruct;
        this.serviceNumbers = serviceNumbers;
        this.serviceProvider = serviceProvider;
        this.signalQuality = n9;
        this.simAliasInformation = sIMAliasInformation;
        this.simPINRequired = bl7;
        this.suppServiceResponse = suppServiceResponseStruct;
        this.telEmerNums = emergencyNumbers;
        this.callState = callStateStruct;
        this.callStackReverted = bl8;
        this.lastAnsweredNumbers = callStackEntryArray;
        this.lastDialedNumbers = callStackEntryArray2;
        this.missedNumbers = callStackEntryArray3;
        this.combinedCallStackEntries = callStackEntryArray4;
        this.missedCallIndicator = missedCallIndicator;
        this.mEDataValidity = n10;
        this.widebandSpeechActive = bl9;
        this.ringtoneIndex = n11;
        this.ringtonePath = string2;
        this.sapUpgradeActive = bl10;
        this.ringtoneMuteSettingOn = bl11;
        this.ringtoneMuteActive = bl12;
        this.eUICCID = string3;
        this.eSIMMSISDN = string4;
        this.eSIMActive = bl13;
        this.eSIMB2BModeActive = bl14;
        this.deviceRole = n12;
        this.instanceID = n13;
        this.isCallStacksReverted = bl15;
        this.phoneReminderSetting = bl16;
        this.prefixActivated = bl17;
        this.prefixContent = string5;
    }

    private boolean supportsFeature(int n) {
        if (this.activationState != null) {
            return GlobalTelephoneState.supportsFeature(this.activationState, n);
        }
        return false;
    }

    public ActivationStateStruct getActivationState() {
        return this.activationState;
    }

    public boolean isAutomaticPinEntryActive() {
        return this.automaticPinEntryActive;
    }

    public boolean isAutomaticRedialActive() {
        return this.automaticRedialActive;
    }

    public int getBatteryChargeLevel() {
        return this.batteryChargeLevel;
    }

    public CallDuration[] getCallDurationList() {
        return this.callDurationList;
    }

    public CallInformation[] getCallList() {
        return this.callList;
    }

    public boolean isCdmaThreeWayCallingSetting() {
        return this.cdmaThreeWayCallingSetting;
    }

    public int getCradlePlugInState() {
        return this.cradlePlugInState;
    }

    public DisconnectReason getDisconnectReason() {
        return this.disconnectReason;
    }

    public String getDtmfTone() {
        return this.dtmfTone;
    }

    public EmergencyCallSetting getEmergencyCallActive() {
        return this.emergencyCallActive;
    }

    public boolean isEnhancedPrivacyMode() {
        return this.enhancedPrivacyMode;
    }

    public int getHandsFreeMode() {
        return this.handsFreeMode;
    }

    public LockStateStruct getLockState() {
        return this.lockState;
    }

    public MailboxDialingNumber[] getMailboxContent() {
        return this.mailboxContent;
    }

    public int getMicGainLevel() {
        return this.micGainLevel;
    }

    public int getmICMuteState() {
        return this.mICMuteState;
    }

    public int getNadMode() {
        return this.nadMode;
    }

    public NADTemperatureStruct getnADTemperature() {
        return this.nADTemperature;
    }

    public NetworkProviderName getNetworkProvider() {
        return this.networkProvider;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public int getOptimizationMode() {
        return this.optimizationMode;
    }

    public boolean isOtherSIMAvailable() {
        return this.otherSIMAvailable;
    }

    public PhoneInformation getPhoneInformation() {
        return this.phoneInformation;
    }

    public boolean isPrivacyMode() {
        return this.privacyMode;
    }

    public RegisterStateStruct getRegisterState() {
        return this.registerState;
    }

    public ServiceCodeTypeStruct getServiceCodeType() {
        return this.serviceCodeType;
    }

    public ServiceNumbers getServiceNumbers() {
        return this.serviceNumbers;
    }

    public ServiceProvider getServiceProvider() {
        return this.serviceProvider;
    }

    public int getSignalQuality() {
        return this.signalQuality;
    }

    public SIMAliasInformation getSimAliasInformation() {
        return this.simAliasInformation;
    }

    public boolean isSimPINRequired() {
        return this.simPINRequired;
    }

    public SuppServiceResponseStruct getSuppServiceResponse() {
        return this.suppServiceResponse;
    }

    public EmergencyNumbers getTelEmerNums() {
        return this.telEmerNums;
    }

    public CallStateStruct getCallState() {
        return this.callState;
    }

    public boolean isCallStackReverted() {
        return this.callStackReverted;
    }

    public CallStackEntry[] getLastAnsweredNumbers() {
        return this.lastAnsweredNumbers;
    }

    public CallStackEntry[] getLastDialedNumbers() {
        return this.lastDialedNumbers;
    }

    public CallStackEntry[] getMissedNumbers() {
        return this.missedNumbers;
    }

    public CallStackEntry[] getCombinedCallStackEntries() {
        return this.combinedCallStackEntries;
    }

    public MissedCallIndicator getMissedCallIndicator() {
        return this.missedCallIndicator;
    }

    public int getmEDataValidity() {
        return this.mEDataValidity;
    }

    public boolean isWidebandSpeechActive() {
        return this.widebandSpeechActive;
    }

    public int getRingtoneIndex() {
        return this.ringtoneIndex;
    }

    public String getRingtonePath() {
        return this.ringtonePath;
    }

    public boolean isSapUpgradeActive() {
        return this.sapUpgradeActive;
    }

    public boolean isRingtoneMuteSettingOn() {
        return this.ringtoneMuteSettingOn;
    }

    public boolean isRingtoneMuteActive() {
        return this.ringtoneMuteActive;
    }

    public String geteUICCID() {
        return this.eUICCID;
    }

    public String geteSIMMSISDN() {
        return this.eSIMMSISDN;
    }

    public boolean iseSIMActive() {
        return this.eSIMActive;
    }

    public boolean iseSIMB2BModeActive() {
        return this.eSIMB2BModeActive;
    }

    public int getDeviceRole() {
        return this.deviceRole;
    }

    public boolean isRolePrimary() {
        return this.deviceRole == 65536;
    }

    public boolean isRoleAssociated() {
        return this.deviceRole == 131072;
    }

    public boolean isRoleData() {
        return this.deviceRole == 196608;
    }

    public int getInstanceID() {
        return this.instanceID;
    }

    public boolean isCallStacksReverted() {
        return this.isCallStacksReverted;
    }

    public boolean isPhoneReminderSetting() {
        return this.phoneReminderSetting;
    }

    public boolean isPrefixActivated() {
        return this.prefixActivated;
    }

    public String getPrefixContent() {
        return this.prefixContent;
    }

    public boolean isMailboxNumberAvailable() {
        if (this.mailboxContent != null) {
            for (int i2 = 0; i2 < this.mailboxContent.length; ++i2) {
                if (this.mailboxContent[i2].mailboxNumber == null || this.mailboxContent[i2].mailboxNumber.length() <= 0) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isMultipartySupported() {
        boolean bl = this.callState != null ? this.callState.isHasBCall() || this.callState.isHasPCall() : false;
        return !bl && this.supportsFeature(8) && this.supportsFeature(32);
    }

    public CallInformation getCall(int n) {
        if (this.callList != null) {
            for (int i2 = 0; i2 < this.callList.length; ++i2) {
                if (this.callList[i2].getTelCallID() != n) continue;
                return this.callList[i2];
            }
        }
        return null;
    }

    public boolean inbandRingingSupported() {
        return this.supportsFeature(1);
    }

    public boolean isRejectCallSupported() {
        return this.supportsFeature(2);
    }

    public boolean isRejectMobileSupported() {
        return this.supportsFeature(256);
    }

    public boolean isResponseAndHoldSupported() {
        return this.supportsFeature(4);
    }

    public boolean isThreeWaySupported() {
        return this.supportsFeature(8);
    }

    public boolean isEnhancedCallFeaturesSupported() {
        return this.supportsFeature(16);
    }

    public boolean isEnhancedStatSupported() {
        return this.supportsFeature(32);
    }

    public boolean isAddToConferenceSupported() {
        return this.supportsFeature(64);
    }

    public boolean isEnhancedConferenceTransferSupported() {
        return this.supportsFeature(128);
    }

    public boolean isAudiServiceAvailable() {
        return this.isInfoCallSupported() || this.isBreakdownCallSupported();
    }

    public boolean isInfoCallSupported() {
        return this.serviceNumbers != null && this.serviceNumbers.getInfonumber() != null && this.serviceNumbers.getInfonumber().length() > 0 && this.serviceNumbers.getInfonumberRoaming() != null && this.serviceNumbers.getInfonumberRoaming().length() > 0;
    }

    public boolean isBreakdownCallSupported() {
        return this.serviceNumbers != null && this.serviceNumbers.getBreakdownNumber() != null && this.serviceNumbers.getBreakdownNumber().length() > 0 && this.serviceNumbers.getBreakdownNumberRoaming() != null && this.serviceNumbers.getBreakdownNumberRoaming().length() > 0;
    }

    public CallStackEntry getLastDialedNumber() {
        if (this.lastDialedNumbers != null && this.lastDialedNumbers.length > 0) {
            return this.lastDialedNumbers[0];
        }
        return null;
    }

    public int getTelMode() {
        return this.activationState != null ? this.activationState.getTelMode() : -1;
    }

    public int getPhoneModuleState() {
        if (this.activationState != null) {
            return this.activationState.getTelPhoneModuleState();
        }
        return -1;
    }

    public String getDisplayProviderName() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.registerState != null) {
            stringBuffer.append(this.getServiceProviderName());
            if (stringBuffer.length() == 0) {
                stringBuffer.append(this.getNetworkProviderName());
            }
        }
        return stringBuffer.toString();
    }

    private String getNetworkProviderName() {
        String string = "";
        String string2 = this.registerState.getTelLongProviderName();
        String string3 = this.registerState.getTelNumProviderName();
        if (string2 != null && string2.length() > 0) {
            string = string2;
        } else if (string3 != null && string3.length() > 0) {
            string = string3;
        }
        return string;
    }

    private String getServiceProviderName() {
        String string;
        String string2 = "";
        if (this.serviceProvider != null && this.serviceProvider.displayConditionServiceProviderName && this.serviceProvider.getTelServiceProviderName() != null && this.serviceProvider.getTelServiceProviderName().length() > 0 && (string = this.serviceProvider.getTelServiceProviderName()) != null && string.length() > 0) {
            string2 = this.serviceProvider.getTelServiceProviderName();
        }
        return string2;
    }

    public String getDisplayNetworkName() {
        if (this.registerState != null) {
            String string = this.registerState.getTelLongProviderName();
            String string2 = this.registerState.getTelNumProviderName();
            if (string != null && string.length() > 0) {
                return string;
            }
            return string2;
        }
        return "";
    }

    public boolean isEmergencyNumber(String string) {
        if (string != null && this.telEmerNums != null) {
            if (PhoneUtils.compareTelNumber(string, this.telEmerNums.getMainEmergencyNumber())) {
                return true;
            }
            String[] stringArray = this.telEmerNums.getAdditionalEmergencyNumber();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!PhoneUtils.compareTelNumber(string, stringArray[i2])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isMailboxNumber(String string) {
        if (string != null && this.mailboxContent != null) {
            for (int i2 = 0; i2 < this.mailboxContent.length; ++i2) {
                if (!PhoneUtils.compareTelNumber(string, this.mailboxContent[i2].getMailboxNumber())) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isInfoNumber(String string) {
        if (string != null && this.serviceNumbers != null) {
            return PhoneUtils.compareTelNumber(string, this.serviceNumbers.getInfonumber()) || PhoneUtils.compareTelNumber(string, this.serviceNumbers.getInfonumberRoaming());
        }
        return false;
    }

    public boolean isBreakdownNumber(String string) {
        if (string != null && this.serviceNumbers != null) {
            return PhoneUtils.compareTelNumber(string, this.serviceNumbers.getBreakdownNumber()) || PhoneUtils.compareTelNumber(string, this.serviceNumbers.getBreakdownNumberRoaming());
        }
        return false;
    }

    public String getMailboxNumber() {
        if (this.mailboxContent != null && this.mailboxContent.length > 0) {
            return this.mailboxContent[0].getMailboxNumber();
        }
        return null;
    }

    public boolean isPhoneReady() {
        if (this.activationState != null && this.lockState != null) {
            return (this.activationState.getTelActivationState() == 5 || this.activationState.getTelActivationState() == 2) && this.lockState.getTelLockState() == 2;
        }
        return false;
    }

    public boolean hasMissedCalls() {
        if (this.missedCallIndicator != null) {
            return this.missedCallIndicator.isMissedCall();
        }
        return false;
    }

    public boolean isDialingPossible() {
        boolean bl = false;
        if (this.callState != null && this.isPhoneReady()) {
            boolean bl2;
            boolean bl3 = bl2 = !this.callState.isHasIncomingCall() && !this.callState.isHasOutgoingCall();
            if (this.callState.isIdle()) {
                bl = true;
            } else if (!this.callState.isMultipartyActive() && this.isMultipartySupported() && bl2) {
                bl = true;
            }
        } else {
            int n = this.activationState != null ? this.activationState.getTelPhoneModuleState() : 0;
            return n == 2;
        }
        return bl;
    }

    public boolean isDialNumberPossible(String string) {
        boolean bl = false;
        if (this.callState != null && this.isPhoneReady()) {
            boolean bl2;
            boolean bl3 = bl2 = !this.callState.isHasIncomingCall() && !this.callState.isHasOutgoingCall();
            if (this.callState.isIdle()) {
                bl = true;
            } else if (!this.callState.isMultipartyActive() && this.isMultipartySupported() && bl2) {
                bl = true;
            }
        } else if (this.isEmergencyNumber(string)) {
            int n = this.activationState != null ? this.activationState.getTelPhoneModuleState() : 0;
            return n == 2;
        }
        return bl;
    }

    public String getDisplayName(String string, String string2) {
        if (string2 != null && !string2.equals("") && this.isEmergencyNumber(string2)) {
            return this.textFactory.getText(4);
        }
        if (string2 != null && !string2.equals("") && this.isBreakdownNumber(string2)) {
            return this.textFactory.getText(3);
        }
        if (string2 != null && !string2.equals("") && this.isInfoNumber(string2)) {
            return this.textFactory.getText(2);
        }
        if (string2 != null && !string2.equals("") && this.isMailboxNumber(string2)) {
            return this.textFactory.getText(0);
        }
        if (string == null || string.equals("")) {
            if (string2 == null || string2.equals("")) {
                return this.textFactory.getText(8);
            }
            return string2;
        }
        return string;
    }

    public String getDisplayNumber(String string, String string2) {
        String string3 = this.getDisplayName(string, string2);
        if (string2 == null || string3 != null && string3.equals(string2) || this.isSomeServiceCall(string2)) {
            return "";
        }
        return string2;
    }

    private boolean isSomeServiceCall(String string) {
        return this.isInfoNumber(string) || this.isBreakdownNumber(string) || this.isMailboxNumber(string) || this.isEmergencyNumber(string);
    }

    public String getDisplayName(AbstractPhoneCall abstractPhoneCall) {
        if (abstractPhoneCall != null) {
            if (abstractPhoneCall instanceof ConferenceCall) {
                return this.textFactory.getText(1);
            }
            if (abstractPhoneCall.getTelCallType() == 196608) {
                return this.textFactory.getText(7);
            }
            if (abstractPhoneCall.getTelCallType() == 65536) {
                return this.textFactory.getText(5);
            }
            if (abstractPhoneCall.getTelCallType() == 131072) {
                return this.textFactory.getText(6);
            }
            return this.getDisplayName(abstractPhoneCall.getTelRemName(), abstractPhoneCall.getTelRemNumber());
        }
        return null;
    }

    public String getDisplayNumber(AbstractPhoneCall abstractPhoneCall) {
        String string = this.getDisplayName(abstractPhoneCall);
        String string2 = abstractPhoneCall.getTelRemNumber();
        if (string2 == null || string != null && string.equals(string2)) {
            return "";
        }
        return string2;
    }

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

    public ITelMESlotState getDevice() {
        return new TelMESlotState(this.activationState, this.lockState, this.phoneInformation, this.networkType, this.callState, this.registerState);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("\n");
        buffer.append("deviceRole=");
        buffer.append(TelDSIUtils.getRoleName(this.deviceRole));
        buffer.append("\n");
        buffer.append("instanceID=");
        buffer.append(this.instanceID);
        buffer.append("\n");
        buffer.append("activationState=");
        buffer.append(this.activationState);
        buffer.append("\n");
        buffer.append("automaticPinEntryActive=");
        buffer.append(this.automaticPinEntryActive);
        buffer.append("\n");
        buffer.append("automaticRedialActive=");
        buffer.append(this.automaticRedialActive);
        buffer.append("\n");
        buffer.append("batteryChargeLevel=");
        buffer.append(this.batteryChargeLevel);
        buffer.append("\n");
        buffer.append("callDurationList=");
        buffer.append("\n");
        buffer.append("-----------------------");
        buffer.append("\n");
        buffer.append(TelLoggingUtils.objectArray2StringNewLines(this.callDurationList));
        buffer.append("\n");
        buffer.append("callList=");
        buffer.append("\n");
        buffer.append("-----------------------");
        buffer.append("\n");
        buffer.append(TelLoggingUtils.objectArray2StringNewLines(this.callList));
        buffer.append("\n");
        buffer.append("cdmaThreeWayCallingSetting=");
        buffer.append(this.cdmaThreeWayCallingSetting);
        buffer.append("\n");
        buffer.append("cradlePlugInState=");
        buffer.append(this.cradlePlugInState);
        buffer.append("\n");
        buffer.append("disconnectReason=");
        buffer.append(this.disconnectReason);
        buffer.append("\n");
        buffer.append("dtmfTone=");
        buffer.append(this.dtmfTone);
        buffer.append("\n");
        buffer.append("emergencyCallActive=");
        buffer.append(this.emergencyCallActive);
        buffer.append("\n");
        buffer.append("enhancedPrivacyMode=");
        buffer.append(this.enhancedPrivacyMode);
        buffer.append("\n");
        buffer.append("handsFreeMode=");
        buffer.append(this.handsFreeMode);
        buffer.append("\n");
        buffer.append("lockState=");
        buffer.append(this.lockState);
        buffer.append("\n");
        buffer.append("mailboxContent=");
        buffer.append("\n");
        buffer.append("-----------------------");
        buffer.append("\n");
        buffer.append(TelLoggingUtils.objectArray2StringNewLines(this.mailboxContent));
        buffer.append("\n");
        buffer.append("micGainLevel=");
        buffer.append(this.micGainLevel);
        buffer.append("\n");
        buffer.append("mICMuteState=");
        buffer.append(this.mICMuteState);
        buffer.append("\n");
        buffer.append("nadMode=");
        buffer.append(this.nadMode);
        buffer.append("\n");
        buffer.append("nADTemperature=");
        buffer.append(this.nADTemperature);
        buffer.append("\n");
        buffer.append("networkProvider=");
        buffer.append(this.networkProvider);
        buffer.append("\n");
        buffer.append("networkType=");
        buffer.append(this.networkType);
        buffer.append("\n");
        buffer.append("optimizationMode=");
        buffer.append(this.optimizationMode);
        buffer.append("\n");
        buffer.append("otherSIMAvailable=");
        buffer.append(this.otherSIMAvailable);
        buffer.append("\n");
        buffer.append("phoneInformation=");
        buffer.append(this.phoneInformation);
        buffer.append("\n");
        buffer.append("privacyMode=");
        buffer.append(this.privacyMode);
        buffer.append("\n");
        buffer.append("registerState=");
        buffer.append(this.registerState);
        buffer.append("\n");
        buffer.append("serviceCodeType=");
        buffer.append(this.serviceCodeType);
        buffer.append("\n");
        buffer.append("serviceNumbers=");
        buffer.append(this.serviceNumbers);
        buffer.append("\n");
        buffer.append("serviceProvider=");
        buffer.append(this.serviceProvider);
        buffer.append("\n");
        buffer.append("signalQuality=");
        buffer.append(this.signalQuality);
        buffer.append("\n");
        buffer.append("simAliasInformation=");
        buffer.append(this.simAliasInformation);
        buffer.append("\n");
        buffer.append("simPINRequired=");
        buffer.append(this.simPINRequired);
        buffer.append("\n");
        buffer.append("suppServiceResponse=");
        buffer.append(this.suppServiceResponse);
        buffer.append("\n");
        buffer.append("telEmerNums=");
        buffer.append(this.telEmerNums);
        buffer.append("\n");
        buffer.append("callState=");
        buffer.append(this.callState);
        buffer.append("\n");
        buffer.append("callStackReverted=");
        buffer.append(this.callStackReverted);
        buffer.append("\n");
        buffer.append("lastAnsweredNumbers=");
        buffer.append("\n");
        buffer.append("-----------------------");
        buffer.append("\n");
        buffer.append(TelLoggingUtils.objectArray2StringNewLines(this.lastAnsweredNumbers));
        buffer.append("\n");
        buffer.append("lastDialedNumbers=");
        buffer.append("\n");
        buffer.append("-----------------------");
        buffer.append("\n");
        buffer.append(TelLoggingUtils.objectArray2StringNewLines(this.lastDialedNumbers));
        buffer.append("\n");
        buffer.append("missedNumbers=");
        buffer.append("\n");
        buffer.append("-----------------------");
        buffer.append("\n");
        buffer.append(TelLoggingUtils.objectArray2StringNewLines(this.missedNumbers));
        buffer.append("\n");
        buffer.append("combinedCallStackEntries=");
        buffer.append(TelLoggingUtils.objectArray2StringNewLines(this.combinedCallStackEntries));
        buffer.append("\n");
        buffer.append("missedCallIndicator=");
        buffer.append(this.missedCallIndicator);
        buffer.append("\n");
        buffer.append("mEDataValidity=");
        buffer.append(this.mEDataValidity);
        buffer.append("\n");
        buffer.append("widebandSpeechActive=");
        buffer.append(this.widebandSpeechActive);
        buffer.append("\n");
        buffer.append("ringtoneIndex=");
        buffer.append(this.ringtoneIndex);
        buffer.append("\n");
        buffer.append("ringtonePath=");
        buffer.append(this.ringtonePath);
        buffer.append("\n");
        buffer.append("sapUpgradeActive=");
        buffer.append(this.sapUpgradeActive);
        buffer.append("\n");
        buffer.append("ringtoneMuteSettingOn=");
        buffer.append(this.ringtoneMuteSettingOn);
        buffer.append("\n");
        buffer.append("ringtoneMuteActive=");
        buffer.append(this.ringtoneMuteActive);
        buffer.append("\n");
        buffer.append("eUICCID=");
        buffer.append(this.eUICCID);
        buffer.append("\n");
        buffer.append("eSIMMSISDN=");
        buffer.append(this.eSIMMSISDN);
        buffer.append("\n");
        buffer.append("eSIMActive=");
        buffer.append(this.eSIMActive);
        buffer.append("\n");
        buffer.append("eSIMB2BModeActive=");
        buffer.append(this.eSIMB2BModeActive);
        buffer.append("\n");
        buffer.append("isCallStacksReverted=");
        buffer.append(this.isCallStacksReverted);
        buffer.append("\n");
        buffer.append("phoneReminderSetting=");
        buffer.append(this.phoneReminderSetting);
        buffer.append("\n");
        buffer.append("prefixActivated=");
        buffer.append(this.prefixActivated);
        buffer.append("\n");
        buffer.append("prefixContent=");
        buffer.append(this.prefixContent);
        buffer.append("\n");
        return buffer.toString();
    }
}

