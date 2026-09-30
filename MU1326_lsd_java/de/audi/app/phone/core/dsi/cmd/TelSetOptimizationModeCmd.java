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

public class TelSetOptimizationModeCmd
extends AbstractTelDSIMECommand {
    private final int optMode;

    public TelSetOptimizationModeCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetOptimizationModeCmd", n2, iTelDSIResponseListener);
        this.optMode = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetOptimizationModeCmd.schedule(commandListManager, this, "TelSetOptimizationModeCmd", new Command(this.logger, "TelSetOptimizationModeCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetOptimizationModeCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetOptimizationModeCmd.this.listener != null) {
                    TelSetOptimizationModeCmd.this.listener.responseSetOptimizationMode(-1, 65537, TelSetOptimizationModeCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelSetOptimizationModeCmd#execute] optMode=%1", (long)this.optMode);
            this.dsi.requestSetOptimizationMode(this.optMode);
        } else {
            this.logger.log(100000, "[TelSetOptimizationModeCmd#execute] dsi is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetOptimizationMode(int n, int n2) {
        this.logger.log(1000000, "[TelSetOptimizationModeCmd#responseSetOptimizationMode] optMode=%1, result=%2", (long)n, (long)n2);
        if (this.listener != null) {
            this.listener.responseSetOptimizationMode(n, n2, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

