/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavDataBase;

class DSINavigationDispatcher$48
extends CommandResponse {
    private final /* synthetic */ NavDataBase[] val$navDataBases;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$48(DSINavigationDispatcher dSINavigationDispatcher, NavDataBase[] navDataBaseArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$navDataBases = navDataBaseArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateEtcAvailableNavDataBases(this.val$navDataBases);
    }
}

