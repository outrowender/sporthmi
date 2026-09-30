/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDSIUtils;
import de.audi.app.phone.core.dsi.TelResultHandlerWrapper;
import de.audi.app.phone.core.dsi.cmd.TelAcceptCmd;
import de.audi.app.phone.core.dsi.cmd.TelCallForwardCmd;
import de.audi.app.phone.core.dsi.cmd.TelCallWaitingCmd;
import de.audi.app.phone.core.dsi.cmd.TelChangeSIMCodeCmd;
import de.audi.app.phone.core.dsi.cmd.TelDecreaseMicGainLevelCmd;
import de.audi.app.phone.core.dsi.cmd.TelDeleteAllCallStacksCmd;
import de.audi.app.phone.core.dsi.cmd.TelDeleteCallStackEntryCmd;
import de.audi.app.phone.core.dsi.cmd.TelDialNumberCmd;
import de.audi.app.phone.core.dsi.cmd.TelDialNumberFromADBEntryCmd;
import de.audi.app.phone.core.dsi.cmd.TelDialOperatorCmd;
import de.audi.app.phone.core.dsi.cmd.TelHangupCmd;
import de.audi.app.phone.core.dsi.cmd.TelIncreaseMicGainLevelCmd;
import de.audi.app.phone.core.dsi.cmd.TelJoinCallsCmd;
import de.audi.app.phone.core.dsi.cmd.TelNetworkRegistrationCmd;
import de.audi.app.phone.core.dsi.cmd.TelNetworkSearchCmd;
import de.audi.app.phone.core.dsi.cmd.TelRequestCLIRCmd;
import de.audi.app.phone.core.dsi.cmd.TelResetMissedCallIndicator;
import de.audi.app.phone.core.dsi.cmd.TelRestoreFactorySettingsCmd;
import de.audi.app.phone.core.dsi.cmd.TelRevertCallStacksCmd;
import de.audi.app.phone.core.dsi.cmd.TelSIMPINRequiredCmd;
import de.audi.app.phone.core.dsi.cmd.TelSendDTMFCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetAutomaticEmergencyCallActiveCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetAutomaticPinEntryActiveCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetAutomaticRedialActiveCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetCDMAThreeWayCallingSettingCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetESIMActiveCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetEnhancedPrivacyModeCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetHandsFreeModeCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetLanguageCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetMailboxNumberCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetMicGainLevelCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetMicMuteStateCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetNadModeCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetOptimizationModeCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetPhoneReminderSettingCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetPhoneRingtoneCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetPrivacyModeCmd;
import de.audi.app.phone.core.dsi.cmd.TelSetTelPowerCmd;
import de.audi.app.phone.core.dsi.cmd.TelSplitCallCmd;
import de.audi.app.phone.core.dsi.cmd.TelSwapCallsCmd;
import de.audi.app.phone.core.dsi.cmd.TelUnlockSIMCmd;
import de.audi.app.phone.core.event.TelEventQueue;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.Hashtable;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CFRequestData;

