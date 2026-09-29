/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelIncreaseMicGainLevelCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelIncreaseMicGainLevelCmd$1
extends Command {
    private final /* synthetic */ TelIncreaseMicGainLevelCmd this$0;

    TelIncreaseMicGainLevelCmd$1(TelIncreaseMicGainLevelCmd telIncreaseMicGainLevelCmd, LogChannel logChannel, String string) {
        this.this$0 = telIncreaseMicGainLevelCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelIncreaseMicGainLevelCmd.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

