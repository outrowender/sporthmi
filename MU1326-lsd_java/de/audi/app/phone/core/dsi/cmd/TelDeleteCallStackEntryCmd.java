/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelDeleteCallStackEntryCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelDeleteCallStackEntryCmd
extends AbstractTelDSIMECommand {
    private final int callList;
    private final int clEntryID;

    public TelDeleteCallStackEntryCmd(int n, int n2, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n3, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelDeleteCallStackEntryCmd", n3, iTelDSIResponseListener);
        this.callList = n;
        this.clEntryID = n2;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelDeleteCallStackEntryCmd.schedule(commandListManager, this, "TelDeleteCallStackEntryCmd", new TelDeleteCallStackEntryCmd$1(this, this.logger, "TelDeleteCallStackEntryCmdError"), monitor);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelDeleteCallStackEntryCmd#execute] callList=%1, clEntryID=%2", (long)this.callList, (long)this.clEntryID);
            this.dsi.deleteCallstacksEntry(this.callList, this.clEntryID);
        } else {
            this.logger.log(-1601830656, "[TelDeleteCallStackEntryCmd#execute] dsi is null --> NOP!");
        }
        this.getCommandList().commandFinished();
    }
}

