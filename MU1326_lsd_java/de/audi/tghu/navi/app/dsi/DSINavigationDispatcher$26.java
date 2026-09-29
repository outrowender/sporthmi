/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$26
extends CommandResponse {
    private final /* synthetic */ int val$rmID;
    private final /* synthetic */ long val$routeID;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$26(DSINavigationDispatcher dSINavigationDispatcher, int n, long l, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rmID = n;
        this.val$routeID = l;
        this.val$resultCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).rmRouteReplaceResult(this.val$rmID, this.val$routeID, this.val$resultCode);
    }
}

