/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class RGSetRouteGuidanceMode
extends NavCommand {
    private int mode;

    public RGSetRouteGuidanceMode(int n) {
        this.mode = n;
    }

    public void execute() {
        this.logger.log(10000000, "RGSetRouteGuidanceMode#execute() - calling rgSetRouteGuidanceMode( %1 ) ", (long)this.mode);
        this.getDSINavigation().rgSetRouteGuidanceMode(this.mode);
    }

    public void rgSetRouteGuidanceModeResult() {
        this.logger.log(10000000, "RGSetRouteGuidanceMode#rgSetRouteGuidanceModeResult() ");
        this.getCommandList().commandFinished();
    }
}

