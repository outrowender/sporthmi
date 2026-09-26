/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$3
extends CommandResponse {
    private final /* synthetic */ int val$windowId;
    private final /* synthetic */ long val$eventsTotal;
    private final /* synthetic */ long val$eventsVisible;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$3(TMCListener tMCListener, int n, long l, long l2, int n2) {
        this.this$0 = tMCListener;
        this.val$windowId = n;
        this.val$eventsTotal = l;
        this.val$eventsVisible = l2;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateEventsTotal(this.val$windowId, this.val$eventsTotal, this.val$eventsVisible, this.val$validFlag);
    }
}

