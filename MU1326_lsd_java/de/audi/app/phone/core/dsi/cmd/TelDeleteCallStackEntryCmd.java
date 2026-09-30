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
        TelDeleteCallStackEntryCmd.schedule(commandListManager, this, "TelDeleteCallStackEntryCmd", new Command(this.logger, "TelDeleteCallStackEntryCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelDeleteCallStackEntryCmd.schedule().new Command() {...}#execute] Error.");
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelDeleteCallStackEntryCmd#execute] callList=%1, clEntryID=%2", (long)this.callList, (long)this.clEntryID);
            this.dsi.deleteCallstacksEntry(this.callList, this.clEntryID);
        } else {
            this.logger.log(100000, "[TelDeleteCallStackEntryCmd#execute] dsi is null --> NOP!");
        }
        this.getCommandList().commandFinished();
    }
}

