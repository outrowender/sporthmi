/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavSegmentID;

class DSINavigationDispatcher$141
extends CommandResponse {
    private final /* synthetic */ NavSegmentID[] val$traceIDs;
    private final /* synthetic */ int val$trDataResult;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$141(DSINavigationDispatcher dSINavigationDispatcher, NavSegmentID[] navSegmentIDArray, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$traceIDs = navSegmentIDArray;
        this.val$trDataResult = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).trImportTrailsResult(this.val$traceIDs, this.val$trDataResult);
    }
}

