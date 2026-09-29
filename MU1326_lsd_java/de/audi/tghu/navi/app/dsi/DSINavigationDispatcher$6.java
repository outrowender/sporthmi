/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$6
extends CommandResponse {
    private final /* synthetic */ long val$resultCode;
    private final /* synthetic */ long val$itemID;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$6(DSINavigationDispatcher dSINavigationDispatcher, long l, long l2) {
        this.this$0 = dSINavigationDispatcher;
        this.val$resultCode = l;
        this.val$itemID = l2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).dmResult(this.val$resultCode, this.val$itemID);
    }
}

