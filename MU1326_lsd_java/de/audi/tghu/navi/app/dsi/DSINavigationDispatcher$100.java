/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$100
extends CommandResponse {
    private final /* synthetic */ boolean val$adjusted;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$100(DSINavigationDispatcher dSINavigationDispatcher, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$adjusted = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateClockAdjusted(this.val$adjusted);
    }
}

