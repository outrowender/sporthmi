/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.auth.LoginCommand$LoginCommandResponseListener;
import de.audi.tghu.online.app.osr.command.auth.LogoutCommand;
import org.dsi.ifc.online.OSRUser;

class LogoutCommand$1
implements LoginCommand$LoginCommandResponseListener {
    private final /* synthetic */ LogoutCommand this$0;

    LogoutCommand$1(LogoutCommand logoutCommand) {
        this.this$0 = logoutCommand;
    }

    @Override
    public void loginCommandResponse(OSRUser oSRUser, int n) {
        LogoutCommand.access$000(this.this$0).log(1078071040, "LogoutCommand#cancelCommand logout was successfully reverted by login");
        this.this$0.getCommandList().commandFinished();
    }
}

