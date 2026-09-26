/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetMailboxNumberCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetMailboxNumberCmd$1
extends Command {
    private final /* synthetic */ TelSetMailboxNumberCmd this$0;

    TelSetMailboxNumberCmd$1(TelSetMailboxNumberCmd telSetMailboxNumberCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetMailboxNumberCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetMailboxNumberCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetMailboxContent(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

