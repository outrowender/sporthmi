/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSendDTMFCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSendDTMFCmd$1
extends Command {
    private final /* synthetic */ TelSendDTMFCmd this$0;

    TelSendDTMFCmd$1(TelSendDTMFCmd telSendDTMFCmd, LogChannel logChannel, String string) {
        this.this$0 = telSendDTMFCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSendDTMFCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSendDTMF(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

