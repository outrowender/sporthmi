/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetESIMActiveCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetESIMActiveCmd$1
extends Command {
    private final /* synthetic */ TelSetESIMActiveCmd this$0;

    TelSetESIMActiveCmd$1(TelSetESIMActiveCmd telSetESIMActiveCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetESIMActiveCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetESIMActiveCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetESIMActive(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

