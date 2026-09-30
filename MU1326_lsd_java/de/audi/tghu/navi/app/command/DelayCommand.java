/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.command.NavCommand;

public class DelayCommand
extends NavCommand {
    protected Timer timer;
    private long delay;

    public DelayCommand(long l) {
        this.delay = l;
    }

    public long getTimeout() {
        return super.getTimeout() + (this.delay > 0L ? this.delay : 0L);
    }

    public void execute() {
        this.logger.log(10000000, "DelayCommand#execute() - delay: %1ms ", this.delay);
        if (this.delay > 0L) {
            this.timer = new Timer("DelayCommandTimer", this.delay, true, this.getDispatcher());
            this.timer.start();
        } else {
            this.getCommandList().commandFinished();
        }
    }

    public void abort() {
        this.logger.log(10000000, "DelayCommand#abort()");
        if (this.timer != null) {
            this.timer.cancel();
        }
    }

    public void fireTimer(Timer timer) {
        this.logger.log(10000000, "DelayCommand#fireTimer() ");
        if (timer == this.timer) {
            this.getCommandList().commandFinished();
        }
    }
}

