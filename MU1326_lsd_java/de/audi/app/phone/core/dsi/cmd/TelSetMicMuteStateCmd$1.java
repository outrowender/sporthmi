/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetMicMuteStateCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetMicMuteStateCmd$1
extends Command {
    private final /* synthetic */ TelSetMicMuteStateCmd this$0;

    TelSetMicMuteStateCmd$1(TelSetMicMuteStateCmd telSetMicMuteStateCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetMicMuteStateCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetMicMuteStateCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetMICMuteState(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

