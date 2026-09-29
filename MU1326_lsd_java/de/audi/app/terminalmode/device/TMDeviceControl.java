/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.device.IDeviceVariantsHandling;
import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.device.TMDeviceControl$1;
import de.audi.app.terminalmode.device.TMDeviceControl$2;
import de.audi.app.terminalmode.device.TMDeviceControl$3;
import de.audi.app.terminalmode.device.TMDeviceControl$4;
import de.audi.app.terminalmode.device.TMDeviceControl$5;
import de.audi.app.terminalmode.device.TMDeviceControl$6;
import de.audi.app.terminalmode.device.TMDeviceControl$IDeviceControlToDeviceManager;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$ErrorCode;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.statemachine.StateMachine;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import org.dsi.ifc.smartphoneintegration.Device;

public class TMDeviceControl {
    public static final int ACTIVE_DEVICE_NONE;
    public static final int ACTIVE_DEVICE_CARPLAY;
    public static final int ACTIVE_DEVICE_ANDRIODAUTO;
    public static final int ACTIVE_DEVICE_CARLIFE;
    private static final int ACTIVE_DEVICE_MAINWIZARD_NONE;
    private static final int ACTIVE_DEVICE_MAINWIZARD_CARPLAY;
    private static final int ACTIVE_DEVICE_MAINWIZARD_ANDROIDAUTO;
    private static final int ACTIVE_DEVICE_MAINWIZARD_CARLIFE;
    public static final long DETACHING_TIMEOUT;
    public static final long DETACHING_TIMEOUT_OLD_CONNECTOR;
    public static final long ACTIVATING_SUBSYSTEM_TIMEOUT;
    public static final long CONNECTING_TIMEOUT;
    public static final int SUPRESS_AUTOMATIC_ACTIVATIONS_TIMOUT;
    public static final int MAXIMAL_RETRIES_AFTER_CONNECTIONSTATE_FAILED_DEVICE_LOCKED;
    public static final int DEVICE_DISCOVERED_DEBOUNE_TIME_FOR_OLD_MEDIA_CONNETOR;
    private final TMDevice tmDevice;
    private final TMDeviceControl$IDeviceControlToDeviceManager deviceControlToDeviceManager;
    private final IContext context;
    private final LogChannel lc;
    private String logTag;
    private final StateMachine sm;
    private final IDispatcher dispatcher;
    private final IStateHandler stateHandler;
    private final IEventBus eventBus;
    private final IDSISmartphoneManager dsiManager;
    private final ITimeSource timeSource;
    private final IDeviceVariantsHandling deviceVariantsHandling;
    private final IDSISmartphoneManager$ISmartphoneProperties smartphoneProperties;
    private volatile PhysicalDevice lastDevice;
    static /* synthetic */ Class class$de$audi$atip$utils$dispatching$IDispatcher;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DeviceLocked;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching;
    static /* synthetic */ Class class$de$audi$app$terminalmode$ITMDeviceSubsystem;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp;

    public TMDeviceControl(IContext iContext, TMDevice tMDevice, TMDeviceControl$IDeviceControlToDeviceManager iDeviceControlToDeviceManager, IStateHandler iStateHandler, ITimeSource iTimeSource, IDeviceVariantsHandling iDeviceVariantsHandling, IDSISmartphoneManager$ISmartphoneProperties iDSISmartphoneManager$ISmartphoneProperties) {
        this.tmDevice = tMDevice;
        this.deviceControlToDeviceManager = iDeviceControlToDeviceManager;
        this.smartphoneProperties = iDSISmartphoneManager$ISmartphoneProperties;
        this.context = iContext;
        this.lc = iContext.getLogger().main();
        this.logTag = new StringBuffer().append("TMDeviceControl(").append(tMDevice.getDevicename()).append(")").toString();
        this.stateHandler = iStateHandler;
        this.dispatcher = (IDispatcher)iContext.get(class$de$audi$atip$utils$dispatching$IDispatcher == null ? (class$de$audi$atip$utils$dispatching$IDispatcher = TMDeviceControl.class$("de.audi.atip.utils.dispatching.IDispatcher")) : class$de$audi$atip$utils$dispatching$IDispatcher);
        this.sm = new TMDeviceControl$SM(this);
        this.eventBus = iContext.getEventBus();
        this.dsiManager = iContext.getSmartphoneDSIManager();
        this.deviceVariantsHandling = iDeviceVariantsHandling;
        this.lastDevice = new PhysicalDevice(new Device(), iContext.getSMIDSIController());
        this.sm.start();
        this.timeSource = iTimeSource;
    }

    public void activateDevice() {
        this.dispatcher.execute(new TMDeviceControl$1(this));
    }

    public void activateOtherModeforDevice() {
        this.dispatcher.execute(new TMDeviceControl$2(this));
    }

    public void deactivateDevice() {
        this.dispatcher.execute(new TMDeviceControl$3(this, this.logTag));
    }

