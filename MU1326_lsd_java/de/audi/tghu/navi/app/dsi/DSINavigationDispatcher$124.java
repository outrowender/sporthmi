/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$124
extends CommandResponse {
    private final /* synthetic */ boolean val$success;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$124(DSINavigationDispatcher dSINavigationDispatcher, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$success = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).rgSwitchToNextPossibleRoadResult(this.val$success);
    }
}

