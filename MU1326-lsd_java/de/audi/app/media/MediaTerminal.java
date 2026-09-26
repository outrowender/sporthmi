/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.media.MediaDiagnosis
 */
package de.audi.app.media;

import de.audi.app.media.HardKeyListener;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.IResetSettingsListener;
import de.audi.app.media.ITitlelineHMIHandler;
import de.audi.app.media.TitlelineHMIHandler;
import de.audi.app.media.actionproxy.IActionProxyDispatcher;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.audio.AudioManager;
import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.configuration.IMediaConfiguration;
import de.audi.app.media.content.ContentManager;
import de.audi.app.media.content.IContentManager;
import de.audi.app.media.content.media.fileplayer.FilePlayerController;
import de.audi.app.media.content.media.online.OnlinePlayerController;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.MediaDSIPlayerControllerImpl;
import de.audi.app.media.extension.MediaTerminalExtensionTracker;
import de.audi.app.media.interapp.MediaServiceImpl;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.logger.MediaLoggerImpl;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.persistence.IMediaPersistence;
import de.audi.app.media.sds.ISDSCommandDistpacher;
import de.audi.app.media.sds.SDSController;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceResolver;
import de.audi.app.media.source.SourceController;
import de.audi.app.media.source.state.ISourceStateHandler;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.mib.swdiagnosis.media.MediaDiagnosis;
import java.util.Iterator;
import java.util.Map;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MediaTerminal
implements IActionProxyListener,
IMediaTerminal,
ServiceTrackerCustomizer {
    private static final String LOGCLASS;
    private final IMediaPersistence mediaPersistence;
    private final int terminalID;
    private final IMediaLogger logger;
    private final AudioManager audioMgr;
    private final IDiagnosisManager diagnosisManager;
    private final ContentManager contentMgr;
    private final SourceController sourceController;
    private final FilePlayerController filePlayerController;
    private final OnlinePlayerController onlinePlayerController;
    private final IServiceManager serviceManager;
    private final IFrameworkAccess framework;
    private final IMediaConfiguration configuration;
    private final ISDSCommandDistpacher sdsDispatcher;
    private final SDSController sdsController;
    private final IMediaDSIPlayerController mediaDSIPlayerController;
    private final HardKeyListener hardKeyListener;
    private final IActionProxyDispatcher actionProxyDispatcher;
    private final MediaServiceImpl mediaService;
    private final DispatcherBase dispatcher;
    private final TitlelineHMIHandler titlelineHMIHandler;
    private final MediaTerminalExtensionTracker extensionTracker;
    private final IServiceTracker swDiagManagerTracker;
    private final ISourceResolver sourceResolver;
    private final IMediaDSIBaseController dsiBaseController;
    private volatile boolean visible;
    private final CopyOnWriteArrayList resetSettingsListeners = new CopyOnWriteArrayList();
    private final SelectionBrowser selectionBrowser;
    MediaDiagnosis diag;
    boolean startup = true;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;

    public MediaTerminal(int n, IMediaPersistence iMediaPersistence, IFrameworkAccess iFrameworkAccess, IServiceManager iServiceManager, IMediaDSIBaseController iMediaDSIBaseController, ISourceStateHandler iSourceStateHandler, ISourceResolver iSourceResolver, IMediaConfiguration iMediaConfiguration, IActionProxyDispatcher iActionProxyDispatcher, DispatcherBase dispatcherBase, IDiagnosisManager iDiagnosisManager, ISDSCommandDistpacher iSDSCommandDistpacher) {
        this.terminalID = n;
        this.logger = new MediaLoggerImpl(n, iFrameworkAccess);
        this.serviceManager = iServiceManager;
        this.configuration = iMediaConfiguration;
        this.framework = iFrameworkAccess;
        this.diagnosisManager = iDiagnosisManager;
        this.mediaPersistence = iMediaPersistence;
        this.dispatcher = dispatcherBase;
        this.actionProxyDispatcher = iActionProxyDispatcher;
        this.sdsDispatcher = iSDSCommandDistpacher;
        this.sourceResolver = iSourceResolver;
        this.sdsController = new SDSController(this);
        this.hardKeyListener = new HardKeyListener(this);
        this.titlelineHMIHandler = new TitlelineHMIHandler(this);
        this.dsiBaseController = iMediaDSIBaseController;
        int n2 = this.terminalID == 4 ? 1 : 0;
        this.mediaDSIPlayerController = new MediaDSIPlayerControllerImpl(n2, this.serviceManager, iFrameworkAccess, this.dispatcher, iSourceResolver, this.logger.dsi());
        this.audioMgr = new AudioManager(this);
        this.extensionTracker = new MediaTerminalExtensionTracker(this, this.serviceManager);
        this.sourceController = new SourceController(this, iSourceStateHandler, this.mediaDSIPlayerController);
        this.mediaDSIPlayerController.setSourceActivationListener(this.sourceController);
        this.contentMgr = new ContentManager(this, this.mediaDSIPlayerController, this.extensionTracker);
        this.mediaService = new MediaServiceImpl(this);
        this.filePlayerController = new FilePlayerController(this.logger.main(), this.sourceController, this.contentMgr, this.serviceManager, this.diagnosisManager, this.audioMgr, this.dispatcher);
        this.onlinePlayerController = new OnlinePlayerController(this.logger.main(), this.sourceController, this.contentMgr, this.serviceManager, this.diagnosisManager, this.dispatcher);
        this.swDiagManagerTracker = this.serviceManager.createServiceTracker(class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = MediaTerminal.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager, this);
        this.selectionBrowser = new SelectionBrowser(this);
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"MediaTerminal");
        this.mediaDSIPlayerController.init();
        this.mediaDSIPlayerController.startDSI();
        this.titlelineHMIHandler.init();
        this.audioMgr.init();
        this.selectionBrowser.init();
        this.contentMgr.init();
        this.contentMgr.addContentListener(this.sourceController);
        this.sourceController.init();
        this.hardKeyListener.init();
        this.sdsController.init();
        this.visible = false;
        this.addActionProxyListener(new int[]{1001, 1002, 1003}, (IActionProxyListener)this);
        this.mediaService.init();
        this.filePlayerController.init();
        this.onlinePlayerController.init();
        this.extensionTracker.init();
        this.swDiagManagerTracker.open();
        this.sourceController.restoreLastModeSource();
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"MediaTerminal");
        this.swDiagManagerTracker.close();
        this.extensionTracker.deinit();
        this.sdsController.deinit();
        this.filePlayerController.deinit();
        this.onlinePlayerController.deinit();
        this.mediaService.deinit();
        this.mediaDSIPlayerController.deinit();
        this.audioMgr.deinit();
        this.titlelineHMIHandler.deinit();
        this.selectionBrowser.deinit();
        this.contentMgr.deinit();
        this.sourceController.deinit();
        this.hardKeyListener.deinit();
        this.resetSettingsListeners.clear();
    }

    @Override
    public ISDSCommandDistpacher getSDSDispatcher() {
        return this.sdsDispatcher;
    }

    @Override
    public int getTerminalID() {
        return this.terminalID;
    }

    @Override
    public boolean supportsCombiDisplay() {
        return this.terminalID == 0;
    }

    @Override
    public IServiceManager getServiceManager() {
        return this.serviceManager;
    }

    @Override
    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    @Override
    public IMediaLogger getLogger() {
        return this.logger;
    }

    @Override
    public IMediaConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override
    public IMediaPersistence getMediaPersistence() {
        return this.mediaPersistence;
    }

    @Override
    public IAudioManager getAudioManager() {
        return this.audioMgr;
    }

    @Override
    public IContentManager getContentManager() {
        return this.contentMgr;
    }

    @Override
    public DispatcherBase getDispatcher() {
        return this.dispatcher;
    }

    @Override
    public IDiagnosisManager getDiagnosisManager() {
        return this.diagnosisManager;
    }

    @Override
    public ITitlelineHMIHandler getTitlelineHMIHandler() {
        return this.titlelineHMIHandler;
    }

    @Override
    public ISourceController getSourceController() {
        return this.sourceController;
    }

    @Override
    public ISourceResolver getSourceResolver() {
        return this.sourceResolver;
    }

    @Override
    public IMediaDSIBaseController getDSIBaseController() {
        return this.dsiBaseController;
    }

    @Override
    public void addActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
        this.actionProxyDispatcher.addActionProxyListener(n, this.getTerminalID(), iActionProxyListener);
    }

    @Override
    public void addActionProxyListener(int[] nArray, IActionProxyListener iActionProxyListener) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.actionProxyDispatcher.addActionProxyListener(nArray[i2], this.getTerminalID(), iActionProxyListener);
        }
    }

    @Override
    public void removeActionProxyListener(IActionProxyListener iActionProxyListener) {
        this.actionProxyDispatcher.removeActionProxyListener(this.getTerminalID(), iActionProxyListener);
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    private void setVisible(boolean bl) {
        this.visible = bl;
    }

    @Override
    public boolean isRearSeatTerminal() {
        return this.terminalID == 5 || this.terminalID == 4 || this.terminalID == 3;
    }

    @Override
    public boolean isFrontTerminal() {
        return !this.isRearSeatTerminal();
    }

    public String toString() {
        switch (this.terminalID) {
            case 3: {
                return "REAR_LEFT";
            }
            case 4: {
                return "REAR_RIGHT";
            }
        }
        return "MAIN";
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 1001: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_HMI_ACTIVATED.", (Object)"MediaTerminal");
                this.setVisible(true);
                break;
            }
            case 1002: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_HMI_DEACTIVATED", (Object)"MediaTerminal");
                this.setVisible(false);
                break;
            }
            case 1003: {
                this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_RELEASE_AUDIO.", (Object)"MediaTerminal");
                if (this.getSourceController().isSelectedSource(this.getSourceController().getSource(4))) {
                    this.logger.main().log(1078071040, "[%1.actionProxyCallPerformed] FilePlayer is active", (Object)"MediaTerminal");
                    return;
                }
                this.getAudioManager().releaseAudio();
                break;
            }
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.logger.main().log(1078071040, "[%1.addingService] SwDiagnosisManager found.", (Object)"MediaTerminal");
        SwDiagnosisManager swDiagnosisManager = (SwDiagnosisManager)this.serviceManager.getService(serviceReference);
        this.diag = new MediaDiagnosis((IMediaTerminal)this);
        this.diag.init();
        swDiagnosisManager.addDiagGateway((AbstractSwDiagnosis)this.diag);
        return swDiagnosisManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        ((SwDiagnosisManager)object).removeDiagGateway((AbstractSwDiagnosis)this.diag);
        this.diag.deinit();
        this.serviceManager.releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void resetSettings(int n) {
        this.logger.main().log(1078071040, "[%1.resetSettings] '%2'.", (Object)"MediaTerminal");
        Iterator iterator = this.resetSettingsListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IResetSettingsListener)iterator.next()).onResetSettings(n);
            }
            catch (Exception exception) {
                this.logger.main().log(-1601830656, "[%1.resetSettings] %2", (Object)"MediaTerminal", (Throwable)exception);
            }
        }
    }

    @Override
    public void addResetSettingsListener(IResetSettingsListener iResetSettingsListener) {
        if (iResetSettingsListener == null) {
            throw new IllegalArgumentException();
        }
        this.resetSettingsListeners.addIfAbsent(iResetSettingsListener);
    }

    @Override
    public SelectionBrowser getSelectionBrowser() {
        return this.selectionBrowser;
    }

    @Override
    public boolean isStartup() {
        return this.startup;
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

