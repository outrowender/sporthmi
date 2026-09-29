/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$11
extends CommandResponse {
    private final /* synthetic */ int val$tmcStatus;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$11(TMCListener tMCListener, int n, int n2) {
        this.this$0 = tMCListener;
        this.val$tmcStatus = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateTmcState(this.val$tmcStatus, this.val$validFlag);
    }
}

