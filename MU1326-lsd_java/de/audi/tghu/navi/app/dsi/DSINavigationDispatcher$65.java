/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavPoiInfo;

class DSINavigationDispatcher$65
extends CommandResponse {
    private final /* synthetic */ NavPoiInfo[] val$rgPoiInfo;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$65(DSINavigationDispatcher dSINavigationDispatcher, NavPoiInfo[] navPoiInfoArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgPoiInfo = navPoiInfoArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgPoiInfo(this.val$rgPoiInfo);
    }
}

