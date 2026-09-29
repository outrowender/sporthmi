/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$16
extends CommandResponse {
    private final /* synthetic */ NavRectangle val$rectangle;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$16(TMCListener tMCListener, NavRectangle navRectangle) {
        this.this$0 = tMCListener;
        this.val$rectangle = navRectangle;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).getBoundingRectangleForTrafficMessagesResult(this.val$rectangle);
    }
}

