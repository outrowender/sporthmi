/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$12
extends CommandResponse {
    private final /* synthetic */ int val$windowId;
    private final /* synthetic */ int val$messageFilter;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$12(TMCListener tMCListener, int n, int n2) {
        this.this$0 = tMCListener;
        this.val$windowId = n;
        this.val$messageFilter = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).setMessageFilterResult(this.val$windowId, this.val$messageFilter);
    }
}

