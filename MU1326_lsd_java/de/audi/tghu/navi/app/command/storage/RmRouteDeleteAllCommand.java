/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.storage;

import de.audi.tghu.navi.app.command.NavCommand;

public class RmRouteDeleteAllCommand
extends NavCommand {
    private int rmID;

    public RmRouteDeleteAllCommand(int n) {
        this.rmID = n;
    }

    public void execute() {
        this.logger.log(10000000, "RmRouteDeleteAllCommand#execute() - calling rmRouteDeleteAll( %1 ) ", (long)this.rmID);
        this.getDSINavigation().rmRouteDeleteAll(this.rmID);
    }

    public void rmRouteDeleteAllResult(int n) {
        this.logger.log(10000000, "RmRouteDeleteAllCommand#rmRouteDeleteAllResult( %1 ) ", (long)n);
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }
}

