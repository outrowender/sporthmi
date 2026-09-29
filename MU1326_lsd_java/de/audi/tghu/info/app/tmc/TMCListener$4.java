/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$4
extends CommandResponse {
    private final /* synthetic */ boolean val$isEngineeringMode;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$4(TMCListener tMCListener, boolean bl, int n) {
        this.this$0 = tMCListener;
        this.val$isEngineeringMode = bl;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateIsEngineeringMode(this.val$isEngineeringMode, this.val$validFlag);
    }
}

