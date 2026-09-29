/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetMicGainLevelCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetMicGainLevelCmd$1
extends Command {
    private final /* synthetic */ TelSetMicGainLevelCmd this$0;

    TelSetMicGainLevelCmd$1(TelSetMicGainLevelCmd telSetMicGainLevelCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetMicGainLevelCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetMicGainLevelCmd.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

