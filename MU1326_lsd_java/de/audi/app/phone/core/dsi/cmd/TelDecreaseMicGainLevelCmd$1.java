/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelDecreaseMicGainLevelCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelDecreaseMicGainLevelCmd$1
extends Command {
    private final /* synthetic */ TelDecreaseMicGainLevelCmd this$0;

    TelDecreaseMicGainLevelCmd$1(TelDecreaseMicGainLevelCmd telDecreaseMicGainLevelCmd, LogChannel logChannel, String string) {
        this.this$0 = telDecreaseMicGainLevelCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelDecreaseMicGainLevelCmd.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

