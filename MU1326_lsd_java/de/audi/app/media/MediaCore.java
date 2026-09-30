/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.FactorySettingController;
import de.audi.app.media.MediaTerminal;
import de.audi.app.media.actionproxy.ActionProxyDispatcherImpl;
import de.audi.app.media.actionproxy.IActionProxyDispatcher;
import de.audi.app.media.configuration.MediaConfigurationImpl;
import de.audi.app.media.diagnosis.DiagnosisManagerImpl;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.diagnosis.MediaDiagnosisApplication;
import de.audi.app.media.dsi.media.EjectHandler;
import de.audi.app.media.dsi.media.MediaDSIBaseControllerImpl;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.logger.MediaLoggerImpl;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.ServiceManagerImpl;
import de.audi.app.media.persistence.MediaPersistenceImpl;
import de.audi.app.media.sds.SDSCommandDispatcherImpl;
import de.audi.app.media.source.state.SourceStateHandlerImpl;
import de.audi.app.media.source.state.providers.BluetoothSourceStateProvider;
import de.audi.app.media.source.state.providers.MediaListSourceStateProvider;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider;
import de.audi.app.media.source.state.providers.PowerEventSourceStateProvider;
import de.audi.app.media.source.state.providers.SDISConnectionStateProvider;
import de.audi.app.media.source.state.providers.TVSourceStateProvider;
import de.audi.app.media.source.state.providers.WLANSourceStateProvider;
import de.audi.atip.base.IDomainListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.job.JobLogger;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.StatisticInterceptor;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class MediaCore {
    private static final String LOGCLASS = "MediaCore";
    public static final int MEDIA_HMI_APPLICATION_ID = 2;
    private final IMediaLogger logger;
    private final IServiceManager serviceManager;
    private final IFrameworkAccess frameworkAccess;
    private final DiagnosisManagerImpl diagnosisManager;
    private final MediaDSIBaseControllerImpl mediaDSIBaseController;
    private final EjectHandler ejectHandler;
    private final ActionProxyDispatcherImpl actionProxyDispatcher;
    private final MediaPersistenceImpl mediaPersistence;
    private final FactorySettingController factorySettingController;
    private final MediaTerminal[] terminals = new MediaTerminal[8];
    private final MediaDiagnosisApplication mediaDiagApplication;
    private final DispatcherBase dispatcher;
    private final SDSCommandDispatcherImpl sdsCommandDispatcher;
    private final MediaListSourceStateProvider mediaListSourceStateProvider;
    private final BluetoothSourceStateProvider bluetoothSourceStateProvider;
    private final WLANSourceStateProvider wlanSourceStateProvider;
    private final PowerEventSourceStateProvider powerEventSourceStateProvider;
    private final OnlineServicesStateProvider onlineServicesStateProvider;
    private final TVSourceStateProvider tvSourceStateProvider;
    private final SDISConnectionStateProvider sdisConnectionStateProvider;
    private final IDomainListener domainStateListener;
    private ServiceRegistration domainStateListenerRegistration;
    static /* synthetic */ Class class$de$audi$atip$base$IDomainListener;

    public MediaCore(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        this.logger = new MediaLoggerImpl(0, iFrameworkAccess);
        this.logger.main().log(1000000, "[%1.<init>]", (Object)LOGCLASS);
        this.actionProxyDispatcher = new ActionProxyDispatcherImpl(iFrameworkAccess);
        this.serviceManager = new ServiceManagerImpl(bundleContext, iFrameworkAccess);
        this.frameworkAccess = iFrameworkAccess;
        this.sdsCommandDispatcher = new SDSCommandDispatcherImpl(this.logger.sds());
        this.diagnosisManager = new DiagnosisManagerImpl(this.logger.main());
        MediaConfigurationImpl mediaConfigurationImpl = new MediaConfigurationImpl(iFrameworkAccess, this.diagnosisManager);
        this.mediaPersistence = new MediaPersistenceImpl(this.logger, iFrameworkAccess.getStorageMgr(), this.actionProxyDispatcher);
        this.mediaPersistence.registerIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL", 0, 8, 0);
        this.mediaPersistence.registerStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD", "1234");
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("Media", new JobLogger(iFrameworkAccess.getLogChannel(new StringBuffer().append(this.logger.getLogPrefix()).append(".Dispatcher").toString())));
        this.dispatcher.addInterceptor(new StatisticInterceptor(this.dispatcher, new JobLogger(iFrameworkAccess.getLogChannel(new StringBuffer().append(this.logger.getLogPrefix()).append(".Dispatcher").toString())), 1000, 0));
        SourceStateHandlerImpl sourceStateHandlerImpl = new SourceStateHandlerImpl(this.logger.main(), this.dispatcher);
        int n = this.mediaPersistence.getGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL");
        this.mediaListSourceStateProvider = new MediaListSourceStateProvider(this.logger.main(), sourceStateHandlerImpl.getSourceStateUpdater(), this.mediaPersistence, this.diagnosisManager);
        this.mediaDSIBaseController = new MediaDSIBaseControllerImpl(0, this.serviceManager, iFrameworkAccess, this.dispatcher, this.diagnosisManager, this.logger.dsi(), n);
        this.ejectHandler = new EjectHandler(this.logger.main(), this.serviceManager, this.mediaDSIBaseController);
        this.bluetoothSourceStateProvider = new BluetoothSourceStateProvider(this.logger.main(), this.serviceManager, sourceStateHandlerImpl.getSourceStateUpdater(), this.diagnosisManager, this.dispatcher);
        this.wlanSourceStateProvider = new WLANSourceStateProvider(this.logger.main(), this.serviceManager, sourceStateHandlerImpl.getSourceStateUpdater(), this.diagnosisManager, this.dispatcher);
        this.powerEventSourceStateProvider = new PowerEventSourceStateProvider(this.logger.main(), this.serviceManager, sourceStateHandlerImpl.getSourceStateUpdater(), this.diagnosisManager, this.dispatcher);
        this.onlineServicesStateProvider = new OnlineServicesStateProvider(this.logger.main(), this.serviceManager, sourceStateHandlerImpl.getSourceStateUpdater(), this.dispatcher, this.diagnosisManager);
        this.tvSourceStateProvider = new TVSourceStateProvider(this.logger.main(), sourceStateHandlerImpl.getSourceStateUpdater(), this.serviceManager, this.dispatcher, this.diagnosisManager);
        this.sdisConnectionStateProvider = new SDISConnectionStateProvider(this.logger.main(), this.serviceManager, sourceStateHandlerImpl.getSourceStateUpdater(), this.diagnosisManager, this.dispatcher);
        if (iFrameworkAccess.isFrontMU()) {
            this.logger.main().log(1000000, "[%1.<init>] Create MAIN", (Object)LOGCLASS);
            this.terminals[0] = new MediaTerminal(0, this.mediaPersistence, iFrameworkAccess, this.serviceManager, this.mediaDSIBaseController, sourceStateHandlerImpl, sourceStateHandlerImpl, mediaConfigurationImpl, this.actionProxyDispatcher, this.dispatcher, this.diagnosisManager, this.sdsCommandDispatcher);
        } else {
            this.logger.main().log(1000000, "[%1.<init>] Create LEFT", (Object)LOGCLASS);
            this.terminals[3] = new MediaTerminal(3, this.mediaPersistence, iFrameworkAccess, this.serviceManager, this.mediaDSIBaseController, sourceStateHandlerImpl, sourceStateHandlerImpl, mediaConfigurationImpl, this.actionProxyDispatcher, this.dispatcher, this.diagnosisManager, this.sdsCommandDispatcher);
            this.logger.main().log(1000000, "[%1.<init>] Create RIGHT", (Object)LOGCLASS);
            this.terminals[4] = new MediaTerminal(4, this.mediaPersistence, iFrameworkAccess, this.serviceManager, this.mediaDSIBaseController, sourceStateHandlerImpl, sourceStateHandlerImpl, mediaConfigurationImpl, this.actionProxyDispatcher, this.dispatcher, this.diagnosisManager, this.sdsCommandDispatcher);
        }
        this.factorySettingController = new FactorySettingController(this.logger.main(), this.mediaDSIBaseController, this.serviceManager, mediaConfigurationImpl, this.terminals, this.dispatcher);
        this.mediaDiagApplication = new MediaDiagnosisApplication(this.logger, this.serviceManager, iFrameworkAccess, this.terminals, this.mediaDSIBaseController);
        if (this.frameworkAccess.isSimulator()) {
            this.logger.main().log(1000000, "[%1.<init>] Start DSI simulation", (Object)LOGCLASS);
            try {
                BundleActivator bundleActivator = (BundleActivator)Class.forName("de.audi.swdiagnosis.media.dsi.MediaDSISimulationActivator").newInstance();
                bundleActivator.start(bundleContext);
            }
            catch (Exception exception) {
                this.frameworkAccess.getStartupMgr().logStartupEvent(new StringBuffer().append("[MediaCore] Starting media simulation failed! ").append(exception.getMessage()).toString());
            }
        }
        this.domainStateListener = new IDomainListener(){

            public void updateDomainState(int n, int n2) {
                if (n != 3 && !MediaCore.this.frameworkAccess.isEvoHigh()) {
                    return;
                }
                int n3 = 0;
                if ((n2 & 0x400000) == 0x400000) {
                    n3 |= 1;
                }
                MediaCore.this.frameworkAccess.getHmiServiceApp().getChoiceModel(200571).setValue(n3);
            }

            public void muDomainIsAvailable(int n, int n2) {
            }
        };
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.mediaDSIBaseController.init();
        this.ejectHandler.init();
        this.mediaPersistence.init();
        this.mediaDSIBaseController.addMediaDeviceListener(this.mediaListSourceStateProvider);
        for (int i2 = 0; i2 < 8; ++i2) {
            if (this.terminals[i2] == null) continue;
            this.terminals[i2].init();
        }
        this.powerEventSourceStateProvider.init();
        this.bluetoothSourceStateProvider.init();
        this.wlanSourceStateProvider.init();
        this.onlineServicesStateProvider.init();
        this.tvSourceStateProvider.init();
        this.sdisConnectionStateProvider.init();
        this.mediaDSIBaseController.setFactorySettingListener(this.factorySettingController);
        this.factorySettingController.init();
        this.mediaDSIBaseController.startDSI();
        this.mediaDiagApplication.init();
        this.domainStateListenerRegistration = this.serviceManager.registerService(class$de$audi$atip$base$IDomainListener == null ? (class$de$audi$atip$base$IDomainListener = MediaCore.class$("de.audi.atip.base.IDomainListener")) : class$de$audi$atip$base$IDomainListener, this.domainStateListener, new Hashtable());
        this.diagnosisManager.addDataProvider(-1, new IDiagnosisDataProvider(){

            public String getDiagValue() {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                MediaCore.this.dispatcher.dump(new PrintStream(byteArrayOutputStream));
                return byteArrayOutputStream.toString();
            }

            public String getDiagKey() {
                return "Dispatcher";
            }
        });
        this.terminals[0].startup = false;
        this.logger.main().log(1000000, "[%1.init] Start media dispatcher processing.", (Object)LOGCLASS);
        this.dispatcher.start();
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.logger.main().log(1000000, "[%1.deinit] Stop media dispatcher processing.", (Object)LOGCLASS);
        this.dispatcher.stop();
        this.frameworkAccess.getDispatcherManager().destroyDispatcher(this.dispatcher.getDispatcherName());
        this.mediaPersistence.deinit();
        this.tvSourceStateProvider.deinit();
        this.onlineServicesStateProvider.deinit();
        this.powerEventSourceStateProvider.deinit();
        this.bluetoothSourceStateProvider.deinit();
        this.wlanSourceStateProvider.deinit();
        this.sdisConnectionStateProvider.deinit();
        this.ejectHandler.deinit();
        if (null != this.domainStateListenerRegistration) {
            this.serviceManager.unregisterService(this.domainStateListenerRegistration);
            this.domainStateListenerRegistration = null;
        }
        this.sdsCommandDispatcher.deinit();
        this.mediaDiagApplication.deinit();
        this.factorySettingController.deinit();
        for (int i2 = 0; i2 < 8; ++i2) {
            if (this.terminals[i2] == null) continue;
            this.terminals[i2].deinit();
            this.terminals[i2] = null;
        }
        this.mediaDSIBaseController.deinit();
    }

    public IActionProxyDispatcher getActionProxyDispatcher() {
        return this.actionProxyDispatcher;
    }

    public IServiceManager getServiceManager() {
        return this.serviceManager;
    }

    public IMediaLogger getLogger() {
        return this.logger;
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

