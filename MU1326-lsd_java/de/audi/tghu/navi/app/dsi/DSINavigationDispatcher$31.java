/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$31
extends CommandResponse {
    private final /* synthetic */ int val$trRenameTraceResultCode;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$31(DSINavigationDispatcher dSINavigationDispatcher, int n, int n2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trRenameTraceResultCode = n;
        this.val$errorCode = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).trRenameTraceResult(this.val$trRenameTraceResultCode, this.val$errorCode);
    }
}

