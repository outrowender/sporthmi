/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

class DSINavigationDispatcher$51
extends CommandResponse {
    private final /* synthetic */ LIStreetHistoryEntry[] val$streetHistory;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$51(DSINavigationDispatcher dSINavigationDispatcher, LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$streetHistory = lIStreetHistoryEntryArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateLiStreetHistory(this.val$streetHistory);
    }
}

