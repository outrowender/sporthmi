/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;

public class PerformPortalRegistrationCommand
extends AbstractOSRCommand {
    private String email;
    PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener listener;

    public PerformPortalRegistrationCommand(String string, PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener performPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener) {
        this.email = string;
        this.listener = performPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener;
    }

    @Override
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
        this.logger.log(1078071040, new StringBuffer().append("PerformPortalRegistrationCommand#execute() registering: ").append(this.email).toString());
        dSIOnlineServiceRegistration.performPortalRegistration(this.email);
    }

    @Override
    public void performPortalRegistrationResponse(String string, int n) {
        this.listener.performPortalRegistrationResponse(string, n);
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

