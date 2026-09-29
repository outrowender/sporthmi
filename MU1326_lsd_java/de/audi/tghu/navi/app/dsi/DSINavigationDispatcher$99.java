/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$99
extends CommandResponse {
    private final /* synthetic */ RenderingInfoProvider val$renderingInfoProvider;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$99(DSINavigationDispatcher dSINavigationDispatcher, RenderingInfoProvider renderingInfoProvider) {
        this.this$0 = dSINavigationDispatcher;
        this.val$renderingInfoProvider = renderingInfoProvider;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRenderingInfoProvider(this.val$renderingInfoProvider);
    }
}

