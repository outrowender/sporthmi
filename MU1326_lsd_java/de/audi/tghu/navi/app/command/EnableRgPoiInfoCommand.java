/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class EnableRgPoiInfoCommand
extends NavCommand {
    private boolean enable;

    public EnableRgPoiInfoCommand(boolean bl) {
        this.enable = bl;
    }

    public void execute() {
        this.logger.log(1000000, "EnableRgPoiInfoCommand#execute() - calling enableRgPoiInfo( %1 ) ", this.enable);
        if (this.getDSINavigation() != null) {
            this.getDSINavigation().enableRgPoiInfo(this.enable);
        }
        this.dsiResponseContainer.setEnableRgPoiInfo(this.enable);
        this.getCommandList().commandFinished();
    }
}