public abstract class AbstractTelDSIDeviceAccess
extends AbstractPhoneComponent
implements ITelDSIMobileEquipmentDeviceAccess {
    private final SimpleIntObjectMap cmdMutexMap = new SimpleIntObjectMap();
    private final SimpleIntObjectMap cmdMonitorMap = new SimpleIntObjectMap();
    protected final LogChannel cmdListLogChannel;
    protected final int instanceID;
    protected int deviceRole = -65536;
    protected final Map hangupMonitorMap;
    protected TelCallForwardCmd callForwardCommand;
    protected TelCallWaitingCmd callWaitingCommand;
    protected TelRequestCLIRCmd clirCommand;
    protected TelNetworkRegistrationCmd networkRegistrationCmd;
    protected TelNetworkSearchCmd networkSearchCmd;
    private volatile IGlobalTelephoneStateStruct currentTelState;
    protected volatile boolean isNadInstance;
    private final TelEventQueue responseDispatcher;

    private static Buffer getDialNumberFromADBEntryParamBuffer(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("telNumber=");
        buffer.append(string);
        buffer.append(", ");
        buffer.append("telDBEntryId=");
        buffer.append(l);
        buffer.append(", ");
        buffer.append("telDBName=");
        buffer.append(string2);
        buffer.append(", ");
        buffer.append("telPhoneType=");
        buffer.append(s);
        buffer.append(", ");
        buffer.append("telEntryType=");
        buffer.append(s2);
        buffer.append(", ");
        buffer.append("telDBPicture=");
        buffer.append(resourceLocator);
        buffer.append(", ");
        buffer.append("telDBPhoneNumberIndex=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("adbPhoneDataCount=");
        buffer.append(n2);
        return buffer;
    }

    private static Buffer getRequestChangeSIMCodeParamBuffer(int n, String string, String string2) {
        return new Buffer().append("telLockCode=").append(n).append(", ").append("telCurrentCode=").append(string).append(", ").append("telNewCode=").append(string2);
    }

    private static Buffer getRequestUnlockSimParamBuffer(int n, String string, String string2) {
        return new Buffer().append("telLockCode=").append(n).append(", ").append("telCurrentCode=").append(string).append(", ").append("telNewCode=").append(string2);
    }

    public static int getAttribute(int n, int n2) {
        return n | n2;
    }

    public AbstractTelDSIDeviceAccess(ITelApplication iTelApplication, int n, int n2) {
        super(iTelApplication, "App.Phone.DSI");
        this.deviceRole = n2;
        this.hangupMonitorMap = new Hashtable();
        this.instanceID = n;
        this.cmdListLogChannel = this.getApplication().getFrameworkAccess().getLogChannel("App.Phone.DSI.CL");
        this.responseDispatcher = iTelApplication.getTelEventQueue();
        this.initMutexMap();
        this.initMonitorMap();
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.deinitMutexMap();
        this.deinitMonitorMap();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
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

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.currentTelState = iGlobalTelephoneStateStruct;
    }

    void initMonitorMap() {
        this.cmdMonitorMap.add(1000, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1001, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1002, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1003, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1004, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1005, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1006, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1007, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1008, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1009, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1010, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1011, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1012, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1013, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1014, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1015, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1016, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1017, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1018, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1019, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1020, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1021, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1022, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1023, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1024, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1025, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1026, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1027, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1028, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1029, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1030, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1031, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1032, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1033, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1034, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1035, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1036, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1037, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1038, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1039, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1040, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1041, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1042, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1043, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1044, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1045, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1046, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1047, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1048, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1049, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1050, new Monitor(this.cmdListLogChannel));
        this.cmdMonitorMap.add(1051, new Monitor(this.cmdListLogChannel));
    }

    void initMutexMap() {
        this.cmdMutexMap.add(1000, new Object());
        this.cmdMutexMap.add(1001, new Object());
        this.cmdMutexMap.add(1002, new Object());
        this.cmdMutexMap.add(1003, new Object());
        this.cmdMutexMap.add(1004, new Object());
        this.cmdMutexMap.add(1005, new Object());
        this.cmdMutexMap.add(1006, new Object());
        this.cmdMutexMap.add(1007, new Object());
        this.cmdMutexMap.add(1008, new Object());
        this.cmdMutexMap.add(1009, new Object());
        this.cmdMutexMap.add(1010, new Object());
        this.cmdMutexMap.add(1011, new Object());
        this.cmdMutexMap.add(1012, new Object());
        this.cmdMutexMap.add(1013, new Object());
        this.cmdMutexMap.add(1014, new Object());
        this.cmdMutexMap.add(1015, new Object());
        this.cmdMutexMap.add(1016, new Object());
        this.cmdMutexMap.add(1017, new Object());
        this.cmdMutexMap.add(1018, new Object());
        this.cmdMutexMap.add(1019, new Object());
        this.cmdMutexMap.add(1020, new Object());
        this.cmdMutexMap.add(1021, new Object());
        this.cmdMutexMap.add(1022, new Object());
        this.cmdMutexMap.add(1023, new Object());
        this.cmdMutexMap.add(1024, new Object());
        this.cmdMutexMap.add(1025, new Object());
        this.cmdMutexMap.add(1026, new Object());
        this.cmdMutexMap.add(1027, new Object());
        this.cmdMutexMap.add(1028, new Object());
        this.cmdMutexMap.add(1029, new Object());
        this.cmdMutexMap.add(1030, new Object());
        this.cmdMutexMap.add(1031, new Object());
        this.cmdMutexMap.add(1032, new Object());
        this.cmdMutexMap.add(1033, new Object());
        this.cmdMutexMap.add(1034, new Object());
        this.cmdMutexMap.add(1035, new Object());
        this.cmdMutexMap.add(1036, new Object());
        this.cmdMutexMap.add(1037, new Object());
        this.cmdMutexMap.add(1038, new Object());
        this.cmdMutexMap.add(1039, new Object());
        this.cmdMutexMap.add(1040, new Object());
        this.cmdMutexMap.add(1041, new Object());
        this.cmdMutexMap.add(1042, new Object());
        this.cmdMutexMap.add(1043, new Object());
        this.cmdMutexMap.add(1044, new Object());
        this.cmdMutexMap.add(1045, new Object());
        this.cmdMutexMap.add(1046, new Object());
        this.cmdMutexMap.add(1047, new Object());
        this.cmdMutexMap.add(1048, new Object());
        this.cmdMutexMap.add(1049, new Object());
        this.cmdMutexMap.add(1050, new Object());
        this.cmdMutexMap.add(1051, new Object());
    }

    private void deinitMutexMap() {
        this.cmdMutexMap.clear();
    }

    private void deinitMonitorMap() {
        this.cmdMonitorMap.clear();
    }

    protected Object getDSICallMutex(int n) {
        return this.cmdMutexMap.get(n);
    }

    protected Monitor getDSICallCmdMonitor(int n) {
        return (Monitor)this.cmdMonitorMap.get(n);
    }

    public void setDeviceRole(int n) {
        this.deviceRole = n;
    }

    public int getDeviceRole() {
        return this.deviceRole;
    }

    public int getInstanceID() {
        return this.instanceID;
    }

    public void setIsNadInstance(boolean bl) {
        this.isNadInstance = bl;
    }

    public boolean isNadInstance() {
        return this.isNadInstance;
    }

    protected abstract CommandListManager getCmdListManager();

    protected abstract CommandListManager getHangupCmdListManager();

    protected abstract ITelDSIMobileEquipmentRequestWrapper getDSIRequestWrapper();

    protected abstract String getName();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void acceptCall(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1000);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1000);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#acceptCall] telAcceptMode=%3 Call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                telResultHandlerWrapper.responseAcceptCall(65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#acceptCall] telAcceptMode=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelAcceptCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deleteCallstacksAll(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1048);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1048);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#deleteCallstacksAll] calllist=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
            } else {
                this.log.log(1000000, "[%1(%2)#deleteCallstacksAll] calllist=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelDeleteAllCallStacksCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deleteCallstacksEntry(int n, int n2, boolean bl, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1049);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1049);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#deleteCallstacksEntry] %3 call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)new Buffer().append("callList=").append(n).append(", ").append("clEntryID=").append(n2));
            } else {
                this.log.log(1000000, "[%1(%2)#deleteCallstacksEntry] %3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)new Buffer().append("callList=").append(n).append(", ").append("clEntryID=").append(n2));
                new TelDeleteCallStackEntryCmd(n, n2, this.getDSIRequestWrapper(), this.log, n3, telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dialSOSNumber(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.currentTelState;
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isDialSOSNumberPossible(string)) {
            Object object = this.getDSICallMutex(1005);
            synchronized (object) {
                Monitor monitor = this.getDSICallCmdMonitor(1005);
                if (monitor.isActive()) {
                    this.log.log(1000000, "[%1(%2)#dialSOSNumber] telNumber=%3 call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                    telResultHandlerWrapper.responseDialNumber(65538, 0, null, n);
                } else {
                    this.log.log(1000000, "[%1(%2)#dialSOSNumber] telNumber=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                    new TelDialNumberCmd(string, this.getDSIRequestWrapper(), this.log, n, telResultHandlerWrapper, this.getApplication().getDialSuppServiceHandler()).schedule(this.getCmdListManager(), monitor);
                }
            }
        } else {
            this.log.log(1000000, "[%1(%2)#dialSOSNumber] telNumber=%3: dialing not possible!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
            telResultHandlerWrapper.responseDialNumber(65540, 0, null, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dialNumber(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.currentTelState;
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isOperatorCallViaNadPresent()) {
            this.log.log(1000000, "[%1(%2)#dialNumber]: dialing not possible! Operator call active", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
            telResultHandlerWrapper.responseDialNumber(65541, 0, null, n);
        } else if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isDialNumberPossible(string)) {
            Object object = this.getDSICallMutex(1005);
            synchronized (object) {
                Monitor monitor = this.getDSICallCmdMonitor(1005);
                if (monitor.isActive()) {
                    this.log.log(1000000, "[%1(%2)#dialNumber] telNumber=%3 call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                    telResultHandlerWrapper.responseDialNumber(65538, 0, null, n);
                } else {
                    this.log.log(1000000, "[%1(%2)#dialNumber] telNumber=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                    new TelDialNumberCmd(string, this.getDSIRequestWrapper(), this.log, n, telResultHandlerWrapper, this.getApplication().getDialSuppServiceHandler()).schedule(this.getCmdListManager(), monitor);
                }
            }
        } else {
            this.log.log(1000000, "[%1(%2)#dialNumber] telNumber=%3: dialing not possible!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
            telResultHandlerWrapper.responseDialNumber(65540, 0, null, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, boolean bl, int n3, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.currentTelState;
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isOperatorCallViaNadPresent()) {
            this.log.log(1000000, "[%1(%2)#dialNumberFromDBEntry]: dialing not possible! Operator call active", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
            telResultHandlerWrapper.responseDialNumber(65541, 0, null, n3);
        } else if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isDialNumberPossible(string)) {
            Object object = this.getDSICallMutex(1005);
            synchronized (object) {
                Monitor monitor = this.getDSICallCmdMonitor(1005);
                if (monitor.isActive()) {
                    this.log.log(1000000, "[%1(%2)#dialNumberFromDBEntry] %3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)AbstractTelDSIDeviceAccess.getDialNumberFromADBEntryParamBuffer(string, l, string2, s, s2, resourceLocator, n, n2));
                    telResultHandlerWrapper.responseDialNumber(65538, 0, null, n3);
                } else {
                    this.log.log(1000000, "[%1(%2)#dialNumberFromDBEntry] %3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)AbstractTelDSIDeviceAccess.getDialNumberFromADBEntryParamBuffer(string, l, string2, s, s2, resourceLocator, n, n2));
                    new TelDialNumberFromADBEntryCmd(string, l, string2, s, s2, resourceLocator, n, n2, this.getDSIRequestWrapper(), this.log, n3, telResultHandlerWrapper, this.getApplication().getDialSuppServiceHandler()).schedule(this.getCmdListManager(), monitor);
                }
            }
        } else {
            this.log.log(1000000, "[%1(%2)#dialNumberFromDBEntry] %3: dialing not possible!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)AbstractTelDSIDeviceAccess.getDialNumberFromADBEntryParamBuffer(string, l, string2, s, s2, resourceLocator, n, n2));
            telResultHandlerWrapper.responseDialNumber(65540, 0, null, n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dialOperator(int n, String string, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1005);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1005);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#dialOperator] callType=%3, telNumber=%4: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(n), (Object)string);
                telResultHandlerWrapper.responseDialOperator(65538, null, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#dialOperator] callType=%3, telNumber=%4", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(n), (Object)string);
                new TelDialOperatorCmd(string, n, this.getDSIRequestWrapper(), this.log, n2, this.getApplication().getDSIDefaultResponseErrorHandler(), bl, telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void hangupCall(final int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1001);
        synchronized (object) {
            boolean bl2 = this.isHangupBlocked(n);
            Monitor monitor = (Monitor)this.hangupMonitorMap.get(new Integer(n));
            if (bl2 || monitor != null && monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#hangupCall] callID=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                telResultHandlerWrapper.responseHangupCall(65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#hangupCall] callID=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelHangupCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getHangupCmdListManager(), new Monitor(this.log){

                    public void prologue(CommandList commandList) {
                        AbstractTelDSIDeviceAccess.this.hangupMonitorMap.put(new Integer(n), this);
                        super.prologue(commandList);
                    }

                    public void epilogue(CommandList commandList) {
                        super.epilogue(commandList);
                        AbstractTelDSIDeviceAccess.this.hangupMonitorMap.remove(new Integer(n));
                    }
                });
            }
        }
    }

    private boolean isHangupBlocked(int n) {
        if (this.currentTelState != null) {
            CallStateStruct callStateStruct = this.currentTelState.getCallStateForRole(this.getDeviceRole());
            AbstractPhoneCall[] abstractPhoneCallArray = callStateStruct.getPhoneCalls();
            for (int i2 = 0; i2 < abstractPhoneCallArray.length; ++i2) {
                AbstractPhoneCall abstractPhoneCall = abstractPhoneCallArray[i2];
                if (abstractPhoneCall.telCallID != n || abstractPhoneCall.telCallState != 5) continue;
                this.log.log(1000000, "[%1(%2)#hangupCall] callID=%3: is in Disconnecting --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void joinCalls(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1004);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1004);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#joinCalls] call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
                telResultHandlerWrapper.responseJoinCalls(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#joinCalls]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
                new TelJoinCallsCmd(this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestAbortNetworkRegistration() {
        Object object = this.getDSICallMutex(1008);
        synchronized (object) {
            Monitor monitor;
            this.log.log(1000000, "[%1(%2)#requestAbortNetworkRegistration]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
            TelNetworkRegistrationCmd telNetworkRegistrationCmd = this.networkRegistrationCmd;
            if (telNetworkRegistrationCmd != null) {
                telNetworkRegistrationCmd.setAbortedByUser(true);
            }
            if ((monitor = this.getDSICallCmdMonitor(1008)) != null) {
                monitor.stopMonitoredLists(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestAbortNetworkSearch() {
        Object object = this.getDSICallMutex(1010);
        synchronized (object) {
            Monitor monitor;
            this.log.log(1000000, "[%1(%2)#requestAbortNetworkSearch]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
            TelNetworkSearchCmd telNetworkSearchCmd = this.networkSearchCmd;
            if (telNetworkSearchCmd != null) {
                telNetworkSearchCmd.setAbortedByUser(true);
            }
            if ((monitor = this.getDSICallCmdMonitor(1010)) != null) {
                monitor.stopMonitoredLists(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestCallForward(CFRequestData[] cFRequestDataArray, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1012);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1012);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestCallForward] telCFRequestData=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)Converter.array2String(cFRequestDataArray));
                telResultHandlerWrapper.responseCallForward(null, 65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestCallForward] telCFRequestData=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)Converter.array2String(cFRequestDataArray));
                this.callForwardCommand = new TelCallForwardCmd(cFRequestDataArray, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper);
                this.callForwardCommand.schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestCallWaiting(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1013);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1013);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestCallWaiting] telCWMode=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                telResultHandlerWrapper.responseCallWaiting(n, -1, 65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestCallWaiting] telCWMode=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                this.callWaitingCommand = new TelCallWaitingCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper);
                this.callWaitingCommand.schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestChangeSIMCode(int n, String string, String string2, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1026);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1026);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestChangeSIMCode] %3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)AbstractTelDSIDeviceAccess.getRequestChangeSIMCodeParamBuffer(n, string, string2));
                telResultHandlerWrapper.responseChangeSIMCode(n, 65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestChangeSIMCode] %3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)AbstractTelDSIDeviceAccess.getRequestChangeSIMCodeParamBuffer(n, string, string2));
                new TelChangeSIMCodeCmd(n, string, string2, this.getDSIRequestWrapper(), this.log, n2, telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestCLIR(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1014);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1014);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestCLIR] telCLIRState=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                telResultHandlerWrapper.responseCLIR(-1, -1, 65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestCLIR] telCLIRState=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                this.clirCommand = new TelRequestCLIRCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper);
                this.clirCommand.schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestDecreaseMicGainLevel(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1035);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1035);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestDecreaseMicGainLevel] value=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)s);
            } else {
                this.log.log(1000000, "[%1(%2)#requestDecreaseMicGainLevel] value=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)s);
                new TelDecreaseMicGainLevelCmd(s, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestIncreaseMicGainLevel(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1036);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1036);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestIncreaseMicGainLevel] value=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)s);
            } else {
                this.log.log(1000000, "[%1(%2)#requestIncreaseMicGainLevel] value=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)s);
                new TelIncreaseMicGainLevelCmd(s, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestNetworkRegistration(String string, int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1008);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1008);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestNetworkRegistration] telNumProviderName=%3, telRegMode=%4: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string, (long)n);
                telResultHandlerWrapper.responseNetworkRegistration(65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestNetworkRegistration] telNumProviderName=%3, telRegMode=%4", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string, (long)n);
                this.networkRegistrationCmd = new TelNetworkRegistrationCmd(string, n, this.getDSIRequestWrapper(), this.log, n2, telResultHandlerWrapper);
                this.networkRegistrationCmd.schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestNetworkSearch(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1010);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1010);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestNetworkSearch] call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
                telResultHandlerWrapper.responseNetworkSearch(null, 65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestNetworkSearch]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
                this.networkSearchCmd = new TelNetworkSearchCmd(this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper);
                this.networkSearchCmd.schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abortCallerIDRequest() {
        Object object = this.getDSICallMutex(1014);
        synchronized (object) {
            Monitor monitor;
            this.log.log(1000000, "[%1(%2)#abortCallerIDRequest]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
            TelRequestCLIRCmd telRequestCLIRCmd = this.clirCommand;
            if (telRequestCLIRCmd != null) {
                telRequestCLIRCmd.setAbortedByUser(true);
            }
            if ((monitor = this.getDSICallCmdMonitor(1014)) != null) {
                monitor.stopMonitoredLists(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abortCallForwardRequest() {
        Object object = this.getDSICallMutex(1012);
        synchronized (object) {
            Monitor monitor;
            this.log.log(1000000, "[%1(%2)#abortCallForwardRequest]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
            TelCallForwardCmd telCallForwardCmd = this.callForwardCommand;
            if (telCallForwardCmd != null) {
                telCallForwardCmd.setAbortedByUser(true);
            }
            if ((monitor = this.getDSICallCmdMonitor(1012)) != null) {
                monitor.stopMonitoredLists(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abortCallWaitingRequest() {
        Object object = this.getDSICallMutex(1013);
        synchronized (object) {
            Monitor monitor;
            this.log.log(1000000, "[%1(%2)#abortCallWaitingRequest]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
            TelCallWaitingCmd telCallWaitingCmd = this.callWaitingCommand;
            if (telCallWaitingCmd != null) {
                telCallWaitingCmd.setAbortedByUser(true);
            }
            if ((monitor = this.getDSICallCmdMonitor(1013)) != null) {
                monitor.stopMonitoredLists(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetAutomaticEmergencyCallActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1019);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1019);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetAutomaticEmergencyCallActive] automaticEmergencyCallActive=%3: call already active --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                telResultHandlerWrapper.responseSetAutomaticEmergencyCallActive(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetAutomaticEmergencyCallActive] automaticEmergencyCallActive=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelSetAutomaticEmergencyCallActiveCmd(bl, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetAutomaticPinEntryActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1016);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1016);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetAutomaticPinEntryActive] automaticPinEntryActive=%3: call already active --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                telResultHandlerWrapper.responseSetAutomaticPinEntryActive(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetAutomaticPinEntryActive] automaticPinEntryActive=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelSetAutomaticPinEntryActiveCmd(bl, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetAutomaticRedialActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1017);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1017);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetAutomaticRedialActive] automaticRedialActive=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                telResultHandlerWrapper.responseSetAutomaticRedialActive(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetAutomaticRedialActive] automaticRedialActive=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelSetAutomaticRedialActiveCmd(bl, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetCDMAThreeWayCallingSetting(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1018);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1018);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetCDMAThreeWayCallingSetting] cdmaThreeWayCallingSetting=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                telResultHandlerWrapper.responseSetCDMAThreeWayCallingSetting(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetCDMAThreeWayCallingSetting] cdmaThreeWayCallingSetting=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelSetCDMAThreeWayCallingSettingCmd(bl, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetEnhancedPrivacyMode(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1020);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1020);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetEnhancedPrivacyMode] enhancedPrivacyMode=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetEnhancedPrivacyMode] enhancedPrivacyMode=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelSetEnhancedPrivacyModeCmd(bl, this.getDSIRequestWrapper(), this.log, n, telResultHandlerWrapper, this.getApplication().getEPMHandler()).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetESIMActive(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1047);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1047);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetESIMActive] active=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                telResultHandlerWrapper.responseSetESIMActive(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetESIMActive] active=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelSetESIMActiveCmd(bl, this.getDSIRequestWrapper(), this.log, n, telResultHandlerWrapper, this.getApplication().getEPMHandler()).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetHandsFreeMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1027);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1027);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetHandsFreeMode] telHFMode=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(n));
                telResultHandlerWrapper.responseSetHandsFreeMode(65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetHandsFreeMode] telHFMode=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelSetHandsFreeModeCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetLanguage(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1029);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1029);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetLanguage] language=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetLanguage] language=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                new TelSetLanguageCmd(string, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetMailboxContent(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1021);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1021);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetMailboxContent] mailboxNumber=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                telResultHandlerWrapper.responseSetMailboxContent(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetMailboxContent] mailboxNumber=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                new TelSetMailboxNumberCmd(string, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetMicGainLevel(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1034);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1034);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetMicGainLevel] micGainLevel=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetMicGainLevel] micGainLevel=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelSetMicGainLevelCmd(n, this.getDSIRequestWrapper(), this.log, n2, telResultHandlerWrapper, this.getApplication().getEPMHandler()).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetMICMuteState(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1028);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1028);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetMICMuteState] telMICMuteState=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                telResultHandlerWrapper.responseSetMICMuteState(65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetMICMuteState] telMICMuteState=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelSetMicMuteStateCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetNADMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1038);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1038);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetNADMode] nadMode=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                telResultHandlerWrapper.responseSetNADMode(-1, 65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetNADMode] nadMode=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelSetNadModeCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetOptimizationMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1037);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1037);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetOptimizationMode] optMode=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                telResultHandlerWrapper.responseSetOptimizationMode(-1, 65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetOptimizationMode] optMode=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelSetOptimizationModeCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetPhoneRingtone(int n, String string, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1044);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1044);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetPhoneRingtone] ringtoneIndex=%3, ringtonePath=%4: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(n), (Object)string);
                telResultHandlerWrapper.responseSetPhoneRingtone(65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetPhoneRingtone] ringtoneIndex=%3, ringtonePath=%4", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(n), (Object)string);
                new TelSetPhoneRingtoneCmd(n, string, this.getDSIRequestWrapper(), this.log, n2, telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetPrivacyMode(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1022);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1022);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetPrivacyMode] active=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                telResultHandlerWrapper.responseSetPrivacyMode(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetPrivacyMode] active=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelSetPrivacyModeCmd(bl, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSIMPINRequired(String string, boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1030);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1030);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSIMPINRequired] telCurrentCode=%3, simPINrequired=%4: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string, (Object)String.valueOf(bl));
                telResultHandlerWrapper.responseSIMPINRequired(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSIMPINRequired] telCurrentCode=%3, simPINrequired=%4", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string, (Object)String.valueOf(bl));
                new TelSIMPINRequiredCmd(string, bl, this.getDSIRequestWrapper(), this.log, n, telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestTelPower(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1023);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1023);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestTelPower] telPower=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                telResultHandlerWrapper.responseTelPower(65538, n2);
            } else {
                this.log.log(1000000, "[%1(%2)#requestTelPower] telPower=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)n);
                new TelSetTelPowerCmd(n, this.getDSIRequestWrapper(), this.log, n2, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestUnlockSIM(int n, String string, String string2, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1024);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1024);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestUnlockSIM] %3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)AbstractTelDSIDeviceAccess.getRequestUnlockSimParamBuffer(n, string, string2));
                telResultHandlerWrapper.responseUnlockSIM(65538, n2, null);
            } else {
                this.log.log(1000000, "[%1(%2)#requestUnlockSIM] %3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)AbstractTelDSIDeviceAccess.getRequestUnlockSimParamBuffer(n, string, string2));
                new TelUnlockSIMCmd(n, string, string2, this.getDSIRequestWrapper(), this.log, n2, telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetMissedCallIndicator(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1050);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1050);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#resetMissedCallIndicator] useDefaultErrorHandling=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
            } else {
                this.log.log(1000000, "[%1(%2)#resetMissedCallIndicator] useDefaultErrorHandling=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelResetMissedCallIndicator(this.getDSIRequestWrapper(), this.log, n, telResultHandlerWrapper, this.getApplication().getEPMHandler()).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void restoreFactorySettings(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1031);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1031);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#restoreFactorySettings] call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
                telResultHandlerWrapper.responseRestoreFactorySettings(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#restoreFactorySettings]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
                new TelRestoreFactorySettingsCmd(this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendDTMF(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1007);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1007);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#sendDTMF] telDTMF=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                telResultHandlerWrapper.responseSendDTMF(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#sendDTMF] telDTMF=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)string);
                new TelSendDTMFCmd(string, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void splitCall(short s, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1003);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1003);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#splitCall] telCallID=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)s);
                telResultHandlerWrapper.responseSplitCall(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#splitCall] telCallID=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (long)s);
                new TelSplitCallCmd(s, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void swapCalls(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1003);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1003);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#swapCalls] call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
                telResultHandlerWrapper.responseSwapCalls(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#swapCalls]", (Object)this.getName(), (Object)this.getInstanceAndRoleString());
                new TelSwapCallsCmd(this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void revertCallstacks(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1051);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1051);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#revertCallstacks] isReverted=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
            } else {
                this.log.log(1000000, "[%1(%2)#revertCallstacks] isReverted=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelRevertCallStacksCmd(bl, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestSetPhoneReminderSetting(boolean bl, boolean bl2, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
        TelResultHandlerWrapper telResultHandlerWrapper = new TelResultHandlerWrapper(this.responseDispatcher, this.getApplication().getDSIDefaultResponseErrorHandler(), iTelDSIResponseListener, bl2, iTelDSIResponseListenerArray);
        Object object = this.getDSICallMutex(1042);
        synchronized (object) {
            Monitor monitor = this.getDSICallCmdMonitor(1042);
            if (monitor.isActive()) {
                this.log.log(1000000, "[%1(%2)#requestSetPhoneReminderSetting] phoneReminderSetting=%3: call already in progress --> NOP!", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                telResultHandlerWrapper.responseSetPhoneReminderSetting(65538, n);
            } else {
                this.log.log(1000000, "[%1(%2)#requestSetPhoneReminderSetting] phoneReminderSetting=%3", (Object)this.getName(), (Object)this.getInstanceAndRoleString(), (Object)String.valueOf(bl));
                new TelSetPhoneReminderSettingCmd(bl, this.getDSIRequestWrapper(), this.log, n, (ITelDSIResponseListener)telResultHandlerWrapper).schedule(this.getCmdListManager(), monitor);
            }
        }
    }
}

