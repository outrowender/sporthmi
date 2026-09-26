/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.LoginCommand;
import de.audi.tghu.online.app.osr.command.auth.LogoutCommand$1;
import de.audi.tghu.online.app.osr.command.auth.LogoutCommand$LogoutCommandResponseListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class LogoutCommand
extends AbstractOSRCommand {
    OSRUser user;
    LogoutCommand$LogoutCommandResponseListener listener;

    public LogoutCommand(OSRUser oSRUser, LogoutCommand$LogoutCommandResponseListener logoutCommand$LogoutCommandResponseListener) {
        this.user = oSRUser;
        this.listener = logoutCommand$LogoutCommandResponseListener;
    }

    @Override
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
        this.logger.log(1078071040, "LogoutCommand#execute() logout user: %1", (Object)this.user.getName());
        dSIOnlineServiceRegistration.logout(this.user);
    }

    @Override
    public void logoutResponse(OSRUser oSRUser, int n) {
        this.logger.log(1078071040, "LogoutCommand#logoutResponse() tried to log out user: %1, result: %2", (Object)(oSRUser != null ? oSRUser.getName() : "null"), (long)n);
        this.listener.logoutCommandResponse(oSRUser, n);
        this.getCommandList().commandFinished();
    }

    @Override
    public AbstractOSRCommand cancelCommand() {
        this.logger.log(1078071040, "LogoutCommand#cancelCommand was called");
        LoginCommand loginCommand = new LoginCommand(this.user, new LogoutCommand$1(this));
        return loginCommand;
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    static /* synthetic */ LogChannel access$000(LogoutCommand logoutCommand) {
        return logoutCommand.logger;
    }
}

