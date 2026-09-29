/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelJoinCallsCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelJoinCallsCmd$1
extends Command {
    private final /* synthetic */ TelJoinCallsCmd this$0;

    TelJoinCallsCmd$1(TelJoinCallsCmd telJoinCallsCmd, LogChannel logChannel, String string) {
        this.this$0 = telJoinCallsCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelJoinCallsCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseJoinCalls(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

