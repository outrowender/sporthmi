/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavDataBase;

class DSINavigationDispatcher$118
extends CommandResponse {
    private final /* synthetic */ NavDataBase[] val$personalPOIDataBases;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$118(DSINavigationDispatcher dSINavigationDispatcher, NavDataBase[] navDataBaseArray, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$personalPOIDataBases = navDataBaseArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateEtcAvailablePersonalPOIDataBases(this.val$personalPOIDataBases, this.val$validFlag);
    }
}

