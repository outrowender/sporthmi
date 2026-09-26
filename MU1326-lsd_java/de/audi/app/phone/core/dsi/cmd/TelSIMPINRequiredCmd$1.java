/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSIMPINRequiredCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSIMPINRequiredCmd$1
extends Command {
    private final /* synthetic */ TelSIMPINRequiredCmd this$0;

    TelSIMPINRequiredCmd$1(TelSIMPINRequiredCmd telSIMPINRequiredCmd, LogChannel logChannel, String string) {
        this.this$0 = telSIMPINRequiredCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSIMPINRequiredCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSIMPINRequired(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

