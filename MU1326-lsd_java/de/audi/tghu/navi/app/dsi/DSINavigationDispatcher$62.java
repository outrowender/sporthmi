/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.RouteOptions;

class DSINavigationDispatcher$62
extends CommandResponse {
    private final /* synthetic */ RouteOptions val$rgCurrentRouteOptions;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$62(DSINavigationDispatcher dSINavigationDispatcher, RouteOptions routeOptions) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgCurrentRouteOptions = routeOptions;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgCurrentRouteOptions(this.val$rgCurrentRouteOptions);
    }
}

