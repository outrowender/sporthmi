/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class SetPrivacyCommand
extends AbstractOSRCommand {
    private OSRUser user;
    private int privacyFlags;
    private ISetPrivacyResponseListener listener;

    public SetPrivacyCommand(OSRUser oSRUser, int n) {
        this(oSRUser, n, null);
    }

    public SetPrivacyCommand(OSRUser oSRUser, int n, ISetPrivacyResponseListener iSetPrivacyResponseListener) {
        this.user = oSRUser;
        this.privacyFlags = n;
        this.listener = iSetPrivacyResponseListener;
    }

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
        this.logger.log(1000000, "SetPrivacyCommand#execute() for user %1 and flags: %2", (Object)this.user.getPortalUser(), (long)this.privacyFlags);
        dSIOnlineServiceRegistration.setPrivacyFlags(this.user, this.privacyFlags);
    }

    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
        this.logger.log(1000000, "SetPrivacyCommand#setPrivacyFlagsResponse()");
        if (this.listener != null) {
            this.listener.setPrivacyFlagsResponse(oSRUser);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface ISetPrivacyResponseListener {
        public void setPrivacyFlagsResponse(OSRUser var1);
    }
}

