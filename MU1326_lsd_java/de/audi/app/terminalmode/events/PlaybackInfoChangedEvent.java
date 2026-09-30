/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.util.Enum;
import de.esolutions.fw.util.commons.Buffer;

public class PlaybackInfoChangedEvent {
    private final PlaybackState state;

    public PlaybackInfoChangedEvent(PlaybackState playbackState) {
        this.state = playbackState;
    }

    public PlaybackState getState() {
        return this.state;
    }

    public String toString() {
        return new Buffer(100).append("PlaybackInfoChangedEvent [").append(this.state).append("]").toString();
    }

    public static class Builder {
        private PlaybackState state;

        public PlaybackInfoChangedEvent build() {
            return new PlaybackInfoChangedEvent(this.state);
        }

        public Builder setPlaybackState(PlaybackState playbackState) {
            this.state = playbackState;
            return this;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class PlaybackState
    extends Enum<PlaybackState> {
        public static final PlaybackState STOPPED = new PlaybackState("STOPPED");
        public static final PlaybackState PLAYING = new PlaybackState("PLAYING");
        public static final PlaybackState PAUSED = new PlaybackState("PAUSED");
        public static final PlaybackState SEEKFORWARD = new PlaybackState("SEEKFORWARD");
        public static final PlaybackState SEEKBACKWARD = new PlaybackState("SEEKBACKWARD");
        public static final PlaybackState INVALID = new PlaybackState("INVALID");

        private PlaybackState(String string) {
            super(string);
        }
    }
}

