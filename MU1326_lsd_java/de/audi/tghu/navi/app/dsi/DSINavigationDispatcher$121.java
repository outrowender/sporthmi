/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.LIStateHistoryEntry;

class DSINavigationDispatcher$121
extends CommandResponse {
    private final /* synthetic */ LIStateHistoryEntry[] val$stateHistory;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$121(DSINavigationDispatcher dSINavigationDispatcher, LIStateHistoryEntry[] lIStateHistoryEntryArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$stateHistory = lIStateHistoryEntryArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateLiStateHistory(this.val$stateHistory);
    }
}

