/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.auth.CreateNewUserCommand$1;
import de.audi.tghu.online.app.osr.command.auth.CreateNewUserCommand$CreateNewUserCommandResponseListener;
import de.audi.tghu.online.app.osr.command.auth.OSRDeleteUserCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class CreateNewUserCommand
extends AbstractOSRCommand {
    private String userName;
    private String password;
    private String pairingCode;
    private CreateNewUserCommand$CreateNewUserCommandResponseListener listener;
    private OSRUser user;

    public CreateNewUserCommand(String string, CreateNewUserCommand$CreateNewUserCommandResponseListener createNewUserCommand$CreateNewUserCommandResponseListener) {
        this.pairingCode = string;
        this.listener = createNewUserCommand$CreateNewUserCommandResponseListener;
    }

    public CreateNewUserCommand(String string, String string2, CreateNewUserCommand$CreateNewUserCommandResponseListener createNewUserCommand$CreateNewUserCommandResponseListener) {
        this.password = string2;
        this.userName = string;
        this.listener = createNewUserCommand$CreateNewUserCommandResponseListener;
    }

    @Override
    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "CreateNewUserCommand#execute() dsi is null");
            return;
        }
        if (this.pairingCode == null && this.userName != null && this.password != null) {
            this.logger.log(1078071040, "CreateNewUserCommand#execute() create user with username and password");
            dSIOnlineServiceRegistration.createUserWithUserPassword("AudiT21Realm", this.userName, this.password);
        } else if (this.pairingCode != null && this.userName == null && this.password == null) {
            this.logger.log(1078071040, "CreateNewUserCommand#execute() create user with pairingCode");
            dSIOnlineServiceRegistration.createUserWithPairingCode("AudiT21Realm", this.pairingCode);
        } else {
            this.logger.log(-1601830656, "CreateNewUserCommand#execute() invalid pairingCode/username combination");
        }
    }

    @Override
    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
        this.logger.log(1078071040, "CreateNewUserCommand#createUserWithPairingCodeResponse()");
        this.handleDSIResponse(string, oSRUser, n);
    }

    @Override
    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
        this.logger.log(1078071040, "CreateNewUserCommand#createUserWithUserPasswordResponse()");
        this.handleDSIResponse(string, oSRUser, n);
    }

    private void handleDSIResponse(String string, OSRUser oSRUser, int n) {
        this.logger.log(1078071040, "CreateNewUserCommand#handleDSIResponse() result: %1", (long)n);
        if (string != "AudiT21Realm") {
            this.logger.log(-1601830656, new StringBuffer().append("CreateNewUserCommand#handleDSIResponse() invalid authIdentifier: ").append(string).toString());
            return;
        }
        if (this.listener == null) {
            this.logger.log(-1601830656, "CreateNewUserCommand#handleDSIResponse() invalid listener");
            return;
        }
        this.listener.createNewUserResponse(oSRUser, n);
        this.user = oSRUser;
        if (n != 0) {
            this.logger.log(1078071040, "CreateNewUserCommand#handleDSIResponse() error reported from dsi. Aborting CommandList");
            this.getCommandList().stop("Error DSI result");
        }
        this.getCommandList().commandFinished();
    }

    @Override
    public AbstractOSRCommand cancelCommand() {
        this.logger.log(1078071040, "CreateNewUserCommand#cancelCommand()");
        OSRDeleteUserCommand oSRDeleteUserCommand = new OSRDeleteUserCommand(this.user, new CreateNewUserCommand$1(this));
        return oSRDeleteUserCommand;
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    static /* synthetic */ LogChannel access$000(CreateNewUserCommand createNewUserCommand) {
        return createNewUserCommand.logger;
    }
}

