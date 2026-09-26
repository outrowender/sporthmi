/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetPrivacyModeCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetPrivacyModeCmd$1
extends Command {
    private final /* synthetic */ TelSetPrivacyModeCmd this$0;

    TelSetPrivacyModeCmd$1(TelSetPrivacyModeCmd telSetPrivacyModeCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetPrivacyModeCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetPrivacyModeCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetPrivacyMode(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

