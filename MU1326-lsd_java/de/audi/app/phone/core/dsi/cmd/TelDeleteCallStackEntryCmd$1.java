/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelDeleteCallStackEntryCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelDeleteCallStackEntryCmd$1
extends Command {
    private final /* synthetic */ TelDeleteCallStackEntryCmd this$0;

    TelDeleteCallStackEntryCmd$1(TelDeleteCallStackEntryCmd telDeleteCallStackEntryCmd, LogChannel logChannel, String string) {
        this.this$0 = telDeleteCallStackEntryCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelDeleteCallStackEntryCmd.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

