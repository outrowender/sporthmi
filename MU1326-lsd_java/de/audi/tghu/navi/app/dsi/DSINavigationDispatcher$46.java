/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavVersionInfo;

class DSINavigationDispatcher$46
extends CommandResponse {
    private final /* synthetic */ NavVersionInfo val$etcVersionInfo;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$46(DSINavigationDispatcher dSINavigationDispatcher, NavVersionInfo navVersionInfo) {
        this.this$0 = dSINavigationDispatcher;
        this.val$etcVersionInfo = navVersionInfo;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateEtcVersionInfo(this.val$etcVersionInfo);
    }
}

