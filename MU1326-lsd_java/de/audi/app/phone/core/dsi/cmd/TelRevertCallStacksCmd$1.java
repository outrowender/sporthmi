/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelRevertCallStacksCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelRevertCallStacksCmd$1
extends Command {
    private final /* synthetic */ TelRevertCallStacksCmd this$0;

    TelRevertCallStacksCmd$1(TelRevertCallStacksCmd telRevertCallStacksCmd, LogChannel logChannel, String string) {
        this.this$0 = telRevertCallStacksCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelRevertCallStacksCmd.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

