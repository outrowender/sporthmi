/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class RgCalculate1stRouteAndPostponeRemainingCommand
extends NavCommand {
    private Route route;
    private int numberOfRoutes;
    private boolean resumeRoute;

    public RgCalculate1stRouteAndPostponeRemainingCommand(Route route, int n, boolean bl) {
        this.route = route;
        this.numberOfRoutes = n;
        this.resumeRoute = bl;
    }

    public void execute() {
        this.dsiResponseContainer.setIndexOfCalculatedRoutes(0);
        this.logger.log(10000000, "RgCalculate1stRouteAndPostponeRemainingCommand#execute() - calling rgCalculate1stRouteAndPostponeRemaining( %1, %2, %3 ) ", (Object)RouteUtil.formatRouteShort(this.route), (Object)Integer.toString(this.numberOfRoutes), (Object)Boolean.toString(this.resumeRoute));
        this.getDSINavigation().rgCalculate1stRouteAndPostponeRemaining(this.route, this.numberOfRoutes, this.resumeRoute);
        this.getCommandList().commandFinished();
    }

    public void rgResult(int n) {
        this.logger.log(10000000, "RgCalculate1stRouteAndPostponeRemainingCommand#rgResult( %1 )", (long)n);
    }
}

