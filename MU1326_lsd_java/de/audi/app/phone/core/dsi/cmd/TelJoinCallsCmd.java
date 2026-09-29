/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelJoinCallsCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelJoinCallsCmd
extends AbstractTelDSIMECommand {
    public TelJoinCallsCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelJoinCallsCmd", n, iTelDSIResponseListener);
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelJoinCallsCmd.schedule(commandListManager, this, "TelJoinCallsCmd", new TelJoinCallsCmd$1(this, this.logger, "TelJoinCallsCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelJoinCallsCmd#execute]");
        if (this.isDSIAvailable()) {
            this.dsi.joinCalls();
        } else {
            this.logger.log(-1601830656, "[TelJoinCallsCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseJoinCalls(int n) {
        this.logger.log(1078071040, "[TelJoinCallsCmd#responseJoinCalls] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseJoinCalls(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

