/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.bulkcopy.BulkCopyActivator;
import de.audi.atip.bulkcopy.BulkCopyManagerImpl;
import de.audi.atip.displaymanager.DisplayManagerServiceImpl;
import de.audi.atip.error.ErrorActivator;
import de.audi.atip.error.ErrorManager;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.irc.InfotainmentRecorder;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.log.NullLogChannel;
import de.audi.atip.log.NullLogServImpl;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.onlinelogo.OnlineLogoActivator;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.startup.DomainActivator;
import de.audi.atip.startup.DomainHandler;
import de.audi.atip.startup.DomainHandlerMU;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.statemachine.SMInterpreter;
import de.audi.atip.storagecache.CacheHandler;
import de.audi.atip.swap.SWaPHandler;
import de.audi.atip.sysapp.SysApp;
import de.audi.atip.sysapp.SysAppActivator;
import de.audi.atip.watchdog.HMIWatchDog;
import de.audi.atip.watchdog.HMIWatchDogActivator;
import de.audi.tghu.diag.DiagnosisActivator;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRendererActivator;
import de.audi.tghu.irc.IrcActivator;
import de.audi.tghu.jdsi.JDSIActivator;
import de.audi.tghu.jdsi.JDSIManager;
import de.audi.tghu.lang.LanguageActivator;
import de.audi.tghu.lang.LanguageManager;
import de.audi.tghu.log.LogActivator;
import de.audi.tghu.log.LogExtractorFactory;
import de.audi.tghu.msg.MessageDistributorActivator;
import de.audi.tghu.msg.MessageDistributorImpl;
import de.audi.tghu.picturestore.PictureStoreProxy;
import de.audi.tghu.picturestore.PictureStoreProxyActivator;
import de.audi.tghu.power.PowerActivator;
import de.audi.tghu.smi.SMI;
import de.audi.tghu.smi.SMIActivator;
import de.audi.tghu.storage.StorageAccess;
import de.audi.tghu.storage.StorageActivator;
import de.audi.tghu.storagecache.CacheActivator;
import de.audi.tghu.swap.SWaPHandlerActivator;
import de.audi.tghu.waveplayer.WavePlayerActivator;
import de.audi.tghu.waveplayer.WavePlayerImpl;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.SystemTimeSource;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class FwServices {
    private final IFrameworkAccess framework;
    private LogChannel log = NullLogChannel.getInstance();
    private BundleContext context;
    private final ITimeSource systemTimeSource;
    private final ITimeSource monotonicTimeSource;
    private MessageDistributorActivator messageDistributorActivator;
    private MessageDistributorImpl messageDistributor;
    private StartupManager startupManager;
    private LogChannelFactory logChannelFactory;
    private LogActivator logActivator;
    private ErrorManager errorManager;
    private ErrorActivator errorActivator;
    private SysApp sysApp;
    private SysAppActivator sysAppActivator;
    private JDSIManager jdsiManager;
    private JDSIActivator jdsiActivator;
    private PowerActivator powerActivator;
    private IPowerManager powerManager;
    private StorageActivator storageActivator;
    private DomainActivator domainActivator;
    private DomainHandler domainHandler;
    private DomainHandlerMU domainHandlerMU;
    private HMIService hmiService;
    private LanguageActivator languageActivator;
    private LanguageManager languageManager;
    private IconRendererActivator iconRendererActivator;
    private IconRenderer iconRenderer;
    private PictureStoreProxyActivator pictureStoreProxyActivator;
    private PictureStoreProxy pictureStoreProxy;
    private DiagnosisActivator diagnosisActivator;
    private IrcActivator ircActivator;
    private InfotainmentRecorder infortainmentRecorder;
    private WavePlayerActivator wavePlayerActivator;
    private WavePlayerImpl wavePlayer;
    private SMIActivator smiActivator;
    private SMI smInterpreter;
    private HMIWatchDogActivator hmiWatchDogActivator;
    private HMIWatchDog hmiWatchDog;
    private CacheActivator cacheActivator;
    private CacheHandler cacheHandler;
    private SWaPHandlerActivator swapHandlerActivator;
    private SWaPHandler swapHandler;
    private BulkCopyActivator bulkCopyActivator;
    private BulkCopyManagerImpl bulkCopyManager;
    private OnlineLogoActivator onlineLogoActivator;
    private DisplayManagerServiceImpl displayManagerService;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$timeout$ITimeSource;

    public FwServices(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.systemTimeSource = new SystemTimeSource();
        this.monotonicTimeSource = this.initMonotonicTimeSource();
        LogExtractorFactory.getInstance().initFramework(iFrameworkAccess);
    }

    private ITimeSource initMonotonicTimeSource() {
        ITimeSource iTimeSource = null;
        ServiceReference serviceReference = this.framework.getBundleCxt().getServiceReference((class$de$esolutions$fw$util$commons$timeout$ITimeSource == null ? (class$de$esolutions$fw$util$commons$timeout$ITimeSource = FwServices.class$("de.esolutions.fw.util.commons.timeout.ITimeSource")) : class$de$esolutions$fw$util$commons$timeout$ITimeSource).getName());
        if (serviceReference != null) {
            iTimeSource = (ITimeSource)this.framework.getBundleCxt().getService(serviceReference);
        }
        if (iTimeSource == null) {
            iTimeSource = new SystemTimeSource();
        }
        return iTimeSource;
    }

    public void initBundleContext(BundleContext bundleContext) {
        this.context = bundleContext;
    }

    void setLog(LogChannel logChannel) {
        this.log = logChannel;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public void initModels() {
        if (this.sysAppActivator != null) {
            this.sysAppActivator.initModels();
        } else {
            this.log.log(1000, "Access to SysAppActivator before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        if (this.getLanguageManager() != null) {
            this.getLanguageManager().init(this.framework.getStartupMgr().isRebootToDownload());
        }
    }

    public void fullStart() {
        this.createBulkCopyManager();
        this.createPictureStoreProxy();
        this.createDiagnosisApp();
        this.createOnlineLogoActivator();
    }

    void createErrorManager() {
        try {
            if (this.errorActivator == null) {
                this.errorActivator = new ErrorActivator();
                this.errorActivator.start(this.context);
            }
            this.errorManager = this.errorActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of ErrorManager failed!", (Throwable)exception);
        }
    }

    ErrorManager getErrorManager() {
        if (this.errorManager == null) {
            this.log.log(1000, "Access to ErrorManager before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.errorManager;
    }

    public void createDomainActivator() {
        if (this.domainActivator == null) {
            this.domainActivator = new DomainActivator(this);
            this.domainActivator.start(this.context);
        }
        this.getDomainHandler().waitForDSIStartup();
    }

    public DomainActivator getDomainActivator() {
        if (this.domainActivator == null) {
            this.log.log(1000, "Access to DomainActivator before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.domainActivator;
    }

    public void createDomainHandler() {
        if (this.domainHandler == null) {
            this.domainHandler = new DomainHandler(this.framework);
        } else {
            this.log.log(10000, "DomainHandler is already created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
    }

    public void createDomainHandlerMU() {
        if (this.domainHandlerMU == null) {
            this.domainHandlerMU = new DomainHandlerMU(this.framework.getLogChannel("Fw.Domain"));
            this.getDomainHandler().setDomainHandlerMU(this.domainHandlerMU);
        } else {
            this.log.log(10000, "DomainHandlerMU is already created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
    }

    public DomainHandler getDomainHandler() {
        if (this.domainHandler == null) {
            this.log.log(10000, "Access to DomainHandler before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.domainHandler;
    }

    public DomainHandlerMU getDomainHandlerMU() {
        if (this.domainHandlerMU == null) {
            this.log.log(10000, "Access to DomainHandlerMU before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.domainHandlerMU;
    }

    public void createPowerManager() {
        try {
            if (this.powerActivator == null) {
                this.powerActivator = new PowerActivator(this);
                this.powerActivator.start(this.context);
            }
            this.powerManager = this.powerActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of PowerManager failed!", (Throwable)exception);
        }
    }

    public IPowerManager getPowerManager() {
        if (this.powerManager == null) {
            this.log.log(1000, "Access to PowerManager before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.powerManager;
    }

    public void createJDSIAdmin() {
        try {
            if (this.jdsiActivator == null) {
                this.jdsiActivator = new JDSIActivator();
                this.jdsiActivator.start(this.context);
            }
            this.jdsiManager = this.jdsiActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of JDSIAdmin failed!", (Throwable)exception);
        }
    }

    public JDSIManager getJDSIAdmin() {
        if (this.jdsiManager == null) {
            this.log.log(1000, "Access to JDSIManager before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.jdsiManager;
    }

    void createLogChannelFactory() {
        try {
            if (this.logActivator == null) {
                this.logActivator = new LogActivator();
                this.logActivator.start(this.context);
                AbstractModelBank.initLogging(this.logActivator.getLogService());
            }
            this.logChannelFactory = this.logActivator.getLogService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of LoggingService failed!", (Throwable)exception);
        }
    }

    public LogChannelFactory getLogChannelFactory() {
        if (this.logChannelFactory == null) {
            this.log.log(1000, "Access to LogChannelFactory before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
            return NullLogServImpl.getInstance();
        }
        return this.logChannelFactory;
    }

    void createSysApp() {
        try {
            if (this.sysAppActivator == null) {
                this.sysAppActivator = new SysAppActivator(this);
                this.sysAppActivator.start(this.context);
            }
            this.sysApp = this.sysAppActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of SysApp failed!", (Throwable)exception);
        }
    }

    public SysApp getSysApp() {
        if (this.sysApp == null) {
            this.log.log(1000, "Access to SysApp before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.sysApp;
    }

    public void createLanguageManager() {
        try {
            if (this.languageActivator == null) {
                this.languageActivator = new LanguageActivator();
                this.languageActivator.start(this.context);
            }
            this.languageManager = this.languageActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of LanguageManager failed!", (Throwable)exception);
        }
    }

    public LanguageManager getLanguageManager() {
        if (this.languageManager == null) {
            this.log.log(1000, "Access to LanguageManager before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.languageManager;
    }

    public void createStorageManager() {
        try {
            if (this.storageActivator == null) {
                this.storageActivator = new StorageActivator(this);
                this.storageActivator.start(this.context);
            }
            this.storageActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of StorageManager failed!", (Throwable)exception);
        }
    }

    public StorageAccess getStorageManager() {
        if (this.storageActivator.getService() == null) {
            this.log.log(1000, "Access to StorageManager before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.storageActivator.getService();
    }

    public void flushStorage() {
        if (this.storageActivator == null) {
            this.log.log(1000, "Access to StorageActivator before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        } else {
            this.storageActivator.flush();
        }
    }

    public StartupManager getStartupManager() {
        try {
            if (this.startupManager == null) {
                this.startupManager = new StartupManager(this);
            }
            return this.startupManager;
        }
        catch (Exception exception) {
            this.log.log(1000, "StartupManager failed!", (Throwable)exception);
            return null;
        }
    }

    public void createIconRenderer() {
        try {
            if (this.iconRendererActivator == null) {
                this.iconRendererActivator = new IconRendererActivator();
                this.iconRendererActivator.start(this.context);
            }
            this.iconRenderer = this.iconRendererActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of IconRenderer failed!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
    }

    public IconRenderer getIconRenderer() {
        if (this.iconRenderer == null) {
            this.log.log(1000, "Access to IconRenderer before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.iconRenderer;
    }

    void createPictureStoreProxy() {
        try {
            if (this.pictureStoreProxyActivator == null) {
                this.pictureStoreProxyActivator = new PictureStoreProxyActivator();
                this.pictureStoreProxyActivator.start(this.context);
            }
            this.pictureStoreProxy = this.pictureStoreProxyActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of PictureStoreProxy failed!", (Throwable)exception);
        }
    }

    void createDiagnosisApp() {
        try {
            if (this.diagnosisActivator == null) {
                this.diagnosisActivator = new DiagnosisActivator();
                this.diagnosisActivator.start(this.context);
            }
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of DiagnosisApp failed!", (Throwable)exception);
        }
    }

    public void createInfotainmentRecorder() {
        try {
            if (this.ircActivator == null) {
                this.ircActivator = new IrcActivator();
                this.ircActivator.start(this.context);
            }
            this.infortainmentRecorder = this.ircActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of InfotainmentRecorder failed!", (Throwable)exception);
        }
    }

    public InfotainmentRecorder getInfotainmentrecorder() {
        if (this.infortainmentRecorder == null) {
            this.log.log(1000, "Access to InfortainmentRecorder before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.infortainmentRecorder;
    }

    public void setHMIService(HMIService hMIService) {
        this.hmiService = hMIService;
    }

    public HMIService getHMIService() {
        if (this.hmiService == null) {
            this.log.log(100000, "Access to HMIService before it was created!");
        }
        return this.hmiService;
    }

    public boolean checkHMIService() {
        return this.hmiService != null;
    }

    public void createWavePlayer() {
        try {
            if (this.wavePlayerActivator == null) {
                this.wavePlayerActivator = new WavePlayerActivator();
                this.wavePlayerActivator.start(this.context);
            }
            this.wavePlayer = this.wavePlayerActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of WavePlayer failed!", (Throwable)exception);
        }
    }

    public WavePlayerImpl getWavePlayer() {
        if (this.wavePlayer == null) {
            this.log.log(1000, "Access to WavePlayer before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.wavePlayer;
    }

    public void createMsgDistrib() {
        try {
            if (this.messageDistributorActivator == null) {
                this.messageDistributorActivator = new MessageDistributorActivator();
                this.messageDistributorActivator.start(this.context);
            }
            this.messageDistributor = this.messageDistributorActivator.getService();
        }
        catch (Exception exception) {
            this.getErrorManager().handleError(exception, "MessageDistributorActivator failed!", 0, 3, 1);
        }
    }

    public MsgDistributor getMsgDistrib() {
        if (this.messageDistributor == null) {
            this.log.log(1000, "Access to MsgDistributor before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.messageDistributor;
    }

    void createBulkCopyManager() {
        try {
            if (this.bulkCopyActivator == null) {
                this.bulkCopyActivator = new BulkCopyActivator();
                this.bulkCopyActivator.start(this.context);
            }
            this.bulkCopyManager = this.bulkCopyActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of BulkCopyManager failed!", (Throwable)exception);
        }
    }

    public BulkCopyManagerImpl getBulkCopyManager() {
        if (this.bulkCopyManager == null) {
            this.log.log(1000, "Access to BulkCopyManager before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.bulkCopyManager;
    }

    public void createSMInterpreter() {
        try {
            if (this.smiActivator == null) {
                this.smiActivator = new SMIActivator();
                this.smiActivator.start(this.context);
            }
            this.smInterpreter = this.smiActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of SMInterpreter failed!", (Throwable)exception);
        }
    }

    public SMInterpreter getSMInterpreter() {
        if (this.smInterpreter == null) {
            this.log.log(1000, "Access to SMInterpreter before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.smInterpreter;
    }

    public void createHMIWatchDog() {
        try {
            if (this.hmiWatchDogActivator == null) {
                this.hmiWatchDogActivator = new HMIWatchDogActivator();
                this.hmiWatchDogActivator.start(this.context);
            }
            this.hmiWatchDog = this.hmiWatchDogActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of HMIWatchDogActivator() failed!", (Throwable)exception);
        }
    }

    public HMIWatchDog getHMIWatchDog() {
        if (this.hmiWatchDog == null) {
            this.log.log(1000, "Access to HMIWatchDog before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.hmiWatchDog;
    }

    public ITimeSource getSystemTimeSource() {
        return this.systemTimeSource;
    }

    public ITimeSource getMonotonicTimeSource() {
        return this.monotonicTimeSource;
    }

    public void createOnlineLogoActivator() {
        try {
            if (this.onlineLogoActivator == null) {
                this.onlineLogoActivator = new OnlineLogoActivator(this.framework);
                this.onlineLogoActivator.start(this.context);
            }
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of OnlineLogoProvider failed!", (Throwable)exception);
        }
    }

    public OnlineLogoActivator getOnlineLogoActivator() {
        if (this.onlineLogoActivator == null) {
            this.log.log(1000, "Access to OnlineLogoActivator before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.onlineLogoActivator;
    }

    public void createDisplayManagerService() {
        try {
            if (this.displayManagerService == null) {
                this.displayManagerService = new DisplayManagerServiceImpl(this.framework, this.context);
                this.displayManagerService.init();
            }
        }
        catch (Exception exception) {
            this.log.log(1000, "Creating of DisplayManagerService failed!", (Throwable)exception);
        }
    }

    public void createSWaPHandler() {
        try {
            if (this.swapHandlerActivator == null) {
                this.swapHandlerActivator = new SWaPHandlerActivator(this);
                this.swapHandlerActivator.start(this.context);
            }
            this.swapHandler = this.swapHandlerActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of SWaPHandlerActivator() failed!", (Throwable)exception);
        }
    }

    public SWaPHandler getSWaPHandler() {
        if (this.swapHandler == null) {
            this.log.log(1000, "Access to SWaPHandler before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.swapHandler;
    }

    public void createCacheHandler() {
        try {
            if (this.cacheActivator == null) {
                this.cacheActivator = new CacheActivator(this);
                this.cacheActivator.start(this.context);
            }
            this.cacheHandler = this.cacheActivator.getService();
        }
        catch (Exception exception) {
            this.log.log(1000, "Activator of CacheActivator() failed!", (Throwable)exception);
        }
    }

    public CacheHandler getCacheHandler() {
        if (this.cacheHandler == null) {
            this.log.log(1000, "Access to CacheHandler before it was created!", (Throwable)new FrameworkException("Startup sequence violation!"));
        }
        return this.cacheHandler;
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

