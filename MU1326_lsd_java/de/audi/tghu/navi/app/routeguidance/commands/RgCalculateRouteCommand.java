/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class RgCalculateRouteCommand
extends NavCommand {
    private Route route;
    private int numberOfRoutes;

    public RgCalculateRouteCommand(Route route, int n) {
        this.route = route;
        this.numberOfRoutes = n;
    }

    public void execute() {
        this.dsiResponseContainer.setIndexOfCalculatedRoutes(0);
        this.logger.log(10000000, "RgCalculateRouteCommand#execute() - calling rgCalculateRoute( %1, %2 ) ", (Object)RouteUtil.formatRouteShort(this.route), (long)this.numberOfRoutes);
        this.getDSINavigation().rgCalculateRoute(this.route, this.numberOfRoutes);
        this.getCommandList().commandFinished();
    }

    public void rgNotPossible(int n) {
        this.logger.log(10000, "RgCalculateRouteCommand#rgNotPossible() - route could not be calculated ( %1 )!", (long)n);
        this.getCommandList().commandAborted(n);
        super.rgNotPossible(n);
    }
}

