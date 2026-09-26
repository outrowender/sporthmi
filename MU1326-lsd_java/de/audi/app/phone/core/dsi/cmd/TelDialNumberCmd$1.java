/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelDialNumberCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelDialNumberCmd$1
extends Command {
    private final /* synthetic */ TelDialNumberCmd this$0;

    TelDialNumberCmd$1(TelDialNumberCmd telDialNumberCmd, LogChannel logChannel, String string) {
        this.this$0 = telDialNumberCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelDialNumberCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseDialNumber(0x1000100, -1, null, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

