/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.WaitForMapReadyCommand$1;

public class WaitForMapReadyCommand
extends NavCommand {
    public static final int COMMAND_TIMEOUT;
    public static final int COMMAND_WATCHDOG_TIMEOUT;
    private Timer commandWatchdogTimer;

    public WaitForMapReadyCommand() {
        super("WaitForMapReadyCommand");
    }

    @Override
    public void execute() {
        this.commandWatchdogTimer = new Timer("commandWatchdogTimer", 0, true, new WaitForMapReadyCommand$1(this));
        this.commandWatchdogTimer.restart();
        this.navigation.getMapInterface().prepareRouteBriefingMap(this);
    }

    public void mapReadyCallBack() {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "WaitForMapReadyCommand#mapReadyCallBack() ");
        }
        this.cancelCommandWatchdogTimer();
        this.getCommandList().commandFinished();
    }

    @Override
    public void abort() {
        this.cancelCommandWatchdogTimer();
        super.abort();
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    private void cancelCommandWatchdogTimer() {
        if (this.commandWatchdogTimer != null) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "WaitForMapReadyCommand#cancelCommandWatchdogTimer() ");
            }
            this.commandWatchdogTimer.cancel();
        }
    }

    static /* synthetic */ LogChannel access$000(WaitForMapReadyCommand waitForMapReadyCommand) {
        return waitForMapReadyCommand.logger;
    }
}

