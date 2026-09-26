/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.TrafficSource;

class TMCListener$14
extends CommandResponse {
    private final /* synthetic */ TrafficSource[] val$trafficSources;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$14(TMCListener tMCListener, TrafficSource[] trafficSourceArray, int n) {
        this.this$0 = tMCListener;
        this.val$trafficSources = trafficSourceArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateTrafficSourceInformation(this.val$trafficSources, this.val$validFlag);
    }
}

