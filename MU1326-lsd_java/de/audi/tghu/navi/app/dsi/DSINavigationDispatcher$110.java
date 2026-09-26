/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$110
extends CommandResponse {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$110(DSINavigationDispatcher dSINavigationDispatcher, NavLocation navLocation, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$navLocation = navLocation;
        this.val$resultCode = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liSelectViaPointResult(this.val$navLocation, this.val$resultCode);
    }
}

