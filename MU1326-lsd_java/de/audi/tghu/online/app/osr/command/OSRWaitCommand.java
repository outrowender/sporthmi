/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRServiceState;

public class OSRWaitCommand
extends AbstractOSRCommand
implements TimerListener {
    private Timer waitTimer;
    private long waitTime;

    public OSRWaitCommand(long l) {
        this.waitTime = l;
        this.waitTimer = new Timer("ORSWaitTimer", l, true, this);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ORSWaitCommand#execute] starting timer for  %1 ms...", this.waitTime);
        this.waitTimer.restart();
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.log(-2137614336, "[ORSWaitCommand#fireTimer] wait finished");
        this.waitTimer = null;
        this.commandList.commandFinished();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

