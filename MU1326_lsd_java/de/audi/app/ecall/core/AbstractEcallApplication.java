/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.EcallDiagnosis
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core;

import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IEcallComponent;
import de.audi.app.ecall.core.ap.ActionProxyDispatcher;
import de.audi.app.ecall.core.ap.IActionProxyDispatcher;
import de.audi.app.ecall.core.audio.AudioConnectionHandlerImpl;
import de.audi.app.ecall.core.audio.EcallAudioScenarioHandler;
import de.audi.app.ecall.core.audio.IAudioConnectionHandler;
import de.audi.app.ecall.core.bap.BAPServiceEcallListenerClusterHandler;
import de.audi.app.ecall.core.bap.EcallBapServiceAdapterCustomizer;
import de.audi.app.ecall.core.bap.IEcallBapServiceAdapter;
import de.audi.app.ecall.core.bap.IGlobalEcallState;
import de.audi.app.ecall.core.bap.OnCommunicationUpHandler;
import de.audi.app.ecall.core.bap.opr.BreakdownCallServiceHandler;
import de.audi.app.ecall.core.bap.sos.EmergencyCallButtonsHandler;
import de.audi.app.ecall.core.bap.sos.EmergencyCallServiceHandler;
import de.audi.app.ecall.core.bap.sos.KoreaEmergencyCallHandler;
import de.audi.app.ecall.core.car.BreakdownCallCarPositionHandler;
import de.audi.app.ecall.core.msg.IMessageDispatcher;
import de.audi.app.ecall.core.msg.MessageDispatcher;
import de.audi.app.ecall.core.osgi.EcallServiceProvider;
import de.audi.app.ecall.core.power.IPowerEventDispatcher;
import de.audi.app.ecall.core.power.PowerEventDispatcher;
import de.audi.app.ecall.core.screen.IPopupScreenStateDispatcher;
import de.audi.app.ecall.core.screen.PopupScreenStateDispatcher;
import de.audi.app.ecall.core.sds.EcallSDSHandler;
import de.audi.app.ecall.core.sds.SDSHandler;
import de.audi.app.ecall.core.tel.ITelServiceEcallHandler;
import de.audi.app.ecall.core.tel.TelEcallStateListenerHandler;
import de.audi.app.ecall.core.tel.TelServiceEcallHandlerImpl;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.mib.swdiagnosis.ecall.EcallDiagnosis;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;
import java.util.ArrayList;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractEcallApplication
implements IEcallApplication,
HMIApplication {
    private final IFrameworkAccess frameworkAccess;
    private final BundleContext bundleContext;
    protected final LogChannel log;
    private final IPopupScreenStateDispatcher popupStateDispatcher;
    protected final IActionProxyDispatcher actionProxyDispatcher;
    private final IPowerEventDispatcher powerEventDispatcher;
    private volatile EcallServiceProvider hmiApplicationService;
    private final EcallDiagnosis diagnosis;
    private final ArrayList components = new ArrayList();
    private final IMessageDispatcher messageDispatcher;
    private TelServiceEcallHandlerImpl telServiceHandler;
    private TelEcallStateListenerHandler telEcallStateHandler;
    private final BAPServiceEcallListenerClusterHandler bapServiceEcallListeClusterHandler;
    private final EcallBapServiceAdapterCustomizer bapServiceEcallCombiner;
    private final EcallAudioScenarioHandler ecallAudioScenarioHandler;
    private final IAudioConnectionHandler audioConnectionHandler;
    private final EcallSDSHandler sdsHandler;
    private final OnCommunicationUpHandler onCommunicationUpHandler;
    private static final int SERVICE_REQUEST_STATES_COUNT = 15;
    private static final boolean[] BCALL_SERVICE_STATES_FOR_SREEN_SHOWING = new boolean[15];
    private static final int PHONE_CALL_STATES_COUNT = 9;
    private static final boolean[] BCALL_PHONE_CALL_STATE_FOR_SREEN_SHOWING;
    private static final boolean[] ECALL_SERVICE_STATES_FOR_SREEN_SHOWING;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    public AbstractEcallApplication(IFrameworkAccess iFrameworkAccess, String string, BundleContext bundleContext) {
        this.frameworkAccess = iFrameworkAccess;
        this.bundleContext = bundleContext;
        this.log = iFrameworkAccess.getLogChannel(string);
        this.diagnosis = new EcallDiagnosis(this.log, bundleContext);
        this.bapServiceEcallCombiner = new EcallBapServiceAdapterCustomizer(this, "App.Ecall.Main");
        this.bapServiceEcallListeClusterHandler = new BAPServiceEcallListenerClusterHandler(this, this.log);
        this.ecallAudioScenarioHandler = new EcallAudioScenarioHandler(this);
        this.audioConnectionHandler = new AudioConnectionHandlerImpl(this.ecallAudioScenarioHandler.getEcallAudioCmdManager());
        this.telServiceHandler = new TelServiceEcallHandlerImpl(this);
        this.telEcallStateHandler = new TelEcallStateListenerHandler(this, "App.Ecall.Main");
        this.sdsHandler = new EcallSDSHandler(this, "App.Ecall.Main");
        this.onCommunicationUpHandler = new OnCommunicationUpHandler(this);
        this.actionProxyDispatcher = new ActionProxyDispatcher(this.log);
        this.powerEventDispatcher = new PowerEventDispatcher(this.log, bundleContext);
        this.popupStateDispatcher = new PopupScreenStateDispatcher(this.log);
        this.messageDispatcher = new MessageDispatcher(this.log, bundleContext);
    }

    protected abstract void addComponents();

    public void init() {
        this.addComponents();
        this.bapServiceEcallListeClusterHandler.init();
        this.addEcallComponent(this.bapServiceEcallCombiner);
        this.addEcallComponent(this.telServiceHandler);
        this.addEcallComponent(this.telEcallStateHandler);
        this.addEcallComponent(this.ecallAudioScenarioHandler);
        this.addEcallComponent(this.sdsHandler);
        this.addEcallComponent(this.onCommunicationUpHandler);
        this.addEcallComponent(new BreakdownCallServiceHandler(this, BCALL_SERVICE_STATES_FOR_SREEN_SHOWING, BCALL_PHONE_CALL_STATE_FOR_SREEN_SHOWING));
        this.addEcallComponent(new EmergencyCallServiceHandler((IEcallApplication)this, ECALL_SERVICE_STATES_FOR_SREEN_SHOWING));
        this.addEcallComponent(new KoreaEmergencyCallHandler(this));
        this.addEcallComponent(new BreakdownCallCarPositionHandler((IEcallApplication)this, this.isGPSShowingAllowed()));
        this.addEcallComponent(new EmergencyCallButtonsHandler(this));
        this.addEcallComponentPost();
        this.initComponents();
        this.initDispatchers();
        this.registerHMIApplication();
        this.diagnosis.init();
    }

    protected void addEcallComponentPost() {
    }

    private boolean isGPSShowingAllowed() {
        return this.getFrameworkAccess().getSysConst(442) != 2;
    }

    public void deinit() {
        this.deinitComponents();
        this.bapServiceEcallListeClusterHandler.deinit();
        this.deinitDispatchers();
        this.deregisterHMIApplication();
        this.diagnosis.deinit();
    }

    private void registerHMIApplication() {
        this.log.log(10000000, "[AbstractEcallApplication#registerHMIApplication] called");
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppEcall");
        hashtable.put("moduleID", new Integer(this.getId()));
        this.hmiApplicationService = new EcallServiceProvider((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractEcallApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), this, hashtable, this.getBundleContext(), this.log);
        this.hmiApplicationService.startService();
    }

    private void deregisterHMIApplication() {
        this.log.log(10000000, "[AbstractEcallApplication#deregisterHMIApplication] called");
        if (this.hmiApplicationService != null) {
            this.hmiApplicationService.stopService();
        }
    }

    protected void addEcallComponent(IEcallComponent iEcallComponent) {
        this.components.add(iEcallComponent);
    }

    public IFrameworkAccess getFrameworkAccess() {
        return this.frameworkAccess;
    }

    private void initComponents() {
        for (int i2 = 0; i2 < this.components.size(); ++i2) {
            ((IEcallComponent)this.components.get(i2)).init();
        }
    }

    private void initDispatchers() {
        this.actionProxyDispatcher.init();
        this.powerEventDispatcher.init();
        this.popupStateDispatcher.init();
        this.messageDispatcher.init();
    }

    private void deinitComponents() {
        for (int i2 = 0; i2 < this.components.size(); ++i2) {
            ((IEcallComponent)this.components.get(i2)).deinit();
        }
    }

    public int getId() {
        return 33;
    }

    private void deinitDispatchers() {
        this.actionProxyDispatcher.deinit();
        this.powerEventDispatcher.init();
        this.popupStateDispatcher.deinit();
        this.messageDispatcher.deinit();
    }

    protected boolean isPhoneModulePresent() {
        return this.getFrameworkAccess().getSysConst(473) == 1;
    }

    public void addDiagnosisComponent(IEcallDiagnosisComponent iEcallDiagnosisComponent) {
        this.diagnosis.addDiagnosisComponent(iEcallDiagnosisComponent);
    }

    public void logStartupEvent(String string) {
        this.getFrameworkAccess().getStartupMgr().logStartupEvent(string);
    }

    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public IPopupScreenStateDispatcher getPopupScreenStateDispatcher() {
        return this.popupStateDispatcher;
    }

    public IPowerEventDispatcher getPowerEventDispatcher() {
        return this.powerEventDispatcher;
    }

    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    public void popupVisible(int n, int n2) {
        this.log.log(1000000, "[AbstractEcallApplication#popupVisible] id=%1, terminalID=%2", (long)n, (long)n2);
        this.getPopupScreenStateDispatcher().notifyPopupVisible(n, n2);
    }

    public void popupHidden(int n, int n2) {
        this.log.log(1000000, "[AbstractEcallApplication#popupHidden] id=%1, terminalID=%2", (long)n, (long)n2);
        this.getPopupScreenStateDispatcher().notifyPopupHidden(n, n2);
    }

    public void popupRemoved(int n, int n2) {
        this.log.log(1000000, "[AbstractEcallApplication#popupRemoved] id=%1, terminalID=%2", (long)n, (long)n2);
        this.getPopupScreenStateDispatcher().notifyPopupRemoved(n, n2);
    }

    public void screenVisible(int n, int n2) {
        this.log.log(1000000, "[AbstractEcallApplication#screenVisible] id=%1, terminalID=%2", (long)n, (long)n2);
        this.getPopupScreenStateDispatcher().notifyScreenVisible(n, n2);
    }

    public void screenHidden(int n, int n2) {
        this.log.log(1000000, "[AbstractEcallApplication#screenHidden] id=%1, terminalID=%2", (long)n, (long)n2);
        this.getPopupScreenStateDispatcher().notifyScreenHidden(n, n2);
    }

    public void screenFadedOut(int n, int n2) {
        this.log.log(1000000, "[AbstractEcallApplication#screenFadedOut] id=%1, terminalID=%2", (long)n, (long)n2);
        this.getPopupScreenStateDispatcher().notifyScreenFadedOut(n, n2);
    }

    public void screenConnected(int n, int n2) {
        this.log.log(1000000, "[AbstractEcallApplication#screenConnected] id=%1, terminalID=%2", (long)n, (long)n2);
        this.getPopupScreenStateDispatcher().notifyScreenConnected(n, n2);
    }

    public ITelServiceEcallHandler getTelServiceEcallHandler() {
        return this.telServiceHandler;
    }

    public LogChannel getEcallAppLogChannel() {
        return this.log;
    }

    public IMessageDispatcher getMessageDispatcher() {
        return this.messageDispatcher;
    }

    public IAudioConnectionHandler getAudioConnectionHandler() {
        return this.audioConnectionHandler;
    }

    public IGlobalEcallState getEcallStateManager() {
        return this.bapServiceEcallListeClusterHandler;
    }

    public IEcallBapServiceAdapter getEcallBapServiceAdapter() {
        return this.bapServiceEcallCombiner.getEcallBapServiceAdapter();
    }

    public SDSHandler getSDSHandler() {
        return this.sdsHandler;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        AbstractEcallApplication.BCALL_SERVICE_STATES_FOR_SREEN_SHOWING[1] = true;
        AbstractEcallApplication.BCALL_SERVICE_STATES_FOR_SREEN_SHOWING[5] = true;
        AbstractEcallApplication.BCALL_SERVICE_STATES_FOR_SREEN_SHOWING[9] = true;
        AbstractEcallApplication.BCALL_SERVICE_STATES_FOR_SREEN_SHOWING[3] = true;
        AbstractEcallApplication.BCALL_SERVICE_STATES_FOR_SREEN_SHOWING[12] = true;
        AbstractEcallApplication.BCALL_SERVICE_STATES_FOR_SREEN_SHOWING[14] = true;
        BCALL_PHONE_CALL_STATE_FOR_SREEN_SHOWING = new boolean[9];
        AbstractEcallApplication.BCALL_PHONE_CALL_STATE_FOR_SREEN_SHOWING[3] = true;
        AbstractEcallApplication.BCALL_PHONE_CALL_STATE_FOR_SREEN_SHOWING[2] = true;
        AbstractEcallApplication.BCALL_PHONE_CALL_STATE_FOR_SREEN_SHOWING[4] = true;
        ECALL_SERVICE_STATES_FOR_SREEN_SHOWING = new boolean[15];
        AbstractEcallApplication.ECALL_SERVICE_STATES_FOR_SREEN_SHOWING[8] = true;
        AbstractEcallApplication.ECALL_SERVICE_STATES_FOR_SREEN_SHOWING[10] = true;
        AbstractEcallApplication.ECALL_SERVICE_STATES_FOR_SREEN_SHOWING[12] = true;
        AbstractEcallApplication.ECALL_SERVICE_STATES_FOR_SREEN_SHOWING[14] = true;
    }
}

