/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$101
extends CommandResponse {
    private final /* synthetic */ int[] val$cityIndices;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$101(DSINavigationDispatcher dSINavigationDispatcher, int[] nArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$cityIndices = nArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateCityVignettes(this.val$cityIndices);
    }
}

