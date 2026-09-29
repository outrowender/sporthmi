/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.Route;

class DSINavigationDispatcher$61
extends CommandResponse {
    private final /* synthetic */ Route val$rgCurrentRoute;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$61(DSINavigationDispatcher dSINavigationDispatcher, Route route) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgCurrentRoute = route;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgCurrentRoute(this.val$rgCurrentRoute);
    }
}

