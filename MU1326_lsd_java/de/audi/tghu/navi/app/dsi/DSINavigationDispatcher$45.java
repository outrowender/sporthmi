/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$45
extends CommandResponse {
    private final /* synthetic */ boolean val$etcSensorDataReplayGuidance;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$45(DSINavigationDispatcher dSINavigationDispatcher, boolean bl) {
        this.this$0 = dSINavigationDispatcher;
        this.val$etcSensorDataReplayGuidance = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).etcSensorDataReplayGuidance(this.val$etcSensorDataReplayGuidance);
    }
}

