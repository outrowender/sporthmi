/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.ValueListStatus;

class DSINavigationDispatcher$53
extends CommandResponse {
    private final /* synthetic */ ValueListStatus val$poiSubstringSearchStatus;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$53(DSINavigationDispatcher dSINavigationDispatcher, ValueListStatus valueListStatus) {
        this.this$0 = dSINavigationDispatcher;
        this.val$poiSubstringSearchStatus = valueListStatus;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updatePoiSubstringSearchStatus(this.val$poiSubstringSearchStatus);
    }
}

