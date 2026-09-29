/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

class DSINavigationDispatcher$60
extends CommandResponse {
    private final /* synthetic */ CalculatedRouteListElement[] val$rgCalculatedRoutes;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$60(DSINavigationDispatcher dSINavigationDispatcher, CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgCalculatedRoutes = calculatedRouteListElementArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgCalculatedRoutes(this.val$rgCalculatedRoutes);
    }
}

