/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.atip.log.LogChannel;

public interface ITerminalLogger {
    public static final String TM_LOG_CHANNEL_ROOT;

    default public LogChannel dsi() {
    }

    default public LogChannel osgi() {
    }

    default public LogChannel main() {
    }

    default public LogChannel audio() {
    }

    default public LogChannel keypanel() {
    }

    default public LogChannel hmi() {
    }

    default public LogChannel state() {
    }

    default public LogChannel commandList() {
    }

    default public LogChannel dispatcher() {
    }
}

