/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelRestoreFactorySettingsCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelRestoreFactorySettingsCmd$1
extends Command {
    private final /* synthetic */ TelRestoreFactorySettingsCmd this$0;

    TelRestoreFactorySettingsCmd$1(TelRestoreFactorySettingsCmd telRestoreFactorySettingsCmd, LogChannel logChannel, String string) {
        this.this$0 = telRestoreFactorySettingsCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelRestoreFactorySettingsCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseRestoreFactorySettings(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

