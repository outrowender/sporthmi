/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.atip.log.LogChannel;

public class TelAbortNetworkRegistrationCmd
extends AbstractTelDSIMECommand {
    public TelAbortNetworkRegistrationCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelAbortNetworkRegistrationCmd", n, iTelDSIResponseListener);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelAbortNetworkRegistrationCmd#execute]");
            this.dsi.requestAbortNetworkRegistration();
        } else {
            this.logger.log(-1601830656, "[TelAbortNetworkRegistrationCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseAbortNetworkRegistration(int n) {
        this.logger.log(1078071040, "[TelAbortServiceCodeRequestCmd#responseAbortNetworkRegistration] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseAbortNetworkRegistration(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }

    @Override
    public void responseNetworkRegistration(int n) {
        this.logger.log(1078071040, "[TelAbortServiceCodeRequestCmd#responseNetworkRegistration] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseNetworkRegistration(n, this.terminalID);
        }
    }
}

