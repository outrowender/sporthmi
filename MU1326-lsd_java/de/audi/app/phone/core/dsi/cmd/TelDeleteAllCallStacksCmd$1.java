/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelDeleteAllCallStacksCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelDeleteAllCallStacksCmd$1
extends Command {
    private final /* synthetic */ TelDeleteAllCallStacksCmd this$0;

    TelDeleteAllCallStacksCmd$1(TelDeleteAllCallStacksCmd telDeleteAllCallStacksCmd, LogChannel logChannel, String string) {
        this.this$0 = telDeleteAllCallStacksCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelDeleteAllCallStacksCmd.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

