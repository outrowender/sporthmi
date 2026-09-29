/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.BapTurnToInfo;

class DSINavigationDispatcher$107
extends CommandResponse {
    private final /* synthetic */ BapTurnToInfo[] val$bapTurnToInfo;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$107(DSINavigationDispatcher dSINavigationDispatcher, BapTurnToInfo[] bapTurnToInfoArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$bapTurnToInfo = bapTurnToInfoArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateBapTurnToInfo(this.val$bapTurnToInfo);
    }
}

