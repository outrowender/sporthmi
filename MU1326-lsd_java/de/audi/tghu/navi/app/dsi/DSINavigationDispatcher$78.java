/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;

class DSINavigationDispatcher$78
extends CommandResponse {
    private final /* synthetic */ NavTraceMemoryUtilization val$trMemoryUtilization;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$78(DSINavigationDispatcher dSINavigationDispatcher, NavTraceMemoryUtilization navTraceMemoryUtilization) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trMemoryUtilization = navTraceMemoryUtilization;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateTrMemoryUtilization(this.val$trMemoryUtilization);
    }
}

