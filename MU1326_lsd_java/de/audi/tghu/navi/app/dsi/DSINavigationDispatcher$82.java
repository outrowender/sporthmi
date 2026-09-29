/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DirectionToWaypoint;

class DSINavigationDispatcher$82
extends CommandResponse {
    private final /* synthetic */ DirectionToWaypoint val$trDirectionToWaypoint;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$82(DSINavigationDispatcher dSINavigationDispatcher, DirectionToWaypoint directionToWaypoint) {
        this.this$0 = dSINavigationDispatcher;
        this.val$trDirectionToWaypoint = directionToWaypoint;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateTrDirectionToWaypoint(this.val$trDirectionToWaypoint);
    }
}

