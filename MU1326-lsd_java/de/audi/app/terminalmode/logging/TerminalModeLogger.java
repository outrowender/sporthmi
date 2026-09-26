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

    @Override
    public LogChannel dsi() {
        return this.dsi;
    }

    @Override
    public LogChannel osgi() {
        return this.osgi;
    }

    @Override
    public LogChannel main() {
        return this.main;
    }

    @Override
    public LogChannel audio() {
        return this.audio;
    }

    @Override
    public LogChannel hmi() {
        return this.hmi;
    }

    @Override
    public LogChannel keypanel() {
        return this.keypanel;
    }

    @Override
    public LogChannel state() {
        return this.state;
    }

    @Override
    public LogChannel commandList() {
        return this.commandList;
    }

    @Override
    public LogChannel dispatcher() {
        return this.dispatcher;
    }
}

