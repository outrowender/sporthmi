/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.RRListElement;

class DSINavigationDispatcher$40
extends CommandResponse {
    private final /* synthetic */ RRListElement[] val$dmRecentRoutesList;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$40(DSINavigationDispatcher dSINavigationDispatcher, RRListElement[] rRListElementArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$dmRecentRoutesList = rRListElementArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateDmRecentRoutesList(this.val$dmRecentRoutesList);
    }
}

