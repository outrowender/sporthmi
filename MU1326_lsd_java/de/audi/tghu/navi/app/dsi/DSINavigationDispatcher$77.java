/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$77
extends CommandResponse {
    private final /* synthetic */ NavLocation val$soPosPositionDescription;
    private final /* synthetic */ boolean val$inProgressData;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$77(DSINavigationDispatcher dSINavigationDispatcher, NavLocation navLocation, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$soPosPositionDescription = navLocation;
        this.val$inProgressData = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateSoPosPositionDescription(this.val$soPosPositionDescription, this.val$inProgressData);
    }
}

