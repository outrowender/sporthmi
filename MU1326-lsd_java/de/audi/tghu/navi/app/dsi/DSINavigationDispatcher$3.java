/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DistanceToNextManeuver;

class DSINavigationDispatcher$3
extends CommandResponse {
    private final /* synthetic */ DistanceToNextManeuver val$distanceToNextManeuver;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$3(DSINavigationDispatcher dSINavigationDispatcher, DistanceToNextManeuver distanceToNextManeuver) {
        this.this$0 = dSINavigationDispatcher;
        this.val$distanceToNextManeuver = distanceToNextManeuver;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateDistanceToNextManeuver(this.val$distanceToNextManeuver);
    }
}

