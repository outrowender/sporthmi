/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$96
extends CommandResponse {
    private final /* synthetic */ String val$language;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$96(DSINavigationDispatcher dSINavigationDispatcher, String string) {
        this.this$0 = dSINavigationDispatcher;
        this.val$language = string;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateLanguage(this.val$language);
    }
}

