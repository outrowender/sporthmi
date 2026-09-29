/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.terminalmode;

public interface ITerminalModeSDSHandler {
    public static final int PTT_PRESSED;
    public static final int PTT_RELEASED_AFTER_SHORT_PRESS;
    public static final int PTT_LONG_DETECTED;
    public static final int PTT_RELEASED_AFTER_LONG_PRESS;

    default public boolean isTerminalModeDeviceActive() {
    }

    default public boolean isTerminalModeSpeechActive() {
    }
}

