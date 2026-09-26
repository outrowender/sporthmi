/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.storage;

import de.audi.tghu.navi.app.command.NavCommand;

public class RmRouteDeleteCommand
extends NavCommand {
    private int rmID;
    private long routeID;

    public RmRouteDeleteCommand(int n, long l) {
        this.rmID = n;
        this.routeID = l;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "RmRouteDeleteCommand#execute() - calling rmRouteDelete( %1, %2 ) ", (long)this.rmID, this.routeID);
        this.getDSINavigation().rmRouteDelete(this.rmID, this.routeID);
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        this.logger.log(-2137614336, "RmRouteDeleteCommand#rmRouteDeleteResult( %1 ) ", (long)n);
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }
}

