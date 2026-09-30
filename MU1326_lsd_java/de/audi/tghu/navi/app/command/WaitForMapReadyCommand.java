/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.command.NavCommand;

public class WaitForMapReadyCommand
extends NavCommand {
    public static final int COMMAND_TIMEOUT = 10000;
    public static final int COMMAND_WATCHDOG_TIMEOUT = 5000;
    private Timer commandWatchdogTimer;

    public WaitForMapReadyCommand() {
        super("WaitForMapReadyCommand");
    }

    public void execute() {
        this.commandWatchdogTimer = new Timer("commandWatchdogTimer", 5000L, true, new TimerListener(){

            public void fireTimer(Timer timer) {
                WaitForMapReadyCommand.this.logger.log(10000, "WaitForMapReadyCommand#execute#fireTimer() - CommandWatchdogTimer fired - finish command!");
                WaitForMapReadyCommand.this.getCommandList().commandFinished();
            }

            public void cancelTimer(Timer timer) {
            }
        });
        this.commandWatchdogTimer.restart();
        this.navigation.getMapInterface().prepareRouteBriefingMap(this);
    }

    public void mapReadyCallBack() {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "WaitForMapReadyCommand#mapReadyCallBack() ");
        }
        this.cancelCommandWatchdogTimer();
        this.getCommandList().commandFinished();
    }

    public void abort() {
        this.cancelCommandWatchdogTimer();
        super.abort();
    }

    public long getTimeout() {
        return 10000L;
    }

    private void cancelCommandWatchdogTimer() {
        if (this.commandWatchdogTimer != null) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "WaitForMapReadyCommand#cancelCommandWatchdogTimer() ");
            }
            this.commandWatchdogTimer.cancel();
        }
    }
}

