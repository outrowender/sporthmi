/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class EnableRgLaneGuidanceCommand
extends NavCommand {
    private boolean enable;

    public EnableRgLaneGuidanceCommand(boolean bl) {
        this.enable = bl;
    }

    public void execute() {
        this.logger.log(1000000, "EnableRgLaneGuidanceCommand#execute() - calling enableRgLaneGuidance( %1 ) ", this.enable);
        this.getDSINavigation().enableRgLaneGuidance(this.enable);
        this.getCommandList().commandFinished();
    }
}

