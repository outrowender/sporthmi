/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.translate;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.translate.TranslateRouteCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.util.RouteHelper;

public abstract class TranslateLocationCommand
extends TranslateRouteCommand {
    public TranslateLocationCommand(NavLocation navLocation) {
        super(navLocation == null ? null : TranslateLocationCommand.constructRouteToTranslate(navLocation));
    }

    public abstract CommandList handleTranslatedLocation(NavLocation var1);

    public void translateRouteResult(Route route) {
        if (this.handleTranslatedRoute(route)) {
            this.getCommandList().commandFinishedWithPostSequence(this.handleTranslatedLocation(this.getTranslatedLocation()));
        } else {
            this.getCommandList().commandAborted("translation not successful");
        }
    }

    private NavLocation getTranslatedLocation() {
        return RouteUtil.getFinalDestination(this.getTranslatedRoute());
    }

    protected static Route constructRouteToTranslate(NavLocation navLocation) {
        Route route = new Route();
        RouteHelper.addDestinationAtPosition(route, new RouteDestination(navLocation, new RouteOptions[]{new RouteOptions()}, 1), 0);
        return route;
    }
}

