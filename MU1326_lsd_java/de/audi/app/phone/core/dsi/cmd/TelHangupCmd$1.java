/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelHangupCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelHangupCmd$1
extends Command {
    private final /* synthetic */ TelHangupCmd this$0;

    TelHangupCmd$1(TelHangupCmd telHangupCmd, LogChannel logChannel, String string) {
        this.this$0 = telHangupCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelHangupCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseHangupCall(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

