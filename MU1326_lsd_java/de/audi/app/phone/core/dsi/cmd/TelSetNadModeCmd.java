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

public class TelSetNadModeCmd
extends AbstractTelDSIMECommand {
    private final int nadMode;

    public TelSetNadModeCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetNadModeCmd", n2, iTelDSIResponseListener);
        this.nadMode = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetNadModeCmd.schedule(commandListManager, this, "TelSetNadModeCmd", new Command(this.logger, "TelSetNadModeCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetNadModeCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetNadModeCmd.this.listener != null) {
                    TelSetNadModeCmd.this.listener.responseSetNADMode(-1, 65537, TelSetNadModeCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetNadModeCmd#execute] nadMode=%1", (long)this.nadMode);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetNADMode(this.nadMode);
        } else {
            this.logger.log(100000, "[TelSetNadModeCmd#execute] dsi is null!!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetNADMode(int n, int n2) {
        this.logger.log(1000000, "[TelSetNadModeCmd#responseSetNADMode] nadMode=%1, result=%2", (long)n, (long)n2);
        if (this.listener != null) {
            this.listener.responseSetNADMode(n, n2, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

