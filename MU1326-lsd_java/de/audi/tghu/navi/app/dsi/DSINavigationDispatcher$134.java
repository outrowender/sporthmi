/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$134
extends CommandResponse {
    private final /* synthetic */ int val$naviCoreAvailableToSetBlocks;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$134(DSINavigationDispatcher dSINavigationDispatcher, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$naviCoreAvailableToSetBlocks = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateNaviCoreAvailableToSetBlocks(this.val$naviCoreAvailableToSetBlocks);
    }
}

