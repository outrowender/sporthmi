/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.ConvenientCommandList;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITMDeviceSubsystem;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.IDeviceVariantsHandling;
import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.app.terminalmode.statemachine.commands.StopService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Subscription;
import de.audi.atip.utils.statemachine.Handler;
import de.audi.atip.utils.statemachine.Message;
import de.audi.atip.utils.statemachine.State;
import de.audi.atip.utils.statemachine.StateMachine;
import de.audi.atip.utils.statemachine.StateMachineInflator;
import de.audi.atip.utils.statemachine.SyncPoint;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import org.dsi.ifc.smartphoneintegration.Device;

public class TMDeviceControl {
    public static final int ACTIVE_DEVICE_NONE = 0;
    public static final int ACTIVE_DEVICE_CARPLAY = 1;
    public static final int ACTIVE_DEVICE_ANDRIODAUTO = 2;
    public static final int ACTIVE_DEVICE_CARLIFE = 3;
    private static final int ACTIVE_DEVICE_MAINWIZARD_NONE = 18;
    private static final int ACTIVE_DEVICE_MAINWIZARD_CARPLAY = 16;
    private static final int ACTIVE_DEVICE_MAINWIZARD_ANDROIDAUTO = 17;
    private static final int ACTIVE_DEVICE_MAINWIZARD_CARLIFE = 19;
    public static final long DETACHING_TIMEOUT = 5000L;
    public static final long DETACHING_TIMEOUT_OLD_CONNECTOR = 10000L;
    public static final long ACTIVATING_SUBSYSTEM_TIMEOUT = 10000L;
    public static final long CONNECTING_TIMEOUT = 30000L;
    public static final int SUPRESS_AUTOMATIC_ACTIVATIONS_TIMOUT = 10000;
    public static final int MAXIMAL_RETRIES_AFTER_CONNECTIONSTATE_FAILED_DEVICE_LOCKED = 2;
    public static final int DEVICE_DISCOVERED_DEBOUNE_TIME_FOR_OLD_MEDIA_CONNETOR = 2000;
    private final TMDevice tmDevice;
    private final IDeviceControlToDeviceManager deviceControlToDeviceManager;
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
    private final IDSISmartphoneManager.ISmartphoneProperties smartphoneProperties;
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

    public TMDeviceControl(IContext iContext, TMDevice tMDevice, IDeviceControlToDeviceManager iDeviceControlToDeviceManager, IStateHandler iStateHandler, ITimeSource iTimeSource, IDeviceVariantsHandling iDeviceVariantsHandling, IDSISmartphoneManager.ISmartphoneProperties iSmartphoneProperties) {
        this.tmDevice = tMDevice;
        this.deviceControlToDeviceManager = iDeviceControlToDeviceManager;
        this.smartphoneProperties = iSmartphoneProperties;
        this.context = iContext;
        this.lc = iContext.getLogger().main();
        this.logTag = new StringBuffer().append("TMDeviceControl(").append(tMDevice.getDevicename()).append(")").toString();
        this.stateHandler = iStateHandler;
        this.dispatcher = (IDispatcher)iContext.get(class$de$audi$atip$utils$dispatching$IDispatcher == null ? (class$de$audi$atip$utils$dispatching$IDispatcher = TMDeviceControl.class$("de.audi.atip.utils.dispatching.IDispatcher")) : class$de$audi$atip$utils$dispatching$IDispatcher);
        this.sm = new SM();
        this.eventBus = iContext.getEventBus();
        this.dsiManager = iContext.getSmartphoneDSIManager();
        this.deviceVariantsHandling = iDeviceVariantsHandling;
        this.lastDevice = new PhysicalDevice(new Device(), iContext.getSMIDSIController());
        this.sm.start();
        this.timeSource = iTimeSource;
    }

