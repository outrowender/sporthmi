/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSplitCallCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSplitCallCmd
extends AbstractTelDSIMECommand {
    private final short telCallID;

    public TelSplitCallCmd(short s, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSplitCallCmd", n, iTelDSIResponseListener);
        this.telCallID = s;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSplitCallCmd.schedule(commandListManager, this, "TelSplitCallCmd", new TelSplitCallCmd$1(this, this.logger, "TelSplitCallCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSplitCallCmd#execute] telCallID=%1", (long)this.telCallID);
        if (this.isDSIAvailable()) {
            this.dsi.splitCall(this.telCallID);
        } else {
            this.logger.log(-1601830656, "[TelSplitCallCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSplitCall(int n) {
        this.logger.log(1078071040, "[TelSplitCallCmd#responseSplitCall] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSplitCall(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

