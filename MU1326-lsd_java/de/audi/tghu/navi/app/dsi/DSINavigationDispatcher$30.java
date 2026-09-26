/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$30
extends CommandResponse {
    private final /* synthetic */ int val$trDeleteTraceResultCode;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$30(DSINavigationDispatcher dSINavigationDispatcher, int n, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trDeleteTraceResultCode = n;
        this.val$errorCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).trDeleteTraceResult(this.val$trDeleteTraceResultCode, this.val$errorCode);
    }
}

