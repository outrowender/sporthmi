/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SDSDialogState;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.ISDSKeyInterceptor;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.def.NullSDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.bindings.IServiceBindings;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.properties.ObservableProperty;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tghu.command.CommandList;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class SDSAppHandler
implements ISDSServiceStatusListener,
ISDSKeyInterceptor,
ITerminalModeComponent,
IDiagnosisCommandProvider,
ButtonListener {
    private static final String LOGCLASS = "SDSAppHandler";
    private final ISpeechRequestHandler speechRequestHandler;
    private final IStateHandler stateHandler;
    private volatile ServiceRegistration serviceRegistration;
    private volatile boolean isPTTLongDetected;
    private final IContext context;
    private final LogChannel logger;
    private final IAudioManager audioManager;
    private final IServiceBindings bindings;
    private final IDeviceManager deviceManager;
    private static final String DIAG_PTTLONG = "pttLong";
    static /* synthetic */ Class class$de$audi$atip$interapp$ISDSKeyInterceptor;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public SDSAppHandler(IContext iContext, IStateHandler iStateHandler, IAudioManager iAudioManager, IServiceBindings iServiceBindings, IDeviceManager iDeviceManager) {
        this.context = Preconditions.checkNotNull(iContext);
        this.logger = Preconditions.checkNotNull(iContext.getLogger().main());
        this.speechRequestHandler = iContext.getSmartphoneDSIManager().getSpeechRequestHandler();
        this.stateHandler = iStateHandler;
        this.audioManager = iAudioManager;
        this.bindings = iServiceBindings;
        this.deviceManager = iDeviceManager;
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.serviceRegistration = this.context.getServiceManager().registerService(class$de$audi$atip$interapp$ISDSKeyInterceptor == null ? (class$de$audi$atip$interapp$ISDSKeyInterceptor = SDSAppHandler.class$("de.audi.atip.interapp.ISDSKeyInterceptor")) : class$de$audi$atip$interapp$ISDSKeyInterceptor, this, new Hashtable(0));
        this.context.getDiagnosisManager().addCommandProvider(-1, this);
        this.context.getButtonModel(3200064).setButtonListener(this);
        this.context.getButtonModel(3200063).setButtonListener(this);
        Observable<NullSDSService> observable = this.bindings.track(class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = SDSAppHandler.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService, new NullSDSService(this.logger));
        ObservableProperty<AudioConnectionState> observableProperty = this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.RINGTONE);
        ObservableProperty<AudioConnectionState> observableProperty2 = this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.PHONE_INPUT);
        ReadOnlyProperty<TMDevice> readOnlyProperty = this.deviceManager.getProperties().activeDevice();
        ReadOnlyProperty<ApplicationOwner> readOnlyProperty2 = this.stateHandler.getStateApplicationProperty(Application.PHONE);
        observableProperty2.combineWith(observableProperty).combineWith(observable).combineWith(readOnlyProperty).subscribe(new Observables.Consumer4<AudioConnectionState, AudioConnectionState, SDSService, TMDevice>(){

            @Override
            public void accept(AudioConnectionState audioConnectionState, AudioConnectionState audioConnectionState2, SDSService sDSService, TMDevice tMDevice) {
                sDSService.disablePTT(tMDevice.isCarplayDevice() && (audioConnectionState.isAudible() || audioConnectionState2.isAudible()), true, (byte)10);
            }

            @Override
            public /* synthetic */ void accept(Object object, Object object2, Object object3, Object object4) {
                this.accept((AudioConnectionState)object, (AudioConnectionState)object2, (SDSService)object3, (TMDevice)object4);
            }
        });
        readOnlyProperty2.distinctUntilChanged().combineWith(observable).combineWith(readOnlyProperty).subscribe(new Observables.Consumer3<ApplicationOwner, SDSService, TMDevice>(){

            @Override
            public void accept(ApplicationOwner applicationOwner, SDSService sDSService, TMDevice tMDevice) {
                if (sDSService.isSDSActive() && SDSAppHandler.this.deviceManager.getActiveDevice().isCarplayDevice() && applicationOwner.is(ApplicationOwner.DEVICE)) {
                    SDSAppHandler.this.logger.log(1000000, "[%1.Phone owner CPdevice while sds active] - disable SDS.", (Object)SDSAppHandler.LOGCLASS);
                    sDSService.disablePTT(true, true, (byte)10);
                }
            }

            @Override
            public /* synthetic */ void accept(Object object, Object object2, Object object3) {
                this.accept((ApplicationOwner)object, (SDSService)object2, (TMDevice)object3);
            }
        });
        observable.redirectTo((Consumer<NullSDSService>)new Consumer<SDSService>(){

            @Override
            public void accept(SDSService sDSService) {
                sDSService.registerStatusListener(SDSAppHandler.this);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((SDSService)object);
            }
        });
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.context.getButtonModel(3200064).setButtonListener(null);
        this.context.getButtonModel(3200063).setButtonListener(null);
        this.context.getServiceManager().unregisterService(this.serviceRegistration);
    }

    public void notifySDSDialogStarted() {
        this.logger.log(1000000, "[%1.notifySDSDialogStarted]", (Object)LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new SDSDialogState(this.context, true, this.stateHandler)).execute("SDSAppHandler.notifySDSDialogStarted");
    }

    public void notifySDSDialogEnded() {
        this.logger.log(1000000, "[%1.notifySDSDialogEnded]", (Object)LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new SDSDialogState(this.context, false, this.stateHandler)).execute("SDSAppHandler.notifySDSDialogEnded");
    }

    public void notifySDSDialogAborting() {
    }

    public void pttPressed() {
        this.logger.log(1000000, "<- [%1.pttPressed]", (Object)LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new PTTPressed(this.logger, this.context)).execute("[SDSAppHandler.pttPressed] -> PTTPressed");
    }

    public void pttReleasedAfterShortPress() {
        this.logger.log(1000000, "<- [%1.pttReleasedAfterShortPress]", (Object)LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new PTTReleasedAfterShortPress(this.logger, this.context)).execute("[SDSAppHandler.pttReleasedAfterShortPress] -> PTTShort");
    }

    public void pttLongDetected() {
        this.logger.log(1000000, "<- [%1.pttLongDetected]", (Object)LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new PTTLongDetected(this.context)).execute("[SDSAppHandler.pttLongDetected] -> PTTLongDetected");
    }

    public void pttReleasedAfterLongPress() {
        this.logger.log(1000000, "<- [%1.pttReleasedAfterLongPress]", (Object)LOGCLASS);
        this.context.getCommandListHelper().create().addSingle(new PTTReleasedAfterLongPress(this.logger, this.context)).execute("[SDSAppHandler.pttReleasedAfterLongPress] -> PTTReleasedAfterLongPress");
    }

    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 3200064: {
                this.logger.log(1000000, "[%1.keyPressed] PTT short", (Object)LOGCLASS);
                this.pttPressed();
                break;
            }
            case 3200063: {
                this.logger.log(1000000, "[%1.keyPressed] PTT long", (Object)LOGCLASS);
                this.isPTTLongDetected = true;
                this.pttLongDetected();
                break;
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 3200064: {
                if (this.isPTTLongDetected) {
                    this.logger.log(1000000, "[%1.keyReleased] PTT long", (Object)LOGCLASS);
                    this.pttReleasedAfterLongPress();
                    this.isPTTLongDetected = false;
                    break;
                }
                this.logger.log(1000000, "[%1.keyReleased] PTT short", (Object)LOGCLASS);
                this.pttReleasedAfterShortPress();
                break;
            }
            case 3200063: {
                break;
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public String[] getDiagKeys() {
        return new String[]{DIAG_PTTLONG};
    }

    public void executeDiagCommand(String string, String[] stringArray) {
        if (DIAG_PTTLONG.equals(string)) {
            this.pttPressed();
            this.pttLongDetected();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class PTTPressed
    extends AbstractCommand {
        public PTTPressed(LogChannel logChannel, IContext iContext) {
            super(logChannel, "PTTPressed", iContext);
        }

        public void execute() {
            if (SDSAppHandler.this.stateHandler.getCurrentState().isAppFree(Application.SPEECH)) {
                SDSAppHandler.this.speechRequestHandler.prewarm();
            }
            this.getCommandList().commandFinished();
        }
    }

    private class PTTLongDetected
    extends AbstractDSICommand {
        private static final String LOGCLASS = "PTTLongDetected";

        public PTTLongDetected(IContext iContext) {
            super(iContext.getLogger().main(), LOGCLASS, iContext, iContext.getSmartphoneDSIManager());
        }

        public void execute() {
            if (SDSAppHandler.this.stateHandler.getCurrentState().isAppFree(Application.SPEECH) || SDSAppHandler.this.stateHandler.getCurrentState().isAppOwnerDevice(Application.SPEECH)) {
                this.logger.log(1000000, "[%1.execute] speech is free", (Object)LOGCLASS);
                SDSAppHandler.this.speechRequestHandler.startSpeechSession();
                TMState tMState = SDSAppHandler.this.stateHandler.getCurrentState();
                tMState.setOwnerForApplication(Application.SPEECH, ApplicationOwner.DEVICE);
                CommandList commandList = SDSAppHandler.this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            } else {
                this.logger.log(1000000, "[%1.execute] speech not free", (Object)LOGCLASS);
                this.getCommandList().commandFinished();
            }
        }
    }

    private class PTTReleasedAfterLongPress
    extends AbstractCommand {
        public PTTReleasedAfterLongPress(LogChannel logChannel, IContext iContext) {
            super(logChannel, "PTTReleasedAfterLongPress", iContext);
        }

        public void execute() {
            SDSAppHandler.this.speechRequestHandler.pttReleasedAfterLongPress();
            this.getCommandList().commandFinished();
        }
    }

    private class PTTReleasedAfterShortPress
    extends AbstractCommand {
        public PTTReleasedAfterShortPress(LogChannel logChannel, IContext iContext) {
            super(logChannel, "PTTReleasedAfterShortPress", iContext);
        }

        public void execute() {
            if (SDSAppHandler.this.stateHandler.getCurrentState().isAppOwnerDevice(Application.SPEECH)) {
                SDSAppHandler.this.speechRequestHandler.abortActiveSpeechSession();
            } else if (SDSAppHandler.this.stateHandler.getCurrentState().isAppFree(Application.SPEECH)) {
                SDSAppHandler.this.speechRequestHandler.cancelPrewarm();
            }
            this.getCommandList().commandFinished();
        }
    }
}

