/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$149
extends CommandResponse {
    private final /* synthetic */ String val$validNVC;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$149(DSINavigationDispatcher dSINavigationDispatcher, String string) {
        this.this$0 = dSINavigationDispatcher;
        this.val$validNVC = string;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).lispGetMatchingNVCResult(this.val$validNVC);
    }
}

