/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$102
extends CommandResponse {
    private final /* synthetic */ Timer val$timer;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$102(DSINavigationDispatcher dSINavigationDispatcher, Timer timer) {
        this.this$0 = dSINavigationDispatcher;
        this.val$timer = timer;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).fireTimer(this.val$timer);
    }
}

