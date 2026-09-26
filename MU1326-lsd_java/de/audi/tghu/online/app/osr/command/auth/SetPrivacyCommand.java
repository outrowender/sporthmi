/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.SetPrivacyCommand$ISetPrivacyResponseListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class SetPrivacyCommand
extends AbstractOSRCommand {
    private OSRUser user;
    private int privacyFlags;
    private SetPrivacyCommand$ISetPrivacyResponseListener listener;

    public SetPrivacyCommand(OSRUser oSRUser, int n) {
        this(oSRUser, n, null);
    }

    public SetPrivacyCommand(OSRUser oSRUser, int n, SetPrivacyCommand$ISetPrivacyResponseListener iSetPrivacyResponseListener) {
        this.user = oSRUser;
        this.privacyFlags = n;
        this.listener = iSetPrivacyResponseListener;
    }

    @Override
    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (this.user == null) {
            this.logger.log(10000, "SetPrivacyCommand#execute() no user... do nothing");
            this.getCommandList().commandAborted(1L);
            return;
        }
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "SetPrivacyCommand#execute() no dsi");
            return;
        }
        this.logger.log(1078071040, "SetPrivacyCommand#execute() for user %1 and flags: %2", (Object)this.user.getPortalUser(), (long)this.privacyFlags);
        dSIOnlineServiceRegistration.setPrivacyFlags(this.user, this.privacyFlags);
    }

    @Override
    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
        this.logger.log(1078071040, "SetPrivacyCommand#setPrivacyFlagsResponse()");
        if (this.listener != null) {
            this.listener.setPrivacyFlagsResponse(oSRUser);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

