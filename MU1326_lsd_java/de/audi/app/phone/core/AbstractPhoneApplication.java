/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 *  de.mib.swdiagnosis.phone.PhoneApplicationDiag
 *  de.mib.swdiagnosis.phone.PhoneDiag
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneApplication$1;
import de.audi.app.phone.core.AbstractPhoneApplication$10;
import de.audi.app.phone.core.AbstractPhoneApplication$11;
import de.audi.app.phone.core.AbstractPhoneApplication$12;
import de.audi.app.phone.core.AbstractPhoneApplication$13;
import de.audi.app.phone.core.AbstractPhoneApplication$14;
import de.audi.app.phone.core.AbstractPhoneApplication$15;
import de.audi.app.phone.core.AbstractPhoneApplication$16;
import de.audi.app.phone.core.AbstractPhoneApplication$17;
import de.audi.app.phone.core.AbstractPhoneApplication$18;
import de.audi.app.phone.core.AbstractPhoneApplication$2;
import de.audi.app.phone.core.AbstractPhoneApplication$3;
import de.audi.app.phone.core.AbstractPhoneApplication$4;
import de.audi.app.phone.core.AbstractPhoneApplication$5;
import de.audi.app.phone.core.AbstractPhoneApplication$6;
import de.audi.app.phone.core.AbstractPhoneApplication$7;
import de.audi.app.phone.core.AbstractPhoneApplication$8;
import de.audi.app.phone.core.AbstractPhoneApplication$9;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelComponent;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.ap.ActionProxyDispatcher;
import de.audi.app.phone.core.ap.IActionProxyDispatcher;
import de.audi.app.phone.core.dsi.ITelephoneDSIAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentAccessImpl;
import de.audi.app.phone.core.event.AbstractTelEvent;
import de.audi.app.phone.core.event.TelEventQueue;
import de.audi.app.phone.core.lang.ILanguageUpdateDispatcher;
import de.audi.app.phone.core.lang.LanguageUpdateDispatcher;
import de.audi.app.phone.core.msg.IMessageDispatcher;
import de.audi.app.phone.core.msg.MessageDispatcher;
import de.audi.app.phone.core.power.IPowerEventDispatcher;
import de.audi.app.phone.core.power.PowerEventDispatcher;
import de.audi.app.phone.core.screen.IPopupScreenStateDispatcher;
import de.audi.app.phone.core.screen.PopupScreenStateDispatcher;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.state.IGlobalTelephoneState;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sync.IWaitSyncer;
import de.audi.tghu.command.CommandListManager;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import de.mib.swdiagnosis.phone.PhoneApplicationDiag;
import de.mib.swdiagnosis.phone.PhoneDiag;
import java.util.ArrayList;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractPhoneApplication
implements ITelApplication,
HMIApplication {
    private final IFrameworkAccess frameworkAccess;
    private final BundleContext bundleContext;
    private final LogChannel log;
    private final LogChannel logStartup;
    private final ArrayList components = new ArrayList();
    protected final IActionProxyDispatcher actionProxyDispatcher;
    private final IPowerEventDispatcher powerEventDispatcher;
    private final IPopupScreenStateDispatcher popupStateDispatcher;
    private final IMessageDispatcher messageDispatcher;
    private final ILanguageUpdateDispatcher languageUpdateDispatcher;
    private final CommandListManager commandListManager;
    private final IGlobalTelephoneState globalTelephoneStateManager;
    private final PhoneDiag diagnosis;
    private volatile PhoneServiceProvider hmiApplicationService;
    private final TelDSIMobileEquipmentAccessImpl dsiMobileEquipmentAccess;
    private final TelEventQueue telEventQueue;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    public AbstractPhoneApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, String string) {
        this.telEventQueue = new TelEventQueue(iFrameworkAccess);
        this.frameworkAccess = iFrameworkAccess;
        this.bundleContext = bundleContext;
        this.log = iFrameworkAccess.getLogChannel(string);
        this.logStartup = iFrameworkAccess.getLogChannel("App.Phone.Startup");
        this.diagnosis = new PhoneDiag(this.getFrameworkAccess().getLogChannel("App.Phone.Main"), bundleContext);
        this.globalTelephoneStateManager = new GlobalTelephoneState(this);
        this.commandListManager = new CommandListManager("TELEPHONE_CMD_LIST_MANAGER", iFrameworkAccess, iFrameworkAccess.getLogChannel("App.Phone.CL"), null, null);
        this.commandListManager.start();
        this.actionProxyDispatcher = new ActionProxyDispatcher(this.log, this.telEventQueue);
        this.popupStateDispatcher = new PopupScreenStateDispatcher(this.log);
        this.messageDispatcher = new MessageDispatcher(this.log, bundleContext, this.telEventQueue);
        this.powerEventDispatcher = new PowerEventDispatcher(iFrameworkAccess.getLogChannel("App.Phone.Main"), bundleContext, this.telEventQueue);
        this.languageUpdateDispatcher = new LanguageUpdateDispatcher(this, bundleContext, this.log, this.telEventQueue);
        this.dsiMobileEquipmentAccess = new TelDSIMobileEquipmentAccessImpl(this);
    }

    private IWaitSyncer getWaitSyncer(String string) {
        return this.frameworkAccess.getWaitSyncer(string, 0, this.log);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void addPhoneComponent(ITelComponent iTelComponent) {
        ArrayList arrayList = this.components;
        synchronized (arrayList) {
            this.components.add(iTelComponent);
        }
    }

    @Override
    public void init() {
        IWaitSyncer iWaitSyncer = this.getWaitSyncer("AbstractPhoneApplication#init");
        this.telEventQueue.init();
        this.logStartup.log(1078071040, "[AbstractPhoneApplication#init]");
        this.telEventQueue.enqueue(new AbstractPhoneApplication$1(this, "[STARTUP] init global telephone state"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$2(this, "[STARTUP] init dispatchers"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$3(this, "[STARTUP] register HMI application"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$4(this, "[STARTUP] init diagnosis"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$5(this, "[STARTUP] add components"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$6(this, "[STARTUP] init components", iWaitSyncer));
        this.logStartup.log(1078071040, "[AbstractPhoneApplication#init] waiting for sync event.");
        iWaitSyncer.waitForTrigger();
        this.logStartup.log(1078071040, "[AbstractPhoneApplication#init] init complete.");
    }

    @Override
    public void deinit() {
        IWaitSyncer iWaitSyncer = this.getWaitSyncer("AbstractPhoneApplication#deinit");
        this.logStartup.log(1078071040, "[AbstractPhoneApplication#deinit]");
        this.telEventQueue.enqueue(new AbstractPhoneApplication$7(this, "[SHUTDOWN] GlobalTelephoneState"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$8(this, "[SHUTDOWN] dispatchers"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$9(this, "[SHUTDOWN] unregister HMIApplication"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$10(this, "[SHUTDOWN] deinit components"));
        this.telEventQueue.enqueue(new AbstractPhoneApplication$11(this, "[SHUTDOWN] deinit event queue.", iWaitSyncer));
        this.logStartup.log(1078071040, "[AbstractPhoneApplication#deinit] waiting for sync event.");
        iWaitSyncer.waitForTrigger();
        this.logStartup.log(1078071040, "[AbstractPhoneApplication#deinit] deinit complete.");
    }

    @Override
    public TelEventQueue getTelEventQueue() {
        return this.telEventQueue;
    }

    private void deinitDispatchers() {
        this.powerEventDispatcher.deinit();
        this.actionProxyDispatcher.deinit();
        this.popupStateDispatcher.deinit();
        this.messageDispatcher.deinit();
        this.languageUpdateDispatcher.deinit();
    }

    private void initDispatchers() {
        try {
            this.powerEventDispatcher.init();
            this.actionProxyDispatcher.init();
            this.popupStateDispatcher.init();
            this.messageDispatcher.init();
            this.languageUpdateDispatcher.init();
        }
        catch (Exception exception) {
            Thread.interrupted();
            this.log.log(10000, "[AbstractPhoneApplication#initDispatchers]", (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void deinitComponents() {
        ArrayList arrayList = this.components;
        synchronized (arrayList) {
            for (int i2 = 0; i2 < this.components.size(); ++i2) {
                long l = this.frameworkAccess.getMonotonicTime();
                ITelComponent iTelComponent = (ITelComponent)this.components.get(i2);
                try {
                    iTelComponent.deinit();
                }
                catch (Exception exception) {
                    Thread.interrupted();
                    this.log.log(10000, "[AbstractPhoneApplication#deinitComponents]", (Throwable)exception);
                }
                this.logStartup.log(1078071040, "[AbstractPhoneApplication#deinitComponents] %1 took %2 ms", (Object)super.getClass().getName(), (Object)String.valueOf(this.frameworkAccess.getMonotonicTime() - l));
            }
            this.components.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initComponents() {
        ArrayList arrayList = this.components;
        synchronized (arrayList) {
            for (int i2 = 0; i2 < this.components.size(); ++i2) {
                long l = this.frameworkAccess.getMonotonicTime();
                ITelComponent iTelComponent = (ITelComponent)this.components.get(i2);
                try {
                    iTelComponent.init();
                }
                catch (Exception exception) {
                    Thread.interrupted();
                    this.log.log(10000, "[AbstractPhoneApplication#initComponents]", (Throwable)exception);
                }
                this.logStartup.log(1078071040, "[AbstractPhoneApplication#initComponents] %1 took %2 ms", (Object)super.getClass().getName(), (Object)String.valueOf(this.frameworkAccess.getMonotonicTime() - l));
            }
        }
    }

    private void initDiagnosis() {
        this.diagnosis.init();
        PhoneApplicationDiag phoneApplicationDiag = new PhoneApplicationDiag((ITelApplication)this);
        this.diagnosis.addDiagnosisComponent((IPhoneDiagComponent)phoneApplicationDiag);
    }

    private void registerHMIApplication() {
        this.log.log(-2137614336, "[AbstractPhoneApplication#registerHMIApplication] called");
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        hashtable.put("moduleID", new Integer(this.getId()));
        this.hmiApplicationService = new PhoneServiceProvider((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractPhoneApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), this, hashtable, this.getBundleContext(), this.log);
        this.hmiApplicationService.startService();
    }

    private void deregisterHMIApplication() {
        this.log.log(-2137614336, "[AbstractPhoneApplication#deregisterHMIApplication] called");
        if (this.hmiApplicationService != null) {
            this.hmiApplicationService.stopService();
        }
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    @Override
    public void popupVisible(int n, int n2) {
        this.telEventQueue.enqueue(new AbstractPhoneApplication$12(this, n, n2));
    }

    @Override
    public void popupHidden(int n, int n2) {
        this.telEventQueue.enqueue(new AbstractPhoneApplication$13(this, n, n2));
    }

    @Override
    public void popupRemoved(int n, int n2) {
        this.telEventQueue.enqueue(new AbstractPhoneApplication$14(this, n, n2));
    }

    @Override
    public void screenVisible(int n, int n2) {
        this.telEventQueue.enqueue(new AbstractPhoneApplication$15(this, n, n2));
    }

    @Override
    public void screenHidden(int n, int n2) {
        this.telEventQueue.enqueue(new AbstractPhoneApplication$16(this, n, n2));
    }

    @Override
    public void screenFadedOut(int n, int n2) {
        this.telEventQueue.enqueue(new AbstractPhoneApplication$17(this, n, n2));
    }

    @Override
    public void screenConnected(int n, int n2) {
        this.telEventQueue.enqueue(new AbstractPhoneApplication$18(this, n, n2));
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public IFrameworkAccess getFrameworkAccess() {
        return this.frameworkAccess;
    }

    @Override
    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }

    @Override
    public IMessageDispatcher getMessageDispatcher() {
        return this.messageDispatcher;
    }

    @Override
    public IPopupScreenStateDispatcher getPopupScreenStateDispatcher() {
        return this.popupStateDispatcher;
    }

    @Override
    public IGlobalTelephoneState getGlobalTelephoneStateManager() {
        return this.globalTelephoneStateManager;
    }

    @Override
    public final IPowerEventDispatcher getPowerEventDispatcher() {
        return this.powerEventDispatcher;
    }

    @Override
    public ILanguageUpdateDispatcher getLanguageUpdateDispatcher() {
        return this.languageUpdateDispatcher;
    }

    @Override
    public void addDiagnosisComponent(IPhoneDiagComponent iPhoneDiagComponent) {
        this.diagnosis.addDiagnosisComponent(iPhoneDiagComponent);
    }

    protected CommandListManager getCommandListManager() {
        return this.commandListManager;
    }

    protected abstract void addComponents() {
    }

    @Override
    public void logStartupEvent(String string) {
        this.getFrameworkAccess().getStartupMgr().logStartupEvent(string);
    }

    @Override
    public ITelephoneDSIAccess getTelephoneDSIAccess() {
        return this.dsiMobileEquipmentAccess;
    }

    @Override
    public void enqueueEvent(AbstractTelEvent abstractTelEvent) {
        this.telEventQueue.enqueue(abstractTelEvent);
    }

    @Override
    public LogChannel getStartupLogChannel() {
        return this.logStartup;
    }

    static /* synthetic */ IGlobalTelephoneState access$000(AbstractPhoneApplication abstractPhoneApplication) {
        return abstractPhoneApplication.globalTelephoneStateManager;
    }

    static /* synthetic */ void access$100(AbstractPhoneApplication abstractPhoneApplication) {
        abstractPhoneApplication.initDispatchers();
    }

    static /* synthetic */ void access$200(AbstractPhoneApplication abstractPhoneApplication) {
        abstractPhoneApplication.registerHMIApplication();
    }

    static /* synthetic */ void access$300(AbstractPhoneApplication abstractPhoneApplication) {
        abstractPhoneApplication.initDiagnosis();
    }

    static /* synthetic */ TelDSIMobileEquipmentAccessImpl access$400(AbstractPhoneApplication abstractPhoneApplication) {
        return abstractPhoneApplication.dsiMobileEquipmentAccess;
    }

    static /* synthetic */ void access$500(AbstractPhoneApplication abstractPhoneApplication) {
        abstractPhoneApplication.initComponents();
    }

    static /* synthetic */ LogChannel access$600(AbstractPhoneApplication abstractPhoneApplication) {
        return abstractPhoneApplication.logStartup;
    }

    static /* synthetic */ LogChannel access$700(AbstractPhoneApplication abstractPhoneApplication) {
        return abstractPhoneApplication.log;
    }

    static /* synthetic */ void access$800(AbstractPhoneApplication abstractPhoneApplication) {
        abstractPhoneApplication.deinitDispatchers();
    }

    static /* synthetic */ void access$900(AbstractPhoneApplication abstractPhoneApplication) {
        abstractPhoneApplication.deregisterHMIApplication();
    }

    static /* synthetic */ void access$1000(AbstractPhoneApplication abstractPhoneApplication) {
        abstractPhoneApplication.deinitComponents();
    }

    static /* synthetic */ TelEventQueue access$1100(AbstractPhoneApplication abstractPhoneApplication) {
        return abstractPhoneApplication.telEventQueue;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

