/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;

class DSINavigationDispatcher$145
extends CommandResponse {
    private final /* synthetic */ NavRectangle val$rectangle;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$145(DSINavigationDispatcher dSINavigationDispatcher, NavRectangle navRectangle) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rectangle = navRectangle;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).rgGetRouteBoundingRectangleResult(this.val$rectangle);
    }
}

