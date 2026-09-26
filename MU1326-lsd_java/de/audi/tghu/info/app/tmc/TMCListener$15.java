/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$15
extends CommandResponse {
    private final /* synthetic */ long[] val$messageIds;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$15(TMCListener tMCListener, long[] lArray) {
        this.this$0 = tMCListener;
        this.val$messageIds = lArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).getMessageIdsForListElementResult(this.val$messageIds);
    }
}

