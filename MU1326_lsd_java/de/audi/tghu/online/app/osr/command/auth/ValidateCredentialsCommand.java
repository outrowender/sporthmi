/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;

public class ValidateCredentialsCommand
extends AbstractOSRCommand {
    public static final String MY_AUDI_AUTHENTICATION_IDENTIFIER = "AudiT21Realm";
    private String userName;
    private String password;
    private ValidateCredentialsCommandListener listener;

    public ValidateCredentialsCommand(String string, String string2, ValidateCredentialsCommandListener validateCredentialsCommandListener) {
        this.userName = string;
        this.password = string2;
        this.listener = validateCredentialsCommandListener;
    }

    public void execute() {
        this.logger.log(10000000, "[ValidateCredentialsCommand#execute] calling DSI ValidateCredentialsCommand userName:%2 password: %3", (Object)this.userName, (Object)this.password);
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        if (dSIOnlineServiceRegistration == null) {
            System.out.println("Validate credentials Command#execute() NO DSI");
        }
    }

    public void validatePortalUserResponse(int n, String string, String string2, String string3, String string4, int n2) {
        this.logger.log(10000000, "[ValidateCredentialsCommand#validatePortalUserResponse] result: %1 userName:%2 password: %3 pairingCode: %4", (Object)String.valueOf(n), (Object)string2, (Object)string3, (Object)String.valueOf(string4));
        if (this.listener != null) {
            this.listener.validateCredentialsCommandResponse(n);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface ValidateCredentialsCommandListener {
        public void validateCredentialsCommandResponse(int var1);
    }
}

