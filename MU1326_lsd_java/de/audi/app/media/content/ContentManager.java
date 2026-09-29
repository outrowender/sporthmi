/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.IResetSettingsListener;
import de.audi.app.media.content.ContentManager$1;
import de.audi.app.media.content.ContentManager$2;
import de.audi.app.media.content.ContentManagerParameterFactory;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.IContentManager;
import de.audi.app.media.content.JobNotifyContentActivationFinished;
import de.audi.app.media.content.media.auxaudiostream.AudioStreamContent;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.online.content.OnlineContent;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.extension.IContentProvider;
import de.audi.app.media.extension.IMediaTerminalExtension;
import de.audi.app.media.extension.MediaTerminalExtensionTracker;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.util.NowPlayingScreenController;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;

public class ContentManager
extends AbstractMediaTerminalComponent
implements SpeedThresholdListener,
IContentManager,
IContentContext,
IDiagnosisCommandProvider,
IResetSettingsListener {
    private static final String LOGCLASS;
    private static final int HMI_CONTENT_UNDEFINED;
    private static final int HMI_CONTENT_CDDA;
    private static final int HMI_CONTENT_DATA;
    private static final int HMI_CONTENT_DVDV;
    private static final int HMI_CONTENT_TV;
    private static final int HMI_CONTENT_AV;
    private static final int HMI_CONTENT_AUX_AUDIO;
    private static final int HMI_CONTENT_FILEPLAYER;
    private static final int HMI_CONTENT_ONLINEPLAYER;
    private final IContent[] contentList = new IContent[9];
    final IMediaDSIPlayerController dsiMediaPlayerController;
    final NowPlayingScreenController npsController;
    final MediaTerminalExtensionTracker extensionTracker;
    final CopyOnWriteArrayList contentListeners;
    private volatile int activeContent;
    private volatile boolean isVehicleMoving;

    public ContentManager(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, MediaTerminalExtensionTracker mediaTerminalExtensionTracker) {
        this(iMediaTerminal, iMediaDSIPlayerController, mediaTerminalExtensionTracker, new ContentManagerParameterFactory());
    }

    ContentManager(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, MediaTerminalExtensionTracker mediaTerminalExtensionTracker, ContentManagerParameterFactory contentManagerParameterFactory) {
        super(iMediaTerminal);
        this.extensionTracker = mediaTerminalExtensionTracker;
        this.dsiMediaPlayerController = iMediaDSIPlayerController;
        this.npsController = contentManagerParameterFactory.createNowPlayingScreenController(iMediaTerminal.getFramework(), this.logger.hmi());
        this.contentListeners = contentManagerParameterFactory.createCopyOnWriteArrayList();
    }

    public void init() {
        this.logger.main().log(-2137614336, "[%1.init]", (Object)"ContentManager");
        this.npsController.init();
        this.getChoiceModel(2098135808).setValue(this.getTerminal().getConfiguration().isSpeedThresholdEnabledEver() ? 1 : 0);
        this.isVehicleMoving = false;
        this.setActiveContentType(-1);
        if (this.getTerminal().isFrontTerminal()) {
            this.getTerminal().getFramework().getSysApp().registerSpeedThresholdListener(this, 2);
            this.getTerminal().getDiagnosisManager().addCommandProvider(this.getTerminal().getTerminalID(), this);
        }
        this.getTerminal().addResetSettingsListener(this);
    }

    public void deinit() {
        this.logger.main().log(-2137614336, "[%1.deinit]", (Object)"ContentManager");
        if (this.getTerminal().isFrontTerminal()) {
            this.getTerminal().getFramework().getSysApp().unregisterSpeedThresholdListener(this);
        }
        this.npsController.deinit();
        this.removeAllContentListener();
        for (int i2 = 0; i2 < 9; ++i2) {
            if (this.contentList[i2] == null) continue;
            this.contentList[i2].deinit();
            this.contentList[i2] = null;
        }
    }

    @Override
    public void activateContent(IActivationContext iActivationContext) {
        int n = iActivationContext.getSlot().getContentType();
        this.logger.main().log(1078071040, "[%1.activateContent] [%2] '%3'", (Object)"ContentManager", (Object)LogUtil.getContentTypeStr(n), (Object)iActivationContext);
        if (!ContentManager.isCTValid(n)) {
            this.logger.main().log(-1601830656, "[%1.activateContent] Invalid content type.", (Object)"ContentManager");
            return;
        }
        this.deactivateActiveContent();
        IContent iContent = this.getContent(n);
        if (null == iContent) {
            return;
        }
        iContent.activate(iActivationContext);
        this.setActiveContentType(n);
        iContent.vehicleMoving(this.isVehicleMoving);
        this.updateToneMediaSoftkeys();
        this.notifyContentActivated(iContent, iActivationContext.getSlot());
    }

    @Override
    public void deactivateActiveContent() {
        int n = this.getActiveContentType();
        if (n == -1) {
            this.logger.main().log(1078071040, "[%1.deactivateActiveContent] No active content.", (Object)"ContentManager");
            return;
        }
        this.logger.main().log(1078071040, "[%1.deactivateActiveContent] '%2'", (Object)"ContentManager", (Object)LogUtil.getContentTypeStr(n));
        this.setActiveContentType(-1);
        IContent iContent = this.getContent(n);
        if (null == iContent) {
            this.logger.main().log(-1601830656, "[%1.deactivateActiveContent] current content is null", (Object)"ContentManager");
            return;
        }
        this.notifyContentDeactivated(iContent);
        iContent.deactivate();
    }

    public int getActiveContentType() {
        return this.activeContent;
    }

    private void setActiveContentType(int n) {
        this.activeContent = n;
        this.setHMIContentType(n);
    }

    private void setHMIContentType(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 8: {
                n2 = 8;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        this.getChoiceModel(1309606656).setValue(n2);
    }

    @Override
    public IContent getActiveContent() {
        int n = this.getActiveContentType();
        if (n == -1) {
            return null;
        }
        return this.getContent(n);
    }

    @Override
    public IContent getContent(int n) {
        return this.lazyInitializeContent(n);
    }

    @Override
    public void onResetSettings(int n) {
        this.logger.main().log(1078071040, "[%1.resetContentSettings]", (Object)"ContentManager");
        this.npsController.resetToFactorySettings();
        for (int i2 = 0; i2 < 9; ++i2) {
            IContent iContent = this.getContent(i2);
            if (iContent == null) continue;
            this.logger.main().log(-2137614336, "[%1.resetContentSettings] Reset content '%2'.", (Object)"ContentManager", (Object)LogUtil.getContentTypeStr(iContent.getContentType()));
            iContent.resetSettings();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private IContent lazyInitializeContent(int n) {
        if (!ContentManager.isCTValid(n)) {
            return null;
        }
        IContentProvider iContentProvider = null;
        IContent[] iContentArray = this.extensionTracker.getServices().iterator();
        while (iContentArray.hasNext()) {
            IMediaTerminalExtension iMediaTerminalExtension = (IMediaTerminalExtension)iContentArray.next();
            if (iMediaTerminalExtension.getContentProvider() == null || !iMediaTerminalExtension.getContentProvider().provideContent(n)) continue;
            iContentProvider = iMediaTerminalExtension.getContentProvider();
            break;
        }
        iContentArray = this.contentList;
        synchronized (this.contentList) {
            if (this.contentList[n] != null) {
                // ** MonitorExit[var3_3] (shouldn't be in output)
                return this.contentList[n];
            }
            switch (n) {
                case 0: {
                    this.logger.main().log(1078071040, "[%1.lazyInitializeContent] CDDA.", (Object)"ContentManager");
                    if (iContentProvider == null) {
                        this.logger.main().log(1078071040, "[%1.lazyInitializeContent] No content provider for CDDA.", (Object)"ContentManager");
                        // ** MonitorExit[var3_3] (shouldn't be in output)
                        return null;
                    }
                    this.contentList[0] = iContentProvider.createContent(0, this, this.getTerminal(), this.dsiMediaPlayerController);
                    break;
                }
                case 1: {
                    this.logger.main().log(1078071040, "[%1.lazyInitializeContent] DATA.", (Object)"ContentManager");
                    if (iContentProvider == null) {
                        this.logger.main().log(1078071040, "[%1.lazyInitializeContent] No content provider for DATA.", (Object)"ContentManager");
                        // ** MonitorExit[var3_3] (shouldn't be in output)
                        return null;
                    }
                    this.contentList[1] = iContentProvider.createContent(1, this, this.getTerminal(), this.dsiMediaPlayerController);
                    break;
                }
                case 2: {
                    this.logger.main().log(1078071040, "[%1.lazyInitializeContent] DVD VIDEO.", (Object)"ContentManager");
                    if (iContentProvider == null) {
                        this.logger.main().log(1078071040, "[%1.lazyInitializeContent] No content provider for DVDV.", (Object)"ContentManager");
                        // ** MonitorExit[var3_3] (shouldn't be in output)
                        return null;
                    }
                    this.contentList[2] = iContentProvider.createContent(2, this, this.getTerminal(), this.dsiMediaPlayerController);
                    break;
                }
                case 3: {
                    if (null == iContentProvider) {
                        this.logger.main().log(10000, "[%1.lazyInitializeContent] ContentProvider for TV not available.", (Object)"ContentManager");
                        // ** MonitorExit[var3_3] (shouldn't be in output)
                        return null;
                    }
                    this.logger.main().log(1078071040, "[%1.lazyInitializeContent] TV.", (Object)"ContentManager");
                    this.contentList[3] = iContentProvider.createContent(3, this, this.getTerminal(), this.dsiMediaPlayerController);
                    break;
                }
                case 5: {
                    this.logger.main().log(1078071040, "[%1.lazyInitializeContent] AUDIOSTREAM.", (Object)"ContentManager");
                    this.contentList[5] = new AudioStreamContent(this, this.getTerminal());
                    break;
                }
                case 4: {
                    if (null == iContentProvider) {
                        this.logger.main().log(10000, "[%1.lazyInitializeContent] ContentProvider for AV not available.", (Object)"ContentManager");
                        // ** MonitorExit[var3_3] (shouldn't be in output)
                        return null;
                    }
                    this.logger.main().log(1078071040, "[%1.lazyInitializeContent] AV", (Object)"ContentManager");
                    this.contentList[4] = iContentProvider.createContent(4, this, this.getTerminal(), this.dsiMediaPlayerController);
                    break;
                }
                case 7: {
                    this.logger.main().log(1078071040, "[%1.lazyInitializeContent] FILEPLAYER.", (Object)"ContentManager");
                    this.contentList[7] = new FilePlayerContent(this, this.getTerminal(), this.dsiMediaPlayerController);
                    break;
                }
                case 8: {
                    this.logger.main().log(1078071040, "[%1.lazyInitializeContent] ONLINEPLAYER.", (Object)"ContentManager");
                    this.contentList[8] = new OnlineContent(this, this.getTerminal(), this.dsiMediaPlayerController);
                    break;
                }
                default: {
                    // ** MonitorExit[var3_3] (shouldn't be in output)
                    return null;
                }
            }
            // ** MonitorExit[var3_3] (shouldn't be in output)
            if (this.contentList[n] == null) {
                throw new IllegalStateException(new StringBuffer().append("No content provider registered for type '").append(n).append("'.").toString());
            }
            this.contentList[n].init();
            return this.contentList[n];
        }
    }

    private static boolean isCTValid(int n) {
        return n > -1 && n < 9;
    }

    private void updateToneMediaSoftkeys() {
        int n;
        int n2 = this.getActiveContentType();
        switch (n2) {
            case 3: {
                n = 3;
                break;
            }
            case 4: 
            case 5: 
            case 6: {
                n = 4;
                break;
            }
            default: {
                n = 2;
            }
        }
        ((ChoiceModelApp)this.getSystemModel(27)).setValue(n);
    }

    @Override
    public void belowLowerThreshold(int n) {
        this.getTerminal().getDispatcher().execute(new ContentManager$1(this, "ContentManager.vehicleMoving(false)"));
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        this.getTerminal().getDispatcher().execute(new ContentManager$2(this, "ContentManager.vehicleMoving(true)"));
    }

    private void setVehicleMoving(boolean bl) {
        this.logger.main().log(1078071040, "[%2.setVehicleMoving] vehicleMoving='%1'.", bl, (Object)"ContentManager");
        if (this.getTerminal().getConfiguration().isSpeedThresholdDisabled()) {
            this.logger.main().log(1078071040, "[%2.setVehicleMoving] Disabled. Ignore.", bl, (Object)"ContentManager");
            return;
        }
        if (this.getTerminal().getConfiguration().isSpeedThresholdEnabledEver()) {
            this.logger.main().log(1078071040, "[%1.setVehicleMoving] Enabled forever.", (Object)"ContentManager");
            this.getChoiceModel(2098135808).setValue(1);
        } else {
            this.getChoiceModel(2098135808).setValue(bl ? 1 : 0);
        }
        this.isVehicleMoving = bl;
        int n = this.getActiveContentType();
        if (n == -1) {
            return;
        }
        IContent iContent = this.getContent(n);
        if (iContent != null) {
            iContent.vehicleMoving(bl);
        }
    }

    @Override
    public void addContentListener(IContentListener iContentListener) {
        this.logger.main().log(-2137614336, "[%1.addContentListener] '%2'", (Object)"ContentManager", (Object)iContentListener);
        if (iContentListener == null) {
            throw new IllegalArgumentException();
        }
        this.contentListeners.addIfAbsent(iContentListener);
    }

    @Override
    public void removeContentListener(IContentListener iContentListener) {
        this.logger.main().log(-2137614336, "[%1.removeContentListener] '%2'", (Object)"ContentManager", (Object)iContentListener);
        this.contentListeners.remove(iContentListener);
    }

    private void removeAllContentListener() {
        this.contentListeners.clear();
    }

    private void notifyContentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        this.logger.main().log(-2137614336, "[%1.notifyContentActivated] '%2'", (Object)"ContentManager", (Object)LogUtil.getContentTypeStr(iContent.getContentType()));
        Iterator iterator = this.contentListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IContentListener)iterator.next()).contentActivated(iContent, iSourceSlot);
            }
            catch (Exception exception) {
                this.logger.main().log(-1601830656, "[%1.notifyContentActivated]", (Object)"ContentManager", (Throwable)exception);
            }
        }
    }

    private void notifyContentDeactivated(IContent iContent) {
        this.logger.main().log(-2137614336, "[%1.notifyContentDeactivated] '%2'", (Object)"ContentManager", (Object)LogUtil.getContentTypeStr(iContent.getContentType()));
        Iterator iterator = this.contentListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IContentListener)iterator.next()).contentDeactivated(iContent);
            }
            catch (Exception exception) {
                this.logger.main().log(-1601830656, "[%1.notifyContentDeactivated]", (Object)"ContentManager", (Throwable)exception);
            }
        }
    }

    @Override
    public void notifyContentActivationFinished(IContent iContent) {
        if (iContent == null) {
            throw new IllegalArgumentException("Content is null");
        }
        this.logger.main().log(1078071040, "[%1.notifyContentActivationFinished] '%2'", (Object)"ContentManager", (Object)LogUtil.getContentTypeStr(iContent.getContentType()));
        this.getTerminal().getDispatcher().execute(new JobNotifyContentActivationFinished(this.logger, this.contentListeners, iContent));
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"SpeedThresholdOver", "SpeedThresholdUnder", "browser.reset"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("SpeedThresholdOver".equals(string)) {
            this.exceedsUpperThreshold(0);
        } else if ("SpeedThresholdUnder".equals(string)) {
            this.belowLowerThreshold(0);
        } else if ("browser.reset".equals(string)) {
            if (this.getActiveContentType() == 1) {
                this.getActiveContent().diagResetBrowser();
            } else {
                this.logger.main().log(10000, "[%1.executeDiagCommand] '%2' no browser reset possible CT_DATA must be active", (Object)"ContentManager", (Object)LogUtil.getContentTypeStr(this.getActiveContentType()));
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("ContentManager").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ IMediaLogger access$000(ContentManager contentManager) {
        return contentManager.logger;
    }

    static /* synthetic */ void access$100(ContentManager contentManager, boolean bl) {
        contentManager.setVehicleMoving(bl);
    }

    static /* synthetic */ IMediaLogger access$200(ContentManager contentManager) {
        return contentManager.logger;
    }
}

