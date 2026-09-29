/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$131
extends CommandResponse {
    private final /* synthetic */ long[] val$uid;
    private final /* synthetic */ int val$blockRequestResultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$131(DSINavigationDispatcher dSINavigationDispatcher, long[] lArray, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$uid = lArray;
        this.val$blockRequestResultCode = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).setBlockDescriptionResult(this.val$uid, this.val$blockRequestResultCode);
    }
}

