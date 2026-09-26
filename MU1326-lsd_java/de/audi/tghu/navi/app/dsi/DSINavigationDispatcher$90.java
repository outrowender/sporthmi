/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$90
extends CommandResponse {
    private final /* synthetic */ boolean val$status;
    private final /* synthetic */ byte[] val$streamLocation;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$90(DSINavigationDispatcher dSINavigationDispatcher, boolean bl, byte[] byArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$status = bl;
        this.val$streamLocation = byArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).locationToStreamResult(this.val$status, this.val$streamLocation);
    }
}

