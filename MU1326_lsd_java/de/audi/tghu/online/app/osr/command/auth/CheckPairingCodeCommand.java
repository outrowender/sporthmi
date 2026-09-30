/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command.auth;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class CheckPairingCodeCommand
extends AbstractOSRCommand {
    private CheckPairingCodeCommandResponseListener listener;
    private String password;
    private boolean backendVerification;

    public CheckPairingCodeCommand(String string, boolean bl, CheckPairingCodeCommandResponseListener checkPairingCodeCommandResponseListener) {
        this.password = string;
        this.backendVerification = bl;
        this.listener = checkPairingCodeCommandResponseListener;
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
        dSIOnlineServiceRegistration.checkPairingCode(oSRUser, this.password, this.backendVerification);
    }

    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
        this.listener.checkPairingCodeResponse(oSRUser, n);
        if (n != 0) {
            this.getCommandList().commandAborted(1L);
            return;
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public static interface CheckPairingCodeCommandResponseListener {
        public void checkPairingCodeResponse(OSRUser var1, int var2);
    }
}

