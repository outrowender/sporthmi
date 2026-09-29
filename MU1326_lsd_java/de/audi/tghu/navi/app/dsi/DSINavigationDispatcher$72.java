/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.RouteOptions;

class DSINavigationDispatcher$72
extends CommandResponse {
    private final /* synthetic */ RouteOptions val$rgUnfulfilledRouteOptions;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$72(DSINavigationDispatcher dSINavigationDispatcher, RouteOptions routeOptions) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgUnfulfilledRouteOptions = routeOptions;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgUnfulfilledRouteOptions(this.val$rgUnfulfilledRouteOptions);
    }
}

