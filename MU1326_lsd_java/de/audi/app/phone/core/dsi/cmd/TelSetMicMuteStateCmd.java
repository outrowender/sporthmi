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

public class TelSetMicMuteStateCmd
extends AbstractTelDSIMECommand {
    private final int telMICMuteState;

    public TelSetMicMuteStateCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetMicMuteStateCmd", n2, iTelDSIResponseListener);
        this.telMICMuteState = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetMicMuteStateCmd.schedule(commandListManager, this, "TelSetMicMuteStateCmd", new Command(this.logger, "TelSetMicMuteStateCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetMicMuteStateCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetMicMuteStateCmd.this.listener != null) {
                    TelSetMicMuteStateCmd.this.listener.responseSetMICMuteState(65537, TelSetMicMuteStateCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelSetMicMuteStateCmd#execute] telMICMuteState=%1", (long)this.telMICMuteState);
            this.dsi.requestSetMICMuteState(this.telMICMuteState);
        } else {
            this.logger.log(100000, "[TelSetMicMuteStateCmd#execute] dsi is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetMICMuteState(int n) {
        this.logger.log(1000000, "[TelSetMicMuteStateCmd#responseSetMICMuteState] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetMICMuteState(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

