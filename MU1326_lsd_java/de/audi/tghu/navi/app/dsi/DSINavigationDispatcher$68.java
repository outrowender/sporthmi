/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavRouteListData;

class DSINavigationDispatcher$68
extends CommandResponse {
    private final /* synthetic */ NavRouteListData[] val$rgStreetList;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$68(DSINavigationDispatcher dSINavigationDispatcher, NavRouteListData[] navRouteListDataArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgStreetList = navRouteListDataArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgStreetList(this.val$rgStreetList);
    }
}

