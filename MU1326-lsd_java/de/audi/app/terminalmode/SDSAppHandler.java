/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 *  de.audi.atip.utils.Preconditions
 *  de.audi.atip.utils.reactive.observables.Observable
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SDSAppHandler$1;
import de.audi.app.terminalmode.SDSAppHandler$2;
import de.audi.app.terminalmode.SDSAppHandler$3;
import de.audi.app.terminalmode.SDSAppHandler$PTTLongDetected;
import de.audi.app.terminalmode.SDSAppHandler$PTTPressed;
import de.audi.app.terminalmode.SDSAppHandler$PTTReleasedAfterLongPress;
import de.audi.app.terminalmode.SDSAppHandler$PTTReleasedAfterShortPress;
import de.audi.app.terminalmode.SDSDialogState;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.ISDSKeyInterceptor;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.def.NullSDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.bindings.IServiceBindings;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.properties.ObservableProperty;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class SDSAppHandler
implements ISDSServiceStatusListener,
ISDSKeyInterceptor,
ITerminalModeComponent,
IDiagnosisCommandProvider,
ButtonListener {
    private static final String LOGCLASS;
    private final ISpeechRequestHandler speechRequestHandler;
    private final IStateHandler stateHandler;
    private volatile ServiceRegistration serviceRegistration;
    private volatile boolean isPTTLongDetected;
    private final IContext context;
    private final LogChannel logger;
    private final IAudioManager audioManager;
    private final IServiceBindings bindings;
    private final IDeviceManager deviceManager;
    private static final String DIAG_PTTLONG;
    static /* synthetic */ Class class$de$audi$atip$interapp$ISDSKeyInterceptor;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public SDSAppHandler(IContext iContext, IStateHandler iStateHandler, IAudioManager iAudioManager, IServiceBindings iServiceBindings, IDeviceManager iDeviceManager) {
        this.context = (IContext)Preconditions.checkNotNull((Object)iContext);
        this.logger = (LogChannel)Preconditions.checkNotNull((Object)iContext.getLogger().main());
        this.speechRequestHandler = iContext.getSmartphoneDSIManager().getSpeechRequestHandler();
        this.stateHandler = iStateHandler;
        this.audioManager = iAudioManager;
        this.bindings = iServiceBindings;
        this.deviceManager = iDeviceManager;
    }

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"SDSAppHandler");
        this.serviceRegistration = this.context.getServiceManager().registerService(class$de$audi$atip$interapp$ISDSKeyInterceptor == null ? (class$de$audi$atip$interapp$ISDSKeyInterceptor = SDSAppHandler.class$("de.audi.atip.interapp.ISDSKeyInterceptor")) : class$de$audi$atip$interapp$ISDSKeyInterceptor, this, new Hashtable(0));
        this.context.getDiagnosisManager().addCommandProvider(-1, this);
        this.context.getButtonModel(1087647744).setButtonListener(this);
        this.context.getButtonModel(1070870528).setButtonListener(this);
        Observable observable = this.bindings.track(class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = SDSAppHandler.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService, new NullSDSService(this.logger));
        ObservableProperty observableProperty = this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.RINGTONE);
        ObservableProperty observableProperty2 = this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.PHONE_INPUT);
        ReadOnlyProperty readOnlyProperty = this.deviceManager.getProperties().activeDevice();
        ReadOnlyProperty readOnlyProperty2 = this.stateHandler.getStateApplicationProperty(Application.PHONE);
        observableProperty2.combineWith(observableProperty).combineWith(observable).combineWith(readOnlyProperty).subscribe(new SDSAppHandler$1(this));
        readOnlyProperty2.distinctUntilChanged().combineWith(observable).combineWith(readOnlyProperty).subscribe(new SDSAppHandler$2(this));
        observable.redirectTo((Consumer)new SDSAppHandler$3(this));
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"SDSAppHandler");
        this.context.getButtonModel(1087647744).setButtonListener(null);
        this.context.getButtonModel(1070870528).setButtonListener(null);
        this.context.getServiceManager().unregisterService(this.serviceRegistration);
    }

    @Override
    public void notifySDSDialogStarted() {
        this.logger.log(1078071040, "[%1.notifySDSDialogStarted]", (Object)"SDSAppHandler");
        this.context.getCommandListHelper().create().addSingle(new SDSDialogState(this.context, true, this.stateHandler)).execute("SDSAppHandler.notifySDSDialogStarted");
    }

    @Override
    public void notifySDSDialogEnded() {
        this.logger.log(1078071040, "[%1.notifySDSDialogEnded]", (Object)"SDSAppHandler");
        this.context.getCommandListHelper().create().addSingle(new SDSDialogState(this.context, false, this.stateHandler)).execute("SDSAppHandler.notifySDSDialogEnded");
    }

    @Override
    public void notifySDSDialogAborting() {
    }

    @Override
    public void pttPressed() {
        this.logger.log(1078071040, "<- [%1.pttPressed]", (Object)"SDSAppHandler");
        this.context.getCommandListHelper().create().addSingle(new SDSAppHandler$PTTPressed(this, this.logger, this.context)).execute("[SDSAppHandler.pttPressed] -> PTTPressed");
    }

    @Override
    public void pttReleasedAfterShortPress() {
        this.logger.log(1078071040, "<- [%1.pttReleasedAfterShortPress]", (Object)"SDSAppHandler");
        this.context.getCommandListHelper().create().addSingle(new SDSAppHandler$PTTReleasedAfterShortPress(this, this.logger, this.context)).execute("[SDSAppHandler.pttReleasedAfterShortPress] -> PTTShort");
    }

    @Override
    public void pttLongDetected() {
        this.logger.log(1078071040, "<- [%1.pttLongDetected]", (Object)"SDSAppHandler");
        this.context.getCommandListHelper().create().addSingle(new SDSAppHandler$PTTLongDetected(this, this.context)).execute("[SDSAppHandler.pttLongDetected] -> PTTLongDetected");
    }

    @Override
    public void pttReleasedAfterLongPress() {
        this.logger.log(1078071040, "<- [%1.pttReleasedAfterLongPress]", (Object)"SDSAppHandler");
        this.context.getCommandListHelper().create().addSingle(new SDSAppHandler$PTTReleasedAfterLongPress(this, this.logger, this.context)).execute("[SDSAppHandler.pttReleasedAfterLongPress] -> PTTReleasedAfterLongPress");
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 3200064: {
                this.logger.log(1078071040, "[%1.keyPressed] PTT short", (Object)"SDSAppHandler");
                this.pttPressed();
                break;
            }
            case 3200063: {
                this.logger.log(1078071040, "[%1.keyPressed] PTT long", (Object)"SDSAppHandler");
                this.isPTTLongDetected = true;
                this.pttLongDetected();
                break;
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        switch (n) {
            case 3200064: {
                if (this.isPTTLongDetected) {
                    this.logger.log(1078071040, "[%1.keyReleased] PTT long", (Object)"SDSAppHandler");
                    this.pttReleasedAfterLongPress();
                    this.isPTTLongDetected = false;
                    break;
                }
                this.logger.log(1078071040, "[%1.keyReleased] PTT short", (Object)"SDSAppHandler");
                this.pttReleasedAfterShortPress();
                break;
            }
            case 3200063: {
                break;
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"pttLong"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("pttLong".equals(string)) {
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

    static /* synthetic */ IDeviceManager access$000(SDSAppHandler sDSAppHandler) {
        return sDSAppHandler.deviceManager;
    }

    static /* synthetic */ LogChannel access$100(SDSAppHandler sDSAppHandler) {
        return sDSAppHandler.logger;
    }

    static /* synthetic */ IStateHandler access$200(SDSAppHandler sDSAppHandler) {
        return sDSAppHandler.stateHandler;
    }

    static /* synthetic */ ISpeechRequestHandler access$300(SDSAppHandler sDSAppHandler) {
        return sDSAppHandler.speechRequestHandler;
    }
}

