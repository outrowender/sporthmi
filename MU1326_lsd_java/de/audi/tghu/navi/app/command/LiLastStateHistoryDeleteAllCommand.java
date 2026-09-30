/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class LiLastStateHistoryDeleteAllCommand
extends NavCommand {
    public void execute() {
        this.logger.log(10000000, "LiLastStateHistoryDeleteAllCommand#execute() - calling liLastStateHistoryDeleteAll() ");
        this.getDSINavigation().liLastStateHistoryDeleteAll();
    }

    public void liHistoryResult(long l) {
        if (l == 0L) {
            this.logger.log(10000000, "LiLastStateHistoryDeleteAllCommand#liHistoryResult()");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LiLastStateHistoryDeleteAllCommand#liHistoryResult() - commandAborted");
            this.getCommandList().commandAborted(l);
        }
    }
}

