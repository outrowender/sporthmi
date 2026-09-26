/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.storage;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class RmRouteAddCommand
extends NavCommand {
    private int rmID;
    private Route route;
    private String name;

    public RmRouteAddCommand(int n, Route route, String string) {
        this.rmID = n;
        this.route = route;
        this.name = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "RmRouteAddCommand#execute() - calling rmRouteAdd( %3, %1, %2 ) ", (Object)RouteUtil.formatRouteShort(this.route), (Object)this.name, (long)this.rmID);
        this.getDSINavigation().rmRouteAdd(this.rmID, this.route, this.name);
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        this.logger.log(-2137614336, "RmRouteAddCommand#rmRouteAddResult( %1, %2 ) ", (long)n, l);
        if (n == 0) {
            this.dsiResponseContainer.setAddedRouteId(l);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }
}

