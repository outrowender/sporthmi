/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.AudioFocusSyncer;
import de.audi.app.media.evo.GracenoteManager;
import de.audi.app.media.evo.MediaOnlineDrawerContextHandler;
import de.audi.app.media.evo.ParentalManagementController;
import de.audi.app.media.evo.content.ImplicitRepeatHandler;
import de.audi.app.media.evo.content.MediaEVOContentProviderImpl;
import de.audi.app.media.evo.content.data.favorites.FavoritesController;
import de.audi.app.media.evo.presets.MediaPresetHandler;
import de.audi.app.media.evo.source.SourceActivationEvoExtension;
import de.audi.app.media.evo.source.SourceHMIHandler;
import de.audi.app.media.evo.source.SourceListHMIHandler;
import de.audi.app.media.evo.source.ToggleSourceHandler;
import de.audi.app.media.extension.IContentProvider;
import de.audi.app.media.extension.IMediaTerminalExtension;
import de.audi.app.media.hmi.MediaVersionInfoHandler;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceManager;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class MediaEVOTerminalExtensionImpl
implements IMediaTerminalExtension {
    private static final String LOGCLASS;
    private final int terminalID;
    private final IMediaLogger logger;
    private final IServiceManager serviceManager;
    private final MediaEVOContentProviderImpl contentProvider;
    private volatile SourceListHMIHandler sourceListHandler;
    private volatile ServiceRegistration serviceRegistration;
    private volatile ToggleSourceHandler sourceToggleHandler;
    private volatile ParentalManagementController parentalManagementSettings;
    private volatile MediaPresetHandler mediaPresetHandler;
    private volatile SourceHMIHandler sourceHMIHandler;
    private volatile MediaVersionInfoHandler versionInfoHandler;
    private volatile GracenoteManager gracenoteManager;
    private volatile ImplicitRepeatHandler implicitRepeatHandler;
    private volatile FavoritesController favoritesController;
    private volatile AudioFocusSyncer audioFocusSyncer;
    private volatile MediaOnlineDrawerContextHandler mediaOnlineDrawerContextHandler;
    static /* synthetic */ Class class$de$audi$app$media$extension$IMediaTerminalExtension;

    public MediaEVOTerminalExtensionImpl(int n, IMediaLogger iMediaLogger, IServiceManager iServiceManager) {
        this.terminalID = n;
        this.serviceManager = iServiceManager;
        this.logger = iMediaLogger;
        this.contentProvider = new MediaEVOContentProviderImpl(iMediaLogger);
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"MediaEVOTerminalExtensionImpl");
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("TERMINALID", new Integer(this.terminalID));
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$app$media$extension$IMediaTerminalExtension == null ? (class$de$audi$app$media$extension$IMediaTerminalExtension = MediaEVOTerminalExtensionImpl.class$("de.audi.app.media.extension.IMediaTerminalExtension")) : class$de$audi$app$media$extension$IMediaTerminalExtension, this, hashtable);
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"MediaEVOTerminalExtensionImpl");
        this.serviceRegistration.unregister();
    }

    @Override
    public void initExtension(IMediaTerminal iMediaTerminal) {
        iMediaTerminal.getLogger().main().log(1078071040, "[%1.initExtension]", (Object)"MediaEVOTerminalExtensionImpl");
        iMediaTerminal.getSourceController().setAutomaticSourceChange(new int[]{5, 9, 2, 0, 3, 1});
        this.sourceListHandler = new SourceListHMIHandler(iMediaTerminal);
        this.sourceListHandler.init();
        this.sourceHMIHandler = new SourceHMIHandler(iMediaTerminal);
        this.sourceHMIHandler.init();
        this.sourceToggleHandler = new ToggleSourceHandler(iMediaTerminal);
        this.sourceToggleHandler.init();
        this.parentalManagementSettings = new ParentalManagementController(iMediaTerminal);
        this.parentalManagementSettings.init();
        this.audioFocusSyncer = new AudioFocusSyncer(iMediaTerminal);
        this.audioFocusSyncer.init();
        this.implicitRepeatHandler = new ImplicitRepeatHandler(iMediaTerminal);
        this.implicitRepeatHandler.init();
        this.favoritesController = new FavoritesController(iMediaTerminal);
        this.favoritesController.init();
        this.mediaPresetHandler = new MediaPresetHandler(iMediaTerminal, this.favoritesController);
        this.mediaPresetHandler.init();
        if (iMediaTerminal.getConfiguration().isGracenoteOnlineAvailable()) {
            this.gracenoteManager = new GracenoteManager(iMediaTerminal);
            this.gracenoteManager.init();
        }
        this.mediaOnlineDrawerContextHandler = new MediaOnlineDrawerContextHandler(iMediaTerminal);
        this.mediaOnlineDrawerContextHandler.init();
        this.contentProvider.setFavoritesController(this.favoritesController);
        this.versionInfoHandler = new MediaVersionInfoHandler(iMediaTerminal);
        this.versionInfoHandler.init();
        this.contentProvider.setImplicitRepeatHandler(this.implicitRepeatHandler);
        iMediaTerminal.getSourceController().setSourceActivationExtension(new SourceActivationEvoExtension(iMediaTerminal));
    }

    @Override
    public void deinitExtension() {
        if (this.sourceListHandler != null) {
            this.sourceListHandler.deinit();
        }
        if (null != this.sourceToggleHandler) {
            this.sourceToggleHandler.deinit();
        }
        if (this.parentalManagementSettings != null) {
            this.parentalManagementSettings.deinit();
        }
        if (null != this.mediaPresetHandler) {
            this.mediaPresetHandler.deinit();
        }
        if (null != this.favoritesController) {
            this.favoritesController.deinit();
        }
        if (null != this.sourceHMIHandler) {
            this.sourceHMIHandler.deinit();
        }
        if (null != this.versionInfoHandler) {
            this.versionInfoHandler.deinit();
        }
        if (null != this.gracenoteManager) {
            this.gracenoteManager.deinit();
        }
        if (null != this.implicitRepeatHandler) {
            this.implicitRepeatHandler.deinit();
        }
        if (null != this.audioFocusSyncer) {
            this.audioFocusSyncer.deinit();
        }
        if (null != this.mediaOnlineDrawerContextHandler) {
            this.mediaOnlineDrawerContextHandler.deinit();
        }
    }

    @Override
    public IContentProvider getContentProvider() {
        return this.contentProvider;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("MediaEVOTerminalExtensionImpl").append("@").append(this.hashCode());
        return buffer.toString();
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

