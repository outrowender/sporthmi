/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$8
extends CommandResponse {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$8(DSINavigationDispatcher dSINavigationDispatcher, NavLocation navLocation) {
        this.this$0 = dSINavigationDispatcher;
        this.val$location = navLocation;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liGetLocationDescriptionTransformResult(this.val$location);
    }
}

