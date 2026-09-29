/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.Route;

class DSINavigationDispatcher$28
extends CommandResponse {
    private final /* synthetic */ Route val$navRoute;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$28(DSINavigationDispatcher dSINavigationDispatcher, Route route) {
        this.this$0 = dSINavigationDispatcher;
        this.val$navRoute = route;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).translateRouteResult(this.val$navRoute);
    }
}

