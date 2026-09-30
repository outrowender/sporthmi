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
    public ActivationStateStruct getActivationState();

    public boolean isAutomaticPinEntryActive();

    public boolean isAutomaticRedialActive();

    public int getBatteryChargeLevel();

    public CallDuration[] getCallDurationList();

    public CallInformation[] getCallList();

    public boolean isCdmaThreeWayCallingSetting();

    public int getCradlePlugInState();

    public DisconnectReason getDisconnectReason();

    public String getDtmfTone();

    public EmergencyCallSetting getEmergencyCallActive();

    public boolean isEnhancedPrivacyMode();

    public int getHandsFreeMode();

    public LockStateStruct getLockState();

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

    public CallStateStruct getCallState();

    public boolean isCallStackReverted();

    public CallStackEntry[] getLastAnsweredNumbers();

    public CallStackEntry[] getLastDialedNumbers();

    public CallStackEntry[] getMissedNumbers();

    public CallStackEntry[] getCombinedCallStackEntries();

    public MissedCallIndicator getMissedCallIndicator();

    public int getmEDataValidity();

    public boolean isWidebandSpeechActive();

    public int getRingtoneIndex();

    public String getRingtonePath();

    public boolean isSapUpgradeActive();

    public boolean isRingtoneMuteSettingOn();

    public boolean isRingtoneMuteActive();

    public String geteUICCID();

    public String geteSIMMSISDN();

    public boolean iseSIMActive();

    public boolean iseSIMB2BModeActive();

    public int getDeviceRole();

    public int getInstanceID();

    public boolean isCallStacksReverted();

    public boolean isPhoneReminderSetting();

    public boolean isPrefixActivated();

    public String getPrefixContent();

    public boolean isMailboxNumberAvailable();

    public boolean isEmergencyNumberAvailable();

    public String getDisplayNumber(AbstractPhoneCall var1);

    public String getDisplayName(AbstractPhoneCall var1);

    public String getDisplayNumber(String var1, String var2);

    public String getDisplayName(String var1, String var2);

    public boolean isDialingPossible();

    public boolean hasMissedCalls();

    public boolean isPhoneReady();

    public String getMailboxNumber();

    public boolean isBreakdownNumber(String var1);

    public boolean isInfoNumber(String var1);

    public boolean isMailboxNumber(String var1);

    public boolean isEmergencyNumber(String var1);

    public String getDisplayNetworkName();

    public String getDisplayProviderName();

    public int getPhoneModuleState();

    public int getTelMode();

    public CallStackEntry getLastDialedNumber();

    public boolean isBreakdownCallSupported();

    public boolean isInfoCallSupported();

    public boolean isAudiServiceAvailable();

    public boolean isEnhancedConferenceTransferSupported();

    public boolean isAddToConferenceSupported();

    public boolean isEnhancedStatSupported();

    public boolean isEnhancedCallFeaturesSupported();

    public boolean isThreeWaySupported();

    public boolean isResponseAndHoldSupported();

    public boolean isRejectMobileSupported();

    public boolean isRejectCallSupported();

    public boolean inbandRingingSupported();

    public CallInformation getCall(int var1);

    public boolean isMultipartySupported();

    public ITelMESlotState getDevice();

    public boolean isDialNumberPossible(String var1);

    public boolean isRoleData();

    public boolean isRoleAssociated();

    public boolean isRolePrimary();
}

