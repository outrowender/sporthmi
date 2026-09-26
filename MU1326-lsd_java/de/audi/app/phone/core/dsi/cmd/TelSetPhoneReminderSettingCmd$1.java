/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetPhoneReminderSettingCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetPhoneReminderSettingCmd$1
extends Command {
    private final /* synthetic */ TelSetPhoneReminderSettingCmd this$0;

    TelSetPhoneReminderSettingCmd$1(TelSetPhoneReminderSettingCmd telSetPhoneReminderSettingCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetPhoneReminderSettingCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetPhoneReminderSettingCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetPhoneReminderSetting(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

