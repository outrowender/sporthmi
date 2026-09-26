/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$108
extends CommandResponse {
    private final /* synthetic */ short[] val$rgiString;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$108(DSINavigationDispatcher dSINavigationDispatcher, short[] sArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgiString = sArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgiString(this.val$rgiString);
    }
}

