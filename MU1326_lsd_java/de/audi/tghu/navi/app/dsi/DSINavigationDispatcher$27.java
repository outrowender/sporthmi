/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;

class DSINavigationDispatcher$27
extends CommandResponse {
    private final /* synthetic */ NavLocation val$vehiclePosition;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$27(DSINavigationDispatcher dSINavigationDispatcher, NavLocation navLocation) {
        this.this$0 = dSINavigationDispatcher;
        this.val$vehiclePosition = navLocation;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).soPosPositionDescriptionVehicleResult(this.val$vehiclePosition);
    }
}

