/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.dsi.carplay.CarPlayAppState;
import de.audi.app.terminalmode.dsi.carplay.CarPlayResource;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl$1;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl$2;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl$3;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl$4;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl$5;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl$6;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl$7;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIControllerListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.app.terminalmode.events.PlayPositionEvent;
import de.audi.app.terminalmode.events.PlayPositionLogEvent;
import de.audi.app.terminalmode.events.PlayPositionLogger;
import de.audi.app.terminalmode.events.PlayPositionLoggerConfiguration;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$Builder;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackDataChangedEvent$Builder;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DSICarplayListener;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class CarplayDSILifecycleController$DSICarplayListenerImpl
implements DSICarplayListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final DispatcherBase dispatcher;
    private final IEventBus eventBus;
    private final IContext context;
    private ICarplayDSIControllerListener dioDSIControllerListener;
    private volatile TrackPlayPositionEvent notifiedPlayPosition;
    private final PlayPositionLogger playPositionLogger;

    private IResource[] convertResource(Resource[] resourceArray) {
        Object[] objectArray = new IResource[resourceArray.length];
        for (int i2 = 0; i2 < resourceArray.length; ++i2) {
            objectArray[i2] = new CarPlayResource(resourceArray[i2]);
        }
        this.logger.log(-2137614336, "[%1.convertResource] %2", (Object)"DSICarplayListenerImpl", (Object)Arrays2.toString(objectArray));
        return objectArray;
    }

    private IAppState[] convertAppState(AppState[] appStateArray) {
        Object[] objectArray = new IAppState[appStateArray.length];
        boolean bl = false;
        for (int i2 = 0; i2 < appStateArray.length; ++i2) {
            if (appStateArray[i2].getAppStateID() == 1 && appStateArray[i2].getOwner() == 2) {
                bl = true;
            }
            if (bl && appStateArray[i2].getAppStateID() == 3) continue;
            objectArray[i2] = new CarPlayAppState(appStateArray[i2]);
        }
        this.logger.log(-2137614336, "[%1.convertAppState] %2", (Object)"DSICarplayListenerImpl", (Object)Arrays2.toString(objectArray));
        return objectArray;
    }

    public CarplayDSILifecycleController$DSICarplayListenerImpl(LogChannel logChannel, DispatcherBase dispatcherBase, IEventBus iEventBus, IContext iContext) {
        this.logger = logChannel;
        this.dispatcher = dispatcherBase;
        this.eventBus = iEventBus;
        this.context = iContext;
        this.notifiedPlayPosition = new TrackPlayPositionEvent(-1, -1);
        this.playPositionLogger = new PlayPositionLogger(new PlayPositionLoggerConfiguration().setPlayPositionLogEvent(PlayPositionEvent.STARTUP, new PlayPositionLogEvent(logChannel, 1078071040, 3)).setPlayPositionLogEvent(PlayPositionEvent.PLAYBACK_STATE_CHANGED, new PlayPositionLogEvent(logChannel, 1078071040, 2)).setPlayPositionLogEvent(PlayPositionEvent.TRACK_CHANGED, new PlayPositionLogEvent(logChannel, 1078071040, 3)).setPlayPositionLogEvent(PlayPositionEvent.ILLEGAL_PLAYPOSITION, new PlayPositionLogEvent(logChannel, 10000, 3)).setPlayPositionLogEvent(PlayPositionEvent.TO_LATE_PLAYPOSITION, new PlayPositionLogEvent(logChannel, 10000, 3)));
    }

    public void init() {
        this.dioDSIControllerListener = (ICarplayDSIControllerListener)this.context.get(SmartphoneManager$SmartphoneType.CARPLAY, CarplayDSILifecycleController.class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener == null ? (CarplayDSILifecycleController.class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener = CarplayDSILifecycleController.class$("de.audi.app.terminalmode.dsi.carplay.ICarplayDSIControllerListener")) : CarplayDSILifecycleController.class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener);
    }

    @Override
    public void updateMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
        if (!this.isValid(n)) {
            this.logger.log(-2137614336, "<- [%1.updateMode] Invalid.", (Object)"DSICarplayListenerImpl");
            return;
        }
        IAppState[] iAppStateArray = this.convertAppState(appStateArray);
        IResource[] iResourceArray = this.convertResource(resourceArray);
        this.dispatcher.execute(new CarplayDSILifecycleController$DSICarplayListenerImpl$1(this, "digitalIpodOutListener.updateMode", iAppStateArray, iResourceArray));
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray, int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(10000, "<- [%1.asyncException] errCode='%2' msg='%3' requestType='%4'", (Object)"DSICarplayListenerImpl", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
    }

    @Override
    public void requestBTDeactivation(String string, int n) {
    }

    @Override
    public void updateTextInputState(int n, int n2) {
        if (!this.isValid(n2)) {
            this.logger.log(-2137614336, "<- [%1.updateTextInputState] Invalid.", (Object)"DSICarplayListenerImpl");
            return;
        }
        this.dispatcher.execute(new CarplayDSILifecycleController$DSICarplayListenerImpl$2(this, "digitalIpodOutListener.updateTextInputState", n));
    }

    @Override
    public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
    }

    @Override
    public void updateTelephonyState(TelephonyState telephonyState, int n) {
        if (this.isValid(n)) {
            PhoneStateChangedEvent phoneStateChangedEvent = new PhoneStateChangedEvent(telephonyState.getSignalStrength(), telephonyState.getRegistrationStatus(), telephonyState.isAirplaneMode(), telephonyState.getMobileOperator());
            this.logger.log(1078071040, "<- [%1.updateTelephonyState] %2", (Object)"DSICarplayListenerImpl", (Object)phoneStateChangedEvent);
            this.eventBus.updatePhoneState(phoneStateChangedEvent);
        }
    }

    @Override
    public void updateNowPlayingData(TrackData trackData, int n) {
        if (this.isValid(n)) {
            TrackDataChangedEvent trackDataChangedEvent = new TrackDataChangedEvent$Builder().setAlbum(trackData.getAlbum()).setArtist(trackData.getArtist()).setComposer(trackData.getComposer()).setDuration(trackData.getDuration()).setGenre(trackData.getGenre()).setTitle(trackData.getTitle()).build();
            this.logger.log(1078071040, "<- [%1.updateNowPlayingData] %2", (Object)"DSICarplayListenerImpl", (Object)trackDataChangedEvent);
            this.playPositionLogger.trackChanged();
            this.eventBus.updateNowPlayingData(trackDataChangedEvent);
            this.notifyPlayPosition(new TrackPlayPositionEvent(0, trackData.getDuration() / 1000));
        }
    }

    private void notifyPlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
        if (trackPlayPositionEvent.equals(this.notifiedPlayPosition)) {
            return;
        }
        this.notifiedPlayPosition = trackPlayPositionEvent;
        this.eventBus.updatePlayPosition(trackPlayPositionEvent);
    }

    @Override
    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if (this.isValid(n)) {
            PlaybackInfoChangedEvent playbackInfoChangedEvent = new PlaybackInfoChangedEvent$Builder().setPlaybackState(this.convert(playbackInfo.getStatus())).build();
            this.logger.log(1078071040, "<- [%1.updatePlaybackState] %2", (Object)"DSICarplayListenerImpl", (Object)playbackInfoChangedEvent);
            this.playPositionLogger.playbackStateChanged();
            this.eventBus.updatePlaybackInfo(playbackInfoChangedEvent);
        }
    }

    private PlaybackInfoChangedEvent$PlaybackState convert(int n) {
        switch (n) {
            case 2: {
                return PlaybackInfoChangedEvent$PlaybackState.PAUSED;
            }
            case 1: {
                return PlaybackInfoChangedEvent$PlaybackState.PLAYING;
            }
            case 4: {
                return PlaybackInfoChangedEvent$PlaybackState.SEEKBACKWARD;
            }
            case 3: {
                return PlaybackInfoChangedEvent$PlaybackState.SEEKBACKWARD;
            }
        }
        return PlaybackInfoChangedEvent$PlaybackState.STOPPED;
    }

    @Override
    public void updatePlayposition(int n, int n2) {
        if (this.isValid(n2)) {
            this.playPositionLogger.updatePlayPosition(n / 1000, this.notifiedPlayPosition.getTotalTimeOfTrack());
            this.notifyPlayPosition(new TrackPlayPositionEvent(n / 1000, this.notifiedPlayPosition.getTotalTimeOfTrack()));
        }
    }

    @Override
    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void updateCallState(CallState[] callStateArray, int n) {
        if (!this.isValid(n)) {
            this.logger.log(-2137614336, "<- [%1.updateCallState] Invalid.", (Object)"DSICarplayListenerImpl");
            return;
        }
        this.dispatcher.execute(new CarplayDSILifecycleController$DSICarplayListenerImpl$3(this, "digitalIpodOutListener.updateCallState", callStateArray));
    }

    @Override
    public void duckAudio(int n, double d2) {
        this.dispatcher.execute(new CarplayDSILifecycleController$DSICarplayListenerImpl$4(this, "digitalIpodOutListener.duckAudio", n, d2));
    }

    @Override
    public void unduckAudio(int n) {
        this.dispatcher.execute(new CarplayDSILifecycleController$DSICarplayListenerImpl$5(this, "digitalIpodOutListener.unduckAudio", n));
    }

    @Override
    public void oemAppSelected() {
        this.dispatcher.execute(new CarplayDSILifecycleController$DSICarplayListenerImpl$6(this, "digitalIpodOutListener.oemAppSelected"));
    }

    @Override
    public void updateMainAudioType(int n, int n2) {
        if (!this.isValid(n2)) {
            this.logger.log(-2137614336, "<- [%1.updateMainAudioType] Invalid.", (Object)"DSICarplayListenerImpl");
            return;
        }
        this.dispatcher.execute(new CarplayDSILifecycleController$DSICarplayListenerImpl$7(this, "digitalIpodOutListener.updateMainAudioType", n));
    }

    protected boolean isValid(int n) {
        return 1 == n;
    }

    static /* synthetic */ LogChannel access$4500(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl) {
        return carplayDSILifecycleController$DSICarplayListenerImpl.logger;
    }

    static /* synthetic */ ICarplayDSIControllerListener access$4600(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl) {
        return carplayDSILifecycleController$DSICarplayListenerImpl.dioDSIControllerListener;
    }

    static /* synthetic */ IEventBus access$4700(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl) {
        return carplayDSILifecycleController$DSICarplayListenerImpl.eventBus;
    }
}

