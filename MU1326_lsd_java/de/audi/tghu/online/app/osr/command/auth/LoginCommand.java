/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.LoginCommand$1;
import de.audi.tghu.online.app.osr.command.auth.LoginCommand$LoginCommandResponseListener;
import de.audi.tghu.online.app.osr.command.auth.LogoutCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class LoginCommand
extends AbstractOSRCommand {
    LoginCommand$LoginCommandResponseListener listener;
    OSRUser user;

    public LoginCommand(OSRUser oSRUser, LoginCommand$LoginCommandResponseListener loginCommandResponseListener) {
        this.listener = loginCommandResponseListener;
        this.user = oSRUser;
    }

    public LoginCommand(LoginCommand$LoginCommandResponseListener loginCommandResponseListener) {
        this.listener = loginCommandResponseListener;
    }

    @Override
    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (this.user == null) {
            this.user = this.getApplication().getAuthenticationController().getModelManager().getCurrentUser();
        }
        if (this.user == null) {
            this.logger.log(10000, "LoginCommand#execute() no user to log in... do nothing");
            this.getCommandList().commandAborted(1L);
            return;
        }
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "LoginCommand#execute() no dsi");
            return;
        }
        dSIOnlineServiceRegistration.login(this.user);
    }

    @Override
    public void loginResponse(OSRUser oSRUser, int n) {
        if (this.listener != null) {
            this.listener.loginCommandResponse(oSRUser, n);
        }
        this.getCommandList().commandFinished();
    }

    @Override
    public AbstractOSRCommand cancelCommand() {
        this.logger.log(1078071040, "LoginCommand#cancelCommand was called");
        LogoutCommand logoutCommand = new LogoutCommand(this.user, new LoginCommand$1(this));
        return logoutCommand;
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    static /* synthetic */ LogChannel access$000(LoginCommand loginCommand) {
        return loginCommand.logger;
    }
}

