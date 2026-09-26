/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$105
extends CommandResponse {
    private final /* synthetic */ int val$mapStyleType;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$105(DSINavigationDispatcher dSINavigationDispatcher, int n, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$mapStyleType = n;
        this.val$resultCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).ehResult(this.val$mapStyleType, this.val$resultCode);
    }
}

