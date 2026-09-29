/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.util.Enum;

public class PlaybackInfoChangedEvent$PlaybackState
extends Enum {
    public static final PlaybackInfoChangedEvent$PlaybackState STOPPED = new PlaybackInfoChangedEvent$PlaybackState("STOPPED");
    public static final PlaybackInfoChangedEvent$PlaybackState PLAYING = new PlaybackInfoChangedEvent$PlaybackState("PLAYING");
    public static final PlaybackInfoChangedEvent$PlaybackState PAUSED = new PlaybackInfoChangedEvent$PlaybackState("PAUSED");
    public static final PlaybackInfoChangedEvent$PlaybackState SEEKFORWARD = new PlaybackInfoChangedEvent$PlaybackState("SEEKFORWARD");
    public static final PlaybackInfoChangedEvent$PlaybackState SEEKBACKWARD = new PlaybackInfoChangedEvent$PlaybackState("SEEKBACKWARD");
    public static final PlaybackInfoChangedEvent$PlaybackState INVALID = new PlaybackInfoChangedEvent$PlaybackState("INVALID");

    private PlaybackInfoChangedEvent$PlaybackState(String string) {
        super(string);
    }
}

