/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavDataBase;

class DSINavigationDispatcher$47
extends CommandResponse {
    private final /* synthetic */ NavDataBase val$navDataBase;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$47(DSINavigationDispatcher dSINavigationDispatcher, NavDataBase navDataBase) {
        this.this$0 = dSINavigationDispatcher;
        this.val$navDataBase = navDataBase;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateEtcCurrentNavDataBase(this.val$navDataBase);
    }
}

