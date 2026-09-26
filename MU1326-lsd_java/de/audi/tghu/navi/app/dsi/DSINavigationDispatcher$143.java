/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavNextWayPointInfo;

class DSINavigationDispatcher$143
extends CommandResponse {
    private final /* synthetic */ NavNextWayPointInfo val$nextWaypointInfo;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$143(DSINavigationDispatcher dSINavigationDispatcher, NavNextWayPointInfo navNextWayPointInfo) {
        this.this$0 = dSINavigationDispatcher;
        this.val$nextWaypointInfo = navNextWayPointInfo;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateTrInfoForNextWaypoint(this.val$nextWaypointInfo);
    }
}

