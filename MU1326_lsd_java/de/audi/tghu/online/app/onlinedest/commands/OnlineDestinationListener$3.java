/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIDestinationImportListener;

class OnlineDestinationListener$3
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ OnlineDestinationListener this$0;

    OnlineDestinationListener$3(OnlineDestinationListener onlineDestinationListener, int n) {
        this.this$0 = onlineDestinationListener;
        this.val$success = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDestinationImportListener)dSIListener).stopActionResult(this.val$success);
    }
}

