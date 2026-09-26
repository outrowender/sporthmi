/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$38
extends CommandResponse {
    private final /* synthetic */ boolean val$afaSpeaking;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$38(DSINavigationDispatcher dSINavigationDispatcher, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$afaSpeaking = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateAfaSpeaking(this.val$afaSpeaking);
    }
}

