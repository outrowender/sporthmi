/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$7
extends CommandResponse {
    private final /* synthetic */ int val$wndId;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$7(TMCListener tMCListener, int n) {
        this.this$0 = tMCListener;
        this.val$wndId = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).windowChange(this.val$wndId);
    }
}