    public TMDeviceControl setUserAcceptState(TMDevice$UserAcceptState tMDevice$UserAcceptState) {
        return this.setUserAcceptState(tMDevice$UserAcceptState, true);
    }

    public TMDeviceControl setUserAcceptState(TMDevice$UserAcceptState tMDevice$UserAcceptState, boolean bl) {
        this.dispatcher.execute(new TMDeviceControl$4(this, this.logTag, tMDevice$UserAcceptState));
        return this;
    }

    public TMDeviceControl setStoreUserAcceptState(boolean bl) {
        this.dispatcher.execute(new TMDeviceControl$5(this, this.logTag, bl));
        return this;
    }

    public void deleteFromPersistence() {
        this.dispatcher.execute(new TMDeviceControl$6(this, this.logTag));
    }

    public TMDevice getTmDevice() {
        return this.tmDevice;
    }

    void deviceDiscovered(PhysicalDevice physicalDevice) {
        this.sm.sendMessage(1, physicalDevice);
    }

    void deviceIsNotDiscovered() {
        this.sm.sendMessage(4);
    }

    void setConnectionStateByDSIState(int n) {
        switch (n) {
            case 1: {
                this.sm.sendMessage(5);
                break;
            }
            case 3: {
                this.sm.sendMessage(9);
                break;
            }
            case 0: {
                this.sm.sendMessage(8);
                break;
            }
            case 2: {
                this.sm.sendMessage(6);
                break;
            }
            default: {
                this.sm.sendMessage(7, n);
            }
        }
    }

    void connectDeviceFailed(SmartphoneIntegrationDSILifecycleController$ErrorCode smartphoneIntegrationDSILifecycleController$ErrorCode) {
        this.sm.sendMessage(13, smartphoneIntegrationDSILifecycleController$ErrorCode);
    }

    void activationConfirmed() {
        this.sm.sendMessage(2);
    }

    void deactivationConfirmed() {
        this.sm.sendMessage(3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void changeConnectionState(TMDevice$ConnectionState tMDevice$ConnectionState, String string) {
        boolean bl = false;
        TMDevice tMDevice = this.tmDevice;
        synchronized (tMDevice) {
            if (this.tmDevice.connectionState().isNot(tMDevice$ConnectionState)) {
                this.lc.log(-2137614336, "[%1.changeConnectionState] %2 -> %3, because %4", (Object)this.logTag, (Object)this.tmDevice.connectionState(), (Object)tMDevice$ConnectionState, (Object)string);
                this.tmDevice.setConnectionState(tMDevice$ConnectionState);
                bl = true;
            }
        }
        if (bl) {
            this.deviceControlToDeviceManager.notifyAboutChange(this.tmDevice, string);
        }
    }

    void deviceDiscoveredPhoneCallActive(PhysicalDevice physicalDevice) {
        this.sm.sendMessage(17, physicalDevice);
    }

    void phoneCallEnded() {
        this.sm.sendMessage(18);
    }

    public String toString() {
        return this.logTag;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ String access$000(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.logTag;
    }

    static /* synthetic */ LogChannel access$100(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.lc;
    }

    static /* synthetic */ IContext access$200(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.context;
    }

    static /* synthetic */ TMDevice access$600(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.tmDevice;
    }

    static /* synthetic */ TMDeviceControl$IDeviceControlToDeviceManager access$700(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.deviceControlToDeviceManager;
    }

    static /* synthetic */ void access$1000(TMDeviceControl tMDeviceControl, TMDevice$ConnectionState tMDevice$ConnectionState, String string) {
        tMDeviceControl.changeConnectionState(tMDevice$ConnectionState, string);
    }

    static /* synthetic */ PhysicalDevice access$1400(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.lastDevice;
    }

    static /* synthetic */ IStateHandler access$1600(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.stateHandler;
    }

    static /* synthetic */ ITimeSource access$2000(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.timeSource;
    }

    static /* synthetic */ IEventBus access$2300(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.eventBus;
    }

    static /* synthetic */ IDSISmartphoneManager access$3800(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.dsiManager;
    }

    static /* synthetic */ IDSISmartphoneManager$ISmartphoneProperties access$3900(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.smartphoneProperties;
    }

    static /* synthetic */ IDeviceVariantsHandling access$5400(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.deviceVariantsHandling;
    }

    static /* synthetic */ StateMachine access$5500(TMDeviceControl tMDeviceControl) {
        return tMDeviceControl.sm;
    }

    static /* synthetic */ String access$002(TMDeviceControl tMDeviceControl, String string) {
        tMDeviceControl.logTag = string;
        return tMDeviceControl.logTag;
    }

    static /* synthetic */ PhysicalDevice access$1402(TMDeviceControl tMDeviceControl, PhysicalDevice physicalDevice) {
        tMDeviceControl.lastDevice = physicalDevice;
        return tMDeviceControl.lastDevice;
    }
}

