/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetPhoneRingtoneCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetPhoneRingtoneCmd$1
extends Command {
    private final /* synthetic */ TelSetPhoneRingtoneCmd this$0;

    TelSetPhoneRingtoneCmd$1(TelSetPhoneRingtoneCmd telSetPhoneRingtoneCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetPhoneRingtoneCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetPhoneRingtoneCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetPhoneRingtone(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

