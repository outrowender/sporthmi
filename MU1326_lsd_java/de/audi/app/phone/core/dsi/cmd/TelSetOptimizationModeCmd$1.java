/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetOptimizationModeCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetOptimizationModeCmd$1
extends Command {
    private final /* synthetic */ TelSetOptimizationModeCmd this$0;

    TelSetOptimizationModeCmd$1(TelSetOptimizationModeCmd telSetOptimizationModeCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetOptimizationModeCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetOptimizationModeCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetOptimizationMode(-1, 0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

