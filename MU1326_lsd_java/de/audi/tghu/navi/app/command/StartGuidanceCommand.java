/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGCalculateRoute;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

public class StartGuidanceCommand
extends NavCommand {
    public static final int ALT_ROUTES_ALLOW;
    public static final int ALT_ROUTES_ENABLE;
    public static final int ALT_ROUTES_DISABLE;
    private int altRoutesState;
    private boolean prepareMap;
    private boolean tryResume;

    public StartGuidanceCommand(int n, boolean bl, boolean bl2) {
        this.altRoutesState = n;
        this.prepareMap = bl;
        this.tryResume = bl2;
    }

    @Override
    public void execute() {
        Route route = this.navigation.getRouteManager().getRoute();
        int n = RouteUtil.getRouteLength(route);
        if (n == 0) {
            String string = "current on-road route is null!";
            this.logger.log(-1601830656, "StartGuidanceCommand#execute() - %1 ", (Object)string);
            this.getCommandList().commandAborted(string);
        } else {
            CommandList commandList = this.navigation.getCommandListFactory().createCommandList();
            int n2 = RouteUtil.getRouteID(route);
            if (n2 == 0) {
                RouteOptions routeOptions = this.navigation.getRouteCriteriaManager().getRouteCriteria().getRouteOptions(true)[0];
                Route route2 = null;
                this.logger.log(-2137614336, "StartGuidanceCommand#execute() - configuredRouteOptions: %1, routeLength: %2", (Object)routeOptions, (long)n);
                if (n == 1 && (this.altRoutesState == 1 || this.altRoutesState == 0)) {
                    RouteOptions[] routeOptionsArray = new RouteOptions[3];
                    for (int i2 = 0; i2 < routeOptionsArray.length; ++i2) {
                        routeOptionsArray[i2] = routeOptions;
                    }
                    route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                    commandList.add(new RGCalculateRoute(route2, 3, this.prepareMap));
                } else {
                    route2 = RouteUtil.cloneRoute(route, new RouteOptions[]{routeOptions});
                    boolean bl = this.tryResume && this.dsiResponseContainer.isRouteResumePossible();
                    commandList.add(new RGCalculateRoute(route2, bl ? 0 : 1, this.prepareMap));
                }
            } else {
                this.logger.log(10000, "StartGuidanceCommand#execute() - only ROUTEID_ONROAD supported, not %1 !", (long)n2);
            }
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

