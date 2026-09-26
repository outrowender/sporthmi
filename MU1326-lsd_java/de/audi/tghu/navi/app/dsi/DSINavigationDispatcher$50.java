/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.LICityHistoryEntry;

class DSINavigationDispatcher$50
extends CommandResponse {
    private final /* synthetic */ LICityHistoryEntry[] val$cityHistory;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$50(DSINavigationDispatcher dSINavigationDispatcher, LICityHistoryEntry[] lICityHistoryEntryArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$cityHistory = lICityHistoryEntryArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateLiCityHistory(this.val$cityHistory);
    }
}

