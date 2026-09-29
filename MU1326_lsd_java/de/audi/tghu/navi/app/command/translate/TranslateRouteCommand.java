/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.translate;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

public class TranslateRouteCommand
extends NavCommand {
    public static final String TRANSLATED_ROUTE;
    protected Route route;
    protected Route translatedRoute;

    public TranslateRouteCommand(Route route) {
        this.setRouteToTranslate(route);
    }

    protected final void setRouteToTranslate(Route route) {
        this.route = route;
    }

    @Override
    public void execute() {
        if (this.route == null) {
            this.logger.log(-1601830656, "TranslateRouteCommand#execute() - given route is null! Translation not possible!");
            this.getCommandList().commandAborted("route is null");
        } else {
            this.logger.log(-2137614336, "TranslateRouteCommand#execute() - calling translateRoute( %1 )", (Object)RouteUtil.formatRouteShort(this.route));
            this.getDSINavigation().translateRoute(this.route);
        }
    }

    @Override
    public void translateRouteResult(Route route) {
        this.logger.log(-2137614336, "TranslateRouteCommand#translateRouteResult( %1 )", (Object)RouteUtil.formatRouteShort(route));
        if (this.handleTranslatedRoute(route)) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("translation not successful");
        }
    }

    protected boolean handleTranslatedRoute(Route route) {
        boolean bl;
        this.logger.log(-2137614336, "TranslateRouteCommand#handleTranslatedRoute( %1 )", (Object)RouteUtil.formatRouteShort(route));
        if (RouteUtil.getRouteLength(this.route) == RouteUtil.getRouteLength(route)) {
            this.getCommandList().put("TRANSLATED_ROUTE", route);
            bl = true;
        } else {
            this.logger.log(-2137614336, "TranslateRouteCommand#handleTranslatedRoute() - route length mismatch");
            bl = false;
        }
        return bl;
    }

    protected Route getTranslatedRoute() {
        return (Route)this.getCommandList().get("TRANSLATED_ROUTE");
    }
}

