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
    public ActivationStateStruct getActivationState();

    public ActivationStateStruct getActivationStateAssociated();

    public int getTelMode();

    public boolean isAutomaticPinEntryActive();

    public boolean isAutomaticRedialActive();

    public int getBatteryChargeLevel();

    public int getBatteryChargeLevelAssociated();

    public boolean isMailboxNumberAvailable();

    public boolean isMultipartySupported();

    public CallDuration[] getCallDurationList();

    public CallInformation[] getCallList();

    public CallInformation getCall(int var1);

    public boolean isCdmaThreeWayCallingSetting();

    public int getCradlePlugInState();

    public DisconnectReason getDisconnectReason();

    public String getDtmfTone();

    public EmergencyCallSetting getEmergencyCallActive();

    public boolean isEnhancedPrivacyMode();

    public int getHandsFreeMode();

    public LockStateStruct getLockState();

    public LockStateStruct getLockStateAssociated();

    public MailboxDialingNumber[] getMailboxContent();

    public int getMicGainLevel();

    public int getmICMuteState();

    public int getNadMode();

    public NADTemperatureStruct getnADTemperature();

    public NetworkProviderName getNetworkProvider();

    public int getNetworkType();

    public int getOptimizationMode();

    public boolean isOtherSIMAvailable();

    public PhoneInformation getPhoneInformation();

    public PhoneInformation getPhoneInformationAssociated();

    public boolean isPrivacyMode();

    public RegisterStateStruct getRegisterState();

    public ServiceCodeTypeStruct getServiceCodeType();

    public ServiceNumbers getServiceNumbers();

    public ServiceProvider getServiceProvider();

    public int getSignalQuality();

    public SIMAliasInformation getSimAliasInformation();

    public boolean isSimPINRequired();

    public SuppServiceResponseStruct getSuppServiceResponse();

    public EmergencyNumbers getTelEmerNums();

    public int getMpCallState();

    public CallStateStruct getCallState();

    public CallStateStruct getCallStateAssociated();

    public CallStateStruct getCallStateData();

    public CallStateStruct getCallStateForRole(int var1);

    public boolean inbandRingingSupported();

    public boolean isRejectCallSupported();

    public boolean isRejectMobileSupported();

    public boolean isResponseAndHoldSupported();

    public boolean isThreeWaySupported();

    public boolean isEnhancedCallFeaturesSupported();

    public boolean isEnhancedStatSupported();

    public boolean isAddToConferenceSupported();

    public boolean isEnhancedConferenceTransferSupported();

    public boolean isAudiServiceAvailable();

    public CallStackEntry getLastDialedNumber();

    public boolean isCallStackReverted();

    public CallStackEntry[] getLastAnsweredNumbers();

    public CallStackEntry[] getLastDialedNumbers();

    public CallStackEntry[] getMissedNumbers();

    public CallStackEntry[] getCombinedCallStackEntries();

    public MissedCallIndicator getMissedCallIndicator();

    public int getmEDataValidity();

    public ActivationStateStruct getActivationStateDSINAD();

    public boolean isAutomaticPinEntryActiveDSINAD();

    public LockStateStruct getLockStateDSINAD();

    public NADTemperatureStruct getnADTemperatureDSINAD();

    public PhoneInformation getPhoneInformationDSINAD();

    public NetworkProviderName getNetworkProviderDSINAD();

    public int getNetworkTypeDSINAD();

    public RegisterStateStruct getRegisterStateDSINAD();

    public int getSignalQualityDSINAD();

    public ServiceProvider getServiceProviderdDSINAD();

    public boolean isSimPINRequiredDSINAD();

    public int getPhoneModuleState();

    public String getDisplayProviderName();

    public String getDisplayProviderNameAssociated();

    public boolean isEmergencyNumber(String var1);

    public boolean isMailboxNumber(String var1);

    public boolean isInfoNumber(String var1);

    public boolean isBreakdownNumber(String var1);

    public String getMailboxNumber();

    public boolean isPhoneReady();

    public boolean hasMissedCalls();

    public boolean isDialingPossible();

    public boolean isDialNumberPossible(String var1);

    public boolean isDialSOSNumberPossible(String var1);

    public boolean isWidebandSpeechActive();

    public String getRingtonePath();

    public int getRingtoneIndex();

    public String getDisplayNetworkName();

    public boolean isNewSMSAvailable();

    public String getDisplayName(String var1, String var2);

    public String getDisplayNumber(String var1, String var2);

    public boolean isSapUpgradeActive();

    public boolean isRingtoneMuteActive();

    public boolean isRingtoneMuteSettingOn();

    public String getDisplayNetworkNameDSINAD();

    public String getDisplayNumber(AbstractPhoneCall var1);

    public String getDisplayName(AbstractPhoneCall var1);

    public int getTelModeDSINAD();

    public boolean isNewEMailAvailable();

    public String getDisplayProviderNameDSINAD();

    public boolean isBreakdownCallSupported();

    public boolean isInfoCallSupported();

    public boolean isEmergencyNumberAvailable();

    public String getDisplayProviderNameForDataConnection();

    public boolean isESIMB2BModeActive();

    public boolean isESIMActive();

    public String getESIMMSISDN();

    public String getEUICCID();

    public IEcallState getConnectedGatewayState();

    public ITelDSIMobileEquipmentDeviceState getDataOnlyNadDeviceState();

    public ITelDSIMobileEquipmentDeviceState getNadInstanceState();

    public ITelDSIMobileEquipmentDeviceState getAssociatedDeviceState();

    public ITelDSIMobileEquipmentDeviceState getPrimaryDeviceState();

    public int getHandsFreeModeAssociated();

    public int getTelModeAssociated();

    public int getmICMuteStateAssociated();

    public boolean inbandRingingSupportedAssociated();

    public boolean isWidebandSpeechActiveAssociated();

    public ITelDSIMobileEquipmentDeviceState getCallLeadingDevice();

    public ITelDSIMobileEquipmentDeviceState getNonCallLeadingDevice();

    public boolean isAutomaticPinEntryActiveAssoicated();

    public boolean isOperatorCallViaNadPresent();

    public boolean isAcceptIncomingCallOnNonCallLeadingDevicePending();

    public ITelTopology getTopology();

    public boolean isSimCardInserted();

    public boolean isChinaSOSEmergencyNumber(String var1);
}

