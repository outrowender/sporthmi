/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 *  de.mib.swdiagnosis.phone.PhoneApplicationDiag
 *  de.mib.swdiagnosis.phone.PhoneDiag
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelComponent;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.ap.ActionProxyDispatcher;
import de.audi.app.phone.core.ap.IActionProxyDispatcher;
import de.audi.app.phone.core.dsi.ITelephoneDSIAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentAccessImpl;
import de.audi.app.phone.core.event.AbstractTelDeinitEvent;
import de.audi.app.phone.core.event.AbstractTelEvent;
import de.audi.app.phone.core.event.AbstractTelHmiApplicationEvent;
import de.audi.app.phone.core.event.AbstractTelInitEvent;
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
        return this.frameworkAccess.getWaitSyncer(string, 15000L, this.log);
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

    public void init() {
        final IWaitSyncer iWaitSyncer = this.getWaitSyncer("AbstractPhoneApplication#init");
        this.telEventQueue.init();
        this.logStartup.log(1000000, "[AbstractPhoneApplication#init]");
        this.telEventQueue.enqueue(new AbstractTelInitEvent("[STARTUP] init global telephone state"){

            public void run() {
                AbstractPhoneApplication.this.globalTelephoneStateManager.init();
            }
        });
        this.telEventQueue.enqueue(new AbstractTelInitEvent("[STARTUP] init dispatchers"){

            public void run() {
                AbstractPhoneApplication.this.initDispatchers();
            }
        });
        this.telEventQueue.enqueue(new AbstractTelInitEvent("[STARTUP] register HMI application"){

            public void run() {
                AbstractPhoneApplication.this.registerHMIApplication();
            }
        });
        this.telEventQueue.enqueue(new AbstractTelInitEvent("[STARTUP] init diagnosis"){

            public void run() {
                AbstractPhoneApplication.this.initDiagnosis();
            }
        });
        this.telEventQueue.enqueue(new AbstractTelInitEvent("[STARTUP] add components"){

            public void run() {
                AbstractPhoneApplication.this.addComponents();
                AbstractPhoneApplication.this.addPhoneComponent(AbstractPhoneApplication.this.dsiMobileEquipmentAccess);
            }
        });
        this.telEventQueue.enqueue(new AbstractTelInitEvent("[STARTUP] init components"){

            public void run() {
                AbstractPhoneApplication.this.initComponents();
                AbstractPhoneApplication.this.logStartup.log(1000000, "[AbstractPhoneApplication#init] triggering waitsyncer");
                iWaitSyncer.trigger();
            }
        });
        this.logStartup.log(1000000, "[AbstractPhoneApplication#init] waiting for sync event.");
        iWaitSyncer.waitForTrigger();
        this.logStartup.log(1000000, "[AbstractPhoneApplication#init] init complete.");
    }

    public void deinit() {
        final IWaitSyncer iWaitSyncer = this.getWaitSyncer("AbstractPhoneApplication#deinit");
        this.logStartup.log(1000000, "[AbstractPhoneApplication#deinit]");
        this.telEventQueue.enqueue(new AbstractTelDeinitEvent("[SHUTDOWN] GlobalTelephoneState"){

            public void run() {
                try {
                    AbstractPhoneApplication.this.globalTelephoneStateManager.deinit();
                }
                catch (Exception exception) {
                    Thread.interrupted();
                    AbstractPhoneApplication.this.log.log(10000, "[AbstractPhoneApplication#deinit]", (Throwable)exception);
                }
            }
        });
        this.telEventQueue.enqueue(new AbstractTelDeinitEvent("[SHUTDOWN] dispatchers"){

            public void run() {
                try {
                    AbstractPhoneApplication.this.deinitDispatchers();
                }
                catch (Exception exception) {
                    Thread.interrupted();
                    AbstractPhoneApplication.this.log.log(10000, "[AbstractPhoneApplication#deinit]", (Throwable)exception);
                }
            }
        });
        this.telEventQueue.enqueue(new AbstractTelDeinitEvent("[SHUTDOWN] unregister HMIApplication"){

            public void run() {
                try {
                    AbstractPhoneApplication.this.deregisterHMIApplication();
                }
                catch (Exception exception) {
                    Thread.interrupted();
                    AbstractPhoneApplication.this.log.log(10000, "[AbstractPhoneApplication#deinit]", (Throwable)exception);
                }
            }
        });
        this.telEventQueue.enqueue(new AbstractTelDeinitEvent("[SHUTDOWN] deinit components"){

            public void run() {
                AbstractPhoneApplication.this.deinitComponents();
            }
        });
        this.telEventQueue.enqueue(new AbstractTelDeinitEvent("[SHUTDOWN] deinit event queue."){

            public void run() {
                try {
                    AbstractPhoneApplication.this.telEventQueue.deinit();
                }
                catch (Exception exception) {
                    Thread.interrupted();
                    AbstractPhoneApplication.this.log.log(10000, "[AbstractPhoneApplication#deinit]", (Throwable)exception);
                }
                AbstractPhoneApplication.this.logStartup.log(1000000, "[AbstractPhoneApplication#deinit] triggering waitsyncer.");
                iWaitSyncer.trigger();
            }
        });
        this.logStartup.log(1000000, "[AbstractPhoneApplication#deinit] waiting for sync event.");
        iWaitSyncer.waitForTrigger();
        this.logStartup.log(1000000, "[AbstractPhoneApplication#deinit] deinit complete.");
    }

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
                this.logStartup.log(1000000, "[AbstractPhoneApplication#deinitComponents] %1 took %2 ms", (Object)iTelComponent.getClass().getName(), (Object)String.valueOf(this.frameworkAccess.getMonotonicTime() - l));
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
                this.logStartup.log(1000000, "[AbstractPhoneApplication#initComponents] %1 took %2 ms", (Object)iTelComponent.getClass().getName(), (Object)String.valueOf(this.frameworkAccess.getMonotonicTime() - l));
            }
        }
    }

    private void initDiagnosis() {
        this.diagnosis.init();
        PhoneApplicationDiag phoneApplicationDiag = new PhoneApplicationDiag((ITelApplication)this);
        this.diagnosis.addDiagnosisComponent((IPhoneDiagComponent)phoneApplicationDiag);
    }

    private void registerHMIApplication() {
        this.log.log(10000000, "[AbstractPhoneApplication#registerHMIApplication] called");
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        hashtable.put("moduleID", new Integer(this.getId()));
        this.hmiApplicationService = new PhoneServiceProvider((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractPhoneApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), this, hashtable, this.getBundleContext(), this.log);
        this.hmiApplicationService.startService();
    }

    private void deregisterHMIApplication() {
        this.log.log(10000000, "[AbstractPhoneApplication#deregisterHMIApplication] called");
        if (this.hmiApplicationService != null) {
            this.hmiApplicationService.stopService();
        }
    }

    public int getId() {
        return 3;
    }

    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    public void popupVisible(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelHmiApplicationEvent(){

            public void run() {
                AbstractPhoneApplication.this.log.log(1000000, "[AbstractPhoneApplication#popupVisible] id=%1, terminalID=%2", (long)n, (long)n2);
                AbstractPhoneApplication.this.getPopupScreenStateDispatcher().notifyPopupVisible(n, n2);
            }
        });
    }

    public void popupHidden(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelHmiApplicationEvent(){

            public void run() {
                AbstractPhoneApplication.this.log.log(1000000, "[AbstractPhoneApplication#popupHidden] id=%1, terminalID=%2", (long)n, (long)n2);
                AbstractPhoneApplication.this.getPopupScreenStateDispatcher().notifyPopupHidden(n, n2);
            }
        });
    }

    public void popupRemoved(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelHmiApplicationEvent(){

            public void run() {
                AbstractPhoneApplication.this.log.log(1000000, "[AbstractPhoneApplication#popupRemoved] id=%1, terminalID=%2", (long)n, (long)n2);
                AbstractPhoneApplication.this.getPopupScreenStateDispatcher().notifyPopupRemoved(n, n2);
            }
        });
    }

    public void screenVisible(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelHmiApplicationEvent(){

            public void run() {
                AbstractPhoneApplication.this.log.log(1000000, "[AbstractPhoneApplication#screenVisible] id=%1, terminalID=%2", (long)n, (long)n2);
                AbstractPhoneApplication.this.getPopupScreenStateDispatcher().notifyScreenVisible(n, n2);
            }
        });
    }

    public void screenHidden(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelHmiApplicationEvent(){

            public void run() {
                AbstractPhoneApplication.this.log.log(1000000, "[AbstractPhoneApplication#screenHidden] id=%1, terminalID=%2", (long)n, (long)n2);
                AbstractPhoneApplication.this.getPopupScreenStateDispatcher().notifyScreenHidden(n, n2);
            }
        });
    }

    public void screenFadedOut(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelHmiApplicationEvent(){

            public void run() {
                AbstractPhoneApplication.this.log.log(1000000, "[AbstractPhoneApplication#screenFadedOut] id=%1, terminalID=%2", (long)n, (long)n2);
                AbstractPhoneApplication.this.getPopupScreenStateDispatcher().notifyScreenFadedOut(n, n2);
            }
        });
    }

    public void screenConnected(final int n, final int n2) {
        this.telEventQueue.enqueue(new AbstractTelHmiApplicationEvent(){

            public void run() {
                AbstractPhoneApplication.this.log.log(1000000, "[AbstractPhoneApplication#screenConnected] id=%1, terminalID=%2", (long)n, (long)n2);
                AbstractPhoneApplication.this.getPopupScreenStateDispatcher().notifyScreenConnected(n, n2);
            }
        });
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public IFrameworkAccess getFrameworkAccess() {
        return this.frameworkAccess;
    }

    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }

    public IMessageDispatcher getMessageDispatcher() {
        return this.messageDispatcher;
    }

    public IPopupScreenStateDispatcher getPopupScreenStateDispatcher() {
        return this.popupStateDispatcher;
    }

    public IGlobalTelephoneState getGlobalTelephoneStateManager() {
        return this.globalTelephoneStateManager;
    }

    public final IPowerEventDispatcher getPowerEventDispatcher() {
        return this.powerEventDispatcher;
    }

    public ILanguageUpdateDispatcher getLanguageUpdateDispatcher() {
        return this.languageUpdateDispatcher;
    }

    public void addDiagnosisComponent(IPhoneDiagComponent iPhoneDiagComponent) {
        this.diagnosis.addDiagnosisComponent(iPhoneDiagComponent);
    }

    protected CommandListManager getCommandListManager() {
        return this.commandListManager;
    }

    protected abstract void addComponents();

    public void logStartupEvent(String string) {
        this.getFrameworkAccess().getStartupMgr().logStartupEvent(string);
    }

    public ITelephoneDSIAccess getTelephoneDSIAccess() {
        return this.dsiMobileEquipmentAccess;
    }

    public void enqueueEvent(AbstractTelEvent abstractTelEvent) {
        this.telEventQueue.enqueue(abstractTelEvent);
    }

    public LogChannel getStartupLogChannel() {
        return this.logStartup;
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

