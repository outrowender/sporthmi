/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$23
extends CommandResponse {
    private final /* synthetic */ int val$rmRouteDeleteResultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$23(DSINavigationDispatcher dSINavigationDispatcher, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rmRouteDeleteResultCode = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).rmRouteDeleteResult(this.val$rmRouteDeleteResultCode);
    }
}

