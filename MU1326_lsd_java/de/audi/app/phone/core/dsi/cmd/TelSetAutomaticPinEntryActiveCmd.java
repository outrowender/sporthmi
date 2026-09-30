/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
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
        TelSetAutomaticPinEntryActiveCmd.schedule(commandListManager, this, "TelSetAutomaticPinEntryActiveCmd", new Command(this.logger, "TelSetAutomaticPinEntryActiveCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetAutomaticPinEntryActiveCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetAutomaticPinEntryActiveCmd.this.listener != null) {
                    TelSetAutomaticPinEntryActiveCmd.this.listener.responseSetAutomaticEmergencyCallActive(65537, TelSetAutomaticPinEntryActiveCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetAutomaticPinEntryActiveCmd#execute] automaticPinEntryActive=%1", this.automaticPinEntryActive);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetAutomaticPinEntryActive(this.automaticPinEntryActive);
        } else {
            this.logger.log(100000, "[TelSetAutomaticPinEntryActiveCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetAutomaticPinEntryActive(int n) {
        this.logger.log(1000000, "[TelSetAutomaticPinEntryActiveCmd#responseSetAutomaticPinEntryActive] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetAutomaticPinEntryActive(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

