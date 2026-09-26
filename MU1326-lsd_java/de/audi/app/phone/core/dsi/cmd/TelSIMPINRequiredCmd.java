/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSIMPINRequiredCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSIMPINRequiredCmd
extends AbstractTelDSIMECommand {
    private final String telCurrentCode;
    private final boolean simPINrequired;

    public TelSIMPINRequiredCmd(String string, boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSIMPINRequiredCmd", n, iTelDSIResponseListener);
        this.telCurrentCode = string;
        this.simPINrequired = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSIMPINRequiredCmd.schedule(commandListManager, this, "TelSIMPINRequiredCmd", new TelSIMPINRequiredCmd$1(this, this.logger, "TelSIMPINRequiredCmdError"), monitor);
    }

    @Override
    public void execute() {
        if (this.logger.isInfo()) {
            this.logger.log(1078071040, "[TelSIMPINRequiredCmd#execute] telCurrentCode=%1, simPINrequired=%2", (Object)String.valueOf(this.telCurrentCode), (Object)String.valueOf(this.simPINrequired));
        }
        if (this.isDSIAvailable()) {
            this.dsi.requestSIMPINRequired(this.telCurrentCode, this.simPINrequired);
        } else {
            this.logger.log(-1601830656, "[TelSIMPINRequiredCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSIMPINRequired(int n) {
        this.logger.log(1078071040, "[TelSIMPINRequiredCmd#responseSIMPINRequired] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSIMPINRequired(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

