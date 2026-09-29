/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.TurnListElement;

class DSINavigationDispatcher$70
extends CommandResponse {
    private final /* synthetic */ TurnListElement[] val$rgTurnList;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$70(DSINavigationDispatcher dSINavigationDispatcher, TurnListElement[] turnListElementArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgTurnList = turnListElementArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgTurnList(this.val$rgTurnList);
    }
}

