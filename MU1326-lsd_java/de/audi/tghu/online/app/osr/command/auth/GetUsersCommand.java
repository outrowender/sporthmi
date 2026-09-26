/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.GetUsersCommand$GetUsersCommandListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class GetUsersCommand
extends AbstractOSRCommand {
    GetUsersCommand$GetUsersCommandListener listener;

    public GetUsersCommand(GetUsersCommand$GetUsersCommandListener getUsersCommand$GetUsersCommandListener) {
        this.listener = getUsersCommand$GetUsersCommandListener;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[GetUsersCommand#execute] calling DSI getUsers()");
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "[GetUsersCommand#execute] no DSI");
            return;
        }
        dSIOnlineServiceRegistration.getUsers("AudiT21Realm");
    }

    @Override
    public void getUsersResponse(OSRUser[] oSRUserArray) {
        this.logger.log(-2137614336, "[GetUsersCommand#getUsersResponse] userList Received. Length: %1", oSRUserArray == null ? -1L : (long)oSRUserArray.length);
        this.listener.getUsersResponse(oSRUserArray);
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

