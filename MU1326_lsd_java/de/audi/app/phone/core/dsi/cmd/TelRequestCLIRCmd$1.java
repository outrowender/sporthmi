/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelRequestCLIRCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelRequestCLIRCmd$1
extends Command {
    private final /* synthetic */ TelRequestCLIRCmd this$0;

    TelRequestCLIRCmd$1(TelRequestCLIRCmd telRequestCLIRCmd, LogChannel logChannel, String string) {
        this.this$0 = telRequestCLIRCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        if (!TelRequestCLIRCmd.access$000(this.this$0)) {
            this.logger.log(-1601830656, "[TelRequestCLIRCmd.schedule().new Command() {...}#execute] Error.");
            if (this.this$0.listener != null) {
                this.this$0.listener.responseCLIR(-1, -1, 0x1000100, this.this$0.terminalID);
            }
        }
        this.getCommandList().commandFinished();
    }
}

