/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.auth.LoginCommand;
import de.audi.tghu.online.app.osr.command.auth.LogoutCommand$LogoutCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class LoginCommand$1
implements LogoutCommand$LogoutCommandResponseListener {
    private final /* synthetic */ LoginCommand this$0;

    LoginCommand$1(LoginCommand loginCommand) {
        this.this$0 = loginCommand;
    }

    @Override
    public void logoutCommandResponse(OSRUser oSRUser, int n) {
        LoginCommand.access$000(this.this$0).log(1078071040, "LoginCommand#cancelCommand login was successfully reverted by logout");
        this.this$0.getCommandList().commandFinished();
    }
}

