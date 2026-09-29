/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetAutomaticPinEntryActiveCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSetAutomaticPinEntryActiveCmd
extends AbstractTelDSIMECommand {
    private final boolean automaticPinEntryActive;

    public TelSetAutomaticPinEntryActiveCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetAutomaticPinEntryActiveCmd", n, iTelDSIResponseListener);
        this.automaticPinEntryActive = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetAutomaticPinEntryActiveCmd.schedule(commandListManager, this, "TelSetAutomaticPinEntryActiveCmd", new TelSetAutomaticPinEntryActiveCmd$1(this, this.logger, "TelSetAutomaticPinEntryActiveCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSetAutomaticPinEntryActiveCmd#execute] automaticPinEntryActive=%1", this.automaticPinEntryActive);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetAutomaticPinEntryActive(this.automaticPinEntryActive);
        } else {
            this.logger.log(-1601830656, "[TelSetAutomaticPinEntryActiveCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n) {
        this.logger.log(1078071040, "[TelSetAutomaticPinEntryActiveCmd#responseSetAutomaticPinEntryActive] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetAutomaticPinEntryActive(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

