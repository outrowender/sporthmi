/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.LocalHazardInformation;

class TMCListener$17
extends CommandResponse {
    private final /* synthetic */ LocalHazardInformation[] val$events;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$17(TMCListener tMCListener, LocalHazardInformation[] localHazardInformationArray, int n) {
        this.this$0 = tMCListener;
        this.val$events = localHazardInformationArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateLocalHazardInformation(this.val$events, this.val$validFlag);
    }
}

