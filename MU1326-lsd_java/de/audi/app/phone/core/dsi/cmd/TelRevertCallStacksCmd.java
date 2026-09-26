/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelRevertCallStacksCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelRevertCallStacksCmd
extends AbstractTelDSIMECommand {
    private final boolean isReverted;

    public TelRevertCallStacksCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelRevertCallStacksCmd", n, iTelDSIResponseListener);
        this.isReverted = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelRevertCallStacksCmd.schedule(commandListManager, this, "TelRevertCallStacksCmd", new TelRevertCallStacksCmd$1(this, this.logger, "TelRevertCallStacksCmdError"), monitor);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelRevertCallStacksCmd#execute] isReverted=%1", this.isReverted);
            this.dsi.revertCallstacks(this.isReverted);
        } else {
            this.logger.log(-1601830656, "[TelRevertCallStacksCmd#execute] dsi is null --> NOP!");
        }
        this.getCommandList().commandFinished();
    }
}

