/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaRouteUtil;
import org.dsi.ifc.navigation.Route;

public class RemoveViaPointsCommand
extends NavCommand {
    public void execute() {
        this.logger.log(10000000, "RemoveViaPointsCommand#execute()");
        Route route = this.navigation.getRouteManager().getRoute();
        if (route != null && ViaRouteUtil.isViaRoute(route)) {
            this.logger.log(10000000, "RemoveViaPointsCommand#execute() - found via points, stripping them from route");
            Route route2 = ViaRouteUtil.filterViaFromRoute(route);
            CommandList commandList = this.navigation.getCommandListFactory().createCommandList();
            commandList.add(new RmMakeRoutePersistentCommand(route2));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.logger.log(10000000, "RemoveViaPointsCommand#execute() - no via points found, do nothing");
            this.getCommandList().commandFinished();
        }
    }
}

