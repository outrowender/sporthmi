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

public class TelHangupCmd
extends AbstractTelDSIMECommand {
    private final int callID;

    public TelHangupCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelHangupCmd", n2, iTelDSIResponseListener);
        this.callID = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelHangupCmd.schedule(commandListManager, this, "TelHangupCmd", new Command(this.logger, "TelHangupCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelHangupCmd.schedule().new Command() {...}#execute] Error.");
                if (TelHangupCmd.this.listener != null) {
                    TelHangupCmd.this.listener.responseHangupCall(65537, TelHangupCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelHangupCmd#execute] hanging up call with id %1", (long)this.callID);
        if (this.isDSIAvailable()) {
            this.dsi.hangupCall(this.callID);
        } else {
            this.logger.log(100000, "[TelHangupCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseHangupCall(int n) {
        this.logger.log(1000000, "[TelHangupCmd#responseHangupCall] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseHangupCall(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

