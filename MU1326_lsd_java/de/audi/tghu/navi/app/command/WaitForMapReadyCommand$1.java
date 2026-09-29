/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;

class WaitForMapReadyCommand$1
implements TimerListener {
    private final /* synthetic */ WaitForMapReadyCommand this$0;

    WaitForMapReadyCommand$1(WaitForMapReadyCommand waitForMapReadyCommand) {
        this.this$0 = waitForMapReadyCommand;
    }

    @Override
    public void fireTimer(Timer timer) {
        WaitForMapReadyCommand.access$000(this.this$0).log(10000, "WaitForMapReadyCommand#execute#fireTimer() - CommandWatchdogTimer fired - finish command!");
        this.this$0.getCommandList().commandFinished();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