    public void activateDevice() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                TMDeviceControl.this.deviceControlToDeviceManager.requestActivation(TMDeviceControl.this);
            }
        });
    }

    public void activateOtherModeforDevice() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                TMDeviceControl.this.deviceControlToDeviceManager.requestOtherModeActivation(TMDeviceControl.this);
            }
        });
    }

    public void deactivateDevice() {
        this.dispatcher.execute(new AbstractDispatcherRunnable(this.logTag){

            public void run() {
                TMDeviceControl.this.deviceControlToDeviceManager.requestDeactivation(TMDeviceControl.this);
            }
        });
    }

    public TMDeviceControl setUserAcceptState(TMDevice.UserAcceptState userAcceptState) {
        return this.setUserAcceptState(userAcceptState, true);
    }

    public TMDeviceControl setUserAcceptState(final TMDevice.UserAcceptState userAcceptState, boolean bl) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(this.logTag){

            public void run() {
                TMDevice.UserAcceptState userAcceptState2 = TMDeviceControl.this.tmDevice.userAcceptState();
                TMDeviceControl.this.lc.log(10000000, "[%1.setUserAcceptState] %2 -> %3", (Object)TMDeviceControl.this.logTag, (Object)userAcceptState2, (Object)userAcceptState);
                TMDeviceControl.this.tmDevice.setUserAcceptState(userAcceptState);
                if (userAcceptState.is(TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED)) {
                    TMDeviceControl.this.tmDevice.setWasDisclaimerPreviouslyAccepted(true);
                }
                TMDeviceControl.this.deviceControlToDeviceManager.notifyAboutChange(TMDeviceControl.this.tmDevice, "setTMActivated");
            }
        });
        return this;
    }

    public TMDeviceControl setStoreUserAcceptState(final boolean bl) {
        this.dispatcher.execute(new AbstractDispatcherRunnable(this.logTag){

            public void run() {
                TMDeviceControl.this.lc.log(1000000, "[%1.setStoreUserAcceptState]  store=%2", (Object)TMDeviceControl.this.logTag, (Object)String.valueOf(bl));
                TMDeviceControl.this.tmDevice.setStoreUserAcceptState(bl);
            }
        });
        return this;
    }

    public void deleteFromPersistence() {
        this.dispatcher.execute(new AbstractDispatcherRunnable(this.logTag){

            public void run() {
                TMDeviceControl.this.sm.sendMessage(14);
            }
        });
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

    void connectDeviceFailed(SmartphoneIntegrationDSILifecycleController.ErrorCode errorCode) {
        this.sm.sendMessage(13, errorCode);
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
    private void changeConnectionState(TMDevice.ConnectionState connectionState, String string) {
        boolean bl = false;
        TMDevice tMDevice = this.tmDevice;
        synchronized (tMDevice) {
            if (this.tmDevice.connectionState().isNot(connectionState)) {
                this.lc.log(10000000, "[%1.changeConnectionState] %2 -> %3, because %4", (Object)this.logTag, (Object)this.tmDevice.connectionState(), (Object)connectionState, (Object)string);
                this.tmDevice.setConnectionState(connectionState);
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

    private class SM
    extends StateMachine {
        private final ISmartphoneIntegrationDSIController dsiController;

        protected SM() {
            super(TMDeviceControl.this.logTag, TMDeviceControl.this.lc, (IDispatcher)TMDeviceControl.this.context.get(class$de$audi$atip$utils$dispatching$IDispatcher == null ? (class$de$audi$atip$utils$dispatching$IDispatcher = TMDeviceControl.class$("de.audi.atip.utils.dispatching.IDispatcher")) : class$de$audi$atip$utils$dispatching$IDispatcher), TMDeviceControlState.getMessageCodeConverter());
            this.dsiController = TMDeviceControl.this.context.getSMIDSIController();
            try {
                new StateMachineInflator(this).inflate();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.setInitialState(this.getStateForClass(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotDiscoveredState")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState));
        }

        public class BaseState
        extends TMDeviceControlState {
            private static final String APPLE_INC = "Apple Inc.-iPhone";

            protected void connectionStateStopped() {
            }

            protected void connectionStateDisconnected() {
            }

            private void updateDevice(PhysicalDevice physicalDevice) {
                if (!TMDeviceControl.this.lastDevice.equals(physicalDevice)) {
                    TMDeviceControl.this.tmDevice.setId(physicalDevice.getDevice().deviceID);
                    if (APPLE_INC.equals(physicalDevice.getDevice().getDeviceName()) && TMDeviceControl.this.tmDevice.getDevicename().length() > 0) {
                        TMDeviceControl.this.lc.log(10000000, "[%1.deviceDiscovered] Device changed: %2 -> %3, retaining old name %4", (Object)TMDeviceControl.this.logTag, (Object)TMDeviceControl.this.lastDevice, (Object)physicalDevice, (Object)TMDeviceControl.this.tmDevice.getDevicename());
                    } else {
                        TMDeviceControl.this.lc.log(10000000, "[%1.deviceDiscovered] Device changed: %2 -> %3", (Object)TMDeviceControl.this.logTag, (Object)TMDeviceControl.this.lastDevice, (Object)physicalDevice);
                        TMDeviceControl.this.tmDevice.setName(physicalDevice.getDevice().getDeviceName());
                    }
                    TMDeviceControl.this.logTag = new StringBuffer().append("TMDeviceControl(").append(TMDeviceControl.this.tmDevice.getDevicename()).append(")").toString();
                    TMDeviceControl.this.lastDevice = physicalDevice;
                }
            }

            public class DeviceLocked
            extends TMDeviceControlState {
                public void enter(Message message) {
                    TMDeviceControl.this.lc.log(100000, "[%1.DeviceLocked.enter] %2", (Object)TMDeviceControl.this.logTag, (Object)TMDeviceControl.this.tmDevice);
                    TMDeviceControl.this.tmDevice.setConnectionState(TMDevice.ConnectionState.NOT_ATTACHED);
                    TMDeviceControl.this.deviceControlToDeviceManager.notifyAboutChange(TMDeviceControl.this.tmDevice, "DeviceLocked");
                }

                protected void activate() {
                    this.enter(SM.this.getCurrentMessage());
                }
            }

            public class DiscoveredState
            extends TMDeviceControlState {
                private int deviceLockedRetriesCounter;

                public DiscoveredState() {
                    this.deviceLockedRetriesCounter = 0;
                }

                public void enter(Message message) {
                    if (TMDeviceControl.this.tmDevice.userAcceptState().isOneOf(TMDevice.UserAcceptState.TM_SELECTED, TMDevice.UserAcceptState.NATIVE) || !TMDeviceControl.this.tmDevice.isStoreUserAcceptState()) {
                        TMDeviceControl.this.lc.log(10000000, "[TMDeviceControl.deviceDiscovered] user accept state change: %1 -> %2", (Object)TMDeviceControl.this.tmDevice.userAcceptState(), (Object)TMDevice.UserAcceptState.INITIAL);
                        TMDeviceControl.this.tmDevice.setUserAcceptState(TMDevice.UserAcceptState.INITIAL);
                    }
                    if (TMDeviceControl.this.tmDevice.userAcceptState().is(TMDevice.UserAcceptState.NATIVE_SELECTED)) {
                        TMDeviceControl.this.lastDevice.disconnectDevice(TMDeviceControl.this);
                    }
                    if (this.deviceLockedRetriesCounter > 2) {
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DeviceLocked == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DeviceLocked = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DeviceLocked")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DeviceLocked);
                    }
                    TMDeviceControl.this.tmDevice.setAttachTime(TMDeviceControl.this.timeSource.getCurrentTime());
                }

                protected void deviceDiscovered(PhysicalDevice physicalDevice) {
                    BaseState.this.updateDevice(physicalDevice);
                    if (TMDeviceControl.this.tmDevice.smartphoneType().is(SmartphoneManager.SmartphoneType.UNKNOWN)) {
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotSupportedState")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState);
                    }
                }

                public class Busy
                extends TMDeviceControlState {
                    protected void deviceNotDiscovered() {
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDetaching);
                    }

                    protected void deactivate() {
                        SM.this.deferMessage(SM.this.getCurrentMessage());
                    }

                    protected void handleDelete() {
                        if (TMDeviceControl.this.context.getConfiguration().supportsDeletionOfConnectedDevices()) {
                            TMDeviceControl.this.lc.log(10000000, "[%1.handleDelete] resetting the device", (Object)TMDeviceControl.this.logTag);
                            TMDeviceControl.this.deviceControlToDeviceManager.requestDeactivation(TMDeviceControl.this);
                            SM.this.deferMessage(SM.this.getCurrentMessage());
                        } else {
                            TMDeviceControl.this.lc.log(100000, "[TMDeviceControl.handleDelete] cannot delete an attached device if not explicitely configured!");
                        }
                    }

                    private void cleanupAndNotify() {
                        ConvenientCommandList convenientCommandList = TMDeviceControl.this.context.getCommandListHelper().create();
                        convenientCommandList.add(TMDeviceControl.this.deviceVariantsHandling.cleanupAfterDeviceDisconnected(TMDeviceControl.this.context, TMDeviceControl.this.stateHandler, TMDeviceControl.this.lc, TMDeviceControl.this.logTag));
                        convenientCommandList.add(new AbstractCommand(TMDeviceControl.this.lc, new StringBuffer().append("NotifyCleanupDone(").append(TMDeviceControl.this.logTag).append(")").toString(), TMDeviceControl.this.context){

                            public void execute() {
                                TMDeviceControl.this.sm.sendMessage(10);
                                this.getCommandList().commandFinished();
                            }
                        });
                        convenientCommandList.execute("TMDeviceControl.Busy.cleanupAndNotify()");
                    }

                    private void deactivateSubsystem() {
                        ITMDeviceSubsystem iTMDeviceSubsystem = (ITMDeviceSubsystem)TMDeviceControl.this.context.get(TMDeviceControl.this.tmDevice.smartphoneType(), class$de$audi$app$terminalmode$ITMDeviceSubsystem == null ? (class$de$audi$app$terminalmode$ITMDeviceSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.ITMDeviceSubsystem")) : class$de$audi$app$terminalmode$ITMDeviceSubsystem);
                        TMDeviceControl.this.lc.log(1000000, "[%1.deactivateSubsystem] deactivating %2", (Object)TMDeviceControl.this.logTag, (Object)iTMDeviceSubsystem);
                        TMDeviceControl.this.context.getCommandListHelper().create().addSingle(new StopService(TMDeviceControl.this.dsiManager, TMDeviceControl.this.context, TMDeviceControl.this.lc, TMDeviceControl.this.stateHandler, TMDeviceControl.this.smartphoneProperties)).execute("TMDeviceControl.Busy.deactivateSubsystem()");
                        iTMDeviceSubsystem.deactivate();
                    }

                    public class Connecting
                    extends TMDeviceControlState {
                        public void enter(Message message) {
                            TMDeviceControl.this.changeConnectionState(TMDevice.ConnectionState.ACTIVATING, "Connecting");
                            TMDeviceControl.this.lastDevice.connectDevice(TMDeviceControl.this);
                            SM.this.dsiController.connectDevice(TMDeviceControl.this.tmDevice.getDeviceId(), TMDeviceControl.this.tmDevice.smartphoneType());
                            SM.this.sendMessageDelayed(12, "CONNECTING_TIMEOUT", 30000L);
                        }

                        protected void connectionStateConnected() {
                            SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem);
                        }

                        protected void connectDeviceFailed(SmartphoneIntegrationDSILifecycleController.ErrorCode errorCode) {
                            this.handleError();
                        }

                        protected void connectionStateFailed(int n) {
                            if (n == 8) {
                                SM.this.sendMessageDelayed(15, 10000L);
                            }
                            if (n == 4) {
                                DiscoveredState.this.deviceLockedRetriesCounter++;
                            }
                            if (n == 6) {
                                TMDeviceControl.this.tmDevice.setUserAcceptState(TMDevice.UserAcceptState.INITIAL).setWasDisclaimerPreviouslyAccepted(false).setStoreUserAcceptState(false).setConnectionState(TMDevice.ConnectionState.ATTACHED);
                                TMDeviceControl.this.deviceControlToDeviceManager.notifyAboutChange(TMDeviceControl.this.tmDevice, "handleNoCarplayDeviceError");
                            }
                            this.handleError();
                        }

                        protected void connectionStateStopped() {
                            this.handleError();
                        }

                        protected void connectionStateDisconnected() {
                            this.handleError();
                        }

                        protected void timeout(String string) {
                            this.handleError();
                        }

                        private void handleError() {
                            SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
                        }

                        public void exit(Message message) {
                            SM.this.removeMessages(12);
                        }

                        protected void deviceNotDiscovered() {
                            SM.this.deferMessage(SM.this.getCurrentMessage());
                        }
                    }

                    public class TearingDown
                    extends TMDeviceControlState {
                        protected void handleDelete() {
                            SM.this.deferMessage(SM.this.getCurrentMessage());
                        }

                        private long getTimeoutConnectorDependent() {
                            return TMDeviceControl.this.context.getConfiguration().usesOldMediaConnector() ? 10000L : 5000L;
                        }

                        public class CleaningUp
                        extends TMDeviceControlState {
                            public void enter(Message message) {
                                Busy.this.cleanupAndNotify();
                            }

                            protected void cleanupDone() {
                                Busy.this.deactivateSubsystem();
                                SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
                            }
                        }

                        public class CleaningUpAndDetaching
                        extends TMDeviceControlState {
                            private static final String CLEANUP_DONE = "CLEANUP_DONE";
                            private static final String DISCONNECTED = "DISCONNECTED";
                            private final SyncPoint cleanedUpAndDetached;

                            public CleaningUpAndDetaching() {
                                this.cleanedUpAndDetached = new SyncPoint.Builder().addRequirement(CLEANUP_DONE).addRequirement(DISCONNECTED).setCallback(new Runnable(){

                                    public void run() {
                                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotDiscoveredState")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState);
                                    }
                                }).setLogChannel(TMDeviceControl.this.lc).setName(TMDeviceControl.this.logTag).build();
                            }

                            public void enter(Message message) {
                                this.cleanedUpAndDetached.reset();
                                TMDeviceControl.this.changeConnectionState(TMDevice.ConnectionState.NOT_ATTACHED, "deviceIsNotDiscovered");
                                Busy.this.cleanupAndNotify();
                                SM.this.sendMessageDelayed(12, "DETACHING_TIMEOUT", TearingDown.this.getTimeoutConnectorDependent());
                            }

                            protected void cleanupDone() {
                                Busy.this.deactivateSubsystem();
                                this.cleanedUpAndDetached.completeRequirement(CLEANUP_DONE);
                            }

                            protected void connectionStateStopped() {
                                TMDeviceControl.this.lc.log(1000000, "[%1.CleaningUpAndDetaching.connectionStateStopped] waiting for disconnected", (Object)TMDeviceControl.this.logTag);
                            }

                            protected void connectionStateDisconnected() {
                                this.cleanedUpAndDetached.completeRequirement(DISCONNECTED);
                            }

                            protected void deviceDiscovered(PhysicalDevice physicalDevice) {
                                SM.this.deferMessage(SM.this.getCurrentMessage());
                            }

                            public void exit(Message message) {
                                SM.this.removeMessages(12);
                            }

                            protected void timeout(String string) {
                                TMDeviceControl.this.lc.log(100000, "[%1.DetachingState.timeout] did not receive disconnected in time!");
                                this.cleanedUpAndDetached.completeRequirement(DISCONNECTED);
                            }
                        }

                        public class CleaningUpAndDisconnecting
                        extends TMDeviceControlState {
                            public void enter(Message message) {
                                Busy.this.cleanupAndNotify();
                            }

                            protected void cleanupDone() {
                                Busy.this.deactivateSubsystem();
                                SM.this.dsiController.disconnectDevice(TMDeviceControl.this.tmDevice.getDeviceId());
                                SM.this.sendMessageDelayed(12, "DETACHING_TIMEOUT", TearingDown.this.getTimeoutConnectorDependent());
                            }

                            protected void connectionStateStopped() {
                                TMDeviceControl.this.lc.log(1000000, "[%1.Disconnecting.connectionStateStopped] waiting for Disconnected", (Object)this.getName());
                            }

                            protected void connectionStateDisconnected() {
                                SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
                            }

                            public void exit(Message message) {
                                SM.this.removeMessages(12);
                            }

                            protected void timeout(String string) {
                                TMDeviceControl.this.lc.log(100000, "[%1.CleaningUpAndDisconnecting.timeout] Waited for disconnected but never got it!");
                                SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
                            }
                        }
                    }

                    public class SubsystemActive
                    extends TMDeviceControlState {
                        protected void connectionStateFailed(int n) {
                            if (n == 4) {
                                DiscoveredState.this.deviceLockedRetriesCounter++;
                            }
                            this.handleError();
                        }

                        protected void connectionStateStopped() {
                            this.handleError();
                        }

                        protected void connectionStateDisconnected() {
                            this.handleError();
                        }

                        private void handleError() {
                            SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUp);
                        }

                        public class Active
                        extends TMDeviceControlState {
                            public void enter(Message message) {
                                TMDeviceControl.this.stateHandler.setServiceStatus(true);
                                TMDeviceControl.this.changeConnectionState(TMDevice.ConnectionState.ACTIVE, "ActivateDeviceSubsystem");
                                TMDeviceControl.this.smartphoneProperties.getPropertySPIServiceState().accept(SPIServiceState.STARTED);
                                this.setHMIDeviceState(true);
                                IAudioManager iAudioManager = TMDeviceControl.this.context.getAudioManager();
                                TMDeviceControl.this.context.getCommandListHelper().create().addSingle(iAudioManager.createAudioConnectionRequest(TMAudioConnection.ANNOUNCEMENT, false)).execute(new StringBuffer().append(TMDeviceControl.this.logTag).append(".Active.enter()").toString());
                                TMDeviceControl.this.eventBus.deviceActivated(TMDeviceControl.this.tmDevice);
                            }

                            protected void deactivate() {
                                SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$TearingDown$CleaningUpAndDisconnecting);
                            }

                            public void exit(Message message) {
                                this.setHMIDeviceState(false);
                                this.resetModels();
                            }

                            private void setHMIDeviceState(boolean bl) {
                                int n = TMDeviceControl.this.tmDevice.isCarplayDevice() ? 1 : (TMDeviceControl.this.tmDevice.isAndroidAutoDevice() ? 2 : 3);
                                this.updateMainWizardModel(bl, n);
                                this.updateTabbarModel(bl, n);
                            }

                            private void updateMainWizardModel(boolean bl, int n) {
                                TMDeviceControl.this.context.getFramework().getHmiServiceApp().getChoiceModel(4239).setValue(bl ? n : 0);
                                int n2 = bl ? (1 == n ? 16 : (2 == n ? 17 : 19)) : 18;
                                int n3 = TMDeviceControl.this.context.getFramework().getHmiServiceApp().getChoiceModel(138).getValue();
                                if (17 == n3 || 16 == n3 || 18 == n3 || 19 == n3) {
                                    TMDeviceControl.this.context.getFramework().getHmiServiceApp().getChoiceModel(138).setValue(n2);
                                }
                            }

                            private void updateTabbarModel(boolean bl, int n) {
                                if (bl) {
                                    if (1 == n) {
                                        TMDeviceControl.this.context.getChoiceModel(4552).setValue(1);
                                    } else {
                                        TMDeviceControl.this.context.getChoiceModel(4552).setValue(2);
                                    }
                                } else {
                                    TMDeviceControl.this.context.getChoiceModel(4552).setValue(0);
                                }
                            }

                            private void resetModels() {
                                TMDeviceControl.this.eventBus.updateNowPlayingData(new TrackDataChangedEvent.Builder().build());
                                TMDeviceControl.this.eventBus.updatePlayPosition(new TrackPlayPositionEvent(0, 0));
                            }
                        }

                        public class ActivatingSubsystem
                        extends TMDeviceControlState {
                            public void enter(Message message) {
                                ITMDeviceSubsystem iTMDeviceSubsystem = (ITMDeviceSubsystem)TMDeviceControl.this.context.get(TMDeviceControl.this.tmDevice.smartphoneType(), class$de$audi$app$terminalmode$ITMDeviceSubsystem == null ? (class$de$audi$app$terminalmode$ITMDeviceSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.ITMDeviceSubsystem")) : class$de$audi$app$terminalmode$ITMDeviceSubsystem);
                                TMDeviceControl.this.lc.log(10000000, "[%1.enter] activating %2", (Object)this.getName(), (Object)iTMDeviceSubsystem);
                                TMDeviceControl.this.changeConnectionState(TMDevice.ConnectionState.ACTIVATING, "ActivateDeviceSubsystem");
                                iTMDeviceSubsystem.activate();
                                SM.this.sendMessageDelayed(12, "ACTIVATING_SUBSYSTEM_TIMEOUT", 10000L);
                            }

                            protected void connectionStateStarted() {
                                SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$Active);
                            }

                            protected void timeout(String string) {
                                ITMDeviceSubsystem iTMDeviceSubsystem = (ITMDeviceSubsystem)TMDeviceControl.this.context.get(TMDeviceControl.this.tmDevice.smartphoneType(), class$de$audi$app$terminalmode$ITMDeviceSubsystem == null ? (class$de$audi$app$terminalmode$ITMDeviceSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.ITMDeviceSubsystem")) : class$de$audi$app$terminalmode$ITMDeviceSubsystem);
                                TMDeviceControl.this.lc.log(1000000, "[%1.ActivatingSubsystem.timeout] deactivating %2", (Object)this.getName(), (Object)iTMDeviceSubsystem);
                                TMDeviceControl.this.context.getCommandListHelper().create().addSingle(new StopService(TMDeviceControl.this.dsiManager, TMDeviceControl.this.context, TMDeviceControl.this.lc, TMDeviceControl.this.stateHandler, TMDeviceControl.this.smartphoneProperties)).execute("TMDeviceControl.ActivatingSubsystem.timeout(String)");
                                iTMDeviceSubsystem.deactivate();
                                SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
                            }

                            public void exit(Message message) {
                                SM.this.removeMessages(12);
                            }
                        }
                    }
                }

                public class ReadyForConnect
                extends TMDeviceControlState {
                    private boolean isDisconnectedInSameState;

                    public ReadyForConnect() {
                        this.isDisconnectedInSameState = false;
                    }

                    public void enter(Message message) {
                        TMDeviceControl.this.changeConnectionState(TMDevice.ConnectionState.ATTACHED, message.toString());
                        if (!(SM.this.getCurrentMessage().getCode() != 16 && SM.this.getCurrentMessage().getCode() != 18 || SM.this.hasMessages(15))) {
                            TMDeviceControl.this.eventBus.readyForActivation(TMDeviceControl.this.tmDevice);
                        } else {
                            TMDeviceControl.this.lc.log(10000000, "[%1.ReadyForConnect.enter] skipped readyForActivation, reason %2%3", (Object)TMDeviceControl.this.logTag, (Object)message.tag, (Object)(SM.this.hasMessages(15) ? ", SUPRESS_AUTOMATIC_ACTIVATIONS_TIMER" : ""));
                        }
                    }

                    protected void activate() {
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$Connecting);
                    }

                    protected void connectionStateFailed(int n) {
                        if (n == 7) {
                            TMDeviceControl.this.lc.log(1000000, "[%1.ReadyForConnect.connectionStateFailed] CONNECTIONSTATE_FAILED_NO_GAL_DEVICE while ReadyForConnect", (Object)this.getName());
                            TMDeviceControl.this.tmDevice.setUserAcceptState(TMDevice.UserAcceptState.NATIVE_SELECTED);
                        }
                    }

                    protected void deviceDiscovered(PhysicalDevice physicalDevice) {
                        TMDeviceControl.this.lc.log(10000000, "[%1.deviceDiscovered] was disconnected in same state: %2", (Object)TMDeviceControl.this.logTag, (Object)(this.isDisconnectedInSameState ? "true" : "false"));
                        if (this.isDisconnectedInSameState && TMDeviceControl.this.tmDevice.userAcceptState().isNot(TMDevice.UserAcceptState.NATIVE_SELECTED)) {
                            TMDeviceControl.this.lc.log(10000000, "[%1.deviceDiscovered] re-activate device", (Object)TMDeviceControl.this.logTag);
                            TMDeviceControl.this.eventBus.readyForActivation(TMDeviceControl.this.tmDevice);
                        }
                    }

                    protected void connectionStateDisconnected() {
                        TMDeviceControl.this.lc.log(10000000, "[%1.connectionStateDisconnected] set disconnected flag", (Object)TMDeviceControl.this.logTag);
                        this.isDisconnectedInSameState = true;
                    }

                    protected void deviceNotDiscovered() {
                        TMDeviceControl.this.context.getChoiceModel(4552).setValue(0);
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotDiscoveredState")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState);
                    }

                    protected void connectionStateConnected() {
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$Busy$SubsystemActive$ActivatingSubsystem);
                    }

                    protected void deactivate() {
                        if (TMDeviceControl.this.context.getConfiguration().usesOldMediaConnector()) {
                            SM.this.sendMessageDelayed(15, 10000L);
                        }
                        TMDeviceControl.this.lastDevice.disconnectDevice(TMDeviceControl.this);
                    }

                    protected void handleDelete() {
                        TMDeviceControl.this.tmDevice.setUserAcceptState(TMDevice.UserAcceptState.INITIAL).setWasDisclaimerPreviouslyAccepted(false).setConnectionState(TMDevice.ConnectionState.ATTACHED);
                        TMDeviceControl.this.deviceControlToDeviceManager.notifyAboutChange(TMDeviceControl.this.tmDevice, "handleDelete");
                        TMDeviceControl.this.eventBus.readyForActivation(TMDeviceControl.this.tmDevice);
                    }
                }
            }

            public class NotSupportedState
            extends TMDeviceControlState {
                public void enter(Message message) {
                    TMDeviceControl.this.lc.log(100000, "[%1.NotSupportedState.enter] %2", (Object)TMDeviceControl.this.logTag, (Object)TMDeviceControl.this.tmDevice);
                    TMDeviceControl.this.tmDevice.setConnectionState(TMDevice.ConnectionState.NOT_ATTACHED);
                    TMDeviceControl.this.deviceControlToDeviceManager.notifyAboutChange(TMDeviceControl.this.tmDevice, "NotSupportedState");
                }

                protected void deviceDiscovered(PhysicalDevice physicalDevice) {
                    BaseState.this.updateDevice(physicalDevice);
                    if (TMDeviceControl.this.tmDevice.smartphoneType().isNot(SmartphoneManager.SmartphoneType.UNKNOWN)) {
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
                    }
                }

                protected void handleDelete() {
                    TMDeviceControl.this.deviceControlToDeviceManager.deleteMe(TMDeviceControl.this);
                }
            }

            public class NotDiscoveredState
            extends TMDeviceControlState {
                public void enter(Message message) {
                    TMDeviceControl.this.changeConnectionState(TMDevice.ConnectionState.NOT_ATTACHED, "deviceIsNotDiscovered");
                }

                public void exit(Message message) {
                    SM.this.removeMessages(16);
                }

                protected void deviceDiscoveredDebounced(PhysicalDevice physicalDevice) {
                    BaseState.this.updateDevice(physicalDevice);
                    if (TMDeviceControl.this.tmDevice.smartphoneType().isNot(SmartphoneManager.SmartphoneType.UNKNOWN)) {
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
                    } else {
                        SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotSupportedState")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotSupportedState);
                    }
                }

                protected void deviceDiscovered(PhysicalDevice physicalDevice) {
                    int n = TMDeviceControl.this.context.getConfiguration().usesOldMediaConnector() && !TMDeviceControl.this.tmDevice.isStoreUserAcceptState() ? 2000 : 0;
                    TMDeviceControl.this.lc.log(1000000, "[%1.deviceDiscovered] %2", (Object)TMDeviceControl.this.logTag, (long)n);
                    SM.this.sendMessageDelayed(16, physicalDevice, n);
                }

                protected void deviceNotDiscovered() {
                    SM.this.removeMessages(16);
                }

                protected void deactivate() {
                    SM.this.removeMessages(16);
                }

                protected void handleDelete() {
                    TMDeviceControl.this.deviceControlToDeviceManager.deleteMe(TMDeviceControl.this);
                }

                protected void connectionStateFailed(int n) {
                    if (n == 6) {
                        TMDeviceControl.this.tmDevice.setUserAcceptState(TMDevice.UserAcceptState.INITIAL).setWasDisclaimerPreviouslyAccepted(false).setStoreUserAcceptState(false).setConnectionState(TMDevice.ConnectionState.ATTACHED);
                        TMDeviceControl.this.deviceControlToDeviceManager.notifyAboutChange(TMDeviceControl.this.tmDevice, "handleNoCarplayDeviceError");
                    }
                }

                protected void deviceDiscoveredPhoneCallActive(PhysicalDevice physicalDevice) {
                    BaseState.this.updateDevice(physicalDevice);
                    SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredPhoneCallActiveState);
                }
            }

            public class DiscoveredPhoneCallActiveState
            extends TMDeviceControlState {
                private Subscription subscribe;

                public void enter(Message message) {
                    TMDeviceControl.this.lastDevice.disconnectDevice(TMDeviceControl.this);
                    this.subscribe = TMDeviceControl.this.stateHandler.getStateApplicationProperty(Application.PHONE).subscribe(new Consumer<ApplicationOwner>(){

                        @Override
                        public void accept(ApplicationOwner applicationOwner) {
                            if (applicationOwner.is(ApplicationOwner.NOBODY)) {
                                SM.this.sendMessage(18);
                            }
                        }

                        @Override
                        public /* synthetic */ void accept(Object object) {
                            this.accept((ApplicationOwner)object);
                        }
                    });
                }

                public void exit(Message message) {
                    this.subscribe.cancel();
                }

                public void phoneCallEnded() {
                    SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$DiscoveredState$ReadyForConnect);
                }

                protected void deviceNotDiscovered() {
                    SM.this.transitionTo(class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState == null ? (class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState = TMDeviceControl.class$("de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$NotDiscoveredState")) : class$de$audi$app$terminalmode$device$TMDeviceControl$SM$BaseState$NotDiscoveredState);
                }

                protected void deviceDiscoveredPhoneCallActive(PhysicalDevice physicalDevice) {
                    TMDeviceControl.this.lc.log(10000000, "[TMDeviceControl.deviceDiscoveredPhoneCallActive] device already on hold");
                }
            }
        }
    }

    private static class TMDeviceControlState
    extends State {
        public static final int DEVICE_DISCOVERED = 1;
        public static final int ACTIVATE = 2;
        public static final int DEACTIVATE = 3;
        public static final int DEVICE_NOT_DISCOVERED = 4;
        public static final int CONNECTIONSTATE_CONNECTED = 5;
        public static final int CONNECTIONSTATE_STARTED = 6;
        public static final int CONNECTIONSTATE_FAILED = 7;
        public static final int CONNECTIONSTATE_DISCONNECTED = 8;
        public static final int CONNECTIONSTATE_STOPPED = 9;
        public static final int CLEANUP_DONE = 10;
        public static final int TIMEOUT = 12;
        public static final int CONNECT_DEVICE_FAILED = 13;
        public static final int HANDLE_DELETE = 14;
        public static final int SUPRESS_AUTOMATIC_ACTIVATIONS_TIMER = 15;
        public static final int DEVICE_DISCOVERED_DEBOUNCED = 16;
        public static final int DEVICE_DISCOVERED_PHONE_CALL_ACTIVE = 17;
        public static final int PHONE_CALL_ENDED = 18;
        private boolean handled = false;

        private TMDeviceControlState() {
        }

        public final boolean processMessage(Message message) {
            this.handled = true;
            switch (message.getCode()) {
                case 1: {
                    this.deviceDiscovered((PhysicalDevice)message.obj);
                    break;
                }
                case 16: {
                    this.deviceDiscoveredDebounced((PhysicalDevice)message.obj);
                    break;
                }
                case 2: {
                    this.activate();
                    break;
                }
                case 3: {
                    this.deactivate();
                    break;
                }
                case 4: {
                    this.deviceNotDiscovered();
                    break;
                }
                case 5: {
                    this.connectionStateConnected();
                    break;
                }
                case 6: {
                    this.connectionStateStarted();
                    break;
                }
                case 7: {
                    this.connectionStateFailed(message.arg1);
                    break;
                }
                case 8: {
                    this.connectionStateDisconnected();
                    break;
                }
                case 9: {
                    this.connectionStateStopped();
                    break;
                }
                case 10: {
                    this.cleanupDone();
                    break;
                }
                case 12: {
                    this.timeout((String)message.obj);
                    break;
                }
                case 13: {
                    this.connectDeviceFailed((SmartphoneIntegrationDSILifecycleController.ErrorCode)message.obj);
                    break;
                }
                case 14: {
                    this.handleDelete();
                    break;
                }
                case 15: {
                    break;
                }
                case 17: {
                    this.deviceDiscoveredPhoneCallActive((PhysicalDevice)message.obj);
                    break;
                }
                case 18: {
                    this.phoneCallEnded();
                    break;
                }
                default: {
                    this.markNotHandled();
                }
            }
            return this.handled;
        }

        protected void deviceDiscovered(PhysicalDevice physicalDevice) {
            this.markNotHandled();
        }

        protected void deviceDiscoveredDebounced(PhysicalDevice physicalDevice) {
            this.markNotHandled();
        }

        protected void deviceNotDiscovered() {
            this.markNotHandled();
        }

        protected void activate() {
            this.markNotHandled();
        }

        protected void deactivate() {
            this.markNotHandled();
        }

        protected void connectionStateConnected() {
            this.markNotHandled();
        }

        protected void connectionStateStopped() {
            this.markNotHandled();
        }

        protected void connectionStateDisconnected() {
            this.markNotHandled();
        }

        protected void connectionStateFailed(int n) {
            this.markNotHandled();
        }

        protected void connectionStateStarted() {
            this.markNotHandled();
        }

        protected void cleanupDone() {
            this.markNotHandled();
        }

        protected void timeout(String string) {
            this.markNotHandled();
        }

        protected void connectDeviceFailed(SmartphoneIntegrationDSILifecycleController.ErrorCode errorCode) {
            this.markNotHandled();
        }

        protected void handleDelete() {
            this.markNotHandled();
        }

        protected void deviceDiscoveredPhoneCallActive(PhysicalDevice physicalDevice) {
            this.markNotHandled();
        }

        protected void phoneCallEnded() {
            this.markNotHandled();
        }

        protected void markNotHandled() {
            this.handled = false;
        }

        static Handler.IMessageCodeToStringConverter getMessageCodeConverter() {
            return new Handler.IMessageCodeToStringConverter(){

                public String messageCodeToString(int n) {
                    switch (n) {
                        case 1: {
                            return "DEVICE_DISCOVERED";
                        }
                        case 2: {
                            return "ACTIVATE";
                        }
                        case 3: {
                            return "DEACTIVATE";
                        }
                        case 4: {
                            return "DEVICE_NOT_DISCOVERED";
                        }
                        case 5: {
                            return "CONNECTIONSTATE_CONNECTED";
                        }
                        case 6: {
                            return "CONNECTIONSTATE_STARTED";
                        }
                        case 7: {
                            return "CONNECTIONSTATE_FAILED";
                        }
                        case 8: {
                            return "CONNECTIONSTATE_DISCONNECTED";
                        }
                        case 9: {
                            return "CONNECTIONSTATE_STOPPED";
                        }
                        case 10: {
                            return "CLEANUP_DONE";
                        }
                        case 12: {
                            return "TIMEOUT";
                        }
                        case 13: {
                            return "CONNECT_DEVICE_FAILED";
                        }
                        case 14: {
                            return "HANDLE_DELETE";
                        }
                        case 15: {
                            return "SUPRESS_AUTOMATIC_ACTIVATIONS_TIMER";
                        }
                        case 16: {
                            return "DEVICE_DISCOVERED_DEBOUNCED";
                        }
                        case 17: {
                            return "DEVICE_DISCOVERED_PHONE_CALL_ACTIVE";
                        }
                        case 18: {
                            return "PHONE_CALL_ENDED";
                        }
                    }
                    return Integer.toString(n);
                }
            };
        }
    }

    public static interface IDeviceControlToDeviceManager {
        public void notifyAboutChange(TMDevice var1, String var2);

        public void requestActivation(TMDeviceControl var1);

        public void requestOtherModeActivation(TMDeviceControl var1);

        public void deleteMe(TMDeviceControl var1);

        public void requestDeactivation(TMDeviceControl var1);
    }
}

