/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetHandsFreeModeCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSetHandsFreeModeCmd
extends AbstractTelDSIMECommand {
    private final int telHFMode;

    public TelSetHandsFreeModeCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetHandsFreeModeCmd", n2, iTelDSIResponseListener);
        this.telHFMode = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetHandsFreeModeCmd.schedule(commandListManager, this, "TelSetHandsFreeModeCmd", new TelSetHandsFreeModeCmd$1(this, this.logger, "TelSetHandsFreeModeCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSetHandsFreeModeCmd#execute] telHFMode=%1", (long)this.telHFMode);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetHandsFreeMode(this.telHFMode);
        } else {
            this.logger.log(-1601830656, "[TelSetHandsFreeModeCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetHandsFreeMode(int n) {
        this.logger.log(1078071040, "[TelSetHandsFreeModeCmd#responseSetHandsFreeMode] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetHandsFreeMode(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

