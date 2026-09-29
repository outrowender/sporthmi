/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$91
extends CommandResponse {
    private final /* synthetic */ boolean val$status;
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$91(DSINavigationDispatcher dSINavigationDispatcher, boolean bl, NavLocation navLocation) {
        this.this$0 = dSINavigationDispatcher;
        this.val$status = bl;
        this.val$navLocation = navLocation;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).streamToLocationResult(this.val$status, this.val$navLocation);
    }
}

