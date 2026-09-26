/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$15
extends CommandResponse {
    private final /* synthetic */ NavLocation val$street;
    private final /* synthetic */ boolean val$entryUnchanged;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$15(DSINavigationDispatcher dSINavigationDispatcher, NavLocation navLocation, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$street = navLocation;
        this.val$entryUnchanged = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liGetLastStreetHistoryEntryResult(this.val$street, this.val$entryUnchanged);
    }
}

