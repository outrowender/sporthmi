/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class RGCalculateRoute
extends NavCommand {
    private Route route;
    private int numberOfRoutes;
    private boolean prepareMap;
    private boolean singleRouteMode;

    public RGCalculateRoute(Route route, int n, boolean bl) {
        this.route = route;
        this.numberOfRoutes = n;
        this.prepareMap = bl;
        this.singleRouteMode = n <= 1;
    }

    public void execute() {
        this.dsiResponseContainer.setIndexOfCalculatedRoutes(0);
        this.navigation.getDemoModeManager().setDemoModeRoute(this.route);
        this.navigation.getMapInterface().startRouteCalculation(this.route, this.numberOfRoutes, this.prepareMap, false, false);
        this.logger.log(10000000, "RGCalculateRoute#execute() - calling rgCalculateRoute( %1, %2 ) ", (Object)RouteUtil.formatRouteShort(this.route), (long)this.numberOfRoutes);
        this.getDSINavigation().rgCalculateRoute(this.route, this.numberOfRoutes);
        this.getCommandList().commandFinished();
    }

    public void rgNotPossible(int n) {
        this.logger.log(10000, "RGCalculateRoute#rgNotPossible() - route could not be calculated ( %1 )!", (long)n);
        this.getCommandList().commandAborted(n);
        super.rgNotPossible(n);
    }
}

