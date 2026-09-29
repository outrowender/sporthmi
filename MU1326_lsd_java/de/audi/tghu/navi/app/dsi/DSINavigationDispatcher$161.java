/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.PoiExtendedInfo;

class DSINavigationDispatcher$161
extends CommandResponse {
    private final /* synthetic */ PoiExtendedInfo val$extendedInfo;
    private final /* synthetic */ boolean val$success;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$161(DSINavigationDispatcher dSINavigationDispatcher, PoiExtendedInfo poiExtendedInfo, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$extendedInfo = poiExtendedInfo;
        this.val$success = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).poiRequestExtendedInfoResult(this.val$extendedInfo, this.val$success);
    }
}

