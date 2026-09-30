/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.dsi.carlife.DSICarlifeDefaultListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.PlayPositionEvent;
import de.audi.app.terminalmode.events.PlayPositionLogEvent;
import de.audi.app.terminalmode.events.PlayPositionLogger;
import de.audi.app.terminalmode.events.PlayPositionLoggerConfiguration;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.TrackData;

public final class CarlifeEventListener
extends DSICarlifeDefaultListener {
    private static final String LOGCLASS = "CarlifeEventListener";
    private final IEventBus eventBus;
    private final LogChannel lc;
    private volatile TrackPlayPositionEvent notifiedPlayPosition;
    private final PlayPositionLogger playPositionLogger;

    public CarlifeEventListener(IEventBus iEventBus, LogChannel logChannel, DSICarlife dSICarlife) {
        this.eventBus = iEventBus;
        this.lc = logChannel;
        dSICarlife.setNotification(new int[]{2, 5}, null);
        this.playPositionLogger = new PlayPositionLogger(new PlayPositionLoggerConfiguration().setPlayPositionLogEvent(PlayPositionEvent.STARTUP, new PlayPositionLogEvent(logChannel, 1000000, 3)).setPlayPositionLogEvent(PlayPositionEvent.PLAYBACK_STATE_CHANGED, new PlayPositionLogEvent(logChannel, 1000000, 2)).setPlayPositionLogEvent(PlayPositionEvent.TRACK_CHANGED, new PlayPositionLogEvent(logChannel, 1000000, 3)).setPlayPositionLogEvent(PlayPositionEvent.ILLEGAL_PLAYPOSITION, new PlayPositionLogEvent(logChannel, 10000, 3)).setPlayPositionLogEvent(PlayPositionEvent.TO_LATE_PLAYPOSITION, new PlayPositionLogEvent(logChannel, 10000, 3)));
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "<- [%1.asyncException] errCode='%2' msg='%3' requestType='%4'", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
    }

    public void updateNowPlayingData(TrackData trackData, int n) {
        if (this.isValid(n)) {
            TrackDataChangedEvent trackDataChangedEvent = new TrackDataChangedEvent.Builder().setAlbum(trackData.getAlbum()).setArtist(trackData.getArtist()).setDuration(trackData.getDuration()).setTitle(trackData.getTitle()).build();
            this.lc.log(1000000, "<- [%1.updateNowPlayingData] %2", (Object)LOGCLASS, (Object)trackDataChangedEvent);
            this.playPositionLogger.trackChanged();
            this.eventBus.updateNowPlayingData(trackDataChangedEvent);
            this.notifyPlayPosition(new TrackPlayPositionEvent(0, trackData.getDuration() / 1000));
        }
    }

    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if (this.isValid(n)) {
            PlaybackInfoChangedEvent playbackInfoChangedEvent = new PlaybackInfoChangedEvent.Builder().setPlaybackState(this.convert(playbackInfo.getStatus())).build();
            this.lc.log(1000000, "<- [%1.updateNowPlayingData] %2", (Object)LOGCLASS, (Object)playbackInfoChangedEvent);
            this.playPositionLogger.playbackStateChanged();
            this.eventBus.updatePlaybackInfo(playbackInfoChangedEvent);
        }
    }

    private PlaybackInfoChangedEvent.PlaybackState convert(int n) {
        switch (n) {
            case 2: {
                return PlaybackInfoChangedEvent.PlaybackState.PAUSED;
            }
            case 1: {
                return PlaybackInfoChangedEvent.PlaybackState.PLAYING;
            }
            case 4: {
                return PlaybackInfoChangedEvent.PlaybackState.SEEKBACKWARD;
            }
            case 3: {
                return PlaybackInfoChangedEvent.PlaybackState.SEEKBACKWARD;
            }
        }
        return PlaybackInfoChangedEvent.PlaybackState.STOPPED;
    }

    private void notifyPlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
        if (trackPlayPositionEvent.equals(this.notifiedPlayPosition)) {
            return;
        }
        this.notifiedPlayPosition = trackPlayPositionEvent;
        this.eventBus.updatePlayPosition(trackPlayPositionEvent);
    }

    public void updatePlayposition(int n, int n2) {
        if (this.isValid(n2)) {
            if (this.notifiedPlayPosition == null) {
                this.lc.log(100000, "[%1.updatePlayposition] southside error: No meta data available", (Object)LOGCLASS);
                return;
            }
            TrackPlayPositionEvent trackPlayPositionEvent = new TrackPlayPositionEvent(n / 1000, this.notifiedPlayPosition.getTotalTimeOfTrack());
            this.playPositionLogger.updatePlayPosition(trackPlayPositionEvent);
            this.notifyPlayPosition(trackPlayPositionEvent);
        }
    }

    private boolean isValid(int n) {
        return 1 == n;
    }
}

