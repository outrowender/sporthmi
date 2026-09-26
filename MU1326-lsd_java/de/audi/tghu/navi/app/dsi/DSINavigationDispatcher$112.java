/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$112
extends CommandResponse {
    private final /* synthetic */ String[] val$styleDBPaths;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$112(DSINavigationDispatcher dSINavigationDispatcher, String[] stringArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$styleDBPaths = stringArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateStyleDBPaths(this.val$styleDBPaths);
    }
}

