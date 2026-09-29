/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$71
extends CommandResponse {
    private final /* synthetic */ String val$rgTurnToStreet;
    private final /* synthetic */ boolean val$inProgressData;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$71(DSINavigationDispatcher dSINavigationDispatcher, String string, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgTurnToStreet = string;
        this.val$inProgressData = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgTurnToStreet(this.val$rgTurnToStreet, this.val$inProgressData);
    }
}

