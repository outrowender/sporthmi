/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.NaviPresetHandler;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import org.dsi.ifc.global.NavLocation;

class NaviPresetHandler$3
extends LocationToStreamCommand {
    private final /* synthetic */ Object val$waitingLock;
    private final /* synthetic */ NaviPresetHandler this$0;

    NaviPresetHandler$3(NaviPresetHandler naviPresetHandler, NavLocation navLocation, Object object) {
        this.this$0 = naviPresetHandler;
        this.val$waitingLock = object;
        super(navLocation);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        this.logger.log(-2137614336, "LocationToStreamCommand#locationToStreamResult( %1 )", bl);
        if (bl) {
            this.getCommandList().put("LOCATION_STREAM", byArray);
        }
        Object object = this.val$waitingLock;
        synchronized (object) {
            this.val$waitingLock.notify();
        }
        this.getCommandList().commandFinished();
    }
}

