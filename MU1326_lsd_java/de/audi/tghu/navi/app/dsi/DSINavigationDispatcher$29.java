/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$29
extends CommandResponse {
    private final /* synthetic */ int val$trDeleteAllTracesResultCode;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$29(DSINavigationDispatcher dSINavigationDispatcher, int n, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trDeleteAllTracesResultCode = n;
        this.val$errorCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).trDeleteAllTracesResult(this.val$trDeleteAllTracesResultCode, this.val$errorCode);
    }
}

