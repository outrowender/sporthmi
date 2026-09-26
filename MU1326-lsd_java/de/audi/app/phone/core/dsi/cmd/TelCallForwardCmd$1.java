/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelCallForwardCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelCallForwardCmd$1
extends Command {
    private final /* synthetic */ TelCallForwardCmd this$0;

    TelCallForwardCmd$1(TelCallForwardCmd telCallForwardCmd, LogChannel logChannel, String string) {
        this.this$0 = telCallForwardCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        if (!TelCallForwardCmd.access$000(this.this$0)) {
            this.logger.log(-1601830656, "[TelCallForwardCmd.schedule().new Command() {...}#execute] Error.");
            if (this.this$0.listener != null) {
                this.this$0.listener.responseCallForward(null, 0x1000100, this.this$0.terminalID);
            }
        }
        this.getCommandList().commandFinished();
    }
}

