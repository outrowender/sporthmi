/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.util.Enum;

public class AudioState
extends Enum {
    public static final AudioState UNKNOWN = new AudioState(-1, "UNKNOWN");
    public static final AudioState UNDEFINED = new AudioState(0, "UNDEFINED");
    public static final AudioState STARTED = new AudioState(1, "STARTED");
    public static final AudioState PAUSED = new AudioState(2, "PAUSED");
    public static final AudioState FADEDIN = new AudioState(3, "FADEDIN");
    public static final AudioState STOPPED = new AudioState(4, "STOPPED");
    public static final AudioState ERROR = new AudioState(5, "ERROR");
    public static final AudioState RELEASED = new AudioState(6, "RELEASED");

    protected AudioState(int n, String string) {
        super(n, string);
    }
}

