/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$13
extends CommandResponse {
    private final /* synthetic */ int[] val$activeTrafficSources;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$13(TMCListener tMCListener, int[] nArray, int n) {
        this.this$0 = tMCListener;
        this.val$activeTrafficSources = nArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateActiveTrafficSources(this.val$activeTrafficSources, this.val$validFlag);
    }
}

