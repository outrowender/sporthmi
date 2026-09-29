/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class LiLastCityOrStreetHistoryDeleteAllCommand
extends NavCommand {
    public static final int TYPE_CITY;
    public static final int TYPE_STREET;
    private int type;

    public LiLastCityOrStreetHistoryDeleteAllCommand(int n) {
        this.type = n;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "LiLastCityHistoryDeleteAllCommand#execute() - calling liLastCityHistoryDeleteAll() ");
        if (this.type == 0) {
            this.getDSINavigation().liLastCityHistoryDeleteAll();
        } else {
            this.getDSINavigation().liLastStreetHistoryDeleteAll();
        }
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        if (l == 0L) {
            this.logger.log(-2137614336, "LiLastCityHistoryDeleteAllCommand#liLastCityAndStreetHistoryResult()");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LiLastCityHistoryDeleteAllCommand#liLastCityAndStreetHistoryResult() - commandAborted");
            this.getCommandList().commandAborted(l);
        }
    }
}

