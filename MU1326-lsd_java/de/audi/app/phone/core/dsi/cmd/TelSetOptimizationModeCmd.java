/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetOptimizationModeCmd$1;
import de.audi.atip.log.LogChannel;
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
        TelSetOptimizationModeCmd.schedule(commandListManager, this, "TelSetOptimizationModeCmd", new TelSetOptimizationModeCmd$1(this, this.logger, "TelSetOptimizationModeCmdError"), monitor);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelSetOptimizationModeCmd#execute] optMode=%1", (long)this.optMode);
            this.dsi.requestSetOptimizationMode(this.optMode);
        } else {
            this.logger.log(-1601830656, "[TelSetOptimizationModeCmd#execute] dsi is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetOptimizationMode(int n, int n2) {
        this.logger.log(1078071040, "[TelSetOptimizationModeCmd#responseSetOptimizationMode] optMode=%1, result=%2", (long)n, (long)n2);
        if (this.listener != null) {
            this.listener.responseSetOptimizationMode(n, n2, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

