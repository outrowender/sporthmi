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

public class TelRevertCallStacksCmd
extends AbstractTelDSIMECommand {
    private final boolean isReverted;

    public TelRevertCallStacksCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelRevertCallStacksCmd", n, iTelDSIResponseListener);
        this.isReverted = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelRevertCallStacksCmd.schedule(commandListManager, this, "TelRevertCallStacksCmd", new Command(this.logger, "TelRevertCallStacksCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelRevertCallStacksCmd.schedule().new Command() {...}#execute] Error.");
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelRevertCallStacksCmd#execute] isReverted=%1", this.isReverted);
            this.dsi.revertCallstacks(this.isReverted);
        } else {
            this.logger.log(100000, "[TelRevertCallStacksCmd#execute] dsi is null --> NOP!");
        }
        this.getCommandList().commandFinished();
    }
}

