/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.combi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.combi.NullCombiBAPService;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.interapp.bap.data.TimeStamp;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class TerminalModeBapCombi
implements ITerminalModeComponent {
    private static final String LOGCLASS = "TerminalModeBapCombi";
    private final IContext context;
    private final BundleContext bundleContext;
    private final LogChannel lc;
    private final IServiceTracker serviceTracker;
    private final IServiceManager serviceManager;
    private final IEventListener eventListener;
    private final CachingEventListener cachingEventListener;
    private volatile CombiBAPServiceTerminalMode bapService;
    private ActiveDeviceStateListener activeDeviceListener;
    private final IAudioStateListener audioStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode;

    public TerminalModeBapCombi(IContext iContext) {
        this.context = iContext;
        this.bundleContext = this.context.getFramework().getBundleCxt();
        this.lc = this.context.getLogger().main();
        this.bapService = new NullCombiBAPService(this.lc);
        this.serviceManager = this.context.getServiceManager();
        this.serviceTracker = this.serviceManager.createServiceTracker(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode = TerminalModeBapCombi.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode, new CombiBapServiceTrackerCustomizer());
        this.eventListener = new EventListener();
        this.cachingEventListener = new CachingEventListener();
        this.activeDeviceListener = new ActiveDeviceStateListener();
        this.audioStateListener = new AudioStateListener();
    }

    public void init() {
        this.serviceTracker.open();
        this.context.getEventBus().registerListener(this.cachingEventListener);
        this.context.getDeviceManager().addActiveDeviceListener(this.activeDeviceListener);
        this.context.getAudioManager().addAudioContextListener(this.audioStateListener);
    }

    public void deinit() {
        this.serviceTracker.close();
        this.context.getEventBus().unregisterListener(this.eventListener);
        this.context.getEventBus().unregisterListener(this.cachingEventListener);
        this.context.getDeviceManager().removeActiveDeviceListener(this.activeDeviceListener);
        this.context.getAudioManager().removeAudioContextListener(this.audioStateListener);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class EventListener
    extends DefaultEventListener {
        private EventListener() {
        }

        public void updateNowPlayingData(TrackDataChangedEvent trackDataChangedEvent) {
            int n = trackDataChangedEvent.getTitle().length() > 0 ? 6 : 0;
            int n2 = trackDataChangedEvent.getArtist().length() > 0 ? 73 : 0;
            int n3 = trackDataChangedEvent.getAlbum().length() > 0 ? 74 : 0;
            CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = new CombiBAPCurrentStationInfo();
            combiBAPCurrentStationInfo.setPrimaryInformation(trackDataChangedEvent.getTitle(), n, 0);
            combiBAPCurrentStationInfo.setSecondaryInformation(trackDataChangedEvent.getArtist(), n2);
            combiBAPCurrentStationInfo.setTertiaryInformation(trackDataChangedEvent.getAlbum(), n3);
            TerminalModeBapCombi.this.lc.log(1000000, "[TerminalModeCombi.updateNowPlayingData] STATES_NO_ERROR!");
            TerminalModeBapCombi.this.bapService.updateCurrentStation(combiBAPCurrentStationInfo);
            TerminalModeBapCombi.this.bapService.updateActiveInfoState(0);
        }

        public void updatePlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
            if (trackPlayPositionEvent.getTotalTimeOfTrack() == 0) {
                TerminalModeBapCombi.this.bapService.updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(65535)).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(65535)).build());
            } else {
                TerminalModeBapCombi.this.bapService.updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(trackPlayPositionEvent.getPlayTime())).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(trackPlayPositionEvent.getTotalTimeOfTrack())).build());
            }
        }
    }

    private final class AudioStateListener
    implements IAudioStateListener {
        private AudioStateListener() {
        }

        public void audioStateChanged(AudioConnectionState audioConnectionState) {
        }

        public void audioFocusChanged(boolean bl) {
            TerminalModeBapCombi.this.lc.log(10000000, "[%1.audioFocusChanged] %2", (Object)TerminalModeBapCombi.LOGCLASS, (Object)new Boolean(bl));
            if (bl) {
                TerminalModeBapCombi.this.context.getEventBus().registerListener(TerminalModeBapCombi.this.eventListener);
                TerminalModeBapCombi.this.cachingEventListener.sendCachedEvents();
            } else {
                TerminalModeBapCombi.this.context.getEventBus().unregisterListener(TerminalModeBapCombi.this.eventListener);
            }
        }
    }

    private class CachingEventListener
    extends DefaultEventListener {
        private final TrackPlayPositionEvent INVALID_TIME = new TrackPlayPositionEvent(-1, 0);
        private final TrackDataChangedEvent INVALID_TRACK = new TrackDataChangedEvent.Builder().build();
        private TrackPlayPositionEvent lastPlayPositionEvent = this.INVALID_TIME;
        private TrackDataChangedEvent lastTrackData = this.INVALID_TRACK;

        private CachingEventListener() {
        }

        public void updateNowPlayingData(TrackDataChangedEvent trackDataChangedEvent) {
            this.lastTrackData = trackDataChangedEvent;
        }

        public void updatePlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
            this.lastPlayPositionEvent = trackPlayPositionEvent;
        }

        public void sendCachedEvents() {
            if (!this.INVALID_TIME.equals(this.lastPlayPositionEvent)) {
                TerminalModeBapCombi.this.eventListener.updatePlayPosition(this.lastPlayPositionEvent);
            }
            if (!this.INVALID_TRACK.equals(this.lastTrackData)) {
                TerminalModeBapCombi.this.eventListener.updateNowPlayingData(this.lastTrackData);
            }
        }

        public void clearCachedEvents() {
            this.lastPlayPositionEvent = this.INVALID_TIME;
            this.lastTrackData = this.INVALID_TRACK;
        }
    }

    private final class ActiveDeviceStateListener
    implements IActiveDeviceStateListener {
        private ActiveDeviceStateListener() {
        }

        public void updateActiveDeviceState(TMDevice tMDevice) {
            if (tMDevice.connectionState().is(TMDevice.ConnectionState.ACTIVATING)) {
                TerminalModeBapCombi.this.bapService.updateActiveInfoState(9);
                int n = this.getBapSourceType(tMDevice);
                TerminalModeBapCombi.this.bapService.updateActiveSource(n, 0, 0, false, false, 0);
                TerminalModeBapCombi.this.bapService.updateCurrentStation(new CombiBAPCurrentStationInfo());
                TerminalModeBapCombi.this.bapService.updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(65535)).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(65535)).build());
                TerminalModeBapCombi.this.bapService.updateActiveInfoState(9);
            }
        }

        private int getBapSourceType(TMDevice tMDevice) {
            if (tMDevice.isCarplayDevice()) {
                return 37;
            }
            if (tMDevice.isAndroidAutoDevice()) {
                return 39;
            }
            return 40;
        }
    }

    private final class CombiBapServiceTrackerCustomizer
    extends DefaultServiceTrackerCustomizer {
        private CombiBapServiceTrackerCustomizer() {
        }

        public Object addingService(ServiceReference serviceReference) {
            CombiBAPServiceTerminalMode combiBAPServiceTerminalMode = (CombiBAPServiceTerminalMode)TerminalModeBapCombi.this.context.getServiceManager().getService(serviceReference);
            if (combiBAPServiceTerminalMode != null) {
                TerminalModeBapCombi.this.lc.log(1000000, "[TerminalModeCombi.addingService] %1", (Object)combiBAPServiceTerminalMode);
                TerminalModeBapCombi.this.bapService = combiBAPServiceTerminalMode;
            }
            return combiBAPServiceTerminalMode;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            TerminalModeBapCombi.this.lc.log(1000000, "[TerminalModeCombi.removedService] %1", object);
            TerminalModeBapCombi.this.bapService = new NullCombiBAPService(TerminalModeBapCombi.this.lc);
            TerminalModeBapCombi.this.bundleContext.ungetService(serviceReference);
        }
    }
}

