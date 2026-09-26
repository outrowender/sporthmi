/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;

class DSINavigationDispatcher$73
extends CommandResponse {
    private final /* synthetic */ NavRmRouteListArrayData[] val$rmRouteList;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$73(DSINavigationDispatcher dSINavigationDispatcher, NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rmRouteList = navRmRouteListArrayDataArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRmRouteList(this.val$rmRouteList);
    }
}

