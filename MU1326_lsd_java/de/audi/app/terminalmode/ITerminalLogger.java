/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.util.Enum;
import de.audi.atip.log.LogChannel;

public interface ITerminalLogger {
    public static final String TM_LOG_CHANNEL_ROOT = "App.TerminalMode";

    public LogChannel dsi();

    public LogChannel osgi();

    public LogChannel main();

    public LogChannel audio();

    public LogChannel keypanel();

    public LogChannel hmi();

    public LogChannel state();

    public LogChannel commandList();

    public LogChannel dispatcher();

    public static class LogScope
    extends Enum {
        public static final LogScope HMI = new LogScope("HMI");

        private LogScope(String string) {
            super(string);
        }
    }
}

