/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelAcceptCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelAcceptCmd$1
extends Command {
    private final /* synthetic */ TelAcceptCmd this$0;

    TelAcceptCmd$1(TelAcceptCmd telAcceptCmd, LogChannel logChannel, String string) {
        this.this$0 = telAcceptCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelAcceptCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseAcceptCall(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

