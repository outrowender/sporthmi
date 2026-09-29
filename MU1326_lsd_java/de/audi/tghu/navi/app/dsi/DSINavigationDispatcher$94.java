/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$94
extends CommandResponse {
    private final /* synthetic */ String[] val$navMedia;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$94(DSINavigationDispatcher dSINavigationDispatcher, String[] stringArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$navMedia = stringArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateNavMedia(this.val$navMedia);
    }
}

