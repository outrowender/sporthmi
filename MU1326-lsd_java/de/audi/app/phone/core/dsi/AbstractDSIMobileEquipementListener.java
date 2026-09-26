/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentDeviceStruct;
import de.audi.app.phone.core.dsi.TelDSIUtils;
import de.audi.app.phone.core.dsi.TelDefaultDSIMobileEquipmentListener;
import de.audi.app.phone.core.state.CallState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
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

public abstract class AbstractDSIMobileEquipementListener
extends AbstractPhoneComponent
implements ICommandResponseSupplier {
    private static final int SIGNAL_QUALITY_UNKNOWN;
    protected ActivationStateStruct activationState;
    protected boolean automaticPinEntryActive;
    protected boolean automaticRedialActive;
    protected int batteryChargeLevel = 255;
    protected CallDuration[] callDurationList;
    protected CallInformation[] callList;
    protected boolean cdmaThreeWayCallingSetting;
    protected int cradlePlugInState;
    protected DisconnectReason disconnectReason;
    protected String dtmfTone;
    protected EmergencyCallSetting emergencyCallActive;
    protected boolean enhancedPrivacyMode;
    protected int handsFreeMode;
    protected LockStateStruct lockState;
    protected MailboxDialingNumber[] mailboxContent;
    protected int micGainLevel;
    protected int mICMuteState = 1;
    protected int nadMode;
    protected NADTemperatureStruct nADTemperature;
    protected NetworkProviderName networkProvider;
    protected int networkType;
    protected int optimizationMode;
    protected boolean otherSIMAvailable;
    protected PhoneInformation phoneInformation;
    protected boolean privacyMode;
    protected RegisterStateStruct registerState;
    protected ServiceCodeTypeStruct serviceCodeType;
    protected ServiceNumbers serviceNumbers;
    protected ServiceProvider serviceProvider;
    protected int signalQuality = 255;
    protected SIMAliasInformation simAliasInformation;
    protected boolean simPINRequired;
    protected SuppServiceResponseStruct suppServiceResponse;
    protected EmergencyNumbers telEmerNums;
    protected boolean callStackReverted;
    protected CallStackEntry[] lastAnsweredNumbers;
    protected CallStackEntry[] lastDialedNumbers;
    protected CallStackEntry[] missedNumbers;
    protected CallStackEntry[] combinedCallStackEntries;
    protected MissedCallIndicator missedCallIndicator;
    protected int mEDataValidity;
    protected boolean widebandSpeechActive;
    protected int ringtoneIndex;
    protected String ringtonePath;
    protected boolean sapUpgradeActive;
    protected boolean ringtoneMuteSettingOn;
    protected boolean ringtoneMuteActive;
    protected String eUICCID;
    protected String eSIMMSISDN;
    protected boolean eSIMActive;
    protected boolean eSIMB2BModeActive;
    protected boolean isCallStacksReverted;
    protected boolean phoneReminderSetting;
    protected boolean prefixActivated;
    protected String prefixContent;
    protected final CommandListManager commandListManager;
    protected final LogChannel cmdListLogChannel;
    protected final TelDefaultDSIMobileEquipmentListener defaultListener;
    protected final Object mutex = new Object();
    protected final int instanceID;
    protected final CallState callState;
    protected int deviceRole = 65535;
    private boolean isNadInstance;

    public AbstractDSIMobileEquipementListener(ITelApplication iTelApplication, CommandListManager commandListManager, LogChannel logChannel, int n) {
        super(iTelApplication, "App.Phone.DSI");
        if (iTelApplication.getFrameworkAccess().getSysConstManager().getSysConst(463) == 0) {
            this.log.log(1078071040, "AbstractDSIMobileEquipementListener#GlobalTelephoneState(): no nad available, setting nad mode to voice and data.");
            this.nadMode = 1;
        }
        this.commandListManager = commandListManager;
        this.cmdListLogChannel = logChannel;
        this.defaultListener = new TelDefaultDSIMobileEquipmentListener();
        this.instanceID = n;
        this.callState = new CallState(this.log);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setDeviceRole(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.deviceRole = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getDeviceRole() {
        Object object = this.mutex;
        synchronized (object) {
            return this.deviceRole;
        }
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public LogChannel getLogChannel() {
        return this.cmdListLogChannel;
    }

    protected Buffer getInstanceAndRoleString() {
        Buffer buffer = new Buffer();
        buffer.append("instanceID=");
        buffer.append(this.instanceID);
        buffer.append("(");
        buffer.append(this.isNadInstance() ? "NAD" : "HFP");
        buffer.append(")");
        buffer.append(", ");
        buffer.append("deviceRole=");
        buffer.append(TelDSIUtils.getRoleName(this.deviceRole));
        return buffer;
    }

    protected void setIsNadInstance(boolean bl) {
        this.isNadInstance = bl;
    }

    private boolean isNadInstance() {
        return this.isNadInstance;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ITelDSIMobileEquipmentDeviceState getMEStateStruct() {
        Object object = this.mutex;
        synchronized (object) {
            return new TelDSIMobileEquipmentDeviceStruct(this.getApplication().getTextFactory(), this.activationState, this.automaticPinEntryActive, this.automaticRedialActive, this.batteryChargeLevel, this.callDurationList, this.callList, this.cdmaThreeWayCallingSetting, this.cradlePlugInState, this.disconnectReason, this.dtmfTone, this.emergencyCallActive, this.enhancedPrivacyMode, this.handsFreeMode, this.lockState, this.mailboxContent, this.micGainLevel, this.mICMuteState, this.nadMode, this.nADTemperature, this.networkProvider, this.networkType, this.optimizationMode, this.otherSIMAvailable, this.phoneInformation, this.enhancedPrivacyMode, this.registerState, this.serviceCodeType, this.serviceNumbers, this.serviceProvider, this.signalQuality, this.simAliasInformation, this.simPINRequired, this.suppServiceResponse, this.telEmerNums, new CallStateStruct(this.callState), this.callStackReverted, this.lastAnsweredNumbers, this.lastDialedNumbers, this.missedNumbers, this.combinedCallStackEntries, this.missedCallIndicator, this.mEDataValidity, this.widebandSpeechActive, this.ringtoneIndex, this.ringtonePath, this.sapUpgradeActive, this.ringtoneMuteSettingOn, this.ringtoneMuteActive, this.eUICCID, this.eSIMMSISDN, this.eSIMActive, this.eSIMB2BModeActive, this.deviceRole, this.instanceID, this.isCallStacksReverted, this.phoneReminderSetting, this.prefixActivated, this.prefixContent);
        }
    }

    protected void updateGlobalTelephoneState(int n) {
        this.getApplication().getGlobalTelephoneStateManager().updateMEDevice(n, this.deviceRole, this.getMEStateStruct());
    }

    protected int getLogLevelFromRole() {
        int n = this.deviceRole;
        return n == 512 || n == 768 || n == 256 ? 1078071040 : -2137614336;
    }
}

