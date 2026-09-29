/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavRouteListData;

class DSINavigationDispatcher$63
extends CommandResponse {
    private final /* synthetic */ NavRouteListData[] val$rgDestinationInfo;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$63(DSINavigationDispatcher dSINavigationDispatcher, NavRouteListData[] navRouteListDataArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgDestinationInfo = navRouteListDataArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgDestinationInfo(this.val$rgDestinationInfo);
    }
}

