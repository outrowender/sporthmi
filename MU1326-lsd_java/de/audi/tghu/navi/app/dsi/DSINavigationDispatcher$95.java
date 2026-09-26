/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$95
extends CommandResponse {
    private final /* synthetic */ String[] val$availableLanguages;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$95(DSINavigationDispatcher dSINavigationDispatcher, String[] stringArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$availableLanguages = stringArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateAvailableLanguages(this.val$availableLanguages);
    }
}

