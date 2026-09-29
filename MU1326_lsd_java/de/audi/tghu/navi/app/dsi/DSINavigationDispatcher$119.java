/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$119
extends CommandResponse {
    private final /* synthetic */ int val$personalPOISearchStatus;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$119(DSINavigationDispatcher dSINavigationDispatcher, int n, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$personalPOISearchStatus = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updatePersonalPOISearchStatus(this.val$personalPOISearchStatus, this.val$validFlag);
    }
}

