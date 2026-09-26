/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.FrameworkAccess;
import de.audi.atip.base.FwServices;
import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IDomainListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.InitialGraphicsEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
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
import de.audi.atip.startup.StartupManager$1;
import de.audi.atip.startup.StartupManager$2;
import de.audi.atip.startup.StartupManager$FullFrameworkStart;
import de.audi.atip.startup.StartupManager$LastmodeSWDLReached;
import de.audi.atip.startup.StartupManager$LogEvent;
import de.audi.atip.startup.StartupManager$ReleaseMute;
import de.audi.atip.startup.StartupManager$StartBundle;
import de.audi.atip.startup.StartupManager$StartBundles;
import de.audi.atip.startup.StartupManager$StartupFilter;
import de.audi.atip.startup.StartupManager$StartupFinished;
import de.audi.atip.startup.StartupManager$StopBundle;
import de.audi.atip.startup.StartupManager$StopBundles;
import de.audi.atip.startup.StartupQueue;
import de.audi.atip.startup.StartupSyncer;
import de.audi.atip.storage.IStorageStatistic;
import de.audi.atip.timer.WatchDog;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IJobFilter;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class StartupManager
implements IDomainListener,
IStartupManager,
PowerEventListener {
    private static final String LOG_CH_STARTUP;
    private static final String LOG_CH_STARTUP_EVENT;
    private static final String LOG_CH_EXT_STARTUP;
    private static final String START_HIGH_HMI_WATCHDOG;
    private static final String WAIT_FOR_RVC_AVAILABLE;
    private static final String WAIT_FOR_FIRST_POWERSTATE;
    private static final String WAIT_FOR_MAP_AVAILABLE;
    private static final String WAIT_FOR_SDS_AVAILABLE;
    private static final String WAIT_FOR_FIRST_MMIKOMBISYNC;
    private static final String WAIT_FOR_FIRST_SCREEN_PAINTED;
    private static final String WAIT_FOR_DSI_PERSISTENCE;
    private static final String WAIT_FOR_AUDIO_TIMEOUT;
    private static final String DEFAULTSWDLDATADIR;
    private static final String SWDLDATADIR;
    private static final String SWDLFLAGFILE;
    private static final int LOG_SIZE;
    private static final int OVERRIDE_OFFSET;
    private static final long TIMEOUT_RVC_AVAILABLE;
    private static final long TIMEOUT_POWERSTATE;
    private static final long TIMEOUT_MAP_AVAILABLE;
    private static final long TIMEOUT_SDS_AVAILABLE;
    private static final long TIMEOUT_MMIKOMBISYNC;
    private static final long TIMEOUT_FIRST_SCREEN_PAINTED;
    private static final long WAIT_FOR_AUDIO_TIMEOUT_DEFAULT;
    private static final long START_BUNDLE_TIMEOUT;
    private static final long START_HMI_TIMEOUT;
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
    private static boolean isSwDiagStarted;
    private Object syncPersistence = new Object();
    private boolean persistenceAvailable = false;
    private long bundleStartTimeout = 0;
    private long hmiStartTimeout = 0;
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
    @Override
    public void logStartupEvent(LogChannel logChannel, int n, String string, Throwable throwable) {
        this.logExtStartup.log(1078071040, string);
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
                this.loggedEvents.add(new StartupManager$LogEvent(this, string));
            } else {
                ++this.discardedStartupEvents;
            }
        }
    }

    @Override
    public void logStartupEvent(String string) {
        this.logStartupEvent(null, 0, string, null);
    }

    @Override
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
        return System.getProperty("SwdlDataDir", "/net/rcc/mnt/efs-persist/SWDL");
    }

    private boolean useUpdateTxt() {
        return System.getProperty("SwdlDataDir") != null;
    }

    private File getSwdlFlagFile() {
        return new File(new StringBuffer().append(this.getSwdlDataDir()).append("update.txt").toString());
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

    @Override
    public void setRVCActive(boolean bl) {
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager#setRVCActive (").append(bl ? "active" : "inactive").append(")").toString());
        this.syncRVC.trigger();
    }

    @Override
    public void setMMIKombiLastmode(int n) {
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager#setMMIKombiLastmode(").append(n).append(")").toString());
        if (n >= 0) {
            this.getLMHandler().enqueueLastmodeChange(0, n);
        }
        this.getSyncMMIKombi().trigger();
    }

    @Override
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

    @Override
    public void triggerNavAvailable() {
        int n;
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#triggerNavAvailable()");
        int n2 = n = this.framework.isFrontMU() ? 0 : 5;
        if (this.getLMHandler().getLastmode(n) != 5 || !this.framework.isFrontMU()) {
            this.getSyncNav().trigger();
        } else {
            this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#triggerNavAvailable() - Navi is last mode, waiting for map to be shown.");
        }
    }

    @Override
    public void triggerMapAvailable() {
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#triggerMapAvailable()");
        this.getSyncNav().trigger();
    }

    public void triggerSDSAvailable() {
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#triggerSDSAvailable()");
        this.getSyncSDS().trigger();
    }

    @Override
    public void triggerNewScreenVisible() {
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#triggerNewScreenVisible()");
        this.getSyncFirstScreenPainted().trigger();
    }

    @Override
    public void triggerTTSAvailable() {
        this.logStartupEvent(this.logChStartup, 1078071040, "StMgr#triggerTTSAvailable()");
        this.getSyncTTS().trigger();
    }

    @Override
    public boolean waitForTTSAvailable() {
        this.getSyncTTS().waitForTrigger();
        return this.getSyncTTS().isTriggered();
    }

    @Override
    public boolean waitForFirstScreen() {
        this.getSyncFirstScreenPainted().waitForTrigger();
        return this.getSyncFirstScreenPainted().isTriggered();
    }

    public long getAudioTimeout() {
        return Long.getLong("WAIT_FOR_AUDIO_TIMEOUT", 0);
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
            this.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(false, new StartupManager$ReleaseMute(this, null)));
        }
        catch (Exception exception) {
            this.criticalStartupError(exception, "AppSystemVariant not started! Cannot initialize Statemachine!");
        }
    }

    private String getDomainName(int n) {
        return DomainHandler.getDomainName(n);
    }

    @Override
    public void showFirstScreen() {
        ComponentState componentState;
        if (this.isSMRunning()) {
            this.logStartupEvent(this.logChStartup, -2137614336, "StartupManager#showFirstScreen() - ShowFirstScreen has already been executed - ignore");
            return;
        }
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#showFirstScreen() - before ShowFirstScreen");
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
        this.logChStartup.log(1078071040, "StartupManager: send initial statemachine event");
        this.fireInitialEvent();
        this.logStartupEvent(null, 0, "StartupManager#showFirstScreen() - SMI started!");
        this.framework.getHMIService().getEventDispatcher().setAdaptiveSleepingEnabled(true);
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#showFirstScreen() - after ShowFirstScreen");
        this.framework.getMsgDistrib().sendMessage(2);
    }

    private void startFull() {
        this.getFwServices().fullStart();
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#startFull() - Framework startup completed!");
    }

    @Override
    public void initDSI() {
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#initDSI() - Initialize DSI");
        this.getFwServices().createJDSIAdmin();
        try {
            this.getFwServices().createDomainActivator();
        }
        catch (Exception exception) {
            this.logStartupEvent(this.logChStartup, 10000, "StartupManager#initDSI() - DSIStartup failed!", exception);
        }
    }

    @Override
    public void initSystem() {
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#initSystem()");
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
            this.logStartupEvent(this.logChStartup, -1601830656, "StartupManager#initSystem() - SWDL is active! Start only Engineering App");
            this.initPersistentDataSwdl();
        } else {
            this.logStartupEvent(this.logChStartup, -1601830656, "StartupManager#initSystem() - SWDL not active! Start complete HMI");
            this.getFwServices().getSysApp().init(false);
            this.getLMHandler().initPersistentData();
            this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#initSystem() - Starting DSICarTimeUnitsLanguage");
            this.startDSIService((class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = StartupManager.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), 0);
        }
    }

    @Override
    public void initHMI() {
        this.fwServices.createInfotainmentRecorder();
        this.fwServices.createSMInterpreter();
        this.framework.getSMInterpreter().registersSMListener(this.getAppStateManager().getGUIGuideModuleManager());
        this.framework.startDSIService((class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = StartupManager.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel).getName(), 0);
        if (Boolean.getBoolean("START_HIGH_HMI_WATCHDOG")) {
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

    @Override
    public void initModelBanks() {
        this.getFwServices().initModels();
        this.getFwServices().getMsgDistrib().sendMessage(101);
        Distance.setHURegion(this.getHURegionForDistance());
        AbstractMetrics.setPorsche(this.getFramework().isPorsche());
        this.getFwServices().createSWaPHandler();
        this.getFwServices().createCacheHandler();
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#initModelBanks() - Starting DSIGeneralVehicleStates");
        this.startDSIService((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = StartupManager.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), 0);
        this.getAppStateManager().initializeModels();
        this.getDomainHandler().addDomainListener(this);
        this.getLMHandler().restoreLastmode();
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager#initModelBanks() - Corrrected Lastmode: ").append(this.getLMHandler().getLastmode(0)).append(", Lastmode Audi: ").append(this.getLMHandler().getLastmodeAudio(0)).toString());
        this.getLMHandler().setLastmodeForAllTerminals(false);
        if (this.isRebootToDownload()) {
            this.logStartupEvent(this.logChStartup, -1601830656, "StartupManager#initModelBanks() - SWDL is active! Start only Engineering App");
            this.getSwdlActiveChoice().setValue(1);
            this.initQueuesForSwdlLastmode();
        } else {
            this.logStartupEvent(this.logChStartup, -1601830656, "StartupManager#initModelBanks() - SWDL not active! Start complete HMI");
            this.getSwdlActiveChoice().setValue(0);
            if (!this.getFramework().isFrontMU() && this.getFwServices().getDomainActivator() != null) {
                this.getFwServices().getDomainActivator().initRSE();
            }
            this.enqueueStartComponent(this.beforeAudioQueue, this.appStateManager.getBeforeAudio(), true);
            this.initQueuesForLastmode();
            this.getLMHandler().initQueues();
        }
    }

    @Override
    public void postStartup() {
        this.logStartupEvent(this.logChStartup, 10000, "StartupManager#postStartup() - Inform DSI that HMI is completely started!");
        this.getDomainHandler().informHMICompletelyStarted();
    }

    public StartupManager(FwServices fwServices) {
        this.fwServices = fwServices;
        this.framework = fwServices.getFramework();
        this.bc = this.framework.getBundleCxt();
        this.logChStartup = this.framework.getLogChannel("Fw.Startup");
        this.logChStartupEvent = this.framework.getLogChannel("Fw.Startup.Event");
        this.logExtStartup = this.framework.getLogChannel("Ext.Startup");
        this.bundleHandler = new BundleHandler(this.bc, this.logChStartup);
        this.bundleStartTimeout = Long.getLong("BUNDLE_START_TIMEOUT", 0);
        this.hmiStartTimeout = Long.getLong("HMI_START_TIMEOUT", 0);
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
            this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#initHMIService()");
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

    @Override
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

    @Override
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

    @Override
    public boolean isStartupCompleted() {
        return this.startupCompleted;
    }

    @Override
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

    @Override
    public boolean isNavEnabled() {
        return this.navEnabled;
    }

    @Override
    public boolean isSMRunning() {
        return this.smRunning;
    }

    private boolean forwardEvents() {
        return this.smRunning || this.popupShown || this.fallBackScreenShown;
    }

    boolean isHMIServiceAvailable() {
        return this.hmiServiceAvailable;
    }

    @Override
    public void processHKsDuringStartup(boolean bl) {
        this.logStartupEvent(null, 0, new StringBuffer().append("StartupManager#processHKsDuringStartup(").append(bl).append(")").toString());
        this.processHKs = bl;
    }

    @Override
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
            long l = Long.getLong("DSI_PERSISTENCE_TIMEOUT", 0);
            this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager#waitForDSIPersistence() - Wait up to ").append(l).append("ms for DSIPersistence to register").toString());
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
                this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#waitForDSIPersistence() - Wait for DSIPersistence succeeded");
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
        this.logStartupEvent(this.logChStartup, 1078071040, "StartupManager#initPersistentDataSwdl() - Start start DSIPersistence");
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

    @Override
    public void resourcesReady(int n) {
    }

    void enqueueStartBundle(List list, Bundle bundle, ComponentState componentState, boolean bl) {
        if (bundle != null) {
            this.getStartupQueue().enqueue(list, new StartupManager$StartBundle(this, bundle, componentState), bl);
        }
    }

    void enqueueStopBundle(List list, Bundle bundle, boolean bl) {
        if (bundle != null) {
            this.getStartupQueue().enqueue(list, new StartupManager$StopBundle(this, bundle), bl);
        }
    }

    void enqueueStartBundles(List list, Bundle[] bundleArray, ComponentState componentState, boolean bl) {
        this.getStartupQueue().enqueue(list, new StartupManager$StartBundles(this, bundleArray, componentState), bl);
    }

    void enqueueStopBundles(List list, Bundle[] bundleArray, boolean bl) {
        this.getStartupQueue().enqueue(list, new StartupManager$StopBundles(this, bundleArray), bl);
    }

    void enqueue(List list, Runnable runnable) {
        this.getStartupQueue().enqueue(list, runnable, false);
    }

    private void initQueues() {
        this.logChStartup.log(-2137614336, "StartupManager.initQueues!");
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
        this.enqueue(arrayList, new StartupManager$FullFrameworkStart(this, null));
        this.getStartupQueue().addQueue(arrayList, "Framework completion");
        this.getStartupQueue().addQueue(this.delayedQueue, "Delayed");
        this.appStateManager.enqueueBackgroundApps(this.backgroundQueue);
        this.getStartupQueue().addQueue(this.backgroundQueue, "Background");
        this.enqueueStartComponent(this.backgroundQueue, this.appStateManager.getAddon(), true);
        this.enqueue(this.backgroundQueue, new StartupManager$StartupFinished(this, null));
    }

    private void initQueuesForSwdlLastmode() {
        int n = this.getFramework().isFrontMU() ? 0 : 5;
        this.logStartupEvent(this.logChStartup, -2137614336, new StringBuffer().append("StartupManager#initQueuesForSwdlLastmode() - Terminal: ").append(n).toString());
        this.getStartupQueue().addQueue(this.shutdownQueue, "ShutdownApps");
        this.getStartupQueue().addQueue(this.delayedQueue, "Delayed");
        ArrayList arrayList = new ArrayList(10);
        this.logChStartup.log(1078071040, "StartupManager.initQueuesForSWDL()");
        this.enqueueStartComponent(arrayList, this.appStateManager.getSwdl(), true);
        this.enqueue(arrayList, new StartupManager$LastmodeSWDLReached(this, n));
        this.enqueue(arrayList, new StartupManager$StartupFinished(this, null));
        this.getStartupQueue().addQueue(arrayList, "Swdl Lastmode");
    }

    @Override
    public void requestStartBundle(String string) {
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager.requestStartBundle(").append(string).append(")").toString());
        this.enqueueStartBundle(this.getDelayedQueue(), this.getBundleHandler().getBundle(string), null, true);
    }

    @Override
    public void requestAppStart(int n) {
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager.requestAppStart(").append(n).append(")").toString());
        this.getLMHandler().enqueueLastmodeChange(-1, n);
    }

    @Override
    public void requestAppStartByHMIKey(int n) {
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager.requestAppStartByHMIKey(").append(n).append(")").toString());
        this.getLMHandler().enqueueLastmodeChange(-1, this.getAppStateManager().convertKeyToLastmode(n));
    }

    @Override
    public void muDomainIsAvailable(int n, int n2) {
        this.logStartupEvent(this.logChStartup, -1601830656, new StringBuffer().append("StartupManager#muDomainIsAvailable(").append(this.getDomainName(n)).append(", 0x").append(n2).append(") - METHOD NOT IMPLEMENTED").toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateDomainState(int n, int n2) {
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager#updateDomainState(").append(this.getDomainName(n)).append(", 0x").append(n2).append(")").toString());
        try {
            this.startupDispatcher.suspend();
            this.getAppStateManager().updateDomainState(n, n2);
        }
        finally {
            this.startupDispatcher.resume();
        }
    }

    private void delayedStart(ComponentState componentState, int n) {
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager#delayedStart(").append(componentState.getComponentName()).append(", ").append(n).append(")").toString());
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
        this.logStartupEvent(this.logChStartup, 1078071040, new StringBuffer().append("StartupManager#delayedDomainIsAvailable(").append(this.getDomainName(n)).append(", 0x").append(n2).append(")").toString());
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
        this.keyFilter = new StartupManager$StartupFilter(this, null);
        this.startupDispatcher.start();
        this.getLMHandler().start();
        this.getFramework().getErrorMgr().registerDumpInfoProvider(new StartupManager$1(this));
        this.diagTracker = new ServiceTracker(this.bc, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = StartupManager.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)new StartupManager$2(this));
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

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
        if (!this.useUpdateTxt()) {
            this.logChStartup.log(1078071040, "StartupManager.notifyPowerTriggerAction(trigger=%1)", (long)n);
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
                this.logChStartup.log(1078071040, "StartupManager.notifyPowerTriggerAction ignore trigger=%1", (long)n);
            }
        }
    }

    @Override
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

    @Override
    public void addInitialEvents(List list) {
        this.initialGraphicsEvents.addAll(list);
    }

    @Override
    public void setFallBackScreenShown(boolean bl) {
        this.fallBackScreenShown = bl;
    }

    static /* synthetic */ IFrameworkAccess access$100(StartupManager startupManager) {
        return startupManager.framework;
    }

    static /* synthetic */ String access$200(StartupManager startupManager, Bundle bundle) {
        return startupManager.getBundleName(bundle);
    }

    static /* synthetic */ LogChannel access$300(StartupManager startupManager) {
        return startupManager.logChStartup;
    }

    static /* synthetic */ WatchDog access$400(StartupManager startupManager, String string) {
        return startupManager.createBundleStartWatchDog(string);
    }

    static /* synthetic */ void access$500(StartupManager startupManager, String string) {
        startupManager.updateComponentState(string);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$600(StartupManager startupManager) {
        startupManager.startFull();
    }

    static /* synthetic */ AppStateManager access$700(StartupManager startupManager) {
        return startupManager.appStateManager;
    }

    static /* synthetic */ ILastmodeHandlerExtended access$800(StartupManager startupManager) {
        return startupManager.getLMHandler();
    }

    static /* synthetic */ boolean access$902(StartupManager startupManager, boolean bl) {
        startupManager.smRunning = bl;
        return startupManager.smRunning;
    }

    static /* synthetic */ void access$1000(StartupManager startupManager) {
        startupManager.fireInitialEvent();
    }

    static /* synthetic */ long access$1100(StartupManager startupManager) {
        return startupManager.startOfFramework;
    }

    static /* synthetic */ boolean access$1202(StartupManager startupManager, boolean bl) {
        startupManager.startupCompleted = bl;
        return startupManager.startupCompleted;
    }

    static /* synthetic */ HMIService access$1300(StartupManager startupManager) {
        return startupManager.hmiService;
    }

    static /* synthetic */ IJobFilter access$1400(StartupManager startupManager) {
        return startupManager.keyFilter;
    }

    static /* synthetic */ WatchDog access$1500(StartupManager startupManager) {
        return startupManager.hmiWatchDog;
    }

    static /* synthetic */ KeyEvent access$1600(StartupManager startupManager) {
        return startupManager.pressedEvent;
    }

    static /* synthetic */ LogChannel access$1700(StartupManager startupManager) {
        return startupManager.logChStartupEvent;
    }

    static /* synthetic */ KeyEvent access$1602(StartupManager startupManager, KeyEvent keyEvent) {
        startupManager.pressedEvent = keyEvent;
        return startupManager.pressedEvent;
    }

    static /* synthetic */ boolean access$1800(StartupManager startupManager) {
        return startupManager.forwardEvents();
    }

    static /* synthetic */ boolean access$1902(StartupManager startupManager, boolean bl) {
        startupManager.popupShown = bl;
        return startupManager.popupShown;
    }

    static /* synthetic */ boolean access$2000(StartupManager startupManager) {
        return startupManager.processHKs;
    }

    static /* synthetic */ void access$2400(StartupManager startupManager, PrintStream printStream) {
        startupManager.dumpMembers(printStream);
    }

    static /* synthetic */ DispatcherBase access$2500(StartupManager startupManager) {
        return startupManager.startupDispatcher;
    }

    static /* synthetic */ void access$2600(StartupManager startupManager, PrintStream printStream) {
        startupManager.dumpEvents(printStream);
    }

    static /* synthetic */ BundleContext access$2700(StartupManager startupManager) {
        return startupManager.bc;
    }

    static /* synthetic */ FwServices access$2800(StartupManager startupManager) {
        return startupManager.fwServices;
    }

    static {
        TIMEOUT_RVC_AVAILABLE = Long.getLong("WAIT_FOR_RVC_AVAILABLE", 0);
        TIMEOUT_POWERSTATE = Long.getLong("WAIT_FOR_FIRST_POWERSTATE", 0);
        TIMEOUT_MAP_AVAILABLE = Long.getLong("WAIT_FOR_MAP_AVAILABLE", 0);
        TIMEOUT_SDS_AVAILABLE = Long.getLong("WAIT_FOR_SDS_AVAILABLE", 0);
        TIMEOUT_MMIKOMBISYNC = Long.getLong("WAIT_FOR_FIRST_MMIKOMBISYNC", 0);
        TIMEOUT_FIRST_SCREEN_PAINTED = Long.getLong("WAIT_FOR_FIRST_SCREEN_PAINTED", 0);
        isSwDiagStarted = false;
    }
}

