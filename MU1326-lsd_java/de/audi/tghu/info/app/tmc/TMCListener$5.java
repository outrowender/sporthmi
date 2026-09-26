/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$5
extends CommandResponse {
    private final /* synthetic */ boolean val$isTmcAvailable;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$5(TMCListener tMCListener, boolean bl, int n) {
        this.this$0 = tMCListener;
        this.val$isTmcAvailable = bl;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateIsTmcProAvailable(this.val$isTmcAvailable, this.val$validFlag);
    }
}

