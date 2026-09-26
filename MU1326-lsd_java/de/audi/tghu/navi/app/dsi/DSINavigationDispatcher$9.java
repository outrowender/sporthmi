/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.LISpellerData;

class DSINavigationDispatcher$9
extends CommandResponse {
    private final /* synthetic */ LISpellerData val$spellerState;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$9(DSINavigationDispatcher dSINavigationDispatcher, LISpellerData lISpellerData) {
        this.this$0 = dSINavigationDispatcher;
        this.val$spellerState = lISpellerData;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liGetStateResult(this.val$spellerState);
    }
}

