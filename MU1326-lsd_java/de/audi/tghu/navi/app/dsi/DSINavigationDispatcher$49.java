/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$49
extends CommandResponse {
    private final /* synthetic */ boolean val$lispIsSpellerActive;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$49(DSINavigationDispatcher dSINavigationDispatcher, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$lispIsSpellerActive = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateLispIsSpellerActive(this.val$lispIsSpellerActive);
    }
}

