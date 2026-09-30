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

public class TelSetAutomaticEmergencyCallActiveCmd
extends AbstractTelDSIMECommand {
    final boolean automaticEmergencyCallActive;

    public TelSetAutomaticEmergencyCallActiveCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetAutomaticEmergencyCallActiveCmd", n, iTelDSIResponseListener);
        this.automaticEmergencyCallActive = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetAutomaticEmergencyCallActiveCmd.schedule(commandListManager, this, "TelSetAutomaticEmergencyCallActiveCmd", new Command(this.logger, "TelSetAutomaticEmergencyCallActiveCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetAutomaticEmergencyCallActiveCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetAutomaticEmergencyCallActiveCmd.this.listener != null) {
                    TelSetAutomaticEmergencyCallActiveCmd.this.listener.responseSetAutomaticEmergencyCallActive(65537, TelSetAutomaticEmergencyCallActiveCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetAutomaticEmergencyCallActiveCmd#execute] automaticEmergencyCallActive=%1", this.automaticEmergencyCallActive);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetAutomaticEmergencyCallActive(this.automaticEmergencyCallActive);
        } else {
            this.logger.log(100000, "[TelSetAutomaticEmergencyCallActiveCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetAutomaticEmergencyCallActive(int n) {
        this.logger.log(1000000, "[TelSetAutomaticEmergencyCallActiveCmd#responseSetAutomaticEmergencyCallActive] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetAutomaticEmergencyCallActive(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

