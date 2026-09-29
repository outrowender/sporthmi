/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.CombinedRouteListElement;

class DSINavigationDispatcher$135
extends CommandResponse {
    private final /* synthetic */ long val$usedAnchorId;
    private final /* synthetic */ CombinedRouteListElement[] val$combinedRouteListElements;
    private final /* synthetic */ int val$positionOfFirstListElement;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$135(DSINavigationDispatcher dSINavigationDispatcher, long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$usedAnchorId = l;
        this.val$combinedRouteListElements = combinedRouteListElementArray;
        this.val$positionOfFirstListElement = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).combinedRouteListResult(this.val$usedAnchorId, this.val$combinedRouteListElements, this.val$positionOfFirstListElement);
    }
}

