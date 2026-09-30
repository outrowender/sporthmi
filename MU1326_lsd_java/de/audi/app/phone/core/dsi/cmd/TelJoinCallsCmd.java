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

public class TelJoinCallsCmd
extends AbstractTelDSIMECommand {
    public TelJoinCallsCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelJoinCallsCmd", n, iTelDSIResponseListener);
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelJoinCallsCmd.schedule(commandListManager, this, "TelJoinCallsCmd", new Command(this.logger, "TelJoinCallsCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelJoinCallsCmd.schedule().new Command() {...}#execute] Error.");
                if (TelJoinCallsCmd.this.listener != null) {
                    TelJoinCallsCmd.this.listener.responseJoinCalls(65537, TelJoinCallsCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelJoinCallsCmd#execute]");
        if (this.isDSIAvailable()) {
            this.dsi.joinCalls();
        } else {
            this.logger.log(100000, "[TelJoinCallsCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseJoinCalls(int n) {
        this.logger.log(1000000, "[TelJoinCallsCmd#responseJoinCalls] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseJoinCalls(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

