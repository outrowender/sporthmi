/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class TerminalModeLogger
implements ITerminalLogger {
    private final LogChannel dsi;
    private final LogChannel osgi;
    private final LogChannel main;
    private final LogChannel audio;
    private final LogChannel hmi;
    private final LogChannel keypanel;
    private final LogChannel state;
    private final LogChannel commandList;
    private final LogChannel dispatcher;

    public TerminalModeLogger(IFrameworkAccess iFrameworkAccess) {
        this.osgi = iFrameworkAccess.getLogChannel("App.TerminalMode.OSGI");
        this.dsi = iFrameworkAccess.getLogChannel("App.TerminalMode.DSI");
        this.main = iFrameworkAccess.getLogChannel("App.TerminalMode.Main");
        this.audio = iFrameworkAccess.getLogChannel("App.TerminalMode.Audio");
        this.hmi = iFrameworkAccess.getLogChannel("App.TerminalMode.HMI");
        this.keypanel = iFrameworkAccess.getLogChannel("App.TerminalMode.Keypanel");
        this.state = iFrameworkAccess.getLogChannel("App.TerminalMode.State");
        this.commandList = iFrameworkAccess.getLogChannel("App.TerminalMode.CommandList");
        this.dispatcher = iFrameworkAccess.getLogChannel("App.TerminalMode.Dispatcher");
    }

    public LogChannel dsi() {
        return this.dsi;
    }

    public LogChannel osgi() {
        return this.osgi;
    }

    public LogChannel main() {
        return this.main;
    }

    public LogChannel audio() {
        return this.audio;
    }

    public LogChannel hmi() {
        return this.hmi;
    }

    public LogChannel keypanel() {
        return this.keypanel;
    }

    public LogChannel state() {
        return this.state;
    }

    public LogChannel commandList() {
        return this.commandList;
    }

    public LogChannel dispatcher() {
        return this.dispatcher;
    }
}

