/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$92
extends CommandResponse {
    private final /* synthetic */ int val$rgRouteCalculationState;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$92(DSINavigationDispatcher dSINavigationDispatcher, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgRouteCalculationState = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgRouteCalculationState(this.val$rgRouteCalculationState);
    }
}

