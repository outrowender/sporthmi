/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetESIMActiveCmd$1;
import de.audi.app.phone.core.epm.ITelEPMHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSetESIMActiveCmd
extends AbstractTelDSIMECommand {
    private final boolean active;

    public TelSetESIMActiveCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelEPMHandler iTelEPMHandler) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetESIMActiveCmd", n, iTelDSIResponseListener);
        this.active = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetESIMActiveCmd.schedule(commandListManager, this, "TelSetESIMActiveCmd", new TelSetESIMActiveCmd$1(this, this.logger, "TelSetESIMActiveCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSetESIMActiveCmd#execute] active=%1", this.active);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetESIMActive(this.active);
        } else {
            this.logger.log(-1601830656, "[TelSetESIMActiveCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetESIMActive(int n) {
        this.logger.log(1078071040, "[TelSetESIMActiveCmd#responseSetESIMActive] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetESIMActive(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

