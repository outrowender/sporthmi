/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$150
extends CommandResponse {
    private final /* synthetic */ int val$listIndex;
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$150(DSINavigationDispatcher dSINavigationDispatcher, int n, NavLocation navLocation) {
        this.this$0 = dSINavigationDispatcher;
        this.val$listIndex = n;
        this.val$location = navLocation;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).lispGetLocationFromLiValueListResult(this.val$listIndex, this.val$location);
    }
}

