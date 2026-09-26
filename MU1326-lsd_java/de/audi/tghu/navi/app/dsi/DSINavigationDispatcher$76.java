/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.PosPosition;

class DSINavigationDispatcher$76
extends CommandResponse {
    private final /* synthetic */ PosPosition val$soPosPosition;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$76(DSINavigationDispatcher dSINavigationDispatcher, PosPosition posPosition) {
        this.this$0 = dSINavigationDispatcher;
        this.val$soPosPosition = posPosition;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateSoPosPosition(this.val$soPosPosition);
    }
}

