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

public class TelSetMailboxNumberCmd
extends AbstractTelDSIMECommand {
    private final String mailboxNumber;

    public TelSetMailboxNumberCmd(String string, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetMailboxNumberCmd", n, iTelDSIResponseListener);
        this.mailboxNumber = string;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetMailboxNumberCmd.schedule(commandListManager, this, "TelSetMailboxNumberCmd", new Command(this.logger, "TelSetMailboxNumberCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetMailboxNumberCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetMailboxNumberCmd.this.listener != null) {
                    TelSetMailboxNumberCmd.this.listener.responseSetMailboxContent(65537, TelSetMailboxNumberCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.dsi.requestSetMailboxContent(this.mailboxNumber);
        } else {
            this.logger.log(100000, "[TelSetMailboxNumberCmd#execute] dsi is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetMailboxContent(int n) {
        this.logger.log(1000000, "[TelSetMailboxNumberCmd#responseSetMailboxContent] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetMailboxContent(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

