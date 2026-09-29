/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.translate;

import de.audi.tghu.navi.app.command.translate.TranslateRouteCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class TranslateTourCommand
extends TranslateRouteCommand {
    public TranslateTourCommand() {
        super((Route)null);
    }

    @Override
    public void execute() {
        Route route = (Route)this.getCommandList().get("LOADED_ROUTE");
        this.logger.log(-2137614336, "TranslateTourCommand#execute() - %1", (Object)RouteUtil.formatRouteShort(route));
        if (route == null) {
            this.logger.log(-1601830656, "TranslateTourCommand#execute() - loaded route not set! Translation not possible!");
            this.getCommandList().commandAborted("loaded route not set");
        } else {
            this.setRouteToTranslate(route);
            super.execute();
        }
    }

    @Override
    public void translateRouteResult(Route route) {
        if (this.handleTranslatedRoute(route)) {
            Integer n = (Integer)this.getCommandList().get("TOUR_INDEX");
            Integer n2 = (Integer)this.getCommandList().get("ROUTE_MEMORY_ID");
            Long l = (Long)this.getCommandList().get("ROUTE_ID");
            this.navigation.getTourHandler().showTour(n, n2, l, route);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("translation not successful");
        }
    }
}

