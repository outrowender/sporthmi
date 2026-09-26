/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;

class DSINavigationDispatcher$89
extends CommandResponse {
    private final /* synthetic */ RgRouteCostChangeInformation val$rgRouteCostChangeInformation;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$89(DSINavigationDispatcher dSINavigationDispatcher, RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgRouteCostChangeInformation = rgRouteCostChangeInformation;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgRouteCostChangeInformation(this.val$rgRouteCostChangeInformation);
    }
}

