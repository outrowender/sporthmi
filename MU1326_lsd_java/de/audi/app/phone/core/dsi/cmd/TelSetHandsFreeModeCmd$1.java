/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetHandsFreeModeCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetHandsFreeModeCmd$1
extends Command {
    private final /* synthetic */ TelSetHandsFreeModeCmd this$0;

    TelSetHandsFreeModeCmd$1(TelSetHandsFreeModeCmd telSetHandsFreeModeCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetHandsFreeModeCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetHandsFreeModeCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetHandsFreeMode(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

