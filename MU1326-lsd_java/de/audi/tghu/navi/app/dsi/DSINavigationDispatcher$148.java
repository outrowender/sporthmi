/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;

class DSINavigationDispatcher$148
extends CommandResponse {
    private final /* synthetic */ NavLocationWgs84 val$position;
    private final /* synthetic */ boolean val$rubberbandPointAvailable;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$148(DSINavigationDispatcher dSINavigationDispatcher, NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$position = navLocationWgs84;
        this.val$rubberbandPointAvailable = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).rgGetRubberBandPointPositionResult(this.val$position, this.val$rubberbandPointAvailable);
    }
}

