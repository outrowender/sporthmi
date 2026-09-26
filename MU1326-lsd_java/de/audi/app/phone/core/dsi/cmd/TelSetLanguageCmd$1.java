/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetLanguageCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetLanguageCmd$1
extends Command {
    private final /* synthetic */ TelSetLanguageCmd this$0;

    TelSetLanguageCmd$1(TelSetLanguageCmd telSetLanguageCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetLanguageCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetLanguageCmd.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

