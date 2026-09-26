/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$35
extends CommandResponse {
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$35(DSINavigationDispatcher dSINavigationDispatcher) {
        this.this$0 = dSINavigationDispatcher;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).rgSetRouteGuidanceModeResult();
    }
}

