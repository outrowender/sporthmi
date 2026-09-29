/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$17
extends CommandResponse {
    private final /* synthetic */ int val$status;
    private final /* synthetic */ int val$type;
    private final /* synthetic */ String val$liValueListFilename;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$17(DSINavigationDispatcher dSINavigationDispatcher, int n, int n2, String string) {
        this.this$0 = dSINavigationDispatcher;
        this.val$status = n;
        this.val$type = n2;
        this.val$liValueListFilename = string;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liValueListFileStatus(this.val$status, this.val$type, this.val$liValueListFilename);
    }
}

