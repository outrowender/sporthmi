/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.LogoutCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class LoginCommand
extends AbstractOSRCommand {
    LoginCommandResponseListener listener;
    OSRUser user;

    public LoginCommand(OSRUser oSRUser, LoginCommandResponseListener loginCommandResponseListener) {
        this.listener = loginCommandResponseListener;
        this.user = oSRUser;
    }

    public LoginCommand(LoginCommandResponseListener loginCommandResponseListener) {
        this.listener = loginCommandResponseListener;
    }

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

    public void loginResponse(OSRUser oSRUser, int n) {
        if (this.listener != null) {
            this.listener.loginCommandResponse(oSRUser, n);
        }
        this.getCommandList().commandFinished();
    }

    public AbstractOSRCommand cancelCommand() {
        this.logger.log(1000000, "LoginCommand#cancelCommand was called");
        LogoutCommand logoutCommand = new LogoutCommand(this.user, new LogoutCommand.LogoutCommandResponseListener(){

            public void logoutCommandResponse(OSRUser oSRUser, int n) {
                LoginCommand.this.logger.log(1000000, "LoginCommand#cancelCommand login was successfully reverted by logout");
                LoginCommand.this.getCommandList().commandFinished();
            }
        });
        return logoutCommand;
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface LoginCommandResponseListener {
        public void loginCommandResponse(OSRUser var1, int var2);
    }
}

