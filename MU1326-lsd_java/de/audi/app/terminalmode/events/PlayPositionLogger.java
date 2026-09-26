/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.events.PlayPositionEvent;
import de.audi.app.terminalmode.events.PlayPositionLogEvent;
import de.audi.app.terminalmode.events.PlayPositionLoggerConfiguration;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.esolutions.fw.util.commons.Buffer;

public class PlayPositionLogger {
    private final PlayPositionLoggerConfiguration logEventConfiguration;
    private volatile PlayPositionLogEvent currentLogEvent;
    private volatile int lastPlayPosition;

    public PlayPositionLogger(PlayPositionLoggerConfiguration playPositionLoggerConfiguration) {
        this.logEventConfiguration = playPositionLoggerConfiguration;
        this.currentLogEvent = playPositionLoggerConfiguration.getPlayPositionLogEvent(PlayPositionEvent.STARTUP);
        this.lastPlayPosition = 0;
    }

    public void updatePlayPosition(int n, int n2) {
        if (n < 0 || n2 < 0 || n > n2 || this.lastPlayPosition > n) {
            this.setCurrentLogEvent(this.logEventConfiguration.getPlayPositionLogEvent(PlayPositionEvent.ILLEGAL_PLAYPOSITION));
            Buffer buffer = new Buffer(50);
            buffer.append("playPosition=");
            buffer.append(n);
            buffer.append(" totalTime=");
            buffer.append(n2);
            this.currentLogEvent.logUpdatePlayposition(buffer.toString());
        } else {
            this.updatePlayPosition(new TrackPlayPositionEvent(n, n2));
        }
        this.lastPlayPosition = n;
    }

    public void updatePlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
        this.currentLogEvent.logUpdatePlayposition(trackPlayPositionEvent.toString());
    }

    public void playbackStateChanged() {
        this.setCurrentLogEvent(this.logEventConfiguration.getPlayPositionLogEvent(PlayPositionEvent.PLAYBACK_STATE_CHANGED));
    }

    public void trackChanged() {
        this.lastPlayPosition = 0;
        this.setCurrentLogEvent(this.logEventConfiguration.getPlayPositionLogEvent(PlayPositionEvent.TRACK_CHANGED));
    }

    private boolean setCurrentLogEvent(PlayPositionLogEvent playPositionLogEvent) {
        playPositionLogEvent.resetCounter();
        this.currentLogEvent = playPositionLogEvent;
        return true;
    }
}

