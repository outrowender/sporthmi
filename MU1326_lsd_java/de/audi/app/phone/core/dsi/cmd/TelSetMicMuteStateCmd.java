/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetMicMuteStateCmd$1;
import de.audi.atip.log.LogChannel;
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
        TelSetMicMuteStateCmd.schedule(commandListManager, this, "TelSetMicMuteStateCmd", new TelSetMicMuteStateCmd$1(this, this.logger, "TelSetMicMuteStateCmdError"), monitor);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelSetMicMuteStateCmd#execute] telMICMuteState=%1", (long)this.telMICMuteState);
            this.dsi.requestSetMICMuteState(this.telMICMuteState);
        } else {
            this.logger.log(-1601830656, "[TelSetMicMuteStateCmd#execute] dsi is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetMICMuteState(int n) {
        this.logger.log(1078071040, "[TelSetMicMuteStateCmd#responseSetMICMuteState] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetMICMuteState(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

