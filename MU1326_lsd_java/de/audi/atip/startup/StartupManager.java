/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.DispatcherDiag
 *  de.mib.swdiagnosis.JDSIManagerDiag
 *  de.mib.swdiagnosis.StartUpDiag
 */
package de.audi.atip.startup;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.FrameworkAccess;
import de.audi.atip.base.FwServices;
import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IDomainListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.EALMergeEvent;
import de.audi.atip.hmi.event.InitialGraphicsEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.MMICombiSyncEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.RegisterPartialPopupsEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.view.IShowPopupRunnable;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.Distance;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.start.ILastmodeHandler;
import de.audi.atip.start.IStartupManager;
import de.audi.atip.startup.AppStateManager;
import de.audi.atip.startup.BundleHandler;
import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.DomainHandler;
import de.audi.atip.startup.ILastmodeHandlerExtended;
import de.audi.atip.startup.LastmodeHandler;
import de.audi.atip.startup.StartupQueue;
import de.audi.atip.startup.StartupSyncer;
import de.audi.atip.storage.IStorageStatistic;
import de.audi.atip.timer.WatchDog;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.mib.swdiagnosis.DispatcherDiag;
import de.mib.swdiagnosis.JDSIManagerDiag;
import de.mib.swdiagnosis.StartUpDiag;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class StartupManager
implements IDomainListener,
IStartupManager,
PowerEventListener {
    private static final String LOG_CH_STARTUP = "Fw.Startup";
    private static final String LOG_CH_STARTUP_EVENT = "Fw.Startup.Event";
    private static final String LOG_CH_EXT_STARTUP = "Ext.Startup";
    private static final String START_HIGH_HMI_WATCHDOG = "START_HIGH_HMI_WATCHDOG";
    private static final String WAIT_FOR_RVC_AVAILABLE = "WAIT_FOR_RVC_AVAILABLE";
    private static final String WAIT_FOR_FIRST_POWERSTATE = "WAIT_FOR_FIRST_POWERSTATE";
    private static final String WAIT_FOR_MAP_AVAILABLE = "WAIT_FOR_MAP_AVAILABLE";
    private static final String WAIT_FOR_SDS_AVAILABLE = "WAIT_FOR_SDS_AVAILABLE";
    private static final String WAIT_FOR_FIRST_MMIKOMBISYNC = "WAIT_FOR_FIRST_MMIKOMBISYNC";
    private static final String WAIT_FOR_FIRST_SCREEN_PAINTED = "WAIT_FOR_FIRST_SCREEN_PAINTED";
    private static final String WAIT_FOR_DSI_PERSISTENCE = "DSI_PERSISTENCE_TIMEOUT";
    private static final String WAIT_FOR_AUDIO_TIMEOUT = "WAIT_FOR_AUDIO_TIMEOUT";
    private static final String DEFAULTSWDLDATADIR = "/net/rcc/mnt/efs-persist/SWDL";
    private static final String SWDLDATADIR = "SwdlDataDir";
    private static final String SWDLFLAGFILE = "update.txt";
    private static final int LOG_SIZE = 300;
    private static final int OVERRIDE_OFFSET = 128;
    private static final long TIMEOUT_RVC_AVAILABLE = Long.getLong("WAIT_FOR_RVC_AVAILABLE", 60000L);
    private static final long TIMEOUT_POWERSTATE = Long.getLong("WAIT_FOR_FIRST_POWERSTATE", 5000L);
    private static final long TIMEOUT_MAP_AVAILABLE = Long.getLong("WAIT_FOR_MAP_AVAILABLE", 20000L);
    private static final long TIMEOUT_SDS_AVAILABLE = Long.getLong("WAIT_FOR_SDS_AVAILABLE", 20000L);
    private static final long TIMEOUT_MMIKOMBISYNC = Long.getLong("WAIT_FOR_FIRST_MMIKOMBISYNC", 5000L);
    private static final long TIMEOUT_FIRST_SCREEN_PAINTED = Long.getLong("WAIT_FOR_FIRST_SCREEN_PAINTED", 5000L);
    private static final long WAIT_FOR_AUDIO_TIMEOUT_DEFAULT = 10000L;
    private static final long START_BUNDLE_TIMEOUT = 10000L;
    private static final long START_HMI_TIMEOUT = 180000L;
    private final FwServices fwServices;
    private final IFrameworkAccess framework;
    private long startOfFramework;
    private final AppStateManager appStateManager;
    protected ILastmodeHandlerExtended lastmodeHandler;
    private final BundleHandler bundleHandler;
    private final StartupQueue startupQueue;
    private final DispatcherBase startupDispatcher;
    private HMIService hmiService = null;
    private IJobFilter keyFilter = null;
    private boolean navEnabled = true;
    private volatile boolean rebootToEngineeringDL = false;
    private volatile boolean swdlRebootQueried = false;
    private final StartupSyncer syncPowerSwdl;
    private final StartupSyncer syncRVC;
    private final StartupSyncer syncNav;
    private final StartupSyncer syncTTS;
    private final StartupSyncer syncSDS;
    private final StartupSyncer syncMMIKombi;
    private final StartupSyncer syncFirstScreenPainted;
    private BundleContext bc;
    private ServiceRegistration regStartup = null;
    private ServiceTracker diagTracker;
    private volatile boolean smRunning;
    private volatile boolean popupShown;
    private volatile boolean fallBackScreenShown;
    private volatile boolean startupCompleted;
    private volatile boolean processHKs = true;
    private WatchDog hmiWatchDog = null;
    private final LogChannel logChStartup;
    private final LogChannel logChStartupEvent;
    private final LogChannel logExtStartup;
    private volatile boolean hmiServiceAvailable = false;
    private final List beforeAudioQueue = new ArrayList(20);
    private final List beforeAppQueue = new ArrayList(20);
    private final List shutdownQueue = new ArrayList(20);
    private final List delayedQueue = new ArrayList(20);
    private final List backgroundQueue = new ArrayList(50);
    private static boolean isSwDiagStarted = false;
    private Object syncPersistence = new Object();
    private boolean persistenceAvailable = false;
    private long bundleStartTimeout = 10000L;
    private long hmiStartTimeout = 180000L;
    private KeyEvent pressedEvent = null;
    private List loggedEvents = new LinkedList();
    private int discardedStartupEvents = 0;
    private List initialGraphicsEvents = new LinkedList();
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistence;
    static /* synthetic */ Class class$de$audi$atip$startup$StartupManager;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void logStartupEvent(LogChannel logChannel, int n, String string, Throwable throwable) {
        this.logExtStartup.log(1000000, string);
        if (logChannel != null) {
            if (throwable != null) {
                logChannel.log(n, string, throwable);
            } else {
                logChannel.log(n, string);
            }
        }
        List list = this.loggedEvents;
        synchronized (list) {
            if (this.loggedEvents.size() < 300) {
                this.loggedEvents.add(new LogEvent(string));
            } else {
                ++this.discardedStartupEvents;
            }
        }
    }

    public void logStartupEvent(String string) {
        this.logStartupEvent(null, 0, string, null);
    }

    public void logStartupEvent(LogChannel logChannel, int n, String string) {
        this.logStartupEvent(logChannel, n, string, null);
    }

    public ChoiceModelApp getSysChoiceModel(int n) {
        if (!this.hmiServiceAvailable) {
            this.logChStartup.log(10000, "Early Model Access to Model %1", (long)n);
            this.logStartupEvent(this.logChStartup, 10000, new StringBuffer().append("StartupManager#getSysChoiceModel() - Early Model Access to Model ").append(n).toString());
            return null;
        }
        return this.framework.getHMIService().getChoiceModel(n);
    }

    protected ChoiceModelApp getInitialApplication() {
        return this.getSysChoiceModel(129);
    }

    private ChoiceModelApp getSwdlActiveChoice() {
        return this.getSysChoiceModel(389);
    }

    public List getDelayedQueue() {
        return this.delayedQueue;
    }

    public List getShutdownQueue() {
        return this.shutdownQueue;
    }

    private String getSwdlDataDir() {
        return System.getProperty(SWDLDATADIR, DEFAULTSWDLDATADIR);
    }

    private boolean useUpdateTxt() {
        return System.getProperty(SWDLDATADIR) != null;
    }

    private File getSwdlFlagFile() {
        return new File(new StringBuffer().append(this.getSwdlDataDir()).append(SWDLFLAGFILE).toString());
    }

    private boolean isRebootToEngineeringDL() {
        if (!this.swdlRebootQueried) {
            File file = this.getSwdlFlagFile();
            if (file.exists()) {
                this.rebootToEngineeringDL = true;
                this.getFwServices().getSysApp().setEngineeringDownloadActive(this.rebootToEngineeringDL);
                if (this.rebootToEngineeringDL) {
                    System.out.println(new StringBuffer().append("=== Booting into SWDL HMI due to ").append(file.getAbsolutePath()).append(" ===").toString());
                }
            } else {
                this.rebootToEngineeringDL = false;
            }
            this.swdlRebootQueried = true;
        }
        return this.rebootToEngineeringDL;
    }

    public void setRVCActive(boolean bl) {
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager#setRVCActive (").append(bl ? "active" : "inactive").append(")").toString());
        this.syncRVC.trigger();
    }

    public void setMMIKombiLastmode(int n) {
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager#setMMIKombiLastmode(").append(n).append(")").toString());
        if (n >= 0) {
            this.getLMHandler().enqueueLastmodeChange(0, n);
        }
        this.getSyncMMIKombi().trigger();
    }

    public boolean waitForKombiSync() {
        this.getSyncMMIKombi().setupWait();
        this.logStartupEvent(null, 0, "StartupManager#waitForKombiSync() - DSIKombiSync wait for initialization ...");
        this.getSyncMMIKombi().waitForTrigger();
        this.logStartupEvent(null, 0, "StartupManager#waitForKombiSync() - DSIKombiSync wait for initialization done");
        boolean bl = this.getSyncMMIKombi().isTriggered();
        if (!bl) {
            this.logStartupEvent(this.logChStartup, 10000, "StartupManager#waitForKombiSync() - waiting for MMIKombiSync timed out!");
        }
        return bl;
    }

    public void triggerNavAvailable() {
        int n;
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#triggerNavAvailable()");
        int n2 = n = this.framework.isFrontMU() ? 0 : 5;
        if (this.getLMHandler().getLastmode(n) != 5 || !this.framework.isFrontMU()) {
            this.getSyncNav().trigger();
        } else {
            this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#triggerNavAvailable() - Navi is last mode, waiting for map to be shown.");
        }
    }

    public void triggerMapAvailable() {
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#triggerMapAvailable()");
        this.getSyncNav().trigger();
    }

    public void triggerSDSAvailable() {
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#triggerSDSAvailable()");
        this.getSyncSDS().trigger();
    }

    public void triggerNewScreenVisible() {
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#triggerNewScreenVisible()");
        this.getSyncFirstScreenPainted().trigger();
    }

    public void triggerTTSAvailable() {
        this.logStartupEvent(this.logChStartup, 1000000, "StMgr#triggerTTSAvailable()");
        this.getSyncTTS().trigger();
    }

    public boolean waitForTTSAvailable() {
        this.getSyncTTS().waitForTrigger();
        return this.getSyncTTS().isTriggered();
    }

    public boolean waitForFirstScreen() {
        this.getSyncFirstScreenPainted().waitForTrigger();
        return this.getSyncFirstScreenPainted().isTriggered();
    }

    public long getAudioTimeout() {
        return Long.getLong(WAIT_FOR_AUDIO_TIMEOUT, 10000L);
    }

    private void startDSIService(String string, int n) {
        if (!this.framework.startDSIService(string, n)) {
            this.logStartupEvent(this.logChStartup, 10000, new StringBuffer().append("StartupManager#startDSIService() - start of DSI: ").append(string).append(" Instance: ").append(n).append(" failed").toString());
        }
    }

    private void fireInitialEvent() {
        this.framework.getPowerMgr().setHMIReady();
        try {
            this.getVariantAppSystem().fireInitialEvent();
            this.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new ReleaseMute()));
        }
        catch (Exception exception) {
            this.criticalStartupError(exception, "AppSystemVariant not started! Cannot initialize Statemachine!");
        }
    }

    private String getDomainName(int n) {
        return DomainHandler.getDomainName(n);
    }

    public void showFirstScreen() {
        ComponentState componentState;
        if (this.isSMRunning()) {
            this.logStartupEvent(this.logChStartup, 10000000, "StartupManager#showFirstScreen() - ShowFirstScreen has already been executed - ignore");
            return;
        }
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#showFirstScreen() - before ShowFirstScreen");
        if (this.framework.isEvoHighMMIKombi() && !this.waitForKombiSync()) {
            this.processHKsDuringStartup(true);
        }
        if (this.framework.isFrontMU()) {
            this.syncRVC.setupWait();
        }
        this.smRunning = true;
        if (this.framework.isFrontMU() && Boolean.getBoolean("SYNC_EARLY_RVC")) {
            this.syncRVC.waitForTrigger();
            if (!this.syncRVC.isTriggered()) {
                this.logStartupEvent(this.logChStartup, 10000, "StartupManager#showFirstScreen() - Waiting for RVC failed!");
            }
        }
        if ((componentState = this.getAppStateManager().getComponentByName("Navi")) != null && componentState.isComponentEnabled()) {
            this.getAppStateManager().getNavProgressMonitor().start();
        }
        this.logChStartup.log(1000000, "StartupManager: send initial statemachine event");
        this.fireInitialEvent();
        this.logStartupEvent(null, 0, "StartupManager#showFirstScreen() - SMI started!");
        this.framework.getHMIService().getEventDispatcher().setAdaptiveSleepingEnabled(true);
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#showFirstScreen() - after ShowFirstScreen");
        this.framework.getMsgDistrib().sendMessage(2);
    }

    private void startFull() {
        this.getFwServices().fullStart();
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#startFull() - Framework startup completed!");
    }

    public void initDSI() {
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#initDSI() - Initialize DSI");
        this.getFwServices().createJDSIAdmin();
        try {
            this.getFwServices().createDomainActivator();
        }
        catch (Exception exception) {
            this.logStartupEvent(this.logChStartup, 10000, "StartupManager#initDSI() - DSIStartup failed!", exception);
        }
    }

    public void initSystem() {
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#initSystem()");
        this.getFwServices().createStorageManager();
        this.initDSIPersistence();
        this.getFwServices().createMsgDistrib();
        this.getFwServices().createPowerManager();
        if (!this.useUpdateTxt()) {
            this.syncPowerSwdl.waitForTrigger();
        }
        this.enqueueStartComponent(this.beforeAudioQueue, this.appStateManager.getHMIBasics(), true);
        this.getFwServices().createLanguageManager();
        this.getLMHandler().initLastmodeStorage(this.isRebootToDownload());
        if (this.isRebootToDownload()) {
            this.logStartupEvent(this.logChStartup, 100000, "StartupManager#initSystem() - SWDL is active! Start only Engineering App");
            this.initPersistentDataSwdl();
        } else {
            this.logStartupEvent(this.logChStartup, 100000, "StartupManager#initSystem() - SWDL not active! Start complete HMI");
            this.getFwServices().getSysApp().init(false);
            this.getLMHandler().initPersistentData();
            this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#initSystem() - Starting DSICarTimeUnitsLanguage");
            this.startDSIService((class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = StartupManager.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), 0);
        }
    }

    public void initHMI() {
        this.fwServices.createInfotainmentRecorder();
        this.fwServices.createSMInterpreter();
        this.framework.getSMInterpreter().registersSMListener(this.getAppStateManager().getGUIGuideModuleManager());
        this.framework.startDSIService((class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = StartupManager.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel).getName(), 0);
        if (Boolean.getBoolean(START_HIGH_HMI_WATCHDOG)) {
            this.getFwServices().createHMIWatchDog();
        }
        this.hmiServiceAvailable = true;
        this.getFwServices().createWavePlayer();
        Iterator iterator = this.initialGraphicsEvents.iterator();
        while (iterator.hasNext()) {
            this.hmiService.getEventDispatcher().postEvent((InitialGraphicsEvent)iterator.next());
        }
        this.getFwServices().createIconRenderer();
        this.getFwServices().createDisplayManagerService();
    }

    private int getHURegionForDistance() {
        return this.getFramework().isNar() ? 1 : 0;
    }

    public void initModelBanks() {
        this.getFwServices().initModels();
        this.getFwServices().getMsgDistrib().sendMessage(101);
        Distance.setHURegion(this.getHURegionForDistance());
        AbstractMetrics.setPorsche(this.getFramework().isPorsche());
        this.getFwServices().createSWaPHandler();
        this.getFwServices().createCacheHandler();
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#initModelBanks() - Starting DSIGeneralVehicleStates");
        this.startDSIService((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = StartupManager.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), 0);
        this.getAppStateManager().initializeModels();
        this.getDomainHandler().addDomainListener(this);
        this.getLMHandler().restoreLastmode();
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager#initModelBanks() - Corrrected Lastmode: ").append(this.getLMHandler().getLastmode(0)).append(", Lastmode Audi: ").append(this.getLMHandler().getLastmodeAudio(0)).toString());
        this.getLMHandler().setLastmodeForAllTerminals(false);
        if (this.isRebootToDownload()) {
            this.logStartupEvent(this.logChStartup, 100000, "StartupManager#initModelBanks() - SWDL is active! Start only Engineering App");
            this.getSwdlActiveChoice().setValue(1);
            this.initQueuesForSwdlLastmode();
        } else {
            this.logStartupEvent(this.logChStartup, 100000, "StartupManager#initModelBanks() - SWDL not active! Start complete HMI");
            this.getSwdlActiveChoice().setValue(0);
            if (!this.getFramework().isFrontMU() && this.getFwServices().getDomainActivator() != null) {
                this.getFwServices().getDomainActivator().initRSE();
            }
            this.enqueueStartComponent(this.beforeAudioQueue, this.appStateManager.getBeforeAudio(), true);
            this.initQueuesForLastmode();
            this.getLMHandler().initQueues();
        }
    }

    public void postStartup() {
        this.logStartupEvent(this.logChStartup, 10000, "StartupManager#postStartup() - Inform DSI that HMI is completely started!");
        this.getDomainHandler().informHMICompletelyStarted();
    }

    public StartupManager(FwServices fwServices) {
        this.fwServices = fwServices;
        this.framework = fwServices.getFramework();
        this.bc = this.framework.getBundleCxt();
        this.logChStartup = this.framework.getLogChannel(LOG_CH_STARTUP);
        this.logChStartupEvent = this.framework.getLogChannel(LOG_CH_STARTUP_EVENT);
        this.logExtStartup = this.framework.getLogChannel(LOG_CH_EXT_STARTUP);
        this.bundleHandler = new BundleHandler(this.bc, this.logChStartup);
        this.bundleStartTimeout = Long.getLong("BUNDLE_START_TIMEOUT", 10000L);
        this.hmiStartTimeout = Long.getLong("HMI_START_TIMEOUT", 180000L);
        this.lastmodeHandler = new LastmodeHandler(this, this.logChStartup);
        this.appStateManager = new AppStateManager(this);
        this.syncPowerSwdl = new StartupSyncer(this, "PowerSwdl", TIMEOUT_POWERSTATE, this.logChStartup);
        this.syncRVC = new StartupSyncer(this, "RVCStart", TIMEOUT_RVC_AVAILABLE, this.logChStartup);
        this.syncNav = new StartupSyncer(this, "NavAvailable", TIMEOUT_MAP_AVAILABLE, this.logChStartup);
        this.syncTTS = new StartupSyncer(this, "TTSAvailable", TIMEOUT_SDS_AVAILABLE, this.logChStartup);
        this.syncSDS = new StartupSyncer(this, "SDSAvailable", TIMEOUT_SDS_AVAILABLE, this.logChStartup);
        this.syncMMIKombi = new StartupSyncer(this, "MMIKombiSync", TIMEOUT_MMIKOMBISYNC, this.logChStartup);
        this.syncFirstScreenPainted = new StartupSyncer(this, "FirstScreenPainted", TIMEOUT_FIRST_SCREEN_PAINTED, this.logChStartup);
        this.syncFirstScreenPainted.setupWait();
        if (this.framework.isEvoHighMMIKombi()) {
            this.processHKsDuringStartup(false);
        }
        if (!this.useUpdateTxt()) {
            this.syncPowerSwdl.setupWait();
        }
        this.startupQueue = new StartupQueue(this.getFramework(), this.logChStartup);
        this.startupDispatcher = this.framework.getDispatcherManager().createDispatcher("Startup", new JobLogger(this.logChStartup), this.startupQueue);
        this.initQueues();
    }

    public void setStartOfFrameworkTimestamp(long l) {
        this.startOfFramework = l;
    }

    public void initHMIService(HMIService hMIService) {
        if (hMIService != null) {
            this.fwServices.setHMIService(hMIService);
            this.hmiService = hMIService;
            this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#initHMIService()");
            hMIService.getEventDispatcherAdmin().addEventFilter(this.keyFilter);
        }
    }

    public DomainHandler getDomainHandler() {
        return this.fwServices.getDomainHandler();
    }

    public AppStateManager getAppStateManager() {
        return this.appStateManager;
    }

    DispatcherBase getStartupDispatcher() {
        return this.startupDispatcher;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    FwServices getFwServices() {
        return ((FrameworkAccess)this.getFramework()).getFwServices();
    }

    BundleHandler getBundleHandler() {
        return this.bundleHandler;
    }

    public ILastmodeHandler getLastmodeHandler() {
        return this.lastmodeHandler;
    }

    private ILastmodeHandlerExtended getLMHandler() {
        return this.lastmodeHandler;
    }

    StartupQueue getStartupQueue() {
        return this.startupQueue;
    }

    StartupSyncer getSyncNav() {
        return this.syncNav;
    }

    StartupSyncer getSyncSDS() {
        return this.syncSDS;
    }

    StartupSyncer getSyncTTS() {
        return this.syncTTS;
    }

    private StartupSyncer getSyncFirstScreenPainted() {
        return this.syncFirstScreenPainted;
    }

    private StartupSyncer getSyncMMIKombi() {
        return this.syncMMIKombi;
    }

    public void startSwDiag() {
        Bundle bundle = this.getBundleHandler().getBundle("FwSwDiag");
        if (bundle != null && !isSwDiagStarted) {
            try {
                this.getBundleHandler().startBundle(bundle);
                isSwDiagStarted = true;
            }
            catch (BundleException bundleException) {
                this.logStartupEvent(this.logChStartup, 10000, "StartupManager#startSwDiag() - Start of FwSwDiag bundle faild", bundleException);
                System.err.println("[ERROR] Start of FwSwDiag bundle faild");
            }
        }
    }

    void switchToBackgroundPriority() {
        this.startupDispatcher.setPriority(5);
    }

    private int getFilteredKeyCode(int n) {
        return n > 128 ? n - 128 : n;
    }

    ComponentState getComponentState(int n) {
        return this.getAppStateManager().getComponentState(this.getFilteredKeyCode(n));
    }

    private void updateComponentState(String string) {
        this.getAppStateManager().updateComponentState(string);
    }

    private String getBundleName(Bundle bundle) {
        return this.getBundleHandler().getBundleName(bundle);
    }

    public boolean isStartupCompleted() {
        return this.startupCompleted;
    }

    public void setNavEnabled(boolean bl) {
        this.setNavEnabled(bl, true);
    }

    void setNavEnabled(boolean bl, boolean bl2) {
        this.navEnabled = bl;
        this.appStateManager.setNavEnabled(bl, false);
        if (bl2 && !this.isRebootToDownload()) {
            this.getLMHandler().storeNavEnabled(bl);
        }
    }

    public boolean isNavEnabled() {
        return this.navEnabled;
    }

    public boolean isSMRunning() {
        return this.smRunning;
    }

    private boolean forwardEvents() {
        return this.smRunning || this.popupShown || this.fallBackScreenShown;
    }

    boolean isHMIServiceAvailable() {
        return this.hmiServiceAvailable;
    }

    public void processHKsDuringStartup(boolean bl) {
        this.logStartupEvent(null, 0, new StringBuffer().append("StartupManager#processHKsDuringStartup(").append(bl).append(")").toString());
        this.processHKs = bl;
    }

    public boolean isRebootToDownload() {
        if (this.useUpdateTxt()) {
            return this.isRebootToEngineeringDL();
        }
        return this.rebootToEngineeringDL;
    }

    void criticalStartupError(Exception exception) {
        this.criticalStartupError(exception, exception != null ? exception.getMessage() : "null");
    }

    private void criticalStartupError(Exception exception, String string) {
        this.logStartupEvent(this.logChStartup, 1000, new StringBuffer().append("StartupManager#criticalStartupError() - ").append(string).toString(), exception);
        this.logStartupEvent(this.logChStartup, 1000, "StartupManager#criticalStartupError() - HMI will terminate!");
        this.framework.getErrorMgr().handleError(exception, "Startup failed! HMI is not operable and will terminate!", 0, 3, 2);
    }

    private WatchDog createBundleStartWatchDog(String string) {
        return this.framework.getErrorMgr().createWatchDog(this.bundleStartTimeout, null, string, 0, 0, 0);
    }

    private WatchDog createHMIStartWatchDog() {
        WatchDog watchDog = this.framework.getErrorMgr().createWatchDog(this.hmiStartTimeout, null, "Incomplete HMI startup! System will shut down!", 0, 3, 2);
        return watchDog;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void persistenceIsAvailable() {
        Object object = this.syncPersistence;
        synchronized (object) {
            this.persistenceAvailable = true;
            this.syncPersistence.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void waitForDSIPersistence() {
        Object object = this.syncPersistence;
        synchronized (object) {
            long l = Long.getLong(WAIT_FOR_DSI_PERSISTENCE, 5000L);
            this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager#waitForDSIPersistence() - Wait up to ").append(l).append("ms for DSIPersistence to register").toString());
            long l2 = this.framework.getMonotonicTime();
            if (!this.persistenceAvailable) {
                try {
                    this.syncPersistence.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
            if (this.persistenceAvailable) {
                this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#waitForDSIPersistence() - Wait for DSIPersistence succeeded");
                IStorageStatistic iStorageStatistic = this.framework.getStorageMgr().getStorageStatistic();
                if (iStorageStatistic != null) {
                    iStorageStatistic.setTime2Wait4DSI(this.framework.getMonotonicTime() - l2);
                }
            } else {
                this.criticalStartupError(new Exception("StartupManager.waitForDSIPersistence() failed! DSIPersistence still not available after timeout."));
            }
        }
    }

    private void initDSIPersistence() {
        this.startDSIService((class$org$dsi$ifc$persistence$DSIPersistence == null ? (class$org$dsi$ifc$persistence$DSIPersistence = StartupManager.class$("org.dsi.ifc.persistence.DSIPersistence")) : class$org$dsi$ifc$persistence$DSIPersistence).getName(), 0);
        this.waitForDSIPersistence();
    }

    private void initPersistentDataSwdl() {
        this.logStartupEvent(this.logChStartup, 1000000, "StartupManager#initPersistentDataSwdl() - Start start DSIPersistence");
        this.getFwServices().getSysApp().init(true);
    }

    void enqueueStartComponent(List list, ComponentState componentState, boolean bl) {
        if (componentState == null) {
            throw new IllegalArgumentException("StartupManager#enqueueStartComponent() - componentState is null");
        }
        if (bl) {
            componentState.enqueueStartFull(list, false);
        } else if (componentState.getStateModelId() == 376 || componentState.getStateModelId() == 354) {
            componentState.enqueueStartFull(list, false);
        } else {
            componentState.enqueueStartAudio(list);
        }
    }

    public void resourcesReady(int n) {
    }

    void enqueueStartBundle(List list, Bundle bundle, ComponentState componentState, boolean bl) {
        if (bundle != null) {
            this.getStartupQueue().enqueue(list, new StartBundle(bundle, componentState), bl);
        }
    }

    void enqueueStopBundle(List list, Bundle bundle, boolean bl) {
        if (bundle != null) {
            this.getStartupQueue().enqueue(list, new StopBundle(bundle), bl);
        }
    }

    void enqueueStartBundles(List list, Bundle[] bundleArray, ComponentState componentState, boolean bl) {
        this.getStartupQueue().enqueue(list, new StartBundles(bundleArray, componentState), bl);
    }

    void enqueueStopBundles(List list, Bundle[] bundleArray, boolean bl) {
        this.getStartupQueue().enqueue(list, new StopBundles(bundleArray), bl);
    }

    void enqueue(List list, Runnable runnable) {
        this.getStartupQueue().enqueue(list, runnable, false);
    }

    private void initQueues() {
        this.logChStartup.log(10000000, "StartupManager.initQueues!");
        this.enqueueStartComponent(this.beforeAudioQueue, this.appStateManager.getStaticInit(), true);
        this.getStartupQueue().addQueue(this.beforeAudioQueue, "Before Audio");
        this.getStartupQueue().addQueue(this.shutdownQueue, "ShutdownApps");
    }

    private void initQueuesForLastmode() {
        this.getLMHandler().initLastmodeAudioQueues();
        this.enqueueStartComponent(this.beforeAppQueue, this.appStateManager.getBeforeApp(), true);
        this.getStartupQueue().addQueue(this.beforeAppQueue, "Before Lastmode");
        this.getLMHandler().initLastmodeAppQueues();
        ArrayList arrayList = new ArrayList(10);
        this.enqueue(arrayList, new FullFrameworkStart());
        this.getStartupQueue().addQueue(arrayList, "Framework completion");
        this.getStartupQueue().addQueue(this.delayedQueue, "Delayed");
        this.appStateManager.enqueueBackgroundApps(this.backgroundQueue);
        this.getStartupQueue().addQueue(this.backgroundQueue, "Background");
        this.enqueueStartComponent(this.backgroundQueue, this.appStateManager.getAddon(), true);
        this.enqueue(this.backgroundQueue, new StartupFinished());
    }

    private void initQueuesForSwdlLastmode() {
        int n = this.getFramework().isFrontMU() ? 0 : 5;
        this.logStartupEvent(this.logChStartup, 10000000, new StringBuffer().append("StartupManager#initQueuesForSwdlLastmode() - Terminal: ").append(n).toString());
        this.getStartupQueue().addQueue(this.shutdownQueue, "ShutdownApps");
        this.getStartupQueue().addQueue(this.delayedQueue, "Delayed");
        ArrayList arrayList = new ArrayList(10);
        this.logChStartup.log(1000000, "StartupManager.initQueuesForSWDL()");
        this.enqueueStartComponent(arrayList, this.appStateManager.getSwdl(), true);
        this.enqueue(arrayList, new LastmodeSWDLReached(n));
        this.enqueue(arrayList, new StartupFinished());
        this.getStartupQueue().addQueue(arrayList, "Swdl Lastmode");
    }

    public void requestStartBundle(String string) {
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager.requestStartBundle(").append(string).append(")").toString());
        this.enqueueStartBundle(this.getDelayedQueue(), this.getBundleHandler().getBundle(string), null, true);
    }

    public void requestAppStart(int n) {
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager.requestAppStart(").append(n).append(")").toString());
        this.getLMHandler().enqueueLastmodeChange(-1, n);
    }

    public void requestAppStartByHMIKey(int n) {
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager.requestAppStartByHMIKey(").append(n).append(")").toString());
        this.getLMHandler().enqueueLastmodeChange(-1, this.getAppStateManager().convertKeyToLastmode(n));
    }

    public void muDomainIsAvailable(int n, int n2) {
        this.logStartupEvent(this.logChStartup, 100000, new StringBuffer().append("StartupManager#muDomainIsAvailable(").append(this.getDomainName(n)).append(", 0x").append(n2).append(") - METHOD NOT IMPLEMENTED").toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDomainState(int n, int n2) {
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager#updateDomainState(").append(this.getDomainName(n)).append(", 0x").append(n2).append(")").toString());
        try {
            this.startupDispatcher.suspend();
            this.getAppStateManager().updateDomainState(n, n2);
        }
        finally {
            this.startupDispatcher.resume();
        }
    }

    private void delayedStart(ComponentState componentState, int n) {
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager#delayedStart(").append(componentState.getComponentName()).append(", ").append(n).append(")").toString());
        if (DomainHandler.isIncluded(componentState.getStateFlagsMinimum(), n)) {
            componentState.enqueueStartFull(this.delayedQueue, false);
        } else {
            this.logStartupEvent(this.logChStartup, 10000, new StringBuffer().append("StartupManager#delayedStart() - The domain has not yet reached the required/minimum state: ").append(componentState.getStateFlagsMinimum()).toString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void delayedDomainIsAvailable(int n, int n2) {
        this.logStartupEvent(this.logChStartup, 1000000, new StringBuffer().append("StartupManager#delayedDomainIsAvailable(").append(this.getDomainName(n)).append(", 0x").append(n2).append(")").toString());
        try {
            this.startupDispatcher.suspend();
            ComponentState[] componentStateArray = this.getAppStateManager().getComponentStateByDomainId(n);
            if (componentStateArray != null) {
                for (int i2 = 0; i2 < componentStateArray.length; ++i2) {
                    ComponentState componentState = componentStateArray[componentStateArray.length - i2 - 1];
                    if (componentState == null) continue;
                    this.delayedStart(componentState, n2);
                }
            }
        }
        finally {
            this.startupDispatcher.resume();
        }
    }

    public void start() {
        this.regStartup = this.bc.registerService((class$de$audi$atip$startup$StartupManager == null ? (class$de$audi$atip$startup$StartupManager = StartupManager.class$("de.audi.atip.startup.StartupManager")) : class$de$audi$atip$startup$StartupManager).getName(), (Object)this, null);
        this.hmiWatchDog = this.createHMIStartWatchDog();
        this.keyFilter = new StartupFilter();
        this.startupDispatcher.start();
        this.getLMHandler().start();
        this.getFramework().getErrorMgr().registerDumpInfoProvider(new DumpInfoProvider(){

            public void dump(PrintStream printStream, String string) {
                StartupManager.this.dumpMembers(printStream);
                printStream.println();
                StartupManager.this.startupDispatcher.dump(printStream, string);
                printStream.println();
                StartupManager.this.dumpEvents(printStream);
            }

            public String getName() {
                return "StartupManager";
            }
        });
        this.diagTracker = new ServiceTracker(this.bc, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = StartupManager.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = StartupManager.this.bc.getService(serviceReference);
                if (object instanceof SwDiagnosisManager) {
                    ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new StartUpDiag(StartupManager.this));
                    ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new DispatcherDiag(StartupManager.this.bc));
                    ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new JDSIManagerDiag(StartupManager.this.fwServices));
                    return object;
                }
                StartupManager.this.bc.ungetService(serviceReference);
                return null;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                StartupManager.this.bc.ungetService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
        this.diagTracker.open();
    }

    public void stop() {
        this.getLMHandler().stop();
        this.startupDispatcher.stop();
        if (this.regStartup != null) {
            this.regStartup.unregister();
            this.regStartup = null;
        }
        if (this.diagTracker != null) {
            this.diagTracker.close();
            this.diagTracker = null;
        }
    }

    void postRunnableEvent(ATIPEvent aTIPEvent) {
        this.hmiService.getEventDispatcher().postEvent(aTIPEvent);
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
        if (!this.useUpdateTxt()) {
            this.logChStartup.log(1000000, "StartupManager.notifyPowerTriggerAction(trigger=%1)", (long)n);
            if (!this.swdlRebootQueried) {
                this.swdlRebootQueried = true;
                if (8 == n) {
                    System.out.println("=== Booting into SWDL HMI due to POWERSTATE_ON_SWDL. ===");
                    this.rebootToEngineeringDL = true;
                } else {
                    this.rebootToEngineeringDL = false;
                }
                this.syncPowerSwdl.trigger();
            } else {
                this.logChStartup.log(1000000, "StartupManager.notifyPowerTriggerAction ignore trigger=%1", (long)n);
            }
        }
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    private IAppSystem getVariantAppSystem() {
        return this.getFramework().getSysApp().getVariantAppSystem();
    }

    public void dumpDomainState(PrintStream printStream) {
        this.getDomainHandler().dumpDomainStartupTimes(printStream, "\n\t");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpMembers(PrintStream printStream) {
        printStream.println("Flags:");
        printStream.print("rebootToEngineeringDL: ");
        printStream.println(this.rebootToEngineeringDL);
        printStream.print("navEnabled: ");
        printStream.println(this.navEnabled);
        printStream.print("smRunning: ");
        printStream.println(this.smRunning);
        printStream.print("persistenceAvailable: ");
        Object object = this.syncPersistence;
        synchronized (object) {
            printStream.println(this.persistenceAvailable);
        }
        printStream.println();
        printStream.println("Timeouts:");
        printStream.print("  Bundle Start Timeout: ");
        printStream.println(this.bundleStartTimeout);
        printStream.print("  HMI Start Timeout: ");
        printStream.println(this.hmiStartTimeout);
        printStream.print("  Wait for Audio: ");
        printStream.println(this.getAudioTimeout());
        printStream.print("  Wait for Map: ");
        printStream.println(TIMEOUT_MAP_AVAILABLE);
        printStream.print("  Wait for RVC: ");
        printStream.println(TIMEOUT_RVC_AVAILABLE);
        printStream.print("  Wait for SDS: ");
        printStream.println(TIMEOUT_SDS_AVAILABLE);
        printStream.print("  Wait for first Powerstate: ");
        printStream.println(TIMEOUT_POWERSTATE);
        printStream.println();
        printStream.print("Framework Start: ");
        printStream.println(this.startOfFramework);
        printStream.println();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpEvents(PrintStream printStream) {
        printStream.println("Startup Events:");
        List list = this.loggedEvents;
        synchronized (list) {
            Iterator iterator = this.loggedEvents.iterator();
            while (iterator.hasNext()) {
                printStream.print("\t");
                printStream.println(iterator.next());
            }
        }
        printStream.print(new StringBuffer().append("Discarded Events: ").append(this.discardedStartupEvents).toString());
    }

    public void dumpQueue(PrintStream printStream) {
        this.getStartupQueue().dump(printStream);
        printStream.println();
        this.dumpEvents(printStream);
        printStream.flush();
    }

    public void addInitialEvents(List list) {
        this.initialGraphicsEvents.addAll(list);
    }

    public void setFallBackScreenShown(boolean bl) {
        this.fallBackScreenShown = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class LogEvent {
        private final long timestamp;
        private final String msg;

        LogEvent(String string) {
            this.timestamp = StartupManager.this.getFramework().getMonotonicTime();
            this.msg = string;
        }

        public String toString() {
            return new StringBuffer().append("[").append(this.timestamp).append("] ").append(this.msg).toString();
        }
    }

    static interface BundleJob
    extends Runnable {
        public String getBundleName();
    }

    protected class BundlesJob
    implements Runnable {
        final String prefix;
        final BundleJob[] jobs;

        BundlesJob(String string, int n) {
            this.prefix = string;
            this.jobs = new BundleJob[n];
        }

        public String toString() {
            Buffer buffer = new Buffer().append(this.prefix);
            for (int i2 = 0; i2 < this.jobs.length; ++i2) {
                if (i2 > 0) {
                    buffer.append(", ");
                }
                buffer.append(this.jobs[i2].getBundleName());
            }
            return buffer.toString();
        }

        public void run() {
            for (int i2 = 0; i2 < this.jobs.length; ++i2) {
                this.jobs[i2].run();
            }
        }
    }

    private class StopBundle
    implements BundleJob {
        private final Bundle bundle;
        private final String bundleName;

        StopBundle(Bundle bundle) {
            this.bundle = bundle;
            this.bundleName = StartupManager.this.getBundleName(bundle);
        }

        public final String toString() {
            return new Buffer().append("StopBundle: ").append(this.bundleName).toString();
        }

        public String getBundleName() {
            return this.bundleName;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void run() {
            WatchDog watchDog = null;
            try {
                watchDog = StartupManager.this.createBundleStartWatchDog(new StringBuffer().append("StopBundle#run() - Stop of bundle timed out: ").append(this.bundleName).toString());
                StartupManager.this.getBundleHandler().stopBundle(this.bundle);
            }
            catch (BundleException bundleException) {
                StartupManager.this.logChStartup.log(10000, "Stop of Bundle %1 failed!", (Object)this.bundleName, (Throwable)bundleException);
            }
            catch (RuntimeException runtimeException) {
                StartupManager.this.logChStartup.log(10000, "Stop of Bundle %1 failed!", (Object)this.bundleName, (Throwable)runtimeException);
            }
            finally {
                if (watchDog != null) {
                    watchDog.cancel();
                }
                StartupManager.this.getAppStateManager().updateComponentState(this.bundleName);
            }
        }
    }

    private class ReleaseMute
    implements Runnable {
        private ReleaseMute() {
        }

        public void run() {
            StartupManager.this.framework.getPowerMgr().releaseStandbyMute();
        }

        public String toString() {
            return "ReleaseMute";
        }
    }

    private class StartBundle
    implements BundleJob {
        private final Bundle bundle;
        private final String bundleName;
        private final ComponentState componentState;

        StartBundle(Bundle bundle, ComponentState componentState) {
            this.bundle = bundle;
            this.bundleName = StartupManager.this.getBundleName(bundle);
            this.componentState = componentState;
        }

        public String toString() {
            return new Buffer().append("StartBundle: ").append(this.bundleName).toString();
        }

        public String getBundleName() {
            return this.bundleName;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            WatchDog watchDog = null;
            if (this.componentState != null) {
                if (this.componentState.isDomainFailed()) {
                    StartupManager.this.logChStartup.log(1000000, "Bundle: %1 Do not start due to domain error!", (Object)this.bundleName);
                    return;
                }
                if (this.componentState.isWaitingForDomainStart()) {
                    StartupManager.this.logChStartup.log(1000000, "Bundle: %1 Do not start, startDomain call is still pending!", (Object)this.bundleName);
                    return;
                }
            }
            try {
                watchDog = StartupManager.this.createBundleStartWatchDog(new StringBuffer().append("Start of bundle timed out: ").append(this.bundleName).toString());
                StartupManager.this.getBundleHandler().startBundle(this.bundle);
                StartupManager.this.updateComponentState(this.bundleName);
            }
            catch (BundleException bundleException) {
                StartupManager.this.logChStartup.log(10000, "Start of Bundle %1 failed!", (Object)this.bundleName, (Throwable)bundleException);
                StartupManager.this.updateComponentState(this.bundleName);
                StartupManager.this.getFramework().getErrorMgr().handleError(bundleException, new StringBuffer().append("Error starting bundle (").append(this.bundleName).append(")").toString(), 0, 0, 0);
            }
            catch (RuntimeException runtimeException) {
                StartupManager.this.updateComponentState(this.bundleName);
                StartupManager.this.logStartupEvent(StartupManager.this.logChStartup, 10000, new StringBuffer().append("StartBundle#run() - Start of Bundle ").append(this.bundleName).append(" failed!").toString(), runtimeException);
            }
            finally {
                if (watchDog != null) {
                    watchDog.cancel();
                }
            }
        }
    }

    private class StopBundles
    extends BundlesJob {
        StopBundles(Bundle[] bundleArray) {
            super("StopBundles: ", bundleArray.length);
            for (int i2 = 0; i2 < bundleArray.length; ++i2) {
                this.jobs[i2] = new StopBundle(bundleArray[i2]);
            }
        }
    }

    private class StartBundles
    extends BundlesJob {
        private final ComponentState componentState;

        StartBundles(Bundle[] bundleArray, ComponentState componentState) {
            super("StartBundles: ", bundleArray.length);
            for (int i2 = 0; i2 < bundleArray.length; ++i2) {
                this.jobs[i2] = new StartBundle(bundleArray[i2], componentState);
            }
            this.componentState = componentState;
        }

        public void run() {
            if (this.componentState != null) {
                if (this.componentState.isDomainFailed()) {
                    StartupManager.this.logChStartup.log(1000000, "%1 Do not start due to domain error!", (Object)this);
                    return;
                }
                if (this.componentState.isWaitingForDomainStart()) {
                    StartupManager.this.logChStartup.log(1000000, "%1 Do not start, startDomain call is still pending!", (Object)this);
                    return;
                }
            }
            super.run();
        }
    }

    private class StartupFilter
    extends BaseJobFilter
    implements IJobFilter {
        private StartupFilter() {
        }

        private void processNonStartupAffecting(Job job, int n) {
            Object object = job.getPayload();
            if (StartupManager.this.forwardEvents()) {
                super.enqueue(job, n);
            } else if (object instanceof KeyEvent && ((KeyEvent)object).getKeyCode() == 16) {
                super.enqueue(job, n);
            } else if (object instanceof RunnableEvent) {
                RunnableEvent runnableEvent = (RunnableEvent)object;
                if (runnableEvent.getRunnable() instanceof IShowPopupRunnable) {
                    StartupManager.this.popupShown = true;
                    super.enqueue(job, n);
                } else if (runnableEvent.isProcessBeforeFirstScreen()) {
                    super.enqueue(job, n);
                } else {
                    StartupManager.this.logChStartupEvent.log(10000000, "StartupManager: discard %1", (Object)job);
                }
            } else if (object instanceof RegisterPartialPopupsEvent) {
                super.enqueue(job, n);
            } else if (object instanceof MMICombiSyncEvent) {
                super.enqueue(job, n);
            } else if (object instanceof ModelUpdateEvent && ((ModelUpdateEvent)object).isForceUpdateActivated()) {
                super.enqueue(job, n);
            } else if (object instanceof EALMergeEvent) {
                if (StartupManager.this.logChStartupEvent.isDebug()) {
                    StartupManager.this.logChStartupEvent.log(10000000, "StartupManager: enqueue EALMergeEvent for Node: %1", (Object)((EALMergeEvent)object).getNodeName());
                }
                super.enqueue(job, n);
            } else {
                StartupManager.this.logChStartupEvent.log(10000000, "StartupManager: discard %1", (Object)job);
            }
        }

        public void enqueue(Job job, int n) {
            StartupManager.this.logChStartupEvent.log(10000000, "StartupManager: handle event %1", (Object)job);
            Object object = job.getPayload();
            if (StartupManager.this.processHKs && !StartupManager.this.isStartupCompleted() && object instanceof KeyEvent && StartupManager.this.getLMHandler().isValidLastmode((KeyEvent)object)) {
                StartupManager.this.logChStartupEvent.log(10000000, "StartupManager#postEvent: KeyEvent is valid lastmode");
                KeyEvent keyEvent = (KeyEvent)object;
                StartupManager.this.logChStartupEvent.log(1000000, "StartupManager: intercept %1", (Object)keyEvent);
                if (keyEvent.getID() == 10402) {
                    if (StartupManager.this.getLMHandler().checkLastmodeChange(keyEvent)) {
                        if (StartupManager.this.pressedEvent == null) {
                            StartupManager.this.pressedEvent = new KeyEvent(keyEvent.getReceiver(), 10401, keyEvent.getKeyCode(), keyEvent.getTerminalID());
                        }
                        super.enqueue(new Job(StartupManager.this.pressedEvent), n);
                        super.enqueue(new Job(keyEvent), n);
                    }
                    StartupManager.this.pressedEvent = null;
                } else {
                    StartupManager.this.pressedEvent = keyEvent;
                }
            } else {
                this.processNonStartupAffecting(job, n);
            }
        }
    }

    private class StartupFinished
    implements Runnable {
        private StartupFinished() {
        }

        public final String toString() {
            return "StartupFinished";
        }

        public final void run() {
            System.out.println("######################################");
            System.out.println(new StringBuffer().append("# HMI STARTUP FINISHED [").append(StartupManager.this.getFramework().getMonotonicTime() - StartupManager.this.startOfFramework).append("ms]").toString());
            System.out.println("######################################");
            StartupManager.this.logStartupEvent(StartupManager.this.logChStartup, 1000000, "StartupFinished#run() - HMI STARTUP FINISHED");
            StartupManager.this.startupCompleted = true;
            if (StartupManager.this.hmiService != null) {
                StartupManager.this.logStartupEvent(StartupManager.this.logChStartup, 1000000, "StartupFinished#run() - Remove StartupFilter from event queue");
                StartupManager.this.hmiService.getEventDispatcherAdmin().removeEventFilter(StartupManager.this.keyFilter);
            }
            if (StartupManager.this.hmiWatchDog != null) {
                StartupManager.this.hmiWatchDog.cancel();
            }
            if (StartupManager.this.framework.isTarget()) {
                try {
                    File file = new File("/tmp/MMX-startup-finished");
                    file.delete();
                    file.createNewFile();
                }
                catch (Exception exception) {
                    StartupManager.this.logStartupEvent(StartupManager.this.logChStartup, 10000, "StartupFinished#run() - Exception on writing /tmp/MMX-startup-finished", exception);
                }
            }
            StartupManager.this.framework.getMsgDistrib().sendMessage(3);
            if (StartupManager.this.pressedEvent != null && StartupManager.this.hmiService != null) {
                StartupManager.this.logStartupEvent(StartupManager.this.logChStartup, 10000000, new StringBuffer().append("StartupFinished#run() - Forward ").append(StartupManager.this.pressedEvent).toString());
                StartupManager.this.logChStartupEvent.log(10000000, "StartupManager: forward %1", (Object)StartupManager.this.pressedEvent);
                StartupManager.this.hmiService.getEventDispatcher().postEvent(StartupManager.this.pressedEvent);
                StartupManager.this.pressedEvent = null;
            }
        }
    }

    private class FullFrameworkStart
    implements Runnable {
        private FullFrameworkStart() {
        }

        public final String toString() {
            return "FullFrameworkStart";
        }

        public final void run() {
            try {
                StartupManager.this.startFull();
            }
            catch (Exception exception) {
                StartupManager.this.logStartupEvent(StartupManager.this.logChStartup, 10000, "FullFrameworkStart#run() - Full Framework start failed!", exception);
                throw new FrameworkException("Full Framework start failed!", exception);
            }
        }
    }

    private class LastmodeSWDLReached
    implements Runnable {
        final int terminalID;

        public LastmodeSWDLReached(int n) {
            this.terminalID = n;
        }

        public final String toString() {
            return "LastmodeSWDLReached terminalID:";
        }

        public final void run() {
            if (StartupManager.this.getLMHandler().activateLastmodeApp(StartupManager.this.appStateManager.getSwdlLastmode(), this.terminalID)) {
                StartupManager.this.getLMHandler().setLastmode(this.terminalID, StartupManager.this.appStateManager.getSwdlLastmode(), false);
                StartupManager.this.smRunning = true;
                StartupManager.this.fireInitialEvent();
                StartupManager.this.logChStartup.log(1000000, "StartupManager: lastmode app is active!");
                StartupManager.this.switchToBackgroundPriority();
                try {
                    StartupManager.this.framework.getMsgDistrib().sendMessage(6);
                    StartupManager.this.startFull();
                }
                catch (Exception exception) {
                    StartupManager.this.logChStartup.log(10000, "StartupManager: Framework.startFull failed!", (Throwable)exception);
                    throw new FrameworkException("Full Framework start failed!", exception);
                }
            }
        }
    }
}

