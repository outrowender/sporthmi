/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$79
extends CommandResponse {
    private final /* synthetic */ int val$trRecordingState;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$79(DSINavigationDispatcher dSINavigationDispatcher, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trRecordingState = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateTrRecordingState(this.val$trRecordingState);
    }
}

