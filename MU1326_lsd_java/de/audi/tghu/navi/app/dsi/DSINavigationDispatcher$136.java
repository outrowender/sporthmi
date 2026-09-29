/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavPoiInfo;

class DSINavigationDispatcher$136
extends CommandResponse {
    private final /* synthetic */ NavPoiInfo val$pois;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$136(DSINavigationDispatcher dSINavigationDispatcher, NavPoiInfo navPoiInfo, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$pois = navPoiInfo;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).poiInformationResult(this.val$pois, this.val$result);
    }
}

