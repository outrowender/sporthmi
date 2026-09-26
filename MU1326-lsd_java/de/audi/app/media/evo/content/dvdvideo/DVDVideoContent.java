/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.media.AbstractMediaContent;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.MediaVideoFormatDVDChanger;
import de.audi.app.media.dsi.media.MediaVideoFormatInternal;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoContent$1;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayer;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;

public class DVDVideoContent
extends AbstractMediaContent
implements IAudioStateListener {
    private static final String LOGCLASS;
    private final DVDVideoPlayer dvdPlayer;
    private volatile IServiceTracker displayMgrServiceTracker;
    private volatile IDisplayManagerService displayManagerService;
    private volatile boolean currentSourceDVDC = false;
    private final MediaVideoFormatInternal videoFormatInternalDVD;
    private final MediaVideoFormatDVDChanger videoFormatDVDChanger;
    private volatile boolean hasAudioFocus;
    static /* synthetic */ Class class$de$audi$atip$interapp$displaymanager$IDisplayManagerService;

    public DVDVideoContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(2, iContentContext, iMediaTerminal);
        this.dvdPlayer = new DVDVideoPlayer(iMediaTerminal, this, iMediaDSIPlayerController);
        this.videoFormatInternalDVD = new MediaVideoFormatInternal(this.logger.main(), iMediaDSIPlayerController);
        this.videoFormatDVDChanger = new MediaVideoFormatDVDChanger(this.logger.main(), iMediaTerminal, this.dvdPlayer);
    }

    @Override
    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"DVDVideoContent");
        this.dvdPlayer.init();
        this.displayMgrServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$displaymanager$IDisplayManagerService == null ? (class$de$audi$atip$interapp$displaymanager$IDisplayManagerService = DVDVideoContent.class$("de.audi.atip.interapp.displaymanager.IDisplayManagerService")) : class$de$audi$atip$interapp$displaymanager$IDisplayManagerService, new DVDVideoContent$1(this));
        this.displayMgrServiceTracker.open();
    }

    @Override
    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"DVDVideoContent");
        this.displayMgrServiceTracker.close();
        this.dvdPlayer.deinit();
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"DVDVideoContent");
        super.activate(iActivationContext);
        boolean bl = iActivationContext.getSlot().getSource().getType() == 3;
        ((ActivationContext)iActivationContext).addParameter("VIDEO_FORMAT_HANDLER", bl ? this.videoFormatDVDChanger : this.videoFormatInternalDVD);
        this.dvdPlayer.activate(iActivationContext);
        if (bl && null != this.displayManagerService) {
            this.displayManagerService.activateComponent(34, this.videoFormatDVDChanger);
            this.getTerminal().getAudioManager().addAudioContextListener(this);
        }
        this.currentSourceDVDC = bl;
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"DVDVideoContent");
        super.deactivate();
        this.dvdPlayer.deactivate();
        if (this.currentSourceDVDC && null != this.displayManagerService) {
            this.getTerminal().getAudioManager().removeAudioContextListener(this);
            this.displayManagerService.deactivateComponent(34);
        }
        this.currentSourceDVDC = false;
    }

    @Override
    public IPlayer getPlayer() {
        return this.dvdPlayer;
    }

    @Override
    public ButtonListener getHardKeyListener() {
        return this.dvdPlayer.getHardKeyListener();
    }

    @Override
    public void vehicleMoving(boolean bl) {
        this.dvdPlayer.vehicleMoving(bl);
    }

    @Override
    public void resetSettings() {
        this.dvdPlayer.resetSettings();
    }

    @Override
    public void audioStateChanged(AudioState audioState) {
        this.logger.main().log(1078071040, "[%1.audioStateChanged]", (Object)"DVDVideoContent");
        boolean bl = this.hasAudioFocus;
        this.hasAudioFocus = this.getTerminal().getAudioManager().hasAudioFocus();
        if (this.displayManagerService != null && this.currentSourceDVDC && this.hasAudioFocus != bl) {
            if (this.hasAudioFocus) {
                this.displayManagerService.activateComponent(34);
            } else {
                this.displayManagerService.deactivateComponent(34);
            }
        }
    }

    @Override
    public void audioFocusChanged(boolean bl) {
    }

    @Override
    public void rearSeatAudioFocusChanged(boolean bl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IMediaLogger access$000(DVDVideoContent dVDVideoContent) {
        return dVDVideoContent.logger;
    }

    static /* synthetic */ IDisplayManagerService access$102(DVDVideoContent dVDVideoContent, IDisplayManagerService iDisplayManagerService) {
        dVDVideoContent.displayManagerService = iDisplayManagerService;
        return dVDVideoContent.displayManagerService;
    }

    static /* synthetic */ MediaVideoFormatDVDChanger access$200(DVDVideoContent dVDVideoContent) {
        return dVDVideoContent.videoFormatDVDChanger;
    }

    static /* synthetic */ IMediaLogger access$300(DVDVideoContent dVDVideoContent) {
        return dVDVideoContent.logger;
    }

    static /* synthetic */ IDisplayManagerService access$100(DVDVideoContent dVDVideoContent) {
        return dVDVideoContent.displayManagerService;
    }

    static /* synthetic */ boolean access$400(DVDVideoContent dVDVideoContent) {
        return dVDVideoContent.currentSourceDVDC;
    }
}

