/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.Route;

public class RmMakeRoutePersistentCommand
extends NavCommand {
    private Route persistentRoute;

    public RmMakeRoutePersistentCommand(Route route) {
        this.persistentRoute = route;
    }

    @Override
    public void execute() {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "RmMakeRoutePersistentCommand#execute() - calling rmMakeRoutePersistent( %1 )", (Object)RouteUtil.formatRouteShort(this.persistentRoute));
        }
        this.getDSINavigation().rmMakeRoutePersistent(this.persistentRoute);
    }

    @Override
    public void updateRmPersistentRoute(Route route) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "RmMakeRoutePersistentCommand#updateRmPersistentRoute() - rmPersistentRoute: %1", (Object)RouteUtil.formatRouteShort(route));
        }
        super.updateRmPersistentRoute(route);
        if (route != null) {
            int n = RouteUtil.getRouteLength(this.persistentRoute);
            int n2 = RouteUtil.getRouteLength(route);
            long l = RouteUtil.getIndexOfCurrentDestination(this.persistentRoute);
            long l2 = RouteUtil.getIndexOfCurrentDestination(route);
            if (n != n2 || l != l2) {
                Buffer buffer = new Buffer();
                buffer.append("(length: ").append(n).append(" -> ").append(n2).append(", index: ").append(l).append(" -> ").append(l2);
                this.logger.log(-1601830656, "RmMakeRoutePersistentCommand#updateRmPersistentRoute() - invalid route received! (%1) ", (Object)buffer);
            }
        } else {
            this.logger.log(-1601830656, "RmMakeRoutePersistentCommand#updateRmPersistentRoute() - received route is null!");
        }
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
        this.logger.log(-2137614336, "RmMakeRoutePersistentCommand#rmMakeRoutePersistentResult( %1 )", l);
        if (l == 0L) {
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(-1601830656, "RmMakeRoutePersistentCommand#rmMakeRoutePersistentResult() - Could not persist route. ResultCode = %1!", l);
            this.getCommandList().commandAborted(l);
        }
    }
}

