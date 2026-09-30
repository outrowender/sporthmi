/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AudioState
extends Enum<AudioState> {
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

