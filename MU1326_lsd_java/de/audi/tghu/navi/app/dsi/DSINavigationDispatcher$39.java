/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.LDListElement;

class DSINavigationDispatcher$39
extends CommandResponse {
    private final /* synthetic */ LDListElement[] val$destinations;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$39(DSINavigationDispatcher dSINavigationDispatcher, LDListElement[] lDListElementArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$destinations = lDListElementArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateDmLastDestinationsList(this.val$destinations);
    }
}

