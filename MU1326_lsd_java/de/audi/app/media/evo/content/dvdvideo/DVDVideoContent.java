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
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayer;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DVDVideoContent
extends AbstractMediaContent
implements IAudioStateListener {
    private static final String LOGCLASS = "DVDVideoContent";
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

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.dvdPlayer.init();
        this.displayMgrServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$displaymanager$IDisplayManagerService == null ? (class$de$audi$atip$interapp$displaymanager$IDisplayManagerService = DVDVideoContent.class$("de.audi.atip.interapp.displaymanager.IDisplayManagerService")) : class$de$audi$atip$interapp$displaymanager$IDisplayManagerService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                DVDVideoContent.this.logger.main().log(1000000, "[%1.removedService]", (Object)DVDVideoContent.LOGCLASS);
                DVDVideoContent.this.displayManagerService = null;
                DVDVideoContent.this.getTerminal().getServiceManager().releaseService(serviceReference);
                DVDVideoContent.this.videoFormatDVDChanger.setDisplayManagerService(null);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = DVDVideoContent.this.getTerminal().getServiceManager().getService(serviceReference);
                if (!(object instanceof IDisplayManagerService)) {
                    DVDVideoContent.this.logger.main().log(1000000, "[%1.addingService] unwanted service", (Object)DVDVideoContent.LOGCLASS);
                    DVDVideoContent.this.getTerminal().getServiceManager().releaseService(serviceReference);
                    return object;
                }
                DVDVideoContent.this.displayManagerService = (IDisplayManagerService)object;
                DVDVideoContent.this.videoFormatDVDChanger.setDisplayManagerService(DVDVideoContent.this.displayManagerService);
                if (DVDVideoContent.this.currentSourceDVDC) {
                    DVDVideoContent.this.displayManagerService.activateComponent(34);
                }
                return object;
            }
        });
        this.displayMgrServiceTracker.open();
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.displayMgrServiceTracker.close();
        this.dvdPlayer.deinit();
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
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

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        super.deactivate();
        this.dvdPlayer.deactivate();
        if (this.currentSourceDVDC && null != this.displayManagerService) {
            this.getTerminal().getAudioManager().removeAudioContextListener(this);
            this.displayManagerService.deactivateComponent(34);
        }
        this.currentSourceDVDC = false;
    }

    public IPlayer getPlayer() {
        return this.dvdPlayer;
    }

    public ButtonListener getHardKeyListener() {
        return this.dvdPlayer.getHardKeyListener();
    }

    public void vehicleMoving(boolean bl) {
        this.dvdPlayer.vehicleMoving(bl);
    }

    public void resetSettings() {
        this.dvdPlayer.resetSettings();
    }

    public void audioStateChanged(AudioState audioState) {
        this.logger.main().log(1000000, "[%1.audioStateChanged]", (Object)LOGCLASS);
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

    public void audioFocusChanged(boolean bl) {
    }

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
}

