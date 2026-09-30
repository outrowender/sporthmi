/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class ETCSetDemoModeSpeed
extends NavCommand {
    private long etcDemoModeSpeed;

    public ETCSetDemoModeSpeed(long l) {
        this.etcDemoModeSpeed = l;
    }

    public void execute() {
        this.logger.log(1000000, "ETCSetDemoModeSpeed#execute() - calling etcSetDemoModeSpeed( %1 ) ", this.etcDemoModeSpeed);
        this.getDSINavigation().etcSetDemoModeSpeed(this.etcDemoModeSpeed);
        this.getCommandList().commandFinished();
    }
}

