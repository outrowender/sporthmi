/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetMailboxNumberCmd$1;
import de.audi.atip.log.LogChannel;
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
        TelSetMailboxNumberCmd.schedule(commandListManager, this, "TelSetMailboxNumberCmd", new TelSetMailboxNumberCmd$1(this, this.logger, "TelSetMailboxNumberCmdError"), monitor);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.dsi.requestSetMailboxContent(this.mailboxNumber);
        } else {
            this.logger.log(-1601830656, "[TelSetMailboxNumberCmd#execute] dsi is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetMailboxContent(int n) {
        this.logger.log(1078071040, "[TelSetMailboxNumberCmd#responseSetMailboxContent] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetMailboxContent(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

