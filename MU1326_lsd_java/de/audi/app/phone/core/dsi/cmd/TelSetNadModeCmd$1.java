/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetNadModeCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetNadModeCmd$1
extends Command {
    private final /* synthetic */ TelSetNadModeCmd this$0;

    TelSetNadModeCmd$1(TelSetNadModeCmd telSetNadModeCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetNadModeCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetNadModeCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetNADMode(-1, 0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

