/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelDeleteAllCallStacksCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelDeleteAllCallStacksCmd
extends AbstractTelDSIMECommand {
    private final int callStackToDelete;

    public TelDeleteAllCallStacksCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelDeleteAllCallStacksCmd", n2, iTelDSIResponseListener);
        this.callStackToDelete = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelDeleteAllCallStacksCmd.schedule(commandListManager, this, "TelDeleteAllCallStacksCmd", new TelDeleteAllCallStacksCmd$1(this, this.logger, "TelDeleteAllCallStacksCmdError"), monitor);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelDeleteAllCallStacksCmd#execute] callStackToDelete=%1", (long)this.callStackToDelete);
            this.dsi.deleteCallstacksAll(this.callStackToDelete);
        } else {
            this.logger.log(-1601830656, "[TelDeleteCallStackEntryCmd#execute] dsi is null --> NOP!");
        }
        this.getCommandList().commandFinished();
    }
}

