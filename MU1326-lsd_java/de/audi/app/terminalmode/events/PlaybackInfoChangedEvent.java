/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;
import de.esolutions.fw.util.commons.Buffer;

public class PlaybackInfoChangedEvent {
    private final PlaybackInfoChangedEvent$PlaybackState state;

    public PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState playbackInfoChangedEvent$PlaybackState) {
        this.state = playbackInfoChangedEvent$PlaybackState;
    }

    public PlaybackInfoChangedEvent$PlaybackState getState() {
        return this.state;
    }

    public String toString() {
        return new Buffer(100).append("PlaybackInfoChangedEvent [").append(this.state).append("]").toString();
    }
}

