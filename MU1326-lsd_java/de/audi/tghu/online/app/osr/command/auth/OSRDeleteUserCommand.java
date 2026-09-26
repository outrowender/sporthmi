/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.OSRDeleteUserCommand$IDeleteUserCommandResponseListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class OSRDeleteUserCommand
extends AbstractOSRCommand {
    private OSRUser user;
    private OSRDeleteUserCommand$IDeleteUserCommandResponseListener listener;

    public OSRDeleteUserCommand(OSRUser oSRUser, OSRDeleteUserCommand$IDeleteUserCommandResponseListener oSRDeleteUserCommand$IDeleteUserCommandResponseListener) {
        this.user = oSRUser;
        this.listener = oSRDeleteUserCommand$IDeleteUserCommandResponseListener;
    }

    @Override
    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (this.user == null) {
            this.logger.log(10000, "ORSDeleteUserCommand#execute() no user to log out... do nothing");
            return;
        }
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "ORSDeleteUserCommand#execute() no dsi");
            return;
        }
        this.logger.log(1078071040, "ORSDeleteUserCommand#execute() deleting user: %1", (Object)this.user.getName());
        dSIOnlineServiceRegistration.removeUser(this.user);
    }

    @Override
    public void removeUserResponse(OSRUser oSRUser, int n) {
        if (this.listener != null) {
            this.listener.removeUserResponse(oSRUser, n);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

