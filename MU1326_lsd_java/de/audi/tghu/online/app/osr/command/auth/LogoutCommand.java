/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.LoginCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class LogoutCommand
extends AbstractOSRCommand {
    OSRUser user;
    LogoutCommandResponseListener listener;

    public LogoutCommand(OSRUser oSRUser, LogoutCommandResponseListener logoutCommandResponseListener) {
        this.user = oSRUser;
        this.listener = logoutCommandResponseListener;
    }

    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (this.user == null) {
            this.logger.log(10000, "LogoutCommand#execute() no user to log out... do nothing");
            return;
        }
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "LogoutCommand#execute() no dsi");
            return;
        }
        this.logger.log(1000000, "LogoutCommand#execute() logout user: %1", (Object)this.user.getName());
        dSIOnlineServiceRegistration.logout(this.user);
    }

    public void logoutResponse(OSRUser oSRUser, int n) {
        this.logger.log(1000000, "LogoutCommand#logoutResponse() tried to log out user: %1, result: %2", (Object)(oSRUser != null ? oSRUser.getName() : "null"), (long)n);
        this.listener.logoutCommandResponse(oSRUser, n);
        this.getCommandList().commandFinished();
    }

    public AbstractOSRCommand cancelCommand() {
        this.logger.log(1000000, "LogoutCommand#cancelCommand was called");
        LoginCommand loginCommand = new LoginCommand(this.user, new LoginCommand.LoginCommandResponseListener(){

            public void loginCommandResponse(OSRUser oSRUser, int n) {
                LogoutCommand.this.logger.log(1000000, "LogoutCommand#cancelCommand logout was successfully reverted by login");
                LogoutCommand.this.getCommandList().commandFinished();
            }
        });
        return loginCommand;
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface LogoutCommandResponseListener {
        public void logoutCommandResponse(OSRUser var1, int var2);
    }
}

