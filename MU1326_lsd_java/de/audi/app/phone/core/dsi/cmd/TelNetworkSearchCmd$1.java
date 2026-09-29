/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelNetworkSearchCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelNetworkSearchCmd$1
extends Command {
    private final /* synthetic */ TelNetworkSearchCmd this$0;

    TelNetworkSearchCmd$1(TelNetworkSearchCmd telNetworkSearchCmd, LogChannel logChannel, String string) {
        this.this$0 = telNetworkSearchCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        if (!TelNetworkSearchCmd.access$000(this.this$0)) {
            this.logger.log(-1601830656, "[TelNetworkSearchCmdCmd.schedule().new Command() {...}#execute] Error.");
            if (this.this$0.listener != null) {
                this.this$0.listener.responseNetworkSearch(null, 0x1000100, this.this$0.terminalID);
            }
        }
        this.getCommandList().commandFinished();
    }
}

