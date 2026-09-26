/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class TrDeleteAllTraces
extends NavCommand {
    @Override
    public void execute() {
        this.getDSINavigation().trDeleteAllTraces();
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
        this.logger.log(-2137614336, "TrDeleteAllTraces#trDeleteAllTracesResult( trDeleteAllTracesResultCode: %1, errorCode: %2 )", (long)n, (long)n2);
        if (n != 0) {
            this.getCommandList().commandAborted(n2);
        }
        this.getCommandList().commandFinished();
    }
}

