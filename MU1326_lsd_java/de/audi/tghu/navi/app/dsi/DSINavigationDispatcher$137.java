/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$137
extends CommandResponse {
    private final /* synthetic */ long val$elementsTotal;
    private final /* synthetic */ long val$elementsVisible;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$137(DSINavigationDispatcher dSINavigationDispatcher, long l, long l2, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$elementsTotal = l;
        this.val$elementsVisible = l2;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateElementsTotal(this.val$elementsTotal, this.val$elementsVisible, this.val$validFlag);
    }
}

