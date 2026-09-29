/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelAcceptCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelAcceptCmd
extends AbstractTelDSIMECommand {
    private final int acceptMode;

    public TelAcceptCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelAcceptCmd", n2, iTelDSIResponseListener);
        this.acceptMode = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelAcceptCmd.schedule(commandListManager, this, "TelAcceptCmd", new TelAcceptCmd$1(this, this.logger, "TelAcceptCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelAcceptCmd#execute] accepting call with mode %1", (long)this.acceptMode);
        if (this.isDSIAvailable()) {
            this.dsi.acceptCall(this.acceptMode);
        } else {
            this.logger.log(-1601830656, "[TelAcceptCmd#execute] dsi is null!!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseAcceptCall(int n) {
        this.logger.log(1078071040, "[TelAcceptCmd#responseAcceptCall] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseAcceptCall(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

