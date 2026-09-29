/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetAutomaticRedialActiveCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetAutomaticRedialActiveCmd$1
extends Command {
    private final /* synthetic */ TelSetAutomaticRedialActiveCmd this$0;

    TelSetAutomaticRedialActiveCmd$1(TelSetAutomaticRedialActiveCmd telSetAutomaticRedialActiveCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetAutomaticRedialActiveCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetAutomaticRedialActiveCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetAutomaticRedialActive(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

