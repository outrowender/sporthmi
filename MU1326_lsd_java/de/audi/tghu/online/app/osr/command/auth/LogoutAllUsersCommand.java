/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class LogoutAllUsersCommand
extends AbstractOSRCommand {
    LogoutAllUsersCommandResponseListener listener;

    public LogoutAllUsersCommand(LogoutAllUsersCommandResponseListener logoutAllUsersCommandResponseListener) {
        this.listener = logoutAllUsersCommandResponseListener;
    }

    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "LogoutAction#execute() no dsi");
            return;
        }
        dSIOnlineServiceRegistration.logoutAuthScheme("AudiT21Realm");
    }

    public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
        this.listener.logoutAllUsersCommandResponse(oSRUserArray, nArray);
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface LogoutAllUsersCommandResponseListener {
        public void logoutAllUsersCommandResponse(OSRUser[] var1, int[] var2);
    }
}

