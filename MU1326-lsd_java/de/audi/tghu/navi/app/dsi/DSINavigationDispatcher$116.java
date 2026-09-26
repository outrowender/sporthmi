/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavSegmentID;

class DSINavigationDispatcher$116
extends CommandResponse {
    private final /* synthetic */ NavSegmentID val$uidOfCalculatedRoute;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$116(DSINavigationDispatcher dSINavigationDispatcher, NavSegmentID navSegmentID, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$uidOfCalculatedRoute = navSegmentID;
        this.val$resultCode = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).rgStartGuidanceCalculatedRouteByUIDResult(this.val$uidOfCalculatedRoute, this.val$resultCode);
    }
}

