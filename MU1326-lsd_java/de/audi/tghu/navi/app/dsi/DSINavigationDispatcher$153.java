/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$153
extends CommandResponse {
    private final /* synthetic */ int[] val$categoryTypes;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$153(DSINavigationDispatcher dSINavigationDispatcher, int[] nArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$categoryTypes = nArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).poiGetCategoryTypesFromUIdResult(this.val$categoryTypes);
    }
}

