/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSwapCallsCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSwapCallsCmd$1
extends Command {
    private final /* synthetic */ TelSwapCallsCmd this$0;

    TelSwapCallsCmd$1(TelSwapCallsCmd telSwapCallsCmd, LogChannel logChannel, String string) {
        this.this$0 = telSwapCallsCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSwapCallsCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSwapCalls(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

