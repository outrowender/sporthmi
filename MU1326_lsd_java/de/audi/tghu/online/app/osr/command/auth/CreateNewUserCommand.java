/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.OSRDeleteUserCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class CreateNewUserCommand
extends AbstractOSRCommand {
    private String userName;
    private String password;
    private String pairingCode;
    private CreateNewUserCommandResponseListener listener;
    private OSRUser user;

    public CreateNewUserCommand(String string, CreateNewUserCommandResponseListener createNewUserCommandResponseListener) {
        this.pairingCode = string;
        this.listener = createNewUserCommandResponseListener;
    }

    public CreateNewUserCommand(String string, String string2, CreateNewUserCommandResponseListener createNewUserCommandResponseListener) {
        this.password = string2;
        this.userName = string;
        this.listener = createNewUserCommandResponseListener;
    }

    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "CreateNewUserCommand#execute() dsi is null");
            return;
        }
        if (this.pairingCode == null && this.userName != null && this.password != null) {
            this.logger.log(1000000, "CreateNewUserCommand#execute() create user with username and password");
            dSIOnlineServiceRegistration.createUserWithUserPassword("AudiT21Realm", this.userName, this.password);
        } else if (this.pairingCode != null && this.userName == null && this.password == null) {
            this.logger.log(1000000, "CreateNewUserCommand#execute() create user with pairingCode");
            dSIOnlineServiceRegistration.createUserWithPairingCode("AudiT21Realm", this.pairingCode);
        } else {
            this.logger.log(100000, "CreateNewUserCommand#execute() invalid pairingCode/username combination");
        }
    }

    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
        this.logger.log(1000000, "CreateNewUserCommand#createUserWithPairingCodeResponse()");
        this.handleDSIResponse(string, oSRUser, n);
    }

    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
        this.logger.log(1000000, "CreateNewUserCommand#createUserWithUserPasswordResponse()");
        this.handleDSIResponse(string, oSRUser, n);
    }

    private void handleDSIResponse(String string, OSRUser oSRUser, int n) {
        this.logger.log(1000000, "CreateNewUserCommand#handleDSIResponse() result: %1", (long)n);
        if (string != "AudiT21Realm") {
            this.logger.log(100000, new StringBuffer().append("CreateNewUserCommand#handleDSIResponse() invalid authIdentifier: ").append(string).toString());
            return;
        }
        if (this.listener == null) {
            this.logger.log(100000, "CreateNewUserCommand#handleDSIResponse() invalid listener");
            return;
        }
        this.listener.createNewUserResponse(oSRUser, n);
        this.user = oSRUser;
        if (n != 0) {
            this.logger.log(1000000, "CreateNewUserCommand#handleDSIResponse() error reported from dsi. Aborting CommandList");
            this.getCommandList().stop("Error DSI result");
        }
        this.getCommandList().commandFinished();
    }

    public AbstractOSRCommand cancelCommand() {
        this.logger.log(1000000, "CreateNewUserCommand#cancelCommand()");
        OSRDeleteUserCommand oSRDeleteUserCommand = new OSRDeleteUserCommand(this.user, new OSRDeleteUserCommand.IDeleteUserCommandResponseListener(){

            public void removeUserResponse(OSRUser oSRUser, int n) {
                CreateNewUserCommand.this.logger.log(1000000, "CreateNewUserCommand#cancelCommand() deleted user %1", (Object)oSRUser);
                CreateNewUserCommand.this.getCommandList().commandFinished();
            }
        });
        return oSRDeleteUserCommand;
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface CreateNewUserCommandResponseListener {
        public void createNewUserResponse(OSRUser var1, int var2);
    }
}

