/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$138
extends CommandResponse {
    private final /* synthetic */ int val$reason;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$138(DSINavigationDispatcher dSINavigationDispatcher, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$reason = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).windowChanged(this.val$reason);
    }
}

