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

public class TelSetAutomaticRedialActiveCmd
extends AbstractTelDSIMECommand {
    private final boolean automaticRedialActive;

    public TelSetAutomaticRedialActiveCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetAutomaticRedialActiveCmd", n, iTelDSIResponseListener);
        this.automaticRedialActive = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetAutomaticRedialActiveCmd.schedule(commandListManager, this, "TelSetAutomaticRedialActiveCmd", new Command(this.logger, "TelSetAutomaticRedialActiveCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetAutomaticRedialActiveCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetAutomaticRedialActiveCmd.this.listener != null) {
                    TelSetAutomaticRedialActiveCmd.this.listener.responseSetAutomaticRedialActive(65537, TelSetAutomaticRedialActiveCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetAutomaticRedialActiveCmd#execute] automaticRedialActive=%1", this.automaticRedialActive);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetAutomaticRedialActive(this.automaticRedialActive);
        } else {
            this.logger.log(100000, "[TelSetAutomaticRedialActiveCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetAutomaticRedialActive(int n) {
        this.logger.log(1000000, "[TelSetAutomaticRedialActiveCmd#responseSetAutomaticRedialActive] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetAutomaticRedialActive(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

