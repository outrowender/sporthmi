/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelCallWaitingCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelCallWaitingCmd$1
extends Command {
    private final /* synthetic */ TelCallWaitingCmd this$0;

    TelCallWaitingCmd$1(TelCallWaitingCmd telCallWaitingCmd, LogChannel logChannel, String string) {
        this.this$0 = telCallWaitingCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        if (!TelCallWaitingCmd.access$000(this.this$0)) {
            this.logger.log(-1601830656, "[TelCallWaitingCmd.schedule().new Command() {...}#execute] Error.");
            if (this.this$0.listener != null) {
                this.this$0.listener.responseCallWaiting(TelCallWaitingCmd.access$100(this.this$0), -1, 0x1000100, this.this$0.terminalID);
            }
        }
        this.getCommandList().commandFinished();
    }
}

