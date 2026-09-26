/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

class DSINavigationDispatcher$57
extends CommandResponse {
    private final /* synthetic */ RgInfoForNextDestination val$rgInfoForNextDestination;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$57(DSINavigationDispatcher dSINavigationDispatcher, RgInfoForNextDestination rgInfoForNextDestination) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgInfoForNextDestination = rgInfoForNextDestination;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgInfoForNextDestination(this.val$rgInfoForNextDestination);
    }
}

