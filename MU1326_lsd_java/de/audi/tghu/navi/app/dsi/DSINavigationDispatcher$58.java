/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.RouteProperties;

class DSINavigationDispatcher$58
extends CommandResponse {
    private final /* synthetic */ RouteProperties val$routeProperties;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$58(DSINavigationDispatcher dSINavigationDispatcher, RouteProperties routeProperties) {
        this.this$0 = dSINavigationDispatcher;
        this.val$routeProperties = routeProperties;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgRouteProperties(this.val$routeProperties);
    }
}

