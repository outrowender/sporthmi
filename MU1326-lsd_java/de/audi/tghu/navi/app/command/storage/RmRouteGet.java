/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.storage;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class RmRouteGet
extends NavCommand {
    public static final String ROUTE_MEMORY_ID;
    public static final String ROUTE_ID;
    public static final String LOADED_ROUTE;
    private int rmID;
    private long routeId;

    public RmRouteGet(int n, long l) {
        this.rmID = n;
        this.routeId = l;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "RmRouteGet#execute() - calling rmRouteGet( rmID %1, routeId %2 ) ", (long)this.rmID, this.routeId);
        this.getDSINavigation().rmRouteGet(this.rmID, this.routeId);
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
        this.logger.log(-2137614336, "RmRouteGet#rmRouteGetResult( %2, %1 ) ", (Object)RouteUtil.formatRouteShort(route), (long)n);
        if (n == 0) {
            this.dsiResponseContainer.setRmRouteGet(route);
            this.getCommandList().put("ROUTE_MEMORY_ID", new Integer(this.rmID));
            this.getCommandList().put("ROUTE_ID", new Long(this.routeId));
            this.getCommandList().put("LOADED_ROUTE", route);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }
}

