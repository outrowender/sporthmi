/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavTraceListData;

class DSINavigationDispatcher$81
extends CommandResponse {
    private final /* synthetic */ NavTraceListData[] val$trTraceList;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$81(DSINavigationDispatcher dSINavigationDispatcher, NavTraceListData[] navTraceListDataArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trTraceList = navTraceListDataArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateTrTraceList(this.val$trTraceList);
    }
}

