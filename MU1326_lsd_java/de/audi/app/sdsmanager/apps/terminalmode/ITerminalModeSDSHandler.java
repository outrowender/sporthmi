/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.terminalmode;

public interface ITerminalModeSDSHandler {
    public static final int PTT_PRESSED = 0;
    public static final int PTT_RELEASED_AFTER_SHORT_PRESS = 1;
    public static final int PTT_LONG_DETECTED = 2;
    public static final int PTT_RELEASED_AFTER_LONG_PRESS = 3;

    public boolean isTerminalModeDeviceActive();

    public boolean isTerminalModeSpeechActive();
}

