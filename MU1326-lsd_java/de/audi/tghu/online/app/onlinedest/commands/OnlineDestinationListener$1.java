/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIDestinationImportListener;

class OnlineDestinationListener$1
extends CommandResponse {
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ OnlineDestinationListener this$0;

    OnlineDestinationListener$1(OnlineDestinationListener onlineDestinationListener, int n, String string, int n2) {
        this.this$0 = onlineDestinationListener;
        this.val$errorCode = n;
        this.val$errorMsg = string;
        this.val$requestType = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIDestinationImportListener)dSIListener).asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType);
    }
}

