/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.util.Enum;

public class PlayPositionEvent
extends Enum {
    public static final PlayPositionEvent STARTUP = new PlayPositionEvent(0, "STARTUP");
    public static final PlayPositionEvent PLAYBACK_STATE_CHANGED = new PlayPositionEvent(1, "PLAYBACK_STATE_CHANGED");
    public static final PlayPositionEvent TRACK_CHANGED = new PlayPositionEvent(2, "TRACK_CHANGED");
    public static final PlayPositionEvent ILLEGAL_PLAYPOSITION = new PlayPositionEvent(3, "ILLEGAL_PLAYPOSITION");
    public static final PlayPositionEvent TO_LATE_PLAYPOSITION = new PlayPositionEvent(4, "TO_LATE_PLAYPOSITION");
    private static final PlayPositionEvent[] internalList = new PlayPositionEvent[]{STARTUP, PLAYBACK_STATE_CHANGED, TRACK_CHANGED, ILLEGAL_PLAYPOSITION, TO_LATE_PLAYPOSITION};

    protected PlayPositionEvent(int n, String string) {
        super(n, string);
    }

    public static PlayPositionEvent[] values() {
        return (PlayPositionEvent[])internalList.clone();
    }
}

