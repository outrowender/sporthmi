/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$21
extends CommandResponse {
    private final /* synthetic */ int val$rmRouteAddResultCode;
    private final /* synthetic */ long val$routeId;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$21(DSINavigationDispatcher dSINavigationDispatcher, int n, long l) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rmRouteAddResultCode = n;
        this.val$routeId = l;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).rmRouteAddResult(this.val$rmRouteAddResultCode, this.val$routeId);
    }
}

