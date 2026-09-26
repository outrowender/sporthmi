/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$154
extends CommandResponse {
    private final /* synthetic */ int[] val$type;
    private final /* synthetic */ NavLocation[] val$locations;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$154(DSINavigationDispatcher dSINavigationDispatcher, int[] nArray, NavLocation[] navLocationArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$type = nArray;
        this.val$locations = navLocationArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).liDisambiguateLocationResult(this.val$type, this.val$locations);
    }
}

