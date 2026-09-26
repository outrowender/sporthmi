/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.NavLaneGuidanceData;

class DSINavigationDispatcher$64
extends CommandResponse {
    private final /* synthetic */ NavLaneGuidanceData[] val$rgLaneGuidance;
    private final /* synthetic */ boolean val$showLaneGuidance;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$64(DSINavigationDispatcher dSINavigationDispatcher, NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$rgLaneGuidance = navLaneGuidanceDataArray;
        this.val$showLaneGuidance = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateRgLaneGuidance(this.val$rgLaneGuidance, this.val$showLaneGuidance);
    }
}

