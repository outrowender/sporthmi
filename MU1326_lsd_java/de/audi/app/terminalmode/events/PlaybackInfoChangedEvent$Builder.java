/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;

public class PlaybackInfoChangedEvent$Builder {
    private PlaybackInfoChangedEvent$PlaybackState state;

    public PlaybackInfoChangedEvent build() {
        return new PlaybackInfoChangedEvent(this.state);
    }

    public PlaybackInfoChangedEvent$Builder setPlaybackState(PlaybackInfoChangedEvent$PlaybackState playbackInfoChangedEvent$PlaybackState) {
        this.state = playbackInfoChangedEvent$PlaybackState;
        return this;
    }
}

