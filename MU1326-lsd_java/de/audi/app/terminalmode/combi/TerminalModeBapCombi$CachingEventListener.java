/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.combi;

import de.audi.app.terminalmode.combi.TerminalModeBapCombi;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$1;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackDataChangedEvent$Builder;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;

class TerminalModeBapCombi$CachingEventListener
extends DefaultEventListener {
    private final TrackPlayPositionEvent INVALID_TIME = new TrackPlayPositionEvent(-1, 0);
    private final TrackDataChangedEvent INVALID_TRACK = new TrackDataChangedEvent$Builder().build();
    private TrackPlayPositionEvent lastPlayPositionEvent = this.INVALID_TIME;
    private TrackDataChangedEvent lastTrackData = this.INVALID_TRACK;
    private final /* synthetic */ TerminalModeBapCombi this$0;

    private TerminalModeBapCombi$CachingEventListener(TerminalModeBapCombi terminalModeBapCombi) {
        this.this$0 = terminalModeBapCombi;
    }

    @Override
    public void updateNowPlayingData(TrackDataChangedEvent trackDataChangedEvent) {
        this.lastTrackData = trackDataChangedEvent;
    }

    @Override
    public void updatePlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
        this.lastPlayPositionEvent = trackPlayPositionEvent;
    }

    public void sendCachedEvents() {
        if (!this.INVALID_TIME.equals(this.lastPlayPositionEvent)) {
            TerminalModeBapCombi.access$600(this.this$0).updatePlayPosition(this.lastPlayPositionEvent);
        }
        if (!this.INVALID_TRACK.equals(this.lastTrackData)) {
            TerminalModeBapCombi.access$600(this.this$0).updateNowPlayingData(this.lastTrackData);
        }
    }

    public void clearCachedEvents() {
        this.lastPlayPositionEvent = this.INVALID_TIME;
        this.lastTrackData = this.INVALID_TRACK;
    }

    /* synthetic */ TerminalModeBapCombi$CachingEventListener(TerminalModeBapCombi terminalModeBapCombi, TerminalModeBapCombi$1 terminalModeBapCombi$1) {
        this(terminalModeBapCombi);
    }
}

