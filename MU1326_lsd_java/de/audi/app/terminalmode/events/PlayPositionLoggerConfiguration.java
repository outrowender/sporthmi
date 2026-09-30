/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.events.PlayPositionEvent;
import de.audi.app.terminalmode.events.PlayPositionLogEvent;
import de.audi.atip.log.NullLogChannel;

public class PlayPositionLoggerConfiguration {
    private final PlayPositionLogEvent[] logEventConfiguration;
    private final PlayPositionLogEvent nullPlayPositionEvent = new PlayPositionLogEvent(NullLogChannel.getInstance(), 100000000, 0);

    public PlayPositionLoggerConfiguration() {
        this.logEventConfiguration = new PlayPositionLogEvent[PlayPositionEvent.values().length];
        this.logEventConfiguration[PlayPositionEvent.STARTUP.ordinal()] = this.nullPlayPositionEvent;
        this.logEventConfiguration[PlayPositionEvent.PLAYBACK_STATE_CHANGED.ordinal()] = this.nullPlayPositionEvent;
        this.logEventConfiguration[PlayPositionEvent.TRACK_CHANGED.ordinal()] = this.nullPlayPositionEvent;
        this.logEventConfiguration[PlayPositionEvent.ILLEGAL_PLAYPOSITION.ordinal()] = this.nullPlayPositionEvent;
        this.logEventConfiguration[PlayPositionEvent.TO_LATE_PLAYPOSITION.ordinal()] = this.nullPlayPositionEvent;
    }

    PlayPositionLogEvent getPlayPositionLogEvent(PlayPositionEvent playPositionEvent) {
        return this.logEventConfiguration[playPositionEvent.ordinal()];
    }

    public PlayPositionLoggerConfiguration setPlayPositionLogEvent(PlayPositionEvent playPositionEvent, PlayPositionLogEvent playPositionLogEvent) {
        this.logEventConfiguration[playPositionEvent.ordinal()] = playPositionLogEvent;
        return this;
    }
}

