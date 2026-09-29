/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelDialOperatorCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelDialOperatorCmd$1
extends Command {
    private final /* synthetic */ TelDialOperatorCmd this$0;

    TelDialOperatorCmd$1(TelDialOperatorCmd telDialOperatorCmd, LogChannel logChannel, String string) {
        this.this$0 = telDialOperatorCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelDialOperatorCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseDialOperator(0x1000100, null, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

