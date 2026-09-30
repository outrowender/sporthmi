/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class ETCSetMetricSystemCommand
extends NavCommand {
    private int metricsSystem;

    public ETCSetMetricSystemCommand(int n) {
        this.metricsSystem = n;
    }

    public void execute() {
        this.logger.log(1000000, "ETCSetMetricSystemCommand#execute() - calling etcSetMetricSystem( %1 ) ", (long)this.metricsSystem);
        this.getDSINavigation().etcSetMetricSystem(this.metricsSystem);
        this.getCommandList().commandFinished();
    }
}

