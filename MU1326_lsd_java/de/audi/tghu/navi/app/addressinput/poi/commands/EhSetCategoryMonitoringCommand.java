/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.navi.app.command.NavCommand;

public class EhSetCategoryMonitoringCommand
extends NavCommand {
    private final int[] categoryUid;
    private final boolean[] monitor;
    private final LogChannel logChannel;

    public EhSetCategoryMonitoringCommand(int[] nArray, boolean[] blArray, LogChannel logChannel) {
        this.categoryUid = nArray;
        this.monitor = blArray;
        this.logChannel = logChannel;
    }

    public void execute() {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(10000000, "EhSetCategoryMonitoringCommand#execute() - calling ehSetCategoryMonitoring(%1)", (Object)Util.arrayToString(this.categoryUid));
        }
        this.getDSINavigation().ehSetCategoryMonitoring(this.categoryUid, this.monitor);
    }

    public void ehResult(int n, int n2) {
        this.logChannel.log(10000000, "EhSetCategoryMonitoringCommand#ehResult( %1, %2 )", (long)n, (long)n2);
        if (n2 == 0) {
            this.logChannel.log(10000000, "   --> NAVRESULTCODE_OK");
            this.getCommandList().commandFinished();
        } else {
            this.logChannel.log(10000000, "   --> Not OK");
            this.getCommandList().commandAborted(n2);
        }
    }
}

