/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$4
extends CommandResponse {
    private final /* synthetic */ long val$resultCode;
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$4(DSINavigationDispatcher dSINavigationDispatcher, long l, NavLocation navLocation) {
        this.this$0 = dSINavigationDispatcher;
        this.val$resultCode = l;
        this.val$destination = navLocation;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).dmLastDestinationsGetResult(this.val$resultCode, this.val$destination);
    }
}

