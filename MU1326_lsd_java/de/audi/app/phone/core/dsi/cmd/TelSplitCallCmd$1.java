/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSplitCallCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSplitCallCmd$1
extends Command {
    private final /* synthetic */ TelSplitCallCmd this$0;

    TelSplitCallCmd$1(TelSplitCallCmd telSplitCallCmd, LogChannel logChannel, String string) {
        this.this$0 = telSplitCallCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSplitCallCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSplitCall(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

