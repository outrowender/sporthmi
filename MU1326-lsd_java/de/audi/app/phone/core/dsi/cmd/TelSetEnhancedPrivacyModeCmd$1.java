/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetEnhancedPrivacyModeCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetEnhancedPrivacyModeCmd$1
extends Command {
    private final /* synthetic */ TelSetEnhancedPrivacyModeCmd this$0;

    TelSetEnhancedPrivacyModeCmd$1(TelSetEnhancedPrivacyModeCmd telSetEnhancedPrivacyModeCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetEnhancedPrivacyModeCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetEnhancedPrivacyModeCmd.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

