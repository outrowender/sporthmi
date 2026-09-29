/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelChangeSIMCodeCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelChangeSIMCodeCmd$1
extends Command {
    private final /* synthetic */ TelChangeSIMCodeCmd this$0;

    TelChangeSIMCodeCmd$1(TelChangeSIMCodeCmd telChangeSIMCodeCmd, LogChannel logChannel, String string) {
        this.this$0 = telChangeSIMCodeCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelChangeSIMCodeCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseChangeSIMCode(-1, 0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

