/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;

class DSINavigationDispatcher$140
extends CommandResponse {
    private final /* synthetic */ long[] val$uids;
    private final /* synthetic */ NavRectangle val$boundingBoxOfCombinedRouteListElements;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$140(DSINavigationDispatcher dSINavigationDispatcher, long[] lArray, NavRectangle navRectangle) {
        this.this$0 = dSINavigationDispatcher;
        this.val$uids = lArray;
        this.val$boundingBoxOfCombinedRouteListElements = navRectangle;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).getBoundingRectangleOfCombinedRouteListElementsResult(this.val$uids, this.val$boundingBoxOfCombinedRouteListElements);
    }
}

