/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;

public class PerformPortalRegistrationCommand
extends AbstractOSRCommand {
    private String email;
    PerformPortalRegistrationCommandResponseListener listener;

    public PerformPortalRegistrationCommand(String string, PerformPortalRegistrationCommandResponseListener performPortalRegistrationCommandResponseListener) {
        this.email = string;
        this.listener = performPortalRegistrationCommandResponseListener;
    }

    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (this.email == null || this.email.length() == 0) {
            this.logger.log(10000, "PerformPortalRegistrationCommand#execute() no user to log in... do nothing");
            this.getCommandList().commandAborted(1L);
            return;
        }
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "PerformPortalRegistrationCommand#execute() no dsi");
            return;
        }
        this.logger.log(1000000, "PerformPortalRegistrationCommand#execute() registering: " + this.email);
        dSIOnlineServiceRegistration.performPortalRegistration(this.email);
    }

    public void performPortalRegistrationResponse(String string, int n) {
        this.listener.performPortalRegistrationResponse(string, n);
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface PerformPortalRegistrationCommandResponseListener {
        public void performPortalRegistrationResponse(String var1, int var2);
    }
}

