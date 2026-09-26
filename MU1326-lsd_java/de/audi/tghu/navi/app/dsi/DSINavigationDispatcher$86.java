/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.Route;

class DSINavigationDispatcher$86
extends CommandResponse {
    private final /* synthetic */ Route val$rmPersistentRoute;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$86(DSINavigationDispatcher dSINavigationDispatcher, Route route) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rmPersistentRoute = route;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRmPersistentRoute(this.val$rmPersistentRoute);
    }
}

