/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class CheckPasswordCommand
extends AbstractOSRCommand {
    private CheckPasswordCommandResponseListener listener;
    private String password;
    private boolean backendVerification;
    private boolean isPairingCode;

    public CheckPasswordCommand(String string, boolean bl, boolean bl2, CheckPasswordCommandResponseListener checkPasswordCommandResponseListener) {
        this.password = string;
        this.backendVerification = bl;
        this.listener = checkPasswordCommandResponseListener;
        this.isPairingCode = bl2;
    }

    public CheckPasswordCommand(String string, boolean bl, CheckPasswordCommandResponseListener checkPasswordCommandResponseListener) {
        this(string, bl, false, checkPasswordCommandResponseListener);
    }

    public void execute() {
        DSIOnlineServiceRegistration dSIOnlineServiceRegistration = this.getDSI();
        OSRUser oSRUser = this.getApplication().getAuthenticationController().getModelManager().getCurrentUser();
        if (oSRUser == null) {
            this.logger.log(10000, "CheckPasswordCommand#execute() no user to log in... do nothing");
            return;
        }
        if (dSIOnlineServiceRegistration == null) {
            this.logger.log(10000, "CheckPasswordCommand#execute() no dsi");
            return;
        }
        if (this.isPairingCode) {
            this.logger.log(1000000, "CheckPasswordCommand#execute() log in user %1 with pairingCode %2", (Object)oSRUser.getName(), (Object)this.password);
            dSIOnlineServiceRegistration.checkPairingCode(oSRUser, this.password, this.backendVerification);
        } else {
            this.logger.log(1000000, "CheckPasswordCommand#execute() log in user %1 with password %2", (Object)oSRUser.getName(), (Object)this.password);
            dSIOnlineServiceRegistration.checkPassword(oSRUser, this.password, this.backendVerification);
        }
    }

    public void checkPasswordResponse(OSRUser oSRUser, int n) {
        this.handleDsiResponse(oSRUser, n);
    }

    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
        this.handleDsiResponse(oSRUser, n);
    }

    private void handleDsiResponse(OSRUser oSRUser, int n) {
        this.listener.checkPasswordCommandResponse(oSRUser, n);
        if (n != 0) {
            this.getCommandList().commandAborted(1L);
            return;
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface CheckPasswordCommandResponseListener {
        public void checkPasswordCommandResponse(OSRUser var1, int var2);
    }
}

