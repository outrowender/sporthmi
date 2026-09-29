/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSwapCallsCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSwapCallsCmd
extends AbstractTelDSIMECommand {
    public TelSwapCallsCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSwapCallsCmd", n, iTelDSIResponseListener);
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSwapCallsCmd.schedule(commandListManager, this, "TelSwapCallsCmd", new TelSwapCallsCmd$1(this, this.logger, "TelSwapCallsCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSwapCallsCmd#execute] called.");
        if (this.isDSIAvailable()) {
            this.dsi.swapCalls();
        } else {
            this.logger.log(-1601830656, "[TelSwapCallsCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSwapCalls(int n) {
        this.logger.log(1078071040, "[TelSwapCallsCmd#responseSwapCalls] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSwapCalls(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

