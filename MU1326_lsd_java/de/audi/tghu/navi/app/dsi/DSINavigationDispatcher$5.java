/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.Route;

class DSINavigationDispatcher$5
extends CommandResponse {
    private final /* synthetic */ long val$resultCode;
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$5(DSINavigationDispatcher dSINavigationDispatcher, long l, Route route) {
        this.this$0 = dSINavigationDispatcher;
        this.val$resultCode = l;
        this.val$route = route;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).dmRecentRoutesGetResult(this.val$resultCode, this.val$route);
    }
}

