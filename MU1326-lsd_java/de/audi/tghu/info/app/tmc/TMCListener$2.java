/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$2
extends CommandResponse {
    private final /* synthetic */ long val$eventsOnRoute;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$2(TMCListener tMCListener, long l, int n) {
        this.this$0 = tMCListener;
        this.val$eventsOnRoute = l;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateEventsOnRoute(this.val$eventsOnRoute, this.val$validFlag);
    }
}

