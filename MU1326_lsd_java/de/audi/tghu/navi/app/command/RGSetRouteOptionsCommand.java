/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.RouteOptions;

public class RGSetRouteOptionsCommand
extends NavCommand {
    private RouteOptions routeOptions;

    public RGSetRouteOptionsCommand(RouteOptions routeOptions) {
        this.routeOptions = routeOptions;
    }

    public void execute() {
        if (this.routeOptions != null) {
            this.logger.log(10000000, "RGSetRouteOptionsCommand#execute() - calling rgSetRouteOptions( %1 )", (Object)this.routeOptions);
            this.getDSINavigation().rgSetRouteOptions(this.routeOptions);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "RGSetRouteOptionsCommand#execute() - no route options set!");
            this.getCommandList().commandAborted("no route options");
        }
    }
}

