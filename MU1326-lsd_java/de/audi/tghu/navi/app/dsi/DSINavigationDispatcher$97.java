/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$97
extends CommandResponse {
    private final /* synthetic */ long val$etcLanguageLoadProgress;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$97(DSINavigationDispatcher dSINavigationDispatcher, long l) {
        this.this$0 = dSINavigationDispatcher;
        this.val$etcLanguageLoadProgress = l;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateEtcLanguageLoadProgress(this.val$etcLanguageLoadProgress);
    }
}

