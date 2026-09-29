/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.TmcListElement;

class TMCListener$1
extends CommandResponse {
    private final /* synthetic */ int val$windowId;
    private final /* synthetic */ int val$usedAnchorId;
    private final /* synthetic */ TmcListElement[] val$tmcListElements;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$1(TMCListener tMCListener, int n, int n2, TmcListElement[] tmcListElementArray) {
        this.this$0 = tMCListener;
        this.val$windowId = n;
        this.val$usedAnchorId = n2;
        this.val$tmcListElements = tmcListElementArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).tmcWindowResult(this.val$windowId, this.val$usedAnchorId, this.val$tmcListElements);
    }
}

