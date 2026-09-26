/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavSegmentID;

class DSINavigationDispatcher$34
extends CommandResponse {
    private final /* synthetic */ int val$trStoreTraceResultCode;
    private final /* synthetic */ NavSegmentID val$segmentID;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$34(DSINavigationDispatcher dSINavigationDispatcher, int n, NavSegmentID navSegmentID, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trStoreTraceResultCode = n;
        this.val$segmentID = navSegmentID;
        this.val$errorCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).trStoreTraceResult(this.val$trStoreTraceResultCode, this.val$segmentID, this.val$errorCode);
    }
}

